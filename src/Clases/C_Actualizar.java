
package Clases;

import java.sql.*;
import javax.swing.*;


public class C_Actualizar {
    C_Connection con = new C_Connection();
    
    Connection conect = null;
    Statement st = null;
    ResultSet rs = null;
    String respuesta;
    //Integer val_consulta=0;
        public String update(String query){
            respuesta = "";
            try{
                conect = con.connection();
                st = conect.createStatement();
                st.executeUpdate(query);
                respuesta="ok";
                //JOptionPane.showMessageDialog(null,"Registro Actualizado");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Eror: "+e);
                respuesta = "no";
            }
            return respuesta;
        }    
    
}
