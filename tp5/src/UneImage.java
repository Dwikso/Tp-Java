import javax.swing.*;
import java.net.URL;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * La classe UneImage représente un bouton avec une image.
 * Elle hérite de la classe JButton et permet d'afficher une image parmi un tableau d'images.
 */
public class UneImage extends JButton implements ActionListener {
    // Tableau d'images provenant de la classe MaPremiereAppliGraphique
    private static final ImageIcon[] TABIMAGES = MaPremiereAppliGraphique.TABIMAGES;

    // URL de l'image par défaut "Rien.gif"
    private static final URL url = UneImage.class.getResource("images/Rien.gif");

    // Image par défaut affichée sur le bouton
    private static final ImageIcon RIEN = new ImageIcon(url);

    // Compteur pour déterminer quelle image afficher
    private final int compteur;

    // Attribut Timer
    private final Timer timer;

    // Attribut pour basculer l'affichage
    private boolean afficherRien;

    /**
     * Constructeur de la classe UneImage.
     * Initialise le bouton avec l'image par défaut et ajoute un écouteur de souris.
     *
     * @param compteur l'index de l'image à afficher dans le tableau TABIMAGES
     */
    public UneImage(int compteur) {
        super(RIEN);
        this.compteur = compteur;
        this.afficherRien = true;
        this.timer = new Timer(200, this);
        addMouseListener(new EcouteurSouris(this));
    }

    /**
     * Méthode pour afficher l'image correspondant au compteur.
     * Si le compteur est valide, l'image correspondante dans le tableau TABIMAGES est affichée.
     */
    public void montrerImage() {
        if (compteur >= 0 && compteur < TABIMAGES.length) {
            setIcon(TABIMAGES[compteur]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (afficherRien) {
            setIcon(RIEN);
        } else {
            montrerImage();
        }
        afficherRien = !afficherRien;
    }

    // Méthode pour démarrer le Timer
    public void demarrerTimer() {
        timer.start();
    }

    // Méthode pour arrêter le Timer
    public void arreterTimer() {
        timer.stop();
    }
}
