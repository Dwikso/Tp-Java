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

    public MonJeu() {
        grille = new int[taille][taille];
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                grille[i][j] = -1; // -1 signifie que la case est vide
            }
        }
        genererNouvellesCouleurs();
        ajouterBillesAleatoires(5);
    }

    private void ajouterBillesAleatoires(int nombreDeBilles) {
        for (int n = 0; n < nombreDeBilles; n++) {
            int x, y;
            // Trouver une case vide pour ajouter une bille
            do {
                x = random.nextInt(taille);
                y = random.nextInt(taille);
            } while (grille[x][y] != -1); // S'assurer que la case est vide

            // Générer une couleur aléatoire parmi les couleurs disponibles
            int couleur = nouvellesCouleurs[n % nouvellesCouleurs.length];
            grille[x][y] = couleur;

            nbBillesAjoutees++; // Incrémenter le nombre de billes ajoutées
        }
        genererNouvellesCouleurs(); // Générer de nouvelles couleurs après l'ajout des billes
    }

    private void genererNouvellesCouleurs() {
        nouvellesCouleurs = new int[3];
        // Générer des couleurs aléatoires pour les prochaines billes
        for (int i = 0; i < 3; i++) {
            nouvellesCouleurs[i] = random.nextInt(couleursUtilisees); // Assurez-vous de respecter le nombre de couleurs
        }
    }

    public List<Point> deplace(int x1, int y1, int x2, int y2) {
        List<Point> casesModifiees = new ArrayList<>();

        // Vérifier si le déplacement est valide (case source occupée et case cible
        // vide)
        if (grille[x1][y1] != -1 && grille[x2][y2] == -1) {
            // Déplacer la bille
            grille[x2][y2] = grille[x1][y1];
            grille[x1][y1] = -1;

            // Ajouter les cases modifiées
            casesModifiees.add(new Point(x1, y1));
            casesModifiees.add(new Point(x2, y2));

            // Ajouter des billes après le déplacement
            ajouterBillesAleatoires(3);
        }

        return casesModifiees;
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

    public int[] getNouvellesCouleurs() {
        return nouvellesCouleurs;
    }

    @Override
    public void reinit() {
        grille = new int[taille][taille];
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                grille[i][j] = -1; // Réinitialiser toutes les cases à vide
            }
        }
        genererNouvellesCouleurs();
        ajouterBillesAleatoires(5); // Ajouter 5 billes au démarrage
    }

    @Override
    public int getCouleur(int lig, int col) {
        return grille[lig][col]; // Retourner l'indice de la couleur (int)
    }

    @Override
    public int getNbBillesAjoutees() {
        return nbBillesAjoutees; // Retourner le nombre total de billes ajoutées
    }

    @Override
    public int getNbColonnes() {
        return taille; // Retourner le nombre de colonnes (taille de la grille)
    }

    @Override
    public int getNbCouleurs() {
        return couleursUtilisees; // Retourner le nombre de couleurs utilisées
    }

    @Override
    public int getNbLignes() {
        return taille; // Retourner le nombre de lignes (taille de la grille)
    }

    @Override
    public int getScore() {
        return score; // Retourner le score (à implémenter selon votre logique)
    }

    @Override
    public boolean partieFinie() {
        // Vérifier si la partie est terminée (plus aucune case vide)
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if (grille[i][j] == -1) { // Si une case est vide
                    return false;
                }
            }
        }
        return true; // Partie terminée si aucune case n'est vide
    }
}
