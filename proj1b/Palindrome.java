import java.util.ArrayDeque;
import java.util.Deque;

/** @Source: https://www.javatpoint.com/how-to-reverse-string-in-java */
public class Palindrome {

    /** Takes a word and returns a deque with all the chars in that word. */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            result.add(word.charAt(i));
        }
        return result;
    }

    /** Takes a word and returns true if it a polindrome; false otherwise. */
    public Boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }
        if (word.length() == 0) {
            return false;
        }
        StringBuilder reverse = new StringBuilder(word).reverse();
        return word.equals(reverse.toString());
    }
}
