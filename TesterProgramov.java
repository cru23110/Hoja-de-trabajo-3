/* Universidad del Valle de Guatemala
 * Hoja de trabajo #3 - Algoritmos y Estructura de Datos
 * Juan Cruz - 23110 | Roberto Barreda - 23354
 */

public class TesterProgramov {

    public static long medirTiempo(Runnable codigo) {
        long inicio = System.currentTimeMillis();
        codigo.run();
        long fin = System.currentTimeMillis();
        return fin - inicio;
    }
}


