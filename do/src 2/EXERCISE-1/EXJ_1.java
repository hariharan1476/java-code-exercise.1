                     
import java.util.*;

public class EXJ_1 
{

    public static void main(String[] args) {
        Scanner A = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = A.nextInt();

        if (age>=18) {
            System.out.println("You are eligible to cast your vote.");
        } else {
            System.out.println("You are not eligible to cast your vote.");
        }

    }
}

    