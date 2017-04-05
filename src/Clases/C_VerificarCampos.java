
package Clases;

import javax.swing.JOptionPane;


public class C_VerificarCampos {
    String val = "no";
    
    public String CamposLoggin(String usuario, String contrasena){
        if(usuario.equals("")){
            JOptionPane.showMessageDialog(null,"Debe Digitar campo 'Usuario'");
        }else if(contrasena.equals("")){
            JOptionPane.showMessageDialog(null,"Debe Digitar campo 'Clave'");
        }else{
            val = "ok";
        }
        return val;
    }
    
    public String CamposClaseArticulos(String clase, String estado){
        if(clase.equals("")){
            JOptionPane.showMessageDialog(null,"Debe Digitar campo 'Nombre Clase'");
        }else if(estado.equals("Seleccionar")){
            JOptionPane.showMessageDialog(null,"Debe Escoger 'Estado'");
        }else{
            val = "ok";
        }
        return val;
    }
    
    
    public String CamposArticulo(String idclase, String codigo, String descripcion, String estado){
        if(idclase.equals("")){
            JOptionPane.showMessageDialog(null,"Debe Escoger 'Clase de Producto'");
        }else if(codigo.equals("")){
            JOptionPane.showMessageDialog(null,"Debe Digitar campo 'Codigo'");
        }else if(descripcion.equals("")){
            JOptionPane.showMessageDialog(null,"Debe Digitar campo 'Descripción'");
        }else if(estado.equals("Seleccionar")){
            JOptionPane.showMessageDialog(null,"Debe Escoger 'Estado'");
        }else{
            val = "ok";
        }
        return val;
    }
}
