/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colores;

import Persistencia.MesaData;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author zalaz
 */
public class ColorListaReserva  extends DefaultTableCellRenderer {
    MesaData mesa=new MesaData();
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Object valorColumna2 = table.getValueAt(row, 0);
        int id=(int) valorColumna2;
        if(mesa.buscarMesaPorReserva(id).getNum()>0){
            setBackground(Color.RED.brighter());
        }else{
            setBackground(Color.gray.brighter());
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
    }
    
}
