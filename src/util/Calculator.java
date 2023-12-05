package util;

import java.util.TreeSet;
import java.util.Set;
import java.util.Arrays;

public class Calculator {
    public static String calculate(String text) {
        //Extract words from text
        String clearText = text.replaceAll("[.,!?:;-]", "");
        String[] words = clearText.split("\\s+");

        //Remove doublicates
        Set<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        set.addAll(Arrays.asList(words));

        //Sort
        String[] order = set.toArray(new String[0]);
        Arrays.sort(order, String.CASE_INSENSITIVE_ORDER);

        //Join
        String line = String.join(" ", order);
        
        return line;
    }
}
