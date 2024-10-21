/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Consola;

import Entidades.Conexion;
import Entidades.Mesa;
import Entidades.Reserva;
import Persistencia.MesaData;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author zalaz
 */
public class Testing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MesaData con=new MesaData();
        Reserva res=new Reserva(2234);
        Mesa mesa=new Mesa(5,3,res,true);
        con.GuardarAlumno(mesa);
        
    }
    
}
