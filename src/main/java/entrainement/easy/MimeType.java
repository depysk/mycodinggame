package entrainement.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MimeType {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        Map<String, String> mimeTypes = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String EXT = in.next().toLowerCase(); // file extension
            String MT = in.next(); // MIME type.
            mimeTypes.put(EXT, MT);
        }

        in.nextLine();

        for (int j = 0; j < Q; j++) {
            String FNAME = in.nextLine(); // One file name per line.
            String mimeType = "UNKNOWN";
            if(FNAME.lastIndexOf(".") != -1) {
                mimeType = mimeTypes.getOrDefault(FNAME.substring(FNAME.lastIndexOf(".") + 1).toLowerCase(), "UNKNOWN");
            }
            System.out.println(mimeType);
        }


        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");


        // For each of the Q filenames, display on a line the corresponding MIME type. If there is no corresponding type, then display UNKNOWN.
    }
}
