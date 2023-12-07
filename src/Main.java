import util.Console;
import lexeme.Text;

public class Main {
    public static void main(String[] args) {
        String input = Console.inquire();

        Text text = new Text(input);
        text.toWords();
        text.unifyWords();
        text.sortWords();
        String output = text.getString();

        Console.printTitled("Output", output); 
    }
}
