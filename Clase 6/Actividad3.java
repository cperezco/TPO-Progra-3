import java.util.*;

public class SeleccionProyectos {

    // Fuerza Bruta
    public static int fuerzaBruta(int[] costos, int[] beneficios, int presupuesto) {
        int n = costos.length;
        return auxFuerzaBruta(costos, beneficios, presupuesto, 0);
    }

    private static int auxFuerzaBruta(int[] costos, int[] beneficios, int presupuesto, int index) {
        if (index == costos.length) {
            return 0;
        }
      
        int opcion1 = auxFuerzaBruta(costos, beneficios, presupuesto, index + 1);

        int opcion2 = 0;
        if (costos[index] <= presupuesto) {
            opcion2 = beneficios[index] + auxFuerzaBruta(costos, beneficios, presupuesto - costos[index], index + 1);
        }

        return Math.max(opcion1, opcion2);
    }

    // Algoritmo Greedy
    public static int greedy(int[] costos, int[] beneficios, int presupuesto) {
        int n = costos.length;
        List<int[]> proyectos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            proyectos.add(new int[]{costos[i], beneficios[i]});
        }

        proyectos.sort((a, b) -> Double.compare((double) b[1] / b[0], (double) a[1] / a[0]));

        int maxBeneficio = 0;

        for (int[] proyecto : proyectos) {
            if (proyecto[0] <= presupuesto) {
                maxBeneficio += proyecto[1];
                presupuesto -= proyecto[0];
            }
        }

        return maxBeneficio;
    }

    // Programación Dinámica
    public static int programacionDinamica(int[] costos, int[] beneficios, int presupuesto) {
        int n = costos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= presupuesto; j++) {
                if (costos[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], beneficios[i - 1] + dp[i - 1][j - costos[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][presupuesto];
    }

    public static void main(String[] args) {
        int[] costos = {10, 15, 20, 25};
        int[] beneficios = {100, 200, 150, 300};
        int presupuesto = 40;

        // Fuerza Bruta
        int maxBeneficioFuerzaBruta = fuerzaBruta(costos, beneficios, presupuesto);
        System.out.println("Máximo beneficio (Fuerza Bruta): " + maxBeneficioFuerzaBruta);

        // Algoritmo Greedy
        int maxBeneficioGreedy = greedy(costos, beneficios, presupuesto);
        System.out.println("Máximo beneficio (Greedy): " + maxBeneficioGreedy);

        // Programación Dinámica
        int maxBeneficioDinamica = programacionDinamica(costos, beneficios, presupuesto);
        System.out.println("Máximo beneficio (Programación Dinámica): " + maxBeneficioDinamica);
    }
}
