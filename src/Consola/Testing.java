/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Consola;

import Entidades.Mesa;
import Entidades.Producto;
import Entidades.Reserva;
import Persistencia.MesaData;
import Persistencia.ProductoData;
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
        // CLASES.DATA
        MesaData con = new MesaData();
        ReservaData cone = new ReservaData();
        ProductoData pro = new ProductoData();
        //PRUEBAS 
        //pruebaGuardarMesa(con);
        //pruebaGuardarReserva(cone);
        //pruebaBuscarReservaID(cone);
        //pruebaBuscarReservaNombre(cone);
        //pruebaBuscarReservaDNI(cone);
        //pruebaListaReserva(cone);
        //pruebaActualizarReserva(cone);
        //pruebaBajaLogicaReserva(cone);
        //pruebaAltaLogicaReserva(cone);
        //pruebaBorrarReserva(cone); //No funciona
        //pruebaActualizarMesa(con);
        //pruebaBuscarMesa(con);
        
    }
    // CRUD (CREATE - READ - UPDATE - DELETE)
    // CRUD - PRODUCTO
    public static void pruebaBorrarProducto(ProductoData pro){
    pro.borrarProducto(1);
    pro.borrarProducto(2);
    pro.borrarProducto(3);
    pro.borrarProducto(4);
    pro.borrarProducto(5);
    }
    public static void pruebaActualizarProducto(ProductoData pro) {
        //UTILICE EL CONSTUCTOR CON CODIGO 

        
        pro.ActualizarProducto(new Producto(1, "cocacola", 1, 100.00));
        pro.ActualizarProducto(new Producto(2, "vino", 1, 1300.50));
        pro.ActualizarProducto(new Producto(3, "papas fritas", 1, 2500.00));
        pro.ActualizarProducto(new Producto(4, "bife a caballo", 1, 5000.00));
        pro.ActualizarProducto(new Producto(5, "ensalada", 1, 200.00));

    }
    public static void pruebaGuardarPruducto(ProductoData pro) {
        //(String nombre, int stock, double precio) {
        Producto p1 = new Producto("cocacola", 4, 100.00);
        Producto p2 = new Producto("vino", 4, 1300.50);
        Producto p3 = new Producto("papas fritas", 4, 2500.00);
        Producto p4 = new Producto("bife a caballo", 4, 5000.00);
        Producto p5 = new Producto("ensalada", 4, 200.00);
        pro.GuardarProducto(p1);
        pro.GuardarProducto(p2);
        pro.GuardarProducto(p3);
        pro.GuardarProducto(p4);
        pro.GuardarProducto(p5);

    }
    // CRUD - RESERVA
    public static void pruebaGuardarReserva(ReservaData cone){
        Reserva res = new Reserva("maximiliano macia", 32676125,LocalDate.of(2024, 10, 21),LocalTime.now(),true);
        Reserva res2 = new Reserva ("fabricio zalazar",38456852, LocalDate.of(2024, 10, 22),LocalTime.now(),true);
        cone.guardarReserva(res);
        cone.guardarReserva(res2);
    }
    public static void pruebaBuscarReservaID(ReservaData cone){
        System.out.println(cone.buscarReservaID(1));
    }
    public static void pruebaBuscarReservaNombre(ReservaData cone){
        System.out.println(cone.buscarReservaNombre("fabricio zalaza"));
    }
    public static void pruebaBuscarReservaDNI(ReservaData cone){
        System.out.println(cone.buscarReservaDNI(32676125));
    }
    public static void pruebaListaReserva(ReservaData cone) {
        for (Reserva reserva : cone.listaReserva()) {
            System.out.println(reserva.toString());
        }
    }
    public static void pruebaActualizarReserva(ReservaData cone){ 
        cone.actualizarReserva(new Reserva(1,"maximiliano mac", 32676125, LocalDate.of(2024, 10, 21), LocalTime.of(14, 50, 00), true));
        cone.actualizarReserva(new Reserva(2,"Fabricio zalaza", 38456852, LocalDate.of(2024, 10, 22), LocalTime.of(16, 30, 00), true));
        cone.actualizarReserva(new Reserva(3,"Abregu Juan", 36681811, LocalDate.of(2024, 10, 23), LocalTime.of(19, 40, 20), true));
    }
    public static void pruebaBajaLogicaReserva(ReservaData cone) {
        cone.bajaLogicaReserva(1);
    }
    public static void pruebaAltaLogicaReserva(ReservaData cone) {
        cone.altaLogicaReserva(3);
    }
    public static void pruebaBorrarReserva(ReservaData cone) {
        cone.borrarReserva(4);
    }
    // CRUD - MESA
    public static void pruebaGuardarMesa(MesaData con) {
        //Reserva(String nombre, int dni, LocalDate fecha, LocalTime hora, boolean estado)
        Reserva res = new Reserva("maximiliano macia", 32676125,LocalDate.of(2024, 10, 21),LocalTime.of(20, 30),true);
        Reserva res2 = new Reserva ("fabricio zalazar",38456852, LocalDate.of(2024, 10, 22),LocalTime.of(21, 30),true);
        
        Mesa mesa = new Mesa(10, 4, res, true);
        Mesa mesa2 = new Mesa(2, 4, res2, true);
        Mesa mesa3 = new Mesa(22, 1, true);      //Mesa insertada sin reserva
        con.GuardarMesa(mesa);
        con.GuardarMesa(mesa2);
        con.GuardarMesa(mesa3);
    }
    public static void pruebaActualizarMesa(MesaData con){
        Reserva res = new Reserva("maximiliano macia", 32676125,LocalDate.of(2024, 10, 21),LocalTime.of(20, 30),true);
        Mesa mesa = new Mesa(2, 1, false);
        con.ActualizarMesa(mesa);
    }
    public static void  pruebaBuscarMesa(MesaData con){
        System.out.println( con.BuscarMesa(2));
       
    }
}
