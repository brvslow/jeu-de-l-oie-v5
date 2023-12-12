package fr.wasson;

import java.util.Random;

public class App {

    public static int Jouer(int nbLancers, Random generateur) {
        int caseCourante = 0;
        for (int i = 1; i <= nbLancers; i++) {
            int lancer = generateur.nextInt(6) + 1;
            caseCourante = caseCourante + lancer;
            System.out.println(
                    String.format("Lancer %d : vous avez fait %d. Vous êtes sur la case %d.", i, lancer, caseCourante));
        }
        return caseCourante;
    }

    public static boolean VictoireOuPas(int caseObjectif, int caseCourante, int compteurSimulations, boolean victoire) {
        int caseRestantes = caseObjectif - caseCourante;
        if (caseCourante == caseObjectif) {
            System.out.println("Vous avez gagné !");
            System.out.println("Il aura fallu " + compteurSimulations + " simulations pour gagner.");
            victoire = true;
        } else if (caseCourante > caseObjectif) {
            System.out.println("Vous dépassez, vous avez perdu !");
        } else {
            System.out.println("Il vous en manque " + caseRestantes + " pour arriver à " + caseObjectif + " !");
        }
        return victoire;
    }

    public static void main(String[] args) {
        int caseObjectif = 20;
        int nbLancers = 5;
        Random generateur = new Random();
        boolean victoire = false;
        int compteurSimulations = 0;
        while (!victoire) {
            compteurSimulations++;
            int caseCourante = Jouer(nbLancers, generateur);
            victoire = VictoireOuPas(caseObjectif, caseCourante, compteurSimulations, victoire);
        }
    }
}
