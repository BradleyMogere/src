import java.util.Random;

public class QuickSort {

    private static long startTime;
    private static int totalElements;
    private static boolean[] checkpointsReached = new boolean[4];

    // Main method to test the QuickSort algorithm.
    public static void main(String[] args) {
        int size = 100000;
        totalElements = size;
        int[] array = generateRandomNumbers(size);

        // Start time
        startTime = System.currentTimeMillis();

        quickSort(array, 0, array.length - 1);

        // End time
        long endTime = System.currentTimeMillis();

        System.out.println("Sorted numbers in ascending order: ");
        printArray(array);

        // Calculate total duration
        long elapsedTime = endTime - startTime;
        System.out.println("Total time taken to sort the array: " + elapsedTime + " milliseconds");
    }

    // Generates an array of random integers of a given size.
    private static int[] generateRandomNumbers(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }

    // Sorts the generated array of integers using the QuickSort algorithm.
    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            // Calculate and print the elapsed time at different stages of sorting
            printElapsedTime(array);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            // If current element is <= to pivot, swap array[i] and array[j]
            if (array[j] <= pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i+1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    // Prints the sorted elements of the array
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
    private static void printElapsedTime(int[] array) {
        int sortedCount = countSortedElements(array);
        int percentage = (sortedCount * 100) / totalElements;

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

    // Counts the number of elements that are in their correct position
    private static int countSortedElements(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}