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
    int _nextLast = 1;

    public ArrayDeque() {
        _items = (T[]) new Object[8];
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T o) {
        if (size() == _items.length) {
            resize(2 * _items.length);
        }
        _items[_nextFirst--] = o;
        _nextFirst = (_nextFirst < 0) ? _items.length - 1 : _nextFirst;
        _size += 1;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T o) {
        if (size() == _items.length) {
            resize(2 * _items.length);
        }
        _items[_nextLast++] = o;
        _nextLast = (_nextLast == _items.length) ? 0 : _nextLast;
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
        T oldFirst = _items[_nextFirst + 1];
        if (isEmpty()) {
            return null;
        } else if (size() <= _items.length / 4) {
            _items[modulo(_nextFirst + 1)] = null;
            _nextFirst = modulo(_nextFirst + 1);
            resize(_items.length / 4);
            _nextFirst = _items.length - 1;
            _size -= 1;
            return oldFirst;
        }
        T removedFirst = _items[modulo(_nextFirst + 1)];
        _items[modulo(_nextFirst + 1)] = null;
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
        } else if (size() <= _items.length / 4) {
            T oldLast = _items[modulo(_nextLast - 1)];
            _items[modulo(_nextLast - 1)] = null;
            _nextLast = modulo(_nextLast - 1);
            _size -= 1;
            resize(_items.length / 4);
            return oldLast;
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
        if (index >= _size || index < 0) {
            return null;
        } else {
            return _items[modulo(_nextFirst + 1 + index)];
        }
    }

    /** Resizes the array when it is full.
     */
    public void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i < size(); i += 1) {
            temp[i] = _items[(_nextFirst + 1 + i) % _items.length];
        }
        _items = temp;
        _nextFirst = 0;
        _nextLast = size();
    }

    /** Return the value of P modulo the size. */
    final int modulo(int p) {
        if (_size == 0) {
            return p;
        }
        int r = p % _items.length;
        if (r < 0) {
            r += _items.length;
        }
        return r;
    }
}