package edd.bdi.proj;

/**
 * Clase que representa una cola de nodos de listas.
 * Permite encolar y desencolar nodos.
 */
public class Cola {
    private NodoDeListas cabeza;
    private NodoDeListas ultimo;

    /**
     * Constructor de la clase Cola.
     * Inicializa una cola vacía.
     */
    public Cola() {
        this.cabeza = null;
        this.ultimo = null;
    }

    /**
     * Verifica si la cola está vacía.
     *
     * @return true si la cola está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return cabeza == null;
    }

    /**
     * Encola un nodo en la cola.
     *
     * @param parada el nodo a encolar.
     */
    public void encolar(NodoDeListas parada) {
        if (isEmpty()) {
            this.cabeza = this.ultimo = parada;
        } else {
            this.ultimo.setpNext(parada);
            this.ultimo = this.ultimo.getpNext();
        }
    }

    /**
     * Desencola un nodo de la cola.
     *
     * @return el nodo desencolado, o null si la cola está vacía.
     */
    public NodoDeListas desencolar() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
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