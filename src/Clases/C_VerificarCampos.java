package Clases;

import javax.swing.JOptionPane;

public class C_VerificarCampos {

    String val = "no";

    public String CamposLoggin(String usuario, String contrasena) {
        if (usuario.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Digitar campo 'Usuario'", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (contrasena.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Digitar campo 'Clave'", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else {
            val = "ok";
        }
        return val;
    }

    public String CamposClaseArticulos(String clase, String estado) {
        if (clase.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Digitar campo 'Nombre Clase'", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (estado.equals("Seleccionar")) {
            JOptionPane.showMessageDialog(null, "Debe Escoger 'Estado'", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else {
            val = "ok";
        }
        return val;
    }

    public String CamposArticulo(String idclase, String codigo, String descripcion, String estado) {
        if (idclase.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Escoger 'Clase de Producto'", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (codigo.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Digitar campo 'Codigo'", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (descripcion.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Digitar campo 'Descripción'", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (estado.equals("Seleccionar")) {
            JOptionPane.showMessageDialog(null, "Debe Escoger 'Estado'", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else {
            val = "ok";
        }
        return val;
    }

    public String CamposAgregarItemFV(String descripcion, String cantidad, String descuento, String precio_unit) {
        if (descripcion.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Digitar campo 'Descripción'", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (cantidad.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Digitar campo 'Cantidad'", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (cantidad.equals("0")) {
            JOptionPane.showMessageDialog(null, "Cantidad debe ser mayor a Cero", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (descuento.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Digitar campo 'Descuento'", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (precio_unit.equals("0")) {
            JOptionPane.showMessageDialog(null, "Precio Unitario debe ser mayor a Cero", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else {
            val = "ok";
        }
        return val;
    }
    
    public String CamposFacturaVenta(String identificacion, String nombre, String telefono, String correo, String almacen,
                                    Integer cantidadfilas, Integer subtotal, Integer total) {
        if (identificacion.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Digitar campo 'Identificación'", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (nombre.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Digitar campo 'Nombre'", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (telefono.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Digitar campo 'Telefono'", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (correo.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Digitar campo 'Correo'", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (almacen.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Escoger un 'Almacen'", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (cantidadfilas==0) {
            JOptionPane.showMessageDialog(null, "Debe Adicionar por lo menos un Item para Facturar", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (subtotal<=0) {
            JOptionPane.showMessageDialog(null, "Campo 'Sub Total' debe ser mayor a Cero", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (total<=0) {
            JOptionPane.showMessageDialog(null, "Campo 'Total' debe ser mayor a Cero", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else {
            val = "ok";
        }
        return val;
    }
    
    public String CamposAgregarItemFC(String descripcion, String cantidad, String precio_unit) {
        if (descripcion.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Digitar campo 'Descripción'", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (cantidad.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Digitar campo 'Cantidad'", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (cantidad.equals("0")) {
            JOptionPane.showMessageDialog(null, "Cantidad debe ser mayor a Cero", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (precio_unit.equals("0") || precio_unit.equals("")) {
            JOptionPane.showMessageDialog(null, "Precio Unitario debe ser mayor a Cero", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else {
            val = "ok";
        }
        return val;
    }
    
        public String CamposFacturaCompra(String identificacion, String nombre, String telefono, String correo, String almacen,
                                    Integer cantidadfilas, Integer total) {
        if (identificacion.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Digitar campo 'Identificación'", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (nombre.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Digitar campo 'Nombre'", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (telefono.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Digitar campo 'Telefono'", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (correo.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Digitar campo 'Correo'", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (almacen.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe Escoger un 'Almacen'", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (cantidadfilas==0) {
            JOptionPane.showMessageDialog(null, "Debe Adicionar por lo menos un Item para Facturar", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else if (total<=0) {
            JOptionPane.showMessageDialog(null, "Campo 'Total' debe ser mayor a Cero", "Mensaje Error", JOptionPane.ERROR_MESSAGE);
        } else {
            val = "ok";
        }
        return val;
    }
    
}
