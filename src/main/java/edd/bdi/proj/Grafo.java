/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edd.bdi.proj;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

/**
 * Clase que representa un grafo con una lista de adyacencia.
 */

public class Grafo {
    boolean dirigido;
    int maxNodos;
    int numVertices;
    ListaAdyacentes listaAdy [];

    /**
     * Constructor para crear un grafo.
     *
     * @param n el número máximo de nodos.
     * @param d indica si el grafo es dirigido.
     */
    public Grafo (int n, boolean d) {
        dirigido = d;
        maxNodos = n;
        numVertices = 0;
        listaAdy = new ListaAdyacentes[n];
    }

    /**
     * Añade una lista de adyacencia al grafo.
     *
     * @param lista la lista de adyacencia a añadir.
     */
    public void addListaAdyacentes(ListaAdyacentes lista) {
        if (numVertices < maxNodos) {
            listaAdy[numVertices++] = lista;
        }
    }

    /**
     * Obtiene la lista de adyacencia para una parada específica.
     *
     * @param nombreParada el nombre de la parada.
     * @return la lista de adyacencia correspondiente a la parada.
     */
    public ListaAdyacentes getListaAdyacentes(String nombreParada) {
        for (int i = 0; i < numVertices; i++) {
            ListaAdyacentes lista = listaAdy[i];
            Parada parada = lista.getVertice();
            if (parada.getNombre().equals(nombreParada)) {
                return lista;
            }
        }
        return null;
    }

    /**
     * Renderiza el grafo para una ciudad seleccionada.
     *
     * @param ciudadSeleccionada el nombre de la ciudad seleccionada.
     * @param app la instancia de la aplicación.
     */
    public static void renderGrafo(String ciudadSeleccionada, App app) {
        NodoDeListas current = app.getcFirst();
        while (current != null) {
            Ciudad ciudad = (Ciudad) current.getDataCiudad();
            if (ciudad.getNombre().equals(ciudadSeleccionada)) {
                ciudad.getGrafo().imprimirGrafo();
                Graph graph = new SingleGraph(ciudadSeleccionada);
                System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");

                for (int i = 0; i < ciudad.getGrafo().numVertices; i++) {
                    String style = "fill-color: #ff5353; text-color: #000000; text-size: 10px; text-style: bold;";
                    try {
                        ListaAdyacentes lista = ciudad.getGrafo().listaAdy[i];
                        Parada parada = lista.getVertice();
                        String nombreParada = parada.getNombre();
                        if (nombreParada.contains(":")) {
                            String[] parts = nombreParada.split(":");
                            String nombre1 = parts[0].trim();
                            String nombre2 = parts[1].trim();
                            if (graph.getNode(nombre1) == null) {
                                Node node1 = graph.addNode(nombre1);
                                node1.setAttribute("ui.label", nombre1);
                                node1.setAttribute("ui.style", style);
                            }
                            if (graph.getNode(nombre2) == null) {
                                Node node2 = graph.addNode(nombre2);
                                node2.setAttribute("ui.label", nombre2);
                                node2.setAttribute("ui.style", style);
                            }
                        } else {
                            if (graph.getNode(nombreParada) == null) {
                                Node node = graph.addNode(nombreParada);
                                node.setAttribute("ui.label", nombreParada);
                                node.setAttribute("ui.style", style);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                for (int i = 0; i < ciudad.getGrafo().numVertices; i++) {
                    ListaAdyacentes lista = ciudad.getGrafo().listaAdy[i];
                    Parada parada = lista.getVertice();
                    NodoDeListas currentAdyacente = lista.getpFirst();
                    while (currentAdyacente != null) {
                        Parada adyacente = (Parada) currentAdyacente.getDataParada();
                        String nombreParada = parada.getNombre();
                        String nombreAdyacente = adyacente.getNombre();
                        if (nombreParada.contains(":")) {
                            nombreParada = nombreParada.split(":")[0].trim();
                        }
                        if (nombreAdyacente.contains(":")) {
                            nombreAdyacente = nombreAdyacente.split(":")[0].trim();
                        }
                        String edgeId = nombreParada + " - " + nombreAdyacente;
                        try {
                            if (graph.getEdge(edgeId) == null) {
                                graph.addEdge(edgeId, nombreParada, nombreAdyacente);
                            } else {
                                ListaAdyacentes listaExistente = ciudad.getGrafo().getListaAdyacentes(nombreParada);
                                if (!listaExistente.equals(lista)) {
                                    NodoDeListas currentAdyacenteExistente = listaExistente.getpFirst();
                                    while (currentAdyacenteExistente != null) {
                                        Parada adyacenteExistente = (Parada) currentAdyacenteExistente.getDataParada();
                                        String nombreAdyacenteExistente = adyacenteExistente.getNombre();
                                        if (nombreAdyacenteExistente.contains(":")) {
                                            nombreAdyacenteExistente = nombreAdyacenteExistente.split(":")[0].trim();
                                        }
                                        String edgeIdExistente = nombreParada + " - " + nombreAdyacenteExistente;
                                        if (graph.getEdge(edgeIdExistente) == null) {
                                            graph.addEdge(edgeIdExistente, nombreParada, nombreAdyacenteExistente);
                                        }
                                        currentAdyacenteExistente = currentAdyacenteExistente.getpNext();
                                    }
                                }
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        currentAdyacente = currentAdyacente.getpNext();
                    }
                }
                graph.display().setCloseFramePolicy(Viewer.CloseFramePolicy.CLOSE_VIEWER);
                break;
            }
            current = current.getpNext();
        }
    }

    /**
     * Imprime el grafo en la consola.
     */
    public void imprimirGrafo() {
        for (int i = 0; i < numVertices; i++) {
            ListaAdyacentes lista = listaAdy[i];
            Parada parada = lista.getVertice();
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