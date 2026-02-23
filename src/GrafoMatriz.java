package matriz;

public class GrafoMatriz {

    private boolean[][] adyacencia;
    private int cantidadVertices;

    public GrafoMatriz(int cantidadVertices) {
        this.cantidadVertices = cantidadVertices;
        adyacencia = new boolean[cantidadVertices][cantidadVertices];
    }

    // Método para agregar conexión
    public void agregarConexion(int origen, int destino) {

        if (origen < 0 || destino < 0 || 
            origen >= cantidadVertices || destino >= cantidadVertices) {
            System.out.println("Error: vértice fuera de rango.");
            return;
        }

        if (adyacencia[origen][destino]) {
            System.out.println("La arista ya existe.");
        } else {
            adyacencia[origen][destino] = true;
        }
    }

    // Método para mostrar la matriz
    public void mostrarMatriz() {
        System.out.println("Matriz de Adyacencia del Grafo Dirigido:");

        for (int i = 0; i < cantidadVertices; i++) {
            for (int j = 0; j < cantidadVertices; j++) {
                System.out.print((adyacencia[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }

    
    public static void main(String[] args) {

        GrafoMatriz grafo = new GrafoMatriz(4);

        grafo.agregarConexion(0, 1);
        grafo.agregarConexion(1, 2);
        grafo.agregarConexion(2, 3);
        grafo.agregarConexion(3, 0);

        grafo.mostrarMatriz();
    }
}
