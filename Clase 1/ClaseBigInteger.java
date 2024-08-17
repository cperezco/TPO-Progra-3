import java.math.BigInteger;

public class ClaseBigInteger {
    public static void main(String[] args) {
        BigInteger num1 = new BigInteger("9223372036854775807"); // Valor máximo de long
        BigInteger num2 = new BigInteger("100000000000000000000"); // Un número mayor al máximo de long

        BigInteger sum = num1.add(num1); 
        BigInteger mult = num1.multiply(num1);

        System.out.println("Numero muy grande (BigInteger): " + num1);
        System.out.println("Otro numero grande (BigInteger): " + num2);
        System.out.println("sum: " + sum);
        System.out.println("mult: " + mult);
    }
}
