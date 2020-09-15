import org.junit.Test;

import java.util.Deque;

import static org.junit.Assert.*;

public class TestArrayDequeGold {
    @Test
    public void testAddFirst() {
        StudentArrayDeque<Integer> actual = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> expected = new ArrayDequeSolution<>();

        for (int i = 0; i < 9999; i++) {
            int random = StdRandom.uniform(9999);
            actual.addFirst(random);
            expected.addFirst(random);
            assertEquals(expected.removeFirst(), actual.removeFirst());
        }
    }

    @Test
    public void testAddLast() {
        StudentArrayDeque<Integer> actual = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> expected = new ArrayDequeSolution<>();

        for (int i = 0; i < 1000; i++) {
            int random = StdRandom.uniform(1000);
            actual.addLast(random);
            expected.addLast(random);
        }
        for (int i = 0; i < 1000; i++) {
            assertEquals(actual.get(i), expected.get(i));
        }
    }

    @Test
    public void testRemoveLast() {
        StudentArrayDeque<Integer> actual = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> expected = new ArrayDequeSolution<>();

        for (int i = 0; i < 1000; i++) {
            int random = StdRandom.uniform(1000);
            actual.addLast(random);
            expected.addLast(random);

        }
        for (int i = 0; i < 1000; i++) {
            assertEquals("removeLast() " + i, expected.removeLast(),
                         actual.removeLast());
        }

    }

    /** This main method is optional. */
    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(AssertEqualsStringDemo.class);
    }
}

