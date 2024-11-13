/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import static java.lang.Character.UnicodeBlock.forName;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mmaci
 */
public class Conexion {
    private static final String URL = "jdbc:mariadb://localhost/";
    private static final String DB = "grupo4-resto-3er-entrega";
    private static final String USUARIO =   "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;
    private static Connection conection;
    
    public static Connection getConexion(){
       
        if (connection == null) {
            try {
                
                Class.forName("org.mariadb.jdbc.Driver");
               
                connection = DriverManager.getConnection(URL + DB,USUARIO, PASSWORD);
                //JOptionPane.showMessageDialog(null, "conectado");
                
                
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "error al cargar los drivers");
            } catch (ClassNotFoundException ex) {
               JOptionPane.showMessageDialog(null, "error al conectarse a la base de datos");
            }
        }
        return connection;
    }
}
        
           
   
      
    
      
    
    
            

