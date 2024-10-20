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
    private boolean dirigido;
    private int maxNodos;
    private int numVertices;
    private boolean matrizAdy [ ] [ ];

    public Grafo (boolean d) {
        maxNodos = numVertices = 0;
        dirigido = d;
    }
    public Grafo (int n, boolean d) {
        dirigido = d;
        maxNodos = n;
        numVertices = 0;
        matrizAdy = new boolean[n][n];
    }
    public void insertaArista (int i, int j) {
        matrizAdy [i] [j] = true;
        if (!dirigido)
            matrizAdy [j] [i] = matrizAdy [i] [j];
    }

    public void eliminarArista (int i, int j) {
        matrizAdy [i] [j] = false;
        if (!dirigido)
            matrizAdy [j] [i] = false;
    }
    public void insertaVertice (int n) {
        if ( n > maxNodos - numVertices )
            System.out.println ("Error, se supera el número de nodos máximo");
        else {
            for (int i=0; i < numVertices + n; i++) {
                for (int j = numVertices; j < numVertices + n; j++)
                    matrizAdy [i] [j] = matrizAdy [j] [i] = false;
            }
            numVertices = numVertices + n;
        }
    }
    public void imprimirTabla () {
        System.out.println ("La matriz contiene " + numVertices + " vértices: \n");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdy [i] [j])
                    System.out.print ("1 ");
                else System.out.print ("0 ");
            }
        }
    }
}