package binarysearchtrees;

import nodes.BSTNode;
import java.util.Comparator;
import java.util.Stack;

public class BinarySearchTree<T> implements BinarySeachTreeInterface<T> {
    enum Direction {
        LEFT,
        RIGHT
    }

    private BSTNode<T> root = null;
    private int nodeCount = 0;
    private T[] array;
    private StringBuilder sb;
    private Comparator<T> comp;

    /**
     * Constructor creates a new BinarySearchTree and sets the root node to null.
     */
    public BinarySearchTree() {
        comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return ((Comparable)o1).compareTo(o2);
            }
        };
    }

    /**
     * search Searches the BST for a node holding a chosen data value.
     * @param data The data to search for.
     * @return True if the data was found, false otherwise.
     */
    public boolean search(T data) {
        if(root == null) {
            return false;
        }
        BSTNode<T> node = root;
        while(node != null) {
            if(comp.compare(data, node.getData()) == 0) {
                return true;
            } else if(comp.compare(data, node.getData()) > 0) {
                node = node.getRight();
            } else if(comp.compare(data, node.getData()) < 0) {
                node = node.getLeft();
            }
        }
        return false;
    }

    /**
     * insert Inserts a new node into the BST.
     * @param data The data for the new node to hold.
     * @return True if the insertion was successful, false otherwise.
     */
    public boolean insert(T data) {
        if(root == null) {
            BSTNode<T> node = new BSTNode<>(data);
            root = node;
            nodeCount++;
            return true;
        }
        BSTNode<T> node = root;
        while(true) {
            if(comp.compare(data, node.getData()) <= 0 && node.getLeft() != null) {
                node = node.getLeft();
            } else if(comp.compare(data, node.getData()) > 0 && node.getRight() != null) {
                node = node.getRight();
            } else if(comp.compare(data, node.getData()) <= 0 && node.getLeft() == null) {
                node.setLeft(new BSTNode<>(data));
                nodeCount++;
                return true;
            } else if(comp.compare(data, node.getData()) > 0 && node.getRight() == null) {
                node.setRight(new BSTNode<>(data));
                nodeCount++;
                return true;
            }
        }
    }

    /**
     * remove Removes a node from the BST.
     * @param data The data held by the node targeted for removal.
     * @return True if the removal was successful, false otherwise.
     */
    public boolean remove(T data) {
        if(isEmpty()) {
            return false;
        }
        BSTNode<T> targetNode = root;
        BSTNode<T> parentRef = targetNode;
        while(true) {
            if(comp.compare(targetNode.getData(), data) == 0) {
                if(targetNode.getLeft() != null && targetNode.getRight() != null) {
                    targetNode.setData(replacement(targetNode));
                } else if(targetNode.getLeft() != null || targetNode.getRight() != null) {
                    removeNodeWithOneChild(targetNode, parentRef);
                } else {
                    removeLeafNode(targetNode, parentRef);
                }
                nodeCount--;
                return true;
            } else if(comp.compare(targetNode.getData(), data) > 0 && targetNode.getLeft() != null) {
                parentRef = targetNode;
                targetNode = targetNode.getLeft();
            } else if(comp.compare(targetNode.getData(), data) < 0 && targetNode.getRight() != null) {
                parentRef = targetNode;
                targetNode = targetNode.getRight();
            } else {
                return false;
            }
        }
    }

    /**
     * replacement Finds the replacement node to replace a node targeted for removal. The replacement node is copied for
     * a return value and removed from the BST.
     * @param n The node intended for removal.
     * @return The replacement node.
     */
    private T replacement(BSTNode<T> n) {
        BSTNode<T> replace = n;
        BSTNode<T> deleter = replace;
        if(n.getLeft() != null) {
            deleter = replace;
            replace = replace.getLeft();
        }
        while(replace.getRight() != null) {
            deleter = replace;
            replace = replace.getRight();
        }
        T copy = replace.getData();
        if(deleter.getRight() != null && deleter.getRight().equals(replace)) {
            deleter.setRight(null);
        } else {
            deleter.setLeft(null);
        }
        return copy;
    }

    /**
     * removeNodeWithOneChild Removes a Node with only one child reference.
     * @param targetNode The Node to be removed.
     * @param parentRef The parent of the Node to be removed.
     */
    private void removeNodeWithOneChild(BSTNode<T> targetNode, BSTNode<T> parentRef) {
        if(targetNode.equals(root) && root.getLeft() != null) {
            root = root.getLeft();
        } else if (targetNode.equals(root) && root.getRight() != null) {
            root = root.getRight();
        } else {
            Direction parentDirection = parentRef.getLeft() != null &&
                    parentRef.getLeft().equals(targetNode) ? Direction.LEFT : Direction.RIGHT;
            Direction targetDirection = targetNode.getLeft() != null ? Direction.LEFT : Direction.RIGHT;
            if(parentDirection == Direction.LEFT && targetDirection == Direction.LEFT) {
                parentRef.setLeft(targetNode.getLeft());
            } else if (parentDirection == Direction.RIGHT && targetDirection == Direction.RIGHT) {
                parentRef.setRight(targetNode.getRight());
            } else if (parentDirection == Direction.LEFT && targetDirection == Direction.RIGHT) {
                parentRef.setLeft(targetNode.getRight());
            } else {
                parentRef.setRight(targetNode.getLeft());
            }
        }
    }

    /**
     * removeLeafNode Removes a Node with no children.
     * @param targetNode The Node to be removed.
     * @param parentRef The parent of the Node to be removed.
     */
    private void removeLeafNode(BSTNode<T> targetNode, BSTNode<T> parentRef) {
        if(targetNode.equals(root)) {
            root = null;
        }
        if(parentRef.getLeft() != null && parentRef.getLeft().equals(targetNode)) {
            parentRef.setLeft(null);
        } else {
            parentRef.setRight(null);
        }
    }

    /**
     * size Reports the total nodes in the BST.
     * @return The count of all nodes in the BST.
     */
    public int size() {
        return nodeCount;
    }

    /**
     * isEmpty Reports if the BST is empty.
     * @return Whether the root node is null or not null.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * isFull Reports if the BST is full.
     * @return False, a BST has no set limit.
     */
    public boolean isFull() {
        return false;
    }

    /**
     * inOrder Performs an inorder traversal algorithm.
     * @return A StringBuilder containing the inorder contents of the BST nodes.
     */
    public StringBuilder inOrder() {
        sb = new StringBuilder("[");
        array = (T[])new Object[nodeCount];
        if(root == null) {
            return sb.append(']');
        }
        int index = 0;
        Stack<BSTNode<T>> stack = new Stack<>();
        BSTNode<T> node = root;
        while(true) {
            if(node != null) {
                stack.push(node);
                node = node.getLeft();
            } else {
                if(stack.isEmpty()) {
                    break;
                }
                node = stack.pop();
                sb.append(node.getData()).append(index == array.length - 1 ? ']' : ' ');
                array[index++] = node.getData();
                node = node.getRight();
            }
        }
        return sb;
    }

    /**
     * minNode Finds the node holding the smallest data.
     * @return The data held by the node.
     */
    public T minNode() {
        if(isEmpty()) {
            return null;
        } else {
            BSTNode<T> node = root;
            while(node.getLeft() != null) {
                node = node.getLeft();
            }
            return node.getData();
        }
    }

    /**
     * maxNode Finds the node holding the largest data.
     * @return The data held by the node.
     */
    public T maxNode() {
        if(isEmpty()) {
            return null;
        } else {
            BSTNode<T> node = root;
            while(node.getRight() != null) {
                node = node.getRight();
            }
            return node.getData();
        }
    }

    /**
     * balance Balances the BST using an iterative balancing algorithm requiring a Stack for nodes and a Stack for the
     * start and end array indices with respect to the node's middle position in the array. The start and end indices
     * change as the new BST is built.
     */
    public void balance() {
        if(nodeCount <= 1) {
            return;
        }
        inOrder();
        Stack<BSTNode<T>> nodeStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push((array.length) - 1);
        indexStack.push(0);
        BSTNode<T> balancedRoot = new BSTNode<>(null);
        nodeStack.push(balancedRoot);
        while(!nodeStack.isEmpty()) {
            BSTNode<T> parsingNode = nodeStack.pop();
            int start = indexStack.pop();
            int end = indexStack.pop();
            int mid = start + (end - start) / 2;
            parsingNode.setData(array[mid]);
            if(start < mid) {
                BSTNode<T> node = new BSTNode<>(array[start]);
                parsingNode.setLeft(node);
                nodeStack.push(node);
                indexStack.push(mid - 1);
                indexStack.push(start);
            }
            if(end > mid) {
                BSTNode<T> node = new BSTNode<>(array[end]);
                parsingNode.setRight(node);
                nodeStack.push(node);
                indexStack.push(end);
                indexStack.push(mid + 1);
            }
        }
        root = balancedRoot;
    }
}
