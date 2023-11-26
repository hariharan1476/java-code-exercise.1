public class methodoverloading {
    public static int add(int a, int b) {
        return a + b;
    }
    public static double add(double a, double b) {
        return a + b;
    }
    public static String add(String a, String b) {
        return a + b;
    }
        public static void main(String[] args) {
        System.out.println(add(5, 10));           // Calls the first method
        System.out.println(add(5.5, 10.5));       // Calls the second method
        System.out.println(add("Hello", "World")); // Calls the third method
    }
}
