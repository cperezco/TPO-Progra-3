/*
            -- Pseudocódigo --
function encontrarNMasGrandes(lista, n)
    Si n == 0 Entonces
        Retornar lista vacía
    Fin Si
    
    Si tamaño(lista) <= n Entonces
        Retornar copia de lista
    Fin Si

    mitad ← tamaño(lista) / 2
    primeraMitad ← sublista(lista, 0, mitad)
    segundaMitad ← sublista(lista, mitad, tamaño(lista))

    mayoresPrimeraMitad ← encontrarNMasGrandes(primeraMitad, n)
    mayoresSegundaMitad ← encontrarNMasGrandes(segundaMitad, n)

    combinados ← concatenar(mayoresPrimeraMitad, mayoresSegundaMitad)

    ordenar(combinados, descendente)

    Retornar sublista(combinados, 0, n)
Fin funcion

Progrma principal
    lista = lista[]
    n = numero
    resultado ← encontrarNMasGrandes(lista, n)
    imprimir resultado
Fin programa
*/
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
