import java.util.*;

public class GrafoDFS {

    private Map<Integer, List<Integer>> grafo = new HashMap<>();

    public void agregarArista(int origen, int destino) {
        grafo.putIfAbsent(origen, new ArrayList<>());
        grafo.putIfAbsent(destino, new ArrayList<>());
        grafo.get(origen).add(destino);
        grafo.get(destino).add(origen); // Para grafo no dirigido
    }

    public void dfs(int nodoInicio) {
        Set<Integer> visitado = new HashSet<>();
        System.out.println("Recorrido DFS desde el nodo " + nodoInicio + ":");
        dfsRecursivo(nodoInicio, visitado);
    }

    private void dfsRecursivo(int nodo, Set<Integer> visitado) {
        visitado.add(nodo);
        System.out.print(nodo + " ");

        for (int adyacente : grafo.get(nodo)) {
            if (!visitado.contains(adyacente)) {
                dfsRecursivo(adyacente, visitado);
            }
        }
    }

    public static void main(String[] args) {
        GrafoDFS grafo = new GrafoDFS();

        grafo.agregarArista(1, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(2, 4);
        grafo.agregarArista(3, 5);
        grafo.agregarArista(4, 5);
        grafo.agregarArista(2, 6);

        grafo.dfs(1);
    }
}
