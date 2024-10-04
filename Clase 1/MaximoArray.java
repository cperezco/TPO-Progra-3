public class MaximoArray {

    // Encuentra el numero maximo dentro de un array de ints
    public static int encontrarMaximo(int[] array) {
        int maximo = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maximo) {
                maximo = array[i];
            }
        }
        return maximo;
    }

    public static void main(String[] args) {
        int[] numeros = {3, 7, 2, 9, 4, 5, -1, 100, 200, 5, 0};
        int maximo = encontrarMaximo(numeros);
        System.out.println("El máximo valor en el array es: " + maximo);
    }
}
