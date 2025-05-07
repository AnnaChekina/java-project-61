package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public final class Progression {

    private Progression() {
        throw new IllegalStateException("Utility class");
    }

    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM_FIRST_NUMBER = 20;
    private static final int MAX_RANDOM_STEP = 10;
    private static final int MAX_RANDOM_POSITION = 10;

    static String[] generateRoundData() {
        int randomFirstNumber = RANDOM.nextInt(MAX_RANDOM_FIRST_NUMBER) + 1;
        int randomStep = RANDOM.nextInt(MAX_RANDOM_STEP) + 1;
        int randomPosition = RANDOM.nextInt(MAX_RANDOM_POSITION);
        int nextNumber = randomFirstNumber;
        int corAnswer = 0;
        StringBuilder question = new StringBuilder();

        for (var i = 0; i < MAX_RANDOM_POSITION; i++) {
            if (i == randomPosition) {
                question.append(".. ");
                corAnswer = nextNumber;
            } else {
                question.append(nextNumber).append(" ");
            }
            nextNumber += randomStep;
        }
        return new String[] {String.valueOf(question).trim(), Integer.toString(corAnswer)};
    }

    public static void progressionGame() {
        String gameConditions = "What number is missing in the progression?";
        String[] questions = new String[Engine.QUANTITY_ROUNDS];
        String[] corAnswers = new String[Engine.QUANTITY_ROUNDS];

        for (var i = 0; i < Engine.QUANTITY_ROUNDS; i++) {
            String[] roundData = generateRoundData();

            questions[i] = roundData[0];
            corAnswers[i] = roundData[1];
        }

        Engine.start(gameConditions, questions, corAnswers);
    }
}
