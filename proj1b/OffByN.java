public class OffByN implements CharacterComparator {
    private int N;

    OffByN(int n) {
        this.N = n;
    }

    @Override
    /** Returns whether x and y are off by one. */
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == this.N;
    }
}
