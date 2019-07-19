package entrainement.easy;

import java.util.Scanner;
import java.util.StringJoiner;

public class AsciiArt {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();

        if (in.hasNextLine()) {
            in.nextLine();
        }

        String T = in.nextLine().toUpperCase();

        StringJoiner output = new StringJoiner("");

        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();

            for(int j=0; j < T.length(); j++) {
                char c = T.charAt(j);
                int rowIndex = c - 'A';
                if(rowIndex < 0 || rowIndex >= 26) {
                    rowIndex = 26;
                }
                output.add(ROW.substring(L*rowIndex, L*(rowIndex + 1)));
            }
            output.add("\n");
        }


        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(output.toString());
    }

}