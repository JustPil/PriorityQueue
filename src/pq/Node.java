package pq;

public class Node<T>
{
    private T data;
    private Node<T> next;

    /**
     * Constructor sets a node's data to the value passed in, and the next node to null.
     * @param t The value to be held by the node.
     */
    public Node(T t)
    {
        data = t;
        next = null;
    }

    /**
     * setData Sets the node's data to the value passed in.
     * @param t The data to be held bu the node.
     */
    public void setData(T t)
    {
        data = t;
    }

    /**
     * getData Returns the data held by the node.
     * @return The data held by the node.
     */
    public T getData()
    {
        return data;
    }

    /**
     * setNext Sets the next node in the linked list to the node passed in.
     * @param n The next node in the linked list.
     */
    public void setNext(Node<T> n)
    {
        next = n;
    }

    /**
     * getNext Returns the next node in the linked list.
     * @return The next node in the linked list.
     */
    public Node<T> getNext()
    {
        return next;
    }
}
