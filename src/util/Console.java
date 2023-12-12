/*
 * Console
 *
 * Version 1.0
 *
 * (c) 2023 Oleksii Shopiak
 * All rights reserved.
 *
 * This class contains some allias of interacting with System IO
 */
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
