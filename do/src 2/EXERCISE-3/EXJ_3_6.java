public class EXJ_3_6{
    public static void main(String[] args) {
        String input = "Welcome     to     Java     Programming     !!";
        String output = removeConsecutiveBlanks(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + output);
    }

    public static String removeConsecutiveBlanks(String input) {

        return input.replaceAll("     ", " ");
    }
}

