package tasks;

import java.util.LinkedList;

/**
 * Class ReverseLinkedList demonstrates the way to reverse the LinkedList.
 *
 * @author Kamila Meshcheryakova
 * created by 12.01.2021
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 30; i++) {
            list.add(i);
        }
        System.out.println(list);
        int size = list.size();
        LinkedList<Integer> reversedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            reversedList.add(list.pollLast());
        }
        System.out.println(reversedList);
        System.out.println(list);
    }
}
