/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Vistas.VistaActualizarMesa;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author mmaci
 */
public class ColorCeldas extends DefaultTableCellRenderer {
    private VistaActualizarMesa actualizarMesa;

    public ColorCeldas(VistaActualizarMesa actualizarMesa) {
        this.actualizarMesa = actualizarMesa;
    }

    

    

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component celda = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

       
        if (value != null && value.equals(true) ) {
            celda.setBackground(Color.GREEN);
        } else {
            celda.setBackground(Color.RED);
        }
        
        return celda;
    }
}


