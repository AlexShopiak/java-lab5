package util;

import java.util.Scanner;

public class Inquirer {
    public static String inquire() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\u001B[1m" + "Enter the text: " + "\u001B[0m");
        String line = scanner.nextLine();

        scanner.close();
        return line;
    }
}
