import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NMasGrandes {

    public static List<Integer> encontrarNMasGrandes(List<Integer> lista, int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        if (lista.size() <= n) {
            return new ArrayList<>(lista);
        }
        int pivot = seleccionarPivot(lista);
        List<Integer> mayores = new ArrayList<>();
        List<Integer> iguales = new ArrayList<>();
        List<Integer> menores = new ArrayList<>();

        for (int elemento : lista) {
            if (elemento > pivot) {
                mayores.add(elemento);
            } else if (elemento < pivot) {
                menores.add(elemento);
            } else {
                iguales.add(elemento);
            }
        }

        if (mayores.size() == n) {
            return mayores;
        } else if (mayores.size() > n) {
            return encontrarNMasGrandes(mayores, n);
        } else {
            int totalMayoresIguales = mayores.size() + iguales.size();
            if (totalMayoresIguales >= n) {
                mayores.addAll(iguales.subList(0, n - mayores.size()));
                return mayores;
            } else {
                mayores.addAll(iguales);
                mayores.addAll(encontrarNMasGrandes(menores, n - totalMayoresIguales));
                return mayores;
            }
        }
    }

    private static int seleccionarPivot(List<Integer> lista) {
        Random rand = new Random();
        return lista.get(rand.nextInt(lista.size()));
    }

    public static void main(String[] args) {
        List<Integer> lista = List.of(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);
        int n = 4;
        List<Integer> resultado = encontrarNMasGrandes(lista, n);
        System.out.println("Los " + n + " elementos más grandes son: " + resultado);
    }
}
///Este codigo cuenta con complejidad O(n log n) debido a la seleccion aleatoria y la reduccion de la lista al relaizar la 
///recursividad
