package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public final class Calc {

    private Calc() {
        throw new IllegalStateException("Utility class");
    }

    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM_NUMBER = 100;

    static int getRandomNumber() {
        return RANDOM.nextInt(MAX_RANDOM_NUMBER) + 1;
    }

    static String getRandomSign() {
        String[] signs = {" + ", " - ", " * "};
        int numSign = RANDOM.nextInt(signs.length);
        return signs[numSign];
    }

    public static void calcGame() {
        String gameConditions = "What is the result of the expression?";
        String[] questions = new String[3];
        String[] corAnswers = new String[3];

        int randomNumber1;
        int randomNumber2;
        String randomSign;
        int corAnswer;

        for (var i = 0; i < 3; i++) {
            randomNumber1 = getRandomNumber();
            randomNumber2 = getRandomNumber();
            randomSign = getRandomSign();

            corAnswer = switch (randomSign) {
                case " + " -> randomNumber1 + randomNumber2;
                case " - " -> randomNumber1 - randomNumber2;
                case " * " -> randomNumber1 * randomNumber2;
                default -> throw new IllegalStateException("Unexpected value: " + randomSign);
            };

            questions[i] = randomNumber1 + randomSign + randomNumber2;
            corAnswers[i] = Integer.toString(corAnswer);
        }

        Engine.start(gameConditions, questions, corAnswers);
    }
}
