public class ArrayDeque<T> {
    /** The array containing the items of this ArrayDeque. */
    T [] _items;

    /** The size of this. */
    private int _size;

    /** The index of where the first item is to be inserted when addFirst is
     called. */
    private int _nextFirst;

    /** The index of where the last item is to be inserted when nextLast is
     called. */
    private int _nextLast;

    public ArrayDeque() {
        _items = (T[]) new Object[8];
        _size = 0;
        _nextFirst = 0;
        _nextLast = 1;
    }

    /** Returns whether _items is full. */
    private boolean isFull() {
        return _size == _items.length;
    }

    /** Decrement the index of the inputted integer k. */
    private int decrementIndex(int k) {
        return modulo(k - 1);
    }

    /** Increment the index of the inputted integer l. */
    private int incrementIndex(int l) {
        return modulo(l + 1);
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T o) {
        if (isFull()) {
            resize(2 * _items.length);
        }
        _items[_nextFirst] = o;
        _nextFirst = decrementIndex(_nextFirst);
        _size += 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return _size == 0;
    }

    /** Returns whether our usage factor < 25% and items.length >= 16. */
    private boolean isDownsizable() {
        return (_items.length >= 16) && ((size()/_items.length) > 0.25);
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return _size;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T o) {
        if (size() == _items.length) {
            resize(2 * _items.length);
        }
        _items[_nextLast] = o;
        _nextLast = incrementIndex(_nextLast);
        _size += 1;
    }


    /** Prints the items in the deque from first to last, separated by a
     * space. */ //FIXME
    public void printDeque() {
        for (int i = _nextFirst + 1; i < _items.length; i += 1) {
            if (_items[i] != null) {
                System.out.println(_items[i]);
            }
        }
        for (int j = 0; j < _nextFirst + 1; j += 1) {
            if (_items[j] != null) {
                System.out.println(_items[j]);
            }
        }

    }

    /** Removes and returns the item at the front of the deque. If no such
     * item exists, returns null.
     */
    public T removeFirst() {
        if (isDownsizable()) {
            resize(_items.length / 2);
        }
        _nextFirst = incrementIndex(_nextFirst);
        T oldFirst = _items[_nextFirst];
        _items[_nextFirst] = null;
        _size = (isEmpty()) ? _size : _size - 1;
        return oldFirst;
    }

    /** Removes and returns the item at the back of the deque. If no such
     * item exists, returns null.
     */
    public T removeLast() {
        if (isDownsizable()) {
            resize(_items.length / 2);
        }
        _nextLast = decrementIndex(_nextLast);
        T oldLast = _items[_nextLast];
        _items[_nextLast] = null;
        _size = (isEmpty()) ? _size : _size - 1;
        return oldLast;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next
     * item, and so forth. If no such item exists, returns null. Must not alter
     * the deque!
     */
    public T get(int index) {
        T result;
        int k = modulo(_nextFirst + 1);

        for (int i = 0; i < index; i++) {
            k = modulo(k + i);
        }
        result = _items[k];
        return result;
    }

    /** Resizes the array when it is full.
     */
    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        int j = 0;

        for (int i = modulo(_nextFirst + 1); i != _nextLast; i = modulo(i + 1)) {
            temp[j++] = _items[i];
        }
        _items = temp;
        _nextFirst = _items.length - 1;
        _nextLast = size();
    }

    /** Return the value of P modulo the size. */
    private int modulo(int p) {
        return (p < 0) ? ((p + _items.length) % _items.length) :
                (p % _items.length);
    }
}
