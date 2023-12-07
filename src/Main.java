import util.Console;
import lexeme.Text;

public class Main {
    public static void main(String[] args) {
        String input = Console.inquire();

        Text text = new Text(input);
        Text unique = text.getUniqueWords();
        Text sorted = unique.getSortedWords();
        String output = sorted.getString();

        Console.printTitled("Output", output); 
    }
}
