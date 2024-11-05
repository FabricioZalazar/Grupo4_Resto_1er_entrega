/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author zalaz
 */
public class Pedido {
    
    private int idPedido;
    private Mesa mesa;
    private Mesero mesero;
    private boolean estado;
    private double total;

    public Pedido(Mesa mesa, Mesero mesero, boolean estado, double total) {
        this.mesa = mesa;
        this.mesero = mesero;
        this.estado = estado;
        this.total = total;
    }

    public Pedido() {
    }

    public Pedido(int idPedido, Mesa mesa, Mesero mesero, boolean estado, double total) {
        this.idPedido = idPedido;
        this.mesa = mesa;
        this.mesero = mesero;
        this.estado = estado;
        this.total = total;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", mesa=" + mesa + ", mesero=" + mesero + ", estado=" + estado + ", total=" + total + '}';
    }
    
    
    
}
