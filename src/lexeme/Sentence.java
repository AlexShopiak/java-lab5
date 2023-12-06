package lexeme;

import java.util.ArrayList;

class Sentence{
    private ArrayList<WordPunct> wordPuncts;

    Sentence(String input) {
        wordPuncts = new ArrayList<>();
        parse(input);
    }

    void parse(String input) {
        input = input.replaceAll("([.,!?:;-])", " $1");
        String[] list = input.split("\\s+");

        for(String elem : list) {
            if (elem.matches("[.,!?:;-]")) {
                wordPuncts.add(new Punctuation(elem));
            } else {
                wordPuncts.add(new Word(elem));
            }
        }
    }

    String join() {
        String output = "";

        for (WordPunct wp : wordPuncts) {
            if (wp instanceof Word) {
                output = output.concat(" ");
            }
            output = output.concat(wp.join());
        }

        return output.substring(1);
    }
}