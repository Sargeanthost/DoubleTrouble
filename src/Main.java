import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isComputerTurn = false;
        Game game = new Game();

        System.out.println(
            "Playing a game of Double-Trouble, a Nim style game! The person with zero stones left after their turn "
            + "wins! Enter 1 to go first, or enter 0 to let the Omniscient Solver go first!");
        Scanner scanner = new Scanner(System.in);
        short answer = scanner.nextShort();

        System.out.println("Starting the game!");
        if (answer != 1) {
            isComputerTurn = true;
        }

        while (!game.isFinished()) {
            //display board first thing
            game.printBoard();
            //ask input on the category, and then ask for input on how many to take.
            if (isComputerTurn) {
                Helper.printHelper(game.makeMoveComputer());
            } else {
                System.out.println("Enter 0, 1, or 2 for category green, orange, or yellow");
                int category = scanner.nextInt();
                System.out.println("Enter a number to take away from this category. If your number is bigger than "
                                   + "what is present, 0 will be left.");
                int amount = scanner.nextInt();
                //not print, human knows what they did
                game.makeMoveHuman(category, amount);
            }
            isComputerTurn = !isComputerTurn;
        }

        if (!isComputerTurn) {
            System.out.println("Computer won!");
        } else {
            System.out.println("You won!");
        }
    }
}