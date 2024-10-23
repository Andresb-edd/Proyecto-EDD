package edd.bdi.proj;

import edd.bdi.proj.Grafo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danielairibarren
 */
public class FuncionesBusqueda {
    
    public void recorrerProfundidad (Grafo g, int v, boolean [ ] visitados) {
        visitados [v] = true;
        System.out.println (v);
        for (int i = 0; i < g.getNumVertices(); i++) {
            if ((v != i) && (!visitados [i]) && (g.existeArista (v, i)) )
            recorrerProfundidad (g, i, visitados);
            }
    }
    public void profundidad (Grafo g) {
        boolean visitados [ ] = new boolean [g.getNumVertices()];
        for (int i = 0; i < g.getNumVertices(); i++)
            visitados [i] = false;
        for (int i = 0; i < g.getNumVertices(); i++) {
            if (!visitados [i])
                recorrerProfundidad (g, i, visitados);
        }
    }
    public static void amplitud(Grafo g) {
        Cola cola = new Cola();
        boolean visitados[] = new boolean[g.getNumVertices()];
        int v = 0;
        for (int i = 0; i < g.getNumVertices(); i++)
            visitados[i] = false;
        for (int i = 0; i < g.getNumVertices(); i++) {
            if (!visitados[i]) {
                NodoDeListas nodo_i = new NodoDeListas(g.listaAdy[i].getVertice());
                cola.encolar(nodo_i);
                visitados[i] = true;
                while (!cola.isEmpty()) {
                    NodoDeListas nodo = cola.desencolar();
                    Parada parada = (Parada) nodo.getDataParada();

                    for (int j = 0; j < g.getNumVertices(); j++) {
                        if (g.listaAdy[j].getVertice().getNombre().equals(parada.getNombre())) {
                            v = j;
                            break;
                        }
                    }
                    for (int j = 0; j < g.getNumVertices(); j++) {
                        if ((v != j) && (g.existeArista(v, j)) && (!visitados[j])) {
                            cola.encolar(new NodoDeListas(g.listaAdy[j].getVertice()));
                            visitados[j] = true;
                        }
                    }
                }
            }
        }
    }
    
}
