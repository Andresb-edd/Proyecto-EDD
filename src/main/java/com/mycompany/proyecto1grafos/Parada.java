/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1grafos;

/**
 *
 * @author danielairibarren
 */
public class Parada {
    
    private String nombre;
    private String linea;

    public Parada(String nombre, String linea) {
        this.nombre = nombre;
        this.linea = linea;
    }
    
    public Parada() {
        this.nombre = null;
        this.linea = null;
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
     * @return the linea
     */
    public String getLinea() {
        return linea;
    }

    /**
     * @param linea the linea to set
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }
    
    
    
    
    
}
