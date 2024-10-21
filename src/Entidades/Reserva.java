/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author zalaz
 */
public class Reserva {
    private String nombre;
    private int dni;
    private Date feche;
    private LocalTime hora;
    private boolean estado;

    public Reserva(String nombre, int dni, Date feche, LocalTime hora, boolean estado) {
        this.nombre = nombre;
        this.dni = dni;
        this.feche = feche;
        this.hora = hora;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Date getFeche() {
        return feche;
    }

    public void setFeche(Date feche) {
        this.feche = feche;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reserva{" + "nombre=" + nombre + ", dni=" + dni + ", feche=" + feche + ", hora=" + hora + ", estado=" + estado + '}';
    }

    
}
