/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author mmaci
 */
public class ColorInventario extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Object valorColumna2 = table.getValueAt(row, 2);
        

        // Verifica si el valor de la columna 2 es booleano y aplica el color correspondiente a toda la fila
        int stock = (int) valorColumna2;
       
        
        if (stock <= 5) {
            setBackground(Color.YELLOW.brighter());
            setForeground(Color.BLACK);
      
       
        }else{
            setBackground(Color.GREEN.brighter().darker());
            setForeground(Color.white);
        }
            

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
