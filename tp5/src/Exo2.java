import javax.swing.*;
import java.awt.*;

/**
 * crée une application Swing pour un jeu mystérieux.
 * Elle configure une fenêtre avec des boutons, des labels et une zone de saisie.
 */
public class Exo2 {
    /**
     * main crée une application JFrame,
     * définit ses propriétés, ajoute des composants d'interface utilisateur et les
     * positionne dans la fenêtre.
     *
     * @param args Arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args) {
        // Crée un nouveau JFrame avec le titre "Jeux Mysterieux"
        JFrame fenetre = new JFrame("Jeux Mysterieux");

        // Rendre la fenêtre visible
        fenetre.setVisible(true);

        // Définir l'opération de fermeture par défaut pour quitter l'application
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Définir la taille de la fenêtre
        fenetre.setSize(700, 700);

        // Créer les boutons, labels et zone de saisie
        JButton btnFin = new JButton("Fin");
        JButton btnCommencer = new JButton("Commencer");
        JLabel lblResultat = new JLabel("Trouver un nombre entre 0 et 99");
        JLabel lblNbCoups = new JLabel("0");
        JTextField txtSaisie = new JTextField(5);

        // Obtenir le conteneur de contenu de la fenêtre
        Container cont = fenetre.getContentPane();

        // Configurer les composants de l'interface utilisateur via LiaisonMystIG
        LiaisonMystIG.setBtnFin(btnFin);
        LiaisonMystIG.setBtnCommencer(btnCommencer);
        LiaisonMystIG.setLblResultat(lblResultat);
        LiaisonMystIG.setLblNbCoups(lblNbCoups);
        LiaisonMystIG.setZoneSaisie(txtSaisie);

        // Ajouter les composants au conteneur avec des positions spécifiques
        cont.add(btnFin, BorderLayout.EAST);
        cont.add(btnCommencer, BorderLayout.WEST);
        cont.add(lblResultat, BorderLayout.NORTH);
        cont.add(lblNbCoups, BorderLayout.SOUTH);
        cont.add(txtSaisie, BorderLayout.CENTER);
    }
}
