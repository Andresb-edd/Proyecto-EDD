/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1grafos;

/**
 *
 * @author danielairibarren
 */
public class Grafo {
    boolean dirigido;
    int maxNodos;
    int numVertices;
    ListaAdyacentes listaAdy [];
    public Grafo (int n, boolean d) {
        dirigido = d;
        maxNodos = n;
        numVertices = 0;
        listaAdy = new ListaAdyacentes[n];
    }
    public void addListaAdyacentes(ListaAdyacentes lista) {
        if (numVertices < maxNodos) {
            listaAdy[numVertices++] = lista;
        }
    }
    public void imprimirGrafo() {
        for (int i = 0; i < numVertices; i++) {
            ListaAdyacentes lista = listaAdy[i];
            Parada parada = lista.getArista();
            System.out.print(parada.getNombre() + ": ");
            NodoDeListas current = lista.getpFirst();
            while (current != null) {
                Parada adyacente = (Parada) current.getDataParada();
                System.out.print(adyacente.getNombre() + " ");
                current = current.getpNext();
            }
            System.out.println();
        }
    }
}