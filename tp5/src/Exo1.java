import javax.swing.*;
import java.awt.*;

/**
 * crée une fenêtre JFrame qui affiche la taille de l'écran.
 */
public class Exo1 {
    /**
     * main
     *
     * @param args Les arguments de la ligne de commande.
     */
    public static void main(String[] args) {
        // Crée une nouvelle fenêtre avec le titre "Premier Fenetre"
        JFrame fenetre = new JFrame("Premier Fenetre");

        // Rendre la fenêtre visible
        fenetre.setVisible(true);

        // Définir l'opération de fermeture par défaut pour quitter l'application
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Obtenir la taille de l'écran
        Dimension dimEcran = fenetre.getToolkit().getScreenSize();

        // Créer un label avec le texte de la taille de l'écran
        JLabel label = new JLabel("Taille de l'écran : " + dimEcran);

        // Ajouter le label au contenu de la fenêtre
        fenetre.getContentPane().add(label);

        // Calculer la position pour centrer la fenêtre sur l'écran
        int x = (dimEcran.width - fenetre.getWidth()) / 2;
        int y = (dimEcran.height - fenetre.getHeight()) / 2;

        // Définir la position de la fenêtre
        fenetre.setLocation(x, y);

        // Ajuster la taille de la fenêtre pour s'adapter à son contenu
        fenetre.pack();
    }
}
