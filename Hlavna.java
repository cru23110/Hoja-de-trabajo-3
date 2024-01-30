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

        // Recordar: GoldenTicket.txt
        try (PrintWriter writer = new PrintWriter(new File("GoldenTicket.txt"))) {
            for (int number : numbers) {
                writer.println(number);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while trying to write to the file.");
            e.printStackTrace();
        }

        // El sorteo de los gnomos
        long startTimeGnomeSort = System.currentTimeMillis();
        AlgoritmyTriediena.gnomeSort(numbers, amount);
        long endTimeGnomeSort = System.currentTimeMillis();
        GrafickyPloter.generarCSV("GnomeSort", amount, endTimeGnomeSort - startTimeGnomeSort);

        // Merengue de ordenamiento
        long startTimeMergeSort = System.currentTimeMillis();
        AlgoritmyTriediena.mergeSort(numbers, 0, numbers.length - 1);
        long endTimeMergeSort = System.currentTimeMillis();
        GrafickyPloter.generarCSV("MergeSort", amount, endTimeMergeSort - startTimeMergeSort);

        // Rapidos y furiosos
        long startTimeQuickSort = System.currentTimeMillis();
        AlgoritmyTriediena.quickSort(numbers, 0, numbers.length - 1);
        long endTimeQuickSort = System.currentTimeMillis();
        GrafickyPloter.generarCSV("QuickSort", amount, endTimeQuickSort - startTimeQuickSort);

        // Un sorteo de rabanos
        long startTimeRadixSort = System.currentTimeMillis();
        AlgoritmyTriediena.radixsort(numbers, numbers.length);
        long endTimeRadixSort = System.currentTimeMillis();
        GrafickyPloter.generarCSV("RadixSort", amount, endTimeRadixSort - startTimeRadixSort);

        // Picky eater
        long startTimeSelectionSort = System.currentTimeMillis();
        AlgoritmyTriediena.selectionSort(numbers);
        long endTimeSelectionSort = System.currentTimeMillis();
        GrafickyPloter.generarCSV("SelectionSort", amount, endTimeSelectionSort - startTimeSelectionSort);

        // Guardar en resultados.txt
        ObsluznyProgramSuboru.writeNumbersToFile("resultados.txt", numbers);
    }
}
