import java.util.*;

public class EXJ_2_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the number to be searched: ");
        int searchNumber = scanner.nextInt();

        // Input the size of the search array
        System.out.print("Enter the size of the search array: ");
        int size = scanner.nextInt();

        // Input the elements of the search array
        int[] searchArray = new int[size];
        System.out.println("Enter " + size + " elements of the search array:");
        for (int i = 0; i < size; i++) {
            searchArray[i] = scanner.nextInt();
        }


        System.out.println("Search number: " + searchNumber);
        System.out.println("Positions:");

        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (searchArray[i] == searchNumber) {
                System.out.println(searchNumber + " found at position " + i);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Number not found in the search array.");
        }

        scanner.close();
    }
}
