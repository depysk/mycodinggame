package bdm2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MagicWords {

    static List<String> voyelles = Arrays.asList("a", "e", "i", "o", "u", "y");
    static Pattern reg = Pattern.compile("[a-z]{2}");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nnMots = sc.nextInt();
        sc.nextLine();

        List<String> magicwords = new ArrayList<>();

        for(int i = 0; i < nnMots; i++) {
            String line = sc.nextLine();
            System.err.println(line);
            if(
                    (line.length() >= 5 && line.length() <= 7)
                    && consecutive(line.substring(0, 2))
                    && contain(line.substring(line.length() -1))) {
                magicwords.add(line);
            }

        }
        System.out.println(magicwords.size());
    }

    private static boolean contain(String toCheck) {
        boolean contains = voyelles.contains(toCheck);
        System.err.println(contains);
        return contains;
    }

    private static boolean consecutive(String line) {
        boolean r = false;
        if(reg.matcher(line).find()) {
            char first = line.charAt(0);
            char second = line.charAt(1);
            r = second - first == 1;
        }
        System.err.println(r);
        return r;
    }
}
