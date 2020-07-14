package binary_tree;

import java.io.Serializable;
import java.util.*;

/**
 * Class BinaryTreeWithQueue represents a model of tree, where every element has at most 2 children
 * using Queue for avoiding recursive and another storage for elements.
 * It isn't arranged in ascending order.
 *
 * @author Kamila Meshcheryakova
 * created by 10.07.2020
 */
public class BinaryTreeWithQueue extends AbstractList<String> {
    private int size;
    Entry<String> root;

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return size;
    }

    // this method adds the element as a leftChild at the beginning, then as a rightChild
    @Override
    public boolean add(String elementName) {
        Entry<String> currentEntry = new BinaryTreeWithQueue.Entry<>(elementName);
        if (root == null) {
            root = currentEntry;
        } else {
            Queue<Entry<String>> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Entry<String> top = queue.poll();
                if (top.availableToAddLeftChildren) {
                    top.leftChild = currentEntry;
                    currentEntry.parent = top;
                    top.availableToAddLeftChildren = false;
                    queue.clear();
                } else if (top.availableToAddRightChildren) {
                    top.rightChild = currentEntry;
                    currentEntry.parent = top;
                    top.availableToAddRightChildren = false;
                    queue.clear();
                } else {
                    if (top.leftChild != null) queue.add(top.leftChild);
                    if (top.rightChild != null) queue.add(top.rightChild);
                }
            }
        }
        size++;
        return true;
    }

    // This method allows to get parent name by element name or nobody,
    // if the element with such name doesn't exist
    public String getParent(String elementName) {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);

        String parentName = "nobody";

        while (!queue.isEmpty()) {
            Entry<String> entry = queue.poll();
            if (elementName.equals(entry.elementName)) {
                parentName = (entry.parent != null) ? entry.parent.elementName : "nobody";
                break;
            } else {
                if (entry.leftChild != null) queue.add(entry.leftChild);
                if (entry.rightChild != null) queue.add(entry.rightChild);
            }
        }
        return parentName;
    }

    // this method removes the element by name with all his children using following
    @Override
    public boolean remove(Object elementName) {
        boolean deleteElement = false;
        if (elementName instanceof String) {
            Queue<Entry<String>> queue = new LinkedList<>();
            queue.add(root);
            // go through all the elements, find a match by name, delete all links
            while (!queue.isEmpty()) {
                Entry<String> entry = queue.poll();
                if (elementName.equals(entry.elementName)) {
                    if (entry == entry.parent.leftChild) {
                        entry.parent.leftChild = null;
                        if (entry != root) {
                            // return the opportunity to add left child if it was removed
                            entry.parent.availableToAddLeftChildren = true;
                        }
                    } else if (entry == entry.parent.rightChild) {
                        entry.parent.rightChild = null;
                        if (entry != root) {
                            // return the opportunity to add a right child if it was removed
                            entry.parent.availableToAddRightChildren = true;
                        }
                    } else {
                        root = null;
                    }
                    deleteElement = true;
                    queue.clear();
                    break;
                } else {
                    if (entry.leftChild != null) queue.add(entry.leftChild);
                    if (entry.rightChild != null) queue.add(entry.rightChild);
                }
            }
            if (root != null) {
                queue.add(root);
                int count = 0;
                // add all elements to a queue and count a number of elements
                while (!queue.isEmpty()) {
                    Entry<String> current = queue.poll();
                    count++;
                    if (current.leftChild != null) queue.add(current.leftChild);
                    if (current.rightChild != null) queue.add(current.rightChild);
                }
                size = count;
            } else {
                size = 0;
            }
            return deleteElement;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }
    }

    public static void main(String[] args) {
        BinaryTreeWithQueue list = new BinaryTreeWithQueue();

        for (int i = 0; i < 16; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println("The list size is " + list.size());
        System.out.println("The parent of the child 8 is " + list.getParent("8"));
        System.out.println("The parent of the child 20 is " + list.getParent("20"));

        list.remove("3");
        System.out.println("The entry 3 is deleted");
        System.out.println("The list size is " + list.size());
        System.out.println("The parent of the child 8 is " + list.getParent("8"));

        list.add("16");
        System.out.println("The list size is " + list.size());
        System.out.println("The parent of the child 16 is " + list.getParent("16"));

        list.remove("4");
        System.out.println("The entry 4 is deleted");
        System.out.println("The list size is " + list.size());
        list.remove("5");
        System.out.println("The entry 5 is deleted");
        System.out.println("The list size is " + list.size());
        list.remove("6");
        System.out.println("The entry 6 is deleted");
        System.out.println("The list size is " + list.size());
        System.out.println("Expected: true. Actual: " + list.add("20"));
        System.out.println("The list size is " + list.size());
        System.out.println("The parent of the child 20 is " + list.getParent("20"));

        list.remove("1");
        System.out.println("The entry 1 is deleted");
        System.out.println("The list size is " + list.size());
        list.remove("2");
        System.out.println("The entry 2 is deleted");
        System.out.println("The list size is " + list.size());
        System.out.println("Expected: true. Actual: " + list.add("21"));
        System.out.println("The parent of the child 21 is " + list.getParent("21"));
        System.out.println("The list size is " + list.size());
    }
} /* Output:
The list size is 16
The parent of the child 8 is 3
The parent of the child 20 is nobody
The entry 3 is deleted
The list size is 12
The parent of the child 8 is nobody
The list size is 13
The parent of the child 16 is 1
The entry 4 is deleted
The list size is 10
The entry 5 is deleted
The list size is 7
The entry 6 is deleted
The list size is 4
Expected: true. Actual: true
The list size is 5
The parent of the child 20 is 1
The entry 1 is deleted
The list size is 2
The entry 2 is deleted
The list size is 1
Expected: true. Actual: true
The parent of the child 21 is 0
The list size is 2
*/
