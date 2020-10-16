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

/* GÉNÉRATION DU CODE
   * Un code est constitué de 9 chiffres que nous noterons c1, c2, c3, c4, c5, c6, c7, c8 et c9 dans cet ordre.
   * Les deux premiers chiffres du code correspondent aux deux derniers chiffres de l'année de naissance,
   * les deux chiffres suivants du code sont les deux chiffres du mois de naissance
   * (s'il s'agit d'une femme, le mois sera augmenté de la quantité 70),
   * ensuite les deux chiffres du jour de naissance.
   * Les trois derniers chiffres du code sont déterminés de la façon suivante :
       c7 : le reste après division par 10 de c1 + 7 * c3 + 5 * c5
       c8 : le reste après division par 10 de 9 * ( c2 + c4 + 2 * c6 )
       c9 est un chiffre entre 0 et 9 tel que c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9 est un multiple de 10.
     Par exemple, si la date de naissance d'une femme est le 18 juin 1981, les 6 premiers chiffres du code seront 817618.
   * Puis,
       c7 = le reste après division entière par 10 de 8 + 7 * 7 + 5 * 1 i.e. le reste après division par 10 de 62, donc 2.
       c8 = le reste après division entière par 10 de 9* ( 1 + 6 + 2 * 8 ) i.e. le reste après division par 10 de 207, donc 7.
   * Si on additionne tous les chiffres du code sauf le dernier, on a : 8 + 1 + 7 + 6 + 1 + 8 + 2 + 7 = 40, donc c9 = 0. Le code sera donc 817618270
   * */

public class GestionEmploye {
    //Déclaration des constantes



    public static void main(String[] args) {
        int nombre = 0, annee, monAnnee = 0, mois = 0, nbreJours = 0, totalCodeBisex = 0, codeBisex = 0, sexeM = 0, sexeF = 0, totalSexF = 0, totalSexM = 0;
        float moyenneFemmes = 0, moyenneHommes = 0;
        int codeGenere = 0;
        int c7 = 0;
        int c8 = 0;
        int c9 = 0;
        char sexe = ' ';
        String c1 = null, c2 = null, c3 = null, c4 = null, c5 = null, c6 = null;

        //Afficher une petite description (ex : Ce programme sert à générer des codes d’employés, etc)


        //LECTURE DES DONNÉES

        Scanner maSaisie = new Scanner(System.in);

        do {

            System.out.printf("Veuillez entrer votre année de naissance (Une valeur entre 1950 et 2002 inclusivement) : ");
            annee = maSaisie.nextInt();
            if (annee == 0) {
                break;
            }

            while (annee < 1950 || annee > 2002) {
                System.out.println("Erreur! Veuillez entrer une valeur entre 1950 et 2002 inclusivement");
                System.out.printf("Veuillez entrer votre année de naissance (Une valeur entre 1950 et 2002 inclusivement) : ");
                annee = maSaisie.nextInt();
                if (annee == 0) {

                    break;

                } else {
                    monAnnee = annee;

                }

            }
            System.out.printf("Veuillez entrer votre mois de naissance (Une valeur entre 1 et 12 inclusivement) : ");
            mois = maSaisie.nextInt();

            while (mois < 1 || mois > 12) {
                    System.out.println("Erreur! Veuillez entrer une valeur entre 1 et 12 inclusivement");
                    System.out.printf("Veuillez entrer votre mois de naissance (Une valeur entre 1 et 12 inclusivement) : ");
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
                        System.out.printf("Veuillez entrer votre jour de naissance (Une valeur entre 1 et 31 inclusivement) : ");
                        nbreJours = maSaisie.nextInt();
                        while (nbreJours < 1 || nbreJours > 31) {
                            System.out.println("Erreur! Veuillez entrer une valeur entre 1 et 31 inclusivement");
                            System.out.printf("Veuillez entrer votre jour de naissance (Une valeur entre 1 et 31 inclusivement) : ");
                            nbreJours = maSaisie.nextInt();

                        }
                        System.out.printf("Êtes-vous du sexe masculin (m) ou féminin (f) : ");
                        sexe = maSaisie.next().trim().charAt(0);
                        if (sexe == 'F' || sexe == 'f') {
                            sexeF++;
                            mois+=70;

                        } else {
                            sexeM++;

                        }
                        System.out.println(sexe);
                        while (sexe != 'F' && sexe != 'M') {
                            System.out.println("Erreur! Veuillez entrer 'f' ou 'm' ");
                            System.out.printf("Êtes-vous du sexe masculin (m) ou féminin (f) : ");
                            sexe = maSaisie.next().toUpperCase().trim().charAt(0);

                        }
                        codeBisex++;
                    } else {
                        System.out.printf("Veuillez entrer votre jour de naissance (Une valeur entre 1 et 31 inclusivement) : ");
                        nbreJours = maSaisie.nextInt();
                        while (nbreJours < 1 || nbreJours > 31) {
                            System.out.println("Erreur! Veuillez entrer une valeur entre 1 et 31 inclusivement");
                            System.out.printf("Veuillez entrer votre jour de naissance (Une valeur entre 1 et 31 inclusivement) : ");
                            nbreJours = maSaisie.nextInt();

                        }
                        System.out.printf("Êtes-vous du sexe masculin (m) ou féminin (f) : ");
                        sexe = maSaisie.next().trim().charAt(0);
                        if (sexe == 'F' || sexe == 'f') {
                            sexeF++;
                            mois+=70;

                        } else {
                            sexeM++;

                        }
                        System.out.println(sexe);
                        while (sexe != 'F' && sexe != 'M') {
                            System.out.println("Erreur! Veuillez entrer 'f' ou 'm' ");
                            System.out.printf("Êtes-vous du sexe masculin (m) ou féminin (f) : ");
                            sexe = maSaisie.next().toUpperCase().trim().charAt(0);

                        }
                    }

                    break;
                case 2:

                    if (anneeEstBissex) {
                        System.out.printf("Veuillez entrer votre jour de naissance (Une valeur entre 1 et 29 inclusivement) : ");
                        nbreJours = maSaisie.nextInt();
                        while (nbreJours < 1 || nbreJours > 29) {
                            System.out.println("Erreur! Veuillez entrer une valeur entre 1 et 29 inclusivement");
                            System.out.printf("Veuillez entrer votre jour de naissance (Une valeur entre 1 et 29 inclusivement) : ");
                            nbreJours = maSaisie.nextInt();

                        }
                        System.out.printf("Êtes-vous du sexe masculin (m) ou féminin (f) : ");
                        sexe = maSaisie.next().trim().charAt(0);
                        if (sexe == 'F' || sexe == 'f') {
                            sexeF++;
                            mois+=70;

                        } else {
                            sexeM++;

                        }
                        System.out.println(sexe);
                        while (sexe != 'F' && sexe != 'M') {
                            System.out.println("Erreur! Veuillez entrer 'f' ou 'm' ");
                            System.out.printf("Êtes-vous du sexe masculin (m) ou féminin (f) : ");
                            sexe = maSaisie.next().toUpperCase().trim().charAt(0);

                        }
                        codeBisex++;
                    } else {
                        System.out.printf("Veuillez entrer votre jour de naissance (Une valeur entre 1 et 28 inclusivement) : ");
                        nbreJours = maSaisie.nextInt();
                        while (nbreJours < 1 || nbreJours > 28) {
                            System.out.println("Erreur! Veuillez entrer une valeur entre 1 et 28 inclusivement");
                            System.out.printf("Veuillez entrer votre jour de naissance (Une valeur entre 1 et 28 inclusivement) : ");
                            nbreJours = maSaisie.nextInt();
                        }
                        System.out.printf("Êtes-vous du sexe masculin (m) ou féminin (f) : ");
                        sexe = maSaisie.next().trim().charAt(0);
                        if (sexe == 'F' || sexe == 'f') {
                            sexeF++;
                            mois+=70;

                        } else {
                            sexeM++;

                        }
                        System.out.println(sexe);
                        while (sexe != 'F' && sexe != 'M') {
                            System.out.println("Erreur! Veuillez entrer 'f' ou 'm' ");
                            System.out.printf("Êtes-vous du sexe masculin (m) ou féminin (f) : ");
                            sexe = maSaisie.next().toUpperCase().trim().charAt(0);

                        }
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (anneeEstBissex) {
                        System.out.printf("Veuillez entrer votre jour de naissance (Une valeur entre 1 et 30 inclusivement) : ");
                        nbreJours = maSaisie.nextInt();
                        while (nbreJours < 1 || nbreJours > 31) {
                            System.out.println("Erreur! Veuillez entrer une valeur entre 1 et 30 inclusivement");
                            System.out.printf("Veuillez entrer votre jour de naissance (Une valeur entre 1 et 30 inclusivement) : ");
                            nbreJours = maSaisie.nextInt();

                        }
                        System.out.printf("Êtes-vous du sexe masculin (m) ou féminin (f) : ");
                       sexe = maSaisie.next().trim().charAt(0);
                        if (sexe == 'F' || sexe == 'f') {
                            sexeF++;
                            mois+=70;

                        } else {
                            sexeM++;

                        }
                        System.out.println(sexe);
                        while (sexe != 'F' && sexe != 'M') {
                            System.out.println("Erreur! Veuillez entrer 'f' ou 'm' ");
                            System.out.printf("Êtes-vous du sexe masculin (m) ou féminin (f) : ");
                            sexe = maSaisie.next().toUpperCase().trim().charAt(0);

                        }
                        codeBisex++;
                    } else {
                        System.out.printf("Veuillez entrer votre jour de naissance (Une valeur entre 1 et 30 inclusivement) : ");
                        nbreJours = maSaisie.nextInt();
                        while (nbreJours < 1 || nbreJours > 31) {
                            System.out.println("Erreur! Veuillez entrer une valeur entre 1 et 30 inclusivement");
                            System.out.printf("Veuillez entrer votre jour de naissance (Une valeur entre 1 et 30 inclusivement) : ");
                            nbreJours = maSaisie.nextInt();

                        }
                        System.out.printf("Êtes-vous du sexe masculin (m) ou féminin (f) : ");
                        sexe = maSaisie.next().trim().charAt(0);
                        if (sexe == 'F' || sexe == 'f') {
                            sexeF++;
                            mois+=70;

                        } else {
                            sexeM++;

                        }
                        System.out.println(sexe);
                        while (sexe != 'F' && sexe != 'M') {
                            System.out.println("Erreur! Veuillez entrer 'f' ou 'm' ");
                            System.out.printf("Êtes-vous du sexe masculin (m) ou féminin (f) : ");
                            sexe = maSaisie.next().toUpperCase().trim().charAt(0);

                        }
                    }

                    break;
                    }
        codeGenere++;
            //TRAITEMENT DES DONNÉES (CALCULS ET AUTRES)


            //Les deux premiers chiffres du code correspondent aux deux derniers chiffres de l'année de naissance,

            c1 = String.valueOf(annee).substring(1,1);
            System.out.println(String.valueOf(annee).substring(1,1));
            c2 = String.valueOf(annee).substring(2);
        /*les deux chiffres suivants du code sont les deux chiffres du mois de naissance
        (s'il s'agit d'une femme, le mois sera augmenté de la quantité 70)*/

            c4 = String.valueOf(mois).substring(1);
            c3 = String.valueOf(mois).length() == 2 ? String.valueOf(mois).substring(0,1) : "0" + mois;

            //ensuite les deux chiffres du jour de naissance.

            c6 = String.valueOf(nbreJours).substring(1);
            c5 = String.valueOf(nbreJours).length() == 2 ? String.valueOf(nbreJours).substring(0,1) : "0"+ nbreJours;
            //Les trois derniers chiffres du code sont déterminés de la façon suivante :

            char nouvc5 = '0';
            char nouvc3 = '0';
            char nouvc1 = '0';


                //nouvc1 = c1.charAt(1);

            /*int nouv1 = Integer.parseInt(String.valueOf(nouvc1));
            System.out.println("Résultat : " + nouv1);
            System.out.println("Résultat calcul : " + (nouv1 * 2));*/

            for (int i=0; i < c3.length(); i++) {

                nouvc3 = c3.charAt(i);
            }
            int nouv3 = Integer.parseInt(String.valueOf(nouvc3));
            System.out.println("Résultat : " + nouv3);
            System.out.println("Résultat calcul : " + (nouv3 * 2));

            for (int i=0; i < c5.length(); i++) {

                nouvc5 = c5.charAt(i);
            }

            int nouv5 = Integer.parseInt(String.valueOf(nouvc5));
            System.out.println("Résultat : " + nouv5);
            System.out.println("Résultat calcul : " + (nouv5 * 2));

            //c7 : le reste après division par 10 de c1 + 7 * c3 + 5 * c5
            c7 = (7 * nouv3) + (5 * nouv5) %10;
            System.out.println("c7 = " + c7);

            //c8 : le reste après division par 10 de 9 * ( c2 + c4 + 2 * c6 )
            char nouvc2 = '0';
            char nouvc4 = '0';
            char nouvc6 = '0';
            for (int i=0; i < c2.length(); i++) {

                nouvc2 = c2.charAt(i);
            }
            int nouv2 = Integer.parseInt(String.valueOf(nouvc2));

            System.out.println("Résultat : " + nouv2);
            System.out.println("Résultat calcul : " + (nouv2 * 2));

            for (int i=0; i < c4.length(); i++) {

                nouvc4 = c4.charAt(i);
            }

            int nouv4 = Integer.parseInt(String.valueOf(nouvc4));
            System.out.println("Résultat : " + nouv4);
            System.out.println("Résultat calcul : " + (nouv4 * 2));


            for (int i=0; i < c6.length(); i++) {

                nouvc6 = c6.charAt(i);
            }
            int nouv6 = Integer.parseInt(String.valueOf(nouvc6));

            System.out.println("Résultat : " + nouv6);
            System.out.println("Résultat calcul : " + (nouv6 * 2));


            //c8 : le reste après division par 10 de 9 * ( c2 + c4 + 2 * c6 )
            c8 = 9 * (nouv2 + nouv4 + 2 * nouv6) %10;
            System.out.println("c8 = " + c8);

            //c9 est un chiffre entre 0 et 9 tel que c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9 est un multiple de 10.



        /*Par exemple, si la date de naissance d'une femme est le 18 juin 1981, les 6 premiers chiffres du code
        seront 817618.
         * * Puis, c7 = le reste après division entière par 10 de 8 + 7 * 7 + 5 * 1 i.e. le reste après division
         par 10 de 62, donc 2.
         * c8 = le reste après division entière par 10 de 9* ( 1 + 6 + 2 * 8 ) i.e. le reste après
         division par 10 de 207, donc 7.
         * Si on additionne tous les chiffres du code sauf le dernier, on a : 8 + 1 + 7 + 6 + 1 + 8 + 2 + 7 = 40,
         donc c9 = 0. Le code sera donc 817618270 */





            System.out.println(sexeF);
            System.out.println(sexeM);
            System.out.println(c1+c2+c3+c4+c5+c6+"0000000");

        } while (/*nombre*/ annee == 0);
        moyenneFemmes = (float)(sexeF*100)/codeGenere;
        moyenneHommes = (float)(sexeM*100)/codeGenere;


        //AFFICHAGE DES RÉSULTATS

        //1. Le nombre de codes générés
        System.out.printf("\nNombre de code généré : %d", codeGenere);
        //2. Le nombre de codes générés à partir d’une année bissextile
          System.out.printf("\nNombre de code bisex généré : %d", codeBisex);
        //3. Le pourcentage de femmes et le nombre de pourcentage d'hommes
          System.out.printf("\nPourcentage du sexe Féminin : %1.2f%%", moyenneFemmes);
          System.out.printf("\nPourcentage du sexe Masculin : %1.2f%%", moyenneHommes);
        //Puis le programme termine son exécution en affichant le message : « FIN NORMALE DU PROGRAMME »
          System.out.printf("\nFIN NORMALE DU PROGRAMME");



    }
}
