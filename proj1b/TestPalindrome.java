import org.junit.Test;

import java.util.Deque;

import static org.junit.Assert.*;

public class TestPalindrome {

    static Palindrome palindrome = new Palindrome();
    static OffByOne off = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque<Character> d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("Racecar"));
        assertTrue(palindrome.isPalindrome("racecar"));
    }

    @Test
    public void testIsPalindromeComp() {
        assertTrue(palindrome.isPalindrome("ab", off));
        assertFalse(palindrome.isPalindrome("an", off));
        assertFalse(palindrome.isPalindrome("ac", off));
    }
}
