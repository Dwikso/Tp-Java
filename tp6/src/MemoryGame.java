import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemoryGame extends JFrame {
    private URL inconnu = getClass().getResource("/images/Inconnu.gif");
    private URL trouve = getClass().getResource("/images/Rien.gif");
    private List<String> cartes;
    private int essais;
    private int pairesTrouvees;
    private String[] images = {
            "/images/Bird.gif", "/images/Bird2.gif", "/images/Cat.gif", "/images/Cat2.gif",
            "/images/Dog.gif", "/images/Dog2.gif", "/images/Pig.gif", "/images/Rabbit.gif"
    };
    private JButton[] boutons;
    private int[] cartesRetournees = { -1, -1 };
    private JLabel labelEssais, labelScore;

    /**
     * Constructeur de la classe MemoryGame.
     * 
     * @param nombrePaires Le nombre de paires de cartes dans le jeu.
     */
    public MemoryGame(int nombrePaires) {
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

        JFrame fenetre = new JFrame("Jeu de Memory");
        fenetre.setTitle("Jeu de Memory");
        fenetre.setSize(600, 600);
        fenetre.setLayout(new BorderLayout());
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelCartes = new JPanel(new GridLayout(4, 4));
        boutons = new JButton[nombrePaires * 2];
        for (int i = 0; i < boutons.length; i++) {
            boutons[i] = new JButton(new ImageIcon(inconnu));
            boutons[i].addActionListener(new CarteClickListener(i));
            panelCartes.add(boutons[i]);
        }

        creerMenu(fenetre);

        JPanel panelInfos = new JPanel();
        labelEssais = new JLabel("Essais : 0");
        labelScore = new JLabel("Paires trouvées : 0");
        panelInfos.add(labelEssais);
        panelInfos.add(labelScore);

        fenetre.add(panelCartes, BorderLayout.CENTER);
        fenetre.add(panelInfos, BorderLayout.SOUTH);
        fenetre.setVisible(true);
    }

    /**
     * gére les clics sur les cartes.
     */
    private class CarteClickListener implements ActionListener {
        private int index;

        public CarteClickListener(int index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (cartesRetournees[0] == -1) {
                cartesRetournees[0] = index;
                boutons[index].setIcon(new ImageIcon(getClass().getResource(cartes.get(index))));
            } else if (cartesRetournees[1] == -1 && cartesRetournees[0] != index) {
                cartesRetournees[1] = index;
                boutons[index].setIcon(new ImageIcon(getClass().getResource(cartes.get(index))));
                verifierPaire();
            }
        }
    }

    /**
     * Active ou désactive toutes les cartes.
     * 
     * @param etat L'état à appliquer aux cartes pour evtier de clicker sur une
     *             cartes pendant la verification d'une paire.
     */
    private void setCartesActives(boolean etat) {
        for (JButton bouton : boutons) {
            bouton.setEnabled(etat);
        }
    }

    /**
     * Vérifie si les deux cartes retournées forment une paire.
     */

    private void verifierPaire() {
        int carte1 = cartesRetournees[0];
        int carte2 = cartesRetournees[1];

        setCartesActives(false);

        if (cartes.get(carte1).equals(cartes.get(carte2))) {
            incrementerPairesTrouvees();
            boutons[carte1].setEnabled(false);
            boutons[carte2].setEnabled(false);

            boutons[carte1].setIcon(new ImageIcon(trouve));
            boutons[carte2].setIcon(new ImageIcon(trouve));

            setCartesActives(true);
        } else {
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boutons[carte1].setIcon(new ImageIcon(inconnu));
                    boutons[carte2].setIcon(new ImageIcon(inconnu));
                    setCartesActives(true);
                }
            });
            timer.setRepeats(false);
            timer.start();
        }

        cartesRetournees[0] = -1;
        cartesRetournees[1] = -1;
        incrementerEssais();

        labelEssais.setText("Essais : " + getEssais());
        labelScore.setText("Paires trouvées : " + getPairesTrouvees());

        if (getPairesTrouvees() == boutons.length / 2) {
            JOptionPane.showMessageDialog(this, "Bravo ! Vous avez gagné en " + getEssais() + " essais !");
        }
    }

    /**
     * Réinitialise le jeu.
     */
    private void resetGame() {
        this.cartes = new ArrayList<>();
        for (int i = 0; i < boutons.length / 2; i++) {
            if (i < images.length) {
                cartes.add(images[i]);
                cartes.add(images[i]);
            }
        }
        Collections.shuffle(cartes);
        this.essais = 0;
        this.pairesTrouvees = 0;

        for (JButton bouton : boutons) {
            bouton.setIcon(new ImageIcon(inconnu));
            bouton.setEnabled(true);
        }
        labelEssais.setText("Essais : 0");
        labelScore.setText("Paires trouvées : 0");
    }

    /**
     * Crée le menu du jeu.
     */
    private void creerMenu(JFrame fenetre) {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuJeu = new JMenu("Jeu");
        JMenuItem nouvellePartie = new JMenuItem("Nouvelle Partie");
        nouvellePartie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
        JMenuItem quitter = new JMenuItem("Quitter");
        quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuJeu.add(nouvellePartie);
        menuJeu.add(quitter);

        JMenu menuAide = new JMenu("Aide");

        menuBar.add(menuJeu);
        menuBar.add(menuAide);
        fenetre.setJMenuBar(menuBar);
    }

    /**
     * Incrémente le nombre d'essais.
     */
    public void incrementerEssais() {
        essais++;
    }

    /**
     * Incrémente le nombre de paires trouvées.
     */
    public void incrementerPairesTrouvees() {
        pairesTrouvees++;
    }

    /**
     * Retourne le nombre d'essais.
     * 
     * @return Le nombre d'essais.
     */
    public int getEssais() {
        return essais;
    }

    /**
     * Retourne le nombre de paires trouvées.
     * 
     * @return Le nombre de paires trouvées.
     */
    public int getPairesTrouvees() {
        return pairesTrouvees;
    }

    /**
     * Point d'entrée principal du jeu.
     * 
     * @param args Les arguments de la ligne de commande.
     */
    public static void main(String[] args) {
        MemoryGame game = new MemoryGame(8);
        game.setVisible(true);
    }
}
