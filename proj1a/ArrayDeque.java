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
        if (isEmpty()) {
            return null;
        } else {
            int actualFirst = (_nextFirst + 1 == _items.length) ? getLastAddedBeforeResize() :
                    (_nextFirst + 1);
            T oldFirst = _items[actualFirst];
            _items[actualFirst] = null;
            _size -= 1;
            _nextFirst = (_nextFirst + 1 == _items.length) ? getLastAddedBeforeResize() : _nextFirst + 1;

            if (size() > 0 && size() <= _items.length / 4) {
                resize(_items.length / 2);
            }
            return oldFirst;
        }
    }

    /** Removes and returns the item at the back of the deque. If no such
     * item exists, returns null.
     */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        int actualLast = (_nextLast - 1 < 0) ? _items.length - 1 :
                _nextLast - 1;
        T oldLast = _items[actualLast];
        _items[actualLast] = null;
        _size -= 1;
        _nextLast = (_nextLast - 1 < 0) ? _items.length - 1 :
                _nextLast - 1;
        if (size() > 0 && size() <= _items.length / 4) {
            resize(_items.length / 2);
        }
        return oldLast;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next
     * item, and so forth. If no such item exists, returns null. Must not alter
     * the deque!
     */
    public T get(int index) {
        if (index >= _size || index < 0) {
            return null;
        } else {
            int actualFirst = (_nextFirst + 1 == _items.length) ? getLastAddedBeforeResize() :
                    _nextFirst + 1;
            int convertedIndex = (_nextFirst + 1 == _items.length) ?
                    actualFirst - index :
                    (actualFirst + index >= _items.length) ?
                            getLastAddedBeforeResize() - ((actualFirst + index) % _items.length) :
                    actualFirst + index;
            return _items[convertedIndex];
        }
    }

    /** Resizes the array when it is full.
     */
    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        int k = 0;
        for (int i = 0; i < size(); i += 1) {
            temp[modulo(-i)] =
                    (_nextFirst + i < _items.length) ?
                    _items[(_nextFirst + i)] : _items[k++];
        }
        _items = temp;
        _nextFirst = _items.length - 1; // FIXME. Try changing to size - 1
        _nextLast = size() + 1; // change to size if score decreases.
    }

    private int getLastAddedBeforeResize() {
        int result = 0;
        for (int i = 0; i < _items.length; i += 1) {
            if (_items[i] != null) {
                result = i;
            } else {
                return result;
            }
        }
        return result;
    }

    private int getActualFirst() {
        int result = 0;
        for (int i = 0; i < size(); i += 1) {
            if (_items[i] != null) {
                result += 1;
            }
        }
        result = modulo(_nextFirst + result);
        return result;
    }

    /** Return the value of P modulo LEN. */
    final int moduloLength(int p, int len) {
        if (_size == 0) {
            return p;
        }
        int r = p % len;
        if (r < 0) {
            r += len;
        }
        return r;
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