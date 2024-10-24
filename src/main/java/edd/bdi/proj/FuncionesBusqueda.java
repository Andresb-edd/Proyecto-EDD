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
        System.out.println(v);
        for (int i = 0; i < g.getNumVertices(); i++) {
            if ((v != i) && (!visitados[i]) && (g.existeArista(v, i))) {
                distancia[i] = distancia[v] + 1;
                if (distancia[i] <= t && !g.listaAdy[i].getVertice().tieneSucursal()) {
                    if (g.getListaAdy()[i].getVertice().getNombre().contains(":")) {
                        Node node = g.getGraph().getNode(g.getListaAdy()[i].getVertice().getNombre().split(":")[0].trim());
                        node.setAttribute("ui.style", "fill-color: yellow;");
                        String nombreParada = g.getListaAdy()[i].getVertice().getNombre();
                        if (nombreParada.contains(":")) {
                            String nombreSecundario = nombreParada.split(":")[1].trim();
                            Node nodeSecundario = g.getGraph().getNode(nombreSecundario);
                            if (nodeSecundario != null) {
                                nodeSecundario.setAttribute("ui.style", "fill-color: yellow;");
                            }
                        }
                    } else {
                        Node node = g.getGraph().getNode(g.getListaAdy()[i].getVertice().getNombre());

                        node.setAttribute("ui.style", "fill-color: yellow;");
                        String nombreParada = g.getListaAdy()[i].getVertice().getNombre();
                        if (nombreParada.contains(":")) {
                            String nombreSecundario = nombreParada.split(":")[1].trim();
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

        cola.encolar(new NodoDeListas(g.getListaAdy()[v].getVertice()));
        visitados[v] = true;
        distancia[v] = 0;

        while (!cola.isEmpty()) {
            NodoDeListas nodo = cola.desencolar();
            Parada parada = (Parada) nodo.getDataParada();

            for (int j = 0; j < g.getNumVertices(); j++) {
                if (g.getListaAdy()[j].getVertice().getNombre().equals(parada.getNombre())) {
                    v = j;
                    break;
                }
            }

            for (int j = 0; j < g.getNumVertices(); j++) {
                if ((v != j) && (g.existeArista(v, j)) && (!visitados[j])) {
                    cola.encolar(new NodoDeListas(g.getListaAdy()[j].getVertice()));
                    visitados[j] = true;
                    distancia[j] = distancia[v] + 1;
                    if (distancia[j] <= t && !g.listaAdy[j].getVertice().tieneSucursal()) {
                        Node node = g.getGraph().getNode(g.getListaAdy()[j].getVertice().getNombre());
                        node.setAttribute("ui.style", "fill-color: yellow;");
                        // Marcar la segunda parte del nombre si existe
                        String nombreParada = g.getListaAdy()[j].getVertice().getNombre();
                        if (nombreParada.contains(":")) {
                            String nombreSecundario = nombreParada.split(":")[1].trim();
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
