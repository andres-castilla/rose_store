package FormulariosExternos;

import Clases.*;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.table.*;

public class DlogBusquedaAlmacen extends javax.swing.JDialog {

    C_Listado listado = new C_Listado();
    C_Consultas consulta = new C_Consultas();
    DefaultTableModel model;
    Integer i;
    String[] query = new String[2];
    String[] titulos;
    String[][] datosConsulta = null;

    public DlogBusquedaAlmacen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        parametrosIniciales();
    }

    void parametrosIniciales() {
        sizeItem();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        RBotonOpTodos.setSelected(true);
    }

    void sizeItem() {
        this.setSize(500, 450);
        sizeTable();
    }

    public void sizeTable() {
        String[] titles = {"id", "Descripcion"};
        titulos = titles;
        model = new DefaultTableModel(null, titles);
        TablaResultadoBusqueda.setModel(model);
        //SE ESTABLECE EL TAMAÑO DE LAS COLUMNAS
        Integer[] size = {300};
        for (i = 1; i < titles.length; i++) {
            TablaResultadoBusqueda.getColumnModel().getColumn(i).setPreferredWidth(size[(i - 1)]);
        }
        TablaResultadoBusqueda.getColumnModel().getColumn(0).setResizable(false);
        TablaResultadoBusqueda.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaResultadoBusqueda.getColumnModel().getColumn(0).setMinWidth(0);
        TablaResultadoBusqueda.getColumnModel().getColumn(0).setPreferredWidth(0);
        TablaResultadoBusqueda.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //SE CENTRAN LOS TITULOS DE LA TABLA
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (i = 1; i < titles.length; i++) {
            TablaResultadoBusqueda.getColumnModel().getColumn(i).setHeaderRenderer(tcr);
        }
        //SE ESTABLECE UBICACION DEL TEXTO EN LAS DIFERENTES FILAS DE LA TABLA
//        DefaultTableCellRenderer tcr2 = new DefaultTableCellRenderer();
//        tcr2.setHorizontalAlignment(SwingConstants.RIGHT);
//        for (i = 0; i < columnasUbicar.length; i++) {
//            TablaResultadoBusqueda.getColumnModel().getColumn(columnasUbicar[i]).setCellRenderer(tcr2);
//        }
        TablaResultadoBusqueda.getTableHeader().setReorderingAllowed(false);//SE BLOQUEA QUE NO SE PUEDAN MOVER LAS COLUMNAS
        TablaResultadoBusqueda.setRowHeight(20);//ANCHO DE FILA
//        String[] aa = {};
//        model.addRow(aa);
    }

    void seleccionOpcion() {
        CmbCampoBuscar.removeAllItems();
        if (RBotonOpTodos.isSelected()) {
            CmbCampoBuscar.setVisible(false);
            TxtDatoBusqueda.setVisible(false);
            consultaDatos();
        } else if (RBotonOpEspecifica.isSelected()) {
            for (i = 1; i < titulos.length; i++) {
                CmbCampoBuscar.addItem(titulos[i]);
            }
            CmbCampoBuscar.setVisible(true);
            TxtDatoBusqueda.setVisible(true);
            TxtDatoBusqueda.setText("");
            TxtDatoBusqueda.requestFocus();
        }
    }

    void limpiarTabla() {
        int cantFilasBorrar = TablaResultadoBusqueda.getRowCount();
        for (i = 0; i < cantFilasBorrar; i++) {
            model.removeRow(0);
        }
    }

    void consultaDatos() {
        if (LbNombreFormulario.equals("almacen")) {
            query[0] = "select count(id) as filas from " + listado.T_Almacenes + ";";
            query[1] = "Select * from " + listado.T_Almacenes + ";";
        } else {
            query[0] = "select count(id) as filas from " + listado.T_Almacenes + " Where estado = '1';";
            query[1] = "Select * from " + listado.T_Almacenes + " Where estado = '1';";
        }
        //query = "select count(id) as filas from " + listado.T_Almacenes + " Where estado = '1';";
        String[] filas = consulta.consulta_existencia(query[0], 1, "filas");
        int cantfilas = Integer.parseInt(filas[0]);
        if (cantfilas > 0) {
            //query = "Select * from " + listado.T_Almacenes + " Where estado = '1';";
            String[] campos = {"id", "descripcion"};
            datosConsulta = consulta.consulta_existencia(query[1], cantfilas, campos.length, campos);
            String[] fila = new String[campos.length];
            limpiarTabla();
            for (i = 0; i < cantfilas; i++) {
                for (int j = 0; j < campos.length; j++) {
                    fila[j] = datosConsulta[i][j];
                }
                model.addRow(fila);
            }
        }
    }

    void busquedaArticuloEspecifica(String campo, String textobuscar) {
        if (LbNombreFormulario.equals("almacen")) {
            query[0] = "select count(id) as filas from " + listado.T_Almacenes + " where " + campo + " like '" + textobuscar + "%';";
            query[1] = "Select * from " + listado.T_Almacenes + " where " + campo + " like '" + textobuscar + "%';";
        } else {
            query[0] = "select count(id) as filas from " + listado.T_Almacenes + " where " + campo + " like '" + textobuscar + "%'" + " and estado = '1';";
            query[1] = "select * from " + listado.T_Almacenes + " where " + campo + " like '" + textobuscar + "%'" + " and estado = '1';";
        }
        if (campo.equals("Seleccionar")) {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar un Parametro de Busqueda");
        } else {
            //query = "select count(id) as filas from " + listado.T_Almacenes + " where " + campo + " like '" + textobuscar + "%'" + " Where estado = '1';";
            String[] filas = consulta.consulta_existencia(query[0], 1, "filas");
            int cantfilas = Integer.parseInt(filas[0]);
            //query = "select * from " + listado.T_ClaseProductos + " where " + campo + " like '" + textobuscar + "%'" + " Where estado = '1';";
            String[] campos = {"id", "descripcion"};
            datosConsulta = consulta.consulta_existencia(query[1], cantfilas, campos.length, campos);
            String[] fila = new String[campos.length];
            limpiarTabla();
            for (i = 0; i < cantfilas; i++) {
                for (int j = 0; j < campos.length; j++) {
                    fila[j] = datosConsulta[i][j];
                }
                model.addRow(fila);
            }
        }
    }

    void seleccion() {
        if (TablaResultadoBusqueda.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar una fila", "Mensaje Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int fila = TablaResultadoBusqueda.getSelectedRow();
            String id = TablaResultadoBusqueda.getValueAt(fila, 0).toString();
            if (LbNombreFormulario.getText().equals("fv")) {
                DlogInterfacesFacturaVenta.LbIdAlmacen.setText(id);
                dispose();
            } else if (LbNombreFormulario.getText().equals("fc")) {
                DlogInterfacesFacturaCompra.LbIdAlmacen.setText(id);
                dispose();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaResultadoBusqueda = new javax.swing.JTable();
        CmbCampoBuscar = new javax.swing.JComboBox<>();
        TxtDatoBusqueda = new javax.swing.JTextField();
        RBotonOpTodos = new javax.swing.JRadioButton();
        RBotonOpEspecifica = new javax.swing.JRadioButton();
        BtnSeleccionar = new javax.swing.JButton();
        LbNombreFormulario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        TablaResultadoBusqueda = new javax.swing.JTable(){
            public boolean isCellEditable(int rows, int colum){
                return false;
            }
        };
        TablaResultadoBusqueda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TablaResultadoBusqueda);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 130, 470, 250);

        CmbCampoBuscar.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        CmbCampoBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CmbCampoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbCampoBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(CmbCampoBuscar);
        CmbCampoBuscar.setBounds(40, 80, 110, 23);

        TxtDatoBusqueda.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        TxtDatoBusqueda.setText("jTextField1");
        TxtDatoBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtDatoBusquedaKeyPressed(evt);
            }
        });
        getContentPane().add(TxtDatoBusqueda);
        TxtDatoBusqueda.setBounds(160, 80, 280, 23);

        buttonGroup1.add(RBotonOpTodos);
        RBotonOpTodos.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        RBotonOpTodos.setText("Todos");
        RBotonOpTodos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                RBotonOpTodosPropertyChange(evt);
            }
        });
        getContentPane().add(RBotonOpTodos);
        RBotonOpTodos.setBounds(20, 20, 70, 25);

        buttonGroup1.add(RBotonOpEspecifica);
        RBotonOpEspecifica.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        RBotonOpEspecifica.setText("Busqueda Especifica");
        getContentPane().add(RBotonOpEspecifica);
        RBotonOpEspecifica.setBounds(20, 50, 137, 25);

        BtnSeleccionar.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        BtnSeleccionar.setText("Seleccionar");
        BtnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeleccionarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnSeleccionar);
        BtnSeleccionar.setBounds(363, 390, 110, 27);
        getContentPane().add(LbNombreFormulario);
        LbNombreFormulario.setBounds(470, 0, 0, 0);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RBotonOpTodosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_RBotonOpTodosPropertyChange
        seleccionOpcion();
    }//GEN-LAST:event_RBotonOpTodosPropertyChange

    private void BtnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSeleccionarActionPerformed
        seleccion();
    }//GEN-LAST:event_BtnSeleccionarActionPerformed

    private void TxtDatoBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDatoBusquedaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            busquedaArticuloEspecifica(CmbCampoBuscar.getSelectedItem().toString(), TxtDatoBusqueda.getText());
        }
    }//GEN-LAST:event_TxtDatoBusquedaKeyPressed

    private void CmbCampoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbCampoBuscarActionPerformed
        TxtDatoBusqueda.requestFocus();
    }//GEN-LAST:event_CmbCampoBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSeleccionar;
    private javax.swing.JComboBox<String> CmbCampoBuscar;
    public static javax.swing.JLabel LbNombreFormulario;
    private javax.swing.JRadioButton RBotonOpEspecifica;
    private javax.swing.JRadioButton RBotonOpTodos;
    private javax.swing.JTable TablaResultadoBusqueda;
    private javax.swing.JTextField TxtDatoBusqueda;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
