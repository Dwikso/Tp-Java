import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Exo1b {
    public static void main(String[] args) {
           JFrame fenetre = new JFrame("Premier Fenetre");
           fenetre.setVisible(true);
           fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
           Dimension dimEcran = fenetre.getToolkit().getScreenSize();

           URL url = Exo1b.class.getResource("images/Bird2.gif");
            JLabel label = new JLabel(new ImageIcon(url));
           
           fenetre.getContentPane().add(label);
           int x = (dimEcran.width - fenetre.getWidth()) /2;
           int y = (dimEcran.height - fenetre.getHeight()) / 2;
           fenetre.setLocation(x,y);
           fenetre.pack();
    }
}