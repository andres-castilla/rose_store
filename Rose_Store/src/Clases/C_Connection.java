
package Clases;

import java.sql.*;


public class C_Connection {
    public Connection connection(){
        Connection conect = null;
        try{            
            String controlador = "com.mysql.jdbc.Driver";
            Class.forName(controlador).newInstance();
            String conec = "jdbc:mysql://localhost:3306/project";
            String user = "root";
            String password = "Solution";
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