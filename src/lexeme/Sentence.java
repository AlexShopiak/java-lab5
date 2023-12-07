package lexeme;

import java.util.ArrayList;
import java.util.Iterator;

class Sentence{
    private ArrayList<WordPunct> wordPuncts;

    Sentence(String input) {
        wordPuncts = new ArrayList<>();
        parse(input);
    }

    void removePuncts() {
        Iterator<WordPunct> iterator = wordPuncts.iterator();
        while (iterator.hasNext()) {
            WordPunct wp = iterator.next();
            if (wp instanceof Punctuation) {
                iterator.remove();
            }
        }
    }

    void set(ArrayList<WordPunct> sent) {
        wordPuncts = sent;
    }

    ArrayList<WordPunct> get() {
        return wordPuncts;
    }

    String join() {
        String output = "";

        for (WordPunct wp : wordPuncts) {
            if (wp instanceof Word) {
                output = output.concat(" ");
            }
            output = output.concat(wp.join());
        }

        if (output.length() > 0) {
            return output.substring(1);
        } else {
            return output;
        }
    }

    private void parse(String input) {
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
}