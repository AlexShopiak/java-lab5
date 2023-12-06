package lexeme;

import java.util.ArrayList;

class Word implements WordPunct{
    private ArrayList<Letter> letters;

    Word(String input) {
        letters = new ArrayList<>();
        parse(input);
    }

    void parse(String input) {
        String[] list = input.split("");
        for (String elem : list) {
            letters.add(new Letter(elem));
        }
    }

    @Override
    public String join() {
        String output = "";

        for (Letter letter : letters) {
            output = output.concat(letter.join());
        }
        return output;
    }
}