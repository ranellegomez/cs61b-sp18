public interface Deque<T> {

    /** Adds an item to the front of the deque. */
    void addFirst(T item);

    /** Adds an item to the back of the deque. */
    void addLast(T item);

    /** Returns true if empty; false otherwise. */
    boolean isEmpty();


    /** Returns the number of items in this deque. */
    int size();

    /** Prints each item of this deque line-by-line starting with the first
     * element.
     * */
    void printDeque();


    /** Removes and returns the first item of this deque. */
    T removeFirst();


    /** Removes and returns the last item of this deque. */
    T removeLast();


    /** Returns the ith item of this deque. */
    T get(int i);
}

