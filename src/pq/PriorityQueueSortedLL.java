package pq;

import java.util.Comparator;

public class PriorityQueueSortedLL<T> implements PriorityQueueInterface<T>
{
    private Node<T> front;
    private int total = 0;
    private Comparator<T> comp;

    /**
     * Constructor creates a new sorted Linked List Priority Queue.
     */
    public PriorityQueueSortedLL()
    {
        front = null;
        comp = new Comparator<T>()
        {
            public int compare(T element1, T element2)
            {
                return ((Comparable)element1).compareTo(element2);
            }
        };
    }

    /**
     * Adds a new element to the Priority Queue in sorted order.
     * @param item The element to be added.
     */
    public void enqueue(T item)
    {
        Node<T> node = new Node<>(item);
        Node<T> parser = front;
        if(isEmpty())
        {
            front = node;
        }
        else
        {
            while(parser != null)
            {
                if(parser == front && comp.compare(front.getData(), item) <= 0)
                {
                    node.setNext(front);
                    front = node;
                    break;
                }
                else if(parser.getNext() != null && comp.compare(parser.getNext().getData(), item) <= 0)
                {
                    Node<T> temp = parser.getNext();
                    parser.setNext(node);
                    node.setNext(temp);
                    break;
                }
                else if(parser.getNext() == null)
                {
                    parser.setNext(node);
                    break;
                }
                else
                {
                    parser = parser.getNext();
                }
            }
        }
        total++;
    }

    /**
     * dequeue Removes the highest priority element from the Priority Queue.
     * @return The highest priority element.
     */
    public T dequeue()
    {
        if(isEmpty())
        {
            return null;
        }
        T highest = front.getData();
        if(total == 1)
        {
            front = null;
            total--;
            return highest;
        }
        else
        {
            front = front.getNext();
        }
        total--;
        return highest;
    }

    /**
     * isEmpty Reports if the Priority Queue is empty.
     * @return True if the Priority Queue is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return total == 0;
    }

    /**
     * isFull Reports if the Priority Queue is full.
     * @return True if the Priority Queue is full, false otherwise.
     */
    public boolean isFull()
    {
        return false;
    }

    /**
     * size Reports the total number of elements contained in the Priority Queue.
     * @return The count of all elements contained in the Priority Queue.
     */
    public int size()
    {
        return total;
    }
}
