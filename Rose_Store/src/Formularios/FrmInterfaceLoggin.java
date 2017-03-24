
package Formularios;

import java.awt.Toolkit;
import Clases.*;

public class FrmInterfaceLoggin extends javax.swing.JFrame {
C_CargarImagenes img = new C_CargarImagenes();


    public FrmInterfaceLoggin() {
        initComponents();
        tamaño();
        LbFondo.setIcon(img.FondoLogin(LbFondo.getWidth(), LbFondo.getHeight()));
    }
    
    void tamaño(){
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        int ancho = (int) (Toolkit.getDefaultToolkit().getScreenSize().width);
        int alto = (int) (Toolkit.getDefaultToolkit().getScreenSize().height);
        LbFondo.setBounds(0, 0, ancho, alto);
        LbUsuario.setLocation((ancho/2)-130,alto/2);
        LbClave.setLocation(LbUsuario.getX(), LbUsuario.getY()+LbUsuario.getWidth());
        TxtUsuario.setLocation(ancho/2, alto/2);
        TxtClave.setLocation(TxtUsuario.getX(),LbClave.getY());
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LbUsuario = new javax.swing.JLabel();
        LbClave = new javax.swing.JLabel();
        TxtUsuario = new javax.swing.JTextField();
        TxtClave = new javax.swing.JTextField();
        LbFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        LbUsuario.setFont(new java.awt.Font("Constantia", 0, 18)); // NOI18N
        LbUsuario.setText("Usuario");
        getContentPane().add(LbUsuario);
        LbUsuario.setBounds(204, 230, 80, 23);

        LbClave.setFont(new java.awt.Font("Constantia", 0, 18)); // NOI18N
        LbClave.setText("Clave");
        getContentPane().add(LbClave);
        LbClave.setBounds(227, 260, 50, 23);

        TxtUsuario.setFont(new java.awt.Font("Constantia", 0, 18)); // NOI18N
        getContentPane().add(TxtUsuario);
        TxtUsuario.setBounds(310, 230, 120, 29);

        TxtClave.setFont(new java.awt.Font("Constantia", 0, 18)); // NOI18N
        TxtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtClaveActionPerformed(evt);
            }
        });
        getContentPane().add(TxtClave);
        TxtClave.setBounds(310, 260, 120, 29);
        getContentPane().add(LbFondo);
        LbFondo.setBounds(10, 11, 60, 30);

        setBounds(0, 0, 660, 412);
    }// </editor-fold>//GEN-END:initComponents

    private void TxtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtClaveActionPerformed

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
            java.util.logging.Logger.getLogger(FrmInterfaceLoggin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInterfaceLoggin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInterfaceLoggin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInterfaceLoggin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInterfaceLoggin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbClave;
    private javax.swing.JLabel LbFondo;
    private javax.swing.JLabel LbUsuario;
    private javax.swing.JTextField TxtClave;
    private javax.swing.JTextField TxtUsuario;
    // End of variables declaration//GEN-END:variables
}
