package Clases;

public class C_ArmarQuery {

    C_Listado tabla = new C_Listado();

    String respuesta;

    public String UpdateInformacionEmpresa(String[] parametros) {
        respuesta = "Update"
                + " " + tabla.T_InformacionEmpresa
                + " Set"
                + " identificacion = '" + parametros[0] + "',"
                + " razon_social = '" + parametros[1] + "',"
                + " representante = '" + parametros[2] + "',"
                + " regimen = '" + parametros[3] + "',"
                + " url_logo = '" + parametros[4] + "'"
                + " Where Id = 1"
                + " ;";

        return respuesta;
    }

    public String Usuarios(String metodo, String[] parametros, String id) {
        if (metodo == "insert") {
            respuesta = "Insert Into"
                    + " " + tabla.T_Usuarios + "(nombre,usuario,contrasena,estado)"
                    + " values("
                    + "'" + parametros[0] + "',"
                    + "'" + parametros[1] + "',"
                    + "'" + parametros[2] + "',"
                    + "'" + parametros[3] + "')"
                    + " ;";
        } else if (metodo == "update") {
            respuesta = "Update"
                    + " " + tabla.T_Usuarios
                    + " Set"
                    + " nombre = '" + parametros[0] + "',"
                    + " usuario = '" + parametros[1] + "',"
                    + " contrasena = '" + parametros[2] + "',"
                    + " estado = '" + parametros[3] + "'"
                    + " Where Id = " + id
                    + " ;";
        } else if (metodo == "consultaGeneral") {
            respuesta = "Select "
                    + " *"
                    + " From " + tabla.T_Usuarios
                    + " ;";
        } else if (metodo == "consultaLoggin"){
            respuesta = "Select "
                    + " *"
                    + " From " + tabla.T_Usuarios
                    + " Where estado = 1"
                    + " ;";
        }
        return respuesta;
    }

    public String Clientes(String metodo, String[] parametros, String id) {
        if (metodo == "insert") {
            respuesta = "Insert Into"
                    + " " + tabla.T_Clientes + "(identificacion,nombre,correo,telefono,estado)"
                    + " values("
                    + "'" + parametros[0] + "',"
                    + "'" + parametros[1] + "',"
                    + "'" + parametros[2] + "',"
                    + "'" + parametros[3] + "',"
                    + "'" + parametros[4] + "')"
                    + " ;";
        } else if (metodo == "update") {
            respuesta = "Update"
                    + " " + tabla.T_Clientes
                    + " Set"
                    + " identificacion = '" + parametros[0] + "',"
                    + " nombre = '" + parametros[1] + "',"
                    + " correo = '" + parametros[2] + "',"
                    + " telefono = '" + parametros[3] + "',"
                    + " estado = '" + parametros[4] + "'"
                    + " Where Id = " + id
                    + " ;";
        } else if (metodo == "consultaGeneral") {
            respuesta = "Select "
                    + " *"
                    + " From " + tabla.T_Clientes
                    + " Where Id = " + id
                    + " ;";
        }
        return respuesta;
    }

    public String Proveedores(String metodo, String[] parametros, String id) {
        if (metodo == "insert") {
            respuesta = "Insert Into"
                    + " " + tabla.T_Proveedores + "(identificacion,nombre,correo,telefono,estado)"
                    + " values("
                    + "'" + parametros[0] + "',"
                    + "'" + parametros[1] + "',"
                    + "'" + parametros[2] + "',"
                    + "'" + parametros[3] + "',"
                    + "'" + parametros[4] + "')"
                    + " ;";
        } else if (metodo == "update") {
            respuesta = "Update"
                    + " " + tabla.T_Proveedores
                    + " Set"
                    + " identificacion = '" + parametros[0] + "',"
                    + " nombre = '" + parametros[1] + "',"
                    + " correo = '" + parametros[2] + "',"
                    + " telefono = '" + parametros[3] + "',"
                    + " estado = '" + parametros[4] + "'"
                    + " Where Id = " + id
                    + " ;";
        } else if (metodo == "consultaGeneral") {
            respuesta = "Select "
                    + " *"
                    + " From " + tabla.T_Proveedores
                    + " Where Id = " + id
                    + " ;";
        }
        return respuesta;
    }

    public String Almacenes(String metodo, String[] parametros, String id) {
        if (metodo == "insert") {
            respuesta = "Insert Into"
                    + " " + tabla.T_Almacenes + "(descripcion,estado)"
                    + " values("
                    + "'" + parametros[0] + "',"
                    + "'" + parametros[1] + "')"
                    + " ;";
        } else if (metodo == "update") {
            respuesta = "Update"
                    + " " + tabla.T_Almacenes
                    + " Set"
                    + " descripcion = '" + parametros[0] + "',"
                    + " estado = '" + parametros[1] + "'"
                    + " Where Id = " + id
                    + " ;";
        } else if (metodo == "consultaGeneral") {
            respuesta = "Select "
                    + " *"
                    + " From " + tabla.T_Almacenes
                    + " Where Id = " + id
                    + " ;";
        }
        return respuesta;
    }

    public String ClaseProductos(String metodo, String[] parametros, String id) {
        if (metodo == "insert") {
            respuesta = "Insert Into"
                    + " " + tabla.T_ClaseProductos + "(descripcion,estado)"
                    + " values("
                    + "'" + parametros[0] + "',"
                    + "'" + parametros[1] + "')"
                    + " ;";
        } else if (metodo == "update") {
            respuesta = "Update"
                    + " " + tabla.T_ClaseProductos
                    + " Set"
                    + " descripcion = '" + parametros[0] + "',"
                    + " estado = '" + parametros[1] + "'"
                    + " Where Id = " + id
                    + " ;";
        } else if (metodo == "consultaGeneral") {
            respuesta = "Select "
                    + " *"
                    + " From " + tabla.T_ClaseProductos
                    + " Where Id = " + id
                    + " ;";
        }
        return respuesta;
    }

    public String Productos(String metodo, String[] parametros, String id) {
        if (metodo == "insert") {
            respuesta = "Insert Into"
                    + " " + tabla.T_Productos + "(codigo,descripcion,ultimo_costo,id_clase,estado)"
                    + " values("
                    + "'" + parametros[0] + "',"
                    + "'" + parametros[1] + "',"
                    + "'" + parametros[2] + "',"
                    + "'" + parametros[3] + "',"
                    + "'" + parametros[4] + "')"
                    + " ;";
        } else if (metodo == "updateGeneral") {
            respuesta = "Update "
                    + " " + tabla.T_Productos
                    + " Set"
                    + " codigo = '" + parametros[0] + "',"
                    + " descripcion = '" + parametros[1] + "',"
                    + " id_clase = '" + parametros[3] + "',"
                    + " estado = '" + parametros[4] + "'"
                    + " Where Id = " + id
                    + " ;";
        } else if (metodo == "updateCosto") {
            respuesta = "Update"
                    + " " + tabla.T_Productos
                    + " Set"
                    + " ultimo_costo = '" + parametros[1] + "'"
                    + " Where Id = " + id
                    + " ;";
        } else if (metodo == "consultaGeneral") {
            respuesta = "Select "
                    + " *"
                    + " From " + tabla.T_Productos
                    + " Where Id = " + id
                    + " ;";
        }
        return respuesta;
    }

    public String ListaPrecio(String metodo, String[] parametros, String id) {
        if (metodo == "insert") {
            respuesta = "Insert Into"
                    + " " + tabla.T_ListaPrecio + "(id_producto,margen_venta,precio_venta)"
                    + " values("
                    + "'" + parametros[0] + "',"
                    + "'" + parametros[1] + "',"
                    + "'" + parametros[2] + "')"
                    + " ;";
        } else if (metodo == "updatePrecioVenta") {
            respuesta = "Update"
                    + " " + tabla.T_ListaPrecio
                    + " Set"
                    + " margen_venta = '" + parametros[0] + "',"
                    + " precio_venta = '" + parametros[1] + "'"
                    + " Where Id = " + id
                    + " ;";
        } else if (metodo == "consultaGeneral") {
            respuesta = "Select "
                    + " *"
                    + " From " + tabla.T_ListaPrecio
                    + " ;";
        }
        return respuesta;
    }

    public String FacturaVentas(String metodo, String[] parametros, String id) {
        if (metodo == "insert") {
            respuesta = "Insert Into"
                    + " " + tabla.T_FacturaVenta + "(id_cliente,fecha,subtotal,descuento,total,observacion,estado)"
                    + " values("
                    + "'" + parametros[0] + "',"
                    + "'" + parametros[1] + "',"
                    + "'" + parametros[2] + "',"
                    + "'" + parametros[3] + "',"
                    + "'" + parametros[4] + "',"
                    + "'" + parametros[5] + "',"
                    + "'" + parametros[6] + "')"
                    + " ;";
        } else if (metodo == "update") {
            respuesta = "Update"
                    + " " + tabla.T_FacturaVenta
                    + " Set"
                    + " estado = '" + parametros[0] + "'"
                    + " Where Id = " + id
                    + " ;";
        } else if (metodo == "consultaGeneral") {
            respuesta = "Select "
                    + " c.identificacion,"
                    + " c.nombre,"
                    + " c.correo,"
                    + " c.telefono,"
                    + " fv.fecha,"
                    + " fv.subtotal,"
                    + " fv.descuento,"
                    + " fv.total,"
                    + " fv.estado,"
                    + " fv.observacion"
                    + " From"
                    + " " + tabla.T_Clientes + " c,"
                    + " " + tabla.T_FacturaVenta + " fv"
                    + " Where"
                    + " fv.id_cliente = c.id and"
                    + " fv.id = " + id
                    + " ;";
        }
        return respuesta;
    }

    public String DetalleFacturaVentas(String metodo, String[] parametros, String id) {
        if (metodo == "insert") {
            respuesta = "Insert Into"
                    + " " + tabla.T_DetalleFacturaVenta + "(id_factura_venta,id_producto,descripcion_producto,cantidad,precio_unitario,descuento)"
                    + " values("
                    + "'" + parametros[0] + "',"
                    + "'" + parametros[1] + "',"
                    + "'" + parametros[2] + "',"
                    + "'" + parametros[3] + "',"
                    + "'" + parametros[4] + "',"
                    + "'" + parametros[5] + "')"
                    + " ;";
        } else if (metodo == "consultaGeneral") {
            respuesta = "Select "
                    + " p.codigo,"
                    + " dfv.descripcion_producto,"
                    + " dfv.cantidad,"
                    + " dfv.precio_unitario,"
                    + " dfv.descuento"
                    + " From"
                    + " " + tabla.T_Productos + " p,"
                    + " " + tabla.T_FacturaVenta + " fv,"
                    + " " + tabla.T_DetalleFacturaVenta + " dfv"
                    + " Where"
                    + " dfv.id_producto = p.id and"
                    + " dfv.id_factura_venta = fv.id and"
                    + " dfv.id_factura_venta = " + id
                    + " ;";
        }
        return respuesta;
    }

    public String FacturaCompras(String metodo, String[] parametros, String id) {
        if (metodo == "insert") {
            respuesta = "Insert Into"
                    + " " + tabla.T_FacturaCompra + "(id_proveedor,fecha,total,observacion,estado)"
                    + " values("
                    + "'" + parametros[0] + "',"
                    + "'" + parametros[1] + "',"
                    + "'" + parametros[2] + "',"
                    + "'" + parametros[3] + "',"
                    + "'" + parametros[4] + "')"
                    + " ;";
        } else if (metodo == "update") {
            respuesta = "Update"
                    + " " + tabla.T_FacturaCompra
                    + " Set"
                    + " estado = '" + parametros[0] + "'"
                    + " Where Id = " + id
                    + " ;";
        } else if (metodo == "consultaGeneral") {
            respuesta = "Select "
                    + " c.identificacion,"
                    + " c.nombre,"
                    + " c.correo,"
                    + " c.telefono,"
                    + " fc.fecha,"
                    + " fv.total,"
                    + " fv.estado,"
                    + " fv.observacion"
                    + " From"
                    + " " + tabla.T_Proveedores + " p,"
                    + " " + tabla.T_FacturaCompra + " fc"
                    + " Where"
                    + " fc.id_proveedor = p.id and"
                    + " fc.id = " + id
                    + " ;";
        }
        return respuesta;
    }

    public String DetalleFacturaCompras(String metodo, String[] parametros, String id) {
        if (metodo == "insert") {
            respuesta = "Insert Into"
                    + " " + tabla.T_DetalleFacturaCompra + "(id_factura_compra,id_producto,descripcion_producto,cantidad,precio_unitario)"
                    + " values("
                    + "'" + parametros[0] + "',"
                    + "'" + parametros[1] + "',"
                    + "'" + parametros[2] + "',"
                    + "'" + parametros[3] + "',"
                    + "'" + parametros[4] + "')"
                    + " ;";
        } else if (metodo == "consultaGeneral") {
            respuesta = "Select "
                    + " p.codigo,"
                    + " dfc.descripcion_producto,"
                    + " dfc.cantidad,"
                    + " dfc.precio_unitario"
                    + " From"
                    + " " + tabla.T_Productos + " p,"
                    + " " + tabla.T_FacturaCompra + " fc,"
                    + " " + tabla.T_DetalleFacturaCompra + " dfc"
                    + " Where"
                    + " dfv.id_producto = p.id and"
                    + " dfv.id_factura_compra = fc.id and"
                    + " dfv.id_factura_compra = " + id
                    + " ;";
        }
        return respuesta;
    }

}
