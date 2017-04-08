
//package Reportes;
//import Class.*;
//import javax.swing.JOptionPane;
//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.view.JasperViewer;
//
//public class C_EjecutarReporte {
//    Class_Connection conec = new Class_Connection();
//    public void R_CuentasPorPagar(){
//        try{
//            JasperReport R_CuentasPorPagar = JasperCompileManager.compileReport("R_CuentasPorPagar_1.jrxml");
//            JasperPrint Print = JasperFillManager.fillReport(R_CuentasPorPagar, null,conec.connection());
//            JasperViewer ver = new JasperViewer(Print, false);
//            ver.setVisible(true);
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null,"Error:"+e);
//        }
//    }
//}
