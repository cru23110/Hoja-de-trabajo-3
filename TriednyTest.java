import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriednyTest {
    @Test
    public void testGnomeSort() {
        int[] array = {4, 2, 7, 1, 9, 3};
        AlgoritmyTriediena.gnomeSort(array, array.length);
        assertArrayEquals(new int[]{1, 2, 3, 4, 7, 9}, array);
    }

    @Test
    public void testMergeSort() {
        int[] array = {9, 3, 6, 1, 8, 2, 5};
        AlgoritmyTriediena.mergeSort(array, 0, array.length - 1);
        assertArrayEquals(new int[]{1, 2, 3, 5, 6, 8, 9}, array);
    }

    @Test
    public void testQuickSort() {
        int[] array = {7, 2, 5, 1, 8, 3, 6};
        AlgoritmyTriediena.quickSort(array, 0, array.length - 1);
        assertArrayEquals(new int[]{1, 2, 3, 5, 6, 7, 8}, array);
    }

    @Test
    public void testRadixSort() {
        int[] array = {123, 456, 789, 321, 654, 987, 1234};
        AlgoritmyTriediena.radixsort(array, array.length);
        assertArrayEquals(new int[]{123, 321, 456, 654, 789, 987, 1234}, array);
    }

    @Test
    public void testSelectionSort() {
        int[] array = {5, 2, 8, 1, 6, 3, 7};
        AlgoritmyTriediena.selectionSort(array);
        assertArrayEquals(new int[]{1, 2, 3, 5, 6, 7, 8}, array);
    }

    @Test
    public void testGenerateNumbers() {
        GeneratorNahodnychCisel generator = new GeneratorNahodnychCisel();
        int[] numbers = generator.generateNumbers(1000);
        assertEquals(1000, numbers.length);
        // ver que los números estén dentro del rango adecuado
        for (int number : numbers) {
            assertTrue(number >= 1 && number <= 3000);
        }
    }

}
