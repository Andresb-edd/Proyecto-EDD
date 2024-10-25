package edd.bdi.proj;

public class Set {
    private Parada[] elements;
    private int size;

    public Set(int capacity) {
        elements = new Parada[capacity];
        size = 0;
    }

    public void add(Parada parada) {
        if (!contains(parada)) {
            elements[size++] = parada;
        }
    }

    public boolean contains(Parada parada) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(parada)) {
                return true;
            }
        }
        return false;
    }

    public void addAll(Set otherSet) {
        for (int i = 0; i < otherSet.size; i++) {
            add(otherSet.elements[i]);
        }
    }

    public int size() {
        return size;
    }

    public Parada getElement(int index) {
        if (index >= 0 && index < size) {
            return elements[index];
        }
        return null;
    }
}