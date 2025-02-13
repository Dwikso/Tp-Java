import guilines.IJeuDesBilles;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonJeu implements IJeuDesBilles {
    private int[][] grille;
    private final int taille = 9;
    private final int couleursUtilisees = 3;
    private Random random = new Random();
    private int[] nouvellesCouleurs;
    private int nbBillesAjoutees;
    private int score = 0;
    private static final int VIDE = -1;

    public MonJeu() {
        this.nbBillesAjoutees = 3;
        grille = new int[taille][taille];
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                grille[i][j] = VIDE;
            }
        }
        genererNouvellesCouleurs();
        ajouterBillesAleatoires(5);
    }

    public void supprimerAllignement(int x1, int y1, int x2, int y2) {

    }

    public int getCouleur(int lig, int col) {
        return grille[lig][col];
    }

    public int getNbBillesAjoutees() {
        return 3;
    }

    public int getNbColonnes() {
        return taille;
    }

    public int getNbCouleurs() {
        return couleursUtilisees;
    }

    public int getNbLignes() {
        return taille;
    }

    public int getScore() {
        return score;
    }

    public int[] getNouvellesCouleurs() {
        return nouvellesCouleurs;
    }

    private void ajouterBillesAleatoires(int nombreDeBilles) {
        for (int n = 0; n < nombreDeBilles; n++) {
            int x, y;
            do {
                x = random.nextInt(taille);
                y = random.nextInt(taille);
            } while (grille[x][y] != VIDE);

            int couleur = nouvellesCouleurs[n % nouvellesCouleurs.length];
            grille[x][y] = couleur;

            System.out.println("Bille ajoutée à (" + x + "," + y + ") avec la couleur " + couleur);
            nbBillesAjoutees++;
        }
        genererNouvellesCouleurs();
    }

    private void genererNouvellesCouleurs() {
        nouvellesCouleurs = new int[3];
        for (int i = 0; i < 3; i++) {
            nouvellesCouleurs[i] = random.nextInt(couleursUtilisees);
        }
    }

    public List<Point> deplace(int x1, int y1, int x2, int y2) {
        List<Point> casesModifiees = new ArrayList<>();

        if (grille[x1][y1] != VIDE && grille[x2][y2] == VIDE) {
            if (x1 == x2 || y1 == y2) {
                grille[x2][y2] = grille[x1][y1];
                grille[x1][y1] = VIDE;

                casesModifiees.add(new Point(x1, y1));
                casesModifiees.add(new Point(x2, y2));

                int saveScore = score;

                supprimerAlignements();

                if (saveScore == score) {
                    ajouterBillesAleatoires(3);
                }

            }
        }

        return getCasesModifiees();
    }

    private void supprimerAlignements() {
        boolean[][] aSupprimer = new boolean[taille][taille];
        int totalBillesSupprimees = 0;

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j <= taille - 5; j++) {
                int couleur = grille[i][j];
                if (couleur != VIDE && couleur == grille[i][j + 1] && couleur == grille[i][j + 2] &&
                        couleur == grille[i][j + 3] && couleur == grille[i][j + 4]) {
                    for (int k = 0; k < 5; k++)
                        aSupprimer[i][j + k] = true;
                }
            }
        }

        for (int j = 0; j < taille; j++) {
            for (int i = 0; i <= taille - 5; i++) {
                int couleur = grille[i][j];
                if (couleur != VIDE && couleur == grille[i + 1][j] && couleur == grille[i + 2][j] &&
                        couleur == grille[i + 3][j] && couleur == grille[i + 4][j]) {
                    for (int k = 0; k < 5; k++)
                        aSupprimer[i + k][j] = true;
                }
            }
        }

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if (aSupprimer[i][j]) {
                    grille[i][j] = VIDE;
                    totalBillesSupprimees++;
                }
            }
        }

        if (totalBillesSupprimees > 0) {
            score += totalBillesSupprimees * 2;
            System.out.println("Alignement supprimé ! Score : " + score);
        }
    }

    private boolean cheminLibre(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            if (y1 < y2) {
                for (int j = y1 + 1; j < y2; j++) {
                    if (grille[x1][j] != VIDE) {
                        return false;
                    }
                }
            } else {
                for (int j = y1 - 1; j > y2; j--) {
                    if (grille[x1][j] != VIDE) {
                        return false;
                    }
                }
            }
            return true;
        }

        if (y1 == y2) {
            if (x1 < x2) {
                for (int i = x1 + 1; i < x2; i++) {
                    if (grille[i][y1] != VIDE) {
                        return false;
                    }
                }
            } else {
                for (int i = x1 - 1; i > x2; i--) {
                    if (grille[i][y1] != VIDE) {
                        return false;
                    }
                }
            }
            return true;
        }

        return false;
    }

    public List<Point> getCasesModifiees() {
        List<Point> toutesLesCases = new ArrayList<>();
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                toutesLesCases.add(new Point(i, j));
            }
        }
        return toutesLesCases;
    }

    public void reinit() {
        score = 0;
        grille = new int[taille][taille];
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                grille[i][j] = VIDE;
            }
        }
        genererNouvellesCouleurs();
        ajouterBillesAleatoires(5);
    }

    public boolean partieFinie() {
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if (grille[i][j] == VIDE) {
                    return false;
                }
            }
        }
        return true;
    }
}
