
package Clases;

import java.awt.Color;


public class C_Listado {
    //LISTADO DE DIRECCIONES DE IMAGENES
    //static String externo = "../";
    static String externo = "";
    public String F_Login = externo+"src/Imagenes/Fondo.jpg";
    public String F_HomePage = externo+"src/Imagenes/FondoHome.jpg";//MONTAR LA IMGAEN DE FONDO DEL SOFTWARE EN LA CARPETA IMAGENES
    public String I_Ajuste = externo+"src/Imagenes/Ico_Ajustes.png";
    public String I_Nuevo = externo+"src/Imagenes/Ico_Nuevo.png";
    public String I_Aceptar = externo+"src/Imagenes/Ico_Aceptar.png";
    public Color colorBusqueda = new Color(192,192,192);
    
    //LISTADO DE TABLAS
    String bd = "aa_software";
    public String T_InformacionEmpresa = bd+"."+"t_informacion_empresa";
    public String T_Usuarios = bd+"."+"t_usuarios";
    public String T_Clientes = bd+"."+"t_clientes";
    public String T_Proveedores = bd+"."+"t_proveedores";
    public String T_Almacenes = bd+"."+"t_almacenes";
    public String T_ClaseProductos = bd+"."+"t_clase_productos";
    public String T_Productos = bd+"."+"t_productos";
    public String T_ListaPrecio = bd+"."+"t_lista_precios";
    public String T_FacturaVenta = bd+"."+"t_factura_ventas";
    public String T_DetalleFacturaVenta = bd+"."+"t_detalle_factura_ventas";
    public String T_FacturaCompra = bd+"."+"t_factura_compras";
    public String T_DetalleFacturaCompra = bd+"."+"t_detalle_factura_compras";
}
