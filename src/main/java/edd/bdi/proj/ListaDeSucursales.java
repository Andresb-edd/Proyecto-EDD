/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd.bdi.proj;

/**
 *
 * @author danielairibarren
 */
public class ListaDeSucursales {
    
    private NodoDeListas sFirst;
    private NodoDeListas sLast;
    private int size;

    public ListaDeSucursales() {
        this.sFirst = null;
        this.sLast = null;
        this.size = 0;
    }

    /**
     * @return the sFirst
     */
    public NodoDeListas getsFirst() {
        return sFirst;
    }

    /**
     * @param sFirst the sFirst to set
     */
    public void setsFirst(NodoDeListas sFirst) {
        this.sFirst = sFirst;
    }

    /**
     * @return the sLast
     */
    public NodoDeListas getsLast() {
        return sLast;
    }

    /**
     * @param sLast the sLast to set
     */
    public void setsLast(NodoDeListas sLast) {
        this.sLast = sLast;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty() {
        return getsFirst() == null;
    }
    
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
    
    
    
    
}
