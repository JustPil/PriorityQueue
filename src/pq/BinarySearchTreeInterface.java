package pq;

public interface BinarySearchTreeInterface<T> {
    T minNode();
    T maxNode();
    boolean isFull();
    boolean isEmpty();
    int height();
    int size();
    boolean search(T data);
    boolean insert(T data);
    boolean remove(T data);
    BSTNode<T> balance(int start, int end);
}
