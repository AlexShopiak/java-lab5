package lexeme;

import java.util.ArrayList;
import java.util.Iterator;

public class Text{
    private ArrayList<Sentence> sentences;

    public Text(String input) {
        sentences = new ArrayList<>();
        if (input.length() > 0) {
            parse(input);
        }
    }

    public void toUniqueWords() {
        ArrayList<WordPunct> words = new ArrayList<>();

        for (Sentence sent : sentences) {
            sent.removePuncts();
            words.addAll(sent.get());
        }

        Iterator<WordPunct> iterator = words.iterator();
        ArrayList<String> uniqueWords = new ArrayList<>();

        while (iterator.hasNext()) {
            WordPunct word = iterator.next();
            if (uniqueWords.contains(word.join())) {
                iterator.remove();
            } else {
                uniqueWords.add(word.join());
            }
        }
        
        Sentence single = new Sentence("");
        single.setSentence(words);

        sentences.clear();
        sentences.add(single);
    }

    public void sortWords() {
        //todo
    }

    public String getString() {
        if (sentences.size() == 0) {
            return "";
        } else {
            return join();
        }
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
            output += " ";
            output += sent.join();
        }

        return output.substring(1);
    }
}