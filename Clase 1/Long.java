public class Long {
    public static void main(String[] args) {
        long num = 9223372036854775807L; // Max valor que puede almacenar un long
        long sum = num + 1; // Busco desbordamiento

        System.out.println("Numero grande (long): " + num);
        System.out.println("Suma con desbordamiento: " + sum); 
    }
}
