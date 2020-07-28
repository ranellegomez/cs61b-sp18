package synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    /** Returns the number of items I can hold. */
    protected int capacity;

    /** Returns the number of items I currently hold. */
    protected int fillCount;

    /** Returns the number of items I can hold. */
    public int capacity() {
        return capacity;
    }

    /** Returns the number of items I currently hold. */
    public int fillCount() {
        return fillCount;
    }
}
