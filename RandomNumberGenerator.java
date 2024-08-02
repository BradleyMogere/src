import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomNumberGenerator {
    private int[] numbers;

    public RandomNumberGenerator(int size) {
        numbers = new int[size];
        generateNumbers();
    }

    private void generateNumbers() {
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100000); // Generate random numbers between 0 and 99999
        }
    }

    private void saveNumbersToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int number : numbers) {
                writer.write(number + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public int[] getNumbers() {
        return numbers;
    }

    public static void main(String[] args) {
        RandomNumberGenerator generator = new RandomNumberGenerator(100000);
        int[] randomNumbers = generator.getNumbers();

        // Example of using the random numbers:
        // Print the first 10 numbers
        for (int i = 0; i < 100000; i++) {
            System.out.println(randomNumbers[i]);
        }

        // Save the numbers to a file
        generator.saveNumbersToFile("random_numbers.txt");
    }
}
