import java.util.*;

public class VoteEligibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter their age
        System.out.print("Enter your age:");
        int age = scanner.nextInt();
        
        // Check if the candidate is eligible to vote
        if (age >= 18) {
            System.out.println("You are eligible to  vote.");
        } else {
            System.out.println("You are not eligible to vote");
        }
        
        scanner.close();
    }
}
