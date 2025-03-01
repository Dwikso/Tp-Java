import javax.swing.*;
import java.awt.*;

public class DecouvreImage {
    public static void main(String[] args) {
        JFrame fenetre = new JFrame("Decouvre Image");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(500, 500);
        fenetre.setLayout(new GridLayout(2, 2));

        for (int i = 0; i < 4; i++) {
            UneImage imgBtn = new UneImage(i);
            fenetre.add(imgBtn);
        }
        fenetre.setVisible(true);
    }
}
