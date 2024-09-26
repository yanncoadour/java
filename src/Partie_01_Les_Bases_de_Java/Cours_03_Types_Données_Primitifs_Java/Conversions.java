package Partie_01_Les_Bases_de_Java.Cours_03_Types_Données_Primitifs_Java;

public class Conversions {
    public static void main(String[] args) {
        int compte1 = 3456;
        double compte2 = 123.34;
        double compte3 = compte1;
        int compte4 = (int) compte2;

        System.out.println("compte 1 : " + compte1);
        System.out.println("compte 2 : " + compte2);
        System.out.println("compte 3 : " + compte3);
        System.out.println("compte 4 : " + compte4);

    }
}
