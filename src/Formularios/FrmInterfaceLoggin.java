
package Formularios;

import java.awt.Toolkit;
import Clases.*;
import FormulariosExternos.*;
import javax.swing.JOptionPane;

public class FrmInterfaceLoggin extends javax.swing.JFrame {
C_CargarImagenes img = new C_CargarImagenes();
C_VerificarCampos verificacion_campos = new C_VerificarCampos();
C_Consultas consulta = new C_Consultas();
String query;


    public FrmInterfaceLoggin() {
        initComponents();
        tamaño();
        LbFondo.setIcon(img.FondoLogin(LbFondo.getWidth(), LbFondo.getHeight()));
        LbAjustesConexion.setIcon(img.IconoAjuste(LbAjustesConexion.getWidth(), LbAjustesConexion.getHeight()));
    }
    
    void tamaño(){
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        int ancho = (int) (Toolkit.getDefaultToolkit().getScreenSize().width);
        int alto = (int) (Toolkit.getDefaultToolkit().getScreenSize().height);
        this.setResizable(false);
        LbFondo.setBounds(0, 0, ancho, alto);
        LbAjustesConexion.setBounds(5, alto-100, 60, 60);
        LbUsuario.setLocation((ancho/2)-130,alto/2);
        LbClave.setLocation(LbUsuario.getX(), LbUsuario.getY()+LbUsuario.getHeight()+20);
        TxtUsuario.setLocation(ancho/2, alto/2);
        TxtClave.setLocation(TxtUsuario.getX(),LbClave.getY());
        BtnIngresar.setLocation(TxtClave.getX() + 30, TxtClave.getY()+ TxtClave.getHeight()+20);
    }
    
    void logginUsuario(String usuario, String contrasena){
        String[] campos = {"usuario","contrasena"};
        if(verificacion_campos.CamposLoggin(usuario, contrasena).equals("ok")){
            query = "Select * from t_usuarios where estado = 1;";//query.Usuarios("consultaLoggin", campos, "1");
            String[] datos = consulta.consulta_existencia(query, campos.length, campos);
            if(usuario.equals(datos[0]) && contrasena.equals(datos[1])){
                new FrmInterfaceMenu().setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Usuario ó Clave invalida.\nDigite nuevamente la información");
                TxtClave.setText("");
            }
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LbUsuario = new javax.swing.JLabel();
        LbClave = new javax.swing.JLabel();
        TxtUsuario = new javax.swing.JTextField();
        LbAjustesConexion = new javax.swing.JLabel();
        BtnIngresar = new javax.swing.JButton();
        TxtClave = new javax.swing.JPasswordField();
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

        LbAjustesConexion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LbAjustesConexionMouseClicked(evt);
            }
        });
        getContentPane().add(LbAjustesConexion);
        LbAjustesConexion.setBounds(0, 360, 0, 0);

        BtnIngresar.setFont(new java.awt.Font("Constantia", 1, 13)); // NOI18N
        BtnIngresar.setText("Ingresar");
        BtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnIngresar);
        BtnIngresar.setBounds(343, 300, 90, 25);
        getContentPane().add(TxtClave);
        TxtClave.setBounds(310, 260, 120, 30);
        getContentPane().add(LbFondo);
        LbFondo.setBounds(10, 11, 60, 30);

        setBounds(0, 0, 660, 412);
    }// </editor-fold>//GEN-END:initComponents

    private void LbAjustesConexionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbAjustesConexionMouseClicked
        DlogInterfaceDatosConexion ajustes = new DlogInterfaceDatosConexion(new javax.swing.JFrame(), true);
        ajustes.setVisible(true);
    }//GEN-LAST:event_LbAjustesConexionMouseClicked

    private void BtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIngresarActionPerformed
        logginUsuario(TxtUsuario.getText(), new String(TxtClave.getPassword()));
    }//GEN-LAST:event_BtnIngresarActionPerformed

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
                if ("Windows".equals(info.getName())) {
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
    private javax.swing.JButton BtnIngresar;
    private javax.swing.JLabel LbAjustesConexion;
    private javax.swing.JLabel LbClave;
    private javax.swing.JLabel LbFondo;
    private javax.swing.JLabel LbUsuario;
    private javax.swing.JPasswordField TxtClave;
    private javax.swing.JTextField TxtUsuario;
    // End of variables declaration//GEN-END:variables
}
