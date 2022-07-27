package priorityqueues;

public interface PriorityQeueuInterface<T> {
    void enqueue(T item);
    T dequeue();
    boolean isEmpty();
    boolean isFull();
    int size();
}
