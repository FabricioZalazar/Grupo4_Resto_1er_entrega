/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colores;

import Entidades.Reserva;
import Vistas.VistaActualizarMesa;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author mmaci
 */
public class ColorCeldas extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Object valorColumna2 = table.getValueAt(row, 2);
        Object valorColumna3 = table.getValueAt(row, 3);
        Object valorColumna4 = table.getValueAt(row, 4);

        // Verifica si el valor de la columna 2 es booleano y aplica el color correspondiente a toda la fila
        String estado = (String) valorColumna2;
        Reserva res = (Reserva) valorColumna3;
        String pedido = (String) valorColumna4;
        
        
        if (estado.equalsIgnoreCase("Ocupado")) {
            setBackground(Color.RED.brighter());
            setForeground(Color.BLACK);
        } else if (valorColumna3 != null) {
            setBackground(Color.BLUE.brighter().darker());
            setForeground(Color.white);
        } else {
            setBackground(Color.GREEN.brighter());
            setForeground(Color.BLACK);
        }
        

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
  

}
