/*Write a java program to find the sum of ‘N’ numbers.*/

import java.util.*;

public class EXJ_4{


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int N = sc.nextInt();

        int sum = 0;

        for (int i = 1; i <= N; i++) {
            sum += i;
        }


        System.out.println("Sum of the first " + N + " numbers is: " + sum);

    }
}