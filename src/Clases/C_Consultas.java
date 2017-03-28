package Clases;

import java.sql.*;
import javax.swing.*;

public class C_Consultas {

    C_Connection con = new C_Connection();
    private String dato_consulta[];
    private String dato_consulta2[][];
    private String validacion;
    Connection conect = null;
    Statement st = null;
    ResultSet rs = null;
    
    public String consulta_existencia(String query) {
        validacion = "";
        try {
            conect = con.connection();
            st = conect.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                validacion = rs.getString(1);
            }
            conect.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null,"Error: "+e);
        }
        return validacion;
    }//VALIDACION DE EXISTENCIA DE UN REGISTRO EN LA BASE DE DATOS

    public String[] consulta_existencia(String query, Integer cant_datos, String datos[]) {
        dato_consulta = new String[cant_datos];
        try {
            JOptionPane.showMessageDialog(null, "entra");
            conect = con.connection();
            JOptionPane.showMessageDialog(null, "conecta");
            st = conect.createStatement();
            JOptionPane.showMessageDialog(null, "ejecuta1");
            rs = st.executeQuery(query);
            
            while (rs.next()) {
                for (int x = 0; x < cant_datos; x++) {
                    dato_consulta[x] = rs.getString(datos[x]);
                    JOptionPane.showMessageDialog(null, dato_consulta[x]);
                }
            }
            conect.close();
        } catch (Exception e) {
            dato_consulta[0] = "Error";
            dato_consulta[1] = e.toString();
            if (cant_datos > 2) {
                for (int i = 2; i < cant_datos; i++) {
                    dato_consulta[i] = "";
                }
            }
        }
        return dato_consulta;
    }//CONSULTA EN LA BASE DE DATOS Y TRAER VARIOS DATOS DE UN REGISTRO FUNCIONA CON UN LISTADO DE CAMPOS EN UN VECTOR

    public String[] consulta_existencia(String query, Integer cant_datos, String datos) {
        dato_consulta = new String[cant_datos];
        try {
            conect = con.connection();
            st = conect.createStatement();
            rs = st.executeQuery(query);
            int x = 0;
            while (rs.next()) {
                dato_consulta[x] = rs.getString(datos);
                x++;
            }
            conect.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return dato_consulta;
    }//CONSULTA EN LA BASE DE DATOS Y TRAE UN DATO DE UN REGISTRO FUNCIONA CON UN SOLO PARAMETRO DE BUSQUEDA

    public String[][] consulta_existencia(String query, Integer fila, Integer column, String datos[]) {
        dato_consulta2 = new String[fila][column];
        try {
            conect = con.connection();
            st = conect.createStatement();
            rs = st.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                for (int j = 0; j < column; j++) {
                    dato_consulta2[i][j] = rs.getString(datos[j]);
                }
                i++;
            }
            conect.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return dato_consulta2;
    }
}
