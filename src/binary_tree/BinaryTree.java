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
    private static final ArrayList<Entry<String>> lists = new ArrayList<>();
    private static int size;

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
        Entry<String> currentElement = new BinaryTree.Entry<>(elementName);
        for (int i = 0; i < lists.size(); i++) {
            // Если нет левого поддерева, добавляем значение в левого ребенка.
            if (lists.get(i).isAvailableToAddChildren()) {
                // If doesn't have left children, add element to left children
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
            lists.add(currentElement);
            break;
        }
        size++;
        return true;
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
    }
    public static void main(String[] args) {
        List<String> list = new BinaryTree();

        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println("The list size is " + list.size());
        System.out.println("The parent of the child 8 is " + ((BinaryTree) list).getParent("8"));
        System.out.println("The parent of the child 20 is  " + ((BinaryTree) list).getParent("20"));
    }
}


