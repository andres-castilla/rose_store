
package Clases;

import java.sql.*;

public class C_Connection {
    C_EditorTexto datosEditor = new C_EditorTexto();
    
    
    
    public Connection connection(){
        
        int j=0;
        String campo="";
        String[] datosConex = new String[4];
        String datos = datosEditor.cargarTxt("DatosConexion.txt");
        char[] caracteres = datos.toCharArray();
        for(int i=0; i<caracteres.length; i++){
            if(caracteres[i]!='-'){
                campo += String.valueOf(caracteres[i]);
            }else{
                datosConex[j] = campo;
                campo="";
                j++;
            }
        }
        
        Connection conect = null;
        try{            
            String controlador = "com.mysql.jdbc.Driver";
            Class.forName(controlador).newInstance();
            String conec = "jdbc:mysql://"+datosConex[0]+":3306/"+datosConex[3];
            String user = datosConex[1];
            String password = datosConex[2];
            conect = DriverManager.getConnection(conec,user,password);
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e){
            //JOptionPane.showMessageDialog(null,"Error al conectar con base de datos.\n Comuniquese con Area de Sistemas--"+e.getMessage());
        }
    return conect;
    }    
}

//public class C_Connection {
//    V_Data_Connection Data = new V_Data_Connection();
//    public Connection connection(){
//        Connection conect = null;
//        try{            
//            String controlador = "com.mysql.jdbc.Driver";
//            Class.forName(controlador).newInstance();
//            String conec = "jdbc:mysql://"+Data.TxtUrlBD.getText()+":3306/"+Data.TxtNombreBD.getText();
//            String user = Data.TxtUsuarioBD.getText();
//            String password = new String (Data.TxtContraseñaBD.getPassword());
//            conect = DriverManager.getConnection(conec,user,password);
//        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e){
//            //JOptionPane.showMessageDialog(null,"Error al conectar con base de datos.\n Comuniquese con Area de Sistemas--"+e.getMessage());
//        }
//    return conect;
//    }    
//}