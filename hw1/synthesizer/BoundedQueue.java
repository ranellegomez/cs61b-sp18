package synthesizer;

public interface BoundedQueue<T> {
    /** Returns the number of items I can hold. */
    int capacity();

    /** Returns the number of items I currently hold. */
    int fillCount();

    /** Adds an item x to my items. */
    void enqueue(T x);

    /** Deletes and returns the item from the front. */
    T dequeue();

    /** Deletes and returns the item from the back. */
    T peek();

    /** Returns whether this is empty. */
    default boolean isEmpty() {
        return true;
    }

    /** Returns whether this is full. */
    default boolean isFull() {
        return false;
    }
}
