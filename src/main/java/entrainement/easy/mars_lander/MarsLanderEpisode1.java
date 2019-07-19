package entrainement.easy.mars_lander;

import java.util.Scanner;
import java.util.StringJoiner;

public class MarsLanderEpisode1 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int surfaceN = in.nextInt(); // the number of points used to draw the surface of Mars.
        for (int i = 0; i < surfaceN; i++) {
            int landX = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
            int landY = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.

        }

        // game loop
        while (true) {
            StringJoiner output = new StringJoiner(" ");

            int X = in.nextInt();
            int Y = in.nextInt();
            int hSpeed = in.nextInt(); // the horizontal speed (in m/s), can be negative.
            int vSpeed = in.nextInt(); // the vertical speed (in m/s), can be negative.
            int fuel = in.nextInt(); // the quantity of remaining fuel in liters.
            int rotate = in.nextInt(); // the rotation angle in degrees (-90 to 90).
            int power = in.nextInt(); // the thrust power (0 to 4).

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            output.add(""+rotate);

            if(Math.abs(vSpeed) < 39) {
                power = power - 1 >= 0 ? power - 1 : power;
            } else {
                power = power + 1 <= 4 ? power + 1 : power;
            }
            output.add(""+power);
            // 2 integers: rotate power. rotate is the desired rotation angle (should be 0 for level 1), power is the desired thrust power (0 to 4).
            System.out.println(output.toString());
        }
    }
}
