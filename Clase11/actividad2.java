public class actividad2 {

    static final int N = 4; 
    static char[][] habitacion = new char[N][N];
    static final char VACIO = '-'; 
    static final char ESCRITORIO = 'E';
    static final char SILLA = 'S'; 

    public static void main(String[] args) {
        inicializarHabitacion();
        ubicarMuebles(0, 0);
    }

    static void inicializarHabitacion() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                habitacion[i][j] = VACIO;
            }
        }
    }

    static void ubicarMuebles(int fila, int columna) {
        if (columna == N) {
            fila++;
            columna = 0;
        }
        if (fila == N) {
            imprimirHabitacion();
            return;
        }

        if (esSeguroColocar(fila, columna, ESCRITORIO)) {
            habitacion[fila][columna] = ESCRITORIO;
            ubicarMuebles(fila, columna + 1);
            habitacion[fila][columna] = VACIO;
        }

        if (esSeguroColocar(fila, columna, SILLA)) {
            habitacion[fila][columna] = SILLA;
            ubicarMuebles(fila, columna + 1);
            habitacion[fila][columna] = VACIO; 
        }

        ubicarMuebles(fila, columna + 1);
    }

    static boolean esSeguroColocar(int fila, int columna, char mueble) {
        // Restricciones
        int[] dFila = {-1, 1, 0, 0}; 
        int[] dColumna = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nuevaFila = fila + dFila[i];
            int nuevaColumna = columna + dColumna[i];

            if (nuevaFila >= 0 && nuevaFila < N && nuevaColumna >= 0 && nuevaColumna < N) {
                if (habitacion[nuevaFila][nuevaColumna] == mueble) {
                    return false; 
                }
            }
        }
        return true;
    }

    static void imprimirHabitacion() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(habitacion[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
