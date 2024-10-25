package edd.bdi.proj;

import edd.bdi.proj.Grafo;
import org.graphstream.graph.Graph;
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


    public void recorrerProfundidad(Grafo g, int v, boolean[] visitados, int[] distancia, int t, boolean test) {
        visitados[v] = true;
        for (int i = 0; i < g.getNumVertices(); i++) {
            if (v == i && g.listaAdy[i].getVertice().getNombre().contains(":") && test && g.listaAdy[i].getVertice().tieneSucursal()) {
                String nombreParada = g.listaAdy[i].getVertice().getNombre();
                String[] partes = nombreParada.split(":");
                for (String parte : partes) {
                    String nombreSecundario = parte.trim();
                    Node nodeSecundario = g.getGraph().getNode(nombreSecundario);
                    if (nodeSecundario != null) {
                        if (parte == partes[1]) {
                            nodeSecundario.setAttribute("ui.style", "fill-color: yellow;");
                            int indexSecundario = -1;
                            for (int k = 0; k < g.getNumVertices(); k++) {
                                if (g.listaAdy[k].getVertice().getNombre().split(":").length > 1) {
                                    if (g.listaAdy[k].getVertice().getNombre().split(":")[0].trim().equals(nombreSecundario)) {
                                        System.out.println(k);
                                        indexSecundario = k;
                                        break;
                                    }
                                }
                            }
                            if (indexSecundario != -1) {
                                profundidad(g, indexSecundario, t - distancia[i] - 1, false);
                            }
                        }
                    }
                }
            }
            if ((v != i) && (!visitados[i]) && (g.existeArista(v, i))) {
                distancia[i] = distancia[v] + 1;
                if (distancia[i] <= t && !g.listaAdy[i].getVertice().tieneSucursal()) {
                    g.listaAdy[i].imprimirAdyacentes();
                    Node node = g.getGraph().getNode(g.listaAdy[i].getVertice().getNombre());
                    String nombreParada = g.listaAdy[i].getVertice().getNombre();

                    if (nombreParada.contains(":")) {
                        String[] partes = nombreParada.split(":");
                        for (String parte : partes) {
                            String nombreSecundario = parte.trim();
                            Node nodeSecundario = g.getGraph().getNode(nombreSecundario);
                            if (nodeSecundario != null) {
                                nodeSecundario.setAttribute("ui.style", "fill-color: yellow;");
                                if (parte == partes[1]) {
                                    int indexSecundario = -1;
                                    for (int k = 0; k < g.getNumVertices(); k++) {

                                        if (g.listaAdy[k].getVertice().getNombre().split(":").length > 1) {
                                            if (g.listaAdy[k].getVertice().getNombre().split(":")[0].trim().equals(nombreSecundario)) {
                                                System.out.println(k);
                                                indexSecundario = k;
                                                break;
                                            }
                                        }
                                    }
                                    if (indexSecundario != -1) {
                                        profundidad(g, indexSecundario, t - distancia[i], true);
                                    }
                                }

                            }
                        }
                    } else {
                        node.setAttribute("ui.style", "fill-color: yellow;");
                    }
                }
                recorrerProfundidad(g, i, visitados, distancia, t, true);
            }
        }
    }


    public boolean checkContador(Grafo g) {
        Graph graph = g.getGraph();
        int contador = 0;
        boolean todosNoRojos = true;

        for (Node node : graph) {
            String color = node.getAttribute("ui.style");
            if (color != null && !color.contains("fill-color: #ff5353;")) {
                contador++;
            } else {
                todosNoRojos = false;
            }
        }

        if (todosNoRojos) {
            System.out.println("Todos los nodos están de un color diferente a rojo.");
        }

        return todosNoRojos;
    }



    public void profundidad(Grafo g, int v, int t, boolean test) {
        boolean visitados[] = new boolean[g.getNumVertices()];
        int distancia[] = new int[g.getNumVertices()];
        for (int i = 0; i < g.getNumVertices(); i++) {
            visitados[i] = false;
            distancia[i] = Integer.MAX_VALUE;
        }
        distancia[v] = 0;
        recorrerProfundidad(g, v, visitados, distancia, t, test);
    }
    public static void amplitud(Grafo g, int v, int t, boolean test) {
        Cola cola = new Cola();
        boolean visitados[] = new boolean[g.getNumVertices()];
        int distancia[] = new int[g.getNumVertices()];

        for (int i = 0; i < g.getNumVertices(); i++) {
            visitados[i] = false;
            distancia[i] = Integer.MAX_VALUE;
        }

        cola.encolar(new NodoDeListas(g.listaAdy[v].getVertice()));
        System.out.println(g.listaAdy[v].getVertice().getNombre());
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
                System.out.println(g.listaAdy[j].getVertice().getNombre());
                g.listaAdy[j].imprimirAdyacentes();
                if (currentIndex == j && g.listaAdy[j].getVertice().getNombre().contains(":") && test && g.listaAdy[j].getVertice().tieneSucursal()) {
                    String nombreParada = g.listaAdy[j].getVertice().getNombre();
                    String[] partes = nombreParada.split(":");
                    for (String parte : partes) {
                        String nombreSecundario = parte.trim();
                        Node nodeSecundario = g.getGraph().getNode(nombreSecundario);
                        if (nodeSecundario != null) {
                            if (parte == partes[1]) {
                                nodeSecundario.setAttribute("ui.style", "fill-color: yellow;");
                                int indexSecundario = -1;
                                for (int k = 0; k < g.getNumVertices(); k++) {
                                    if (g.listaAdy[k].getVertice().getNombre().split(":").length > 1) {
                                        if (g.listaAdy[k].getVertice().getNombre().split(":")[0].trim().equals(nombreSecundario)) {
                                            System.out.println(k);
                                            indexSecundario = k;
                                            break;
                                        }
                                    }
                                }
                                if (indexSecundario != -1) {
                                    amplitud(g, indexSecundario, t - distancia[j] - 1, false);
                                }
                            }
                        }
                    }
                }
                if ((currentIndex != j) && (g.existeArista(currentIndex, j)) && (!visitados[j])) {
                    cola.encolar(new NodoDeListas(g.listaAdy[j].getVertice()));
                    visitados[j] = true;
                    distancia[j] = distancia[currentIndex] + 1;
                    if (distancia[j] <= t && !g.listaAdy[j].getVertice().tieneSucursal()) {
                        Node node = g.getGraph().getNode(g.listaAdy[j].getVertice().getNombre());
                        String nombreParada = g.listaAdy[j].getVertice().getNombre();
                        if (nombreParada.contains(":")) {
                            String[] partes = nombreParada.split(":");
                            for (String parte : partes) {
                                String nombreSecundario = parte.trim();
                                Node nodeSecundario = g.getGraph().getNode(nombreSecundario);
                                if (nodeSecundario != null) {
                                    nodeSecundario.setAttribute("ui.style", "fill-color: yellow;");
                                    if (parte == partes[1]) {
                                        int indexSecundario = -1;
                                        for (int k = 0; k < g.getNumVertices(); k++) {

                                            if (g.listaAdy[k].getVertice().getNombre().split(":").length > 1) {
                                                if (g.listaAdy[k].getVertice().getNombre().split(":")[0].trim().equals(nombreSecundario)) {
                                                    System.out.println(k);
                                                    indexSecundario = k;
                                                    break;
                                                }
                                            }
                                        }
                                        if (indexSecundario != -1) {
                                            amplitud(g, indexSecundario, t - distancia[j], true);
                                        }
                                    }

                                }
                            }
                        } else {
                            node.setAttribute("ui.style", "fill-color: yellow;");
                        }
                    }
                }
            }
        }
    }
}