package edd.bdi.proj;

public class ListaAdyacentes {
    private Parada Vertice;
    private NodoDeListas pFirst;
    private NodoDeListas pLast;

    public ListaAdyacentes(Parada Arista) {
        this.pFirst = null;
        this.pLast = null;
        this.Vertice = Arista;
    }

    public Parada getVertice() {return Vertice;}
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
    
        public Parada buscar_ParadaEn_lista_Adyacente(String nombre_linea){
        
        NodoDeListas aux = getpFirst();
        
        if(isEmpty()){
            return null;
        }
        
        
        while(aux != null){
      
            if(aux.getDataLinea().getNombre().equals(nombre_linea)){
                return aux.getDataParada();
            }
            aux = aux.getpNext();
        }
        return null;
    }
}
