import java.util.Random;

public class SelectionSort {

    private static long startTime;
    private static int totalElements;
    private static boolean[] checkpointsReached = new boolean[4];

    // Main method to test the Selection Sort algorithm.
    public static void main(String[] args) {
        int size = 100000;
        totalElements = size;
        int[] array = generateRandomNumbers(size);

        // Start time
        startTime = System.currentTimeMillis();

        selectionSort(array);

        // End time
        long endTime = System.currentTimeMillis();

        System.out.println("Sorted Numbers: ");
        printArray(array);

        // Calculate duration
        long elapsedTime = endTime - startTime;
        System.out.println("Time taken to sort the array: " + elapsedTime + " milliseconds");
    }

    // Generating an array of random integers.
    private static int[] generateRandomNumbers(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }

    // Sort the generated array of integers using the Selection Sort algorithm.
    private static void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;

            // Calculate and print the elapsed time at different stages of sorting
            printElapsedTime(array, i + 1);
        }
    }

    // Prints the elements of the array
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
    private static void printElapsedTime(int[] array, int currentIndex) {
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

