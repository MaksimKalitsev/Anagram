package ua.com.foxminded.anagrams;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;


public class StringUtilsTest {

    @Test
    public void testOnlyLetters() {
        assertEquals("abcd efgh", StringUtils.makeAnagram("dcba hgfe", ""));
    }

    @Test
    public void testLettersAndSymbols() {
        assertEquals("a1bcd efg!h", StringUtils.makeAnagram("d1cba hgf!e", ""));
    }

    @Test
    public void testOnlyLettersWithFilter() {
        assertEquals("abcd efgh", StringUtils.makeAnagram("dcba hgfe", "xl"));
    }

    @Test
    public void testLettersAndSymbolsWithFilter() {
        assertEquals("Foxminded cool 24/7", StringUtils.makeAnagram("dexdnimoF oocl 7/42", "xl"));
    }
}