import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EXJ_2_9 {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {3, 4, 5, 6, 7};

        int[] commonElements = findCommonElements(array1, array2);

        System.out.println("Common elements between the two arrays: " + Arrays.toString(commonElements));
    }

    public static int[] findCommonElements(int[] arr1, int[] arr2) {
        List<Integer> commonElementsList = new ArrayList<>();

        for (int element1 : arr1) {
            for (int element2 : arr2) {
                if (element1 == element2) {
                    commonElementsList.add(element1);
                    break; // Break to avoid duplicate entries in the result
                }
            }
        }

        // Convert the List to an array
        int[] commonElementsArray = new int[commonElementsList.size()];
        for (int i = 0; i < commonElementsList.size(); i++) {
            commonElementsArray[i] = commonElementsList.get(i);
        }

        return commonElementsArray;
    }
}
