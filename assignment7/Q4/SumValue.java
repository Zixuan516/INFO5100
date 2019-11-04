package assignment7.Q4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumValue {

    /*generate array of random numbers*/
    static void generateRandomArray(int[] arr){
        Random rand = new Random();
        int upperBound = arr.length;
        for(int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(upperBound);
        }
    }

    /*get sum of an array using 4 threads*/
    static long sum(int[] arr){
        int numOfThreads = 4;
        ExecutorService threadpool = Executors.newFixedThreadPool(numOfThreads);
        try {
            List<Future<Long>> futures = new ArrayList<>();
            for (int i = 0; i < numOfThreads; i++) {
                final int time = i;
                Future<Long> f = threadpool.submit(() -> {
                    long sum = 0;
                    for (int j = time * 1000000; j < (time + 1) * 1000000; j++) {
                        sum = sum + arr[j];
                    }
                    return sum;
                });
                futures.add(f);
            }

            long totalSum = 0;
            for (Future<Long> future : futures) {
                totalSum += future.get();
            }

            return totalSum;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            threadpool.shutdown();
        }
    }

    public static void main(String[] args){
        int[] arr = new int[4000000];
        generateRandomArray(arr);
        long sum = sum(arr);
        System.out.println("Sum: " + sum);
    }
}
