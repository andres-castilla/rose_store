
package FormulariosExternos;
import Clases.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DlogInterfaceDatosConexion extends javax.swing.JDialog {
    C_CargarImagenes img = new C_CargarImagenes();
    C_EditorTexto datosEditor = new C_EditorTexto();


    public DlogInterfaceDatosConexion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        parametrosIniciales();
    }
    
    void parametrosIniciales(){
        sizeItem();
        LbFondo.setIcon(img.FondoHome(LbFondo.getWidth(), LbFondo.getHeight()));
        cargarDatosConexion();
    }
    
    void sizeItem(){
        this.setSize(340, 280);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        LbFondo.setBounds(0, 0, this.getWidth(), this.getHeight());
        LbTitulo.setBounds(5, 5, this.getWidth(), 40);
        SepTitulo.setBounds(0, LbTitulo.getY() + LbTitulo.getHeight(), this.getWidth(), 10);
    }
    
    void cargarDatosConexion(){
        int j=0;
        String campo="";
        String[] datosConex = new String[4];
        String datos = datosEditor.cargarTxt("DatosConexion.txt");
        char[] caracteres = datos.toCharArray();
        for(int i=0; i<caracteres.length; i++){
            if(caracteres[i]!='-'){
                campo += String.valueOf(caracteres[i]);
            }else{
                datosConex[j] = campo;
                campo="";
                j++;
            }
        }
        TxtDireccionConexionBD.setText(datosConex[0]);
        TxtUsarioBD.setText(datosConex[1]);
        TxtContrasena.setText(datosConex[2]);
        TxtNombreBD.setText(datosConex[3]);
    }
    
    void guardarDatosConexion(String texto, String nombreArchivo){
        datosEditor.nuevoTxt(texto, nombreArchivo);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LbTitulo = new javax.swing.JLabel();
        SepTitulo = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtDireccionConexionBD = new javax.swing.JTextField();
        TxtUsarioBD = new javax.swing.JTextField();
        TxtNombreBD = new javax.swing.JTextField();
        BtnActualizar = new javax.swing.JButton();
        TxtContrasena = new javax.swing.JPasswordField();
        LbFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        LbTitulo.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        LbTitulo.setText("Datos de Conexión");
        getContentPane().add(LbTitulo);
        LbTitulo.setBounds(0, 20, 170, 30);
        getContentPane().add(SepTitulo);
        SepTitulo.setBounds(0, 60, 90, 10);

        jLabel1.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        jLabel1.setText("Dirección de Conexión:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 90, 140, 17);

        jLabel2.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        jLabel2.setText("Usuario:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 120, 60, 17);

        jLabel3.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        jLabel3.setText("Contraseña:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 150, 80, 17);

        jLabel4.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        jLabel4.setText("Nombre de Base Datos:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 180, 150, 17);

        TxtDireccionConexionBD.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        getContentPane().add(TxtDireccionConexionBD);
        TxtDireccionConexionBD.setBounds(150, 90, 170, 20);

        TxtUsarioBD.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        getContentPane().add(TxtUsarioBD);
        TxtUsarioBD.setBounds(150, 120, 170, 20);

        TxtNombreBD.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        getContentPane().add(TxtNombreBD);
        TxtNombreBD.setBounds(150, 180, 170, 20);

        BtnActualizar.setFont(new java.awt.Font("Constantia", 1, 13)); // NOI18N
        BtnActualizar.setText("Actualizar");
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnActualizar);
        BtnActualizar.setBounds(223, 220, 100, 25);
        getContentPane().add(TxtContrasena);
        TxtContrasena.setBounds(150, 150, 170, 20);
        getContentPane().add(LbFondo);
        LbFondo.setBounds(0, 0, 0, 0);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarActionPerformed
        String texto="";
        texto += TxtDireccionConexionBD.getText();
        texto += "-" + TxtUsarioBD.getText();
        texto += "-" + new String(TxtContrasena.getPassword());
        texto += "-" + TxtNombreBD.getText();
        texto += "-";
        guardarDatosConexion(texto, "DatosConexion.txt");
        
    }//GEN-LAST:event_BtnActualizarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JLabel LbFondo;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JSeparator SepTitulo;
    private javax.swing.JPasswordField TxtContrasena;
    private javax.swing.JTextField TxtDireccionConexionBD;
    private javax.swing.JTextField TxtNombreBD;
    private javax.swing.JTextField TxtUsarioBD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
