package PriorityQueueSortedLLTests;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import priorityqueues.PriorityQeueuInterface;
import priorityqueues.PriorityQueueSortedLL;

public class PriorityQueueSortedLLTest {
    private final PriorityQeueuInterface<Integer> PQ = new PriorityQueueSortedLL<>();

    @Test
    public void addOneElement() {
        PQ.enqueue(1);
        var result = PQ.size() == 1 && !PQ.isEmpty();
        Assertions.assertTrue(result);
    }

    @Test
    public void addMultipleElements() {
        PQ.enqueue(1);
        PQ.enqueue(2);
        PQ.enqueue(3);
        var result = PQ.size() == 3 && !PQ.isEmpty();
        Assertions.assertTrue(result);
    }

    @Test
    public void removeOneElement() {
        PQ.enqueue(1);
        var result = PQ.dequeue();
        Assertions.assertEquals(1, result);
    }

    @Test
    public void removeHighestPriorityElementWhenAddedLast() {
        PQ.enqueue(1);
        PQ.enqueue(2);
        PQ.enqueue(3);
        var result = PQ.dequeue();
        Assertions.assertEquals(3, result);
    }

    @Test
    public void removeHighestPriorityElementWhenAddedFirst() {
        PQ.enqueue(3);
        PQ.enqueue(2);
        PQ.enqueue(1);
        var result = PQ.dequeue();
        Assertions.assertEquals(3, result);
    }

    @Test
    public void removeHighestPriorityElementWhenNotFirstOrLast() {
        PQ.enqueue(1);
        PQ.enqueue(3);
        PQ.enqueue(2);
        var result = PQ.dequeue();
        Assertions.assertEquals(3, result);
    }

    @Test
    public void removeAllElements() {
        PQ.enqueue(1);
        PQ.enqueue(2);
        PQ.enqueue(3);
        PQ.dequeue();
        PQ.dequeue();
        PQ.dequeue();
        var result = PQ.size() == 0 && PQ.isEmpty();
        Assertions.assertTrue(result);
    }

    @Test
    public void removeElementsCheckLowestPriorityIsLast() {
        PQ.enqueue(1);
        PQ.enqueue(2);
        PQ.enqueue(3);
        PQ.dequeue();
        PQ.dequeue();
        var result = PQ.dequeue();
        Assertions.assertEquals(1, result);
    }
}
