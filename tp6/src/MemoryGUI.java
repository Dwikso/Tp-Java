import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class MemoryGUI extends JFrame {
    URL inconnu = getClass().getResource("/images/Inconnu.gif");
    private ModeleMemory modele;
    private JButton[] boutons;
    private int[] cartesRetournees = {-1, -1};
    private JLabel labelEssais, labelScore;

    public MemoryGUI(int nombrePaires) {
        modele = new ModeleMemory(nombrePaires);
        setTitle("Jeu de Memory");
        setSize(600, 600);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel pour les cartes
        JPanel panelCartes = new JPanel(new GridLayout(4, 4));
        boutons = new JButton[nombrePaires * 2];
        for (int i = 0; i < boutons.length; i++) {
            boutons[i] = new JButton(new ImageIcon(inconnu));
            boutons[i].setFont(new Font("Arial", Font.BOLD, 20));
            boutons[i].addActionListener(new CarteClickListener(i));
            panelCartes.add(boutons[i]);
        }

        // Barre de menu
        creerMenu();

        // Panneau d'informations
        JPanel panelInfos = new JPanel();
        labelEssais = new JLabel("Essais : 0");
        labelScore = new JLabel("Paires trouvées : 0");
        panelInfos.add(labelEssais);
        panelInfos.add(labelScore);

        // Ajout des composants à la fenêtre
        add(panelCartes, BorderLayout.CENTER);
        add(panelInfos, BorderLayout.SOUTH);
    }

    private class CarteClickListener implements ActionListener {
        private int index;

        public CarteClickListener(int index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (cartesRetournees[0] == -1) {
                cartesRetournees[0] = index;
                boutons[index].setIcon(new ImageIcon(getClass().getResource(modele.getCartes().get(index))));
            } else if (cartesRetournees[1] == -1) {
                cartesRetournees[1] = index;
                boutons[index].setIcon(new ImageIcon(getClass().getResource(modele.getCartes().get(index))));
                verifierPaire();
            }
        }
    }

    private void verifierPaire() {
        int carte1 = cartesRetournees[0];
        int carte2 = cartesRetournees[1];

        if (modele.getCartes().get(carte1).equals(modele.getCartes().get(carte2))) {
            modele.incrementerPairesTrouvees();
            boutons[carte1].setEnabled(false);
            boutons[carte2].setEnabled(false);
        } else {
            Timer timer = new Timer(1000, e -> {
                boutons[carte1].setIcon(new ImageIcon(inconnu));
                boutons[carte2].setIcon(new ImageIcon(inconnu));
            });
            timer.setRepeats(false);
            timer.start();
        }

        cartesRetournees[0] = -1;
        cartesRetournees[1] = -1;
        modele.incrementerEssais();

        labelEssais.setText("Essais : " + modele.getEssais());
        labelScore.setText("Paires trouvées : " + modele.getPairesTrouvees());

        if (modele.getPairesTrouvees() == boutons.length / 2) {
            JOptionPane.showMessageDialog(this, "Bravo ! Vous avez gagné en " + modele.getEssais() + " essais !");
        }
    }

    private void resetGame() {
        modele = new ModeleMemory(8);
        for (JButton bouton : boutons) {
            bouton.setIcon(new ImageIcon(inconnu));
            bouton.setEnabled(true);
        }
        labelEssais.setText("Essais : 0");
        labelScore.setText("Paires trouvées : 0");
    }

    private void creerMenu() {
        JMenuBar menuBar = new JMenuBar();

        // Menu Jeu
        JMenu menuJeu = new JMenu("Jeu");
        JMenuItem nouvellePartie = new JMenuItem("Nouvelle Partie");
        nouvellePartie.addActionListener(e -> resetGame());
        JMenuItem quitter = new JMenuItem("Quitter");
        quitter.addActionListener(e -> System.exit(0));
        menuJeu.add(nouvellePartie);
        menuJeu.add(quitter);

        JMenu menuAide = new JMenu("Aide");

        menuBar.add(menuJeu);
        menuBar.add(menuAide);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        new MemoryGUI(8).setVisible(true);
    }
}
