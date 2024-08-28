// **** Pseudocódigo ****

// Se busca el numero mas grande de la lista
// ese número se muestra y se toma como parámetro máximo del próximo número más grande

//-- Análisis de recurrencia por método inductivo --
//  Caso Base:
//  Hay un solo número y lo devuelve

//Hipótesis de Inducción
//Asumimos que el algoritmo funciona correctamente para cualquier cantidad de números en orden
// hasta acabar los de la lista
//
//Paso de Inducción
//Tomando que hace una lectura por cada máximo que busca, hará n búsquedas

//Conclusión
//Por lo tanto, sin entrar en detalles matemáticos, el tiempo de ejecución crece a medida que se tiene una lista
//más larga y/o se buscan más elementos

public class Main {
    public static void main(String[] args) {
        int[] lista = {1, 12, 612, 237, 8, 9, 57, 3, 4, 510, -1};

        buscar(lista,buscar(lista,9999999));
    }

    public static int buscar(int[] lista, int mayor) {
        int segundo_mayor = -1;
        for (int j : lista) {
            if (j > segundo_mayor && j < mayor) {
                segundo_mayor = j;
            }
        }
        System.out.println(segundo_mayor);
        return segundo_mayor;
    }
}