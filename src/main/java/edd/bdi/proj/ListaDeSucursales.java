package edd.bdi.proj;

/**
 * Clase que representa una lista de sucursales.
 * Contiene métodos para manipular la lista de sucursales.
 */
public class ListaDeSucursales {

    private NodoDeListas sFirst;
    private NodoDeListas sLast;
    private int size;

    /**
     * Constructor de la clase ListaDeSucursales.
     * Inicializa la lista sin sucursales y con un tamaño de 0.
     */
    public ListaDeSucursales() {
        this.sFirst = null;
        this.sLast = null;
        this.size = 0;
    }

    /**
     * Obtiene el primer nodo en la lista de sucursales.
     *
     * @return el primer nodo en la lista de sucursales.
     */
    public NodoDeListas getsFirst() {
        return sFirst;
    }

    /**
     * Establece el primer nodo en la lista de sucursales.
     *
     * @param sFirst el nodo a establecer como primero en la lista.
     */
    public void setsFirst(NodoDeListas sFirst) {
        this.sFirst = sFirst;
    }

    /**
     * Obtiene el último nodo en la lista de sucursales.
     *
     * @return el último nodo en la lista de sucursales.
     */
    public NodoDeListas getsLast() {
        return sLast;
    }

    /**
     * Establece el último nodo en la lista de sucursales.
     *
     * @param sLast el nodo a establecer como último en la lista.
     */
    public void setsLast(NodoDeListas sLast) {
        this.sLast = sLast;
    }

    /**
     * Obtiene el tamaño de la lista de sucursales.
     *
     * @return el tamaño de la lista de sucursales.
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño de la lista de sucursales.
     *
     * @param size el tamaño a establecer para la lista de sucursales.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Verifica si la lista de sucursales está vacía.
     *
     * @return true si la lista está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return getsFirst() == null;
    }

    /**
     * Inserta una nueva sucursal en la lista.
     *
     * @param dataSucursal la sucursal a insertar en la lista.
     */
    public void insert_sucursal(Sucursal dataSucursal) {
        NodoDeListas newNodo = new NodoDeListas(dataSucursal);
        if (isEmpty()) {
            setsFirst(newNodo);
            setsLast(newNodo);
        } else {
            getsLast().setpNext(newNodo);
            newNodo.setpBefore(getsLast());
            setsLast(newNodo);
        }
        setSize(getSize() + 1);
    }

    /**
     * Elimina una sucursal de la lista por su nombre.
     *
     * @param nombreSucursal el nombre de la sucursal a eliminar.
     */
    public void eliminar_sucursal(String nombreSucursal) {
        if (isEmpty()) {
            return;
        }
        NodoDeListas current = getsFirst();

        while (current != null) {
            if (((Sucursal) current.getDataSucursal()).getParada().getNombre().equals(nombreSucursal)) {
                if (current == getsFirst()) {
                    setsFirst(current.getpNext());
                    if (getsFirst() != null) {
                        getsFirst().setpBefore(null);
                    }
                } else if (current == getsLast()) {
                    setsLast(current.getpBefore());
                    if (getsLast() != null) {
                        getsLast().setpNext(null);
                    }
                } else {
                    current.getpBefore().setpNext(current.getpNext());
                    current.getpNext().setpBefore(current.getpBefore());
                }
                setSize(getSize() - 1);
                return;
            }
            current = current.getpNext();
        }
    }
}