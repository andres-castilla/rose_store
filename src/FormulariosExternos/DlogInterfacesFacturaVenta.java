package FormulariosExternos;

import Clases.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.*;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.*;

public class DlogInterfacesFacturaVenta extends javax.swing.JDialog {

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

    public DlogInterfacesFacturaVenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        parametrosIniciales();
    }

    void parametrosIniciales() {
        sizeItem();
        parametrosCamposClientesIni();
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
        this.setSize(TablaDetalleFacturaVenta.getWidth() + 70, 500);
        LbFondo.setSize(this.getWidth(), this.getHeight());
        SepTitulo.setSize(this.getWidth(), 10);
        LbNuevo.setBounds(10, this.getHeight() - 70, 25, 25);
        LbNuevoArticulo.setBounds(LbNuevo.getX() + LbNuevo.getWidth() + 2, LbNuevo.getY() + (LbNuevo.getHeight() / 2), 80, 10);
        LbAceptar.setBounds(TxtPrecioVentaUnit.getX() + TxtPrecioVentaUnit.getWidth() + 5, TxtCodigo.getY() - 5, 25, 25);
        BtnLimpiar.setLocation(this.getWidth() / 2 - BtnLimpiar.getWidth() / 2, this.getHeight() - 70);
        BtnAgregar.setLocation(BtnLimpiar.getX() + BtnLimpiar.getWidth() + 20, BtnLimpiar.getY());
        BtnCancelar.setLocation(BtnLimpiar.getX() - BtnCancelar.getWidth() - 20, BtnLimpiar.getY());

    }

    void sizeTable() {
        String[] titles = {"Id", "Codigo", "Descripcion", "Cantidad", "Precio Unit", "Dcto", "SubTotal"};
        model = new DefaultTableModel(null, titles);
        TablaDetalleFacturaVenta.setModel(model);
        //SE ESTABLECE EL TAMAÑO DE LAS COLUMNAS
        Integer[] size = {20, 200, 20, 20, 10, 50};
        for (i = 1; i < titles.length; i++) {
            TablaDetalleFacturaVenta.getColumnModel().getColumn(i).setPreferredWidth(size[i - 1]);
        }
        TablaDetalleFacturaVenta.getColumnModel().getColumn(0).setResizable(false);
        TablaDetalleFacturaVenta.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaDetalleFacturaVenta.getColumnModel().getColumn(0).setMinWidth(0);
        TablaDetalleFacturaVenta.getColumnModel().getColumn(0).setPreferredWidth(0);
        //SE CENTRAN LOS TITULOS DE LA TABLA
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (i = 1; i < titles.length; i++) {
            TablaDetalleFacturaVenta.getColumnModel().getColumn(i).setHeaderRenderer(tcr);
        }
        //SE ESTABLECE UBICACION DEL TEXTO EN LAS DIFERENTES FILAS DE LA TABLA
        DefaultTableCellRenderer tcr2 = new DefaultTableCellRenderer();
        tcr2.setHorizontalAlignment(SwingConstants.RIGHT);
        for (i = 3; i < titles.length; i++) {
            TablaDetalleFacturaVenta.getColumnModel().getColumn(i).setCellRenderer(tcr2);
        }
        TablaDetalleFacturaVenta.getTableHeader().setReorderingAllowed(false);//SE BLOQUEA QUE NO SE PUEDAN MOVER LAS COLUMNAS
        TablaDetalleFacturaVenta.setRowHeight(20);//ANCHO DE FILA
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
        LbIdCliente.setText("0");
        LbIdAlmacen.setText("0");
        LbIdArticulo.setText("0");
        if (TablaDetalleFacturaVenta.getRowCount() > 0) {
            int cantfilas = TablaDetalleFacturaVenta.getRowCount();
            for (int i = 0; i < cantfilas; i++) {
                model.removeRow(0);
            }
        }
        TxtSubTotal.setEnabled(false);
        TxtSubTotal.setText("0");
        TxtDescuentoTotal.setEnabled(false);
        TxtDescuentoTotal.setText("0");
        TxtTotal.setEnabled(false);
        TxtTotal.setText("0");
        TAreaObservacion.setText("");
        DateFechaActual.setDate(fechaActual);
    }

    void parametrosCamposClientesIni() {
        TxtIdentificacion.setText("");
        LbIdArticulo.setText("0");
        LbIdCliente.setText("0");
        TxtNumeroFactura.setEnabled(false);
        TxtNombre.setEnabled(false);
        TxtNombre.setText("");
        TxtCorreo.setEnabled(false);
        TxtCorreo.setText("");
        TxtTelefono.setEnabled(false);
        TxtTelefono.setText("");
        TxtAlmacen.setEditable(false);
    }

    void parametrosCamposClienteNuevo() {
        LbIdCliente.setText("0");
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
        TxtPrecioVentaUnit.setText("");
        TxtDescuentoUnit.setText("");
        TxtSubTotal.setText("0");
        TxtDescuentoTotal.setText("0");
        TxtTotal.setText("0");
    }

    void validacionCamposNumericos(KeyEvent evt) {
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }

    void consultaCliente(String identificacion) {
        query = "Select *"
                + " From " + listado.T_Clientes
                + " where identificacion = " + identificacion
                + " And estado = 1;";
        String resultado = consulta.consulta_existencia(query);
        if (resultado.equals("")) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.", "Mensaje Información", JOptionPane.INFORMATION_MESSAGE);
            parametrosCamposClienteNuevo();
        } else {
            String[] campos = {"id","nombre","correo","telefono"};
            datosConsulta = consulta.consulta_existencia(query, campos.length, campos);
            LbIdCliente.setText(datosConsulta[0]);
            TxtNombre.setText(datosConsulta[1]);
            TxtCorreo.setText(datosConsulta[2]);
            TxtTelefono.setText(datosConsulta[3]);
            TxtAlmacen.requestFocus();
        }
    }

    void consultaNuneroFactura() {
        query = "Select count(id) as numeroFacturas"
                + " From " + listado.T_FacturaVenta
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
            query = "Select p.id, p.codigo, p.descripcion, lp.precio_venta"
                    + " From " + listado.T_Productos + " p, " + listado.T_ListaPrecio + " lp"
                    + " Where lp.id_producto = p.id and lp.id_producto = '" + idarticulo + "' and p.estado = '1';";
            String[] campos = {"codigo", "descripcion", "precio_venta"};
            datosConsulta = consulta.consulta_existencia(query, campos.length, campos);
            TxtCodigo.setText(datosConsulta[0]);
            TxtDescripcion.setText(datosConsulta[1]);
            TxtPrecioVentaUnit.setText(datosConsulta[2]);
        }
    }

    void agregarItem_Tabla() {
        if (verificar_campos.CamposAgregarItemFV(
                TxtDescripcion.getText(),
                TxtCantidad.getText(),
                TxtDescuentoUnit.getText(),
                TxtPrecioVentaUnit.getText()).equals("ok")) {
            int cantidad = Integer.parseInt(TxtCantidad.getText());
            int descuento = Integer.parseInt(TxtDescuentoUnit.getText());
            int precio_unitario = Integer.parseInt(TxtPrecioVentaUnit.getText());
            int subtotal = (cantidad * precio_unitario) - descuento;

            String[] nuevaItem = {
                LbIdArticulo.getText(),
                TxtCodigo.getText(),
                TxtDescripcion.getText(),
                TxtCantidad.getText(),
                TxtPrecioVentaUnit.getText(),
                TxtDescuentoUnit.getText(),
                String.valueOf(subtotal)
            };
            model.addRow(nuevaItem);
            parametrosCamposItemNuevo();
            calcularTotal(TablaDetalleFacturaVenta.getRowCount());
            TxtCodigo.requestFocus();
        }

    }

    void opcionesPopUp(String metodo, Integer numeroFila) {
        if (numeroFila < 0) {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar Item", "Mensaje de Información", JOptionPane.INFORMATION_MESSAGE);
        } else if (metodo == "eliminar") {
            model.removeRow(numeroFila);
            calcularTotal(TablaDetalleFacturaVenta.getRowCount());
        } else if (metodo == "modificar") {
            LbIdArticulo.setText(TablaDetalleFacturaVenta.getValueAt(numeroFila, 0).toString());
            TxtCodigo.setText(TablaDetalleFacturaVenta.getValueAt(numeroFila, 1).toString());
            TxtDescripcion.setText(TablaDetalleFacturaVenta.getValueAt(numeroFila, 2).toString());
            TxtCantidad.setText(TablaDetalleFacturaVenta.getValueAt(numeroFila, 3).toString());
            TxtPrecioVentaUnit.setText(TablaDetalleFacturaVenta.getValueAt(numeroFila, 4).toString());
            TxtDescuentoUnit.setText(TablaDetalleFacturaVenta.getValueAt(numeroFila, 5).toString());
            model.removeRow(numeroFila);
            calcularTotal(TablaDetalleFacturaVenta.getRowCount());
        }
    }

    void calcularTotal(Integer cantidadFilas) {
        int subtotal = 0;
        int descuentoTotal = 0;
        int total = 0;
        for (i = 0; i < cantidadFilas; i++) {
            int cantidad = Integer.parseInt(TablaDetalleFacturaVenta.getValueAt(i, 3).toString());
            int precioUnit = Integer.parseInt(TablaDetalleFacturaVenta.getValueAt(i, 4).toString());
            subtotal += (cantidad * precioUnit);
            int descuento = Integer.parseInt(TablaDetalleFacturaVenta.getValueAt(i, 5).toString());
            descuentoTotal += descuento;
        }
        total = subtotal - descuentoTotal;
        TxtSubTotal.setText(String.valueOf(subtotal));
        TxtDescuentoTotal.setText(String.valueOf(descuentoTotal));
        TxtTotal.setText(String.valueOf(total));
    }

    void agregar() {
        String respuesta = "";
        int subtotal = Integer.parseInt(TxtSubTotal.getText());
        int total = Integer.parseInt(TxtTotal.getText());
        if (verificar_campos.CamposFacturaVenta(TxtIdentificacion.getText(), TxtNombre.getText(), TxtTelefono.getText(),
                TxtCorreo.getText(), TxtAlmacen.getText(), TablaDetalleFacturaVenta.getRowCount(),
                subtotal, total).equals("ok")) {
            String fechadocumento = fecha.dateToString(DateFechaActual.getDate());
            if (LbIdCliente.getText().equals("0")) {
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
                respuesta = agregar.agregar(listado.T_Clientes, campos, valores);
                query = "Select * From " + listado.T_Clientes + " Where identificacion = '" + TxtIdentificacion.getText() + "';";
                datosConsulta = consulta.consulta_existencia(query, 1, "id");
                LbIdCliente.setText(datosConsulta[0]);
            }

            JOptionPane.showMessageDialog(null, "id cliente:" + datosConsulta[0]);

            respuesta = "";
            campos
                    = "id,"
                    + "id_cliente,"
                    + "fecha,"
                    + "subtotal,"
                    + "descuento,"
                    + "total,"
                    + "observacion,"
                    + "estado";
            valores
                    = TxtNumeroFactura.getText() + "',"//id
                    + "'" + LbIdCliente.getText() + "',"//id_cliente
                    + "'" + fechadocumento + "',"//fecha
                    + "'" + TxtSubTotal.getText() + "',"//subtotal
                    + "'" + TxtDescuentoTotal.getText() + "',"//descuento
                    + "'" + TxtTotal.getText() + "',"//total
                    + "'" + TAreaObservacion.getText() + "',"//observacion
                    + "'1";//estado
            respuesta = agregar.agregar(listado.T_FacturaVenta, campos, valores);
            
            JOptionPane.showMessageDialog(null, "agrega factura venta:-" + respuesta);

            //String[] titles = {"Id", "Codigo", "Descripcion", "Cantidad", "Precio Unit", "Dcto", "SubTotal"};
            if (respuesta.equals("ok")) {
                respuesta = "";
                campos
                        = "id_factura_venta,"
                        + "id_producto,"
                        + "descripcion_producto,"
                        + "cantidad,"
                        + "precio_unitario,"
                        + "descuento";
                for (i = 0; i < TablaDetalleFacturaVenta.getRowCount(); i++) {
                    valores
                            = TxtNumeroFactura.getText() + "',"//id_factura_venta
                            + "'" + TablaDetalleFacturaVenta.getValueAt(i, 0) + "',"//id_producto
                            + "'" + TablaDetalleFacturaVenta.getValueAt(i, 2) + "',"//descripcion_producto
                            + "'" + TablaDetalleFacturaVenta.getValueAt(i, 3) + "',"//cantidad
                            + "'" + TablaDetalleFacturaVenta.getValueAt(i, 4) + "',"//precio_unitario
                            + "'" + TablaDetalleFacturaVenta.getValueAt(i, 5);//descuento
                    respuesta = agregar.agregar(listado.T_DetalleFacturaVenta, campos, valores);
                }
                
                JOptionPane.showMessageDialog(null, "agrega detalle fv:-"+respuesta);
                
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
                for (i = 0; i < TablaDetalleFacturaVenta.getRowCount(); i++) {
                    valores
                            = TablaDetalleFacturaVenta.getValueAt(i, 0) + "',"//id_producto
                            + "'" + LbIdAlmacen.getText() + "',"//id_almacen_origen
                            + "'" + LbIdAlmacen.getText() + "',"//id_almacen_destino
                            + "'fv',"//tipo_documento
                            + "'" + TxtNumeroFactura.getText() + "',"//numero_documento
                            + "'0',"//cantidad_entrada
                            + "'" + TablaDetalleFacturaVenta.getValueAt(i, 3) + "',"//cantidad_salida
                            + "'" + TablaDetalleFacturaVenta.getValueAt(i, 4) + "',"//precio_unitario
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
        jLabel14 = new javax.swing.JLabel();
        TxtDescuentoUnit = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TxtPrecioVentaUnit = new javax.swing.JTextField();
        LbAceptar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDetalleFacturaVenta = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TAreaObservacion = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        TxtSubTotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TxtDescuentoTotal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TxtTotal = new javax.swing.JTextField();
        BtnCancelar = new javax.swing.JButton();
        BtnLimpiar = new javax.swing.JButton();
        BtnAgregar = new javax.swing.JButton();
        LbIdArticulo = new javax.swing.JLabel();
        LbIdCliente = new javax.swing.JLabel();
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
        LbTitulo.setText("Factura de Venta");
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

        jLabel14.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel14.setText("Dcto.:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(550, 160, 40, 18);

        TxtDescuentoUnit.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        TxtDescuentoUnit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TxtDescuentoUnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtDescuentoUnitKeyTyped(evt);
            }
        });
        getContentPane().add(TxtDescuentoUnit);
        TxtDescuentoUnit.setBounds(590, 160, 70, 20);

        jLabel8.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jLabel8.setText("Precio Unit.:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(670, 160, 80, 18);

        TxtPrecioVentaUnit.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        TxtPrecioVentaUnit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TxtPrecioVentaUnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtPrecioVentaUnitKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtPrecioVentaUnitKeyTyped(evt);
            }
        });
        getContentPane().add(TxtPrecioVentaUnit);
        TxtPrecioVentaUnit.setBounds(750, 160, 80, 20);

        LbAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LbAceptarMouseClicked(evt);
            }
        });
        getContentPane().add(LbAceptar);
        LbAceptar.setBounds(830, 160, 30, 30);

        TablaDetalleFacturaVenta = new javax.swing.JTable(){
            public boolean isCellEditable(int rows, int colum){
                return false;
            }
        };
        TablaDetalleFacturaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaDetalleFacturaVenta.setComponentPopupMenu(PopUpEditarItemTable);
        jScrollPane1.setViewportView(TablaDetalleFacturaVenta);

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

        jLabel10.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel10.setText("Sub Total:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(630, 330, 80, 18);

        TxtSubTotal.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        TxtSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        getContentPane().add(TxtSubTotal);
        TxtSubTotal.setBounds(720, 330, 140, 21);

        jLabel11.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        jLabel11.setText("Descuento:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(630, 360, 75, 18);

        TxtDescuentoTotal.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        TxtDescuentoTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        getContentPane().add(TxtDescuentoTotal);
        TxtDescuentoTotal.setBounds(720, 360, 140, 21);

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

        LbIdCliente.setText("0");
        getContentPane().add(LbIdCliente);
        LbIdCliente.setBounds(750, 0, 10, 20);

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

    private void TxtDescuentoUnitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtDescuentoUnitKeyTyped
        validacionCamposNumericos(evt);
    }//GEN-LAST:event_TxtDescuentoUnitKeyTyped

    private void TxtPrecioVentaUnitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPrecioVentaUnitKeyTyped
        validacionCamposNumericos(evt);
    }//GEN-LAST:event_TxtPrecioVentaUnitKeyTyped

    private void TxtIdentificacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtIdentificacionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            consultaCliente(TxtIdentificacion.getText());
        } else if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {
            parametrosCamposClientesIni();
        }
    }//GEN-LAST:event_TxtIdentificacionKeyPressed

    private void LbAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbAceptarMouseClicked
        agregarItem_Tabla();
    }//GEN-LAST:event_LbAceptarMouseClicked

    private void TxtPrecioVentaUnitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPrecioVentaUnitKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            agregarItem_Tabla();
        }
    }//GEN-LAST:event_TxtPrecioVentaUnitKeyPressed

    private void MenuEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEditarActionPerformed
        opcionesPopUp("modificar", TablaDetalleFacturaVenta.getSelectedRow());
    }//GEN-LAST:event_MenuEditarActionPerformed

    private void MenuEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEliminarActionPerformed
        opcionesPopUp("eliminar", TablaDetalleFacturaVenta.getSelectedRow());
    }//GEN-LAST:event_MenuEliminarActionPerformed

    private void TxtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCodigoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            DlogBusquedaArticulos dlogBusqueda = new DlogBusquedaArticulos(new javax.swing.JFrame(), true);
            dlogBusqueda.LbNombreFormulario.setText("fv");
            dlogBusqueda.setVisible(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {
            LbIdArticulo.setText("0");
            TxtCodigo.setText("");
            TxtDescripcion.setText("");
            TxtCantidad.setText("");
            TxtDescuentoUnit.setText("");
            TxtPrecioVentaUnit.setText("");
        }
    }//GEN-LAST:event_TxtCodigoKeyPressed

    private void LbNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbNuevoMouseClicked
        DlogInterfaceArticulos dialog = new DlogInterfaceArticulos(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_LbNuevoMouseClicked

    private void TxtAlmacenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtAlmacenKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            DlogBusquedaAlmacen busquedaAlmacen = new DlogBusquedaAlmacen(new javax.swing.JFrame(), true);
            busquedaAlmacen.LbNombreFormulario.setText("fv");
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
    public static javax.swing.JLabel LbIdCliente;
    private javax.swing.JLabel LbNuevo;
    private javax.swing.JLabel LbNuevoArticulo;
    private javax.swing.JLabel LbNumeroFactura;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JMenuItem MenuEditar;
    private javax.swing.JMenuItem MenuEliminar;
    private javax.swing.JPopupMenu PopUpEditarItemTable;
    private javax.swing.JSeparator SepTitulo;
    private javax.swing.JTextArea TAreaObservacion;
    private javax.swing.JTable TablaDetalleFacturaVenta;
    private javax.swing.JTextField TxtAlmacen;
    private javax.swing.JTextField TxtCantidad;
    private javax.swing.JTextField TxtCodigo;
    private javax.swing.JTextField TxtCorreo;
    private javax.swing.JTextField TxtDescripcion;
    private javax.swing.JTextField TxtDescuentoTotal;
    private javax.swing.JTextField TxtDescuentoUnit;
    private javax.swing.JTextField TxtIdentificacion;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtNumeroFactura;
    private javax.swing.JTextField TxtPrecioVentaUnit;
    private javax.swing.JTextField TxtSubTotal;
    private javax.swing.JTextField TxtTelefono;
    private javax.swing.JTextField TxtTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
