package entrainement.easy;

import java.util.Scanner;

public class Defibrillators {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String LON = in.next();
        String LAT = in.next();
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        Double minDistance = Double.MAX_VALUE;
        String defibrillator = "none";

        for (int i = 0; i < N; i++) {
            String DEFIB = in.nextLine();
            String[] defibInfo = DEFIB.split(";");
            Double distance = calculateDistance(LON, LAT, defibInfo[4], defibInfo[5]);
            if(distance.compareTo(minDistance) < 0) {
                minDistance = distance;
                defibrillator = defibInfo[0];
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(defibrillator);
    }

    private static Double calculateDistance(String userLon, String userLat, String defibLon, String defibLat) {
        Double userLonRad = Math.toRadians(Double.valueOf(userLon.replaceAll(",", ".")));
        Double userLatRad = Math.toRadians(Double.valueOf(userLat.replaceAll(",", ".")));
        Double defibLonRad = Math.toRadians(Double.valueOf(defibLon.replaceAll(",", ".")));
        Double defibLatRad = Math.toRadians(Double.valueOf(defibLat.replaceAll(",", ".")));

        Double x = (defibLonRad - userLonRad) * Math.cos((userLonRad + defibLonRad) / 2);
        Double y = defibLatRad - userLatRad;

        return Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2))) * 6371;
    }
}
