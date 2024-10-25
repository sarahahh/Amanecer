/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

/**
 *
 * @author USUARIO
 */
public class Propietario extends javax.swing.JFrame {

    /**
     * Creates new form Propietario
     */
    public Propietario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bDisponibilidad = new javax.swing.JButton();
        bAdministracion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bSalir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        bBuscarMulta = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        bBuscarFactura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(217, 217, 217));

        bDisponibilidad.setBackground(new java.awt.Color(115, 99, 79));
        bDisponibilidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bDisponibilidad.setForeground(new java.awt.Color(0, 0, 0));
        bDisponibilidad.setText("IR");
        bDisponibilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDisponibilidadActionPerformed(evt);
            }
        });

        bAdministracion.setBackground(new java.awt.Color(115, 99, 79));
        bAdministracion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bAdministracion.setForeground(new java.awt.Color(0, 0, 0));
        bAdministracion.setText("IR");
        bAdministracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAdministracionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        jLabel1.setText("MENÚ PROPIETARIO");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Disponibilidad de espacios comunes:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Administración de mi propiedad:");

        bSalir.setBackground(new java.awt.Color(115, 99, 79));
        bSalir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bSalir.setForeground(new java.awt.Color(0, 0, 0));
        bSalir.setText("SALIR");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Buscar mis multas:");

        bBuscarMulta.setBackground(new java.awt.Color(115, 99, 79));
        bBuscarMulta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bBuscarMulta.setForeground(new java.awt.Color(0, 0, 0));
        bBuscarMulta.setText("IR");
        bBuscarMulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarMultaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Buscar mis facturas:");

        bBuscarFactura.setBackground(new java.awt.Color(115, 99, 79));
        bBuscarFactura.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bBuscarFactura.setForeground(new java.awt.Color(0, 0, 0));
        bBuscarFactura.setText("IR");
        bBuscarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bAdministracion, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(bDisponibilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bBuscarMulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bBuscarFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(jLabel1)))
                .addGap(144, 179, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel1)
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(bDisponibilidad))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(bAdministracion))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(bBuscarMulta))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(bBuscarFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(bSalir)
                .addGap(76, 76, 76))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        // TODO add your handling code here:
        Principal ventanaPrincipal = new Principal();
        this.setVisible(false);
        ventanaPrincipal.setVisible(true);
    }//GEN-LAST:event_bSalirActionPerformed

    private void bDisponibilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDisponibilidadActionPerformed
        // TODO add your handling code here:
        EspaciosComunes ventanaEspaciosComunes = new EspaciosComunes();
        this.setVisible(false);
        ventanaEspaciosComunes.setVisible(true);
    }//GEN-LAST:event_bDisponibilidadActionPerformed

    private void bAdministracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAdministracionActionPerformed
        // TODO add your handling code here:
        AdminPropiedad ventanaAdminPropiedad = new AdminPropiedad();
        this.setVisible(false);
        ventanaAdminPropiedad.setVisible(true);
    }//GEN-LAST:event_bAdministracionActionPerformed

    private void bBuscarMultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarMultaActionPerformed
        // TODO add your handling code here:
        BuscarMulta ventanaBuscarMulta = new BuscarMulta();
        this.setVisible(false);
        ventanaBuscarMulta.setVisible(true);
    }//GEN-LAST:event_bBuscarMultaActionPerformed

    private void bBuscarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarFacturaActionPerformed
        // TODO add your handling code here:
        BuscarFactura ventanaBuscarFactura = new BuscarFactura();
        this.setVisible(false);
        ventanaBuscarFactura.setVisible(true);
        
    }//GEN-LAST:event_bBuscarFacturaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Propietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Propietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Propietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Propietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Propietario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdministracion;
    private javax.swing.JButton bBuscarFactura;
    private javax.swing.JButton bBuscarMulta;
    private javax.swing.JButton bDisponibilidad;
    private javax.swing.JButton bSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}