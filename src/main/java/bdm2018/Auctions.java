package bdm2018;

import java.util.Scanner;

public class Auctions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nbEncheres = sc.nextInt();
        sc.nextLine();
        int prixReserve = sc.nextInt();
        sc.nextLine();

        String vainqueur = "KO";
        int meilleurEnchere = prixReserve;

        for(int i = 0; i < nbEncheres; i++) {
            String[] data = sc.nextLine().split(" ");
            int prix = Integer.parseInt(data[0]);
            String nom = data[1];
            if(prix > meilleurEnchere) {
                meilleurEnchere = prix;
                vainqueur = nom;
            }
        }
        System.out.println(vainqueur);
    }

}
