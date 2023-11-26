/*Write a java program to find the following pattern:

 *
 * *
 * * *
 * * * *

 */

public class EXJ_5{
    public static void main(String[] args) {
        int n = 4; 

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}


