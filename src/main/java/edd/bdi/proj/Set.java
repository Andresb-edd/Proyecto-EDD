package edd.bdi.proj;

/**
 * Clase que representa un conjunto de paradas.
 * Permite agregar, verificar la existencia y obtener elementos del conjunto.
 */
public class Set {
    private Parada[] elements;
    private int size;

    /**
     * Constructor que inicializa el conjunto con una capacidad dada.
     *
     * @param capacity la capacidad inicial del conjunto.
     */
    public Set(int capacity) {
        elements = new Parada[capacity];
        size = 0;
    }

    /**
     * Agrega una parada al conjunto si no está ya presente.
     *
     * @param parada la parada a agregar al conjunto.
     */
    public void add(Parada parada) {
        if (!contains(parada)) {
            elements[size++] = parada;
        }
    }

    /**
     * Verifica si una parada está presente en el conjunto.
     *
     * @param parada la parada a verificar.
     * @return true si la parada está presente en el conjunto, false en caso contrario.
     */
    public boolean contains(Parada parada) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(parada)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Agrega todos los elementos de otro conjunto a este conjunto.
     *
     * @param otherSet el otro conjunto cuyos elementos se agregarán.
     */
    public void addAll(Set otherSet) {
        for (int i = 0; i < otherSet.size; i++) {
            add(otherSet.elements[i]);
        }
    }

    /**
     * Obtiene el tamaño del conjunto.
     *
     * @return el tamaño del conjunto.
     */
    public int size() {
        return size;
    }

    /**
     * Obtiene el elemento en una posición específica del conjunto.
     *
     * @param index el índice del elemento a obtener.
     * @return el elemento en la posición especificada, o null si el índice es inválido.
     */
    public Parada getElement(int index) {
        if (index >= 0 && index < size) {
            return elements[index];
        }
        return null;
    }
}