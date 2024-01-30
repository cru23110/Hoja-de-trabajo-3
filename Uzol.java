/*Universidad del Valle de Guatemala
 * Hoja de trabajo #3 - Algoritmos y Estructura de Datos
 * Juan Cruz - 23110 | Roberto Barreda - 23354
 */

public class Uzol<T> {
    private T data;
    private Uzol<T> next;

    public Uzol(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Uzol<T> getNext() {
        return next;
    }

    public void setNext(Uzol<T> next) {
        this.next = next;
    }
}
