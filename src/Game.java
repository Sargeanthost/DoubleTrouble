import java.util.Random;

public class Game {
    //game numbers
    private int green = 3;
    private int orange = 5;
    private int yellow = 7;

    /***
     * Make the optimal move if available. If given nim sum, will default to random move.
     *
     * @return returns an array, with the zero element the category, and the one element the
     * amount taken.
     */
    public int[] makeMoveComputer() {
        int go = green ^ orange;
        int gy = green ^ yellow;
        int oy = orange ^ yellow;

        if (yellow > go) {
            int amount = yellow - go;
            yellow -= amount;
            return new int[] {2, amount};
        } else if (orange > gy) {
            int amount = orange - gy;
            orange -= amount;
            return new int[] {1, amount};
        } else if (green > oy) {
            int amount = green - oy;
            green -= amount;
            return new int[] {0, amount};
        } else {
            return makeRandomMove();
        }
    }

    private int[] makeRandomMove() {
        System.out.println("RANDOM");
        Random randNum = new Random();
        int subtract;
        int category = randNum.nextInt(3);
        //check if valid
        boolean isValid = true;
        while (isValid) {
            switch (category) {
                case 0:
                    if (green == 0) {
                        category = randNum.nextInt(3);
                    } else {
                        isValid = false;
                    }
                    break;
                case 1:
                    if (orange == 0) {
                        category = randNum.nextInt(3);
                    } else {
                        isValid = false;
                    }
                    break;
                case 2:
                    if (yellow == 0) {
                        category = randNum.nextInt(3);
                    } else {
                        isValid = false;
                    }
            }
        }

        switch (category) {
            case 0 -> {
                subtract = randNum.nextInt(green) + 1;
                green -= subtract;
                return new int[] {0, subtract};
            }
            case 1 -> {
                subtract = randNum.nextInt(orange) + 1;
                orange -= subtract;
                return new int[] {1, subtract};
            }
            case 2 -> {
                subtract = randNum.nextInt(yellow) + 1;
                yellow -= subtract;
                return new int[] {2, subtract};
            }
        }
        return new int[] {0, 0};
    }

    /**
     * Take away a certain amount from one, and only one, category.
     *
     * @param category the category to take from. 0 for three, 1 for five, and 2 for seven
     * @param amount   how many stones to take away. Inputting a number larger than current amount will take all
     *                 available stones
     */
    public void makeMoveHuman(int category, int amount) {
        //return boolean. true if everything went well, false if made illegal move.
        switch (category) {
            case 0 -> green = Math.max(0, (green - amount));
            case 1 -> orange = Math.max(0, (orange - amount));
            case 2 -> yellow = Math.max(0, (yellow - amount));
            default -> System.out.println("You tricked me");
        }
    }

    public void printBoard() {
        System.out.println("Printing board...");
        System.out.println("\033[0;32m   " + "|".repeat(green) + "   \033[0m");
        System.out.println("\033[0;31m  " + "|".repeat(orange) + "  \033[0m");
        System.out.println("\033[0;33m " + "|".repeat(yellow) + " \033[0m");
    }

    public boolean isFinished() {
        return green + orange + yellow == 0;
    }
}
