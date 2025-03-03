import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

/**
 * La classe Exo2d crée une application GUI simple en utilisant Swing.
 * L'application consiste en une JFrame avec plusieurs composants :
 * Un bouton "Fin"
 * Un bouton "Commencer"
 * Un label affichant un message pour trouver un nombre entre 0 et 99
 * Un label affichant le nombre de tentatives
 * Un champ de texte pour la saisie de l'utilisateur
 *
 * Les composants sont disposés en utilisant un GridBagLayout.
 */
public class Exo2d {
    public static void main(String[] args) {
        // Crée la fenêtre principale de l'application
        JFrame fenetre = new JFrame("Jeux Mysterieux FlowLayout");
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(700, 700);

        // Crée les composants
        JButton btnFin = new JButton("Fin");
        JButton btnCommencer = new JButton("Commencer");
        JLabel lblResultat = new JLabel("Trouver un nombre entre 0 et 99");
        JLabel lblNbCoups = new JLabel("0");
        JTextField txtSaisie = new JTextField(5);

        // Obtient le conteneur de contenu et définit la disposition
        Container cont = fenetre.getContentPane();
        cont.setLayout(new GridBagLayout(3, 2));

        // Définit les composants dans la classe LiaisonMystIG
        LiaisonMystIG.setBtnFin(btnFin);
        LiaisonMystIG.setBtnCommencer(btnCommencer);
        LiaisonMystIG.setLblResultat(lblResultat);
        LiaisonMystIG.setLblNbCoups(lblNbCoups);
        LiaisonMystIG.setZoneSaisie(txtSaisie);

        // Ajoute les composants au conteneur de contenu
        cont.add(btnFin, BorderLayout.EAST);
        cont.add(btnCommencer, BorderLayout.WEST);
        cont.add(lblResultat, BorderLayout.NORTH);
        cont.add(lblNbCoups, BorderLayout.SOUTH);
        cont.add(txtSaisie, BorderLayout.CENTER);
    }
}
