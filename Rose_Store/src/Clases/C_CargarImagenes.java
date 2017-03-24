
package Clases;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class C_CargarImagenes {
    Icon icono;
    C_Listado Ic = new C_Listado();
    
    public Icon IconoLogin(int W, int H){
        ImageIcon icoUsuario = new ImageIcon(Ic.Ic_Login);
        icono = new ImageIcon(icoUsuario.getImage().getScaledInstance(W, H, Image.SCALE_DEFAULT));
        return icono;
    }
    public Icon IconoCerrar(int W, int H){
        ImageIcon icoUsuario = new ImageIcon(Ic.Ic_Cerrar);
        icono = new ImageIcon(icoUsuario.getImage().getScaledInstance(W, H, Image.SCALE_DEFAULT));
        return icono;
    }
    
    public Icon IconoMesa(int W, int H){
        ImageIcon icoUsuario = new ImageIcon(Ic.Ic_Mesa);
        icono = new ImageIcon(icoUsuario.getImage().getScaledInstance(W, H, Image.SCALE_DEFAULT));
        return icono;
    }
    
    public Icon IconoMesaOcup(int W, int H){
        ImageIcon icoUsuario = new ImageIcon(Ic.Ic_MesaOcup);
        icono = new ImageIcon(icoUsuario.getImage().getScaledInstance(W, H, Image.SCALE_DEFAULT));
        return icono;
    }
    
    public Icon IconoUser(int W, int H){
        ImageIcon icoUsuario = new ImageIcon(Ic.Ic_User);
        icono = new ImageIcon(icoUsuario.getImage().getScaledInstance(W, H, Image.SCALE_DEFAULT));
        return icono;
    }
    
    public Icon IconoTeclado(int W, int H){
        ImageIcon icoUsuario = new ImageIcon(Ic.Ic_Teclado);
        icono = new ImageIcon(icoUsuario.getImage().getScaledInstance(W, H, Image.SCALE_DEFAULT));
        return icono;
    }
    
    public Icon IconoAceptar(int W, int H){
        ImageIcon icoUsuario = new ImageIcon(Ic.Ic_Aceptar);
        icono = new ImageIcon(icoUsuario.getImage().getScaledInstance(W, H, Image.SCALE_DEFAULT));
        return icono;
    }
    
    public Icon FondoLogin(int W, int H){
        ImageIcon icoUsuario = new ImageIcon(Ic.F_Login);
        icono = new ImageIcon(icoUsuario.getImage().getScaledInstance(W, H, Image.SCALE_DEFAULT));
        return icono;
    }
    
    public Icon FondoHome(int W, int H){
        ImageIcon icoUsuario = new ImageIcon(Ic.F_HomePage);
        icono = new ImageIcon(icoUsuario.getImage().getScaledInstance(W, H, Image.SCALE_DEFAULT));
        return icono;
    }
}
