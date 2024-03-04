import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter the maximum number for the range: ");
        int MAX_NUMBER = scanner.nextInt();

        System.out.print("Enter the maximum number of attempts per round: ");
        int MAX_ATTEMPTS = scanner.nextInt();

        System.out.print("Enter the number of rounds: ");
        int MAX_ROUNDS = scanner.nextInt();

        int totalScore = 0;

        System.out.println("Welcome to Guess the Number!");
        System.out.println("You have " + MAX_ROUNDS + " rounds to play.");

        for (int round = 1; round <= MAX_ROUNDS; round++) {
            int secretNumber = random.nextInt(MAX_NUMBER) + 1;
            System.out.println("The secret number is"+secretNumber);
            int attempts = 0;
            int roundScore = 0;

            System.out.println("\nRound " + round + ":");
            System.out.println("I've selected a number between 1 and " + MAX_NUMBER + ". Can you guess it?");
            
            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Attempt " + (attempts + 1) + "/" + MAX_ATTEMPTS + ": Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    roundScore = MAX_ATTEMPTS - attempts + 1;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    System.out.println("Your score for this round: " + roundScore);
                    totalScore += roundScore;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (roundScore == 0) {
                System.out.println("Sorry, you've reached the maximum number of attempts.");
                System.out.println("The correct number was: " + secretNumber);
            }
        }

        System.out.println("\nGame over!");
        System.out.println("Total score: " + totalScore);
        scanner.close();
    }
}
