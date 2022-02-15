package pq;

import java.util.Comparator;

public class PriorityQueueUnsortedArray<T> implements PriorityQueueInterface<T> {
    private T[] array;
    private int last = 0;
    private Comparator<T> comp;

    /**
     * Constructor creates a new unsorted Array Priority Queue with default array capacity of 100.
     */
    public PriorityQueueUnsortedArray() {
        array = (T[]) new Object[100];
        comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return ((Comparable)o1).compareTo(o2);
            }
        };
    }

    /**
     * Constructor creates a new unsorted Array Priority Queue with specified array capacity.
     * @param bound The capacity of the array.
     */
    public PriorityQueueUnsortedArray(int bound) {
        array = (T[]) new Object[bound];
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
        if(!isFull()) {
            array[last++] = item;
        }
    }

    /**
     * dequeue Removes the highest priority element from the Priority Queue.
     * @return The highest priority element.
     */
    public T dequeue() {
        if(isEmpty()) {
            return null;
        }
        if(last == 1) {
            last--;
            T ret = array[last];
            array[last] = null;
            return ret;
        }
        T highest = findHighest();
        if(comp.compare(array[last - 1], highest) == 0) {
            array[last - 1] = null;
            last--;
            return highest;
        }
        for(int i = 0; i < last; i++) {
            if(comp.compare(array[i], highest) == 0) {
                array[i] = array[last - 1];
                array[last--] = null;
            }
        }
        return highest;
    }

    /**
     * findHighest Searches the array for the highest priority element.
     * @return The value of the highest priority element.
     */
    private T findHighest() {
        T highest = array[0];
        for(int i = 1; i < last; i++) {
            if(comp.compare(array[i], highest) >= 0) {
                highest = array[i];
            }
        }
        return highest;
    }

    /**
     * isEmpty Reports if the Priority Queue is empty.
     * @return True if the Priority Queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return last == 0;
    }

    /**
     * isFull Reports if the Priority Queue is full.
     * @return True if the Priority Queue is full, false otherwise.
     */
    public boolean isFull() {
        return last == array.length;
    }

    /**
     * size Reports the total number of elements contained in the Priority Queue.
     * @return The count of all elements contained in the Priority Queue.
     */
    public int size() {
        return last;
    }
}
