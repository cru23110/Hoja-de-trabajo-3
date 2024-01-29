import java.util.Arrays;

public class TesterProgramov {

    public static long medirTiempo(Runnable codigo) {
        long inicio = System.currentTimeMillis();
        codigo.run();
        long fin = System.currentTimeMillis();
        return fin - inicio;
    }
}


