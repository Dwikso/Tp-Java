/*
 * Bataille
 *
 * @author Pellosse Quentin
 * @version 1.1
 */

/**
 * Classe de la bataille.
 */
public class Bataille {
    private FileDeCartes joueur1;
    private FileDeCartes joueur2;
    private PileDeCartes cartesRetournees;

    public Bataille() {
        Jeu jeu = new Jeu();
        jeu.melanger();
        joueur1 = new FileDeCartes();
        joueur2 = new FileDeCartes();
        cartesRetournees = new PileDeCartes();

        // Répartition équitable des cartes entre les deux joueurs
        for (int i = 0; i < 52; i++) {
            if (i % 2 == 0) {
                joueur1.ajouter(jeu.retirerCarte());
            } else {
                joueur2.ajouter(jeu.retirerCarte());
            }
        }
    }

    /**
     * Joue tour.
     */
    public void jouerTour() {
        if (joueur1.estVide() || joueur2.estVide()) {
            return;
        }

        Carte carteJoueur1 = joueur1.retirerCarte();
        Carte carteJoueur2 = joueur2.retirerCarte();

        System.out.println("Tour : ");
        System.out.println("Joueur 1 joue : " + carteJoueur1);
        System.out.println("Joueur 2 joue : " + carteJoueur2);

        cartesRetournees.ajouter(carteJoueur1);
        cartesRetournees.ajouter(carteJoueur2);

        int rangJoueur1 = carteJoueur1.getRang().getRang();
        int rangJoueur2 = carteJoueur2.getRang().getRang();

        if (rangJoueur1 > rangJoueur2) {
            System.out.println("Joueur 1 remporte ce tour");
            recupererCartes(joueur1);
        } else if (rangJoueur2 > rangJoueur1) {
            System.out.println("Joueur 2 remporte ce tour");
            recupererCartes(joueur2);
        } else {
            System.out.println("Égalité ! Bataille !");
            gererBataille();
        }
        System.out.println();
    }

    /*
     * Gestion de la bataille.
     */
    private void gererBataille() {
        // Chaque joueur doit poser une carte face cachée, puis une autre face visible
        if (joueur1.taille() < 2 || joueur2.taille() < 2) {
            System.out.println("Un joueur n'a plus assez de cartes pour continuer la bataille !");
            return;
        }

        // Chaque joueur pose une carte face cachée
        cartesRetournees.ajouter(joueur1.retirerCarte());
        cartesRetournees.ajouter(joueur2.retirerCarte());

        // Puis une autre carte face visible
        Carte nouvelleCarteJoueur1 = joueur1.retirerCarte();
        Carte nouvelleCarteJoueur2 = joueur2.retirerCarte();

        System.out.println("Joueur 1 pose en bataille : " + nouvelleCarteJoueur1);
        System.out.println("Joueur 2 pose en bataille : " + nouvelleCarteJoueur2);

        cartesRetournees.ajouter(nouvelleCarteJoueur1);
        cartesRetournees.ajouter(nouvelleCarteJoueur2);

        int rangNouvelleCarteJoueur1 = nouvelleCarteJoueur1.getRang().getRang();
        int rangNouvelleCarteJoueur2 = nouvelleCarteJoueur2.getRang().getRang();

        if (rangNouvelleCarteJoueur1 > rangNouvelleCarteJoueur2) {
            System.out.println("Joueur 1 gagne la bataille !");
            recupererCartes(joueur1);
        } else if (rangNouvelleCarteJoueur2 > rangNouvelleCarteJoueur1) {
            System.out.println("Joueur 2 gagne la bataille !");
            recupererCartes(joueur2);
        } else {
            System.out.println("Nouvelle égalité ! Une autre bataille commence...");
            gererBataille(); // Répétition jusqu'à résolution
        }
    }

    /**
     * Joue une partie.
     */
    public void jouerPartie() {
        while (!joueur1.estVide() && !joueur2.estVide()) {
            jouerTour();
        }

        if (joueur1.estVide()) {
            System.out.println("Joueur 2 a gagné !");
        } else {
            System.out.println("Joueur 1 a gagné !");
        }
    }

    /*
     * Recupere les cartes retournées.
     */
    private void recupererCartes(FileDeCartes joueur) {
        while (!cartesRetournees.estVide()) {
            joueur.ajouter(cartesRetournees.retirerCarte());
        }
    }

    public FileDeCartes getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(FileDeCartes joueur1) {
        this.joueur1 = joueur1;
    }

    public FileDeCartes getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(FileDeCartes joueur2) {
        this.joueur2 = joueur2;
    }

    public PileDeCartes getCartesRetournees() {
        return cartesRetournees;
    }

    public void setCartesRetournees(PileDeCartes cartesRetournees) {
        this.cartesRetournees = cartesRetournees;
    }
}
