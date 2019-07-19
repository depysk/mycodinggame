package entrainement.easy;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

/**
 * Jeu de test
 *
 * 7 7
 * A  B  C
 * |  |  |
 * |--|  |
 * |  |--|
 * |  |--|
 * |  |  |
 * 1  2  3
 *
 *
 * 13 8
 * A  B  C  D  E
 * |  |  |  |  |
 * |  |--|  |  |
 * |--|  |  |  |
 * |  |  |--|  |
 * |  |--|  |--|
 * |  |  |  |  |
 * 1  2  3  4  5
 */
public class GhostLegs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();

        if (in.hasNextLine()) {
            in.nextLine();
        }

        String ghostHeaderKeys = in.nextLine();

        Map<Integer, String> ghostAreaRows = IntStream.range(0, H-2).boxed()
                .collect(toMap(index -> index, index -> in.nextLine()));

        String ghostFooterKeys = in.nextLine();

        int asciiSpaceCode = 32;
        int asciiVerticalLineCode = 124;
        int asciiHorizontalLineCode = 45;
        int ghostHeaderKeysLength = ghostHeaderKeys.length();
        int ghostAreaRowsSize = ghostAreaRows.size();

        for(int i = 0; i < ghostHeaderKeysLength; i++) {
            int beginIndex = i;
            if (ghostHeaderKeys.charAt(i) != asciiSpaceCode) {
                String returnValue = Character.toString(ghostHeaderKeys.charAt(i));
                for(int j = 0; j < ghostAreaRowsSize; j++) {
                    String line = ghostAreaRows.get(j);
                    int upSearchIndex = beginIndex + 1;
                    int backSearchIndex = beginIndex - 1;

                    if(beginIndex < (W-1) && line.charAt(upSearchIndex) == asciiHorizontalLineCode) {
                        int indexVert = line.indexOf(asciiVerticalLineCode, upSearchIndex);
                        if(indexVert != -1) {
                            beginIndex = indexVert;
                        }
                    } else if(beginIndex > 0 && line.charAt(backSearchIndex) == asciiHorizontalLineCode) {
                        int indexVert = line.lastIndexOf(asciiVerticalLineCode, backSearchIndex);
                        if(indexVert != -1) {
                            beginIndex = indexVert;
                        }
                    }

                }
                returnValue += Character.toString(ghostFooterKeys.charAt(beginIndex));
                System.out.println(returnValue);

            }
        }


    }
}
