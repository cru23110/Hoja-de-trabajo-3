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
            throw new IllegalStateException("La bandeja esta vacia");
        }
        T data = vrch.getData();
        vrch = vrch.getNext();
        return data;
    }

    public T vrchol() {
        if (jePrazdny()) {
            throw new IllegalStateException("La bandeja esta vacia");
        }
        return vrch.getData();
    }
}


