
package Clases;


public class C_Listado {
    //LISTADO DE DIRECCIONES DE IMAGENES
    //static String externo = "../";
    static String externo = "";
    public String Ic_Login = externo+"src/Iconos/Login.png";
    public String Ic_Cerrar = externo+"src/Iconos/Close.png";
    public String Ic_Mesa = externo+"src/Iconos/Mesa.png";
    public String Ic_MesaOcup = externo+"src/Iconos/MesaOcup.png";
    public String Ic_User = externo+"src/Iconos/User.png";
    public String Ic_Teclado = externo+"src/Iconos/Teclado.png";
    public String Ic_Aceptar = externo+"src/Iconos/Aceptar.png";
    public String F_Login = externo+"src/Fondos/I_FondoApp.jpg";
    public String F_HomePage = externo+"src/Fondos/I_MenuApp2.jpg";
    
    //LISTADO DE TABLAS
    String bd = "aa_software";
    public String T_InformacionEmpresa = bd+"."+"t_informacion_empresa";
    public String T_Usuarios = bd+"·"+"t_usuarios";
    public String T_Clientes = bd+"·"+"t_clientes";
    public String T_Proveedores = bd+"·"+"t_proveedores";
    public String T_Almacenes = bd+"·"+"t_almacenes";
    public String T_ClaseProductos = bd+"·"+"t_clase_productos";
    public String T_Productos = bd+"·"+"t_productos";
    public String T_ListaPrecio = bd+"·"+"t_lista_precios";
    public String T_FacturaVenta = bd+"·"+"t_factura_ventas";
    public String T_DetalleFacturaVenta = bd+"·"+"t_detalle_factura_ventas";
    public String T_FacturaCompra = bd+"·"+"t_factura_compras";
    public String T_DetalleFacturaCompra = bd+"·"+"t_detalle_factura_compras";
}
