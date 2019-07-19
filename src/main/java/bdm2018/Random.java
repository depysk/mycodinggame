package bdm2018;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class Random {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double valToCheck = (sc.nextDouble() / 2);
        sc.nextLine();

        List<Double> functValues = Arrays.stream(sc.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(toList());

        int size = functValues.size();
        int nbFois = 0;
        boolean infini = false;
        for(int i = 0; i < (size - 1); i++) {
            double max = Math.max(functValues.get(i), functValues.get(i + 1));
            double min = Math.min(functValues.get(i), functValues.get(i + 1));
            if(max == valToCheck && min == valToCheck ) {
                infini = true;
            } else if (min < valToCheck && max >= valToCheck) {
                nbFois++;
            }
        }
        System.out.println(infini ? "INF" : nbFois);
    }
}
