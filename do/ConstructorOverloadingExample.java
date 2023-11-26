public class ConstructorOverloadingExample {

    private int value;

    // Default constructor
    public ConstructorOverloadingExample() {
        this.value = 0;
    }

    // Parameterized constructor with one parameter
    public ConstructorOverloadingExample(int value) {
        this.value = value;
    }

    // Parameterized constructor with two parameters
    public ConstructorOverloadingExample(int a, int b) {
        this.value = a + b;
    }

    // Getter method to retrieve the value
    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        ConstructorOverloadingExample obj1 = new ConstructorOverloadingExample();
        ConstructorOverloadingExample obj2 = new ConstructorOverloadingExample(10);
        ConstructorOverloadingExample obj3 = new ConstructorOverloadingExample(5, 7);

        System.out.println("Value in obj1: " + obj1.getValue()); // Prints 0
        System.out.println("Value in obj2: " + obj2.getValue()); // Prints 10
        System.out.println("Value in obj3: " + obj3.getValue()); // Prints 12
    }
}
