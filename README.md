# PriorityQueue
Summary

Priority Queue ADT implemented with a Heap, Binary Search Tree, Unordered Array, Sorted Linked List, Unordered Linked List. The Priority Queue maintains that elements are stored according to priority, with the highest priority element situated as the first element for removal.

Design

Heap Priority Queue

Implemented with an Array for element storage that may be visualized as a Binary Tree fulfilling the conditions of:

1. A Full Binary Tree, where leaf nodes are on the same level and every parent node has two child nodes.
2. A Complete Binary Tree, where all levels are full to the level before last, and on the last level the leaf nodes are as far left as possible.

The root node of the Heap is the highest priority element, and removing this element will see that it is replaced by the next highest priority element. The Array is able to implicitly store the order of a Heap with the following equation:

For any parent node array[index], the left child node is located a by array[index * 2 + 1] and the right child node by array[index * 2 + 2]. Therefore, finding any node's parent can be performed by calculating array[(index - 1) / 2]. This is how the Heap maintains its order when inserting or removing elements in an optimized fashion.

Efficiency of element addition and removal of highest priority element: O(log N) for addition, O(log N) for removal and required reordering for new highest priority element.

Binary Search Tree Priority Queue

The BST keeps order with the rule that every node to the left of its parent must be less than or equal to the parent, and every node to the right of its parent must be greater than or equal to its parent. The highest priority element would then be the rightmost node in a BST, which is the first element to be removed from a Priority Queue. This BST contains a balancing algorithm to protect against becoming a pathologic/skewed BST, and insertion/deletion algorithms to maintain order.

Efficiency of element addition and removal of highest priority element: O(log N) for addition, O(log N) for removal if BST is balanced, O(N) if BST is pathologic/skewed.

Unordered Array Priority Queue

The unordered Array, adds elements to the leftmost empty index. Removing the highest priority element requires searching the entire Array and keeping a record of the highest element seen so far and its index. This element is then removed by setting it to null and swapping it with the last Array element to fill the empty index.

Efficiency of element addition and removal of highest priority element: O(1) for addition, O(N) for removal of highest priority element.

Sorted Linked List Priority Queue

The Sorted Linked List is sorted from largest to smallest, so that removing the highest priority element removes the front of the list. Adding to the list requires traversing through the nodes to find the correct placement of the value to insert.

Efficiency of element addition and removal of highest priority element: O(N) for addition, O(1) for removal of highest priority element.

Unordered Linked List Priority Queue

The Unordered Linked List adds new elements directly to the front of the list. Removing the highest priority element requires traversing the entire list to find the highest valued element.

Efficiency of element addition and removal of highest priority element: O(1) for addition, O(N) for removal of highest priority element.
