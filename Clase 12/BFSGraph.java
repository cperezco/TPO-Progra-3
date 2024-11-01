import java.util.LinkedList;
import java.util.Queue;

public class BFSGraph {
    private int numVertices;
    private LinkedList<Integer>[] adjacencyList;

    // Constructor
    public BFSGraph(int vertices) {
        numVertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Método para agregar una arista al grafo
    public void addEdge(int start, int end) {
        adjacencyList[start].add(end);
        adjacencyList[end].add(start); // Grafo no dirigido
    }

    // Método para realizar el recorrido BFS desde un nodo dado
    public void BFS(int startNode) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();

        // Marcar el nodo de inicio como visitado y encolarlo
        visited[startNode] = true;
        queue.add(startNode);

        while (!queue.isEmpty()) {
            // Desencolar un vértice de la cola e imprimirlo
            int node = queue.poll();
            System.out.print(node + " ");

            // Obtener todos los vértices adyacentes al nodo
            for (int neighbor : adjacencyList[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSGraph graph = new BFSGraph(9);

        // Agregar aristas al grafo según la imagen
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 7);
        graph.addEdge(4, 8);

        // Realizar el recorrido BFS desde el nodo 0
        System.out.println("Recorrido BFS comenzando desde el nodo 0:");
        graph.BFS(0);
    }
}
