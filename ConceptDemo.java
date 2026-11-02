// ConceptDemo.java
// Spencer Tran
// November 1, 2026
// Demonstrates the Adapter pattern with Java collections.

import java.util.*;

// Adapter: wraps an Integer[] and provides it as a List
class ArrayAdapter {
    private Integer[] array;

    // Store the array we are adapting
    public ArrayAdapter(Integer[] array) {
        this.array = array;
    }

    // Convert the array into a new, changeable List
    public List<Integer> toList() {
        List<Integer> list = new ArrayList<>();  // diamond operator
        Collections.addAll(list, array);         // copy array into list
        return list;
    }
}

public class ConceptDemo {
    // Unbounded wildcard: accepts a List of any type
    public static void printList(List<?> list) {
        System.out.println(list);
    }

    public static void main(String[] args) {
        // Create the array of integers to adapt
        Integer[] numbers = {5, 2, 9, 1, 4, 7};

        // Use the adapter to get a mutable List from the array
        List<Integer> list = new ArrayAdapter(numbers).toList();

        // Print the list before sorting
        System.out.println("Before sorting: " + list);

        // Sort the list in ascending order
        Collections.sort(list);
        System.out.println("After sorting: " + list);

        // Remove the value 4 (valueOf avoids removing by index)
        list.remove(Integer.valueOf(4));
        System.out.println("After removing 4: " + list);

        // Print the list using the unbounded wildcard method
        System.out.print("Printing list using unbounded wildcard: ");
        printList(list);
    }
}