import java.lang.reflect.Array;
import java.util.Arrays;

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
    int _nextLast = modulo(_nextFirst + 1);

    public ArrayDeque() {
        _items = (T[]) new Object[8];
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T o) {
        if (_size == 0 || Arrays.asList(_items).contains(null)) {
            _items[modulo(_nextFirst)] = o;
            _size += 1;
            _nextFirst = modulo(_nextFirst - 1);
        } else {
            T[] oldItems = _items.clone();
            System.arraycopy(oldItems, 0, _items, 1, oldItems.length - 1);
            _items[0] = o;
            _size += 1;
            _nextFirst = _size - 1;
            _nextLast += 1;
        }

    }

    /** Gets the last index and updates it.
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
     } */

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T o) {

        if (_size == 0 || Arrays.asList(_items).contains(null)) {
            _items[modulo(_nextLast)] = o;
            _size += 1;
            _nextLast = modulo(_nextLast + 1);
        } else {
            T[] oldItems = _items.clone();
            System.arraycopy(oldItems, 0, _items, 0, oldItems.length);
            _items[oldItems.length] = o;
            _size += 1;
            _nextLast += 1;
        }

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
        for (int i = _nextFirst; i < _size; i += 1) {
            if (_items[i] != null) {
                System.out.println(_items[i]);
            }
        }
        for (int j = 0; j < _nextFirst; j += 1) {
            if (_items[j] != null) {
                System.out.println(_items[j]);
            }
        }

    }

    /** Removes and returns the item at the front of the deque. If no such
     * item exists, returns null.
     */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T removedFirst = _items[_nextFirst + 1];
        _items[_nextFirst + 1] = null;
        _size -= 1;
        _nextFirst = modulo(_nextFirst + 1);
        return removedFirst;
    }

    /** Removes and returns the item at the back of the deque. If no such
     * item exists, returns null.
     */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T removedLast = _items[_nextLast - 1];
        _items[_nextLast - 1] = null;
        _size -= 1;
        _nextLast = modulo(_nextLast - 1);
        return removedLast;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next
     * item, and so forth. If no such item exists, returns null. Must not alter
     * the deque!
     */
    public T get(int index) {
        if (index >= _size) {
            return null;
        } else {
            return _items[modulo(_nextFirst + 1 + index)];
        }
    }

    /** Resizes the array when it is full.
     */
    public void resize() {
        _items = (T[]) new Object[(_size + 1) * 4];
    }

    /** Return the value of P modulo the size. */
    final int modulo(int p) {
        if (_size == 0) {
            return _nextFirst + 1;
        }
        int r = p % _items.length;
        if (r < 0) {
            r += _items.length;
        }
        return r;
    }
}