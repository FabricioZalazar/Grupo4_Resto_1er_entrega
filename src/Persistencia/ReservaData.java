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
import java.util.ArrayList;
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
    // CREATE
    public void guardarReserva (Reserva reserva) {

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
    // READ
    public Reserva buscarReservaID (int id){
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
    
    public Reserva buscarReservaNombre (String nombre) {
        Reserva reserva = new Reserva();
        try {
            String query = "SELECT * FROM `reserva` WHERE Nombre = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString (1, nombre);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                reserva.setIdReserva(resultado.getInt("idReserva"));
                reserva.setNombre(nombre);
                reserva.setDni(resultado.getInt("dni"));
                reserva.setFecha(resultado.getDate("fecha").toLocalDate());
                reserva.setHora(resultado.getTime("hora").toLocalTime());
                reserva.setEstado(resultado.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "Persona de la reserva no encontrada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al devolver la reserva" + ex);
        }
        return reserva;
    }
    
    public Reserva buscarReservaDNI (int dni) {
        Reserva reserva = new Reserva();
        try {
            String query = "SELECT * FROM `reserva` WHERE Dni = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, dni);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                reserva.setIdReserva(resultado.getInt("idReserva"));
                reserva.setNombre(resultado.getString("nombre"));
                reserva.setDni(dni);
                reserva.setFecha(resultado.getDate("fecha").toLocalDate());
                reserva.setHora(resultado.getTime("hora").toLocalTime());
                reserva.setEstado(resultado.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "DNI de la persona que reservo no fue encontrado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al devolver la reserva" + ex);
        }
        return reserva;
    }
    
    public ArrayList <Reserva> listaReserva () {
        ArrayList<Reserva> listaReserva = new ArrayList();
        try {
            String query = "SELECT * FROM reserva";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                Reserva reserva = new Reserva();
                reserva.setIdReserva(resultado.getInt("idReserva"));
                reserva.setNombre(resultado.getString("nombre"));
                reserva.setDni(resultado.getInt("dni"));
                reserva.setFecha(resultado.getDate("fecha").toLocalDate());
                reserva.setHora(resultado.getTime("hora").toLocalTime());
                reserva.setEstado(resultado.getBoolean("estado"));
                listaReserva.add(reserva);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al devolver la lista de reservas" + ex);
        }
        return listaReserva;
    }
    // UPDATE
    public void actualizarReserva (Reserva reserva) {
        String query = "UPDATE reserva SET Nombre = ?, Dni = ?, Fecha = ?, Hora = ?, Estado = ? WHERE IdReserva = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            //Recibe los parametros de la clase objeto
            ps.setString(1, reserva.getNombre());
            ps.setInt(2, reserva.getDni());
            ps.setDate(3, Date.valueOf(reserva.getFecha()));
            ps.setTime(4, Time.valueOf(reserva.getHora()));
            ps.setBoolean(5, reserva.isEstado());
            //Ejecuta la consulta
            int rs = ps.executeUpdate();
            if (rs == 1) {
                JOptionPane.showMessageDialog(null, "Reserva actualizada");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la reserva: " + ex.getMessage());
        }
    }
    // DELETE
    public void borrarReserva (int id) {
        try {
            //Primero borramos las conecciones
            String query1 = "DELET FROM mesa WHERE IdReserva = ?";
            PreparedStatement ps1 = con.prepareStatement(query1);
            ps1.setInt(1, id);
            int resutado1 = ps1.executeUpdate();
            //Luego borramos en la misma tabla
            String query2 = "DELET FROM reserva WHERE IdReserva = ?";
            PreparedStatement ps2 = con.prepareStatement(query2);
            ps2.setInt(1, id);
            int resultado2 = ps2.executeUpdate();
            
            if (resultado2 == 1) {
                JOptionPane.showMessageDialog(null, "La reserva fue eliminada exitosamente");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ReservaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
