/*Universidad del Valle de Guatemala
 * Hoja de trabajo #3 - Algoritmos y Estructura de Datos
 * Juan Cruz - 23110 | Roberto Barreda - 23354
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Hlavna {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ingresar la cantidad de números a generar
        System.out.println("Enter the amount of numbers to generate:");
        int amount = scanner.nextInt();

        // Generar números aleatorios
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
        // Instanciar el profiler
        TesterProgramov profiler = new TesterProgramov();

        while (true) {
            // Seleccionar algoritmo de ordenamiento
            System.out.println("Choose sorting algorithm:");
            System.out.println("1. Gnome Sort");
            System.out.println("2. Merge Sort");
            System.out.println("3. Quick Sort");
            System.out.println("4. Radix Sort");
            System.out.println("5. Selection Sort");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Exiting the program.");
                break;
            }

            long startTime = System.nanoTime();

            switch (choice) {
                case 0 :
                    System.out.println("Exiting the program.");
                    break;
                case 1: // El sorteo de los gnomos
                    AlgoritmyTriediena.gnomeSort(numbers, amount);
                    GrafickyPloter.generarCSV("GnomeSort", amount, System.nanoTime() - startTime);
                    break;
                case 2: // Merengue de ordenamiento
                    AlgoritmyTriediena.mergeSort(numbers, 0, numbers.length - 1);
                    GrafickyPloter.generarCSV("MergeSort", amount, System.nanoTime() - startTime);
                    break;
                case 3: // Rapidos y furiosos
                    AlgoritmyTriediena.quickSort(numbers, 0, numbers.length - 1);
                    GrafickyPloter.generarCSV("QuickSort", amount, System.nanoTime() - startTime);
                    break;
                case 4: // Un sorteo de rabanos
                    AlgoritmyTriediena.radixsort(numbers, numbers.length);
                    GrafickyPloter.generarCSV("RadixSort", amount, System.nanoTime() - startTime);
                    break;
                case 5: // Picky eater
                    AlgoritmyTriediena.selectionSort(numbers);
                    GrafickyPloter.generarCSV("SelectionSort", amount, System.nanoTime() - startTime);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid sorting algorithm.");
                    break;
            }
            // Guardar en resultados.txt
            ObsluznyProgramSuboru.writeNumbersToFile("resultados.txt", numbers);
        }
    }
}