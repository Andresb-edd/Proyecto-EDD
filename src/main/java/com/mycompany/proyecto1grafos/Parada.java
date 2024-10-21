package com.mycompany.proyecto1grafos;

/**
 * Clase que representa una parada en una línea de transporte.
 * Contiene el nombre de la parada y la línea a la que pertenece.
 */
public class Parada {

    private String nombre;
    private String linea;

    /**
     * Constructor de la clase Parada.
     * Inicializa la parada con un nombre y una línea.
     *
     * @param nombre el nombre de la parada.
     * @param linea la línea a la que pertenece la parada.
     */
    public Parada(String nombre, String linea) {
        this.nombre = nombre;
        this.linea = linea;
    }

    /**
     * Constructor por defecto de la clase Parada.
     * Inicializa la parada con valores nulos.
     */
    public Parada() {
        this.nombre = null;
        this.linea = null;
    }

    public Parada(String nombre) {
        this.nombre = nombre;
        this.linea = null;
    }


    /**
     * Obtiene el nombre de la parada.
     *
     * @return el nombre de la parada.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la parada.
     *
     * @param nombre el nombre a establecer para la parada.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la línea a la que pertenece la parada.
     *
     * @return la línea a la que pertenece la parada.
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Establece la línea a la que pertenece la parada.
     *
     * @param linea la línea a establecer para la parada.
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }
}