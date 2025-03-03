import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * La classe GereClickBouton implémente l'interface ActionListener pour gérer les clics sur un bouton.
 * Elle change l'icône du bouton à chaque clic en parcourant un tableau d'images.
 */
public class GereClickBouton implements ActionListener {
    private int compteur = 0; // Compteur pour suivre l'index de l'image actuelle
    private final JButton btn; // Le bouton dont l'icône sera changée

    /**
     * Constructeur de la classe GereClickBouton.
     * @param btn Le bouton dont l'icône sera changée
     */
    public GereClickBouton(JButton btn) {
        this.btn = btn;
    }

    /**
     * Méthode appelée lorsqu'une action est effectuée (clic sur le bouton).
     * @param e L'événement d'action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Incrémente le compteur et le remet à zéro si nécessaire
        compteur = (compteur + 1) % MaPremiereAppliGraphique.TABIMAGES.length;
        // Change l'icône du bouton
        btn.setIcon(MaPremiereAppliGraphique.TABIMAGES[compteur]);
    }
}
