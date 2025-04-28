package hexlet.code;

import java.util.Scanner;

public final class Engine {

    private Engine() {
        throw new IllegalStateException("Utility class");
    }

    public static void start(String gameConditions, String[] questions, String[] corAnswers) {

        Cli.greeting();

        Scanner scanner = new Scanner(System.in);

        System.out.println(gameConditions);

        boolean gameOver = true;

        for (var i = 0; i < 3; i++) {
            System.out.println("Question: " + questions[i]);
            System.out.print("Your answer: ");
            String answer = scanner.nextLine().trim();
            if (corAnswers[i].equals(answer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + corAnswers[i] + "'.");
                System.out.println("Let's try again, " + Cli.getUserName() + "!");
                gameOver = false;
                break;
            }
        }
        if (gameOver) {
            System.out.println("Congratulations, " + Cli.getUserName() + "!");
        }
    }
}
