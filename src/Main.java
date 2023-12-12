/*
 * Main
 *
 * Version 1.0
 *
 * (c) 2023 Oleksii Shopiak
 * All rights reserved.
 *
 * This is an entry point of a project.
 */
import util.Console;
import lexeme.TextMaster;

public class Main {
    public static void main(String[] args) {
        String input = Console.inquire();

        TextMaster master = new TextMaster(input);
        master.turnTextToWords();
        master.unifyWordsInSentences();
        master.sortWordsByAlphabet();
        String output = master.getString();

        Console.printTitled("Output", output); 
    }
}
