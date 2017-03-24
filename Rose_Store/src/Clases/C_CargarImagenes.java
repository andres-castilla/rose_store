
package Clases;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class C_CargarImagenes {
    Icon icono;
    C_Listado Ic = new C_Listado();
    
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
