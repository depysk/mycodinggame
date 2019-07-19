package entrainement.easy;
import java.util.Scanner;

class TheDescent {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int hightestMountainIndex = 0;

        // game loop
        while (true) {
            int hightestMountain = 0;

            for (int i = 0; i < 8; i++) {
                int mountainH = in.nextInt(); // represents the height of one mountain.

                hightestMountain = Math.max(hightestMountain, mountainH);
                if (hightestMountain == mountainH) {
                    hightestMountainIndex = i;
                }
            }


            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println(hightestMountainIndex); // The index of the mountain to fire on.
        }
    }
}