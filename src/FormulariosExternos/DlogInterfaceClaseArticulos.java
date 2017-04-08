package FormulariosExternos;

import Clases.*;
import javax.swing.JOptionPane;

public class DlogInterfaceClaseArticulos extends javax.swing.JDialog {

    C_CargarImagenes img = new C_CargarImagenes();
    C_Listado listado = new C_Listado();
    C_VerificarCampos verificarCampos = new C_VerificarCampos();
    C_Consultas consulta = new C_Consultas();
    C_Agregar agregar = new C_Agregar();
    C_Actualizar actualizar = new C_Actualizar();
    Integer estado;
    String query;

    public DlogInterfaceClaseArticulos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        parametrosIniciales();
    }

    void parametrosIniciales() {
        sizeItem();
        opCancelar();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        LbFondo.setIcon(img.FondoHome(LbFondo.getWidth(), LbFondo.getHeight()));

    }

    void sizeItem() {
        int espacio = 10;
        this.setSize(530, 220);
        LbFondo.setSize(this.getWidth(), this.getHeight());
        SepTitulo.setSize(this.getWidth(), 10);
        BtnGuardar.setLocation(BtnNuevo.getX() + BtnNuevo.getWidth() + espacio, BtnNuevo.getY());
        BtnCancelar.setLocation(BtnGuardar.getX() + BtnGuardar.getWidth() + espacio, BtnNuevo.getY());
        BtnBuscar.setLocation(BtnCancelar.getX() + BtnCancelar.getWidth() + espacio, BtnNuevo.getY());
        BtnModificar.setLocation(BtnBuscar.getX() + BtnBuscar.getWidth() + espacio, BtnNuevo.getY());
        BtnActualizar.setLocation(BtnModificar.getX(), BtnNuevo.getY());
    }

    void opCancelar() {
        TxtNombreClase.setText("");
        TxtNombreClase.setEnabled(false);
        CmbEstado.setSelectedIndex(0);
        CmbEstado.setEnabled(false);
        BtnNuevo.setEnabled(true);
        BtnGuardar.setEnabled(false);
        BtnCancelar.setEnabled(false);
        BtnBuscar.setEnabled(true);
        BtnModificar.setEnabled(false);
        BtnModificar.setVisible(true);
        BtnActualizar.setVisible(false);
        LbIdClase.setText("0");
    }

    void opNuevo() {
        opCancelar();
        TxtNombreClase.setEnabled(true);
        CmbEstado.setEnabled(true);
        BtnNuevo.setEnabled(false);
        BtnGuardar.setEnabled(true);
        BtnCancelar.setEnabled(true);
        BtnBuscar.setEnabled(false);
        BtnModificar.setEnabled(false);
        TxtNombreClase.requestFocus();
    }
    
    void opModificar(){
        TxtNombreClase.setEnabled(true);
        CmbEstado.setEnabled(true);
        BtnNuevo.setEnabled(false);
        BtnBuscar.setEnabled(false);
        BtnCancelar.setEnabled(true);
        BtnModificar.setEnabled(false);
        BtnModificar.setVisible(false);
        BtnActualizar.setEnabled(true);
        BtnActualizar.setVisible(true);
    }

    void estados() {
        if (CmbEstado.getSelectedItem().equals("Activo")) {
            estado = 1;
        } else {
            estado = 0;
        }
    }

    void agregar() {
        if (verificarCampos.CamposClaseArticulos(TxtNombreClase.getText(), CmbEstado.getSelectedItem().toString()).equals("ok")) {
            estados();
            String campos
                    = "descripcion,"
                    + "estado";
            String valores
                    = TxtNombreClase.getText() + "',"
                    + "'" + estado;
            String respuesta = agregar.agregar(listado.T_ClaseProductos, campos, valores);
            if (respuesta.equals("ok")) {
                JOptionPane.showMessageDialog(null, "Registro Agregado con Exito");
                opCancelar();
            }
        }
    }

    void buscar(String idclase) {
        if (!idclase.equals("0")) {
            query = "Select * from " + listado.T_ClaseProductos + " where id = '" + idclase + "';";
            String[] campos = {"descripcion", "estado"};
            String[] datosClase = consulta.consulta_existencia(query, campos.length, campos);
            TxtNombreClase.setText(datosClase[0]);
            if(datosClase[1].equals("0")){
                CmbEstado.setSelectedIndex(2);
            }else{
                CmbEstado.setSelectedIndex(1);
            }
            BtnModificar.setEnabled(true);
        }
    }
    
    void actualizar(String idclase){
        estados();
        query = "Update"
                + " "+listado.T_ClaseProductos
                + " Set"
                + " descripcion = '"+TxtNombreClase.getText()+"',"
                + " estado = '"+estado+"'"
                + " where id = '"+idclase+"';";
        String respuesta = actualizar.update(query);
            if (respuesta.equals("ok")) {
                JOptionPane.showMessageDialog(null, "Registro Actualizado con Exito");
                opCancelar();
            }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LbTitulo = new javax.swing.JLabel();
        SepTitulo = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtNombreClase = new javax.swing.JTextField();
        CmbEstado = new javax.swing.JComboBox<>();
        BtnNuevo = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        BtnBuscar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnActualizar = new javax.swing.JButton();
        LbFondo = new javax.swing.JLabel();
        LbIdClase = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        LbTitulo.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        LbTitulo.setText("Creación Clase de Articulos");
        getContentPane().add(LbTitulo);
        LbTitulo.setBounds(0, 20, 410, 30);
        getContentPane().add(SepTitulo);
        SepTitulo.setBounds(0, 50, 90, 10);

        jLabel1.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel1.setText("Nombre Clase:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 80, 100, 18);

        jLabel2.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel2.setText("Estado:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 110, 90, 18);

        TxtNombreClase.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        TxtNombreClase.setText("jTextField1");
        getContentPane().add(TxtNombreClase);
        TxtNombreClase.setBounds(130, 80, 310, 21);

        CmbEstado.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        CmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Activo", "Inactivo" }));
        getContentPane().add(CmbEstado);
        CmbEstado.setBounds(130, 110, 130, 21);

        BtnNuevo.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        BtnNuevo.setText("Nuevo");
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(BtnNuevo);
        BtnNuevo.setBounds(10, 150, 90, 25);

        BtnGuardar.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        BtnGuardar.setText("Guardar");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnGuardar);
        BtnGuardar.setBounds(100, 150, 90, 25);

        BtnCancelar.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnCancelar);
        BtnCancelar.setBounds(190, 150, 90, 25);

        BtnBuscar.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnBuscar);
        BtnBuscar.setBounds(280, 150, 90, 25);

        BtnModificar.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        BtnModificar.setText("Modificar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnModificar);
        BtnModificar.setBounds(370, 150, 90, 25);

        BtnActualizar.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        BtnActualizar.setText("Actualizar");
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnActualizar);
        BtnActualizar.setBounds(390, 170, 90, 25);
        getContentPane().add(LbFondo);
        LbFondo.setBounds(0, 0, 0, 0);

        LbIdClase.setText("0");
        LbIdClase.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                LbIdClasePropertyChange(evt);
            }
        });
        getContentPane().add(LbIdClase);
        LbIdClase.setBounds(460, 0, 20, 10);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        opNuevo();
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        opCancelar();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        agregar();
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void LbIdClasePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_LbIdClasePropertyChange
        buscar(LbIdClase.getText());
    }//GEN-LAST:event_LbIdClasePropertyChange

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        DlogBusquedaClaseArticulos busqueda = new DlogBusquedaClaseArticulos(new javax.swing.JFrame(), true);
        busqueda.LbNombreFormulario.setText("clase");
        busqueda.setVisible(true);
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarActionPerformed
        actualizar(LbIdClase.getText());
    }//GEN-LAST:event_BtnActualizarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        opModificar();
    }//GEN-LAST:event_BtnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JComboBox<String> CmbEstado;
    private javax.swing.JLabel LbFondo;
    public static javax.swing.JLabel LbIdClase;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JSeparator SepTitulo;
    private javax.swing.JTextField TxtNombreClase;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
