package lista;

import java.util.LinkedList;
import java.util.List;

public class GrafoLista {

    private List<Integer>[] adyacentes;
    private int totalVertices;

    @SuppressWarnings("unchecked")
    public GrafoLista(int totalVertices) {
        this.totalVertices = totalVertices;
        adyacentes = new LinkedList[totalVertices];

        for (int i = 0; i < totalVertices; i++) {
            adyacentes[i] = new LinkedList<>();
        }
    }

    // Validar si el vértice existe
    private boolean esValido(int v) {
        return v >= 0 && v < totalVertices;
    }

    // Agregar conexión sin duplicados
    public void conectar(int origen, int destino) {

        if (!esValido(origen) || !esValido(destino)) {
            System.out.println("Vértice inválido.");
            return;
        }

        if (!adyacentes[origen].contains(destino)) {
            adyacentes[origen].add(destino);
        }

        if (!adyacentes[destino].contains(origen)) {
            adyacentes[destino].add(origen);
        }
    }

    // Mostrar lista de adyacencia
    public void imprimirGrafo() {
        System.out.println("Lista de Adyacencia del Grafo No Dirigido:");

        for (int i = 0; i < totalVertices; i++) {
            System.out.print(i + " -> ");
            for (Integer vecino : adyacentes[i]) {
                System.out.print("[" + vecino + "] ");
            }
            System.out.println();
        }
    }

    
    public static void main(String[] args) {

        GrafoLista grafo = new GrafoLista(4);

        grafo.conectar(0, 1);
        grafo.conectar(0, 2);
        grafo.conectar(1, 3);

        grafo.imprimirGrafo();
    }
}
