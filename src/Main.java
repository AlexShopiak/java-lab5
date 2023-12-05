import util.Inquirer;
import util.Calculator;

public class Main {

    public static void main(String[] args) {
        String input = Inquirer.inquire();
        printText("Input", input);

        String output = Calculator.calculate(input);
        printText("Output", output);

        System.out.println();
    }

    private static void printText(String title, String text) {
        //Bold title and nonbold text
        System.out.println("\n\u001B[1m" + title + ": \u001B[0m" + text);
    }
}
