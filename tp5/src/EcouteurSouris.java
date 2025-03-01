import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EcouteurSouris implements MouseListener {
    private final UneImage imgBtn;

    public EcouteurSouris(UneImage imgBtn) {
        this.imgBtn = imgBtn;
    }
    public void mouseClicked(MouseEvent e) {
        imgBtn.montrerImage();
    }
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
