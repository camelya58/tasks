package binary_tree;

import java.io.Serializable;
import java.util.*;

/**
 * Class RedBlackTree represents a model of red black tree.
 *
 * @author Kamila Meshcheryakova
 * created by 08.07.2020
 */
@SuppressWarnings("unused")
public class RedBlackTree extends AbstractList<Integer> implements Cloneable, Serializable {
    private static final ArrayList<Entry<Integer>> lists = new ArrayList<>();
    private static int size;

    Entry<Integer> root;

    @Override
    public int size() {
        return size;
    }

    public String getParent(int elementName) {
        for (int i = 1; i < lists.size(); ++i) {
            Entry<Integer> currentElem = lists.get(i);

            if (currentElem.elementName == elementName)
                return String.valueOf(currentElem.parent.elementName);
        }
        return "nobody, because there isn't such element as " + elementName;
    }

    public boolean add(int elementName) {
       if (root == null) {
           root = new RedBlackTree.Entry<>(elementName);
        } else {
           addRecursive(root, elementName);
       }
        size++;
        return true;
    }

    private void addRecursive(Entry<Integer> element, int elementName) {
        Entry<Integer> currentElement = new RedBlackTree.Entry<>(elementName);
        // Случай 1: Вставляемое значение меньше значения узла
        if (elementName< element.elementName) {
        // Если нет левого поддерева, добавляем значение в левого ребенка,
        if (element.availableToAddLeftChildren) {
            element.leftChild = currentElement;
            currentElement.parent = element;
            element.availableToAddLeftChildren = false;
            lists.add(currentElement);
        } else {
            // в противном случае повторяем для левого поддерева.
            addRecursive(element.leftChild, elementName);
        }
        }
        // Случай 2: Вставляемое значение больше или равно значению узла.
        else {
        // Если нет правого поддерева, добавляем значение в правого ребенка,
        if (element.availableToAddRightChildren) {
            element.rightChild = currentElement;
            currentElement.parent = element;
            element.availableToAddRightChildren = false;
            lists.add(currentElement);
        } else {
            // в противном случае повторяем для правого поддерева.
            addRecursive(element.rightChild, elementName);
        }
        }
    }

    @Override
    public Integer get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Integer remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Integer> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        throw new UnsupportedOperationException();
    }

    static class Entry<Integer> implements Serializable {
        int elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<Integer> parent, leftChild, rightChild;

        public Entry(int elementName) {
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
        RedBlackTree tree = new RedBlackTree();
        tree.add(8);
        tree.add(4);
        tree.add(2);
        tree.add(3);
        tree.add(10);
        tree.add(6);
        tree.add(7);

        System.out.println("The list size is " + tree.size());
        System.out.println("The parent of the child 6 is " + tree.getParent(6));
        System.out.println("The parent of the child 20 is " + tree.getParent(20));
    }
} /* Output:
The list size is 7
The parent of the child 6 is 4
The parent of the child 20 is nobody, because there isn't such element as 20
*/


