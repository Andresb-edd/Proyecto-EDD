/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1grafos;

/**
 *
 * @author danielairibarren
 */
public class NodoDeListas {
    
    private NodoDeListas pNext;
    private NodoDeListas pBefore;
    private Parada dataParada;
    private Ciudad dataCiudad;
    private Linea dataLinea;

    public NodoDeListas(Parada dataParada) {
        this.pNext = null;
        this.pBefore = null;
        this.dataParada = dataParada;
    }
    
    public NodoDeListas(Ciudad dataCiudad) {
        this.pNext = null;
        this.pBefore = null;
        this.dataCiudad = dataCiudad;
    }
    
    public NodoDeListas(Linea dataLinea) {
        this.pNext = null;
        this.pBefore = null;
        this.dataLinea = dataLinea;
    }

    /**
     * @return the pNext
     */
    public NodoDeListas getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(NodoDeListas pNext) {
        this.pNext = pNext;
    }

    /**
     * @return the pBefore
     */
    public NodoDeListas getpBefore() {
        return pBefore;
    }

    /**
     * @param pBefore the pBefore to set
     */
    public void setpBefore(NodoDeListas pBefore) {
        this.pBefore = pBefore;
    }

    /**
     * @return the dataParada
     */
    public Parada getDataParada() {
        return dataParada;
    }

    /**
     * @param dataParada the dataParada to set
     */
    public void setDataParada(Parada dataParada) {
        this.dataParada = dataParada;
    }

    /**
     * @return the dataCiudad
     */
    public Ciudad getDataCiudad() {
        return dataCiudad;
    }

    /**
     * @param dataCiudad the dataCiudad to set
     */
    public void setDataCiudad(Ciudad dataCiudad) {
        this.dataCiudad = dataCiudad;
    }
}
