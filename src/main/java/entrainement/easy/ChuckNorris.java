package entrainement.easy;

import java.util.Collections;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ChuckNorris {

    public static void main(String args[]) {
//        Scanner in = new Scanner(System.in);
//        String MESSAGE = in.nextLine(); 10000111000011
        String MESSAGE = "%";
        StringJoiner output = new StringJoiner(" ");

        /* Solution 1*/
        MESSAGE.chars()
                .mapToObj(charElt -> String.format("%7s", Integer.toBinaryString(charElt)).replace(' ', '0'))
                .collect(Collectors.joining(""))
                .chars().reduce('s', (a, b) -> {
            System.out.print(a == b ? "0" : ((a != 's' ? " " : "") + (b == '1' ? "0 0" : "00 0")));
            return b;
        });
        System.out.println();

        /* Solution 2*/
        String messageBinaryString = MESSAGE.chars()
                .mapToObj(charElt -> String.format("%7s", Integer.toBinaryString(charElt)).replace(' ', '0'))
                .collect(Collectors.joining(""));


        do {
            char c = messageBinaryString.charAt(0);
            int cIndex;
            String converted;
            if(c == '0') {
                cIndex = messageBinaryString.indexOf('1', 1) > 0 ? messageBinaryString.indexOf('1', 1) : messageBinaryString.length();
                converted = "00 "+ String.join("", Collections.nCopies(cIndex, "0"));

            } else {
                cIndex = messageBinaryString.indexOf('0', 1) > 0 ? messageBinaryString.indexOf('0', 1) : messageBinaryString.length();
                converted = "0 "+ String.join("", Collections.nCopies(cIndex, "0"));
            }

            output.add(converted);
            messageBinaryString = messageBinaryString.substring(cIndex);

        } while(!messageBinaryString.isEmpty());



        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(output.toString());

//        /* Best Solution */
//        Scanner in = new Scanner(System.in);
//        char[] MESSAGE = in.nextLine().toCharArray();
//
//        boolean pbit = (MESSAGE[0] & 0x40) != 0;
//        System.out.print(pbit ? "0 " : "00 ");
//
//        for (char B : MESSAGE)
//        {
//            for (char bm = 0x40; bm != 0; bm >>= 1)
//            {
//                boolean bit = (B & bm) != 0;
//                System.out.print((bit == pbit) ? "0"
//                        : bit ? " 0 0"
//                        : " 00 0");
//                pbit = bit;
//            }
//        }
    }
}
