

/*Write a java program to find first 10 prime numbers from natural numbers.*/

public class EXJ_3{
    public static void main(String[] args) {
        int count = 0;
        int number = 2;

        System.out.println("First 10 prime numbers:");

        while (count < 10) {
            boolean isPrime = true;

            for (int i = 2; i*i <= number; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.print(number + " ");
                count++;
            }

            number++;
        }
    }
}
