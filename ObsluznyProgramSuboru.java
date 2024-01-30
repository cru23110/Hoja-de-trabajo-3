import java.io.*;
import java.util.*;

class ObsluznyProgramSuboru {

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
