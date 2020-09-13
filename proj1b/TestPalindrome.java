import org.junit.Test;

import static org.junit.Assert.*;


public class TestPalindrome {

    static Palindrome palindrome = new Palindrome();
    static OffByOne offOne = new OffByOne();
    static OffByN offFive = new OffByN(5);

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);

        Deque x = palindrome.wordToDeque("hello world");
        String actual1 = "";
        for (int i = 0; i < "hello world".length(); i++) {
            actual1 += x.removeFirst();
        }
        assertEquals("hello world", actual1);
    }

    @Test
    public void testIsPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("Racecar"));
        assertTrue(palindrome.isPalindrome("racecar"));
    }

    @Test
    public void testIsPalindromeComp() {
        assertTrue(palindrome.isPalindrome("ab", offOne));
        assertFalse(palindrome.isPalindrome("an", offOne));
        assertFalse(palindrome.isPalindrome("ac", offOne));
        assertTrue(palindrome.isPalindrome("detrude", offOne));

        assertTrue(palindrome.isPalindrome("binding", offFive));
    }
}
