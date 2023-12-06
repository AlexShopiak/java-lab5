import util.Inquirer;
import lexeme.Text;
import util.Calculator;

public class Main {

    public static void main(String[] args) {
        String input = Inquirer.inquire();
        Text text = new Text(input);

        Calculator.calculate(text);

        String output = text.get();

        print("Output", output); 
    }

    private static void print(String title, String text) {
        //Bold title and nonbold text
        System.out.println();
        System.out.println("\u001B[1m" + title + ": \u001B[0m" + text);
        System.out.println();
    }
}
