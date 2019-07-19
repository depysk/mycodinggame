package entrainement.easy;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class HorseRacingDuals {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        List<Integer> horses = IntStream.range(0, N)
                .mapToObj(index -> in.nextInt())
                .filter(value -> value > 0 && value <= 10000000)
                .sorted()
                .collect(toList());

        int gap = Integer.MAX_VALUE;
        int previousValue = 0;

        for (int horse : horses) {
            int newGap = horse - previousValue;
            if (newGap >= 0 && newGap < gap) {
                gap = newGap;
            }
            previousValue = horse;
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(gap);
    }
}
