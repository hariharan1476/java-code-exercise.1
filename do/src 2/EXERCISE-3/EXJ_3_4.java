import java.util.Arrays;


public class EXJ_3_4 {
    public static void main(String[] args) {

        String[] n = {"hh","ss","aa","bb"};
        Arrays.sort(n);
        
        System.out.println("\nNames in ascending order:");
        for (String name : n) {
            System.out.println(name);
        }
    }
}
