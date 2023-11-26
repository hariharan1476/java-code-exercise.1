public class EXJ_2_2{
    public static void main(String[] args) {
        int n = 100;
        boolean[] isPrime = new boolean[n + 1];

        // Step 1: Fill an array num [100] with numbers from 1 to 100
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // Step 2 to Step 4: Set multiples of non-zero elements to zero
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        // Step 5: Print out the prime numbers
        System.out.println("Prime numbers from 1 to 100 are:");
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
