import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModeleMemory {
    private List<String> cartes;
    private int essais;
    private int pairesTrouvees;
    private String[] images = {
        "/images/Bird.gif", "/images/Bird2.gif", "/images/Cat.gif", "/images/Cat2.gif",
        "/images/Dog.gif", "/images/Dog2.gif", "/images/Pig.gif", "/images/Rabbit.gif"
    };

    public ModeleMemory(int nombrePaires) {
        this.cartes = new ArrayList<>();
        for (int i = 0; i < nombrePaires; i++) {
            if (i < images.length) {
                cartes.add(images[i]);
                cartes.add(images[i]);
            }
        }
        Collections.shuffle(cartes);
        this.essais = 0;
        this.pairesTrouvees = 0;
    }

    public List<String> getCartes() {
        return cartes;
    }

    public void incrementerEssais() {
        essais++;
    }

    public void incrementerPairesTrouvees() {
        pairesTrouvees++;
    }

    public int getEssais() {
        return essais;
    }

    public int getPairesTrouvees() {
        return pairesTrouvees;
    }
}
