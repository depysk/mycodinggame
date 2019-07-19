package bdm2018;

import java.util.Arrays;
import java.util.Scanner;

public class Tripadvisor {
    public static void main( String[] argv ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int restaurantNumber = sc.nextInt();
        sc.nextLine();

        int result = Integer.MIN_VALUE;

        for(int i = 0; i < restaurantNumber; i++) {
            String line = sc.nextLine();
            String[] notes = line.split(" ");
            double notesSum = Arrays.stream(notes)
                    .map(Double::parseDouble)
                    .reduce(0.0, Double::sum);
            double noteAverage = Math.ceil(notesSum/notes.length);

            if(noteAverage > result) {
                result = new Double(noteAverage).intValue();
            }

        }
        System.out.println(result);

    }

    private static boolean checkRestaurantNumber(int restaurants) {
        return restaurants >= 2 && restaurants <= 500;
    }
}
