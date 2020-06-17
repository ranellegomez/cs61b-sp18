import java.lang.reflect.Array;

public class ArrayDeque<T> {
    /** The array containing the items of this ArrayDeque. */
    T [] _items;

    /** The size of this. */
    int _size = 0;

    /** The index of where the first item is to be inserted when addFirst is
     called. */
    int _nextFirst = 0;

    /** The index of where the last item is to be inserted when nextLast is
     called. */
    int _nextLast = 0;

    public ArrayDeque() {
        _items = (T[]) new Object[8];
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T o) {
        _items[_nextFirst++] = o;
        _size += 1;
        get_nextLast();
    }

    /** Gets the last index and updates it. */
    private int get_nextLast() {
        if ((_items[(_nextFirst + 1) % _size] == null)) {
            _nextLast = _nextFirst + 1;
        } else {
            for (int i = _nextFirst; i < _size; _size += 1) {
                if (_items[i] == null) {
                    _nextLast = i;
                }
            }
        }
        return _nextLast;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T o) {
        _items[_nextLast++ % _size] = o;
        _size += 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return _size == 0;
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return _size;
    }

    /** Prints the items in the deque from first to last, separated by a
     * space. */
    public void printDeque() {

    }

    /** Removes and returns the item at the front of the deque. If no such
     * item exists, returns null.
     */
    public T removeFirst() {
        return null;
    }

    /** Removes and returns the item at the back of the deque. If no such
     * item exists, returns null.
     */
    public T removeLast() {
        return null;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next
     * item, and so forth. If no such item exists, returns null. Must not alter
     * the deque!
     */
    public T get(int index) {
        return null;
    }

    /** Returns the item at the given index of me. */
    public T getRecursive(int index) {
        return null;
    }
}
