import java.util.LinkedList;
import java.util.Scanner;

/**
 * A class that reads a list of integers from user input, stores them in a LinkedList,
 * and sorts the LinkedList using a bubble sort algorithm.
 * This class uses the Collections Framework for managing the LinkedList.
 * 
 * @author Chelsea Tacey
 * @version 1.1.0
 * @since Week 4 of CSC6301
 */
public class LinkedListSorter {
    /**
     * Initializes the class for sorting operations.
     */
    public LinkedListSorter() {
        // Default constructor
    }
    /**
     * Sorts a LinkedList of integers using the Bubble Sort algorithm.
     * Reuses the original bubbleSort to aid in implementing a LinkedList.
     *
     * @param list the LinkedList to be sorted
     * @since Week 4 of CSC6301
     */
    public static void bubbleSort(LinkedList<Integer> list) {
        int n = list.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    // Swap list[j] and list[j + 1]
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Main method to read a list of integers, store them in a LinkedList, and sort them.
     * Reuses the bubbleSort method to sort the LinkedList.
     * Follows Collections Framework guidelines by using LinkedList for dynamic size and automatic resizing.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> numbers = new LinkedList<>();

        System.out.println("Enter integers (type 'done' to finish):");

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            } else {
                String input = scanner.next();
                if (input.equalsIgnoreCase("done")) {
                    break;
                } else {
                    System.out.println("Please enter a valid integer or 'done' to finish.");
                }
            }
        }
        scanner.close();

        System.out.println("List before sorting:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }

        bubbleSort(numbers);

        System.out.println("\nList after sorting:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
