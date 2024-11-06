import java.util.*;

class Almacen {
    int id;
    String nombre;

    public Almacen(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

class Grafo {
    private Map<Almacen, List<Almacen>> adjList;

    public Grafo() {
        adjList = new HashMap<>();
    }

    public void agregarAlmacen(Almacen almacen) {
        adjList.putIfAbsent(almacen, new ArrayList<>());
    }

    public void conectarAlmacenes(Almacen a, Almacen b) {
        adjList.get(a).add(b);
        adjList.get(b).add(a); // Conexión bidireccional
    }

    // DFS Recursivo
    public void DFS(Almacen almacenInicial) {
        Set<Almacen> visitados = new HashSet<>();
        DFSRecursivo(almacenInicial, visitados);
    }

    private void DFSRecursivo(Almacen almacen, Set<Almacen> visitados) {
        visitados.add(almacen);
        System.out.println("Visitando almacen: " + almacen);

        for (Almacen vecino : adjList.get(almacen)) {
            if (!visitados.contains(vecino)) {
                DFSRecursivo(vecino, visitados);
            }
        }
    }

    // BFS
    public void BFS(Almacen almacenInicial) {
        Queue<Almacen> cola = new LinkedList<>();
        Set<Almacen> visitados = new HashSet<>();

        cola.add(almacenInicial);
        visitados.add(almacenInicial);

        while (!cola.isEmpty()) {
            Almacen actual = cola.poll();
            System.out.println("Visitando almacen: " + actual);

            for (Almacen vecino : adjList.get(actual)) {
                if (!visitados.contains(vecino)) {
                    cola.add(vecino);
                    visitados.add(vecino);
                }
            }
        }
    }
}

// Ejemplo de uso
public class Main {
    public static void main(String[] args) {
        Grafo redAlmacenes = new Grafo();

        Almacen a1 = new Almacen(1, "Almacen A");
        Almacen a2 = new Almacen(2, "Almacen B");
        Almacen a3 = new Almacen(3, "Almacen C");
        Almacen a4 = new Almacen(4, "Almacen D");

        redAlmacenes.agregarAlmacen(a1);
        redAlmacenes.agregarAlmacen(a2);
        redAlmacenes.agregarAlmacen(a3);
        redAlmacenes.agregarAlmacen(a4);

        redAlmacenes.conectarAlmacenes(a1, a2);
        redAlmacenes.conectarAlmacenes(a2, a3);
        redAlmacenes.conectarAlmacenes(a3, a4);
        redAlmacenes.conectarAlmacenes(a4, a1);

        System.out.println("DFS desde Almacen A:");
        redAlmacenes.DFS(a1);

        System.out.println("\nBFS desde Almacen A:");
        redAlmacenes.BFS(a1);
    }
}
