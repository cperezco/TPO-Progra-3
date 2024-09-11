import java.util.*;

public class Actividad_3 {
    private static final int INF = Integer.MAX_VALUE;

    public static void algPrim(int numVertices, List<List<int[]>> grafo) {
        int[] clave = new int[numVertices];
        int[] padre = new int[numVertices];
        boolean[] enArbol = new boolean[numVertices];

        Arrays.fill(clave, INF);
        clave[0] = 0;
        padre[0] = -1;

        for (int i = 0; i < numVertices - 1; i++) {
            int u = obtenerMinClave(numVertices, clave, enArbol);
            enArbol[u] = true;

            for (int[] vecino : grafo.get(u)) {
                int v = vecino[0];
                int peso = vecino[1];

                if (!enArbol[v] && peso < clave[v]) {
                    clave[v] = peso;
                    padre[v] = u;
                }
            }
        }

        imprimirArbol(padre, numVertices, grafo);
    }

    private static int obtenerMinClave(int numVertices, int[] clave, boolean[] enArbol) {
        int min = INF, minIndice = -1;

        for (int v = 0; v < numVertices; v++) {
            if (!enArbol[v] && clave[v] < min) {
                min = clave[v];
                minIndice = v;
            }
        }

        return minIndice;
    }

    private static void imprimirArbol(int[] padre, int numVertices, List<List<int[]>> grafo) {
        System.out.println("Arista \tPeso");
        for (int i = 1; i < numVertices; i++) {
            for (int[] vecino : grafo.get(i)) {
                if (vecino[0] == padre[i]) {
                    System.out.println(padre[i] + " - " + i + "\t" + vecino[1]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int numVertices = 6;
        List<List<int[]>> grafo = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            grafo.add(new ArrayList<>());
        }

        grafo.get(0).add(new int[]{1, 4});
        grafo.get(1).add(new int[]{0, 4});
        grafo.get(0).add(new int[]{2, 4});
        grafo.get(2).add(new int[]{0, 4});
        grafo.get(1).add(new int[]{2, 2});
        grafo.get(2).add(new int[]{1, 2});
        grafo.get(1).add(new int[]{3, 6});
        grafo.get(3).add(new int[]{1, 6});
        grafo.get(2).add(new int[]{3, 8});
        grafo.get(3).add(new int[]{2, 8});
        grafo.get(2).add(new int[]{4, 9});
        grafo.get(4).add(new int[]{2, 9});
        grafo.get(3).add(new int[]{4, 5});
        grafo.get(4).add(new int[]{3, 5});
        grafo.get(3).add(new int[]{5, 10});
        grafo.get(5).add(new int[]{3, 10});
        grafo.get(4).add(new int[]{5, 7});
        grafo.get(5).add(new int[]{4, 7});

        algPrim(numVertices, grafo);
    }
}

