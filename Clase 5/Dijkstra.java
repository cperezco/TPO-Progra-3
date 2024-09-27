import java.util.*;

public class Dijkstra {

    static class Edge {
        int destino;
        int distancia;

        Edge(int destino, int distancia) {
            this.destino = destino;
            this.distancia = distancia;
        }
    }

    static class Graph {
        int vertices;
        List<List<Edge>> adjList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        void addEdge(int source, int destino, int distancia) {
            adjList.get(source).add(new Edge(destino, distancia));
        }

        void dijkstra(int startVertex) {
            int[] distances = new int[vertices];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[startVertex] = 0;

            PriorityQueue<Edge> pq = new PriorityQueue<>(vertices, Comparator.comparingInt(e -> e.distancia));
            pq.add(new Edge(startVertex, 0));

            boolean[] visited = new boolean[vertices];

            while (!pq.isEmpty()) {
                int u = pq.poll().destino;

                if (visited[u]) continue;
                visited[u] = true;

                for (Edge edge : adjList.get(u)) {
                    int v = edge.destino;
                    int distancia = edge.distancia;

                    if (!visited[v] && distances[u] + distancia < distances[v]) {
                        distances[v] = distances[u] + distancia;
                        pq.add(new Edge(v, distances[v]));
                    }
                }
            }

            printSolution(distances, startVertex);
        }

        void printSolution(int[] distances, int startVertex) {
            System.out.println("Distancia desde el vértice " + startVertex);
            for (int i = 0; i < vertices; i++) {
                System.out.println("La distancia hasta " + i + " es " + distances[i]+ " kilómetros.");
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);

        // Añadir aristas al grafo
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 3);
        graph.addEdge(4, 5, 1);
        graph.addEdge(3, 5, 2);

        graph.dijkstra(0);  // Ejecutar Dijkstra desde el vértice 0
    }
}