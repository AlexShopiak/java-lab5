package lexeme;

import java.util.ArrayList;

public class Text{
    private ArrayList<Sentence> sentences;
    private boolean isEmpty = true;

    public Text(String input) {
        sentences = new ArrayList<>();
        if (input.length() > 0) {
            parse(input);
            isEmpty = false;
        }
    }
    public Word create() {
        return new Word("aboba");
    }

    public String get() {
        if (isEmpty) {
            return "";
        } else {
            return join();
        }
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    private void parse(String input) {
        String[] arr = input.split("(?<=[.!?])\\s");

        for (String elem : arr) {
            sentences.add(new Sentence(elem));
        }
    }

    private String join() {
        String output = "";

        for (Sentence sent : sentences) {
            output = output.concat(" ");
            output = output.concat(sent.join());
        }

        return output.substring(1);
    }
}