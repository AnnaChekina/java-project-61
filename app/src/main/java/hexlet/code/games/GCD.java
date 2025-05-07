package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public final class GCD {

    private GCD() {
        throw new IllegalStateException("Utility class");
    }

    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM_NUMBER = 100;

    static int getRandomNumber() {
        return RANDOM.nextInt(MAX_RANDOM_NUMBER) + 1;
    }

    static int getGCD(int num1, int num2) {
        while (num2 != 0) {
            int tmp = num1 % num2;
            num1 = num2;
            num2 = tmp;
        }
        return num1;
    }

    public static void gcdGame() {
        String gameConditions = "Find the greatest common divisor of given numbers.";
        String[] questions = new String[Engine.QUANTITY_ROUNDS];
        String[] corAnswers = new String[Engine.QUANTITY_ROUNDS];

        int randomNumber1;
        int randomNumber2;

        for (var i = 0; i < Engine.QUANTITY_ROUNDS; i++) {
            randomNumber1 = getRandomNumber();
            randomNumber2 = getRandomNumber();

            questions[i] = randomNumber1 + " " + randomNumber2;
            corAnswers[i] = Integer.toString(getGCD(randomNumber1, randomNumber2));
        }

        Engine.start(gameConditions, questions, corAnswers);
    }
}
