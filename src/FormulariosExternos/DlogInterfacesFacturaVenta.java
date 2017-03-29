
package FormulariosExternos;


public class DlogInterfacesFacturaVenta extends javax.swing.JDialog {


    public DlogInterfacesFacturaVenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        parametrosIniciales();
    }
    
    void parametrosIniciales(){
        sizeItem();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    void sizeItem(){
        this.setSize(TblaDetalleFacturaVenta.getWidth()+70, 500);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtIdentificacion = new javax.swing.JTextField();
        TxtNombre = new javax.swing.JTextField();
        TxtCorreo = new javax.swing.JTextField();
        TxtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TxtCodigo = new javax.swing.JTextField();
        TxtDescripcion = new javax.swing.JTextField();
        TxtCantidad = new javax.swing.JTextField();
        TxtPrecioVenta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblaDetalleFacturaVenta = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        LbTitulo = new javax.swing.JLabel();
        SepTitulo = new javax.swing.JSeparator();
        LbFondo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TAreaObservacion = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        TxtSubTotal = new javax.swing.JTextField();
        TxtDescuento = new javax.swing.JTextField();
        TxtTotal = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        TxtAlmacen = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel1.setText("Identificación:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 80, 100, 18);

        jLabel2.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 110, 70, 18);

        jLabel3.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel3.setText("Correo:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(320, 80, 49, 18);

        jLabel4.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel4.setText("Fecha:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(590, 80, 50, 18);

        TxtIdentificacion.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        getContentPane().add(TxtIdentificacion);
        TxtIdentificacion.setBounds(140, 80, 170, 20);

        TxtNombre.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        getContentPane().add(TxtNombre);
        TxtNombre.setBounds(100, 110, 340, 20);

        TxtCorreo.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        getContentPane().add(TxtCorreo);
        TxtCorreo.setBounds(380, 80, 200, 20);

        TxtTelefono.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        getContentPane().add(TxtTelefono);
        TxtTelefono.setBounds(520, 110, 100, 20);

        jLabel5.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel5.setText("Codigo:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 160, 50, 18);

        jLabel6.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel6.setText("Descripción:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(150, 160, 77, 18);

        jLabel7.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel7.setText("Cantidad:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(420, 160, 60, 18);

        jLabel8.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel8.setText("Precio Unit. Vta.:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(560, 160, 106, 18);

        TxtCodigo.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        getContentPane().add(TxtCodigo);
        TxtCodigo.setBounds(80, 160, 60, 20);

        TxtDescripcion.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        getContentPane().add(TxtDescripcion);
        TxtDescripcion.setBounds(230, 160, 180, 20);

        TxtCantidad.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        getContentPane().add(TxtCantidad);
        TxtCantidad.setBounds(490, 160, 50, 20);

        TxtPrecioVenta.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        getContentPane().add(TxtPrecioVenta);
        TxtPrecioVenta.setBounds(670, 160, 60, 20);

        TblaDetalleFacturaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TblaDetalleFacturaVenta);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 210, 770, 110);

        jButton1.setText("add");
        getContentPane().add(jButton1);
        jButton1.setBounds(740, 160, 60, 20);

        jLabel9.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel9.setText("Telefono:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(450, 110, 70, 18);

        jDateChooser1.setDateFormatString("yyyy/MM/dd");
        getContentPane().add(jDateChooser1);
        jDateChooser1.setBounds(660, 80, 140, 20);

        LbTitulo.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        LbTitulo.setText("Factura de Venta");
        getContentPane().add(LbTitulo);
        LbTitulo.setBounds(0, 20, 170, 30);
        getContentPane().add(SepTitulo);
        SepTitulo.setBounds(0, 50, 90, 10);
        getContentPane().add(LbFondo);
        LbFondo.setBounds(0, 0, 0, 0);

        TAreaObservacion.setColumns(20);
        TAreaObservacion.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        TAreaObservacion.setRows(5);
        jScrollPane2.setViewportView(TAreaObservacion);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 330, 510, 80);

        jLabel10.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel10.setText("Sub Total:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(590, 330, 80, 18);

        jLabel11.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel11.setText("Descuento:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(590, 360, 75, 18);

        jLabel12.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel12.setText("Total:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(590, 390, 39, 18);

        TxtSubTotal.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        getContentPane().add(TxtSubTotal);
        TxtSubTotal.setBounds(680, 330, 120, 23);

        TxtDescuento.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        getContentPane().add(TxtDescuento);
        TxtDescuento.setBounds(680, 360, 120, 23);

        TxtTotal.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        getContentPane().add(TxtTotal);
        TxtTotal.setBounds(680, 390, 120, 23);

        jButton2.setText("Agregar");
        getContentPane().add(jButton2);
        jButton2.setBounds(470, 430, 80, 23);

        jButton3.setText("Cancelar");
        getContentPane().add(jButton3);
        jButton3.setBounds(240, 430, 80, 23);

        jButton4.setText("Limpiar");
        getContentPane().add(jButton4);
        jButton4.setBounds(350, 430, 80, 23);

        TxtAlmacen.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        getContentPane().add(TxtAlmacen);
        TxtAlmacen.setBounds(700, 110, 100, 20);

        jLabel13.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel13.setText("Almacen:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(630, 110, 70, 18);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbFondo;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JSeparator SepTitulo;
    private javax.swing.JTextArea TAreaObservacion;
    private javax.swing.JTable TblaDetalleFacturaVenta;
    private javax.swing.JTextField TxtAlmacen;
    private javax.swing.JTextField TxtCantidad;
    private javax.swing.JTextField TxtCodigo;
    private javax.swing.JTextField TxtCorreo;
    private javax.swing.JTextField TxtDescripcion;
    private javax.swing.JTextField TxtDescuento;
    private javax.swing.JTextField TxtIdentificacion;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtPrecioVenta;
    private javax.swing.JTextField TxtSubTotal;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JTextField TxtTotal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
