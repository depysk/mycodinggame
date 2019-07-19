package entrainement.easy;

import java.util.*;

public class Temperature {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        int output = 0;

        if(isNumberOfTemperaturesValid(n)) {
            if (in.hasNextLine()) {
                in.nextLine();
            }
            String temps = in.nextLine(); // the n temperatures expressed as integers ranging from -273 to 5526
            List<String> temperatures = Arrays.asList(temps.split(" "));

            Optional<Integer> maxNegativeValue = temperatures.stream()
                    .filter(input -> !input.isEmpty())
                    .map(Integer::valueOf)
                    .filter(temperature -> temperature < 0)
                    .max(Comparator.comparingInt(temp -> temp));

            if (maxNegativeValue.isPresent()) {
                output = maxNegativeValue.get();
            }

            Optional<Integer> minPositiveValue = temperatures.stream()
                    .filter(input -> !input.isEmpty())
                    .map(Integer::valueOf)
                    .filter(temperature -> temperature > 0)
                    .min(Comparator.comparingInt(temp -> temp));

            if (minPositiveValue.isPresent()) {
                int value = minPositiveValue.get();
                int absOutput = Math.abs(output);

                if(absOutput == 0 || value <= absOutput && value > 0) {
                    output = value;
                }
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
        }

        System.out.println(output);
    }

    private static boolean isNumberOfTemperaturesValid(int temperature) {
        return temperature >= 0 && temperature < 10000;
    }
}
