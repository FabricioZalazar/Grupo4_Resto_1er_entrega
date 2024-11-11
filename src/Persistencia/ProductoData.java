/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entidades.Conexion;
import Entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mmaci
 */
public class ProductoData {

    private Connection con = null;

    public ProductoData() {

        con = (Connection) Conexion.getConexion();
    }

    public void borrarProducto(int codigo) {
        String sql = "DELETE FROM producto WHERE idProducto = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Producto borrado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el producto");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al borrar el producto");
        }

    }

    public void ActualizarProducto(Producto produc) {

        String sql = "UPDATE producto SET Nombre = ?, Stock = ?, Precio = ? WHERE IdProducto = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, produc.getNombre());
            ps.setInt(2, produc.getStock());
            ps.setDouble(3, produc.getPrecio());
            ps.setInt(4, produc.getCodigo());
            int filas = ps.executeUpdate();

            if (filas > 0) {
               // JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el producto");
        }
    }

    public void GuardarProducto(Producto produc) {

        String sql = "INSERT INTO producto (Nombre, Stock, Precio) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, produc.getNombre());
            ps.setInt(2, produc.getStock());
            ps.setDouble(3, produc.getPrecio());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Producto guardado");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al guardar el producto");
        }

    }
    
     public ArrayList <Producto> listaProductos () {
        ArrayList<Producto> listaProductos = new ArrayList();
        try {
            String query = "SELECT * FROM producto";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                Producto proc = new Producto();
                proc.setNombre(resultado.getString("Nombre"));
                proc.setStock(resultado.getInt("Stock"));
                proc.setPrecio(resultado.getDouble("Precio"));
                proc.setCodigo(resultado.getInt("IdProducto"));
                listaProductos.add(proc);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al devolver la lista de Productos" + ex);
        }
        return listaProductos;
    }
     
     public Producto buscarProducto(int idProducto) {
        Producto proc = new Producto();

        String sql = "SELECT * FROM producto WHERE IdProducto = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idProducto);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                proc.setCodigo(rs.getInt("IdProducto"));
                proc.setNombre(rs.getString("Nombre"));
                proc.setPrecio(rs.getDouble("Precio"));
                proc.setStock(rs.getInt("Stock"));
                // Asegúrate de que estás capturando todos los campos necesarios
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el producto");
            }
             ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el producto: " + ex.getMessage());
        }
        return proc;
    }
     
      public Producto buscarProductoPorNombre(String nombre) {
        Producto proc = new Producto();

        String sql = "SELECT * FROM producto WHERE Nombre = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                proc.setCodigo(rs.getInt("IdProducto"));
                proc.setNombre(rs.getString("Nombre"));
                proc.setPrecio(rs.getDouble("Precio"));
                proc.setStock(rs.getInt("Stock"));
                // Asegúrate de que estás capturando todos los campos necesarios
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el producto");
            }
             ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar el producto: " + ex.getMessage());
        }
        return proc;
      }
      
      
}