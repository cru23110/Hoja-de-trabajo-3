import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GrafickyPloter {

    private static final String NOMBRE_ARCHIVO = "resultados.csv";

    public static void generarCSV(String algoritmo, int cantidadNumeros, long tiempo) {
        try {
            boolean existeArchivo = Files.exists(Paths.get(NOMBRE_ARCHIVO));

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
                // Si el archivo no existe, agregar encabezado
                if (!existeArchivo) {
                    writer.write("Algoritmo,Cantidad de Números,Tiempo\n");
                }

                // Escribir datos en el archivo
                writer.write(algoritmo + "," + cantidadNumeros + "," + tiempo + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
