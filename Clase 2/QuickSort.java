public class QuickSort {

    // Quicksort. Utilizamos recursividad para poder ordenar el array rapidamente. O(n·log n)
    public static void quickSort(int[] arreglo, int bajo, int alto) 
    {
        if (bajo < alto) 
        {
            int indiceParticion = particion(arreglo, bajo, alto);
            quickSort(arreglo, bajo, indiceParticion - 1);
            quickSort(arreglo, indiceParticion + 1, alto);
        }
    }

    private static int particion(int[] arreglo, int bajo, int alto) 
    {
        int pivote = arreglo[alto];
        int i = (bajo - 1);

        for (int j = bajo; j < alto; j++) 
        {
            if (arreglo[j] <= pivote) {
                i++;
                int pointer = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = pointer;
            }
        }
        int temporal = arreglo[i + 1];
        arreglo[i + 1] = arreglo[alto];
        arreglo[alto] = temporal;

        return i + 1;
    }
    public static void main(String[] args) 
    {
        int[] arrayDesordenado = {50,6,3,8,5,2,51,4,1};
        quickSort(arrayDesordenado, 0, arrayDesordenado.length - 1);
        System.out.print("Array ordenado: ");
        for (int i = 0; i < arrayDesordenado.length; i++) 
        {
            System.out.print(arrayDesordenado[i] + " ");
        }
    }
}
