/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Conexion;
import Entidades.Reserva;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author zalaz
 */
public class ReservaData {

    private Connection con = null;

    public ReservaData() {
        con = (Connection) Conexion.getConexion();
    }

    public void guardarReserva(Reserva reserva) {

        String sql = "INSERT INTO reserva (Nombre, Dni, Fecha, Hora, Estado) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, reserva.getNombre());
            ps.setInt(2, reserva.getDni());
            ps.setDate(3, Date.valueOf(reserva.getFecha()));
            ps.setTime(4, Time.valueOf(reserva.getHora()));
            ps.setBoolean(5, reserva.isEstado());

            int rs = ps.executeUpdate();
            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Reserva  Guardada");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MesaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Reserva buscarReserva (int id){
        Reserva reserva = new Reserva();
        try {
            String query = "SELECT * FROM `reserva` WHERE idReserva = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                reserva.setIdReserva(id);
                reserva.setNombre(resultado.getString("nombre"));
                reserva.setDni(resultado.getInt("dni"));
                reserva.setFecha(resultado.getDate("fecha").toLocalDate());
                reserva.setHora(resultado.getTime("hora").toLocalTime());
                reserva.setEstado(resultado.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "Reserva no encontrada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al devolver la reserva" + ex);
        }
        return reserva;
    }
}
