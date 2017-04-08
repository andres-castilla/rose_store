package FormulariosExternos;

import Clases.*;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.table.*;

public class DlogInterfaceListaPrecio extends javax.swing.JDialog {

    C_CargarImagenes img = new C_CargarImagenes();
    C_Consultas consulta = new C_Consultas();
    C_VerificarCampos verificacionCampos = new C_VerificarCampos();
    C_Listado listado = new C_Listado();
    C_Actualizar actualizar = new C_Actualizar();
    DefaultTableModel model;
    String query;
    Integer i;

    public DlogInterfaceListaPrecio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        parametrizacion();
    }

    void parametrizacion() {
        sizeItem();
        opCancelar();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        LbFondo.setIcon(img.FondoHome(LbFondo.getWidth(), LbFondo.getHeight()));
        LbBuscar.setIcon(img.IconoBuscar(LbBuscar.getWidth(), LbBuscar.getHeight()));
        TxtIdClase.setBackground(listado.colorBusqueda);
    }

    void sizeItem() {
        sizeTable();
        this.setSize(500, 480);
        LbFondo.setSize(this.getWidth(), this.getHeight());
        LbBuscar.setSize(40, 40);
        ScrollTabla.setSize(this.getWidth() - 30, 250);
        BtnCancelar.setLocation(100, ScrollTabla.getY() + ScrollTabla.getHeight() + 10);
        BtnActualizar.setLocation(BtnCancelar.getX() + BtnCancelar.getWidth() + 80, BtnCancelar.getY());
    }

    public void sizeTable() {
        String[] titles = {"id", "Codigo", "Descripcion", "Costo Unit.", "%", "Precio Venta Unit"};
        model = new DefaultTableModel(null, titles);
        TablaListaPrecio.setModel(model);
        //SE ESTABLECE EL TAMAÑO DE LAS COLUMNAS
        Integer[] size = {40, 130, 50, 20, 70};
        for (i = 1; i < titles.length; i++) {
            TablaListaPrecio.getColumnModel().getColumn(i).setPreferredWidth(size[(i - 1)]);
        }
        TablaListaPrecio.getColumnModel().getColumn(0).setResizable(false);
        TablaListaPrecio.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaListaPrecio.getColumnModel().getColumn(0).setMinWidth(0);
        TablaListaPrecio.getColumnModel().getColumn(0).setPreferredWidth(0);
        //TablaListaPrecio.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //SE CENTRAN LOS TITULOS DE LA TABLA
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (i = 1; i < titles.length; i++) {
            TablaListaPrecio.getColumnModel().getColumn(i).setHeaderRenderer(tcr);
        }
        //SE ESTABLECE UBICACION DEL TEXTO EN LAS DIFERENTES FILAS DE LA TABLA
        DefaultTableCellRenderer tcr2 = new DefaultTableCellRenderer();
        tcr2.setHorizontalAlignment(SwingConstants.RIGHT);
        for (i = 3; i < titles.length; i++) {
            TablaListaPrecio.getColumnModel().getColumn(i).setCellRenderer(tcr2);
        }
        TablaListaPrecio.getTableHeader().setReorderingAllowed(false);//SE BLOQUEA QUE NO SE PUEDAN MOVER LAS COLUMNAS
        TablaListaPrecio.setRowHeight(20);//ANCHO DE FILA
//        String[] aa = {};
//        model.addRow(aa);
    }

    void opCancelar() {
        TxtIdClase.setText("");
        TxtNombreClase.setText("");
        TxtNombreClase.setEnabled(false);
        limpiarTabla();
    }

    void limpiarTabla() {
        int cantfilasBorrar = TablaListaPrecio.getRowCount();
        for (i = 0; i < cantfilasBorrar; i++) {
            model.removeRow(0);
        }
    }

    void buscarClase(String idclase) {
        if (!idclase.equals("0")) {
            String campo = "descripcion";
            query = "Select " + campo + " from " + listado.T_ClaseProductos + " Where id = " + idclase + " and estado = 1";
            String[] datosClase = consulta.consulta_existencia(query, campo.length(), campo);
            TxtNombreClase.setText(datosClase[0]);
        }
    }

    void buscarTodoArticulo() {
        query = "select count(id) as filas from " + listado.T_Productos + " where estado = '1';";
        String[] filas = consulta.consulta_existencia(query, 1, "filas");
        int cantfilas = Integer.parseInt(filas[0]);
        if (cantfilas > 0) {
            query = "Select p.id, p.codigo, p.descripcion, p.ultimo_costo, lp.margen_venta, lp.precio_venta"
                    + " From " + listado.T_Productos + " p, " + listado.T_ListaPrecio + " lp"
                    + " Where lp.id_producto = p.id and p.estado = '1';";
            String[] campos = {"id", "codigo", "descripcion", "ultimo_costo", "margen_venta", "precio_venta"};
            String[][] datosConsulta = consulta.consulta_existencia(query, cantfilas, campos.length, campos);
            String[] fila = new String[campos.length];
            //limpiarTabla();
            for (i = 0; i < cantfilas; i++) {
                for (int j = 0; j < campos.length; j++) {
                    fila[j] = datosConsulta[i][j];
                }
                model.addRow(fila);
            }
        }
    }

    void buscarArticulo(String idclase) {
        if (!idclase.equals("")) {
            query = "select count(id) as filas from " + listado.T_Productos + " where id_clase = '" + idclase + "' and estado = '1';";
            String[] filas = consulta.consulta_existencia(query, 1, "filas");
            int cantfilas = Integer.parseInt(filas[0]);
            if (cantfilas > 0) {
                query = "Select p.id, p.codigo, p.descripcion, p.ultimo_costo, lp.margen_venta, lp.precio_venta"
                        + " From " + listado.T_Productos + " p, " + listado.T_ListaPrecio + " lp"
                        + " Where lp.id_producto = p.id and p.id_clase = '" + idclase + "' and p.estado = '1';";
                String[] campos = {"id", "codigo", "descripcion", "ultimo_costo", "margen_venta", "precio_venta"};
                String[][] datosConsulta = consulta.consulta_existencia(query, cantfilas, campos.length, campos);
                String[] fila = new String[campos.length];
                for (i = 0; i < cantfilas; i++) {
                    for (int j = 0; j < campos.length; j++) {
                        fila[j] = datosConsulta[i][j];
                    }
                    model.addRow(fila);
                }
            }
        }
    }

    void consultar() {
        limpiarTabla();
        if (RBtnTodos.isSelected()) {
            buscarTodoArticulo();
        } else if (RBtnSeleccionarClase.isSelected()) {
            buscarArticulo(TxtIdClase.getText());
        }
    }

    void calcularPrecioVenta(Integer fila) {
        if (TablaListaPrecio.getRowCount() > 0 && TablaListaPrecio.getSelectedRow() >= 0) {
            if (!TablaListaPrecio.getValueAt(fila, 4).equals("0")) {
                int margen = Integer.parseInt(TablaListaPrecio.getValueAt(fila, 4).toString());
                int costounit = Integer.parseInt(TablaListaPrecio.getValueAt(fila, 3).toString());
                int precioventa = margen * costounit;//se monta codigo calculo precio
                TablaListaPrecio.setValueAt(String.valueOf(precioventa), fila, 5);
            }
        }
    }

    void actualizar() {
        if (TablaListaPrecio.getRowCount() > 0) {
            String respuesta = "";
            int cantidadfilas = TablaListaPrecio.getRowCount();
            for (i = 0; i < cantidadfilas; i++) {
                query = "Update"
                        + " " + listado.T_ListaPrecio
                        + " Set"
                        + " margen_venta = '" + TablaListaPrecio.getValueAt(i, 4) + "',"
                        + " precio_venta = '" + TablaListaPrecio.getValueAt(i, 5) + "'"
                        + " Where id_producto = '" + TablaListaPrecio.getValueAt(i, 0) + "';";
                respuesta = actualizar.update(query);
                if (respuesta.equals("no")) {
                    i = cantidadfilas;
                    JOptionPane.showMessageDialog(null,"Error Margen de Venta\n"
                            + "Nombre: "+TablaListaPrecio.getValueAt(i, 2));
                }
            }
            if (respuesta.equals("ok")) {
                JOptionPane.showMessageDialog(null, "Listado Actualizado con Exito", "Mensaje Información", JOptionPane.INFORMATION_MESSAGE);
                opCancelar();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        TxtIdClase = new javax.swing.JTextField();
        TxtNombreClase = new javax.swing.JTextField();
        ScrollTabla = new javax.swing.JScrollPane();
        TablaListaPrecio = new javax.swing.JTable();
        LbTitulo = new javax.swing.JLabel();
        SepTitulo = new javax.swing.JSeparator();
        BtnCancelar = new javax.swing.JButton();
        BtnActualizar = new javax.swing.JButton();
        LbBuscar = new javax.swing.JLabel();
        RBtnTodos = new javax.swing.JRadioButton();
        RBtnSeleccionarClase = new javax.swing.JRadioButton();
        LbIdClase = new javax.swing.JLabel();
        LbFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

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
        TxtIdClase.setBounds(160, 100, 40, 20);
        getContentPane().add(TxtNombreClase);
        TxtNombreClase.setBounds(210, 100, 240, 20);

        TablaListaPrecio = new javax.swing.JTable(){
            public boolean isCellEditable(int rows, int colum){
                if(colum==4)
                return true;
                return false;
            }
        };
        TablaListaPrecio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        TablaListaPrecio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TablaListaPrecioPropertyChange(evt);
            }
        });
        ScrollTabla.setViewportView(TablaListaPrecio);

        getContentPane().add(ScrollTabla);
        ScrollTabla.setBounds(10, 150, 420, 280);

        LbTitulo.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        LbTitulo.setText("Lista de Precio");
        getContentPane().add(LbTitulo);
        LbTitulo.setBounds(0, 20, 410, 30);
        getContentPane().add(SepTitulo);
        SepTitulo.setBounds(0, 50, 90, 10);

        BtnCancelar.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnCancelar);
        BtnCancelar.setBounds(90, 440, 90, 25);

        BtnActualizar.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        BtnActualizar.setText("Actualizar");
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnActualizar);
        BtnActualizar.setBounds(260, 440, 90, 25);

        LbBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LbBuscarMouseClicked(evt);
            }
        });
        getContentPane().add(LbBuscar);
        LbBuscar.setBounds(390, 50, 50, 40);

        buttonGroup1.add(RBtnTodos);
        RBtnTodos.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        RBtnTodos.setText("Todos");
        RBtnTodos.setOpaque(false);
        getContentPane().add(RBtnTodos);
        RBtnTodos.setBounds(20, 60, 65, 27);

        buttonGroup1.add(RBtnSeleccionarClase);
        RBtnSeleccionarClase.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        RBtnSeleccionarClase.setText("Seleccionar Clase");
        RBtnSeleccionarClase.setOpaque(false);
        RBtnSeleccionarClase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBtnSeleccionarClaseActionPerformed(evt);
            }
        });
        getContentPane().add(RBtnSeleccionarClase);
        RBtnSeleccionarClase.setBounds(20, 100, 140, 27);

        LbIdClase.setText("0");
        LbIdClase.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                LbIdClasePropertyChange(evt);
            }
        });
        getContentPane().add(LbIdClase);
        LbIdClase.setBounds(400, 0, 20, 14);
        getContentPane().add(LbFondo);
        LbFondo.setBounds(0, 0, 0, 0);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        opCancelar();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void TxtIdClaseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtIdClaseKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            DlogBusquedaClaseArticulos buscarClase = new DlogBusquedaClaseArticulos(new javax.swing.JFrame(), true);
            buscarClase.LbNombreFormulario.setText("lista");
            buscarClase.setVisible(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            consultar();
        }
    }//GEN-LAST:event_TxtIdClaseKeyPressed

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

    private void TxtIdClaseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtIdClaseKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_TxtIdClaseKeyTyped

    private void LbIdClasePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_LbIdClasePropertyChange
        if (!LbIdClase.getText().equals("0")) {
            buscarClase(LbIdClase.getText());
            TxtIdClase.setText(LbIdClase.getText());
        }
    }//GEN-LAST:event_LbIdClasePropertyChange

    private void LbBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbBuscarMouseClicked
        consultar();
    }//GEN-LAST:event_LbBuscarMouseClicked

    private void RBtnSeleccionarClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBtnSeleccionarClaseActionPerformed
        if (RBtnSeleccionarClase.isSelected()) {
            TxtIdClase.requestFocus();
        }
    }//GEN-LAST:event_RBtnSeleccionarClaseActionPerformed

    private void TablaListaPrecioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TablaListaPrecioPropertyChange
        calcularPrecioVenta(TablaListaPrecio.getSelectedRow());
    }//GEN-LAST:event_TablaListaPrecioPropertyChange

    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarActionPerformed
        actualizar();
    }//GEN-LAST:event_BtnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JLabel LbBuscar;
    private javax.swing.JLabel LbFondo;
    public static javax.swing.JLabel LbIdClase;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JRadioButton RBtnSeleccionarClase;
    private javax.swing.JRadioButton RBtnTodos;
    private javax.swing.JScrollPane ScrollTabla;
    private javax.swing.JSeparator SepTitulo;
    private javax.swing.JTable TablaListaPrecio;
    private javax.swing.JTextField TxtIdClase;
    private javax.swing.JTextField TxtNombreClase;
    private javax.swing.ButtonGroup buttonGroup1;
    // End of variables declaration//GEN-END:variables

}
