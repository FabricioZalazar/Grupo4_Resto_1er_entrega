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
import org.mariadb.jdbc.Statement;

/**
 *
 * @author zalaz
 */
public class MesaData {
    
    private Connection con = null;
    
    public MesaData() {
        con = (Connection) Conexion.getConexion();
    }
    
    public void GuardarMesa(Mesa mesa) {
        
        String sql = "INSERT INTO mesa(IdMesa, Capacidad, Estado) VALUES (?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, mesa.getNum());
            ps.setInt(2, mesa.getCapacidad());
            ps.setBoolean(3, mesa.isEstado());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Mesa Guardada");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MesaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void ActualizarMesa(Mesa mesa) {
        String sql = "UPDATE mesa SET Capacidad=?,IdReserva=?,Estado=? WHERE IdMesa = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, mesa.getCapacidad());
            if (mesa.getReserva() != null) {
                ps.setInt(2, mesa.getReserva().getIdReserva());
            } else {
                ps.setObject(2, null );
            }
            ps.setBoolean(3, mesa.isEstado());
            ps.setInt(4, mesa.getNum());
            int rs = ps.executeUpdate();
            if (rs == 1) {
                JOptionPane.showMessageDialog(null, "Mesa actualizado");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MesaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Mesa BuscarMesa(int id) {
        ReservaData cone = new ReservaData();
        String query = "SELECT * FROM mesa WHERE IdMesa=?";
        Mesa mesa = new Mesa();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                mesa.setNum(id);
                mesa.setCapacidad(resultado.getInt("Capacidad"));
                if (resultado.getInt("IdReserva") > 0) {
                    mesa.setReserva(cone.buscarReserva(resultado.getInt("IdReserva")));
                } else {
                    mesa.setReserva(null);
                }
                mesa.setEstado(resultado.getBoolean("Estado"));
            } else {
                JOptionPane.showMessageDialog(null, "Mesa no encontrada");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MesaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mesa;
    }
}
