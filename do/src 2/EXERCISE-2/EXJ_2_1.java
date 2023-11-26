import java.util.*;
public class EXJ_2_1 {
    public static void main(String[] args) {
        // Predefined array
        int[] array = {3, 5, 2, 8, 7, 5, 1, 4, 3, 9};



        System.out.print("Enter the number to be searched: ");
        Scanner scanner = new Scanner(System.in);
        int searchNumber = scanner.nextInt();

        int count = 0;
        for (int i = 0; i <= array.length; i++) {
            if (array[i] == searchNumber) {
                count++;
            }
        }


        if (count > 0) {
            System.out.println(searchNumber + " is present in the array.");
            System.out.println("It appears " + count + " time(s) in the array.");
        } else {
            System.out.println(searchNumber + " is not present in the array.");
        }

        scanner.close();
    }
}
