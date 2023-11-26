public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    // Constructor to initialize to 0
    public Time() {
        this(0, 0, 0);
    }

    // Constructor to initialize to fixed values
    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    // Display the time in 11:59:59 format
    public void displayTime() {
        System.out.printf("%02d:%02d:%02d\n", hours, minutes, seconds);
    }

    // Add two Time objects and return a new Time object
    public Time add(Time otherTime) {
        int newHours = this.hours + otherTime.hours;
        int newMinutes = this.minutes + otherTime.minutes;
        int newSeconds = this.seconds + otherTime.seconds;

        // Handle overflow and adjust the time
        if (newSeconds >= 60) {
            newSeconds -= 60;
            newMinutes++;
        }
        if (newMinutes >= 60) {
            newMinutes -= 60;
            newHours++;
        }

        return new Time(newHours, newMinutes, newSeconds);
    }

    public static void main(String[] args) {
        // Create two initialized Time objects
        Time time1 = new Time(10, 30, 45);
        Time time2 = new Time(2, 45, 14);

        // Create one uninitialized Time object (initialized to 0)
        Time time3 = new Time();

        // Add the two initialized values together
        Time result = time1.add(time2);

        // Display the result
        System.out.print("Time 1: ");
        time1.displayTime();
        System.out.print("Time 2: ");
        time2.displayTime();
        System.out.print("Time 3 (initialized to 0): ");
        time3.displayTime();
        System.out.print("Result of adding Time 1 and Time 2: ");
        result.displayTime();
    }
}
