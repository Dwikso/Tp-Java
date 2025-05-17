package vueGraphique;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import modele.Carte;
import modele.Lecture;
import modele.Direction;

/**
 * Classe VueSokoban qui gère l'affichage du jeu Sokoban
 * Elle étend JPanel et implémente KeyListener pour gérer les entrées clavier
 */
public class VueSokoban extends JPanel implements KeyListener {
  private Carte carte;
  private final int TAILLE_CASE = 60;

  // Chargement des images
  private static final URL joueurBas = VueSokoban.class.getResource("/img/Bas.gif");
  private static final URL joueurHaut = VueSokoban.class.getResource("/img/Haut.gif");
  private static final URL joueurGauche = VueSokoban.class.getResource("/img/Gauche.gif");
  private static final URL joueurDroite = VueSokoban.class.getResource("/img/Droite.gif");
  private static final URL mur = VueSokoban.class.getResource("/img/mur.gif");
  private static final URL sol = VueSokoban.class.getResource("/img/sol.gif");
  private static final URL caisse = VueSokoban.class.getResource("/img/caisse1.gif");
  private static final URL destination = VueSokoban.class.getResource("/img/but.gif");
  private static final URL caisseDestination = VueSokoban.class.getResource("/img/caisse2.gif");

  // Chemins des niveaux
  private String[] niveaux = { "bin/map/map1.txt", "bin/map/map2.txt", "bin/map/map3.txt" };
  private int niveauActuel = 0;

  // Images pour le joueur et les objets
  // (Mur, Sol, Caisse, Destination, Caisse sur Destination)
  // (Joueur en bas, haut, gauche, droite)
  private final Image imgJoueurBas, imgJoueurHaut, imgJoueurGauche, imgJoueurDroite;
  private final Image imgMur, imgSol, imgCaisse, imgDestination, imgCaisseDestination;

  /**
   * Constructeur de la classe VueSokoban
   * Initialise la carte et les images
   *
   * @param fichierCarte Le chemin du fichier de la carte
   */
  public VueSokoban(String fichierCarte) {
    carte = new Carte(Lecture.lireCarte(fichierCarte));
    setPreferredSize(new Dimension(carte.getLargeur() * TAILLE_CASE, carte.getHauteur() * TAILLE_CASE));

    setFocusable(true);
    addKeyListener(this);

    imgMur = chargerImage(mur);
    imgSol = chargerImage(sol);
    imgCaisse = chargerImage(caisse);
    imgDestination = chargerImage(destination);
    imgCaisseDestination = chargerImage(caisseDestination);

    imgJoueurBas = chargerImage(joueurBas);
    imgJoueurHaut = chargerImage(joueurHaut);
    imgJoueurGauche = chargerImage(joueurGauche);
    imgJoueurDroite = chargerImage(joueurDroite);
  }

  /**
   * Méthode pour charger une image à partir d'une URL
   *
   * @param url L'URL de l'image à charger
   * @return L'image chargée
   */
  private Image chargerImage(URL url) {
    if (url == null) {
      System.out.println("⚠ ERREUR : Impossible de charger l'image !");
      return new ImageIcon().getImage();
    }
    return new ImageIcon(url).getImage();
  }

  /**
   * Méthode pour gérer les événements de touche pressée
   *
   * @param e L'événement de touche pressée
   */
  @Override
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    switch (key) {
      case KeyEvent.VK_UP -> carte.deplacerJoueur(Direction.HAUT);
      case KeyEvent.VK_DOWN -> carte.deplacerJoueur(Direction.BAS);
      case KeyEvent.VK_LEFT -> carte.deplacerJoueur(Direction.GAUCHE);
      case KeyEvent.VK_RIGHT -> carte.deplacerJoueur(Direction.DROITE);
    }
    repaint();

    if (carte.estTerminee()) {
      finDePartieNiveau();
    }
  }

  /**
   * Méthode pour gérer la fin de niveau
   */
  private void finDePartieNiveau() {
    JOptionPane.showMessageDialog(this, "Niveau terminé !", "Bravo", JOptionPane.INFORMATION_MESSAGE);
    niveauActuel++;
    chargerNiveau(niveauActuel);

    SwingUtilities.getWindowAncestor(this).pack(); // Ajute la taille de la fenêtre en fonction du niveau
  }

  /**
   * Méthode pour gérer la fin de partie
   */
  private void finDePartie() {
    JOptionPane.showMessageDialog(this, "Fin de partie !", "Fin de partie", JOptionPane.INFORMATION_MESSAGE);
    System.exit(0);
  }

  /**
   * Méthode pour charger un niveau
   *
   * @param index L'index du niveau à charger
   */
  private void chargerNiveau(int index) {
    if (index < niveaux.length) {
      carte = new Carte(Lecture.lireCarte(niveaux[index]));
      setPreferredSize(new Dimension(carte.getLargeur() * TAILLE_CASE, carte.getHauteur() * TAILLE_CASE));
      revalidate();
      repaint();
    } else {
      finDePartie();
    }
  }

  /**
   * Méthode pour réinitialiser le jeu
   */
  private void resetGame() {
    niveauActuel = 0;
    chargerNiveau(niveauActuel);
  }

  /**
   * Méthode pour réinitialiser le niveau actuel
   */
  private void resetNiveau() {
    chargerNiveau(niveauActuel);
  }

  /**
   * Méthode pour créer le menu de la fenêtre
   *
   * @param frame La fenêtre principale
   */
  private void creerMenu(JFrame frame) {
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Jeu");
    JMenuItem resetItem = new JMenuItem("Recommencer");
    JMenuItem resetLvl = new JMenuItem("Recommencer le niveau");
    JMenuItem quitter = new JMenuItem("Quitter");
    resetItem.addActionListener(e -> resetGame());
    resetLvl.addActionListener(e -> resetNiveau());
    quitter.addActionListener(e -> System.exit(0));
    menu.add(resetItem);
    menu.add(resetLvl);
    menu.add(quitter);
    menuBar.add(menu);
    frame.setJMenuBar(menuBar);
  }

  /**
   * Méthode pour gérer les événements de touche relâchée
   *
   * @param e L'événement de touche relâchée
   */
  @Override
  public void keyReleased(KeyEvent e) {
  }

  /**
   * Méthode pour gérer les événements de touche tapée
   *
   * @param e L'événement de touche tapée
   */
  @Override
  public void keyTyped(KeyEvent e) {
  }

  /**
   * Méthode pour peindre le composant
   *
   * @param g Le contexte graphique
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (int y = 0; y < carte.getHauteur(); y++) {
      for (int x = 0; x < carte.getLargeur(); x++) {
        char symbole = carte.getChar(x, y);
        Image img = imgSol;

        // Détermine l'image à afficher en fonction du symbole
        switch (symbole) {
          case '#' -> img = imgMur;
          case '.' -> img = imgDestination;
          case '$' -> img = imgCaisse;
          case '*' -> img = imgCaisseDestination;
          case '@' -> {
            // Affiche le joueur
            switch (carte.getDirectionJoueur()) {
              case HAUT -> img = imgJoueurHaut;
              case BAS -> img = imgJoueurBas;
              case GAUCHE -> img = imgJoueurGauche;
              case DROITE -> img = imgJoueurDroite;
            }
          }
        }

        g.drawImage(img, x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE, TAILLE_CASE, this); // Dessine l'image
      }
    }
  }

  /**
   * Méthode principale pour lancer l'application
   *
   * @param args Les arguments de la ligne de commande
   */
  public static void main(String[] args) {
    JFrame frame = new JFrame("Sokoban");
    VueSokoban panel = new VueSokoban("bin/map/map1.txt");

    frame.add(panel);
    frame.setTitle("Sokoban");
    frame.pack();
    frame.setSize(800, 600);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel.creerMenu(frame);

    frame.setVisible(true);
  }
}
