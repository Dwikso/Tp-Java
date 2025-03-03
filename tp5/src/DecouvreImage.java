import javax.swing.*;
import java.awt.*;

/**
 * crée une fenêtre avec une grille de boutons d'image.
 * Chaque bouton affiche une image différente lorsqu'il est cliqué.
 */
public class DecouvreImage {

    /**
     * main
     *
     * @param args Les arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args) {
        JFrame fenetre = new JFrame("Decouvre Image");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(500, 500);
        fenetre.setLayout(new GridLayout(2, 2));

        // Ajoute 4 boutons d'image à la fenêtre
        for (int i = 0; i < 4; i++) {
            UneImage imgBtn = new UneImage(i);
            fenetre.add(imgBtn);
        }
        fenetre.setVisible(true);
    }
}
