package collections_methods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class CollectionsMethods demonstrates the methods of util class Collections:
 * - sort(List);
 * - binarySearch(List, key) - use only with sorted list.
 *
 * @author Kamila Meshcheryakova
 * created 02.10.2020
 */
public class CollectionsMethods {
    public static void main(String[] args) {
        ArrayList<Integer> list = new java.util.ArrayList<>(List.of(-2, 6, -20, 0, 4, 29, 23, 45));
        Collections.sort(list);
        int index = Collections.binarySearch(list, -20);
        System.out.println(index);

        Employee emp1 = new Employee(124, "Oleg", 200_000);
        Employee emp2 = new Employee(12, "Olga", 220_000);
        Employee emp3 = new Employee(24, "Inna", 180_000);
        Employee emp4 = new Employee(154, "Anna", 150_000);
        Employee emp5 = new Employee(12, "Tonya", 100_000);
        Employee emp6 = new Employee(84, "Igor", 250_000);
        Employee emp7 = new Employee(128, "Sasha", 210_000);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);
        employeeList.add(emp5);
        employeeList.add(emp6);
        employeeList.add(emp7);
        System.out.println(employeeList);
        Collections.sort(employeeList);
        System.out.println(employeeList);
        int index2 = Collections.binarySearch(employeeList, new Employee(12, "Tonya", 100_000));
        System.out.println(index2);

        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);
    }
}

class Employee implements Comparable<Employee> {
    int id;
    String name;
    int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        int result = this.id - o.id;
        if (result == 0) {
            result = this.name.compareTo(o.name);
        }
        return result;
    }
}