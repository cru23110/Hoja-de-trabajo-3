/*Universidad del Valle de Guatemala
 * Hoja de trabajo #3 - Algoritmos y Estructura de Datos
 * Juan Cruz - 23110 | Roberto Barreda - 23354
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;

public class GrafickyPloter {

    private static final String NOMBRE_ARCHIVO = "resultados.csv";

    public static void generarCSV(String algoritmo, int cantidadNumeros, long tiempo) {
        double complejidadTeorica = obtenerComplejidadTeorica(algoritmo, cantidadNumeros);

        try {
            boolean existeArchivo = Files.exists(Paths.get(NOMBRE_ARCHIVO));

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
                // Si el archivo no existe, agregar encabezado
                if (!existeArchivo) {
                    writer.write("Algoritmo,Cantidad de Números,Tiempo,Complejidad Teórica\n");
                }

                // Escribir datos en el archivo
                writer.write(algoritmo + "," + cantidadNumeros + "," + tiempo + "," + complejidadTeorica + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static double obtenerComplejidadTeorica(String algoritmo, int cantidadNumeros) {
        switch (algoritmo) {
            case "GnomeSort":
                return redondear(calcularComplejidadGnomeSort(cantidadNumeros));
            case "MergeSort":
                return redondear(calcularComplejidadMergeSort(cantidadNumeros));
            case "QuickSort":
                return redondear(calcularComplejidadQuickSort(cantidadNumeros));
            case "RadixSort":
                return redondear(calcularComplejidadRadixSort(cantidadNumeros));
            case "SelectionSort":
                return redondear(calcularComplejidadSelectionSort(cantidadNumeros));
            default:
                return -1; // Valor para indicar que la complejidad no está especificada
        }
    }

    private static double redondear(double valor) {
        DecimalFormat formato = new DecimalFormat("#.##");
        return Double.parseDouble(formato.format(valor));
    }

    private static double calcularComplejidadGnomeSort(int n) {
        // Fórmula de la complejidad de Gnome Sort: O(n^2)
        return Math.pow(n, 2);
    }

    private static double calcularComplejidadMergeSort(int n) {
        // Fórmula de la complejidad de Merge Sort: O(n log n)
        return n * Math.log(n);
    }

    private static double calcularComplejidadQuickSort(int n) {
        // Fórmula de la complejidad de Quick Sort: O(n^2) en el peor caso, O(n log n) en el caso promedio
        return Math.pow(n, 2); // En el peor caso
    }

    private static double calcularComplejidadRadixSort(int n) {
        // Fórmula de la complejidad de Radix Sort: O(kn), donde k es el número de dígitos
        // Suponiendo el peor caso de k = log10(n)
        return Math.log10(n) * n;
    }

    private static double calcularComplejidadSelectionSort(int n) {
        // Fórmula de la complejidad de Selection Sort: O(n^2)
        return Math.pow(n, 2);
    }
}
