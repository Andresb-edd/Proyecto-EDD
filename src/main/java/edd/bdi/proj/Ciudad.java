package edd.bdi.proj;

/**
 * Clase que representa una ciudad en la red de transporte.
 * Contiene una lista de líneas de transporte y métodos para manipular dicha lista.
 */
public class Ciudad {

    private String nombre;
    private int id;
    private NodoDeListas lFirst;
    private NodoDeListas lLast;
    private int size;
    private int t;
    private Grafo grafo;


    /**
     * Constructor de la clase Ciudad.
     * Inicializa la ciudad con un nombre, un id y una lista vacía de líneas de transporte.
     *
     * @param nombre el nombre de la ciudad.
     * @param id el identificador de la ciudad.
     */
    public Ciudad(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.lFirst = null;
        this.lLast = null;
        this.size = 0;
        this.grafo = new Grafo(100, false);
        this.t = 1;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    /**
     * Obtiene el nombre de la ciudad.
     *
     * @return el nombre de la ciudad.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la ciudad.
     *
     * @param nombre el nombre a establecer para la ciudad.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador de la ciudad.
     *
     * @return el identificador de la ciudad.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador de la ciudad.
     *
     * @param id el identificador a establecer para la ciudad.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el primer nodo de la lista de líneas de transporte.
     *
     * @return el primer nodo de la lista de líneas de transporte.
     */
    public NodoDeListas getlFirst() {
        return lFirst;
    }

    /**
     * Establece el primer nodo de la lista de líneas de transporte.
     *
     * @param lFirst el nodo a establecer como primero en la lista.
     */
    public void setlFirst(NodoDeListas lFirst) {
        this.lFirst = lFirst;
    }

    /**
     * Obtiene el último nodo de la lista de líneas de transporte.
     *
     * @return el último nodo de la lista de líneas de transporte.
     */
    public NodoDeListas getlLast() {
        return lLast;
    }

    /**
     * Establece el último nodo de la lista de líneas de transporte.
     *
     * @param lLast el nodo a establecer como último en la lista.
     */
    public void setlLast(NodoDeListas lLast) {
        this.lLast = lLast;
    }

    /**
     * Obtiene el tamaño de la lista de líneas de transporte.
     *
     * @return el tamaño de la lista de líneas de transporte.
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño de la lista de líneas de transporte.
     *
     * @param size el tamaño a establecer para la lista de líneas de transporte.
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    
    /**
     * @return the t
     */
    public int getT() {
        return t;
        }

    /**
     * Establece el valor de t para la ciudad.
     *
     * @param t el valor de t a establecer.
     */
    public void setT(int t) {
        this.t = t;
    }

    /**
     * Verifica si la lista de líneas de transporte está vacía.
     *
     * @return true si la lista está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return getlFirst() == null;
    }

    /**
     * Inserta una nueva línea de transporte en la lista.
     *
     * @param dataLinea la línea de transporte a insertar en la lista.
     */
    public void insert_Linea(Linea dataLinea) {
        NodoDeListas newNodo = new NodoDeListas(dataLinea);
        if (isEmpty()) {
            setlFirst(newNodo);
            setlLast(newNodo);
        } else {
            getlLast().setpNext(newNodo);
            newNodo.setpBefore(getlLast());
            setlLast(newNodo);
        }
        setSize(getSize() + 1);
        updateGrafo(dataLinea);
    }
    private void updateGrafo(Linea linea) {
        for (NodoDeListas current = linea.getpFirst(); current != null; current = current.getpNext()) {
            Parada parada = (Parada) current.getDataParada();
            ListaAdyacentes listaAdyacentes = new ListaAdyacentes(parada);

            if (current.getpBefore() != null) {
                listaAdyacentes.insert_Parada((Parada) current.getpBefore().getDataParada());
            }
            if (current.getpNext() != null) {
                listaAdyacentes.insert_Parada((Parada) current.getpNext().getDataParada());
            }
            if (parada.getNombre().contains(":")) {
                String[] parts = parada.getNombre().split(":");
                String key = parts[0].trim();
                String value = parts[1].trim();
                Parada adjParada = new Parada(value);
                listaAdyacentes.insert_Parada(adjParada);

            }
            grafo.addListaAdyacentes(listaAdyacentes);
        }
    }

}