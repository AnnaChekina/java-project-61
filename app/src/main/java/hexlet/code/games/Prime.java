package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public final class Prime {

    private Prime() {
        throw new IllegalStateException("Utility class");
    }

    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM_NUMBER = 100;

    static int getRandomNumber() {
        return RANDOM.nextInt(MAX_RANDOM_NUMBER) + 1;
    }

    static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void primeGame() {
        String gameConditions = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[] questions = new String[Engine.QUANTITY_ROUNDS];
        String[] corAnswers = new String[Engine.QUANTITY_ROUNDS];

        int randomNumber;
        String corAnswer;

        for (var i = 0; i < Engine.QUANTITY_ROUNDS; i++) {
            randomNumber = getRandomNumber();

            if (isPrime(randomNumber)) {
                corAnswer = "yes";
            } else {
                corAnswer = "no";
            }

            questions[i] = Integer.toString(randomNumber);
            corAnswers[i] = corAnswer;
        }

        Engine.start(gameConditions, questions, corAnswers);
    }
}
