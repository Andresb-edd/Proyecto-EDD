package edd.bdi.proj;

/**
 * Clase que representa una línea de transporte en la red.
 * Contiene una lista de paradas y métodos para manipular dicha lista.
 */
public class Linea {

    private String nombre;
    private int id;
    private NodoDeListas pFirst;
    private NodoDeListas pLast;
    private int size;

    /**
     * Constructor de la clase Linea.
     * Inicializa la línea con un nombre y un tamaño.
     *
     * @param nombre el nombre de la línea.
     * @param size el tamaño de la línea.
     */
    public Linea(String nombre, int size) {
        this.pFirst = null;
        this.pLast = null;
        this.nombre = nombre;
        this.id = id;
        this.size = 0;
    }

    /**
     * Obtiene el primer nodo de la lista de paradas.
     *
     * @return el primer nodo de la lista de paradas.
     */
    public NodoDeListas getpFirst() {
        return pFirst;
    }

    /**
     * Establece el primer nodo de la lista de paradas.
     *
     * @param pFirst el nodo a establecer como primero en la lista.
     */
    public void setpFirst(NodoDeListas pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * Obtiene el último nodo de la lista de paradas.
     *
     * @return el último nodo de la lista de paradas.
     */
    public NodoDeListas getpLast() {
        return pLast;
    }

    /**
     * Establece el último nodo de la lista de paradas.
     *
     * @param pLast el nodo a establecer como último en la lista.
     */
    public void setpLast(NodoDeListas pLast) {
        this.pLast = pLast;
    }

    /**
     * Obtiene el tamaño de la lista de paradas.
     *
     * @return el tamaño de la lista de paradas.
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño de la lista de paradas.
     *
     * @param size el tamaño a establecer para la lista de paradas.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Verifica si la lista de paradas está vacía.
     *
     * @return true si la lista está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return getpFirst() == null;
    }

    /**
     * Inserta una nueva parada en la lista.
     *
     * @param dataParada la parada a insertar en la lista.
     */
    public void insert_Parada(Parada dataParada) {
        NodoDeListas newNodo = new NodoDeListas(dataParada);
        if (isEmpty()) {
            setpFirst(newNodo);
            setpLast(newNodo);
        } else {
            getpLast().setpNext(newNodo);
            newNodo.setpBefore(getpLast());
            setpLast(newNodo);
        }
        setSize(getSize() + 1);
    }
}