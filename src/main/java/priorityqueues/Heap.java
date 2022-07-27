package priorityqueues;

import java.util.Comparator;

public class Heap<T> implements PriorityQeueuInterface<T>{
    private T[] array;
    private int rear = 0;
    private int count = 0;
    private Comparator<T> comp;

    /**
     * Constructor creates a new Heap with default array capacity 100.
     */
    public Heap() {
        array = (T[])new Object[100];
        comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return ((Comparable)o1).compareTo(o2);
            }
        };
    }

    /**
     * Constructor creates a new Heap with specified array capacity.
     * @param size The capacity of the Heap's array.
     */
    public Heap(int size) {
        array = (T[])new Object[size];
        comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return ((Comparable)o1).compareTo(o2);
            }
        };
    }

    /**
     * enqueue Adds a new element to the end of the Heap.
     * @param item The element to be added.
     */
    public void enqueue(T item) {
        if(count == array.length) {
            return;
        }
        array[rear++] = item;
        count++;
        if(count == 1) {
            return;
        }
        siftUp(item);
    }

    /**
     * siftUp Moves the element from the end of the Heap to its proper location.
     * @param item The element to be moved.
     */
    private void siftUp(T item) {
        int swap = rear - 1;
        while(swap > 0) {
            if(comp.compare(item, array[(swap - 1) / 2]) > 0) {
                array[swap] = array[(swap - 1) / 2];
                swap = (swap - 1) / 2;
            } else {
                break;
            }
        }
        array[swap] = item;
    }

    /**
     * dequeue Removes the highest priority element from the Heap, replacing it with the rear element.
     * @return The highest priority element.
     */
    public T dequeue() {
        T swap;
        T ret = null;
        if(count == 0) {
            return ret;
        } else {
            ret = array[0];
            swap = array[rear - 1];
            rear--;
            count--;
            if(count != 0) {
                siftDown(swap);
            }
            return ret;
        }
    }

    /**
     * siftDown Moves the head element down the Heap to its proper location.
     * @param item The element to be moved.
     */
    private void siftDown(T item) {
        int swap = 0;
        int connection = largestChildIndex(swap, item);
        while(connection != swap) {
            array[swap] = array[connection];
            swap = connection;
            connection = largestChildIndex(swap, item);
        }
        array[swap] = item;
    }

    /**
     * largestChildIndex Determines which child of a parent node is largest when the Heap is conceptualized as a tree.
     * @param swap The index of the element to be swapped.
     * @param item The value of the element to move.
     * @return The index of the element to be swapped.
     */
    private int largestChildIndex(int swap, T item) {
        int leftChild = (swap * 2) + 1;
        int rightChild = (swap * 2) + 2;
        if(leftChild > rear) {
            return swap;
        } else if(leftChild == rear) {
            if(comp.compare(item, array[leftChild]) < 0) {
                return leftChild;
            }
            return swap;
        } else if(comp.compare(array[leftChild], array[rightChild]) < 0) {
            if(comp.compare(array[rightChild], item) <= 0) {
                return swap;
            }
            return rightChild;
        } else if(comp.compare(array[leftChild], item) <= 0) {
            return swap;
        }
        return leftChild;
    }

    /**
     * isEmpty Reports if the Heap is empty.
     * @return True if the Heap is empty, false otherwise.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * isFull Reports if the Heap is full.
     * @return True if the Heap is full, false otherwise.
     */
    public boolean isFull() {
        return count == array.length;
    }

    /**
     * size Reports the total number of elements contained in the Heap.
     * @return The count of all elements contained in the Heap.
     */
    public int size() {
        return count;
    }
}
