package entrainement.medium.no_spoon;

import java.util.Scanner;
import java.util.StringJoiner;

public class NoSpoonEpisode1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        if (in.hasNextLine()) {
            in.nextLine();
        }

        char[][] data = new char[height][width];
        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            data[i] = line.toCharArray();
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                char node = data[i][j];
                if(node == '0') {
                    StringJoiner target = new StringJoiner(" ");
                    target.add(String.valueOf(j)).add(String.valueOf(i));

                    String x2y2 = null;
                    int k = j;
                    while(x2y2 == null) {
                        x2y2 = k + 1 >= width? "-1 -1" : data[i][k + 1] == '0' ? (k + 1)+" "+i : null;
                        k++;
                    }
                    target.add(x2y2);

                    String x3y3 = null;
                    int l = i;
                    while(x3y3 == null) {
                        x3y3 = l + 1 >= height? "-1 -1" : data[l + 1][j] == '0' ? j+" "+(l + 1) : null;
                        l++;
                    }
                    target.add(x3y3);
                    System.out.println(target.toString());
                }
            }
        }


        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");


        // Three coordinates: a node, its right neighbor, its bottom neighbor
    }
}
