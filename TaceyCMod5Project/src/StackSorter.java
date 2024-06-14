import java.util.Scanner;
import java.util.Stack;

/**
 * A class that reads a list of integers from user input, stores them in a Stack,
 * and sorts the Stack using a bubble sort algorithm.
 * This class uses the Collections Framework for managing the Stack.
 * 
 * @version 1.2.0
 * @since Week 5 of CSC6301
 */
public class StackSorter {
    /**
     * Initializes the class for sorting operations.
     */
    public StackSorter() {
        // Default constructor
    }

    /**
     * Sorts a Stack of integers using the Bubble Sort algorithm.
     * 
     * This method reuses the bubbleSort algorithm initially designed
     * for LinkedLists, adapted for Stack by utilizing the inherited
     * methods from Vector.
     * 
     * @param stack the Stack to be sorted
     * @since Week 5 of CSC6301
     */
    public static void bubbleSort(Stack<Integer> stack) {
        int n = stack.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (stack.get(j) > stack.get(j + 1)) {
                    // Swap stack[j] and stack[j + 1]
                    int temp = stack.get(j);
                    stack.set(j, stack.get(j + 1));
                    stack.set(j + 1, temp);
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
     * Main method to read a list of integers, store them in a Stack, and sort them.
     * 
     * This method reuses the bubbleSort method to sort the Stack. It follows
     * Collections Framework guidelines by using Stack for dynamic size and automatic resizing.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> numbers = new Stack<>();

        System.out.println("Enter integers (type 'done' to finish):");

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                numbers.push(scanner.nextInt());
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

        System.out.println("Stack before sorting:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }

        bubbleSort(numbers);

        System.out.println("\nStack after sorting:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}

