package ua.com.foxminded.anagrams;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.StringJoiner;


/**
 * This class makes an anagram
 *
 * @author Maksim.Kalitsev
 */
public class Anagram {

    private static final String SPACE_DELIMITER = " ";

    /**
     * This method splits the string into words and reverses each word separately
     *
     * @param sentence something string
     * @return result of reverses
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public String makeAnagram(String sentence) {
        validateSentence(sentence);

        String[] words = sentence.split(SPACE_DELIMITER, sentence.length());
        StringJoiner result = new StringJoiner(SPACE_DELIMITER);

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

    /**
     * This method turns a string into characters and swaps without symbols
     *
     * @param word something string
     * @return new string
     */
    private String reversedWord(String word) {
        char[] result = word.toCharArray();
        int i = 0;
        int j = result.length - 1;
        char temp;

        while (i < j) {
            if (Character.isLetter(result[i]) && Character.isLetter(result[j])) {
                temp = result[i];
                result[i] = result[j];
                result[j] = temp;
                i++;
                j--;
            } else if (!Character.isLetter(result[i]) && Character.isLetter(result[j])) {
                i++;
            } else if (Character.isLetter(result[i]) && !Character.isLetter(result[j])) {
                j--;
            } else {
                i++;
                j--;
            }
        }
        return new String(result);
    }
}