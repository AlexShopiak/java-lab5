/*
 * TextMaster
 *
 * Version 1.0
 *
 * (c) 2023 Oleksii Shopiak
 * All rights reserved.
 *
 * TextMaster is class that has a Text object, do String/Text converting 
 * and provide us with methods for changing the text
 */
package lexeme;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Comparator;

public class TextMaster{
    Text text;

    public TextMaster(String input) {    
        text = new Text(input);
    }

    public void turnTextToWords() {
        ArrayList<WordPunct> words = new ArrayList<>();
        ArrayList<Sentence> sentences = text.get();

        for (Sentence sent : sentences) {
            removePuncts(sent);
            words.addAll(sent.get());
        }
        
        Sentence single = new Sentence("");
        single.set(words);

        sentences.clear();
        sentences.add(single);
    }

    public void unifyWordsInSentences() {
        ArrayList<Sentence> sentences = text.get();

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

    public void sortWordsByAlphabet() {
        ArrayList<Sentence> sentences = text.get();

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
        return text.join();
    }


    private boolean containsCaseIgn(ArrayList<String> list, String item) {
        return list.stream().anyMatch(element -> element.equalsIgnoreCase(item));
    }

    private void removePuncts(Sentence sent) {
        ArrayList<WordPunct> wordPuncts = sent.get();
        Iterator<WordPunct> iterator = wordPuncts.iterator();

        while (iterator.hasNext()) {
            WordPunct wp = iterator.next();
            if (wp instanceof Punctuation) {
                iterator.remove();
            }
        }
    }
}
