import java.util.Random;

public class GeneratorNahodnychCisel {
    public int[] generateNumbers(int amount) {
        Random random = new Random();
        int[] numbers = new int[amount];
        for (int i = 0; i < amount; i++) {
            numbers[i] = 1 + random.nextInt(3000);
        }
        return numbers;
    }
}