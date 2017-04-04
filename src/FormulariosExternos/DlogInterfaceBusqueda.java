package FormulariosExternos;

import javax.swing.*;
import javax.swing.table.*;

public class DlogInterfaceBusqueda extends javax.swing.JDialog {

    DefaultTableModel model;
    String[] titulos = null;
    Integer i;

    public DlogInterfaceBusqueda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        parametrosIniciales();
    }
    
    void parametrosIniciales(){
        sizeItem();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        RBotonOpTodos.setSelected(true);
    }
    
    void sizeItem(){
        this.setSize(500, 450);
    }

    public void sizeTable(String[] titles, Integer[] size, Integer ubicacion, Integer[] columnasUbicar) {
        //String[] titles = {"Id", "Codigo", "Descripcion", "Cantidad", "Precio Unit", "Dcto", "SubTotal"};
        titulos = titles;
        model = new DefaultTableModel(null, titles);
        TablaResultadoBusqueda.setModel(model);
        
        //SE ESTABLECE EL TAMAÑO DE LAS COLUMNAS
        //Integer[] size = {20, 200, 20, 20, 10, 50};
        for (i = 1; i < titles.length; i++) {
            TablaResultadoBusqueda.getColumnModel().getColumn(i).setPreferredWidth(size[i - 1]);
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
        if (ubicacion == 1) {
            DefaultTableCellRenderer tcr2 = new DefaultTableCellRenderer();
            tcr2.setHorizontalAlignment(SwingConstants.RIGHT);
            for (i = 0; i < columnasUbicar.length; i++) {
                TablaResultadoBusqueda.getColumnModel().getColumn(columnasUbicar[i]).setCellRenderer(tcr2);
            }
        }
        TablaResultadoBusqueda.getTableHeader().setReorderingAllowed(false);//SE BLOQUEA QUE NO SE PUEDAN MOVER LAS COLUMNAS
        TablaResultadoBusqueda.setRowHeight(20);//ANCHO DE FILA
        String[] aa = {};
        model.addRow(aa);
    }
    
    void seleccionOpcion(){
        CmbCampoBuscar.removeAllItems();
        String respuesta = "";
        if(RBotonOpTodos.isSelected()){
            CmbCampoBuscar.setVisible(false);
            TxtDatoBusqueda.setVisible(false);
        }else if(RBotonOpEspecifica.isSelected()){
                    for(i=0;i<titulos.length;i++){
                        CmbCampoBuscar.addItem(titulos[i]);
                    }
            CmbCampoBuscar.setVisible(true);
            TxtDatoBusqueda.setVisible(true);
        }
        
        //return respuesta;
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
        jButton1 = new javax.swing.JButton();

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
        getContentPane().add(CmbCampoBuscar);
        CmbCampoBuscar.setBounds(40, 80, 110, 23);

        TxtDatoBusqueda.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        TxtDatoBusqueda.setText("jTextField1");
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
        RBotonOpEspecifica.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                RBotonOpEspecificaPropertyChange(evt);
            }
        });
        getContentPane().add(RBotonOpEspecifica);
        RBotonOpEspecifica.setBounds(20, 50, 137, 25);

        jButton1.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jButton1.setText("Aceptar");
        getContentPane().add(jButton1);
        jButton1.setBounds(383, 390, 90, 27);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RBotonOpTodosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_RBotonOpTodosPropertyChange
        seleccionOpcion();
    }//GEN-LAST:event_RBotonOpTodosPropertyChange

    private void RBotonOpEspecificaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_RBotonOpEspecificaPropertyChange
        
    }//GEN-LAST:event_RBotonOpEspecificaPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbCampoBuscar;
    private javax.swing.JRadioButton RBotonOpEspecifica;
    private javax.swing.JRadioButton RBotonOpTodos;
    private javax.swing.JTable TablaResultadoBusqueda;
    private javax.swing.JTextField TxtDatoBusqueda;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
