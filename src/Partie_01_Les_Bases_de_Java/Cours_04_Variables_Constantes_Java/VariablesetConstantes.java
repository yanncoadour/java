package Partie_01_Les_Bases_de_Java.Cours_04_Variables_Constantes_Java;

public class VariablesetConstantes {
    public static void main(String[] args) {
        int age = 35;
        double taille = 15.5;
        char sexe = 'M';
        System.out.println(age + " " + taille + " " + sexe);
        age = 36;
        taille = 16.9;
        sexe = 'F';
        System.out.println(age + " " + taille + " " + sexe);

        final double TVA = 0.20;
        int prixDepart = 5;
        int prixArrivee = (int) (prixDepart * TVA);
        System.out.println(prixDepart + " " + prixArrivee + "prix total =" + (prixDepart + prixArrivee));
    }

}
