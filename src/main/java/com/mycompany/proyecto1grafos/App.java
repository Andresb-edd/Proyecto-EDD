/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1grafos;

/**
 *
 * @author danielairibarren
 */
public class App {
    
    private NodoDeListas cFirst;
    private NodoDeListas cLast;
    private int size;

    public App() {
        this.cFirst = null;
        this.cLast = null;
        this.size = 0;
    }

    /**
     * @return the cFirst
     */
    public NodoDeListas getcFirst() {
        return cFirst;
    }

    /**
     * @param cFirst the cFirst to set
     */
    public void setcFirst(NodoDeListas cFirst) {
        this.cFirst = cFirst;
    }

    /**
     * @return the cLast
     */
    public NodoDeListas getcLast() {
        return cLast;
    }

    /**
     * @param cLast the cLast to set
     */
    public void setcLast(NodoDeListas cLast) {
        this.cLast = cLast;
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
        return getcFirst()== null;
    }
    
    public void insert_Ciudad(Ciudad dataCiudad){
        NodoDeListas newNodo = new NodoDeListas(dataCiudad);
        if(isEmpty()){
            setcFirst(newNodo);
            setcLast(newNodo);
        }else{
            getcLast().setpNext(newNodo);
            newNodo.setpBefore(getcLast());
            setcLast(newNodo);
        }
        setSize(getSize()+1);
    }
    
    

    
}
