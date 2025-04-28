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

    public static void gcdGame() {
        String gameConditions = "Find the greatest common divisor of given numbers.";
        String[] questions = new String[3];
        String[] corAnswers = new String[3];

        int randomNumber1;
        int randomNumber2;
        int corAnswer;

        for (var i = 0; i < 3; i++) {
            randomNumber1 = getRandomNumber();
            randomNumber2 = getRandomNumber();
            int a = randomNumber1;
            int b = randomNumber2;

            while (b != 0) {
                int tmp = a % b;
                a = b;
                b = tmp;
            }
            corAnswer = a;

            questions[i] = randomNumber1 + " " + randomNumber2;
            corAnswers[i] = Integer.toString(corAnswer);
        }

        Engine.start(gameConditions, questions, corAnswers);
    }
}
