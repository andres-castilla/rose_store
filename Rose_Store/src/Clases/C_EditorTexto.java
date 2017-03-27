
package Clases;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class C_EditorTexto {
    
    public void nuevoTxt(String texto, String nombreArchivo){
        try {
            FileWriter fichero = new FileWriter(nombreArchivo);
            fichero.write(texto);
            fichero.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
    
    public String cargarTxt(String nombreArchivo){
        String datos="";
        try {
            FileReader archivo = new FileReader(nombreArchivo);
            BufferedReader br = new BufferedReader(archivo);
            datos = br.readLine();
            archivo.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Bienvenido.\nPor favor ingrese Datos de Conexión");
            //Logger.getLogger(C_EditorTexto.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return datos;
    }
    
}
