package util;

import java.util.Scanner;

public class Inquirer {
    public static String inquire() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String line = scanner.nextLine();

        scanner.close();
        return line;
    }
}
