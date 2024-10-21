/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Conexion;
import Entidades.Reserva;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author zalaz
 */
public class ReservaData {
    
    
    private Connection con = null;

    public ReservaData() {
         con = (Connection) Conexion.getConexion();
    }

    

    public void GuardarReserva(Reserva reserva) {

        String sql = "INSERT INTO mesa(Numero, Capacidad, Reserva, Estado) VALUES (?,?,?,?)";

        
       /* try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, mesa.getNum());
            ps.setInt(2, mesa.getCapacidad());
            ps.setInt(3, mesa.getReserva().getDni());
            ps.setBoolean(4, mesa.isEstado());
            int rs = ps.executeUpdate();
            if (rs>0) {
                JOptionPane.showMessageDialog(null, "Mesa Guardada");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MesaData.class.getName()).log(Level.SEVERE, null, ex);
        }

    */}
}
