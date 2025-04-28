package hexlet.code;

import hexlet.code.games.Even;

import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);
    static String numMenu;

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");

        checkNumMenu();

        scanner.close();
    }

    public static void checkNumMenu() {
        System.out.print("Your choice: ");
        numMenu = scanner.nextLine().trim();

        switch (numMenu) {
            case "1":
                Cli.greeting();
                break;
            case "2":
                Even.evenGame();
                break;
            case "0":
                System.out.println("Exiting the game. Goodbye!");
                break;
            default:
                System.out.println("Your choice is incorrect. Let's try again!");
                checkNumMenu();
        }
    }
}
