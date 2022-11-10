package ua.com.foxminded.anagrams;

import java.util.HashSet;
import java.util.Set;


final public class StringUtils {
    private StringUtils() {
    }

    public static String makeAnagram(String sentence, String ignoreString) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }
        final String SPACE_DELIMITER = " ";
        String[] lines = sentence.split("\n");
        StringBuilder result = new StringBuilder();
        Set<Character> ignoredSymbols = stringToSet(ignoreString);
        for (String line : lines) {
            String[] words = line.split(SPACE_DELIMITER, sentence.length());
            for (String part : words) {
                result.append(reversedWord(part, ignoredSymbols)).append(SPACE_DELIMITER);
            }
            result.deleteCharAt(result.length()-1).append("\n");
        }
        return result.toString().trim();
    }

    private static Set<Character> stringToSet(String ignoreSymbols) {
        Set<Character> ignore = new HashSet<>();
        for (char symbol : ignoreSymbols.toCharArray()) {
            ignore.add(symbol);
        }
        return ignore;
    }

    private static boolean shouldBeProcessed(char symbol, Set<Character> ignoredSymbols) {
        if (ignoredSymbols.isEmpty()) {
            return Character.isLetter(symbol);
        } else {
            return !ignoredSymbols.contains(symbol);
        }
    }

    private static String reversedWord(String word, Set<Character> ignored) {
        char[] result = word.toCharArray();
        int i = 0;
        int j = result.length - 1;
        char temp;

        while (i < j) {
            if (!shouldBeProcessed(result[i], ignored)) {
                i++;
            } else if (!shouldBeProcessed(result[j], ignored)) {
                j--;
            } else {
                temp = result[i];
                result[i] = result[j];
                result[j] = temp;
                i++;
                j--;
            }
        }
        return new String(result);
    }
}