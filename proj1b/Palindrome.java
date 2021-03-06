/**
 * (C) 2020 Ranelle Gomez
 * @Source: https://www.javatpoint.com/how-to-reverse-string-in-java
 */
public class Palindrome {

    /**
     * Takes a String WORD and returns a deque with all the chars in that
     * word.
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            result.addLast(word.charAt(i));
        }
        return result;
    }

    /**
     * Takes a word and returns true if it a palindrome; false otherwise.
     */
    public boolean isPalindrome(String word) {
        if (word == null) {
            /** Unsure about this. Need to verify. */
            return false;
        }
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        StringBuilder reverse = new StringBuilder(word).reverse();
        return word.equals(reverse.toString());
    }

    /**
     * Given a comparator COMP and a String S, returns true if this is a
     * palindrome according to comp; false otherwise.
     */
    public boolean isPalindrome(String s, CharacterComparator comp) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        String revS = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < s.length(); i++) {
            if (!comp.equalChars(s.charAt(i), revS.charAt(i))
                    && i != Math.floorDiv(s.length(), 2)) {
                return false;
            }
        }
        return true;
    }
}
