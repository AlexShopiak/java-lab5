package util;

import java.util.Scanner;

public class Console {
    private static final String BOLD_STD = "\u001B[1m";
    private static final String BOLD_END = "\u001B[0m";

    public static String inquire() {
        Scanner scanner = new Scanner(System.in);

        System.out.print(BOLD_STD + "Enter the text: " + BOLD_END);
        String line = scanner.nextLine();

        scanner.close();
        return line;
    }

    public static void printTitled(String title, String text) {
        System.out.println();
        System.out.println(BOLD_STD + title + ": " + BOLD_END + text);
        System.out.println();
    }
}
