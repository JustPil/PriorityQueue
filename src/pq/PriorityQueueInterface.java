package pq;

public interface PriorityQueueInterface<T>
{
    void enqueue(T item);
    T dequeue();
    boolean isEmpty();
    boolean isFull();
    int size();
}
