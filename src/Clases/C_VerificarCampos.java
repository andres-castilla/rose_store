
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
    
}
