package synthesizer;
import java.util.Iterator;

public interface BoundedQueue<T> extends Iterable<T> {
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
        return fillCount() == 0;
    }

    /** Returns whether this is full. */
    default boolean isFull() {
        return fillCount() == capacity();
    }
    

}
