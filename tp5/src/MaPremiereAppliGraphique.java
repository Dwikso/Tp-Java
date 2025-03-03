import java.util.Random;
import javax.swing.*;
import java.net.URL;

/**
 * La classe MaPremiereAppliGraphique crée une application graphique simple
 * qui affiche une fenêtre avec un bouton. L'icône du bouton est choisie
 * aléatoirement parmi un ensemble d'images.
 */
public class MaPremiereAppliGraphique {

    // URLs des images utilisées pour les icônes
    static URL url = MaPremiereAppliGraphique.class.getResource("images/Bird.gif");
    static URL url2 = MaPremiereAppliGraphique.class.getResource("images/Bird2.gif");
    static URL url3 = MaPremiereAppliGraphique.class.getResource("images/Cat.gif");
    static URL url4 = MaPremiereAppliGraphique.class.getResource("images/Cat2.gif");
    static URL url5 = MaPremiereAppliGraphique.class.getResource("images/Dog.gif");
    static URL url6 = MaPremiereAppliGraphique.class.getResource("images/Rabbit.gif");
    static URL url7 = MaPremiereAppliGraphique.class.getResource("images/Pig.gif");

    // Tableau d'ImageIcons initialisé avec les URLs des images
    public static final ImageIcon[] TABIMAGES = {
        new ImageIcon(url),
        new ImageIcon(url2),
        new ImageIcon(url3),
        new ImageIcon(url4),
        new ImageIcon(url5),
        new ImageIcon(url6),
        new ImageIcon(url7)
    };

    /**
     * Méthode principale qui crée la fenêtre et le bouton avec une icône aléatoire.
     * @param args Arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args) {
        JFrame fenetre = new JFrame("Les images");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(500, 500);

        // Création du bouton
        JButton leBtn = new JButton();
        leBtn.setIcon(TABIMAGES[new Random().nextInt(TABIMAGES.length)]);
        leBtn.addActionListener(new GereClickBouton(leBtn));

        // Ajout du bouton à la fenêtre
        fenetre.add(leBtn);
        fenetre.setVisible(true);
    }
}
