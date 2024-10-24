/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.ManejoPDFMulta;
import Model.Multa;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class BuscarMulta extends javax.swing.JFrame {

    /**
     * Creates new form BuscarMulta
     */
    public BuscarMulta() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NombrePersona = new javax.swing.JTextField();
        bBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        bSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        jLabel1.setText("BUSCAR MULTAS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Nombre:");

        bBuscar.setBackground(new java.awt.Color(115, 99, 79));
        bBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bBuscar.setForeground(new java.awt.Color(0, 0, 0));
        bBuscar.setText("BUSCAR");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        bSalir.setBackground(new java.awt.Color(115, 99, 79));
        bSalir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bSalir.setForeground(new java.awt.Color(0, 0, 0));
        bSalir.setText("SALIR");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(65, 65, 65)
                        .addComponent(NombrePersona, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(bBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(138, 138, 138))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(321, 321, 321))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel1)
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombrePersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBuscar)
                    .addComponent(jLabel2))
                .addGap(73, 73, 73)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(bSalir)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        // TODO add your handling code here:
        String nombrePersona = NombrePersona.getText(); // Campo de texto donde el usuario ingresa el nombre

            // Validar que el campo no esté vacío
            if (nombrePersona.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                        "Por favor, ingresa el nombre de la persona.", 
                        "Campo vacío", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Llamar al método para buscar las multas por nombre de persona
            ManejoPDFMulta manejoMulta = new ManejoPDFMulta();
            List<Multa> multasEncontradas = manejoMulta.buscarMultasPorPersona(nombrePersona);

            if (multasEncontradas.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                        "No se encontraron multas para la persona ingresada.", 
                        "Multa no encontrada", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Mostrar las multas en un JTextArea
            StringBuilder resultado = new StringBuilder();
            for (Multa multa : multasEncontradas) {
                resultado.append("Código: ").append(multa.getCodigoMulta()).append("\n")
                         .append("Fecha Multa: ").append(multa.getFechaMulta()).append("\n")
                         .append("Propiedad: ").append(multa.getPropiedad()).append("\n")
                         .append("Evento: ").append(multa.getEvento()).append("\n")
                         .append("Valor: ").append(multa.getValorMulta()).append("\n")
                         .append("Fecha Máxima Pago: ").append(multa.getFechaMaxPago()).append("\n\n");
            }

            jTextArea1.setText(resultado.toString()); // Mostrar el resultado en el JTextArea
    }//GEN-LAST:event_bBuscarActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        // TODO add your handling code here:
        Principal ventanaPrincipal = new Principal();
        this.setVisible(false);
        ventanaPrincipal.setVisible(true);
    }//GEN-LAST:event_bSalirActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarMulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarMulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarMulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarMulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarMulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NombrePersona;
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
