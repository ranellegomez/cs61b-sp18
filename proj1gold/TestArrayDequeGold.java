import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestArrayDequeGold {
    @Test
    public void testAddFirst() {
        StudentArrayDeque<Integer> actual = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> expected = new ArrayDequeSolution<>();
        String calls = "\n";
        for (int i = 0; i < 9999; i++) {
            int random = StdRandom.uniform(9999);
            actual.addFirst(random);
            expected.addFirst(random);
            calls += "addFirst(" + random + ")" + "\n";
            calls += "removeFirst()" + "\n";
            assertEquals(calls, expected.removeFirst(), actual.removeFirst());
        }
    }

    @Test
    public void testAddLast() {
        StudentArrayDeque<Integer> actual = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> expected = new ArrayDequeSolution<>();
        String calls = "\n";

        for (int i = 0; i < 9999; i++) {
            int random = StdRandom.uniform(9999);
            actual.addLast(random);
            expected.addLast(random);
            calls += "addLast(" + random + ")" + "\n";
        }
        for (int i = 0; i < 9999; i++) {
            calls += "get(" + i + ")" + "\n";
            assertEquals(calls, actual.get(i), expected.get(i));
        }
    }

    @Test
    public void testRemoveLast() {
        StudentArrayDeque<Integer> actual = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> expected = new ArrayDequeSolution<>();
        String calls = "\n";
        for (int i = 0; i < 9999; i++) {
            int random = StdRandom.uniform(9999);
            actual.addLast(random);
            expected.addLast(random);
            calls += "addLast(" + random + ")" + "\n";
        }
        for (int i = 0; i < 9999; i++) {
            calls += "removeLast()" + "\n";
            assertEquals(calls, expected.removeLast(),
                         actual.removeLast());
        }
    }

    @Test
    public void testRemoveLast2() {
        StudentArrayDeque<Integer> actual = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> expected = new ArrayDequeSolution<>();
        String calls = "\n";
        for (int i = 0; i < 9999; i++) {
            int random = StdRandom.uniform(9999);
            int random2 = StdRandom.uniform(9999);

            actual.addLast(random);
            expected.addLast(random);

            actual.addLast(random2);
            expected.addLast(random2);

            calls += "addLast(" + random + ")" + "\n";
            calls += "addLast(" + random2 + ")" + "\n";
            calls += "removeLast()" + "\n";

            assertEquals(calls, expected.removeLast(),
                         actual.removeLast());
        }
    }

    @Test
    public void testRemoveFirst2() {
        StudentArrayDeque<Integer> actual = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> expected = new ArrayDequeSolution<>();
        String calls = "\n";
        for (int i = 0; i < 9999; i++) {
            int random = StdRandom.uniform(9999);
            int random2 = StdRandom.uniform(9999);

            actual.addFirst(random);
            expected.addFirst(random);

            actual.addFirst(random2);
            expected.addFirst(random2);

            calls += "addFirst(" + random + ")" + "\n";
            calls += "addFirst(" + random2 + ")" + "\n";
            calls += "removeLast()" + "\n";

            assertEquals(calls, expected.removeLast(),
                         actual.removeLast());
        }
    }

    @Test
    public void testRemoveFirst3() {
        StudentArrayDeque<Integer> actual = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> expected = new ArrayDequeSolution<>();
        String calls = "\n";
        for (int i = 0; i < 9999; i++) {
            int random = StdRandom.uniform(9999);
            int random2 = StdRandom.uniform(9999);

            actual.addFirst(random);
            expected.addFirst(random);

            actual.addFirst(random2);
            expected.addFirst(random2);

            calls += "addFirst(" + random + ")" + "\n";
            calls += "addFirst(" + random2 + ")" + "\n";
            calls += "removeFirst()" + "\n";

            assertEquals(calls, expected.removeFirst(),
                         actual.removeFirst());
        }
    }

    @Test
    public void testRemoveFirst() {
        StudentArrayDeque<Integer> actual = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> expected = new ArrayDequeSolution<>();
        String calls = "\n";
        for (int i = 0; i < 9999; i++) {
            int random = StdRandom.uniform(9999);
            actual.addFirst(random);
            expected.addFirst(random);
            calls += "addFirst(" + random + ")" + "\n";
        }
        for (int i = 0; i < 9999; i++) {
            calls += "removeFirst(), " + "\n";
            assertEquals(calls, expected.removeFirst(),
                         actual.removeFirst());
        }

    }
}



