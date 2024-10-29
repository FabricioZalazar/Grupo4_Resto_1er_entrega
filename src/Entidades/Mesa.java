/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author zalaz
 */
public class Mesa {
        
        private int num;
        private int capacidad;
        private Reserva reserva;
        private boolean estado;
        

    public Mesa() {
    }

    public Mesa(int num, int capacidad, boolean estado) {
        this.num = num;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    
    
    

        
    public Mesa(int num, int capacidad, Reserva reserva, boolean estado) {
        this.num = num;
        this.capacidad = capacidad;
        this.reserva = reserva;
        this.estado = estado;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Mesa{" + "num=" + num + ", capacidad=" + capacidad + ", reserva=" + reserva + ", estado=" + estado + '}';
    }
  
       
   
        
        
}
