
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
    
        //procedimiento recursivo
    public void recorrerProfundidad (Grafo g, int v, boolean [ ] visitados) {
        //se marca el vértice v como visitado
        visitados [v] = true;
        //el tratamiento del vértice consiste únicamente en imprimirlo en pantalla
        System.out.println (v);
        //se examinan los vértices adyacentes a v para continuar el recorrido
        for (int i = 0; i < g.getNumVertices(); i++) {
            if ((v != i) && (!visitados [i]) && (g.existeArista (v, i)) )
            recorrerProfundidad (g, i, visitados);
            }
        }
    
        //procedimiento no recursivo
        public void profundidad (Grafo g) {
            boolean visitados [ ] = new boolean [g.getNumVertices()];
            for (int i = 0; i < g.getNumVertices(); i++) //inicializar vector con campos false
                visitados [i] = false;
                for (int i = 0; i < g.getNumVertices(); i++) { //Relanza el recorrido en cada
                    if (!visitados [i]) //vértice visitado
                    recorrerProfundidad (g, i, visitados);
                    }
    }
    
}
