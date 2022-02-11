package pq;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        String choice = "";
        Scanner scn = new Scanner(System.in);
        while(!choice.equalsIgnoreCase("X"))
        {
            System.out.print("Priority Queue Implementations\n1 - Heap (Array)\n2 - Binary Search Tree\n3 - " +
                    "Linked List (sorted)\n4 - Linked List (unsorted)\n5 - Array (unsorted)\nX - Terminate\n" +
                    "Enter choice: ");
            choice = scn.nextLine();
            if(choice.equals("1"))
            {
                heapArray(scn);
            }
            else if(choice.equals("2"))
            {
                binarySearchTree(scn);
            }
            else if(choice.equals("3"))
            {
                linkedListSort(scn);
            }
            else if(choice.equals("4"))
            {
                linkedListUnsort(scn);
            }
            else if(choice.equals("5"))
            {
                arrayUnsort(scn);
            }
            else if(choice.equalsIgnoreCase("X"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid choice.");
            }
        }
        scn.close();
    }

    /**
     * heapArray A Test Driver for a Priority Queue implemented as a Heap.
     * @param s A Scanner to relay user input.
     */
    public static void heapArray(Scanner s)
    {
        Heap<Integer> heap = new Heap<>();
        String choice = "";
        while(!choice.equalsIgnoreCase("X"))
        {
            System.out.print("\nMethods for Priority Queue (Heap Implementation)\n1 - ENQUEUE - Adds an element " +
                    "to the Priority Queue\n2 - DEQUEUE - Removes the largest element\n3 - IS EMPTY - Checks if " +
                    "the Priority Queue is empty\n4 - IS FULL - Checks if the Priority Queue is full\n5 - SIZE - " +
                    "Reports the number of elements in the Priority Queue\nX - Terminate\n\nEnter choice: ");
            choice = s.nextLine();
            if(choice.equals("1"))
            {
                System.out.print("Enter an integer to add to the Priority Queue: ");
                int input = s.nextInt();
                s.nextLine();
                heap.enqueue(input);
                System.out.println("Added: " + input);
            }
            else if(choice.equals("2"))
            {
                System.out.println("Removed: " + heap.dequeue());
            }
            else if(choice.equals("3"))
            {
                System.out.println("Empty Priority Queue: " + heap.isEmpty());
            }
            else if(choice.equals("4"))
            {
                System.out.println("Full Priority Queue: " + heap.isFull());
            }
            else if(choice.equals("5"))
            {
                System.out.println("Size: " + heap.size());
            }
            else if(choice.equalsIgnoreCase("X"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid choice.");
            }
        }
    }

    /**
     * binarySearchTree A Test Driver for a Priority Queue implemented as a Binary Tree.
     * @param s A Scanner to relay user input.
     */
    public static void binarySearchTree(Scanner s)
    {
        PriorityQueueBST<Integer> bst = new PriorityQueueBST<>();
        String choice = "";
        while(!choice.equalsIgnoreCase("X"))
        {
            System.out.print("\nMethods for Priority Queue (Binary Search Tree Implementation)\n1 - ENQUEUE - Adds " +
                            "an element to the Priority Queue\n2 - DEQUEUE - Removes the largest element\n3 - IS " +
                    "EMPTY - Checks if the Priority Queue is empty\n4 - IS FULL - Checks if the Priority Queue is " +
                            "full\n5 - SIZE - Reports the number of elements in the Priority Queue\nX - Terminate\n" +
                    "\nEnter choice: ");
            choice = s.nextLine();
            if(choice.equals("1"))
            {
                System.out.print("Enter an integer to add to the Priority Queue: ");
                int input = s.nextInt();
                s.nextLine();
                bst.enqueue(input);
                System.out.println("Added: " + input);
            }
            else if(choice.equals("2"))
            {
                System.out.println("Removed: " + bst.dequeue());
            }
            else if(choice.equals("3"))
            {
                System.out.println("Empty Priority Queue:  " + bst.isEmpty());
            }
            else if(choice.equals("4"))
            {
                System.out.println("Full Priority Queue: " + bst.isFull());
            }
            else if(choice.equals("5"))
            {
                System.out.println("Size: " + bst.size());
            }
            else if(choice.equalsIgnoreCase("X"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid choice.");
            }
        }
    }

    /**
     * linkedListSort A Test Driver for a Priority Queue implemented as a sorted Linked List.
     * @param s A Scanner to relay user input.
     */
    public static void linkedListSort(Scanner s)
    {
        PriorityQueueSortedLL<Integer> ll = new PriorityQueueSortedLL<>();
        String choice = "";
        while(!choice.equalsIgnoreCase("X"))
        {
            System.out.print("\nMethods for Priority Queue (Sorted Linked List Implementation)\n1 - ENQUEUE - Adds " +
                            "an element to the Priority Queue\n2 - DEQUEUE - Removes the largest element\n3 - IS " +
                    "EMPTY - Checks if the Priority Queue is empty\n4 - IS FULL - Checks if the Priority Queue is " +
                            "full\n5 - SIZE - Reports the number of elements in the Priority Queue\nX - Terminate\n" +
                    "\nEnter choice: ");
            choice = s.nextLine();
            if(choice.equals("1"))
            {
                System.out.print("Enter an integer to add to the Priority Queue: ");
                int input = s.nextInt();
                s.nextLine();
                ll.enqueue(input);
                System.out.println("Added: " + input);
            }
            else if(choice.equals("2"))
            {
                System.out.println("Removed: " + ll.dequeue());
            }
            else if(choice.equals("3"))
            {
                System.out.println("Empty Priority Queue:  " + ll.isEmpty());
            }
            else if(choice.equals("4"))
            {
                System.out.println("Full Priority Queue: " + ll.isFull());
            }
            else if(choice.equals("5"))
            {
                System.out.println("Size: " + ll.size());
            }
            else if(choice.equalsIgnoreCase("X"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid choice.");
            }
        }
    }

    /**
     * linkedListUnsort A Test Driver for a Priority Queue implemented as an unsorted Linked List.
     * @param s A Scanner to relay user input.
     */
    public static void linkedListUnsort(Scanner s)
    {
        PriorityQueueUnsortedLL<Integer> ll = new PriorityQueueUnsortedLL<>();
        String choice = "";
        while(!choice.equalsIgnoreCase("X"))
        {
            System.out.print("\nMethods for Priority Queue (Unsorted Linked List Implementation)\n1 - ENQUEUE - Adds" +
                            "an element to the Priority Queue\n2 - DEQUEUE - Removes the largest element\n3 - IS " +
                    "EMPTY - Checks if the Priority Queue is empty\n4 - IS FULL - Checks if the Priority Queue is " +
                            "full\n5 - SIZE - Reports the number of elements in the Priority Queue\nX - Terminate\n" +
                    "\nEnter choice: ");
            choice = s.nextLine();
            if(choice.equals("1"))
            {
                System.out.print("Enter an integer to add to the Priority Queue: ");
                int input = s.nextInt();
                s.nextLine();
                ll.enqueue(input);
                System.out.println("Added: " + input);
            }
            else if(choice.equals("2"))
            {
                System.out.println("Removed: " + ll.dequeue());
            }
            else if(choice.equals("3"))
            {
                System.out.println("Empty Priority Queue:  " + ll.isEmpty());
            }
            else if(choice.equals("4"))
            {
                System.out.println("Full Priority Queue: " + ll.isFull());
            }
            else if(choice.equals("5"))
            {
                System.out.println("Size: " + ll.size());
            }
            else if(choice.equalsIgnoreCase("X"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid choice.");
            }
        }
    }

    /**
     * arrayUnsort A Test Driver for a Priority Queue implemented as an unsorted Array.
     * @param s A Scanner to relay user input.
     */
    public static void arrayUnsort(Scanner s)
    {
        PriorityQueueUnsortedArray<Integer> arr = new PriorityQueueUnsortedArray<>();
        String choice = "";
        while(!choice.equalsIgnoreCase("X"))
        {
            System.out.print("\nMethods for Priority Queue (Unsorted Array Implementation)\n1 - ENQUEUE - Adds an " +
                            "element to the Priority Queue\n2 - DEQUEUE - Removes the largest element\n3 - IS EMPTY " +
                    "- Checks if the Priority Queue is empty\n4 - IS FULL - Checks if the Priority Queue is full\n5 -" +
                            " SIZE - Reports the number of elements in the Priority Queue\nX - Terminate\n\nEnter " +
                    "choice: ");
            choice = s.nextLine();
            if(choice.equals("1"))
            {
                System.out.print("Enter an integer to add to the Priority Queue: ");
                int input = s.nextInt();
                s.nextLine();
                arr.enqueue(input);
                System.out.println("Added: " + input);
            }
            else if(choice.equals("2"))
            {
                System.out.println("Removed: " + arr.dequeue());
            }
            else if(choice.equals("3"))
            {
                System.out.println("Empty Priority Queue:  " + arr.isEmpty());
            }
            else if(choice.equals("4"))
            {
                System.out.println("Full Priority Queue: " + arr.isFull());
            }
            else if(choice.equals("5"))
            {
                System.out.println("Size: " + arr.size());
            }
            else if(choice.equalsIgnoreCase("X"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid choice.");
            }
        }
    }
}
