package edd.bdi.proj;

import edd.bdi.proj.Grafo;
import org.graphstream.graph.Node;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danielairibarren
 */
public class FuncionesBusqueda {


    public void recorrerProfundidad(Grafo g, int v, boolean[] visitados, int[] distancia, int t) {
        visitados[v] = true;
        for (int i = 0; i < g.getNumVertices(); i++) {
            if ((v != i) && (!visitados[i]) && (g.existeArista(v, i))) {
                distancia[i] = distancia[v] + 1;
                if (distancia[i] <= t && !g.listaAdy[i].getVertice().tieneSucursal()) {
                    Node node = g.getGraph().getNode(g.listaAdy[i].getVertice().getNombre());
                    node.setAttribute("ui.style", "fill-color: yellow;");
                    String nombreParada = g.listaAdy[i].getVertice().getNombre();
                    if (nombreParada.contains(":")) {
                        String[] partes = nombreParada.split(":");
                        for (String parte : partes) {
                            String nombreSecundario = parte.trim();
                            Node nodeSecundario = g.getGraph().getNode(nombreSecundario);
                            if (nodeSecundario != null) {
                                nodeSecundario.setAttribute("ui.style", "fill-color: yellow;");
                            }
                        }
                    }
                }
                recorrerProfundidad(g, i, visitados, distancia, t);
            }
        }
    }
    public void profundidad(Grafo g, int v, int t) {
        boolean visitados[] = new boolean[g.getNumVertices()];
        int distancia[] = new int[g.getNumVertices()];
        for (int i = 0; i < g.getNumVertices(); i++) {
            visitados[i] = false;
            distancia[i] = Integer.MAX_VALUE;
        }
        distancia[v] = 0;
        recorrerProfundidad(g, v, visitados, distancia, t);
    }
    public static void amplitud(Grafo g, int v, int t) {
        Cola cola = new Cola();
        boolean visitados[] = new boolean[g.getNumVertices()];
        int distancia[] = new int[g.getNumVertices()];

        for (int i = 0; i < g.getNumVertices(); i++) {
            visitados[i] = false;
            distancia[i] = Integer.MAX_VALUE;
        }

        cola.encolar(new NodoDeListas(g.listaAdy[v].getVertice()));
        visitados[v] = true;
        distancia[v] = 0;

        while (!cola.isEmpty()) {
            NodoDeListas nodo = cola.desencolar();
            Parada parada = (Parada) nodo.getDataParada();
            int currentIndex = -1;

            for (int j = 0; j < g.getNumVertices(); j++) {
                if (g.listaAdy[j].getVertice().getNombre().equals(parada.getNombre())) {
                    currentIndex = j;
                    break;
                }
            }

            for (int j = 0; j < g.getNumVertices(); j++) {
                if ((currentIndex != j) && (g.existeArista(currentIndex, j)) && (!visitados[j])) {
                    cola.encolar(new NodoDeListas(g.listaAdy[j].getVertice()));
                    visitados[j] = true;
                    distancia[j] = distancia[currentIndex] + 1;
                    if (distancia[j] <= t && !g.listaAdy[j].getVertice().tieneSucursal()) {
                        Node node = g.getGraph().getNode(g.listaAdy[j].getVertice().getNombre());
                        node.setAttribute("ui.style", "fill-color: yellow;");
                        String nombreParada = g.listaAdy[j].getVertice().getNombre();
                        if (nombreParada.contains(":")) {
                            String[] partes = nombreParada.split(":");
                            for (String parte : partes) {
                                String nombreSecundario = parte.trim();
                                Node nodeSecundario = g.getGraph().getNode(nombreSecundario);
                                if (nodeSecundario != null) {
                                    nodeSecundario.setAttribute("ui.style", "fill-color: yellow;");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
