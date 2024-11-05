/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.time.LocalTime;
import java.time.LocalDate;

/**
 *
 * @author zalaz
 */
public class Reserva {
    
    private int IdReserva;
    private String nombre;
    private int dni;
    private LocalDate fecha;
    private LocalTime horaDe;
    private LocalTime horaHasta;
    private boolean estado;

    public Reserva() {
    }

    

    public Reserva(int IdReserva, String nombre, int dni, LocalDate fecha, LocalTime horaDe, LocalTime horaHasta, boolean estado) {
        this.IdReserva = IdReserva;
        this.nombre = nombre;
        this.dni = dni;
        this.fecha = fecha;
        this.horaDe = horaDe;
        this.horaHasta = horaHasta;
        this.estado = estado;
    }

    public Reserva(String nombre, int dni, LocalDate fecha, LocalTime horaDe, LocalTime horaHasta, boolean estado) {
        this.nombre = nombre;
        this.dni = dni;
        this.fecha = fecha;
        this.horaDe = horaDe;
        this.horaHasta = horaHasta;
        this.estado = estado;
    }

    
    public LocalTime getHoraHasta() {
        return horaHasta;
    }

    public void setHoraHasta(LocalTime horaHasta) {
        this.horaHasta = horaHasta;
    }
    
   

    public int getIdReserva() {
        return IdReserva;
    }

    public void setIdReserva(int IdReserva) {
        this.IdReserva = IdReserva;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraDe() {
        return horaDe;
    }

    public void setHoraDe(LocalTime horaDe) {
        this.horaDe = horaDe;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reserva{" + "IdReserva=" + IdReserva + ", nombre=" + nombre + ", dni=" + dni + ", fecha=" + fecha + ", hora=" + horaDe + ", estado=" + estado + '}';
    }

    
}
