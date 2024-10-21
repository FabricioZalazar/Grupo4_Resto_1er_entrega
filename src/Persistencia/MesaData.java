/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Conexion;
import Entidades.Mesa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author zalaz
 */
public class MesaData {

    private Connection con = null;

    public MesaData() {
        con = (Connection) Conexion.getConexion();
    }

    public void GuardarAlumno(Mesa mesa) {

        String sql = "INSERT INTO mesa(Numero, Capacidad, Reserva, Estado) VALUES (?,?,?,?)";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, mesa.getNum());
            ps.setInt(2, mesa.getCapacidad());
            ps.setInt(3, mesa.getReserva().getDni());
            ps.setBoolean(4, mesa.isEstado());
            ps.executeUpdate();
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Mesa guardado");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MesaData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
