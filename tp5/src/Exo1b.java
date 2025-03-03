import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * application Swing simple qui crée une fenêtre
 * affichant une image centrée sur l'écran.
 */
public class Exo1b {
    /**
     *  crée une application JFrame,
     * définit ses propriétés, ajoute une image et centre la fenêtre sur l'écran.
     *
     * @param args Arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args) {
        // Crée un nouveau JFrame avec le titre "Premier Fenetre"
        JFrame fenetre = new JFrame("Premier Fenetre");

        // Rendre la fenêtre visible
        fenetre.setVisible(true);

        // Définir l'opération de fermeture par défaut pour quitter l'application
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Obtenir les dimensions de l'écran
        Dimension dimEcran = fenetre.getToolkit().getScreenSize();

        // Charger l'image depuis les ressources
        URL url = Exo1b.class.getResource("images/Bird2.gif");
        JLabel label = new JLabel(new ImageIcon(url));

        // Ajouter le label de l'image au contenu de la fenêtre
        fenetre.getContentPane().add(label);

        // Calculer les coordonnées x et y pour centrer la fenêtre sur l'écran
        int x = (dimEcran.width - fenetre.getWidth()) / 2;
        int y = (dimEcran.height - fenetre.getHeight()) / 2;

        // Définir la position de la fenêtre aux coordonnées calculées
        fenetre.setLocation(x, y);

        // Ajuster la taille des composants dans la fenêtre
        fenetre.pack();
    }
}
