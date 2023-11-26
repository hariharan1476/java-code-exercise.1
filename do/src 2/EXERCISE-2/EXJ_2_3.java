import java.util.Arrays;
import java.util.Scanner;
public class EXJ_2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] originalArray = {3, 5, 2, 8, 7, 5, 1, 4, 3, 9};
        int[] ascendingArray = Arrays.copyOf(originalArray, originalArray.length);
        int[] descendingArray = Arrays.copyOf(originalArray, originalArray.length);
        Arrays.sort(ascendingArray);
        Arrays.sort(descendingArray);
        int start = 0;
        int end = descendingArray.length - 1;

        while (start < end) {
            int temp = descendingArray[start];
            descendingArray[start] = descendingArray[end];
            descendingArray[end] = temp;
            start++;
            end--;
        }
        System.out.println("Original Array: " + Arrays.toString(originalArray));
        System.out.println("Ascending Array: " + Arrays.toString(ascendingArray));
        System.out.println("Descending Array: " + Arrays.toString(descendingArray));
    }
}