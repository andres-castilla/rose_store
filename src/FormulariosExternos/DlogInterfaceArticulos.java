
package FormulariosExternos;
import Clases.*;
import javax.swing.JOptionPane;

public class DlogInterfaceArticulos extends javax.swing.JDialog {
C_CargarImagenes img = new C_CargarImagenes();
C_Listado listado = new C_Listado();
C_VerificarCampos verificacionCampos = new C_VerificarCampos();
C_Consultas consulta = new C_Consultas();
C_Agregar agregar = new C_Agregar();
String query;

    public DlogInterfaceArticulos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        parametrosIniciales();
    }

    void parametrosIniciales(){
        sizeItem();
        cancelar();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        LbFondo.setIcon(img.FondoHome(LbFondo.getWidth(), LbFondo.getHeight()));
        TxtIdClase.setBackground(listado.colorBusqueda);
    }
    
void sizeItem(){
    int espacio = 10;
    this.setSize(550, 320);
    LbFondo.setSize(this.getWidth(), this.getHeight());
    SepTitulo.setSize(this.getWidth(), 10);
    BtnGuardar.setLocation(BtnNuevo.getX()+BtnNuevo.getWidth()+espacio, BtnNuevo.getY());
    BtnCancelar.setLocation(BtnGuardar.getX()+BtnGuardar.getWidth()+espacio, BtnNuevo.getY());
    BtnBuscar.setLocation(BtnCancelar.getX()+BtnCancelar.getWidth()+espacio, BtnNuevo.getY());
    BtnModificar.setLocation(BtnBuscar.getX()+BtnBuscar.getWidth()+espacio, BtnNuevo.getY());
    BtnActualizar.setLocation(BtnModificar.getX(), BtnNuevo.getY());
}

void cancelar(){
    TxtIdClase.setText("");
    TxtIdClase.setEnabled(false);
    TxtNombreClase.setText("");
    TxtNombreClase.setEnabled(false);
    TxtCodigo.setText("");
    TxtCodigo.setEnabled(false);
    TxtDescripcion.setText("");
    TxtDescripcion.setEnabled(false);
    TxtUltimoCosto.setText("0");
    TxtUltimoCosto.setEnabled(false);
    CmbEstado.setSelectedIndex(0);
    CmbEstado.setEnabled(false);
    BtnNuevo.setEnabled(true);
    BtnGuardar.setEnabled(false);
    BtnCancelar.setEnabled(false);
    BtnBuscar.setEnabled(true);
    BtnModificar.setEnabled(false);
    BtnActualizar.setVisible(false);
}

void nuevo(){
    TxtIdClase.setEnabled(true);
    TxtCodigo.setEnabled(true);
    TxtDescripcion.setEnabled(true);
    CmbEstado.setEnabled(true);
    BtnNuevo.setEnabled(false);
    BtnGuardar.setEnabled(true);
    BtnCancelar.setEnabled(true);
    BtnBuscar.setEnabled(false);
    BtnModificar.setEnabled(false);
    TxtIdClase.requestFocus();
}

void guardar(){
    if(verificacionCampos.CamposArticulo(TxtIdClase.getText(), TxtCodigo.getText(), TxtDescripcion.getText(), CmbEstado.getSelectedItem().toString()).equals("ok")){
        query = "Select codigo from "+listado.T_Productos+" where codigo = "+TxtCodigo.getText();
        if(!consulta.consulta_existencia(query).equals("")){
            JOptionPane.showMessageDialog(null,"Codigo de Articulo ya se encuentra Registrado","Mensaje Error",JOptionPane.ERROR_MESSAGE);
        }else{
            String campos = "codigo,"
                    + "descripcion,"
                    + "ultimo_costo,"
                    + "id_clase,"
                    + "estado";
            String valores = TxtCodigo.getText()+"',"
                    + "'"+TxtDescripcion.getText()+"',"
                    + "'"+TxtUltimoCosto.getText()+"',"
                    + "'"+TxtIdClase.getText()+"',"
                    + "'"+CmbEstado.getSelectedIndex();
            agregar.agregar(listado.T_Productos, campos, valores);
            cancelar();
        }
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LbArticuloId = new javax.swing.JLabel();
        TxtCodigo = new javax.swing.JTextField();
        TxtIdClase = new javax.swing.JTextField();
        TxtNombreClase = new javax.swing.JTextField();
        TxtDescripcion = new javax.swing.JTextField();
        TxtUltimoCosto = new javax.swing.JTextField();
        CmbEstado = new javax.swing.JComboBox<>();
        LbTitulo = new javax.swing.JLabel();
        SepTitulo = new javax.swing.JSeparator();
        BtnNuevo = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        BtnBuscar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnActualizar = new javax.swing.JButton();
        LbFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel1.setText("Codigo:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 110, 80, 18);

        jLabel2.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel2.setText("Descripción:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 150, 100, 18);

        jLabel3.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel3.setText("Ultimo Costo:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 190, 100, 18);

        jLabel4.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel4.setText("Clase de Producto:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 70, 130, 18);

        jLabel5.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel5.setText("Estado");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(310, 190, 60, 18);
        getContentPane().add(LbArticuloId);
        LbArticuloId.setBounds(370, 0, 34, 14);

        TxtCodigo.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        getContentPane().add(TxtCodigo);
        TxtCodigo.setBounds(140, 110, 170, 21);

        TxtIdClase.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        getContentPane().add(TxtIdClase);
        TxtIdClase.setBounds(140, 70, 40, 21);

        TxtNombreClase.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        getContentPane().add(TxtNombreClase);
        TxtNombreClase.setBounds(190, 70, 200, 21);

        TxtDescripcion.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        getContentPane().add(TxtDescripcion);
        TxtDescripcion.setBounds(140, 150, 370, 21);

        TxtUltimoCosto.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        TxtUltimoCosto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        getContentPane().add(TxtUltimoCosto);
        TxtUltimoCosto.setBounds(140, 190, 140, 21);

        CmbEstado.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        CmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Activo", "Inactivo" }));
        getContentPane().add(CmbEstado);
        CmbEstado.setBounds(360, 190, 120, 21);

        LbTitulo.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        LbTitulo.setText("Creación Articulo");
        getContentPane().add(LbTitulo);
        LbTitulo.setBounds(0, 20, 170, 30);
        getContentPane().add(SepTitulo);
        SepTitulo.setBounds(0, 50, 90, 10);

        BtnNuevo.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        BtnNuevo.setText("Nuevo");
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(BtnNuevo);
        BtnNuevo.setBounds(20, 240, 90, 25);

        BtnGuardar.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        BtnGuardar.setText("Guardar");
        getContentPane().add(BtnGuardar);
        BtnGuardar.setBounds(110, 240, 90, 25);

        BtnCancelar.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        BtnCancelar.setText("Cancelar");
        getContentPane().add(BtnCancelar);
        BtnCancelar.setBounds(200, 240, 90, 25);

        BtnBuscar.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        BtnBuscar.setText("Buscar");
        getContentPane().add(BtnBuscar);
        BtnBuscar.setBounds(290, 240, 90, 25);

        BtnModificar.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        BtnModificar.setText("Modificar");
        getContentPane().add(BtnModificar);
        BtnModificar.setBounds(380, 240, 90, 25);

        BtnActualizar.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        BtnActualizar.setText("Actualizar");
        getContentPane().add(BtnActualizar);
        BtnActualizar.setBounds(400, 260, 90, 25);
        getContentPane().add(LbFondo);
        LbFondo.setBounds(0, 0, 0, 0);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        nuevo();
    }//GEN-LAST:event_BtnNuevoActionPerformed


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
            java.util.logging.Logger.getLogger(DlogInterfaceArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlogInterfaceArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlogInterfaceArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlogInterfaceArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlogInterfaceArticulos dialog = new DlogInterfaceArticulos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JComboBox<String> CmbEstado;
    private javax.swing.JLabel LbArticuloId;
    private javax.swing.JLabel LbFondo;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JSeparator SepTitulo;
    private javax.swing.JTextField TxtCodigo;
    private javax.swing.JTextField TxtDescripcion;
    private javax.swing.JTextField TxtIdClase;
    private javax.swing.JTextField TxtNombreClase;
    private javax.swing.JTextField TxtUltimoCosto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
