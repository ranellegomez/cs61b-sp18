package synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    /** Returns the number of items I can hold. */
    protected int _capacity;

    /** Returns the number of items I currently hold. */
    protected int _fillCount;

    /** Returns the number of items I can hold. */
    public int capacity() {
        return _capacity;
    }

    /** Returns the number of items I currently hold. */
    public int fillCount() {
        return _fillCount;
    }
}
