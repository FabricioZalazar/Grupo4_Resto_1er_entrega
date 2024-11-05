/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Conexion;
import Entidades.Mesa;
import Entidades.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabricio Zalazar
 */
public class PedidoData {

    private Connection con = null;

    public PedidoData() {

        con = (Connection) Conexion.getConexion();
    }

    public void guardarPedido(Pedido pedido) {
        String sql = "INSERT INTO pedido(IdMesa, IdMesero, Estado, SubTotal) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getMesa().getNum());
            ps.setInt(2, pedido.getMesero().getIdMesero());
            ps.setBoolean(3, pedido.isEstado());
            ps.setDouble(4, 0);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Pedido Guardado");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarPedido(int id) {

        try {
            String sql = "DELETE FROM pedido WHERE IdPedido=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "El pedido fue eliminado exitosamente");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MesaData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void actualizarPedido(Pedido pedido) {
        String sql = "UPDATE pedido SET IdMesa=?,IdMesero=?,Estado=?,SubTotal=? WHERE IdPedido=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getMesa().getNum());
            ps.setInt(2, pedido.getMesero().getIdMesero());
            ps.setBoolean(3, pedido.isEstado());
            ps.setDouble(4, pedido.getTotal());
            ps.setInt(5, pedido.getIdPedido());
            int rs = ps.executeUpdate();
            if (rs == 1) {
                JOptionPane.showMessageDialog(null, "Pedido actualizado");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MesaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Pedido buscarPedido(int id) {
        MesaData con = new MesaData();
        MeseroData mes = new MeseroData();
        Pedido pedido = new Pedido();
        String query = "SELECT * FROM pedido WHERE IdPedido=?";
        try {
            PreparedStatement ps = this.con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                pedido.setIdPedido(resultado.getInt("IdPedido"));
                pedido.setMesa(con.buscarMesa(resultado.getInt("IdMesa")));
                pedido.setMesero(mes.buscarMozo(resultado.getInt("IdMesero")));
                pedido.setEstado(resultado.getBoolean("Estado"));
                pedido.setTotal(resultado.getDouble("SubTotal"));
            } else {
                JOptionPane.showMessageDialog(null, "Pedido no encontrado");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MesaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedido;
    }

    public void bajaLogica(int id) {
        try {
            String sql = "UPDATE pedido SET estado = 0 WHERE IdPedido = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Pedido dado de Baja");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MesaData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void altaLogica(int id) {
        try {
            String sql = "UPDATE pedido SET estado = 1 WHERE IdPedido = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Pedido dado de Alta");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MesaData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Pedido> listaProductos() {
        MesaData con = new MesaData();
        MeseroData mes = new MeseroData();
        ArrayList<Pedido> listaPedidos = new ArrayList();
        try {
            String query = "SELECT * FROM pedido";
            PreparedStatement ps = this.con.prepareStatement(query);
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(resultado.getInt("IdPedido"));
                pedido.setMesa(con.buscarMesa(resultado.getInt("IdMesa")));
                pedido.setMesero(mes.buscarMozo(resultado.getInt("IdMesero")));
                pedido.setEstado(resultado.getBoolean("Estado"));
                pedido.setTotal(resultado.getDouble("SubTotal"));
                listaPedidos.add(pedido);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al devolver la lista de Pedidos" + ex);
        }
        return listaPedidos;
    }

}
