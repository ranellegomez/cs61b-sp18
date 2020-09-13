public class OffByOne implements CharacterComparator {

    @Override
    /** Returns whether x and y are off by one. */
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 1;
    }
}
