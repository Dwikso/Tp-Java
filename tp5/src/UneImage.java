import javax.swing.*;
import java.net.URL;

public class UneImage extends JButton {
    private static final ImageIcon[] TABIMAGES = MaPremiereAppliGraphique.TABIMAGES;
    private static final URL url = UneImage.class.getResource("images/Rien.gif");
    private static final ImageIcon RIEN = new ImageIcon(url);

    private final int compteur;

    public UneImage(int compteur) {
        super(RIEN);
        this.compteur = compteur;
        addMouseListener(new EcouteurSouris(this));
    }

    public void montrerImage() {
        if (compteur >= 0 && compteur < TABIMAGES.length) {
            setIcon(TABIMAGES[compteur]);
        }
    }
}
