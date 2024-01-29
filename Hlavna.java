import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Hlavna {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount of numbers to generate:");
        int amount = scanner.nextInt();

        GeneratorNahodnychCisel generator = new GeneratorNahodnychCisel();
        int[] numbers = generator.generateNumbers(amount);

        try (PrintWriter writer = new PrintWriter(new File("GoldenTicket.txt"))) {
            for (int number : numbers) {
                writer.println(number);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while trying to write to the file.");
            e.printStackTrace();
        }
    }
}
