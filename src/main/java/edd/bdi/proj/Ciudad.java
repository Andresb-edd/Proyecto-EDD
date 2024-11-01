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
    private ListaDeSucursales listaSucursal;


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
        this.grafo = new Grafo(1000, false);
        this.t = 1;
    }

    /**
     * Obtiene el grafo de la ciudad.
     *
     * @return el grafo de la ciudad.
     */
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

    public ListaDeSucursales getListaSucursal() {
        return listaSucursal;
    }

    public void setListaSucursal(ListaDeSucursales listaSucursal) {
        this.listaSucursal = listaSucursal;
    }
    
    

    /**
     * Verifica si la lista de líneas de transporte está vacía.
     *
     * @return true si la lista está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return getlFirst() == null;
    }
    
        public boolean isLast_Empty() {
        return getlLast() == null;
    }

    /**
     * Inserta una nueva línea de transporte en la lista.
     *
     * @param dataLinea la línea de transporte a insertar en la lista.
     */
    public void insert_Linea(Linea dataLinea) {
        try {
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
        } catch (Exception e) {
            System.err.println("Error al insertar la línea: " + e.getMessage());
        }
    }


    /**
     * Actualiza el grafo de la ciudad con las paradas y sus adyacencias
     * basadas en la línea de transporte proporcionada.
     *
     * @param linea la línea de transporte que contiene las paradas a agregar al grafo.
     */
    public void updateGrafo(Linea linea) {
        try {
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
                boolean exists = false;

                for (int i = 0; i < grafo.listaAdy.length; i++) {
                    if (grafo.listaAdy[i] != null) {
                        if (grafo.listaAdy[i].getVertice().getNombre().equals(listaAdyacentes.getVertice().getNombre())) {
                            exists = true;
                            NodoDeListas currentAdy = listaAdyacentes.getpFirst();
                            while (currentAdy != null) {
                                boolean paradaExiste = false;
                                NodoDeListas nodoExistente = grafo.listaAdy[i].getpFirst();
                                while (nodoExistente != null) {
                                    if (nodoExistente.getDataParada().getNombre().equals(currentAdy.getDataParada().getNombre())) {
                                        paradaExiste = true;
                                        break;
                                    }
                                    nodoExistente = nodoExistente.getpNext();
                                }
                                if (!paradaExiste) {
                                    grafo.listaAdy[i].insert_Parada(currentAdy.getDataParada());
                                }
                                currentAdy = currentAdy.getpNext();
                            }
                            break;
                        }
                    }
                }
                if (!exists) {
                    grafo.addListaAdyacentes(listaAdyacentes);
                }
            }
        }
        catch (Exception e) {
            System.err.println("Error al actualizar el grafo: " + e.getMessage());
        }
    }

    /**
     * Busca una línea de transporte en la lista de líneas de la ciudad por su nombre.
     *
     * @param nombre_linea el nombre de la línea de transporte a buscar.
     * @return la línea de transporte encontrada, o null si no se encuentra ninguna línea con ese nombre.
     */
    public Linea buscar_Linea(String nombre_linea){

        NodoDeListas aux = getlFirst();

        if(isEmpty()){
            return null;
        }


        while(aux != null){

            if(aux.getDataLinea().getNombre().equals(nombre_linea)){
                return aux.getDataLinea();
            }
            aux = aux.getpNext();
        }
        return null;
    }


    /**
     * Inserta una nueva línea de transporte en la lista sin actualizar el grafo de la ciudad.
     *
     * @param dataLinea la línea de transporte a insertar en la lista.
     */
    public void insert_Linea_sinGrafo(Linea dataLinea) {
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
    }
}