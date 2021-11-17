package pq;

public interface BinarySearchTreeInterface<T>
{
    StringBuilder inOrder();
    StringBuilder preOrder();
    StringBuilder postOrder();
    StringBuilder levelOrder();
    T minNode();
    T maxNode();
    boolean isFull();
    boolean isEmpty();
    int leafCounter();
    int onlyChild();
    int height();
    int size();
    boolean search(T data);
    boolean insert(T data);
    boolean remove(T data);
    BSTNode<T> replacement(BSTNode<T> n);
    BSTNode<T> balance(int start, int end);
    void setRoot(BSTNode<T> n);
    double fullnessRatio();
    int optimalHeight();
}
