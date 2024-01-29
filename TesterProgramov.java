import java.util.Arrays;

public class TesterProgramov {

    public static long medirTiempo(Runnable codigo) {
        long inicio = System.currentTimeMillis();
        codigo.run();
        long fin = System.currentTimeMillis();
        return fin - inicio;
    }

    public static void main(String[] args) {
        int[] arrayAleatorio = generarArrayAleatorio(1000);

        // Gnome Sort
        long tiempoGnomeSort = medirTiempo(() -> {
            AlgoritmyTriediena.gnomeSort(arrayAleatorio);
        });
        System.out.println("Tiempo de Gnome Sort: " + tiempoGnomeSort + " milisegundos");

        //Merge Sort
        long tiempoMergeSort = medirTiempo(() -> {
            AlgoritmyTriediena.mergeSort(arrayAleatorio);
        });
        System.out.println("Tiempo de Merge Sort: " + tiempoMergeSort + " milisegundos");

        // Quick Sort
        long tiempoQuickSort = medirTiempo(() -> {
            AlgoritmyTriediena.quickSort(arrayAleatorio);
        });
        System.out.println("Tiempo de Quick Sort: " + tiempoQuickSort + " milisegundos");

        //Radix Sort
        long tiempoRadixSort = medirTiempo(() -> {
            AlgoritmyTriediena.radixSort(arrayAleatorio);
        });
        System.out.println("Tiempo de Radix Sort: " + tiempoRadixSort + " milisegundos");
    }

    private static int[] generarArrayAleatorio(int cantidad) {
        int[] array = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            array[i] = (int) (Math.random() * 1000); // Números aleatorios entre 0 y 999 (ajusta según tus necesidades)
        }
        return array;
    }
}

