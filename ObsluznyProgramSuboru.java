/* Universidad del Valle de Guatemala
 * Hoja de trabajo #3 - Algoritmos y Estructura de Datos
 * Juan Cruz - 23110 | Roberto Barreda - 23354
 */

import java.io.*;
import java.util.*;
class ObsluznyProgramSuboru {
    /** 
     * @param fileName
     * @return int[]
     */
    public static int[] readNumbersFromFile(String fileName) {
        List<Integer> numbersList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextInt()) {
                numbersList.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return numbersList.stream().mapToInt(Integer::intValue).toArray();
    }
    
    /** 
     * @param fileName
     * @param numbers
     */
    public static void writeNumbersToFile(String fileName, int[] numbers) {
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            for (int number : numbers) {
                writer.println(number);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
