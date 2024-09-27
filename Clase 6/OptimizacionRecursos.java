public class OptimizacionRecursos {

    public static int optimizarPresupuesto(int[] costos, int[] rendimientos, int capacidad) {
        int n = costos.length;
        int[][] dp = new int[n + 1][capacidad + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= capacidad; j++) {
                if (costos[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costos[i - 1]] + rendimientos[i - 1]);

                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][capacidad];
    }

    public static void main(String[] args) {
        int[] costos = {5, 3, 4};
        int[] rendimientos = {60,50,70};
        int capacidad = 8;

        int rendimientoMaximo = optimizarPresupuesto(costos, rendimientos, capacidad);
        System.out.println("Rendimiento máximo con el capacidad " + capacidad + " es: " + rendimientoMaximo);
    }
}