package com.mycompany.proyecto1grafos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danielairibarren
 */
public class Linea {
    
    private String nombre;
    private int id;
    private NodoDeListas pFirst;
    private NodoDeListas pLast;
    private int size;

    public Linea(NodoDeListas pFirst, NodoDeListas pLast, int size) {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    /**
     * @return the pFirst
     */
    public NodoDeListas getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(NodoDeListas pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the pLast
     */
    public NodoDeListas getpLast() {
        return pLast;
    }

    /**
     * @param pLast the pLast to set
     */
    public void setpLast(NodoDeListas pLast) {
        this.pLast = pLast;
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
    
        public boolean isEmpty(){
        return getpFirst()== null;
    }
    
    public void insert(Parada dataParada){
        NodoDeListas newNodo = new NodoDeListas(dataParada);
        if(isEmpty()){
            setpFirst(newNodo);
            setpLast(newNodo);
        }else{
            getpLast().setpNext(newNodo);
            newNodo.setpBefore(getpLast());
            setpLast(newNodo);
        }
        setSize(getSize()+1);
    }
    
    
}
