/*Universidad del Valle de Guatemala
 * Hoja de trabajo #3 - Algoritmos y Estructura de Datos
 * Juan Cruz - 23110 | Roberto Barreda - 23354
 */

import java.util.Random;
class GeneratorNahodnychCisel {
    
    /** 
     * @param amount
     * @return int[]
     */
    public int[] generateNumbers(int amount) {
        Random random = new Random();
        int[] numbers = new int[amount];
        for (int i = 0; i < amount; i++) {
            numbers[i] = 1 + random.nextInt(3000);
        }
        return numbers;
    }
}