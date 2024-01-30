/*Universidad del Valle de Guatemala
 * Hoja de trabajo #3 - Algoritmos y Estructura de Datos
 * Juan Cruz - 23110 | Roberto Barreda - 23354
 */

public class VlastnýZásobník<T> {
    private Uzol<T> vrch;

    public VlastnýZásobník() {
        this.vrch = null;
    }

    public boolean jePrazdny() {
        return vrch == null;
    }

    public void vlož(T data) {
        Uzol<T> novýUzol = new Uzol<>(data);
        novýUzol.setNext(vrch);
        vrch = novýUzol;
    }

    public T vyber() {
        if (jePrazdny()) {
            throw new IllegalStateException("Zásobník je prázdny");
        }
        T data = vrch.getData();
        vrch = vrch.getNext();
        return data;
    }

    public T vrchol() {
        if (jePrazdny()) {
            throw new IllegalStateException("Zásobník je prázdny");
        }
        return vrch.getData();
    }
}


