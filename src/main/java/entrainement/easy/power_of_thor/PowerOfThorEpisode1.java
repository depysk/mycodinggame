package entrainement.easy.power_of_thor;

import java.util.*;

class PowerOfThorEpisode1 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTX = in.nextInt(); // Thor's starting X position
        int initialTY = in.nextInt(); // Thor's starting Y position

        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.
            StringBuilder  move = new StringBuilder ();
            
            
            if(initialTX < lightX && isThorXPositionStillInTheArea(initialTX)) {
                if(initialTY < lightY && isThorYPositionStillInTheArea(initialTY)) {
                    move.append("SE");
                    initialTX++;
                    initialTY++;
                } else if(initialTY > lightY && isThorYPositionStillInTheArea(initialTY)) {
                    move.append("NE");
                    initialTX++;
                    initialTY--;
                } else {
                    move.append("E");
                    initialTX++;
                }
            } else if(initialTX > lightX && isThorXPositionStillInTheArea(initialTX)) {
                if(initialTY < lightY && isThorYPositionStillInTheArea(initialTY)) {
                    move.append("SW");
                    initialTX--;
                    initialTY++;
                } else if(initialTY > lightY && isThorYPositionStillInTheArea(initialTY)) {
                    move.append("NW");
                    initialTX--;
                    initialTY--;
                } else {
                    move.append("W");
                    initialTX--;
                }
            } else {
                if(initialTY < lightY) {
                    move.append("S");
                    initialTY++;
                } else if(initialTY > lightY) {
                    move.append("N");
                    initialTY--;
                }
            }
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // A single line providing the move to be made: N NE E SE S SW W or NW
            System.out.println(move.toString());
        }
    }
    
    private static boolean isThorXPositionStillInTheArea(int initialTX) {
        return initialTX < 40 && initialTX >= 0;
    }
    
    private static boolean isThorYPositionStillInTheArea(int initialTY) {
        return initialTY < 18 && initialTY >= 0;
    }
}