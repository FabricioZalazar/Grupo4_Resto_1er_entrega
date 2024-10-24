/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entidades.Conexion;
import Entidades.Mesero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mmaci
 */
public class MeseroData {

    private Connection con = null;

    public MeseroData() {

        con = (Connection) Conexion.getConexion();
    }
    public void borrarMozo(int idMesero) {
        String sql = "DELETE FROM mesero WHERE idMesero = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMesero);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Mozo borrado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el mozo");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al borrar el mozo");
        }
    }

    public Mesero buscarMozo(int idMesero) {
        Mesero mozo = new Mesero();

        String sql = "SELECT * FROM mesero WHERE idMesero = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idMesero);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                mozo.setIdMesero(rs.getInt("idMesero"));
                mozo.setNombre(rs.getString("Nombre"));
                // Asegúrate de que estás capturando todos los campos necesarios
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el mozo");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el mozo: " + ex.getMessage());
        }
        return mozo;
    }

    public void agregarMozo(Mesero mozo) {
        String sql = "INSERT INTO mesero (Nombre) VALUES (?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, mozo.getNombre());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                mozo.setIdMesero(rs.getInt(1)); // Asumiendo que tienes un método setIdMesero en la clase Mesero
                JOptionPane.showMessageDialog(null, "Mozo agregado correctamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error, el mozo no se agregó: " + ex.getMessage());
        }
    }
}
