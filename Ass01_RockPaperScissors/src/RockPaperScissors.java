import java.util.Scanner;

class RockPaperScissors{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        do {
            String playerAChoice = getPlayerChoice(scanner, "Player A");
            String playerBChoice = getPlayerChoice(scanner, "Player B");

            String result = determineWinner(playerAChoice, playerBChoice);
            System.out.println(result);

            System.out.println("Do you want to play again? [Y/N]");
            playAgain = scanner.nextLine().trim().toUpperCase();
        } while (playAgain.equals("Y"));

        System.out.println("Thank you for playing!");
    }

    private static String getPlayerChoice(Scanner scanner, String player) {
        String choice;
        while (true) {
            System.out.println(player + ", enter your move (R, P, S, r, p, s): ");
            choice = scanner.nextLine().trim().toUpperCase();
            if (choice.equals("R") || choice.equals("P") || choice.equals("S")) {
                break;
            } else {
                System.out.println("Invalid move. Please enter R, P, or S.");
            }
        }
        return choice;
    }

    private static String determineWinner(String playerAChoice, String playerBChoice) {
        if (playerAChoice.equals(playerBChoice)) {
            return playerAChoice + " vs " + playerBChoice + " it's a Tie!";
        } else if ((playerAChoice.equals("R") && playerBChoice.equals("S")) ||
                (playerAChoice.equals("P") && playerBChoice.equals("R")) ||
                (playerAChoice.equals("S") && playerBChoice.equals("P"))) {
            return getWinningPhrase(playerAChoice, playerBChoice) + " Player A wins!";
        } else {
            return getWinningPhrase(playerBChoice, playerAChoice) + " Player B wins!";
        }
    }

    private static String getWinningPhrase(String winner, String loser) {
        if (winner.equals("R") && loser.equals("S")) {
            return "Rock breaks Scissors,";
        } else if (winner.equals("P") && loser.equals("R")) {
            return "Paper covers Rock,";
        } else if (winner.equals("S") && loser.equals("P")) {
            return "Scissors cuts Paper,";
        }
        return "";
    }
}
