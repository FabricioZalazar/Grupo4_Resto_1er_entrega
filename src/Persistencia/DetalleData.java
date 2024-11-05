/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entidades.Conexion;
import Entidades.Detalle;
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
 * @author Nedisane
 */
public class DetalleData {
    
    private Connection con = null;

    public DetalleData() {

        con = (Connection) Conexion.getConexion();
    }
    
    public void guardarDetalle(Detalle detalle) {
        String sql = "INSERT INTO detalle(IdPedido, IdProducto, Cantidad) VALUES (?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, detalle.getPedido().getIdPedido());
            ps.setInt(2, detalle.getProducto().getCodigo());
            ps.setInt(3, detalle.getCantidad());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Detalle Guardado");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Detalle buscarDetalleID (int id) {
        Detalle detalle = new Detalle();
        PedidoData pedidoData = new PedidoData();
        ProductoData productoData = new ProductoData();
        try {
            String query = "SELECT * FROM `detalle` WHERE idDetalle = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                detalle.setIdDetalle(id);
                detalle.setPedido(pedidoData.buscarPedido(resultado.getInt("idPedido")));
                detalle.setProducto(productoData.buscarProducto(resultado.getInt("idProducto")));
                detalle.setCantidad(resultado.getInt("cantidad"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al devolver la reserva" + ex);
        }
        return detalle;
    }
    
    public ArrayList <Detalle> listaDetalle () {
        ArrayList<Detalle> listaDetalle = new ArrayList();
        PedidoData pedidoData = new PedidoData();
        ProductoData productoData = new ProductoData();
        try {
            String query = "SELECT * FROM detalle";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                Detalle detalle = new Detalle();
                detalle.setIdDetalle(resultado.getInt("idReserva"));
                detalle.setPedido(pedidoData.buscarPedido(resultado.getInt("idPedido")));
                detalle.setProducto(productoData.buscarProducto(resultado.getInt("idProducto")));
                detalle.setCantidad(resultado.getInt("cantidad"));
                listaDetalle.add(detalle);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al devolver la lista de detalles" + ex);
        }
        return listaDetalle;
    }
    
    public void actualizarDetalle (Detalle detalle) {
        PedidoData pedidoData = new PedidoData();
        ProductoData productoData = new ProductoData();
        
        String query = "UPDATE detalle SET idPedido = ?, idProducto = ?, cantidad = ? WHERE IdDetalle = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setInt(1, detalle.getPedido().getIdPedido());
            ps.setInt(2, detalle.getProducto().getCodigo());
            ps.setInt(3, detalle.getCantidad());
            ps.setInt(4, detalle.getIdDetalle());
            
            int rs = ps.executeUpdate();
            if (rs == 1) {
                JOptionPane.showMessageDialog(null, "Detalle actualizado");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el Detalle: " + ex.getMessage());
        }
    }
    
    public void borrarDetalle (int id) {
        try {
            //Luego borramos en la misma tabla
            String query = "DELETE FROM detalle WHERE IdDetalle = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int resultado = ps.executeUpdate();
            
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "El detalle fue eliminado Exitosamente");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReservaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
