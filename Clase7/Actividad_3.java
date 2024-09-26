import java.util.*;

public class FloydWarshallLogistica {
    static final int INF = 99999;

    public static void main(String[] args) {
        FloydWarshallLogistica fw = new FloydWarshallLogistica();

        int[][] graph = new int[][] {
                {0, 15, INF, 7},
                {INF, 0, 10, INF},
                {INF, INF, 0, 4},
                {INF, INF, INF, 0}
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el vértice de origen (1 a 4): ");
        int origen = scanner.nextInt() - 1;  
        System.out.print("Ingrese el vértice de destino (1 a 4): ");
        int destino = scanner.nextInt() - 1;  
        scanner.close();

        int V = graph.length;
        fw.floydWarshall(graph, V, origen, destino);
    }

    void floydWarshall(int[][] graph, int V, int origen, int destino) {
        int[][] dist = new int[V][V];
        int[][] predecesor = new int[V][V]; 

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];

                if (i == j) {
                    predecesor[i][j] = -1; 
                } else if (graph[i][j] != INF) {
                    predecesor[i][j] = i; 
                } else {
                    predecesor[i][j] = -1; 
                }
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        predecesor[i][j] = predecesor[k][j];
                    }
                }
            }
        }

        if (dist[origen][destino] == INF) {
            System.out.println("No hay ruta disponible entre los vértices " + (origen + 1) + " y " + (destino + 1));
        } else {
            System.out.println("La distancia más corta entre el vértice " + (origen + 1) + " y el vértice " + (destino + 1) + " es: " + dist[origen][destino]);
            System.out.println("El camino más corto es: ");
            imprimirCamino(predecesor, origen, destino);
            System.out.println((destino + 1));
        }
    }

    void imprimirCamino(int[][] predecesor, int i, int j) {
        if (predecesor[i][j] == -1) {
            return; 
        }
        imprimirCamino(predecesor, i, predecesor[i][j]);
        System.out.print((predecesor[i][j] + 1) + " -> ");
    }

    void checkNegativeCycles(int[][] dist, int V) {
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                System.out.println("Se detectó un ciclo negativo en el centro de distribución C" + (i + 1));
            }
        }
    }
}
