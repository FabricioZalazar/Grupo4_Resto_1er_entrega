/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author zalaz
 */
public class Producto {
    
    private int codigo;
    private String nombre;
    private int stock;
    private double precio;

    public Producto() {
    }

    
    public Producto(int codigo, String nombre, int stock, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }
    

    public Producto(String nombre, int stock, double precio) {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", stock=" + stock + ", precio=" + precio + '}';
    }
    
    
}
