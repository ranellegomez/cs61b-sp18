public class OffByN implements CharacterComparator {

    /**
     * This OffByN's unique number that represents how many characters away
     * from two characters can be from one another.
     */
    private final int _n;

    /**
     * This OffByN's constructor which binds _n to the user-inputted int N.
     */
    public OffByN(int n) {
        _n = n;
    }

    @Override
    /** Returns whether x and y are off by one. */
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == _n;
    }
}
