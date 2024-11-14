/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import Entidades.Detalle;
import Entidades.Mesa;
import Entidades.Pedido;
import Persistencia.DetalleData;
import Persistencia.MesaData;
import Persistencia.PedidoData;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabricio Zalazar
 */
public class VistaCobrarMesa extends javax.swing.JInternalFrame {

    VistaPrincipal vistaPrincipal;
    VistaPedidos vistaPedidos;
    MesaData mesa = new MesaData();
    DetalleData con = new DetalleData();
    PedidoData cone = new PedidoData();

    public VistaCobrarMesa() {
        initComponents();
        llenarCampos();
    }

    public VistaCobrarMesa(VistaPrincipal VistaPrincipal) {
        initComponents();
        llenarCampos();
        this.vistaPrincipal = VistaPrincipal;
    }

    public VistaCobrarMesa(VistaPedidos VistaPedidos) {
        this.vistaPedidos=VistaPedidos;
        initComponents();
        llenarCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JLabel();
        jLTotal = new javax.swing.JLabel();
        txtCambio = new javax.swing.JLabel();
        jLCambio = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        jLPago = new javax.swing.JLabel();
        txtPago = new javax.swing.JTextField();
        btnCobrar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(206, 202, 195));

        txtTitulo.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        txtTitulo.setText("Mesa Nº 22");

        jLTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLTotal.setText("Total");

        txtCambio.setText("jLabel3");

        jLCambio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLCambio.setText("Cambio");

        txtTotal.setText("jLabel5");

        jLPago.setText("Pago");

        txtPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPagoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagoKeyTyped(evt);
            }
        });

        btnCobrar.setText("Cobrar Mesa");
        btnCobrar.setEnabled(false);
        btnCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobrarActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(226, 70, 70));
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLCambio)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCambio))
                    .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTitulo)
                    .addComponent(btnCobrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTitulo)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLPago)
                            .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLCambio)
                            .addComponent(txtCambio)))
                    .addComponent(txtTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCobrar)
                    .addComponent(jButton2))
                .addGap(14, 14, 14))
        );

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarActionPerformed
        try{
        double total = Double.parseDouble(txtTotal.getText());
        double pago = Double.parseDouble(txtPago.getText());
        if (pago < total) {
            JOptionPane.showMessageDialog(rootPane, "Monto Insuficiente (A lavar los platos)");
        } else {
            Mesa m = VistaPrincipal.getMesa();

            for (Detalle d : con.listaDetallePorMesa(m.getNum())) {
                con.borrarDetalle(d.getIdDetalle());

            }
            Pedido p = cone.buscarPedidoPorMesa(m.getNum());
            cone.borrarPedido(p.getIdPedido());
            mesa.actualizarMesa(new Mesa(m.getNum(), m.getCapacidad(), m.getReserva(), false));
            try{
                vistaPrincipal.actualizarTabla();
                
            }catch(NullPointerException r){
                vistaPedidos.llenarTabla();
            }
            
            VistaPrincipal.setMesa(null);
            this.dispose();
        }
        }catch(NumberFormatException r){
             JOptionPane.showMessageDialog(rootPane, "Complete el campo de pago");
            
        }
    }//GEN-LAST:event_btnCobrarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        VistaPrincipal.setMesa(null);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyTyped

    }//GEN-LAST:event_txtPagoKeyTyped

    private void txtPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyReleased
        try{
        if (!txtPago.getText().equals("")) {
            
            double total = Double.parseDouble(txtTotal.getText());
            double pago = Double.parseDouble(txtPago.getText());
            if(pago>0){
            if (total < pago) {
                txtCambio.setText((pago - total) + "");
            } else {
                txtCambio.setText("0");
            }
            btnCobrar.setEnabled(true);
            }else{
                 btnCobrar.setEnabled(false);
            }
        }
        }catch(NumberFormatException r){
            JOptionPane.showMessageDialog(rootPane, "*ERROR solo se permiten numeros");
            txtPago.setText("0");
             btnCobrar.setEnabled(false);
        }
    }//GEN-LAST:event_txtPagoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCobrar;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLCambio;
    private javax.swing.JLabel jLPago;
    private javax.swing.JLabel jLTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtCambio;
    private javax.swing.JTextField txtPago;
    private javax.swing.JLabel txtTitulo;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
    public void llenarCampos() {
        Pedido p = cone.buscarPedidoPorMesa(VistaPrincipal.getMesa().getNum());
        Pedido pe = new Pedido(p.getIdPedido(), p.getMesa(), p.getMesero(), p.isEstado(), cone.Total(p.getMesa().getNum()));
        cone.actualizarPedido(pe);
        txtTotal.setText(pe.getTotal() + "");
        txtCambio.setText("0");
        txtTitulo.setText("Mesa Nº " + p.getMesa().getNum());
    }

}
