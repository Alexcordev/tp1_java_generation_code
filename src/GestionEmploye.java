import java.util.*;
/* CONSIGNES
    /*  Valider avec une BOUCLE de validation
        Le programme plante si l’utilisateur
        saisit autre chose qu’un nombre entier.
        Les seules CLASSES PERMISES sont System et String (et Locale, éventuellement)
        Vous NE DEVEZ PAS utiliser les tableaux.
        Vous NE DEVEZ PAS utiliser les expressions régulières.
        Toute VARIABLE GLOBALE est INTERDITE : toutes les variables doivent être déclarées à l’intérieur (et au
        début) de la méthode main (sauf pour les boucles for).
        Utilisez des constantes (final) autant que possible : les messages affichés, les bornes de validation, etc.
        Les constantes doivent être déclarées au niveau de la classe (public static final)
        L'affichage des résultats doit se faire à la console.
        Utilisez des variables réelles uniquement lorsque requis. Par exemple, un compteur ne doit pas être un float ou un
        double.
        Vous DEVEZ respecter le style Java vu en classe.
        Votre code doit pouvoir s’exécuter sur le JDK7.
 */

public class GestionEmploye {
    //Déclaration des constantes
    public static final String FIN_PROGRAMME = "FIN NORMALE DU PROGRAMME";
    public static final int ANNEE_MIN = 1950;
    public static final int ANNEE_MAX = 2002;
    public static final int MOIS_MIN = 1;
    public static final int MOIS_MAX = 12;
    public static final int AJOUT_MOIS = 70;
    public static final String MESSAGE_ERREUR_ANNEE = "Erreur! Veuillez entrer une valeur entre 1950 et 2002 inclusivement";
    public static final String MESSAGE_ERREUR_MOIS = "Erreur! Veuillez entrer une valeur entre 1 et 12 inclusivement";
    public static final String MESSAGE_ERREUR_MOIS_28_JOURS = "Erreur! Veuillez entrer une valeur entre 1 et 28 inclusivement";
    public static final String MESSAGE_ERREUR_MOIS_29_JOURS = "Erreur! Veuillez entrer une valeur entre 1 et 29 inclusivement";
    public static final String MESSAGE_ERREUR_MOIS_30_JOURS = "Erreur! Veuillez entrer une valeur entre 1 et 30 inclusivement";
    public static final String MESSAGE_ERREUR_MOIS_31_JOURS = "Erreur! Veuillez entrer une valeur entre 1 et 31 inclusivement";
    public static final String MESSAGE_ERREUR_SEXE = "Erreur! Veuillez entrer 'f' ou 'm' ";

    public static void main(String[] args) {
        int annee, mois, nbreJours = 0, codeBisex = 0, sexeM = 0, sexeF = 0, c7, c8, c9, codeGenere = 0, code, resultat, leCode;
        float moyenneFemmes, moyenneHommes;
        char sexe = ' ';
        String c1, c2, c3, c4, c5, c6;

        //Afficher une petite description (ex : Ce programme sert à générer des codes d’employés, etc)
        System.out.println("\n\nCe programme en java sert à générer des codes d'employés à 9 chiffres.\nL'utilisateur doit entrer l'année, " +
                "le mois, le jour de sa naissance\net finalement son sexe pour que le code en question soit généré automatiquement.\n");

        //LECTURE DES DONNÉES

        Scanner maSaisie = new Scanner(System.in);

        System.out.printf("\nVeuillez entrer votre année de naissance (Une valeur entre 1950 et 2002 inclusivement) (Appuyez sur 0 pour quitter) : ");
        annee = maSaisie.nextInt();
        if (annee == 0) {
            System.out.println(FIN_PROGRAMME);
            System.exit(0);

        }
        while (annee != 0) {

            while (annee < ANNEE_MIN || annee > ANNEE_MAX) {
                System.out.printf("\n\n%s\n", MESSAGE_ERREUR_ANNEE);
                System.out.printf("Veuillez entrer votre année de naissance (Une valeur entre 1950 et 2002 inclusivement) : ");
                annee = maSaisie.nextInt();
            }

            System.out.printf("\n\nVeuillez entrer votre mois de naissance (Une valeur entre 1 et 12 inclusivement) : ");
            mois = maSaisie.nextInt();

            while (mois < MOIS_MIN || mois > MOIS_MAX) {
                System.out.printf("\n%s\n", MESSAGE_ERREUR_MOIS);
                System.out.printf("\nVeuillez entrer votre mois de naissance (Une valeur entre 1 et 12 inclusivement) : ");
                mois = maSaisie.nextInt();

            }
            boolean anneeEstBissex = annee % 400 == 0 || (annee % 4 == 0 && annee % 100 != 0);

            switch (mois) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (anneeEstBissex) {
                        System.out.printf("\nVeuillez entrer votre jour de naissance (Une valeur entre 1 et 31 inclusivement) : ");
                        nbreJours = maSaisie.nextInt();
                        while (nbreJours < 1 || nbreJours > 31) {
                            System.out.printf("\n%s\n", MESSAGE_ERREUR_MOIS_31_JOURS);
                            System.out.printf("Veuillez entrer votre jour de naissance (Une valeur entre 1 et 31 inclusivement) : ");
                            nbreJours = maSaisie.nextInt();
                        }

                        System.out.printf("\n\nÊtes-vous du sexe masculin (m) ou féminin (f) : ");
                        sexe = maSaisie.next().trim().charAt(0);
                        if (sexe == 'f' || sexe == 'F') {
                            sexeF++;
                            mois += AJOUT_MOIS;

                        } else if (sexe == 'm' || sexe == 'M'){
                            sexeM++;

                        }

                        while (sexe != 'F' & sexe != 'f' && sexe != 'M' & sexe != 'm') {
                            System.out.printf("\n%s\n", MESSAGE_ERREUR_SEXE);
                            System.out.printf("\nÊtes-vous du sexe masculin (m) ou féminin (f) : ");
                            sexe = maSaisie.next().trim().charAt(0);

                        }
                        codeBisex++;
                    } else {
                        System.out.printf("\nVeuillez entrer votre jour de naissance (Une valeur entre 1 et 31 inclusivement) : ");
                        nbreJours = maSaisie.nextInt();
                        while (nbreJours < 1 || nbreJours > 31) {
                            System.out.printf("\n%s\n", MESSAGE_ERREUR_MOIS_31_JOURS);
                            System.out.printf("Veuillez entrer votre jour de naissance (Une valeur entre 1 et 31 inclusivement) : ");
                            nbreJours = maSaisie.nextInt();

                        }
                        System.out.printf("\n\nÊtes-vous du sexe masculin (m) ou féminin (f) : ");
                        sexe = maSaisie.next().trim().charAt(0);
                        if (sexe == 'f' || sexe == 'F') {
                            sexeF++;
                            mois += AJOUT_MOIS;

                        } else if (sexe == 'm' || sexe == 'M'){
                            sexeM++;

                        }

                        while (sexe != 'F' & sexe != 'f' && sexe != 'M' & sexe != 'm') {
                            System.out.printf("\n%s", MESSAGE_ERREUR_SEXE);
                            System.out.printf("\nÊtes-vous du sexe masculin (m) ou féminin (f) : ");
                            sexe = maSaisie.next().trim().charAt(0);
                        }
                    }

                    break;
                case 2:

                    if (anneeEstBissex) {
                        System.out.printf("\nVeuillez entrer votre jour de naissance (Une valeur entre 1 et 29 inclusivement) : ");
                        nbreJours = maSaisie.nextInt();
                        while (nbreJours < 1 || nbreJours > 29) {
                            System.out.printf("\n\n%s", MESSAGE_ERREUR_MOIS_29_JOURS);
                            System.out.printf("\nVeuillez entrer votre jour de naissance (Une valeur entre 1 et 29 inclusivement) : ");
                            nbreJours = maSaisie.nextInt();

                        }
                        System.out.printf("\n\nÊtes-vous du sexe masculin (m) ou féminin (f) : ");
                        sexe = maSaisie.next().trim().charAt(0);
                        if (sexe == 'f' || sexe == 'F') {
                            sexeF++;
                            mois += AJOUT_MOIS;

                        } else if (sexe == 'm' || sexe == 'M'){
                            sexeM++;

                        }

                        while (sexe != 'F' & sexe != 'f' && sexe != 'M' & sexe != 'm') {
                            System.out.printf("\n%s\n", MESSAGE_ERREUR_SEXE);
                            System.out.printf("Êtes-vous du sexe masculin (m) ou féminin (f) : ");
                            sexe = maSaisie.next().trim().charAt(0);

                        }
                        codeBisex++;
                    } else {
                        System.out.printf("\nVeuillez entrer votre jour de naissance (Une valeur entre 1 et 28 inclusivement) : ");
                        nbreJours = maSaisie.nextInt();
                        while (nbreJours < 1 || nbreJours > 28) {
                            System.out.printf("\n%s", MESSAGE_ERREUR_MOIS_28_JOURS);
                            System.out.printf("\nVeuillez entrer votre jour de naissance (Une valeur entre 1 et 28 inclusivement) : ");
                            nbreJours = maSaisie.nextInt();
                        }
                        System.out.printf("\nÊtes-vous du sexe masculin (m) ou féminin (f) : ");
                        sexe = maSaisie.next().trim().charAt(0);
                        if (sexe == 'f' || sexe == 'F') {
                            sexeF++;
                            mois += AJOUT_MOIS;

                        } else if (sexe == 'm' || sexe == 'M'){
                            sexeM++;

                        }

                        while (sexe != 'F' & sexe != 'f' && sexe != 'M' & sexe != 'm') {
                            System.out.printf("\n%s", MESSAGE_ERREUR_SEXE);
                            System.out.printf("\nÊtes-vous du sexe masculin (m) ou féminin (f) : ");
                            sexe = maSaisie.next().trim().charAt(0);

                        }
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (anneeEstBissex) {
                        System.out.printf("\nVeuillez entrer votre jour de naissance (Une valeur entre 1 et 30 inclusivement) : ");
                        nbreJours = maSaisie.nextInt();
                        while (nbreJours < 1 || nbreJours > 30) {
                            System.out.printf("\n%s", MESSAGE_ERREUR_MOIS_30_JOURS);
                            System.out.printf("\nVeuillez entrer votre jour de naissance (Une valeur entre 1 et 30 inclusivement) : ");
                            nbreJours = maSaisie.nextInt();

                        }
                        System.out.printf("\n\nÊtes-vous du sexe masculin (m) ou féminin (f) : ");
                        sexe = maSaisie.next().trim().charAt(0);
                        if (sexe == 'f' || sexe == 'F') {
                            sexeF++;
                            mois += AJOUT_MOIS;

                        } else if (sexe == 'm' || sexe == 'M'){
                            sexeM++;

                        }

                        while (sexe != 'F' & sexe != 'f' && sexe != 'M' & sexe != 'm') {
                            System.out.printf("\n%s\n", MESSAGE_ERREUR_SEXE);
                            System.out.printf("Êtes-vous du sexe masculin (m) ou féminin (f) : ");
                            sexe = maSaisie.next().trim().charAt(0);

                        }
                        codeBisex++;
                    } else {
                        System.out.printf("\nVeuillez entrer votre jour de naissance (Une valeur entre 1 et 30 inclusivement) : ");
                        nbreJours = maSaisie.nextInt();
                        while (nbreJours < 1 || nbreJours > 30) {
                            System.out.printf("\n%s", MESSAGE_ERREUR_MOIS_30_JOURS);
                            System.out.printf("\nVeuillez entrer votre jour de naissance (Une valeur entre 1 et 30 inclusivement) : ");
                            nbreJours = maSaisie.nextInt();

                        }
                        System.out.printf("\n\nÊtes-vous du sexe masculin (m) ou féminin (f) : ");
                        sexe = maSaisie.next().trim().charAt(0);
                        if (sexe == 'f' || sexe == 'F') {
                            sexeF++;
                            mois += AJOUT_MOIS;

                        } else if (sexe == 'm' || sexe == 'M'){
                            sexeM++;

                        }

                        while (sexe != 'F' & sexe != 'f' && sexe != 'M' & sexe != 'm') {
                            System.out.println("\nErreur! Veuillez entrer 'f' ou 'm' ");
                            System.out.printf("\n%s", MESSAGE_ERREUR_SEXE);
                            sexe = maSaisie.next().trim().charAt(0);

                        }
                    }

                    break;
            }
            codeGenere++;

            //TRAITEMENT DES DONNÉES (CALCULS ET AUTRES)


            //Les deux premiers chiffres du code correspondent aux deux derniers chiffres de l'année de naissance,
            c2 = String.valueOf(annee).substring(2);
            c1 = c2.substring(0,1);

        /*les deux chiffres suivants du code sont les deux chiffres du mois de naissance
        (s'il s'agit d'une femme, le mois sera augmenté de la quantité 70)*/
            c4 = String.valueOf(mois).substring(1);
            c3 = String.valueOf(mois).length() == 2 ? String.valueOf(mois).substring(0, 1) : "0" + mois;

            //ensuite les deux chiffres du jour de naissance.
            c6 = String.valueOf(nbreJours).substring(1);
            c5 = String.valueOf(nbreJours).length() == 2 ? String.valueOf(nbreJours).substring(0, 1) : "0" + nbreJours;


            char nouvc1 = '0';
            char nouvc2 = '0';
            char nouvc3 = '0';
            char nouvc4 = '0';
            char nouvc5 = '0';
            char nouvc6 = '0';

            nouvc1 = c1.charAt(0);
            int nouv1 = nouvc1 - '0';;

            for (int i = 0; i < c2.length(); i++) {
                nouvc2 = c2.charAt(i);
            }
            int nouv2 = nouvc2 - '0';;

            for (int i = 0; i < c3.length(); i++) {
                nouvc3 = c3.charAt(i);
            }
            int nouv3 = nouvc3 - '0';

            for (int i = 0; i < c4.length(); i++) {
                nouvc4 = c4.charAt(i);
            }
            int nouv4 = nouvc4 - '0';;

            for (int i = 0; i < c5.length(); i++) {
                nouvc5 = c5.charAt(i);
            }
            int nouv5 = nouvc5 - '0';

            for (int i = 0; i < c6.length(); i++) {
                nouvc6 = c6.charAt(i);
            }
            int nouv6 = nouvc6 - '0';;


            //c7 : le reste après division par 10 de c1 + 7 * c3 + 5 * c5
            c7 = (nouv1 + 7 * nouv3 + 5 * nouv5) % 10;

            //c8 : le reste après division par 10 de 9 * ( c2 + c4 + 2 * c6 )
            c8 = 9 * (nouv2 + nouv4 + 2 * nouv6) % 10;

            //c9 est un chiffre entre 0 et 9 tel que c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9 est un multiple de 10.
            code = nouv1 + nouv2 + nouv3 + nouv4 + nouv5 + nouv6 + c7 + c8;
            resultat = code%10;
            leCode = resultat;
            c9 = leCode;

            System.out.println("\n-------------------------");
            System.out.printf("|                       |\n");
            System.out.printf("| CODE D'EMPLOYÉ GÉNÉRÉ |\n");
            System.out.printf("|                       |\n");
            System.out.printf("-------------------------\n");
            System.out.printf("        %s           \n",c1.substring(1,1) + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9);
            System.out.printf("-------------------------\n\n");


            System.out.printf("\n\nGÉNÉRER UN AUTRE CODE D'EMPLOYÉ?\n\n");
            System.out.printf("Entrer l'année de naissance pour continuer ou 0 pour terminer la saisie et afficher les résultats\n\n");
            System.out.printf("Veuillez entrer votre année de naissance (Une valeur entre 1950 et 2002 inclusivement) : ");
            annee = maSaisie.nextInt();


        }
            moyenneFemmes = (float) (sexeF * 100) / codeGenere;
            moyenneHommes = (float) (sexeM * 100) / codeGenere;


        //AFFICHAGE DES RÉSULTATS
        System.out.printf("\n\n-------------------------------------------------------------\n");
        System.out.printf("|                  AFFICHAGE DES RÉSULTATS                   |\n");
        System.out.printf("|                                                            |\n");
        System.out.printf("-------------------------------------------------------------\n");
        //1. Le nombre de codes générés
        System.out.printf("| Nombre de codes générés : %d                                |\n", codeGenere);
        System.out.printf("-------------------------------------------------------------\n");
        //2. Le nombre de codes générés à partir d’une année bissextile
        System.out.printf("| Nombre de code généré à partir d'une année bissextile : %d  |\n", codeBisex);
        System.out.printf("-------------------------------------------------------------\n");
        //3. Le pourcentage de femmes et le nombre de pourcentage d'hommes
        System.out.printf("| Pourcentage de femmes : %1.2f%%                             |\n", moyenneFemmes);
        System.out.printf("-------------------------------------------------------------\n");
        System.out.printf("| Pourcentage d'hommes : %1.2f%%                              |\n", moyenneHommes);
        System.out.printf("-------------------------------------------------------------\n");

          //Puis le programme termine son exécution en affichant le message : « FIN NORMALE DU PROGRAMME »
          System.out.printf("\nFIN NORMALE DU PROGRAMME");



    }
}
