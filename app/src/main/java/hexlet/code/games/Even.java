package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public final class Even {

    private Even() {
        throw new IllegalStateException("Utility class");
    }

    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM_NUMBER = 1000;

    static int getRandomNumber() {
        return RANDOM.nextInt(MAX_RANDOM_NUMBER) + 1;
    }

    public static void evenGame() {
        String gameConditions = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[] questions = new String[Engine.QUANTITY_ROUNDS];
        String[] corAnswers = new String[Engine.QUANTITY_ROUNDS];

        int randomNumber;
        String corAnswer;

        for (var i = 0; i < Engine.QUANTITY_ROUNDS; i++) {
            randomNumber = getRandomNumber();

            if (randomNumber % 2 == 0) {
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
