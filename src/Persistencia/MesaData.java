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
import java.util.ArrayList;
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

    public void guardarMesa(Mesa mesa) {

        String sql = "INSERT INTO mesa(Capacidad, IdReserva, Estado) VALUES (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, mesa.getCapacidad());
            if(mesa.getReserva() != null){
              ps.setInt(2, mesa.getReserva().getIdReserva());  
            }else{
                ps.setObject(2, null);
            }
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

    public void actualizarMesa(Mesa mesa) {
        String sql = "UPDATE mesa SET Capacidad=?,IdReserva=?, Estado = ? WHERE IdMesa = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, mesa.getCapacidad());
            if (mesa.getReserva() != null) {
                ps.setInt(2, mesa.getReserva().getIdReserva());
            } else {
                ps.setObject(2, null);
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

    public Mesa buscarMesa(int id) {
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
                    mesa.setReserva(cone.buscarReservaID(resultado.getInt("IdReserva")));
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

    public Mesa buscarMesaPorReserva(int id) {
        ReservaData cone = new ReservaData();
        String query = "SELECT * FROM mesa WHERE IdReserva=?";
        Mesa mesa = new Mesa();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                mesa.setNum(id);
                mesa.setCapacidad(resultado.getInt("Capacidad"));
                if (resultado.getInt("IdReserva") > 0) {
                    mesa.setReserva(cone.buscarReservaID(resultado.getInt("IdReserva")));
                } else {
                    mesa.setReserva(null);
                }
                mesa.setEstado(resultado.getBoolean("Estado"));
            } else {
                //JOptionPane.showMessageDialog(null, "Mesa no encontrada");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MesaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mesa;
    }
    public void borrarMesa(int id) {

        try {
            String sql = "DELETE FROM mesa WHERE IdMesa=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "La mesa fue eliminada exitosamente");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MesaData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void bajaLogica(int id) {
        try {
            String sql = " UPDATE mesa SET estado = 0 WHERE IdMesa = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Mesa dada de Baja");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MesaData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void altaLogica(int id) {
        try {
            String sql = " UPDATE mesa SET estado = 1 WHERE IdMesa = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Mesa dada de Alta");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MesaData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     public ArrayList <Mesa> listaMesa () {
        ReservaData cone = new ReservaData();
        ArrayList<Mesa> listaMesa = new ArrayList();
        try {
            String query = "SELECT * FROM mesa";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                Mesa mesa = new Mesa();
                mesa.setNum(resultado.getInt("IdMesa"));
                mesa.setCapacidad(resultado.getInt("Capacidad"));
                if(cone.buscarReservaID(resultado.getInt("IdReserva")).getNombre()!=null){
                   mesa.setReserva(cone.buscarReservaID(resultado.getInt("IdReserva")));     
                }else{
                    mesa.setReserva(null);
                }
                mesa.setEstado(resultado.getBoolean("Estado"));
                listaMesa.add(mesa);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al devolver la lista de mesas" + ex);
        }
        return listaMesa;
    }

    public Mesa buscarMesaXPedido(int id) {
        ReservaData cone = new ReservaData();
        String query = "SELECT mesa.IdMesa, Capacidad, IdReserva, mesa.Estado FROM mesa\n" +
                        "JOIN pedido on mesa.IdMesa = pedido.IdMesa\n" +
                        "WHERE pedido.IdPedido = ?";
        Mesa mesa = new Mesa();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                mesa.setNum(resultado.getInt("IdMesa"));
                mesa.setCapacidad(resultado.getInt("Capacidad"));
                if (resultado.getInt("IdReserva") > 0) {
                    mesa.setReserva(cone.buscarReservaID(resultado.getInt("IdReserva")));
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
    
     public ArrayList <Mesa> listaMesaDeReservas () {
        ReservaData cone = new ReservaData();
        ArrayList<Mesa> listaMesa = new ArrayList();
        try {
            String query = "SELECT * FROM mesa WHERE IdReserva IS NOT NULL";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                Mesa mesa = new Mesa();
                mesa.setNum(resultado.getInt("IdMesa"));
                mesa.setCapacidad(resultado.getInt("Capacidad"));
                if(cone.buscarReservaID(resultado.getInt("IdReserva")).getNombre()!=null){
                   mesa.setReserva(cone.buscarReservaID(resultado.getInt("IdReserva")));     
                }else{
                    mesa.setReserva(null);
                }
                mesa.setEstado(resultado.getBoolean("Estado"));
                listaMesa.add(mesa);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al devolver la lista de mesas" + ex);
        }
        return listaMesa;
    }
   
}
