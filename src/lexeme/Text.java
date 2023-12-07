package lexeme;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Comparator;

public class Text{
    private ArrayList<Sentence> sentences;

    public Text(String input) {
        sentences = new ArrayList<>();
        if (input.length() > 0) {
            parse(input);
        }
    }
    //-----------Public-------------------------------//
    public void toWords() {
        ArrayList<WordPunct> words = new ArrayList<>();

        for (Sentence sent : sentences) {
            sent.removePuncts();
            words.addAll(sent.get());
        }
        
        Sentence single = new Sentence("");
        single.set(words);

        sentences.clear();
        sentences.add(single);
    }

    public void unifyWords() {
        for (Sentence sent : sentences) {
            Iterator<WordPunct> iterator = sent.get().iterator();
            ArrayList<String> uniqueWords = new ArrayList<>();

            while (iterator.hasNext()) {
                WordPunct word = iterator.next();
                if (containsCaseIgn(uniqueWords, word.join())) {
                    iterator.remove();
                } else {
                    uniqueWords.add(word.join());
                }
            }
        }
    }

    public void sortWords() {
        for (Sentence sent : sentences) {
            if (sent.get().size() > 1) {
                sent.get().sort(new Comparator<WordPunct>() {
                    @Override
                    public int compare(WordPunct word1, WordPunct word2) {
                        return word1.join().compareToIgnoreCase(word2.join());
                    }
                });
            }
        }
    }

    public String getString() {
        if (sentences.size() == 0) {
            return "";
        } else {
            return join();
        }
    }
    //----------Private-------------------------------//
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

        if (output.length() > 0) {
            return output.substring(1);
        } else {
            return output;
        }
    }

    private boolean containsCaseIgn(ArrayList<String> list, String item) {
        return list.stream().anyMatch(element -> element.equalsIgnoreCase(item));
    }
}
