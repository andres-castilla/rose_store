package FormulariosExternos;

import Clases.*;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class DlogInterfaceArticulos extends javax.swing.JDialog {

    C_CargarImagenes img = new C_CargarImagenes();
    C_Listado listado = new C_Listado();
    C_VerificarCampos verificacionCampos = new C_VerificarCampos();
    C_Consultas consulta = new C_Consultas();
    C_Agregar agregar = new C_Agregar();
    C_Actualizar actualizar = new C_Actualizar();
    Integer estado;
    String query;

    public DlogInterfaceArticulos(java.awt.Frame parent, boolean modal) {
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
        TxtIdClase.setBackground(listado.colorBusqueda);
    }

    void sizeItem() {
        int espacio = 10;
        this.setSize(550, 320);
        LbFondo.setSize(this.getWidth(), this.getHeight());
        SepTitulo.setSize(this.getWidth(), 10);
        BtnGuardar.setLocation(BtnNuevo.getX() + BtnNuevo.getWidth() + espacio, BtnNuevo.getY());
        BtnCancelar.setLocation(BtnGuardar.getX() + BtnGuardar.getWidth() + espacio, BtnNuevo.getY());
        BtnBuscar.setLocation(BtnCancelar.getX() + BtnCancelar.getWidth() + espacio, BtnNuevo.getY());
        BtnModificar.setLocation(BtnBuscar.getX() + BtnBuscar.getWidth() + espacio, BtnNuevo.getY());
        BtnActualizar.setLocation(BtnModificar.getX(), BtnNuevo.getY());
    }

    void opCancelar() {
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
        BtnModificar.setVisible(true);
        BtnActualizar.setVisible(false);
        LbIdClase.setText("0");
        LbId.setText("0");
        LbIdArticulo.setText("0");
    }

    void opNuevo() {
        opCancelar();
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

    void opModificar() {
        TxtIdClase.setEnabled(true);
        TxtDescripcion.setEnabled(true);
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

    void consecutivoId() {
        query = "Select count(id) as filas From " + listado.T_Productos + ";";
        String[] datoBusqueda = consulta.consulta_existencia(query, 1, "filas");
        int nuevoId = Integer.parseInt(datoBusqueda[0]) + 1;
        LbId.setText(String.valueOf(nuevoId));
    }

    void buscarClase(String idclase) {
        if (!idclase.equals("0")) {
            String campo = "descripcion";
            query = "Select " + campo + " from " + listado.T_ClaseProductos + " Where id = " + idclase + " and estado = 1";
            String[] datosClase = consulta.consulta_existencia(query, campo.length(), campo);
            TxtNombreClase.setText(datosClase[0]);
            TxtCodigo.requestFocus();
        }
    }

    void buscarArticulo(String idarticulo) {
        if (!idarticulo.equals("0")) {
            query = "Select * from " + listado.T_Productos + " Where id = '" + idarticulo + "';";
            String[] campos = {"codigo", "descripcion", "ultimo_costo", "id_clase", "estado"};
            String[] datosArticulo = consulta.consulta_existencia(query, campos.length, campos);
            TxtCodigo.setText(datosArticulo[0]);
            TxtDescripcion.setText(datosArticulo[1]);
            TxtUltimoCosto.setText(datosArticulo[2]);
            TxtIdClase.setText(datosArticulo[3]);
            LbIdClase.setText(datosArticulo[3]);
            if (datosArticulo[4].equals("0")) {
                CmbEstado.setSelectedIndex(2);
            } else {
                CmbEstado.setSelectedIndex(1);
            }
            BtnModificar.setEnabled(true);
        }
    }

    void guardar() {
        if (verificacionCampos.CamposArticulo(TxtIdClase.getText(), TxtCodigo.getText(), TxtDescripcion.getText(), CmbEstado.getSelectedItem().toString()).equals("ok")) {
            query = "Select codigo from " + listado.T_Productos + " where codigo = '" + TxtCodigo.getText() + "'";
            if (!consulta.consulta_existencia(query).equals("")) {
                JOptionPane.showMessageDialog(null, "Codigo de Articulo ya se encuentra Registrado", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
            } else {
                estados();
                String campos = "codigo,"
                        + "descripcion,"
                        + "ultimo_costo,"
                        + "id_clase,"
                        + "estado";
                String valores = TxtCodigo.getText() + "',"
                        + "'" + TxtDescripcion.getText() + "',"
                        + "'" + TxtUltimoCosto.getText() + "',"
                        + "'" + TxtIdClase.getText() + "',"
                        + "'" + estado;
                String respuesta = agregar.agregar(listado.T_Productos, campos, valores);
                if (respuesta.equals("ok")) {
                    respuesta = "";
                    campos = "id_producto,margen_venta,precio_venta";
                    valores = LbId.getText() + "','0','0";
                    respuesta = agregar.agregar(listado.T_ListaPrecio, campos, valores);
                    if (respuesta.equals("ok")) {
                        JOptionPane.showMessageDialog(null, "Registro Agregado con Exito");
                        opCancelar();
                    }
                }
            }
        }
    }

    void actualizar(String idarticulo) {
        estados();
        query = "Update"
                + " " + listado.T_Productos
                + " Set"
                + " descripcion = '" + TxtDescripcion.getText() + "',"
                + " id_clase = '" + TxtIdClase.getText() + "',"
                + " estado = '" + estado + "'"
                + " where id = '" + idarticulo + "';";
        String respuesta = actualizar.update(query);
        if (respuesta.equals("ok")) {
            JOptionPane.showMessageDialog(null, "Registro Actualizado con Exito");
            opCancelar();
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
        LbId = new javax.swing.JLabel();
        LbIdClase = new javax.swing.JLabel();
        LbIdArticulo = new javax.swing.JLabel();

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
        jLabel4.setBounds(20, 70, 120, 18);

        jLabel5.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel5.setText("Estado");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(310, 190, 60, 18);

        TxtCodigo.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        getContentPane().add(TxtCodigo);
        TxtCodigo.setBounds(140, 110, 170, 21);

        TxtIdClase.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        TxtIdClase.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtIdClaseKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtIdClaseKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtIdClaseKeyTyped(evt);
            }
        });
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
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnGuardar);
        BtnGuardar.setBounds(110, 240, 90, 25);

        BtnCancelar.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnCancelar);
        BtnCancelar.setBounds(200, 240, 90, 25);

        BtnBuscar.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnBuscar);
        BtnBuscar.setBounds(290, 240, 90, 25);

        BtnModificar.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        BtnModificar.setText("Modificar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnModificar);
        BtnModificar.setBounds(380, 240, 90, 25);

        BtnActualizar.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        BtnActualizar.setText("Actualizar");
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnActualizar);
        BtnActualizar.setBounds(400, 260, 90, 25);
        getContentPane().add(LbFondo);
        LbFondo.setBounds(0, 0, 0, 0);

        LbId.setText("0");
        getContentPane().add(LbId);
        LbId.setBounds(470, 0, 6, 14);

        LbIdClase.setText("0");
        LbIdClase.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                LbIdClasePropertyChange(evt);
            }
        });
        getContentPane().add(LbIdClase);
        LbIdClase.setBounds(420, 0, 20, 20);

        LbIdArticulo.setText("0");
        LbIdArticulo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                LbIdArticuloPropertyChange(evt);
            }
        });
        getContentPane().add(LbIdArticulo);
        LbIdArticulo.setBounds(370, 0, 34, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        opNuevo();
        consecutivoId();
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void LbIdClasePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_LbIdClasePropertyChange
        if (!LbIdClase.getText().equals("0")) {
            buscarClase(LbIdClase.getText());
            TxtIdClase.setText(LbIdClase.getText());
        }
    }//GEN-LAST:event_LbIdClasePropertyChange

    private void TxtIdClaseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtIdClaseKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_TxtIdClaseKeyTyped

    private void TxtIdClaseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtIdClaseKeyReleased
        if (TxtIdClase.getText().isEmpty()) {
            LbIdClase.setText("0");
            TxtNombreClase.setText("");
        } else {
            String idclase = "";
            idclase += TxtIdClase.getText();
            LbIdClase.setText(idclase);
        }

    }//GEN-LAST:event_TxtIdClaseKeyReleased

    private void TxtIdClaseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtIdClaseKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            DlogBusquedaClaseArticulos buscarClase = new DlogBusquedaClaseArticulos(new javax.swing.JFrame(), true);
            buscarClase.LbNombreFormulario.setText("articulo");
            buscarClase.setVisible(true);
        }

    }//GEN-LAST:event_TxtIdClaseKeyPressed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void LbIdArticuloPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_LbIdArticuloPropertyChange
        if (!LbIdArticulo.getText().equals("0")) {
            buscarArticulo(LbIdArticulo.getText());
        }
    }//GEN-LAST:event_LbIdArticuloPropertyChange

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        DlogBusquedaArticulos buscarArticulo = new DlogBusquedaArticulos(new javax.swing.JFrame(), true);
        buscarArticulo.LbNombreFormulario.setText("articulo");
        buscarArticulo.setVisible(true);
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        opModificar();
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarActionPerformed
        actualizar(LbIdArticulo.getText());
    }//GEN-LAST:event_BtnActualizarActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        opCancelar();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JComboBox<String> CmbEstado;
    private javax.swing.JLabel LbFondo;
    private javax.swing.JLabel LbId;
    public static javax.swing.JLabel LbIdArticulo;
    public static javax.swing.JLabel LbIdClase;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JSeparator SepTitulo;
    private javax.swing.JTextField TxtCodigo;
    private javax.swing.JTextField TxtDescripcion;
    public static javax.swing.JTextField TxtIdClase;
    private javax.swing.JTextField TxtNombreClase;
    private javax.swing.JTextField TxtUltimoCosto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
