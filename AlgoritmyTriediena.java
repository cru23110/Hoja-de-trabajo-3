/*Universidad del Valle de Guatemala
 * Hoja de trabajo #3 - Algoritmos y Estructura de Datos
 * Juan Cruz - 23110 | Roberto Barreda - 23354
 */

import java.util.*; 
public class AlgoritmyTriediena {


    
    /** 
     * @param arr[]
     * @param n
     */
    static void gnomeSort(int arr[], int n) 
    { 
        int index = 0; 
  
        while (index < n) { 
            if (index == 0) 
                index++; 
            if (arr[index] >= arr[index - 1]) 
                index++; 
            else { 
                int temp = 0; 
                temp = arr[index]; 
                arr[index] = arr[index - 1]; 
                arr[index - 1] = temp; 
                index--; 
            } 
        } 
        return; 
    }
    
    /** 
     * @param arr[]
     * @param l
     * @param r
     */
    static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }
    
    /** 
     * @param arr[]
     * @param l
     * @param m
     * @param r
     */
    static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    /** 
     * @param arr[]
     * @param low
     * @param high
     * @return int
     */
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high]; 
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    
    /** 
     * @param arr[]
     * @param low
     * @param high
     */
    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    /** 
     * @param arr[]
     * @param n
     * @param exp
     */
    static void countingSort(int arr[], int n, int exp) {
        int output[] = new int[n];
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }
    
    /** 
     * @param arr[]
     * @param n
     */
    static void radixsort(int arr[], int n) {
        int m = Arrays.stream(arr).max().getAsInt();

        for (int exp = 1; m / exp > 0; exp *= 10)
            countingSort(arr, n, exp);
    }
    
    /** 
     * @param arr[]
     */
    static void selectionSort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}
