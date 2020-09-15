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
        String calls = "\n";
        for (int i = 0; i < 1000; i++) {
            int random = StdRandom.uniform(1000);
            actual.addLast(random);
            expected.addLast(random);
            calls += "actual.addLast(" + random + ")" + "\n" + "expected"
                    + ".addLast(" + random + ")" + "\n";
        }
        for (int i = 0; i < 1000; i++) {
            calls += "assertEquals(" + "expected.removeLast(), " +
                    "actual.removeLast())" + "\n";
            assertEquals(calls, expected.removeLast(),
                         actual.removeLast());
        }

    }

    @Test
    public void testRemoveFirst() {
        StudentArrayDeque<Integer> actual = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> expected = new ArrayDequeSolution<>();
        String calls = "\n";
        for (int i = 0; i < 1000; i++) {
            int random = StdRandom.uniform(1000);
            actual.addFirst(random);
            expected.addFirst(random);
            calls += "actual.First(" + random + ")" + "\n" + "expected"
                    + ".addFirst(" + random + ")" + "\n";
        }
        for (int i = 0; i < 1000; i++) {
            calls += "assertEquals(" + "expected.removeFirst(), " +
                    "actual.removeFirst())" + "\n";
            assertEquals(calls, expected.removeFirst(),
                         actual.removeFirst());
        }

    }
}



