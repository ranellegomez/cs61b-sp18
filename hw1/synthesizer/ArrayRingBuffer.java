package synthesizer;// TODO: Make sure to make this class a part of the synthesizer package

import java.lang.reflect.Type;
import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
// Compile Me. javac BoundedQueue.java AbstractBoundedQueue.java
// ArrayRingBuffer.java
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> implements Iterable<T> {

    /* Index for the next dequeue or peek. */
    private int _first;            // index for the next dequeue or peek

    /* Index for the next enqueue. */
    private int _last;

    /** The number of items stored in me. */
    private int _fillCount;

    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        _first = 0;
        _last = 0;
        _fillCount = 0;
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
    }

    /** Returns whether I am empty. */
    public boolean isEmpty() {
        return _fillCount == 0;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (_last == _first) {
            throw new RuntimeException("Ring buffer overflow.");
        }
        rb[_last++] = x;
        if (_last == rb.length) {
            _last = 0;
        }
        _fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow.");
        }
        T oldFirst = rb[_first++];
        if (_first == rb.length) {
            _first = 0;
        }
        _fillCount--;
        return oldFirst;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        return rb[_first];
        // TODO: Return the first item. None of your instance variables should change.
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < _capacity && rb[currentIndex] != null;
            }

            @Override
            public T next() {
                return rb[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
    // TODO: When you get to part 5, implement the needed code to support iteration.
}

