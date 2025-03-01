import javax.swing.*;
import java.awt.*;

public class Exo1 {
    public static void main(String[] args) {
           JFrame fenetre = new JFrame("Premier Fenetre");
           fenetre.setVisible(true);
           fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           Dimension dimEcran = fenetre.getToolkit().getScreenSize();
           JLabel label = new JLabel("Taille de l'écran : " + dimEcran);
           fenetre.getContentPane().add(label);
           int x = (dimEcran.width - fenetre.getWidth()) /2;
           int y = (dimEcran.height - fenetre.getHeight()) / 2;
           fenetre.setLocation(x,y);
           fenetre.pack();
    }
}