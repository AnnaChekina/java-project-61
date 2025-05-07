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

    static int getCalcSolution(int num1, int num2, String sign) {
        int corAnswer;
        corAnswer = switch (sign) {
            case " + " -> num1 + num2;
            case " - " -> num1 - num2;
            case " * " -> num1 * num2;
            default -> throw new IllegalStateException("Unexpected value: " + sign);
        };
        return corAnswer;
    }

    public static void calcGame() {
        String gameConditions = "What is the result of the expression?";
        String[] questions = new String[Engine.QUANTITY_ROUNDS];
        String[] corAnswers = new String[Engine.QUANTITY_ROUNDS];

        int randomNumber1;
        int randomNumber2;
        String randomSign;

        for (var i = 0; i < Engine.QUANTITY_ROUNDS; i++) {
            randomNumber1 = getRandomNumber();
            randomNumber2 = getRandomNumber();
            randomSign = getRandomSign();

            questions[i] = randomNumber1 + randomSign + randomNumber2;
            corAnswers[i] = Integer.toString(getCalcSolution(randomNumber1, randomNumber2, randomSign));
        }

        Engine.start(gameConditions, questions, corAnswers);
    }
}
