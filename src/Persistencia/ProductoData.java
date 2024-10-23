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
import java.sql.SQLException;
import java.sql.Statement;
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
                JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");
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
}