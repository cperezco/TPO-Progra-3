public class QuickSort {

    public static void quickSort(int[] arreglo, int bajo, int alto) {
        if (bajo < alto) {
            int indiceParticion = particion(arreglo, bajo, alto);
            quickSort(arreglo, bajo, indiceParticion - 1);
            quickSort(arreglo, indiceParticion + 1, alto);
        }
    }

    private static int particion(int[] arreglo, int bajo, int alto) {
        int pivote = arreglo[alto];
        int i = (bajo - 1);

        for (int j = bajo; j < alto; j++) {
            if (arreglo[j] <= pivote) {
                i++;
                int temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }
        int temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[alto];
        arreglo[alto] = temp;

        return i + 1;
    }
    public static void main(String[] args) {
        int[] arreglo = {50,6,3,8,5,2,51,4,1};
        quickSort(arreglo, 0, arreglo.length - 1);
        System.out.print("Array ordenado: ");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
    }
}