import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class NMasGrandes {

    public static List<Integer> encontrarNMasGrandes(List<Integer> lista, int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        if (lista.size() <= n) {
            return new ArrayList<>(lista);
        }


        int mitad = lista.size() / 2;
        List<Integer> primeraMitad = lista.subList(0, mitad);
        List<Integer> segundaMitad = lista.subList(mitad, lista.size());


        List<Integer> mayoresPrimeraMitad = encontrarNMasGrandes(primeraMitad, n);
        List<Integer> mayoresSegundaMitad = encontrarNMasGrandes(segundaMitad, n);

        
        List<Integer> combinados = new ArrayList<>();
        combinados.addAll(mayoresPrimeraMitad);
        combinados.addAll(mayoresSegundaMitad);

        Collections.sort(combinados, Collections.reverseOrder());
        
        return combinados.subList(0, n);
    }

    public static void main(String[] args) {
        List<Integer> lista = List.of(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);
        int n = 6;
        List<Integer> resultado = encontrarNMasGrandes(lista, n);
        System.out.println("Los " + n + " elementos más grandes son: " + resultado);
    }
}
///Este codigo cuenta con complejidad O(n log n) debido a la seleccion aleatoria y la reduccion de la lista al relaizar la 
///recursividad
