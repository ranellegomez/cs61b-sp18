package synthesizer;

public abstract class AbstractBoundedQueue implements BoundedQueue {
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
