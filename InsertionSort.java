import java.util.Random;

public class InsertionSort {

    private static long startTime;
    private static int totalElements;
    private static boolean[] checkpointsReached = new boolean[4];

    public static void main(String[] args) {
        int size = 100000;
        totalElements = size;
        int[] array = generateRandomNumbers(size);

        // Saa Mwanzo/Start time
        startTime = System.currentTimeMillis();
        insertionSort(array);

        // Saa wa Mwisho/End time
        long endTime = System.currentTimeMillis();

        System.out.println("Your inserted numbers are: ");
        printArray(array);

        // Hesabu wa mda/Calculate duration
        long duration = endTime - startTime;
        System.out.println("Time taken to sort the array: " + duration + " milliseconds");
    }

    private static int[] generateRandomNumbers(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int n = 0; n < size; n++) {
            array[n] = random.nextInt(size);
        }
        return array;
    }

    private static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;

            // Not that good in swahili/Calculate and print the elapsed time at different stages of sorting
            printElapsedTime(i, n);
        }
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            if (i % 10000 == 9999) {
                System.out.println();
            }
        }
        System.out.println();
    }

    // Here I just gave up on the mother language :) /Prints the elapsed time at different stages of sorting
    private static void printElapsedTime(int currentIndex, int totalElements) {


        int percentage = (currentIndex * 100) / totalElements;

        if (percentage >= 25 && !checkpointsReached[0]) {
            checkpointsReached[0] = true;
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;
            System.out.println("Time taken to sort 25% of the array: " + elapsedTime + " milliseconds");
        } else if (percentage >= 50 && !checkpointsReached[1]) {
            checkpointsReached[1] = true;
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;
            System.out.println("Time taken to sort 50% of the array: " + elapsedTime + " milliseconds");
        } else if (percentage >= 75 && !checkpointsReached[2]) {
            checkpointsReached[2] = true;
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;
            System.out.println("Time taken to sort 75% of the array: " + elapsedTime + " milliseconds");
        } else if (percentage == 100 && !checkpointsReached[3]) {
            checkpointsReached[3] = true;
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;
            System.out.println("Time taken to sort 100% of the array: " + elapsedTime + " milliseconds");
        }
    }
}
