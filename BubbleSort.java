import java.util.Random;

public class BubbleSort {
    private static long startTime;
    private static int totalElements;
    private static boolean[] checkpointsReached = new boolean[4];

    // Like Gucci this is the Main method to test the Bubble Sort algorithm.
    public static void main(String[] args) {
        int size = 100000;
        totalElements = size;
        int[] array = generateRandomNumbers(size);

        // Beginning/Start time
        startTime = System.currentTimeMillis();

        bubbleSort(array);

        // Finish/End time
        long endTime = System.currentTimeMillis();

        System.out.println("Bubble sorted array: ");
        printArray(array);

        // Calculate duration, kuhesabu yani
        long elapsedTime = endTime - startTime;
        System.out.println("Time taken to sort the array: " + elapsedTime + " milliseconds");
    }

    // I am reall running out of quips but this is..
    // Generating an array of random integers.
    private static int[] generateRandomNumbers(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int k = 0; k < size; k++) {
            array[k] = random.nextInt(size);
        }
        return array;
    }

    // Insert funny quip here...
    //Sorting the array of integers in ascending order using the Bubble Sort algorithm.
    private static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // I'm done just read the comments >>>
            // Print elapsed time at different stages of sorting
            printElapsedTime(i, n);
            if (!swapped) break;
        }
    }

    // Prints the array of sorted integers.
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