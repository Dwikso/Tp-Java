import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GereClickBouton implements ActionListener {
    private int compteur = 0;
    private final JButton btn;

    public GereClickBouton(JButton btn) {
        this.btn = btn;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        compteur = (compteur + 1) % MaPremiereAppliGraphique.TABIMAGES.length;
        btn.setIcon(MaPremiereAppliGraphique.TABIMAGES[compteur]);
    }
}
