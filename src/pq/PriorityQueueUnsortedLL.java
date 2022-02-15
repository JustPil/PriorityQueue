package pq;

import java.util.Comparator;

public class PriorityQueueUnsortedLL<T> implements PriorityQueueInterface<T> {
    private Node<T> front;
    private int total = 0;
    private Comparator<T> comp;

    /**
     * Constructor creates a new unsorted Linked List Priority Queue.
     */
    public PriorityQueueUnsortedLL() {
        front = null;
        comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return ((Comparable)o1).compareTo(o2);
            }
        };
    }

    /**
     * Adds a new element to the Priority Queue.
     * @param item The element to be added.
     */
    public void enqueue(T item) {
        Node<T> node = new Node<>(item);
        if (!isEmpty()) {
            node.setNext(front);
        }
        front = node;
        total++;
    }

    /**
     * dequeue Removes the highest priority element from the Priority Queue.
     * @return The highest priority element.
     */
    public T dequeue() {
        if(isEmpty()) {
            return null;
        }
        T highest = findHighest();
        if(total == 1) {
            front = null;
            total--;
            return highest;
        }
        Node<T> parser = front;
        while(parser != null) {
            if(parser == front && comp.compare(parser.getData(), highest) == 0) {
                front = front.getNext();
                break;
            } else if(comp.compare(parser.getNext().getData(), highest) == 0) {
                if(parser.getNext().getNext() != null) {
                    parser.setNext(parser.getNext().getNext());
                } else {
                    parser.setNext(null);
                }
                break;
            } else {
                parser = parser.getNext();
            }
        }
        total--;
        return highest;
    }

    /**
     * findHighest Searches the Linked List for the highest priority element.
     * @return The value of the highest priority element.
     */
    private T findHighest() {
        T highest = front.getData();
        Node<T> parser = front;
        while(parser != null) {
            if(comp.compare(parser.getData(), highest) >= 0) {
                highest = parser.getData();
            }
            parser = parser.getNext();
        }
        return highest;
    }

    /**
     * isEmpty Reports if the Priority Queue is empty.
     * @return True if the Priority Queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return total == 0;
    }

    /**
     * isFull Reports if the Priority Queue is full.
     * @return True if the Priority Queue is full, false otherwise.
     */
    public boolean isFull() {
        return false;
    }

    /**
     * size Reports the total number of elements contained in the Priority Queue.
     * @return The count of all elements contained in the Priority Queue.
     */
    public int size() {
        return total;
    }
}
