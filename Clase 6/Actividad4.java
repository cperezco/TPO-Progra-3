import java.util.*;

public class SeleccionPaquetes 
{

    // Fuerza Bruta: O(2^n) donde n es el numero de paquetes
    public static int fuerzaBruta(int[] costos, int[] ganancias, int presupuesto) 
    {
        return auxFuerzaBruta(costos, ganancias, presupuesto, 0);
    }

    private static int auxFuerzaBruta(int[] costos, int[] ganancias, int presupuesto, int index) 
    {
        if (index == costos.length) 
        {
            return 0;
        }

        int opcion_1 = auxFuerzaBruta(costos, ganancias, presupuesto, index + 1);

        int opcion_2 = 0;
        if (costos[index] <= presupuesto) 
        {
            opcion_2 = ganancias[index] + auxFuerzaBruta(costos, ganancias, presupuesto - costos[index], index + 1);
        }

        return Math.max(opcion_1, opcion_2);
    }

    // Algoritmo Greedy: O(n log n) por la ordenación de los paquetes
    public static int greedy(int[] costos, int[] ganancias, int presupuesto) 
    {
        int n = costos.length;
        List<int[]> paquetes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            paquetes.add(new int[]{costos[i], ganancias[i]});
        }

        paquetes.sort((a, b) -> Double.compare((double) b[1] / b[0], (double) a[1] / a[0]));

        int gananciaTotal = 0;

        for (int[] paquete : paquetes) 
        {
            if (paquete[0] <= presupuesto) 
            {
                gananciaTotal += paquete[1]; 
                presupuesto -= paquete[0];   
            }
        }

        return gananciaTotal;
    }

    // Programación Dinámica: O(n * presupuesto) donde n es el número de paquetes y presupuesto es el límite
    public static int programacionDinamica(int[] costos, int[] ganancias, int presupuesto) 
    {
        int n = costos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        for (int i = 1; i <= n; i++) 
        {
            for (int j = 0; j <= presupuesto; j++) 
            {
                if (costos[i - 1] <= j) 
                {
                    dp[i][j] = Math.max(dp[i - 1][j], ganancias[i - 1] + dp[i - 1][j - costos[i - 1]]);
                } else 
                {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][presupuesto]; 
    }

    public static void main(String[] args) 
    {
        int[] costos = {12, 20, 15, 25};
        int[] ganancias = {150, 200, 100, 300};
        int presupuesto = 35;

        // Ejecución de Fuerza Bruta
        int maxGananciaFuerzaBruta = fuerzaBruta(costos, ganancias, presupuesto);
        System.out.println("Máxima ganancia (Fuerza Bruta): " + maxGananciaFuerzaBruta);

        // Ejecución del Algoritmo Greedy
        int maxGananciaGreedy = greedy(costos, ganancias, presupuesto);
        System.out.println("Máxima ganancia (Greedy): " + maxGananciaGreedy);

        // Ejecución de Programación Dinámica
        int maxGananciaDinamica = programacionDinamica(costos, ganancias, presupuesto);
        System.out.println("Máxima ganancia (Programación Dinámica): " + maxGananciaDinamica);
    }
}
