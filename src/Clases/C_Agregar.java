
package Clases;

import java.sql.*;
import javax.swing.*;

public class C_Agregar {
    C_Connection con = new C_Connection();
    
    Connection conect = null;
    Statement st = null;
    ResultSet rs = null;
    String query;
    String respuesta;
    
    public String agregar(String tabla, String campos, String valores){
        respuesta = "";
        try{
            query = "insert into "+tabla+"("+campos+") values ('"+valores+"')";
            conect = con.connection();
            st=conect.createStatement();
            st.executeUpdate(query);
            conect.close();
            respuesta = "ok";
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error"+e);
        }
        return respuesta;
    }        
}
