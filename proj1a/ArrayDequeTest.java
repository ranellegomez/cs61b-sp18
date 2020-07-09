import java.util.Arrays;

/** Performs some basic linked list tests. */
public class ArrayDequeTest {

    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");
        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
        // /*
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        boolean passed = checkEmpty(true, lld1.isEmpty());

        for (int i = 0; i < 15; i += 1) {
            //lld1.addFirst(i);
            //lld1.addLast(i);
        }


        lld1.addFirst(0);
        lld1.removeLast();      //==> 0
        lld1.addLast(2);
        lld1.removeLast();      //==> 2
        lld1.addLast(4);
        lld1.removeFirst();     //==> 4
        lld1.addFirst(6);
        lld1.addLast(7);
        lld1.addLast(8);    /// FIXME. The problem is here.
        lld1.removeFirst();     //==> 6
        lld1.addFirst(10);
        lld1.removeFirst();     //==> 10
        lld1.addLast(12);
        lld1.addFirst(13);
        lld1.get(2);




        for (int i = 0; i < lld1.size(); i += 1) {
            System.out.println(lld1.get(i));
        }
        System.out.println(Arrays.toString(lld1._items));

        /**
        passed = checkSize(15, lld1.size()) && passed;
        passed = checkEmpty(false, lld1.isEmpty()) && passed;
         */

    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
        // /*
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        // should be empty
        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.removeFirst();
        // should be empty
        passed = checkEmpty(true, lld1.isEmpty()) && passed;

        printTestStatus(passed);
        // */
    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
    }
} 