import org.junit.Test;
import static org.junit.Assert.*;


public class TestPalindrome {

    static Palindrome palindrome = new Palindrome();
    static OffByOne off = new OffByOne();

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
        assertTrue(palindrome.isPalindrome("ab", off));
        assertFalse(palindrome.isPalindrome("an", off));
        assertFalse(palindrome.isPalindrome("ac", off));
    }
}
