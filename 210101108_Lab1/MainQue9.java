import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.*;
class PrimeCalculator implements Runnable {
    private final int startRange;
    private final int endRange;
    private final long[] result;

    public PrimeCalculator(int startRange, int endRange, long[] result) {
        this.startRange = startRange;
        this.endRange = endRange;
        this.result = result;
    }

    @Override
    public void run() {
        long threadSum = 0;

        for (int num = startRange; num <= endRange; num++) {
            if (isPrime(num)) {
                threadSum += num;
                System.out.println(Thread.currentThread().getName() + ": Found prime number " + num);
            }
        }

        synchronized (result) {
            result[0] += threadSum;
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}

public class MainQue9 {
    public static void main(String[] args) {
        // Declare the variables
        int num;
 
        // Input the integer
        System.out.println("Enter the integer: ");
 
        // Create Scanner object
        Scanner s = new Scanner(System.in);
         
        // Read the next integer from the screen
        num = s.nextInt();
        int limit = num; // Set your desired limit
        int numThreads = 4; // Set the number of threads

        long[] result = {0}; // Shared result array to store the sum

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        int numbersPerThread = limit / numThreads;
        int startRange, endRange;

        for (int i = 0; i < numThreads; i++) {
            startRange = i * numbersPerThread + 1;
            endRange = (i == numThreads - 1) ? limit : (i + 1) * numbersPerThread;
            executorService.execute(new PrimeCalculator(startRange, endRange, result));
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {
            // Wait for all threads to finish
        }

        System.out.println("Sum of prime numbers up to " + limit + ": " + result[0]);
        s.close();
    }
}
