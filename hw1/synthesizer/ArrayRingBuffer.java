package synthesizer;// TODO: Make sure to make this class a part of the synthesizer package

import java.lang.reflect.Type;
import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
// Compile Me. javac BoundedQueue.java AbstractBoundedQueue.java
// ArrayRingBuffer.java
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {

    /** Index for the next dequeue or peek. */
    private int _first;

    /** Index for the next enqueue. */
    private int _last;

    /** The number of items stored in me.
    private int _fillCount; */

    /** Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int c) {
        _first = 0;
        _last = 0;
        fillCount = 0;
        capacity = c;
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow.");
        }
        rb[_last++] = x;
        if (_last == rb.length) {
            _last = 0;
        }
        fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow.");
        }
        T oldFirst = rb[_first++];
        if (_first == rb.length) {
            _first = 0;
        }
        fillCount--;
        return oldFirst;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow.");
        }
        return rb[_first];
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < fillCount;
            }

            @Override
            public T next() {
                int nextIndex = (currentIndex + _first) % capacity;
                T result = rb[nextIndex];
                currentIndex++;
                return result;
            }
        };
        return it;
    }
}

