package FormulariosExternos;

import Clases.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.*;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.*;

public class DlogInterfacesFacturaCompra extends javax.swing.JDialog {

    C_CargarImagenes img = new C_CargarImagenes();
    C_Consultas consulta = new C_Consultas();
    C_Listado listado = new C_Listado();
    C_VerificarCampos verificar_campos = new C_VerificarCampos();
    C_FechaAjustarFormato fecha = new C_FechaAjustarFormato();
    C_Agregar agregar = new C_Agregar();
    Date fechaActual;
    DefaultTableModel model;//SE DEBE CREAR EL OBJETO DEBAJO DEL PUBLIC CLASS DEL FORMULARIO
    Integer i;
    String query, campos, valores;
    String[] datosConsulta = null;

    public DlogInterfacesFacturaCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        parametrosIniciales();
    }

    void parametrosIniciales() {
        sizeItem();
        parametrosCamposProveedorIni();
        cargarFechaActual();
        consultaNuneroFactura();
        parametrosCamposItemNuevo();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        LbNuevo.setIcon(img.IconoNuevo(LbNuevo.getWidth(), LbNuevo.getHeight()));
        LbAceptar.setIcon(img.IconoAceptar(LbAceptar.getWidth(), LbAceptar.getHeight()));
        LbFondo.setIcon(img.FondoHome(LbFondo.getWidth(), LbFondo.getHeight()));
        TxtIdentificacion.setBackground(listado.colorBusqueda);
        TxtAlmacen.setBackground(listado.colorBusqueda);
        TxtCodigo.setBackground(listado.colorBusqueda);
        opCancelar();
    }

    void sizeItem() {
        sizeTable();
        this.setSize(TablaDetalleFacturaCompra.getWidth() + 70, 500);
        LbFondo.setSize(this.getWidth(), this.getHeight());
        SepTitulo.setSize(this.getWidth(), 10);
        LbNuevo.setBounds(10, this.getHeight() - 70, 25, 25);
        LbNuevoArticulo.setBounds(LbNuevo.getX() + LbNuevo.getWidth() + 2, LbNuevo.getY() + (LbNuevo.getHeight() / 2), 80, 10);
        LbAceptar.setBounds(TxtPrecioCompraUnit.getX() + TxtPrecioCompraUnit.getWidth() + 5, TxtCodigo.getY() - 5, 25, 25);
        BtnLimpiar.setLocation(this.getWidth() / 2 - BtnLimpiar.getWidth() / 2, this.getHeight() - 70);
        BtnAgregar.setLocation(BtnLimpiar.getX() + BtnLimpiar.getWidth() + 20, BtnLimpiar.getY());
        BtnCancelar.setLocation(BtnLimpiar.getX() - BtnCancelar.getWidth() - 20, BtnLimpiar.getY());
    }

    void sizeTable() {
        String[] titles = {"Id", "Codigo", "Descripcion", "Cantidad", "Precio Unit", "SubTotal"};
        model = new DefaultTableModel(null, titles);
        TablaDetalleFacturaCompra.setModel(model);
        //SE ESTABLECE EL TAMAÑO DE LAS COLUMNAS
        Integer[] size = {20, 200, 20, 20, 50};
        for (i = 1; i < titles.length; i++) {
            TablaDetalleFacturaCompra.getColumnModel().getColumn(i).setPreferredWidth(size[i - 1]);
        }
        TablaDetalleFacturaCompra.getColumnModel().getColumn(0).setResizable(false);
        TablaDetalleFacturaCompra.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaDetalleFacturaCompra.getColumnModel().getColumn(0).setMinWidth(0);
        TablaDetalleFacturaCompra.getColumnModel().getColumn(0).setPreferredWidth(0);
        //SE CENTRAN LOS TITULOS DE LA TABLA
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (i = 1; i < titles.length; i++) {
            TablaDetalleFacturaCompra.getColumnModel().getColumn(i).setHeaderRenderer(tcr);
        }
        //SE ESTABLECE UBICACION DEL TEXTO EN LAS DIFERENTES FILAS DE LA TABLA
        DefaultTableCellRenderer tcr2 = new DefaultTableCellRenderer();
        tcr2.setHorizontalAlignment(SwingConstants.RIGHT);
        for (i = 3; i < titles.length; i++) {
            TablaDetalleFacturaCompra.getColumnModel().getColumn(i).setCellRenderer(tcr2);
        }
        TablaDetalleFacturaCompra.getTableHeader().setReorderingAllowed(false);//SE BLOQUEA QUE NO SE PUEDAN MOVER LAS COLUMNAS
        TablaDetalleFacturaCompra.setRowHeight(20);//ANCHO DE FILA
//        String[] aa = {};
//        model.addRow(aa);
    }

    void cargarFechaActual() {
        fechaActual = new Date();
        DateFechaActual.setDate(fechaActual);
    }

    void opCancelar() {
        TxtIdentificacion.setText("");
        TxtNombre.setText("");
        TxtTelefono.setText("");
        TxtCorreo.setText("");
        TxtAlmacen.setText("");
        LbIdProveedor.setText("0");
        LbIdAlmacen.setText("0");
        LbIdArticulo.setText("0");
        if (TablaDetalleFacturaCompra.getRowCount() > 0) {
            int cantfilas = TablaDetalleFacturaCompra.getRowCount();
            for (int i = 0; i < cantfilas; i++) {
                model.removeRow(0);
            }
        }
        TxtTotal.setEnabled(false);
        TxtTotal.setText("0");
        TAreaObservacion.setText("");
        DateFechaActual.setDate(fechaActual);
    }

    void parametrosCamposProveedorIni() {
        TxtIdentificacion.setText("");
        LbIdArticulo.setText("0");
        LbIdProveedor.setText("0");
        TxtNumeroFactura.setEnabled(false);
        TxtNombre.setEnabled(false);
        TxtNombre.setText("");
        TxtCorreo.setEnabled(false);
        TxtCorreo.setText("");
        TxtTelefono.setEnabled(false);
        TxtTelefono.setText("");
        TxtAlmacen.setEditable(false);
    }

    void parametrosCamposProveedorNuevo() {
        LbIdProveedor.setText("0");
        TxtNombre.setEnabled(true);
        TxtCorreo.setEnabled(true);
        TxtTelefono.setEnabled(true);
        TxtNombre.requestFocus();
    }

    void parametrosCamposItemNuevo() {
        LbIdArticulo.setText("0");
        TxtCodigo.setText("");
        TxtCodigo.setEditable(false);
        TxtDescripcion.setText("");
        TxtCantidad.setText("");
        TxtPrecioCompraUnit.setText("");
        TxtTotal.setText("0");
    }

    void validacionCamposNumericos(KeyEvent evt) {
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }

    void consultaProveedor(String identificacion) {
        query = "Select *"
                + " From " + listado.T_Proveedores
                + " where identificacion = " + identificacion
                + " And estado = 1;";
        String resultado = consulta.consulta_existencia(query);
        if (resultado.equals("")) {
            JOptionPane.showMessageDialog(null, "Proveedor no encontrado.", "Mensaje Información", JOptionPane.INFORMATION_MESSAGE);
            parametrosCamposProveedorNuevo();
        } else {
            String[] campos = {"id","nombre","correo","telefono"};
            datosConsulta = consulta.consulta_existencia(query, campos.length, campos);
            LbIdProveedor.setText(datosConsulta[0]);
            TxtNombre.setText(datosConsulta[1]);
            TxtCorreo.setText(datosConsulta[2]);
            TxtTelefono.setText(datosConsulta[3]);
            TxtAlmacen.requestFocus();
        }
    }

    void consultaNuneroFactura() {
        query = "Select count(id) as numeroFacturas"
                + " From " + listado.T_FacturaCompra
                + " ;";
        String campos = "numeroFacturas";
        datosConsulta = consulta.consulta_existencia(query, 1, campos);
        String numeroFactura = String.valueOf(Integer.parseInt(datosConsulta[0]) + 1);
        TxtNumeroFactura.setText(numeroFactura);
    }

    void consultaAlmacen(String idalmacen) {
        if (!idalmacen.equals("0")) {
            query = "Select * From " + listado.T_Almacenes + " Where id = '" + LbIdAlmacen.getText() + "';";
            datosConsulta = consulta.consulta_existencia(query, 1, "descripcion");
            TxtAlmacen.setText(datosConsulta[0]);
            TxtCodigo.requestFocus();
        }
    }

    void consultaArticulo(String idarticulo) {
        if (!idarticulo.equals("0")) {
            query = "Select *"
                    + " From " + listado.T_Productos
                    + " Where id = '" + idarticulo + "' and estado = '1';";
            String[] campos = {"codigo", "descripcion"};
            datosConsulta = consulta.consulta_existencia(query, campos.length, campos);
            TxtCodigo.setText(datosConsulta[0]);
            TxtDescripcion.setText(datosConsulta[1]);
            TxtCantidad.setText("0");
            TxtPrecioCompraUnit.setText("0");
        }
    }

    void agregarItem_Tabla() {
        if (verificar_campos.CamposAgregarItemFC(
                TxtDescripcion.getText(),
                TxtCantidad.getText(),
                TxtPrecioCompraUnit.getText()).equals("ok")) {
            int cantidad = Integer.parseInt(TxtCantidad.getText());
            int precio_unitario = Integer.parseInt(TxtPrecioCompraUnit.getText());
            int subtotal = (cantidad * precio_unitario);

            String[] nuevaItem = {
                LbIdArticulo.getText(),
                TxtCodigo.getText(),
                TxtDescripcion.getText(),
                TxtCantidad.getText(),
                TxtPrecioCompraUnit.getText(),
                String.valueOf(subtotal)
            };
            model.addRow(nuevaItem);
            parametrosCamposItemNuevo();
            calcularTotal(TablaDetalleFacturaCompra.getRowCount());
            TxtCodigo.requestFocus();
        }

    }

    void opcionesPopUp(String metodo, Integer numeroFila) {
        if (numeroFila < 0) {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar Item", "Mensaje de Información", JOptionPane.INFORMATION_MESSAGE);
        } else if (metodo == "eliminar") {
            model.removeRow(numeroFila);
            calcularTotal(TablaDetalleFacturaCompra.getRowCount());
        } else if (metodo == "modificar") {
            LbIdArticulo.setText(TablaDetalleFacturaCompra.getValueAt(numeroFila, 0).toString());
            TxtCodigo.setText(TablaDetalleFacturaCompra.getValueAt(numeroFila, 1).toString());
            TxtDescripcion.setText(TablaDetalleFacturaCompra.getValueAt(numeroFila, 2).toString());
            TxtCantidad.setText(TablaDetalleFacturaCompra.getValueAt(numeroFila, 3).toString());
            TxtPrecioCompraUnit.setText(TablaDetalleFacturaCompra.getValueAt(numeroFila, 4).toString());
            model.removeRow(numeroFila);
            calcularTotal(TablaDetalleFacturaCompra.getRowCount());
        }
    }

    void calcularTotal(Integer cantidadFilas) {
        //String[] titles = {"Id", "Codigo", "Descripcion", "Cantidad", "Precio Unit", "SubTotal"};
        int subtotal = 0;
        int total = 0;
        for (i = 0; i < cantidadFilas; i++) {
            int cantidad = Integer.parseInt(TablaDetalleFacturaCompra.getValueAt(i, 3).toString());
            int precioUnit = Integer.parseInt(TablaDetalleFacturaCompra.getValueAt(i, 4).toString());
            subtotal += (cantidad * precioUnit);
        }
        total = subtotal;
        TxtTotal.setText(String.valueOf(total));
    }

    void agregar() {
        String respuesta = "";
        int total = Integer.parseInt(TxtTotal.getText());
        if (verificar_campos.CamposFacturaCompra(TxtIdentificacion.getText(), TxtNombre.getText(), TxtTelefono.getText(),
                TxtCorreo.getText(), TxtAlmacen.getText(), TablaDetalleFacturaCompra.getRowCount(), total).equals("ok")) {
            String fechadocumento = fecha.dateToString(DateFechaActual.getDate());
            if (LbIdProveedor.getText().equals("0")) {
                campos
                        = "identificacion,"
                        + "nombre,"
                        + "correo,"
                        + "telefono,"
                        + "estado";
                valores
                        = TxtIdentificacion.getText() + "',"
                        + "'" + TxtNombre.getText() + "',"
                        + "'" + TxtCorreo.getText() + "',"
                        + "'" + TxtTelefono.getText() + "',"
                        + "'1";
                respuesta = agregar.agregar(listado.T_Proveedores, campos, valores);
                query = "Select * From " + listado.T_Proveedores + " Where identificacion = '" + TxtIdentificacion.getText() + "';";
                datosConsulta = consulta.consulta_existencia(query, 1, "id");
                LbIdProveedor.setText(datosConsulta[0]);
            }

            JOptionPane.showMessageDialog(null, "id proveedor:" + datosConsulta[0]);
            //AGREGAR FACTURA DE COMPRA
            respuesta = "";
            campos
                    = "id,"
                    + "id_proveedor,"
                    + "fecha,"
                    + "total,"
                    + "observacion,"
                    + "estado";
            valores
                    = TxtNumeroFactura.getText() + "',"//id
                    + "'" + LbIdProveedor.getText() + "',"//id_proveedor
                    + "'" + fechadocumento + "',"//fecha
                    + "'" + TxtTotal.getText() + "',"//total
                    + "'" + TAreaObservacion.getText() + "',"//observacion
                    + "'1";//estado
            respuesta = agregar.agregar(listado.T_FacturaCompra, campos, valores);
            
            JOptionPane.showMessageDialog(null, "agrega factura compra:-" + respuesta);

            //String[] titles = {"Id", "Codigo", "Descripcion", "Cantidad", "Precio Unit", "SubTotal"};
            //SE AGREGA DETALLE FACTURA DE COMPRA
            if (respuesta.equals("ok")) {
                respuesta = "";
                campos
                        = "id_factura_compra,"
                        + "id_producto,"
                        + "descripcion_producto,"
                        + "cantidad,"
                        + "precio_unitario";
                for (i = 0; i < TablaDetalleFacturaCompra.getRowCount(); i++) {
                    valores
                            = TxtNumeroFactura.getText() + "',"//id_factura_compra
                            + "'" + TablaDetalleFacturaCompra.getValueAt(i, 0) + "',"//id_producto
                            + "'" + TablaDetalleFacturaCompra.getValueAt(i, 2) + "',"//descripcion_producto
                            + "'" + TablaDetalleFacturaCompra.getValueAt(i, 3) + "',"//cantidad
                            + "'" + TablaDetalleFacturaCompra.getValueAt(i, 4); //precio_unitario
                    respuesta = agregar.agregar(listado.T_DetalleFacturaCompra, campos, valores);
                }
                
                JOptionPane.showMessageDialog(null, "agrega detalle fc:-"+respuesta);
                
                campos
                        = "id_producto,"
                        + "id_almacen_origen,"
                        + "id_almacen_destino,"
                        + "tipo_documento,"
                        + "numero_documento,"
                        + "cantidad_entrada,"
                        + "cantidad_salida,"
                        + "valor_unitario,"
                        + "fecha,"
                        + "estado";
                for (i = 0; i < TablaDetalleFacturaCompra.getRowCount(); i++) {
                    valores
                            = TablaDetalleFacturaCompra.getValueAt(i, 0) + "',"//id_producto
                            + "'" + LbIdAlmacen.getText() + "',"//id_almacen_origen
                            + "'" + LbIdAlmacen.getText() + "',"//id_almacen_destino
                            + "'fc',"//tipo_documento
                            + "'" + TxtNumeroFactura.getText() + "',"//numero_documento
                            + "'" + TablaDetalleFacturaCompra.getValueAt(i, 3) + "',"//cantidad_entrada
                            + "'0',"//cantidad_salida
                            + "'" + TablaDetalleFacturaCompra.getValueAt(i, 4) + "',"//precio_unitario
                            + "'" + fechadocumento + "',"//fecha
                            + "'1";//estado
                    respuesta = agregar.agregar(listado.T_Kardex, campos, valores);
                }
                JOptionPane.showMessageDialog(null, "agrega kardex:-"+respuesta);
                if (respuesta.equals("ok")) {
                    JOptionPane.showMessageDialog(null, "Registro Agregado con Exito");
                    opCancelar();
                    consultaNuneroFactura();
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopUpEditarItemTable = new javax.swing.JPopupMenu();
        MenuEditar = new javax.swing.JMenuItem();
        MenuEliminar = new javax.swing.JMenuItem();
        LbTitulo = new javax.swing.JLabel();
        SepTitulo = new javax.swing.JSeparator();
        LbNumeroFactura = new javax.swing.JLabel();
        TxtNumeroFactura = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        TxtIdentificacion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtCorreo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        DateFechaActual = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        TxtTelefono = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        TxtAlmacen = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        TxtCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtDescripcion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TxtCantidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TxtPrecioCompraUnit = new javax.swing.JTextField();
        LbAceptar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDetalleFacturaCompra = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TAreaObservacion = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        TxtTotal = new javax.swing.JTextField();
        BtnCancelar = new javax.swing.JButton();
        BtnLimpiar = new javax.swing.JButton();
        BtnAgregar = new javax.swing.JButton();
        LbIdArticulo = new javax.swing.JLabel();
        LbIdProveedor = new javax.swing.JLabel();
        LbNuevo = new javax.swing.JLabel();
        LbNuevoArticulo = new javax.swing.JLabel();
        LbIdAlmacen = new javax.swing.JLabel();
        LbFondo = new javax.swing.JLabel();

        MenuEditar.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        MenuEditar.setText("Editar");
        MenuEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEditarActionPerformed(evt);
            }
        });
        PopUpEditarItemTable.add(MenuEditar);

        MenuEliminar.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        MenuEliminar.setText("Eliminar");
        MenuEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEliminarActionPerformed(evt);
            }
        });
        PopUpEditarItemTable.add(MenuEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        LbTitulo.setFont(new java.awt.Font("Constantia", 1, 18)); // NOI18N
        LbTitulo.setText("Factura de Compra");
        getContentPane().add(LbTitulo);
        LbTitulo.setBounds(0, 20, 170, 30);
        getContentPane().add(SepTitulo);
        SepTitulo.setBounds(0, 50, 90, 10);

        LbNumeroFactura.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        LbNumeroFactura.setText("No.:");
        getContentPane().add(LbNumeroFactura);
        LbNumeroFactura.setBounds(30, 80, 30, 18);

        TxtNumeroFactura.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        TxtNumeroFactura.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TxtNumeroFactura.setToolTipText("");
        getContentPane().add(TxtNumeroFactura);
        TxtNumeroFactura.setBounds(60, 80, 60, 20);

        jLabel1.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel1.setText("Identificación:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 80, 100, 18);

        TxtIdentificacion.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        TxtIdentificacion.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TxtIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtIdentificacionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtIdentificacionKeyTyped(evt);
            }
        });
        getContentPane().add(TxtIdentificacion);
        TxtIdentificacion.setBounds(240, 80, 170, 20);

        jLabel2.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 110, 70, 18);

        TxtNombre.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        getContentPane().add(TxtNombre);
        TxtNombre.setBounds(100, 110, 400, 20);

        jLabel3.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel3.setText("Correo:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(420, 80, 50, 18);

        TxtCorreo.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        getContentPane().add(TxtCorreo);
        TxtCorreo.setBounds(480, 80, 190, 20);

        jLabel4.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel4.setText("Fecha:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(680, 80, 50, 18);

        DateFechaActual.setDateFormatString("dd-MMMM-yyyy");
        getContentPane().add(DateFechaActual);
        DateFechaActual.setBounds(730, 80, 130, 20);

        jLabel9.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel9.setText("Telefono:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(510, 110, 70, 18);

        TxtTelefono.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        getContentPane().add(TxtTelefono);
        TxtTelefono.setBounds(580, 110, 100, 20);

        jLabel13.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel13.setText("Almacen:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(690, 110, 70, 18);

        TxtAlmacen.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        TxtAlmacen.setToolTipText("Presione F2");
        TxtAlmacen.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtAlmacenFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TxtAlmacenFocusLost(evt);
            }
        });
        TxtAlmacen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtAlmacenKeyPressed(evt);
            }
        });
        getContentPane().add(TxtAlmacen);
        TxtAlmacen.setBounds(760, 110, 100, 20);

        jLabel15.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel15.setText("Codigo:");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(30, 160, 50, 18);

        TxtCodigo.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        TxtCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtCodigoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TxtCodigoFocusLost(evt);
            }
        });
        TxtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtCodigoKeyPressed(evt);
            }
        });
        getContentPane().add(TxtCodigo);
        TxtCodigo.setBounds(80, 160, 60, 20);

        jLabel6.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel6.setText("Descripción:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(150, 160, 77, 18);

        TxtDescripcion.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        getContentPane().add(TxtDescripcion);
        TxtDescripcion.setBounds(230, 160, 190, 20);

        jLabel7.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel7.setText("Cantidad:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(430, 160, 60, 18);

        TxtCantidad.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        TxtCantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TxtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCantidadKeyTyped(evt);
            }
        });
        getContentPane().add(TxtCantidad);
        TxtCantidad.setBounds(490, 160, 50, 20);

        jLabel8.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel8.setText("Precio Unit.:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(670, 160, 80, 18);

        TxtPrecioCompraUnit.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        TxtPrecioCompraUnit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TxtPrecioCompraUnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtPrecioCompraUnitKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtPrecioCompraUnitKeyTyped(evt);
            }
        });
        getContentPane().add(TxtPrecioCompraUnit);
        TxtPrecioCompraUnit.setBounds(750, 160, 80, 20);

        LbAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LbAceptarMouseClicked(evt);
            }
        });
        getContentPane().add(LbAceptar);
        LbAceptar.setBounds(830, 160, 30, 30);

        TablaDetalleFacturaCompra = new javax.swing.JTable(){
            public boolean isCellEditable(int rows, int colum){
                return false;
            }
        };
        TablaDetalleFacturaCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaDetalleFacturaCompra.setComponentPopupMenu(PopUpEditarItemTable);
        jScrollPane1.setViewportView(TablaDetalleFacturaCompra);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 210, 830, 110);

        TAreaObservacion.setColumns(20);
        TAreaObservacion.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        TAreaObservacion.setRows(5);
        TAreaObservacion.setToolTipText("");
        TAreaObservacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Constantia", 0, 12))); // NOI18N
        jScrollPane2.setViewportView(TAreaObservacion);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 330, 580, 80);

        jLabel12.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel12.setText("Total:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(630, 390, 39, 18);

        TxtTotal.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        TxtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TxtTotal.setText("0");
        getContentPane().add(TxtTotal);
        TxtTotal.setBounds(720, 390, 140, 21);

        BtnCancelar.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        BtnCancelar.setText("Cancelar");
        getContentPane().add(BtnCancelar);
        BtnCancelar.setBounds(230, 430, 90, 25);

        BtnLimpiar.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        BtnLimpiar.setText("Limpiar");
        BtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnLimpiar);
        BtnLimpiar.setBounds(340, 430, 90, 25);

        BtnAgregar.setFont(new java.awt.Font("Constantia", 0, 13)); // NOI18N
        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnAgregar);
        BtnAgregar.setBounds(460, 430, 90, 25);

        LbIdArticulo.setText("0");
        LbIdArticulo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                LbIdArticuloPropertyChange(evt);
            }
        });
        getContentPane().add(LbIdArticulo);
        LbIdArticulo.setBounds(770, 0, 10, 20);

        LbIdProveedor.setText("0");
        getContentPane().add(LbIdProveedor);
        LbIdProveedor.setBounds(750, 0, 10, 20);

        LbNuevo.setToolTipText("");
        LbNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        LbNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LbNuevoMouseClicked(evt);
            }
        });
        getContentPane().add(LbNuevo);
        LbNuevo.setBounds(0, 420, 40, 30);

        LbNuevoArticulo.setFont(new java.awt.Font("Constantia", 0, 12)); // NOI18N
        LbNuevoArticulo.setText("Nuevo Articulo");
        getContentPane().add(LbNuevoArticulo);
        LbNuevoArticulo.setBounds(40, 440, 100, 18);

        LbIdAlmacen.setText("0");
        LbIdAlmacen.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                LbIdAlmacenPropertyChange(evt);
            }
        });
        getContentPane().add(LbIdAlmacen);
        LbIdAlmacen.setBounds(790, 0, 6, 20);
        getContentPane().add(LbFondo);
        LbFondo.setBounds(0, 0, 0, 0);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtIdentificacionKeyTyped
        validacionCamposNumericos(evt);
    }//GEN-LAST:event_TxtIdentificacionKeyTyped

    private void TxtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCantidadKeyTyped
        validacionCamposNumericos(evt);
    }//GEN-LAST:event_TxtCantidadKeyTyped

    private void TxtPrecioCompraUnitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPrecioCompraUnitKeyTyped
        validacionCamposNumericos(evt);
    }//GEN-LAST:event_TxtPrecioCompraUnitKeyTyped

    private void TxtIdentificacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtIdentificacionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            consultaProveedor(TxtIdentificacion.getText());
        } else if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {
            parametrosCamposProveedorIni();
        }
    }//GEN-LAST:event_TxtIdentificacionKeyPressed

    private void LbAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbAceptarMouseClicked
        agregarItem_Tabla();
    }//GEN-LAST:event_LbAceptarMouseClicked

    private void TxtPrecioCompraUnitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPrecioCompraUnitKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            agregarItem_Tabla();
        }
    }//GEN-LAST:event_TxtPrecioCompraUnitKeyPressed

    private void MenuEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEditarActionPerformed
        opcionesPopUp("modificar", TablaDetalleFacturaCompra.getSelectedRow());
    }//GEN-LAST:event_MenuEditarActionPerformed

    private void MenuEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEliminarActionPerformed
        opcionesPopUp("eliminar", TablaDetalleFacturaCompra.getSelectedRow());
    }//GEN-LAST:event_MenuEliminarActionPerformed

    private void TxtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCodigoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            DlogBusquedaArticulos dlogBusqueda = new DlogBusquedaArticulos(new javax.swing.JFrame(), true);
            dlogBusqueda.LbNombreFormulario.setText("fc");
            dlogBusqueda.setVisible(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {
            LbIdArticulo.setText("0");
            TxtCodigo.setText("");
            TxtDescripcion.setText("");
            TxtCantidad.setText("");
            TxtPrecioCompraUnit.setText("");
        }
    }//GEN-LAST:event_TxtCodigoKeyPressed

    private void LbNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbNuevoMouseClicked
        DlogInterfaceArticulos dialog = new DlogInterfaceArticulos(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_LbNuevoMouseClicked

    private void TxtAlmacenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtAlmacenKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            DlogBusquedaAlmacen busquedaAlmacen = new DlogBusquedaAlmacen(new javax.swing.JFrame(), true);
            busquedaAlmacen.LbNombreFormulario.setText("fc");
            busquedaAlmacen.setVisible(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {
            TxtAlmacen.setText("");
            LbIdAlmacen.setText("0");
        }
    }//GEN-LAST:event_TxtAlmacenKeyPressed

    private void LbIdAlmacenPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_LbIdAlmacenPropertyChange
        consultaAlmacen(LbIdAlmacen.getText());
    }//GEN-LAST:event_LbIdAlmacenPropertyChange

    private void LbIdArticuloPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_LbIdArticuloPropertyChange
        consultaArticulo(LbIdArticulo.getText());
    }//GEN-LAST:event_LbIdArticuloPropertyChange

    private void TxtCodigoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtCodigoFocusGained
        Border border = BorderFactory.createLineBorder(Color.red);
        TxtCodigo.setBorder(border);
    }//GEN-LAST:event_TxtCodigoFocusGained

    private void TxtCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtCodigoFocusLost
        Border border = BorderFactory.createLineBorder(Color.GRAY);
        TxtCodigo.setBorder(border);
    }//GEN-LAST:event_TxtCodigoFocusLost

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        agregar();
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void TxtAlmacenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtAlmacenFocusGained
        Border border = BorderFactory.createLineBorder(Color.red);
        TxtAlmacen.setBorder(border);
    }//GEN-LAST:event_TxtAlmacenFocusGained

    private void TxtAlmacenFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtAlmacenFocusLost
        Border border = BorderFactory.createLineBorder(Color.GRAY);
        TxtAlmacen.setBorder(border);
    }//GEN-LAST:event_TxtAlmacenFocusLost

    private void BtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarActionPerformed
        opCancelar();
    }//GEN-LAST:event_BtnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnLimpiar;
    private com.toedter.calendar.JDateChooser DateFechaActual;
    private javax.swing.JLabel LbAceptar;
    private javax.swing.JLabel LbFondo;
    public static javax.swing.JLabel LbIdAlmacen;
    public static javax.swing.JLabel LbIdArticulo;
    public static javax.swing.JLabel LbIdProveedor;
    private javax.swing.JLabel LbNuevo;
    private javax.swing.JLabel LbNuevoArticulo;
    private javax.swing.JLabel LbNumeroFactura;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JMenuItem MenuEditar;
    private javax.swing.JMenuItem MenuEliminar;
    private javax.swing.JPopupMenu PopUpEditarItemTable;
    private javax.swing.JSeparator SepTitulo;
    private javax.swing.JTextArea TAreaObservacion;
    private javax.swing.JTable TablaDetalleFacturaCompra;
    private javax.swing.JTextField TxtAlmacen;
    private javax.swing.JTextField TxtCantidad;
    private javax.swing.JTextField TxtCodigo;
    private javax.swing.JTextField TxtCorreo;
    private javax.swing.JTextField TxtDescripcion;
    private javax.swing.JTextField TxtIdentificacion;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtNumeroFactura;
    private javax.swing.JTextField TxtPrecioCompraUnit;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JTextField TxtTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
