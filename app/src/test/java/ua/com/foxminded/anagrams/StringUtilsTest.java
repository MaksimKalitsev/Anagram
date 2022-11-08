package ua.com.foxminded.anagrams;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;


public class StringUtilsTest {

    @Test
    public void testOnlyLetters() {
        assertEquals("dcba hgfe", StringUtils.makeAnagram("abcd efgh", ""));
    }

    @Test
    public void testLettersAndSymbols() {
        assertEquals("d1cba hgf!e", StringUtils.makeAnagram("a1bcd efg!h", ""));
    }

    @Test
    public void testOnlyLettersWithFilter() {
        assertEquals("dcba hgfe", StringUtils.makeAnagram("abcd efgh", "xl"));
    }

    @Test
    public void testLettersAndSymbolsWithFilter() {
        assertEquals("dexdnimoF oocl 7/42", StringUtils.makeAnagram("Foxminded cool 24/7", "xl"));
    }

    @Test
    public void testEmptyString() {
        assertEquals("", StringUtils.makeAnagram("", ""));
    }

    @Test
    public void testEmptyStringWithFilter() {
        assertEquals("", StringUtils.makeAnagram("", "xl"));
    }

    @Test
    public void testMultiLine() {
        assertEquals("qwerty\nasdfgh", StringUtils.makeAnagram("ytrewq\nhgfdsa", ""));
    }
}