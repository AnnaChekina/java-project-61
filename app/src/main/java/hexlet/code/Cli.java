package hexlet.code;

import java.util.Scanner;

public final class Cli {

    private Cli() {
        throw new IllegalStateException("Utility class");
    }

    private static String userName;

    public static void greeting() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = scanner.nextLine().trim();
        System.out.println("Hello, " + userName + "!");
    }

    public static String getUserName() {
        return userName;
    }
}
