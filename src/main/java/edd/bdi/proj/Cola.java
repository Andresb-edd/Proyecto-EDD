package edd.bdi.proj;

public class Cola {
    private NodoDeListas cabeza;
    private NodoDeListas ultimo;

    public Cola() {
        this.cabeza = null;
        this.ultimo = null;
    }
    public boolean isEmpty() {
        return cabeza == null;
    }
    public void encolar(NodoDeListas parada) {
        if (isEmpty()) {
            this.cabeza = this.ultimo = parada;
        } else {
            this.ultimo.setpNext(parada);
            this.ultimo = this.ultimo.getpNext();
        }
    }

    public NodoDeListas desencolar() {
        if (isEmpty()) {
            System.out.println("La cola Esta vacia");
            return null;
        } else {
            NodoDeListas cabeza_t = this.cabeza;
            this.cabeza = cabeza.getpNext();
            if (this.cabeza == null) {
                this.ultimo = null;
            }
            return cabeza_t;
        }
    }

}
