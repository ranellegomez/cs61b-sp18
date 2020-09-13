
/** @Source: https://www.javatpoint.com/how-to-reverse-string-in-java */
public class Palindrome {

    /** Takes a word and returns a deque with all the chars in that word. */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            result.addLast(word.charAt(i));
        }
        return result;
    }

    /** Takes a word and returns true if it a palindrome; false otherwise. */
    public Boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        StringBuilder reverse = new StringBuilder(word).reverse();
        return word.equals(reverse.toString());
    }

    public Boolean isPalindrome(String s, CharacterComparator comp) {
        String revS = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < s.length(); i++) {
            if (!comp.equalChars(s.charAt(i), revS.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
