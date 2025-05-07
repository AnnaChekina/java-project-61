package hexlet.code;

import java.util.Scanner;

public final class Engine {

    private Engine() {
        throw new IllegalStateException("Utility class");
    }

    public static final int QUANTITY_ROUNDS = 3;

    public static void start(String gameConditions, String[][] questionsAndAnswers) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.nextLine().trim();
        System.out.println("Hello, " + userName + "!");

        System.out.println(gameConditions);

        for (var i = 0; i < QUANTITY_ROUNDS; i++) {
            System.out.println("Question: " + questionsAndAnswers[i][0]);
            System.out.print("Your answer: ");
            String answer = scanner.nextLine().trim();
            if (questionsAndAnswers[i][1].equals(answer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '"
                        + questionsAndAnswers[i][1] + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}
