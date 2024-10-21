package com.mycompany.proyecto1grafos;

public class ListaAdyacentes {
    private Parada Arista;
    private NodoDeListas pFirst;
    private NodoDeListas pLast;

    public ListaAdyacentes(Parada Arista) {
        this.pFirst = null;
        this.pLast = null;
        this.Arista = Arista;
    }

    public Parada getArista() {return Arista;}
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
    }
}
