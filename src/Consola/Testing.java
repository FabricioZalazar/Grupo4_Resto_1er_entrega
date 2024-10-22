/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Consola;

import Entidades.Mesa;
import Entidades.Reserva;
import Persistencia.MesaData;
import Persistencia.ReservaData;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

/**
 *
 * @author zalaz
 */
public class Testing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MesaData con = new MesaData();
        ReservaData cone = new ReservaData();
        pruebaGuardarMesa(con);
        //pruebaGuardarReserva(cone);
        
        
    }
    public static void pruebaGuardarReserva(ReservaData cone){
        Reserva res = new Reserva("maximiliano macia", 32676125,LocalDate.of(2024, 10, 21),LocalTime.now(),true);
        Reserva res2 = new Reserva ("fabricio zalazar",38456852, LocalDate.of(2024, 10, 22),LocalTime.now(),true);
        cone.GuardarReserva(res);
        cone.GuardarReserva(res2);
    }

    public static void pruebaGuardarMesa(MesaData con) {
        //Reserva(String nombre, int dni, LocalDate fecha, LocalTime hora, boolean estado)
        Reserva res = new Reserva("maximiliano macia", 32676125,LocalDate.of(2024, 10, 21),LocalTime.of(20, 30),true);
        Reserva res2 = new Reserva ("fabricio zalazar",38456852, LocalDate.of(2024, 10, 22),LocalTime.of(21, 30),true);
        
        Mesa mesa = new Mesa(10, 4, res, true);
        Mesa mesa2 = new Mesa(2, 4, res2, true);
        con.GuardarMesa(mesa);
        con.GuardarMesa(mesa2);
    }

}