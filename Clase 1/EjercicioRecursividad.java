public class EjercicioRecursividad {
    
    public static int SumarNumeros(int n) {
        if (n <= 0) {
            return 0; // Caso base
        } else {
            return n + SumarNumeros(n - 1); // Llamada recursiva
        }
    }

    public static void main(String[] args) {
        int n = 10; 
        int resultado = SumarNumeros(n);
        System.out.println("La suma de los primeros " + n + " números enteros es: " + resultado);
    }
}
