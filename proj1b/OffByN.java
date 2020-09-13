public class OffByN implements CharacterComparator {
    private int _n;

    public OffByN(int n) {
        _n = n;
    }

    @Override
    /** Returns whether x and y are off by one. */
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == _n;
    }
}
