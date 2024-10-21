/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Consola;

import Entidades.Mesa;
import Entidades.Reserva;
import Persistencia.MesaData;

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
        pruebaGuardarMesa(con);
        
    }

    public static void pruebaGuardarMesa(MesaData con) {
        Reserva res = new Reserva(32234);
        Reserva res2 = new Reserva(12334);
        Mesa mesa = new Mesa(10, 4, res, true);
        Mesa mesa2 = new Mesa(2, 4, res2, true);
        con.GuardarMesa(mesa);
        con.GuardarMesa(mesa2);
    }

}
