public class Actividad_1_ProgramacioDinamica {

    public static int optimizarPresupuesto(int[] costos, int[] rendimientos, int presupuesto) {
        int sizeCostos = costos.length;
        int[][] matrix = new int[n + 1][presupuesto + 1];

        for (int i = 1; i <= sizeCostos; i++) {
            for (int j = 0; j <= presupuesto; j++) {
                if (costos[i - 1] <= j) {
                    dp[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - costos[i - 1]] + rendimientos[i - 1]);
                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }

        return matrix[n][presupuesto];
    }

    public static void main(String[] args) {
        int[] costos = {5, 4, 3};
        int[] rendimientos = {90,70,50};
        int presupuesto = 8;

        int rendimientoMaximo = optimizarPresupuesto(costos, rendimientos, presupuesto);
        System.out.println("El rendimiento maximo con el presupuesto: " + presupuesto + " es: " + rendimientoMaximo);
    }
}
