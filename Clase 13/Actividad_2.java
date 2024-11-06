import java.util.*;

class Nodo {
    String nombre;

    public Nodo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

class Grafo {
    private Map<Nodo, List<Arista>> adjList = new HashMap<>();

    public void agregarNodo(Nodo nodo) {
        adjList.putIfAbsent(nodo, new ArrayList<>());
    }

    public void agregarArista(Nodo origen, Nodo destino, int costo) {
        adjList.get(origen).add(new Arista(destino, costo));
        adjList.get(destino).add(new Arista(origen, costo)); // Si el grafo es bidireccional
    }

    public int UCS(Nodo inicio, Nodo objetivo) {
        PriorityQueue<Estado> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(estado -> estado.costoAcumulado));
        Map<Nodo, Integer> costosMinimos = new HashMap<>();
        
        colaPrioridad.add(new Estado(inicio, 0));
        costosMinimos.put(inicio, 0);

        while (!colaPrioridad.isEmpty()) {
            Estado estadoActual = colaPrioridad.poll();
            Nodo nodoActual = estadoActual.nodo;
            int costoActual = estadoActual.costoAcumulado;

            if (nodoActual.equals(objetivo)) {
                return costoActual; // Se encontró el camino de menor costo
            }

            for (Arista arista : adjList.get(nodoActual)) {
                int nuevoCosto = costoActual + arista.costo;
                if (nuevoCosto < costosMinimos.getOrDefault(arista.destino, Integer.MAX_VALUE)) {
                    costosMinimos.put(arista.destino, nuevoCosto);
                    colaPrioridad.add(new Estado(arista.destino, nuevoCosto));
                }
            }
        }

        return -1; // Retorna -1 si no hay camino entre los nodos
    }
}

class Arista {
    Nodo destino;
    int costo;

    public Arista(Nodo destino, int costo) {
        this.destino = destino;
        this.costo = costo;
    }
}

class Estado {
    Nodo nodo;
    int costoAcumulado;

    public Estado(Nodo nodo, int costoAcumulado) {
        this.nodo = nodo;
        this.costoAcumulado = costoAcumulado;
    }
}

// Ejemplo de uso
public class Main {
    public static void main(String[] args) {
        Grafo grafoViajes = new Grafo();

        Nodo a = new Nodo("A");
        Nodo b = new Nodo("B");
        Nodo c = new Nodo("C");
        Nodo d = new Nodo("D");
        Nodo e = new Nodo("E");

        grafoViajes.agregarNodo(a);
        grafoViajes.agregarNodo(b);
        grafoViajes.agregarNodo(c);
        grafoViajes.agregarNodo(d);
        grafoViajes.agregarNodo(e);

        grafoViajes.agregarArista(a, b, 2);
        grafoViajes.agregarArista(a, c, 4);
        grafoViajes.agregarArista(b, c, 1);
        grafoViajes.agregarArista(b, d, 7);
        grafoViajes.agregarArista(c, e, 3);
        grafoViajes.agregarArista(d, e, 1);

        int costoMinimo = grafoViajes.UCS(a, e);
        if (costoMinimo != -1) {
            System.out.println("El costo mínimo para llegar de A a E es: " + costoMinimo);
        } else {
            System.out.println("No hay un camino disponible de A a E.");
        }
    }
}
