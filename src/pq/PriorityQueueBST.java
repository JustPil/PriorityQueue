package pq;

public class PriorityQueueBST<T> implements PriorityQueueInterface<T> {
    private BinarySearchTree<T> bst;
    private int balanceCounter = 0;

    /**
     * Constructor creates a new BST Priority Queue with a Binary Search Tree as a wrapper class.
     */
    public PriorityQueueBST() {
        bst = new BinarySearchTree<>();
    }

    /**
     * enqueue Adds a new element to the Priority Queue. The BST is rebalanced every 4 elements enqueued.
     * @param item The element to be added.
     */
    public void enqueue(T item) {
        bst.insert(item);
        balanceCounter++;
        if(balanceCounter == 4) {
            bst.balance();
            balanceCounter = 0;
        }
    }

    /**
     * dequeue Removes the highest priority element from the Priority Queue.
     * @return The highest priority element.
     */
    public T dequeue() {
        if(bst.isEmpty()) {
            return null;
        }
        T max = bst.maxNode();
        bst.remove(max);
        return max;
    }

    /**
     * isEmpty Reports if the Priority Queue is empty.
     * @return True if the Priority Queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return bst.isEmpty();
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
        return bst.size();
    }
}
