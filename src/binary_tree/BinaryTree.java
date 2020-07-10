package binary_tree;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Class BinaryTree represents a model of tree, where every element has at most 2 children
 * and is arranged in ascending order.
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

    public String getParent(String elementName) {
        for (int i = 1; i < lists.size(); ++i) {
            Entry<String> currentElem = lists.get(i);

            if (currentElem.elementName.equals(elementName))
                return currentElem.parent.elementName;
        }
        return "nobody, because there isn't such element as " + elementName;
    }

    public boolean add(String elementName) {
        boolean check = false;
        Entry<String> currentElement = new BinaryTree.Entry<>(elementName);
        // Method 1. If you want to return the opportunity to have children if you can't add new element to anybody
//        if (lists.stream().noneMatch(Entry::isAvailableToAddChildren)) {
//            if (lists.size() == 1) {
//                lists.get(0).isAvailableToBeParent(lists.get(0));
//            } else {
//                for (int i = 1; i < lists.size(); i++) {
//                    lists.get(i).isAvailableToBeParent(lists.get(i));
//                }
//            }
//        }
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

        // Method 2.
        if (currentElem.parent.leftChild == null && currentElem.parent.rightChild == null &&
                !currentElem.parent.availableToAddLeftChildren && !currentElem.parent.availableToAddRightChildren)
            currentElem.parent.isAvailableToBeParent(currentElem.parent);

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
        List<String> list = new BinaryTree();

        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println("The list size is " + list.size());
        System.out.println("The parent of the child 8 is " + ((BinaryTree) list).getParent("8"));
        System.out.println("The parent of the child 20 is  " + ((BinaryTree) list).getParent("20"));

        list.remove("3");
        System.out.println("The entry 3 is deleted");
        System.out.println("The parent of the child 8 is " + ((BinaryTree) list).getParent("8"));

        list.add("16");
        System.out.println("The parent of the child 16 is " + ((BinaryTree) list).getParent("16"));

        list.remove("4");
        System.out.println("The entry 4 is deleted");
        list.remove("5");
        System.out.println("The entry 5 is deleted");
        list.remove("6");
        System.out.println("The entry 6 is deleted");
        System.out.println("Expected: true. Actual: " + list.add("20"));
        System.out.println("The parent of the child 20 is " + ((BinaryTree) list).getParent("20"));

        list.remove("1");
        System.out.println("The entry 1 is deleted");
        list.remove("2");
        System.out.println("The entry 2 is deleted");
        System.out.println("The list size is " + list.size());
        System.out.println("Expected: true. Actual: " + list.add("21"));
        System.out.println("The parent of the child 21 is " + ((BinaryTree) list).getParent("21"));
        System.out.println("The list size is " + list.size());
    }
} /* Output:
The list size is 15
The parent of the child 8 is 3
The parent of the child 20 is  nobody, because there isn't such element as 20
The entry 3 is deleted
The parent of the child 8 is nobody, because there isn't such element as 8
The parent of the child 16 is 9
The entry 4 is deleted
The entry 5 is deleted
The entry 6 is deleted
Expected: true. Actual: true
The parent of the child 20 is 1
The entry 1 is deleted
The entry 2 is deleted
The list size is 0
Expected: true. Actual: true
The parent of the child 21 is 0
The list size is 1
*/


