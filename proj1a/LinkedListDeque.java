/** A simple, native trainer. */
import java.util.ArrayDeque;

public class LinkedListDeque<T> {
    /** First element of list. */
    private IntNode _first;
    /** The size of this LinkedListDeque. */
    private int _size;

    /*public LinkedListDeque(T x) {
        _first = new IntNode(x, null, null);
    }
    */


    public LinkedListDeque() {
        _first = new IntNode(null, null, null);
        _first._prev = _first;
        _first._next = _first;
        _size = 0;
    }

    private class IntNode {
        /** Remaining elements of list. */
        public T _item;
        public IntNode _prev;
        public IntNode _next;

        /** A List with head HEAD0 and tail TAIL0. */
        private IntNode(T item, IntNode prev, IntNode next) {
            _item = item;
            _prev = prev;
            _next = next;
        }

        /** An IntNode with null previous, next, and item arguments. */
        public IntNode() {
            this (null, null, null);
        }

    }

        /** Adds an item of type T to the front of the deque. */
    public void addFirst(T o) {
        _first._next = new IntNode(o, _first, _first._next);
        _first._next._next._prev = _first._next;
        _size += 1;
    }

    /** Adds an item of type T to the back of the deque. */
     public void addLast(T o) {
         _first._prev._next = new IntNode(o, _first._prev, _first);
         _first._prev = _first._prev._next;
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
        IntNode ptr = _first._next;
        for (int i = 0; i < size(); i += 1) {
            System.out.println(ptr._item);
            ptr = ptr._next;
        }

    }

    /** Removes and returns the item at the front of the deque. If no such
     * item exists, returns null.
     */
    public T removeFirst() {
        IntNode removed = _first._next;
        if (_size == 0) { //removed == null
            return  null;
        } else {
            _first._next = _first._next._next;
            _first._next._prev = _first;
            //removed._prev._next = _first;
        }
        _size -= 1;
        return removed._item;
    }

    /** Removes and returns the item at the back of the deque. If no such
     * item exists, returns null.
     */
    public T removeLast() {
        IntNode removed = _first._prev;
        if (_size == 0) { //removed == null
            return null;
        } else {
            /*
            _first._prev = removed._prev;
            _first._prev._next = _first;

             */
            _first._prev._prev._next = _first;
            _first._prev = _first._prev._prev;
        }
        _size -= 1;
        return removed._item;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next
     * item, and so forth. If no such item exists, returns null. Must not alter
     * the deque!
     */
    public T get(int index) {
        if (index >= _size) {
            return null;
        } else {
            IntNode ptr = _first._next;
            for (int i = 0; i < index; i += 1) {
                ptr = ptr._next;
            }
            return ptr._item;
        }
    }

    public T getRecursive(int index) {
        if (index < 0 || index > _size) {
            return null;
        }
        if (index == 0) {
            return _first._next._item;
        }
        IntNode ptr = _first._next;
        return getNodeRecursive(ptr, index);
    }

    private T getNodeRecursive(IntNode n, int index) {
        if (index == 0) {
            return n._item;
        } else {
            return getNodeRecursive(n._next, index - 1);
        }
    }
}
