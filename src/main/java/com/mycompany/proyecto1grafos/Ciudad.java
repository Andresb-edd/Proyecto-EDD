/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1grafos;

/**
 *
 * @author danielairibarren
 */
public class Ciudad {
    
    private String nombre;
    private int id;
    private NodoDeListas lFirst;
    private NodoDeListas lLast;
    private int size;
    private int t;

    public Ciudad(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.lFirst = null;
        this.lLast = null;
        this.size = 0;
        this.t = 1;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the lFirst
     */
    public NodoDeListas getlFirst() {
        return lFirst;
    }

    /**
     * @param lFirst the lFirst to set
     */
    public void setlFirst(NodoDeListas lFirst) {
        this.lFirst = lFirst;
    }

    /**
     * @return the lLast
     */
    public NodoDeListas getlLast() {
        return lLast;
    }

    /**
     * @param lLast the lLast to set
     */
    public void setlLast(NodoDeListas lLast) {
        this.lLast = lLast;
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

    public void setT(int t) {
        this.t = t;
    }


    public boolean isEmpty(){
        return getlFirst()== null;
    }
    
    public void insert_Linea(Linea dataLinea){
        NodoDeListas newNodo = new NodoDeListas(dataLinea);
        if(isEmpty()){
            setlFirst(newNodo);
            setlLast(newNodo);
        }else{
            getlLast().setpNext(newNodo);
            newNodo.setpBefore(getlLast());
            setlLast(newNodo);
        }
        setSize(getSize()+1);
    }
    
    
    
}
