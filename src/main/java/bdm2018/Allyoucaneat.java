package bdm2018;

import java.util.Scanner;

public class Allyoucaneat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double price = sc.nextDouble();
        sc.nextLine();

        int tables = sc.nextInt();
        sc.nextLine();

        double totalPrice = 0.0;

        for(int i = 0; i <tables; i++) {
            int people = sc.nextInt();
            totalPrice += (price * people) - getPercentagePrice(people, price);
            sc.nextLine();
        }
        System.out.println(new Double(Math.ceil(totalPrice)).intValue());
    }

    private static double getPercentagePrice(int people, double price) {
        if(people >= 10) {
            return people * ((price * 30) / 100);
        } else if(people >= 6) {
            return people * ((price * 20) / 100);
        } else if(people >= 4) {
            return people * ((price * 10) / 100);
        }
        return 0.0;
    }

}
