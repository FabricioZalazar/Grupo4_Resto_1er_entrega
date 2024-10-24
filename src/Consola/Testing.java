/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Consola;

import Entidades.Mesa;
import Entidades.Mesero;
import Entidades.Producto;
import Entidades.Reserva;
import Persistencia.MesaData;
import Persistencia.MeseroData;
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
        MeseroData mes=new MeseroData();
        //PRUEBAS 

        ///MESA
        //pruebaGuardarMesa(con);
        //pruebaBorrarMesa(con);
        //pruebaActualizarMesa(con);
        //pruebaAltaLogicaMesa(con);
        //pruebaBajaLogicaMesa(con);
        //pruebaBuscarMesa(con);
        //pruebaListaMesa(con);
        ///RESERVA
        //pruebaGuardarReserva(cone);  //Cada vez que se vuelva a guardar reiniciar el autoIncremental a 1 en la parte de operaciones
        //pruebaBuscarReservaID(cone);
        //pruebaBuscarReservaNombre(cone);
        //pruebaBuscarReservaDNI(cone);
        //pruebaListaReserva(cone);
        //pruebaActualizarReserva(cone);
        //pruebaBajaLogicaReserva(cone);
        //pruebaAltaLogicaReserva(cone);
        //pruebaBorrarReserva(cone); //No funciona
        
        //PRODUCTO
        //pruebaGuardarPruducto(pro);   //VOLVERLO A UNO
        //pruebaActualizarProducto(pro);
        //pruebaBorrarProducto(pro);
        
        //MESERO
        //pruebaGuardarMesero(mes);   //VOLVERLO A UNO
        //pruebaBorrarMesero(mes);
        pruebaListaMeseros(mes);
    }

    // CRUD (CREATE - READ - UPDATE - DELETE)
    // CRUD - PRODUCTO
    public static void pruebaGuardarMesero(MeseroData mes){
        Mesero mozo1=new Mesero("Maximiliano Macia");
        Mesero mozo2=new Mesero("Mario Bros");
        Mesero mozo3=new Mesero("Batman");
        Mesero mozo4=new Mesero("Mati Macia");
        
        mes.agregarMozo(mozo1);
        mes.agregarMozo(mozo2);
        mes.agregarMozo(mozo3);
        mes.agregarMozo(mozo4);
    }
    
    public static void pruebaBorrarMesero(MeseroData mes){
        int can=mes.listaMeseros().size();
        for (int i = 1; i < can+1; i++) {
            mes.borrarMozo(i);
        }
        
    }
    
    public static void pruebaListaMeseros(MeseroData mes){
        System.out.println(mes.listaMeseros());
    }
    
    public static void pruebaBorrarProducto(ProductoData pro) {
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
    public static void pruebaGuardarReserva(ReservaData cone) {
        Reserva res = new Reserva("Maximiliano Macia", 32676125, LocalDate.of(2024, 10, 21), LocalTime.now(), true);
        Reserva res2 = new Reserva("Fabricio Zalazar", 43456852, LocalDate.of(2024, 10, 22), LocalTime.now(), true);
        Reserva res3 = new Reserva("Christian Losada", 12345, LocalDate.of(2024, 10, 26), LocalTime.now(), true);
        Reserva res4 = new Reserva("Juan Abregu", 38456852, LocalDate.of(2024, 10, 12), LocalTime.now(), true);
        Reserva res5 = new Reserva("Diego Amieva", 1319389, LocalDate.of(2024, 9, 22), LocalTime.now(), true);

        cone.guardarReserva(res);
        cone.guardarReserva(res2);
        cone.guardarReserva(res3);
        cone.guardarReserva(res4);
        cone.guardarReserva(res5);
    }

    public static void pruebaBuscarReservaID(ReservaData cone) {
        System.out.println("Prueba Buscar Reserva por ID");
        System.out.println(cone.buscarReservaID(1));
        System.out.println(cone.buscarReservaID(2));
        System.out.println(cone.buscarReservaID(22));
    }

    public static void pruebaBuscarReservaNombre(ReservaData cone) {
        System.out.println(cone.buscarReservaNombre("fabricio zalaza"));
    }

    public static void pruebaBuscarReservaDNI(ReservaData cone) {
        System.out.println(cone.buscarReservaDNI(32676125));
    }

    public static void pruebaListaReserva(ReservaData cone) {
        for (Reserva reserva : cone.listaReserva()) {
            System.out.println(reserva.toString());
        }
    }

    public static void pruebaActualizarReserva(ReservaData cone) {
        cone.actualizarReserva(new Reserva(1, "maximiliano mac", 32676125, LocalDate.of(2024, 10, 21), LocalTime.of(14, 50, 00), true));
        cone.actualizarReserva(new Reserva(2, "Fabricio zalaza", 38456852, LocalDate.of(2024, 10, 22), LocalTime.of(16, 30, 00), true));
        cone.actualizarReserva(new Reserva(3, "Abregu Juan", 36681811, LocalDate.of(2024, 10, 23), LocalTime.of(19, 40, 20), true));
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
        ReservaData cone = new ReservaData();

        Mesa mesa = new Mesa(1, 4, true);
        Mesa mesa2 = new Mesa(2, 4, true);
        Mesa mesa3 = new Mesa(3, 4, false);      /// Mesa insertada sin reserva
        Mesa mesa4 = new Mesa(4, 2, true);
        Mesa mesa5 = new Mesa(5, 2, true);
        Mesa mesa6 = new Mesa(6, 6, cone.buscarReservaID(1), true);    /// Mesa insertada con Reserva     

        con.guardarMesa(mesa);
        con.guardarMesa(mesa2);
        con.guardarMesa(mesa3);
        con.guardarMesa(mesa4);
        con.guardarMesa(mesa5);
        con.guardarMesa(mesa6);
    }

    public static void pruebaActualizarMesa(MesaData con) {
        ReservaData cone = new ReservaData();

        Mesa mesa = new Mesa(1, 1, false);
        Mesa mesa2 = new Mesa(5, 4, true);
        Mesa mesa3 = new Mesa(4, 2, cone.buscarReservaID(2), true);

        con.actualizarMesa(mesa);
        con.actualizarMesa(mesa2);
        con.actualizarMesa(mesa3);
    }

    public static void pruebaAltaLogicaMesa(MesaData con) {
        con.altaLogica(1);
    }

    public static void pruebaBajaLogicaMesa(MesaData con) {
        con.bajaLogica(1);
    }

    public static void pruebaBuscarMesa(MesaData con) {
        System.out.println(con.buscarMesa(6));
    }

    public static void pruebaListaMesa(MesaData con) {
        for (Mesa mesa : con.listaMesa()) {
            System.out.println(mesa.toString());
        }
    }

    public static void pruebaBorrarMesa(MesaData con) {
        con.borrarMesa(1);
        con.borrarMesa(2);
        con.borrarMesa(3);
        con.borrarMesa(4);
        con.borrarMesa(5);
        con.borrarMesa(6);
    }
}
