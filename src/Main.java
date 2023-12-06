import util.Inquirer;
import util.Converter;
import util.Calculator;

public class Main {

    public static void main(String[] args) {
        String inputStr = Inquirer.inquire();
        Text inputText = Converter.strToText(inputStr);

        Text outputText = Calculator.calculate(inputText);
        String outputStr = Converter.textToStr(outputText);

        printStr("Output", output);
        System.out.println();
    }

    private static void printStr(String title, String text) {
        //Bold title and nonbold text
        System.out.println("\n\u001B[1m" + title + ": \u001B[0m" + text);
    }
}
