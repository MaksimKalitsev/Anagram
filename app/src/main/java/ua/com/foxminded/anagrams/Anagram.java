package ua.com.foxminded.anagrams;

import android.os.Build;

import androidx.annotation.RequiresApi;


import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;


public class Anagram {

    private static final String SPACE_DELIMITER = " ";

    private Set<Character> ignoredSymbols;

    private static Set<Character> stringToSet(String ignoreSymbols) {
        Set<Character> ignore = new HashSet<>();
        for (char symbol : ignoreSymbols.toCharArray()) {
            ignore.add(symbol);
        }
        return ignore;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String makeAnagram(String sentence, String ignoreString) {
        validateSentence(sentence);

        String[] words = sentence.split(SPACE_DELIMITER, sentence.length());
        StringJoiner result = new StringJoiner(SPACE_DELIMITER);
        ignoredSymbols = stringToSet(ignoreString);

        for (String part : words) {
            result.add(reversedWord(part));
        }
        return result.toString();
    }

    private void validateSentence(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("sentence is null");
        }
    }

    private boolean shouldBeProcessed(char symbol) {
        if (ignoredSymbols.isEmpty()) {
            return Character.isLetter(symbol);
        } else {
            return !ignoredSymbols.contains(symbol);
        }
    }

    private String reversedWord(String word) {
        char[] result = word.toCharArray();
        int i = 0;
        int j = result.length - 1;
        char temp;

        while (i < j) {
            if (shouldBeProcessed(result[i]) && shouldBeProcessed(result[j])) {
                temp = result[i];
                result[i] = result[j];
                result[j] = temp;
                i++;
                j--;
            } else if (!shouldBeProcessed(result[i]) && shouldBeProcessed(result[j])) {
                i++;
            } else if (shouldBeProcessed(result[i]) && !shouldBeProcessed(result[j])) {
                j--;
            } else {
                i++;
                j--;
            }
        }
        return new String(result);
    }
}