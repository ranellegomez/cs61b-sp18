import java.lang.reflect.Array;
import java.util.Arrays;

/** (C) 2020 Ranelle Gomez */

public class ArrayDeque<T> {
    /** The array containing the items of this ArrayDeque. */
    T [] _items;

    /** The size of this. */
    int _size;

    /** The index of where the first item is to be inserted when addFirst is
     called. */
    int _nextFirst = 0;

    /** The index of where the last item is to be inserted when nextLast is
     called. */
    int _nextLast = 1;

    public ArrayDeque() {
        _items = (T[]) new Object[8];
        _size = 0;
    }

    /** Adds an item of type T to the front of the deque.
     * STACK!!!!!!!!! */
    public void addFirst(T o) {
        if (_size == _items.length) {
            resize(getSize() * 2);
        }
        if (_items[0] != null && _nextFirst == 0) {
            _nextFirst = _items.length - 1;
        }
        _items[_nextFirst--] = o;
        _size += 1;
    }

    /** Adds an item of type T to the back of the deque.
     * QUEUE!!!!!!! AKA: ENQUEUE. UPDATED. */
    public void addLast(T o) {
        if (getSize() == _items.length) {
            resize(getSize() * 2);
        }
        if (_items[0] != null && _nextLast == 0) {
            _nextLast += 1;
        }
        _items[_nextLast++] = o;
        _size += 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return _size == 0;
    }

    /** Returns the number of items in the deque. */
    public int getSize() {
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
     * AKA Dequeue. UPDATED.
     */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (_nextFirst == _items.length - 1) {
            _nextFirst = 0;
        } else {
            _nextFirst += 1;
        }
        T removedFirst = _items[_nextFirst];
        _items[_nextFirst] = null;
        if (getSize() > 0 && getSize() == _items.length / 4) {
            resize(_items.length / 4);
        }
        _size -= 1;
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
        _size -= 1;
        _items[--_nextLast] = null;
        if (getSize() == _items.length / 2) {
            resize(_items.length / 2); //FIXME. Need to fix lengths.
        }
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
            return _items[index];
        }
    }

    /** Resizes the array when it is full.
     */
    public void resize(int newSize) {
        assert newSize > getSize();
        T[] newItems = (T[]) new Object[(newSize)];
        for (int i = 1; i < _items.length; i += 1) {
            newItems[i - 1] = _items[(_nextFirst + i) % _items.length];
        }
        _items = newItems;
        _nextFirst = newItems.length - 1;
        _nextLast = getSize();
    }
}