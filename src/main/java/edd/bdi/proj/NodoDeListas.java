package edd.bdi.proj;

/**
 * Clase que representa un nodo en una lista doblemente enlazada.
 * Puede contener datos de una parada, una ciudad o una línea de transporte.
 */
public class NodoDeListas {
    
    private NodoDeListas pNext;
    private NodoDeListas pBefore;
    private Parada dataParada;
    private Ciudad dataCiudad;
    private Linea dataLinea;
    private Sucursal dataSucursal;

    /**
     * Constructor que inicializa un nodo con datos de una parada.
     *
     * @param dataParada los datos de la parada a almacenar en el nodo.
     */
    public NodoDeListas(Parada dataParada) {
        this.pNext = null;
        this.pBefore = null;
        this.dataParada = dataParada;
    }

    /**
     * Constructor que inicializa un nodo con datos de una ciudad.
     *
     * @param dataCiudad los datos de la ciudad a almacenar en el nodo.
     */
    public NodoDeListas(Ciudad dataCiudad) {
        this.pNext = null;
        this.pBefore = null;
        this.dataCiudad = dataCiudad;
    }
    /**
     * Constructor que inicializa un nodo con datos de una línea de transporte.
     *
     * @param dataLinea los datos de la línea a almacenar en el nodo.
     */
    public NodoDeListas(Linea dataLinea) {
        this.pNext = null;
        this.pBefore = null;
        this.dataLinea = dataLinea;
    }
    
    /**
     * Constructor que inicializa un nodo con datos de una Sucursal.
     *
     * @param dataSucursal los datos de la línea a almacenar en el nodo.
     */
    public NodoDeListas(Sucursal dataSucursal) {
        this.pNext = null;
        this.pBefore = null;
        this.dataSucursal = dataSucursal;
    }
    
    

    /**
     * Obtiene el siguiente nodo en la lista.
     *
     * @return el siguiente nodo en la lista.
     */
    public NodoDeListas getpNext() {
        return pNext;
    }

    /**
     * Establece el siguiente nodo en la lista.
     *
     * @param pNext el nodo a establecer como siguiente en la lista.
     */
    public void setpNext(NodoDeListas pNext) {
        this.pNext = pNext;
    }

    /**
     * Obtiene el nodo anterior en la lista.
     *
     * @return el nodo anterior en la lista.
     */
    public NodoDeListas getpBefore() {
        return pBefore;
    }

    /**
     * Establece el nodo anterior en la lista.
     *
     * @param pBefore el nodo a establecer como anterior en la lista.
     */
    public void setpBefore(NodoDeListas pBefore) {
        this.pBefore = pBefore;
    }

    /**
     * Obtiene los datos de la parada almacenados en el nodo.
     *
     * @return los datos de la parada.
     */
    public Parada getDataParada() {
        return dataParada;
    }

    /**
     * Establece los datos de la parada en el nodo.
     *
     * @param dataParada los datos de la parada a establecer.
     */
    public void setDataParada(Parada dataParada) {
        this.dataParada = dataParada;
    }

    /**
     * Obtiene los datos de la ciudad almacenados en el nodo.
     *
     * @return los datos de la ciudad.
     */
    public Ciudad getDataCiudad() {
        return dataCiudad;
    }

    public Sucursal getDataSucursal() {
        return dataSucursal;
    }


    /**
     * Establece los datos de la ciudad en el nodo.
     *
     * @param dataCiudad los datos de la ciudad a establecer.
     */
    public void setDataCiudad(Ciudad dataCiudad) {
        this.dataCiudad = dataCiudad;
    }
}
