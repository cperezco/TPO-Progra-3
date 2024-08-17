public class MaximoArray {
    public static void main(String[] args) {
        int[] numeros = {3, 7, 2, 9, 4, 5};
        int maximo = encontrarMaximo(numeros);
        System.out.println("El máximo valor en el array es: " + maximo);
    }

    public static int encontrarMaximo(int[] array) {
        int maximo = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maximo) {
                maximo = array[i];
            }
        }
        return maximo;
    }
}
