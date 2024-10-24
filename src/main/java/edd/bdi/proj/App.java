package edd.bdi.proj;

/**
 * Clase que representa la aplicación principal para la gestión de la red de
 * transporte. Contiene una lista de ciudades y métodos para manipular dicha
 * lista.
 *
 */
public class App {

    private NodoDeListas cFirst;
    private NodoDeListas cLast;
    private int size;

    /**
     * Constructor de la clase App. Inicializa la lista de ciudades como vacía.
     */
    public App() {
        this.cFirst = null;
        this.cLast = null;
        this.size = 0;
    }

    /**
     * Obtiene el primer nodo de la lista de ciudades.
     *
     * @return el primer nodo de la lista de ciudades.
     */
    public NodoDeListas getcFirst() {
        return cFirst;
    }

    /**
     * Establece el primer nodo de la lista de ciudades.
     *
     * @param cFirst el nodo a establecer como primero en la lista.
     */
    public void setcFirst(NodoDeListas cFirst) {
        this.cFirst = cFirst;
    }

    /**
     * Obtiene el último nodo de la lista de ciudades.
     *
     * @return el último nodo de la lista de ciudades.
     */
    public NodoDeListas getcLast() {
        return cLast;
    }

    /**
     * Establece el último nodo de la lista de ciudades.
     *
     * @param cLast el nodo a establecer como último en la lista.
     */
    public void setcLast(NodoDeListas cLast) {
        this.cLast = cLast;
    }

    /**
     * Obtiene el tamaño de la lista de ciudades.
     *
     * @return el tamaño de la lista de ciudades.
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño de la lista de ciudades.
     *
     * @param size el tamaño a establecer para la lista de ciudades.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Verifica si la lista de ciudades está vacía.
     *
     * @return true si la lista está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return getcFirst() == null;
    }

    /**
     * Inserta una nueva ciudad en la lista. Si la ciudad ya existe, se
     * actualiza.
     *
     * @param dataCiudad la ciudad a insertar o actualizar en la lista.
     */
    public void insert_Ciudad(Ciudad dataCiudad) {
        boolean bool = true;

        if (isEmpty()) {
            size++;
            dataCiudad.setId(size);
            NodoDeListas newNodo = new NodoDeListas(dataCiudad);
            cFirst = newNodo;
            cLast = newNodo;
            bool = false;
            return;
        }
        NodoDeListas current = cFirst;
        while (current != null) {
            Ciudad ciudadExistente = (Ciudad) current.getDataCiudad();
            if (ciudadExistente.getNombre().equals(dataCiudad.getNombre())) {
                dataCiudad.setId(ciudadExistente.getId());
                NodoDeListas newNodo = new NodoDeListas(dataCiudad);
                bool = false;
                if (current.getpBefore() != null) {
                    current.getpBefore().setpNext(newNodo);
                    newNodo.setpBefore(current.getpBefore());
                } else {
                    cFirst = newNodo;
                    cFirst.setpNext(current.getpNext());
                }
                if (current.getpNext() != null) {
                    current.getpNext().setpBefore(newNodo);
                } else {
                    cLast = newNodo;
                    cLast.setpBefore(current.getpBefore());
                }
                break;
            }
            current = current.getpNext();
        }
        if (bool) {
            size++;
            dataCiudad.setId(size);
            NodoDeListas newNodo = new NodoDeListas(dataCiudad);
            cLast.setpNext(newNodo);
            newNodo.setpBefore(cLast);
            cLast = newNodo;
        }

    }

    /**
     * Busca una ciudad en la lista de ciudades por su nombre.
     *
     * @param nombre el nombre de la ciudad a buscar.
     * @return la ciudad encontrada, o null si no se encuentra ninguna ciudad con ese nombre.
     */
    public Ciudad buscar_ciudad(String nombre) {
        NodoDeListas temp = getcFirst();
        if (isEmpty()) {
            System.out.println("Ciudad no encontrada");
        }
        while (temp != null) {
            if (temp.getDataCiudad().getNombre().equals(nombre)) {
                return temp.getDataCiudad();
            }
            temp = temp.getpNext();
        }
        return null;
    }

}
