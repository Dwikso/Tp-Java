import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * implémente l'interface MouseListener pour gérer les événements de la souris.
 * Elle est associée à un objet UneImage et affiche l'image lorsque le bouton de la souris est cliqué.
 */
public class EcouteurSouris extends MouseAdapter {
    private final UneImage uneImage;

    /**
     * Constructeur de la classe EcouteurSouris.
     *
     * @param uneImage L'objet UneImage associé à cet écouteur de souris.
     */
    public EcouteurSouris(UneImage uneImage) {
        this.uneImage = uneImage;
    }

    /**
     * Méthode appelée lorsque le bouton de la souris est cliqué.
     *
     * @param e L'événement de la souris.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        uneImage.demarrerTimer();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        uneImage.arreterTimer();
    }
}
