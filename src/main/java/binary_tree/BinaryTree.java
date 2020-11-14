package binary_tree;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Class BinaryTree represents a model of tree, where every element has at most 2 children
 * using ArrayList as a storage for elements.
 * It can be arranged in ascending order using method 1
 * or can't be arranged in ascending order using method 2.
 *
 * @author Kamila Meshcheryakova
 * created by 08.07.2020
 */
public class BinaryTree extends AbstractList<String> implements Cloneable, Serializable {
    private final ArrayList<Entry<String>> lists = new ArrayList<>();
    private int size;

    Entry<String> root;

    public BinaryTree() {
        this.root = new BinaryTree.Entry<>("0");
        lists.add(root);
    }

    @Override
    public int size() {
        return size;
    }

    // This method allows to get parent name by element name or nobody,
    // if the element with such name doesn't exist
    public String getParent(String elementName) {
        for (int i = 1; i < lists.size(); ++i) {
            Entry<String> currentElem = lists.get(i);

            if (currentElem.elementName.equals(elementName))
                return currentElem.parent.elementName;
        }
        return "nobody, because there isn't such element as " + elementName;
    }

    // this method adds the element as a leftChild at the beginning, then as a rightChild
    @Override
    public boolean add(String elementName) {
        boolean check = false;
        Entry<String> currentElement = new BinaryTree.Entry<>(elementName);
        // Method 1. If none of the element is available to add children
        // then the opportunity to have children returns to element who doesn't have children
        // is arranged in ascending order
        if (lists.stream().noneMatch(Entry::isAvailableToAddChildren)) {
            for (Entry<String> list : lists) {
                if (list.leftChild != null && list.rightChild != null) continue;
                list.isAvailableToBeParent(list);
            }
        }
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).isAvailableToAddChildren()) {
                if (lists.get(i).availableToAddLeftChildren) {
                    lists.get(i).leftChild = currentElement;
                    currentElement.parent = lists.get(i);
                    lists.get(i).availableToAddLeftChildren = false;
                } else {
                    lists.get(i).rightChild = currentElement;
                    currentElement.parent = lists.get(i);
                    lists.get(i).availableToAddRightChildren = false;
                }
            } else {
                continue;
            }
            check = lists.add(currentElement);
            break;
        }
        if (check) {
            size++;
            return true;
        }
        return false;
    }

    // this method removes the element by name with all his children using recursive
    @Override
    public boolean remove(Object elementName) {
        if (elementName instanceof String) {
            for (Entry<String> currentElem : lists) {
                if (currentElem.elementName.equals(elementName)) {
                    removeRecursive(currentElem);
                    return true;
                }
            }
            return false;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    // this method allows to remove element together with all his branch of heirs
    private void removeRecursive(Entry<String> currentElem) {
        if (currentElem.leftChild != null || currentElem.rightChild != null) {
            if (currentElem.leftChild != null) {
                removeRecursive(currentElem.leftChild);
                currentElem.leftChild = null;
            }
            if (currentElem.rightChild != null) {
                removeRecursive(currentElem.rightChild);
                currentElem.rightChild = null;
            }
        }
        lists.remove(currentElem);
        if (currentElem == currentElem.parent.leftChild) {
            currentElem.parent.leftChild = null;

        }
        if (currentElem == currentElem.parent.rightChild) {
            currentElem.parent.rightChild = null;
        }

        // if the element isn't available to add left and right child and doesn't have any child
        // then the opportunity to have a child returns to element
        // isn't arranged in ascending order

//        if (currentElem.parent.leftChild == null && currentElem.parent.rightChild == null &&
//                !currentElem.parent.availableToAddLeftChildren && !currentElem.parent.availableToAddRightChildren)
//            currentElem.parent.isAvailableToBeParent(currentElem.parent);

        size--;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
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

        public boolean isAvailableToAddChildren() {
            return (this.availableToAddRightChildren && this.availableToAddLeftChildren)
                    || this.availableToAddRightChildren
                    || this.availableToAddLeftChildren;
        }

        public void isAvailableToBeParent(Entry<T> element) {
            element.availableToAddLeftChildren = true;
            element.availableToAddRightChildren = true;
        }
    }

    public static void main(String[] args) {
        BinaryTree list = new BinaryTree(); // root initializes during creation of BinaryTree

        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println("The list size is " + list.size());
        System.out.println("The parent of the child 8 is " + list.getParent("8"));
        System.out.println("The parent of the child 20 is  " + list.getParent("20"));

        list.remove("3");
        System.out.println("The entry 3 is deleted");
        System.out.println("The parent of the child 8 is " + list.getParent("8"));

        list.add("16");
        System.out.println("The parent of the child 16 is " + list.getParent("16"));

        list.remove("4");
        System.out.println("The entry 4 is deleted");
        list.remove("5");
        System.out.println("The entry 5 is deleted");

        System.out.println("Expected: true. Actual: " + list.add("20"));
        System.out.println("The parent of the child 20 is " + list.getParent("20"));

        list.remove("1");
        System.out.println("The entry 1 is deleted");
        list.remove("2");
        System.out.println("The entry 2 is deleted");
        System.out.println("The list size is " + list.size());
        System.out.println("Expected: true. Actual: " + list.add("21"));
        System.out.println("The parent of the child 21 is " + list.getParent("21"));
        System.out.println("The list size is " + list.size());
    }
} /* Output for Method 1:
The list size is 15
The parent of the child 8 is 3
The parent of the child 20 is  nobody, because there isn't such element as 20
The entry 3 is deleted
The parent of the child 8 is nobody, because there isn't such element as 8
The parent of the child 16 is 9
The entry 4 is deleted
The entry 5 is deleted
Expected: true. Actual: true
The parent of the child 20 is 13
The entry 1 is deleted
The entry 2 is deleted
The list size is 0
Expected: true. Actual: true
The parent of the child 21 is 0
The list size is 1


Output for Method 2:
The list size is 15
The parent of the child 8 is 3
The parent of the child 20 is  nobody, because there isn't such element as 20
The entry 3 is deleted
The parent of the child 8 is nobody, because there isn't such element as 8
The parent of the child 16 is 9
The entry 4 is deleted
The entry 5 is deleted
Expected: true. Actual: true
The parent of the child 20 is 1
The entry 1 is deleted
The entry 2 is deleted
The list size is 0
Expected: true. Actual: true
The parent of the child 21 is 0
The list size is 1
*/


