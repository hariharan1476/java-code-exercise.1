public class Distance {
    private int feet;
    private double inches;

    // Constructor to initialize to zero
    public Distance() {
        this(0, 0.0);
    }

    // Constructor to initialize to fixed values
    public Distance(int feet, double inches) {
        this.feet = feet;
        this.inches = inches;
    }

    // Display the distance data
    public void displayDistance() {
        System.out.printf("%d feet %.2f inches\n", feet, inches);
    }

    // Add two Distance objects and return the resultant object
    public Distance add(Distance otherDistance) {
        int newFeet = this.feet + otherDistance.feet;
        double newInches = this.inches + otherDistance.inches;

        if (newInches >= 12) {
            newInches -= 12;
            newFeet++;
        }

        return new Distance(newFeet, newInches);
    }

    public static void main(String[] args) {
        // Create two initialized Distance objects
        Distance distance1 = new Distance(5, 6.5);
        Distance distance2 = new Distance(3, 8.25);

        // Create one uninitialized Distance object (initialized to 0)
        Distance distance3 = new Distance();

        // Add the two initialized values together
        Distance result = distance1.add(distance2);

        // Display the values
        System.out.println("Distance 1: ");
        distance1.displayDistance();
        System.out.println("Distance 2: ");
        distance2.displayDistance();
        System.out.println("Distance 3 (initialized to 0): ");
        distance3.displayDistance();
        System.out.println("Result of adding Distance 1 and Distance 2: ");
        result.displayDistance();
    }
}
