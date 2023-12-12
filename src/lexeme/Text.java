/*
 * Text
 *
 * Version 1.0
 *
 * (c) 2023 Oleksii Shopiak
 * All rights reserved.
 *
 * Text class has an array of sentences
 */
package lexeme;

import java.util.ArrayList;
import java.util.Iterator;

class Text{
    private ArrayList<Sentence> sentences = new ArrayList<>();

    Text(String input) {    
        if (input.length() > 0) {
            parse(input);
        }
    }

    ArrayList<Sentence> get() {
        return sentences;
    }

    String join() {
        String output = "";

        for (Sentence sent : sentences) {
            output += " ";
            output += sent.join();
        }

        if (output.length() > 0) {
            output = output.substring(1);
        }

        return output;
    }

    private void parse(String input) {
        String[] arr = input.split("(?<=[.!?])\\s");

        for (String elem : arr) {
            sentences.add(new Sentence(elem));
        }
    }
}


/*
 * Sentence class has an array of words and punctuation marks
 */
class Sentence{
    private ArrayList<WordPunct> wordPuncts = new ArrayList<>();

    Sentence(String input) {
        parse(input);
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
            output = output.substring(1);
        }

        return output;
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


/* 
 * WordPunct interface descripes Word and Punctuation classes
 */
interface WordPunct {
    String join();
}


/*
 * Punctuation class describes one punctuation mark
 */
class Punctuation implements WordPunct{
    private String mark;

    Punctuation(String input) {
        this.mark = input;
    }

    @Override
    public String join() {
        return mark;
    }
}


/*
 * Word class has an array of letters
 */
class Word implements WordPunct{
    private ArrayList<Letter> letters;

    Word(String input) {
        letters = new ArrayList<>();
        parse(input);
    }

    @Override
    public String join() {
        String output = "";

        for (Letter letter : letters) {
            output = output.concat(letter.join());
        }
        return output;
    }

    private void parse(String input) {
        String[] list = input.split("");
        for (String elem : list) {
            letters.add(new Letter(elem));
        }
    }
}


/*
 * Letter class describes one letter
 */
class Letter {
    private String letter;

    Letter(String input) {
        this.letter = input;
    }

    String join() {
        return letter;
    }
}
