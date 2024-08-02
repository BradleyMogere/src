import java.util.Random;

public class MergeSort {

    private static long startTime;
    private static int totalElements;
    private static boolean[] checkpointsReached = new boolean[4];

    public static void main(String[] args) {
        int size = 100000;
        totalElements = size;
        int[] array = generateRandomNumbers(size);

        // Start time
        startTime = System.currentTimeMillis();

        mergeSort(array, 0, array.length - 1);

        // End time
        long endTime = System.currentTimeMillis();

        // Print sorted array
        System.out.println("Sorted numbers: ");
        printArray(array);

        // Calculate duration
        long elapsedTime = endTime - startTime;
        System.out.println("Time taken to sort the array: " + elapsedTime + " milliseconds");
    }

    // Generates an array of random integers.
    private static int[] generateRandomNumbers(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }

    // Sorts an array of integers using the Merge Sort algorithm.
    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);

            // Calculate and print the elapsed time at different stages of sorting
            printElapsedTime(left, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = array[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Prints the elements in the array
    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            if (i % 10000 == 9999) {
                System.out.println();
            }
        }
        System.out.println();
    }

    // Prints the elapsed time at different stages of sorting
    private static void printElapsedTime(int left, int right) {
        int sortedElements = right - left + 1;
        int percentage = (sortedElements * 100) / totalElements;

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
