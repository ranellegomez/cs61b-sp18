import java.util.ArrayDeque;
import java.util.Deque;

public class Palindrome {

    /** Takes a word and returns a deque with all the chars in that word. */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new ArrayDeque<Character>();

        for (int i = 0; i < word.length(); i++) {
            result.add(word.charAt(i));
        }
        return result;
    }
}
