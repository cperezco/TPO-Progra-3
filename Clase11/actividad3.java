public class actividad3 {

    static final int N = 4; 
    static char[][] oficina = new char[N][N]; 
    static final char VACIO = '-'; 
    static final char COMPUTADORA = 'C'; 
    static final char IMPRESORA = 'P';

    public static void main(String[] args) {
        inicializarOficina();
        ubicarEquipos(0, 0);
    }

    static void inicializarOficina() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                oficina[i][j] = VACIO;
            }
        }
    }

    static void ubicarEquipos(int fila, int columna) {
        if (columna == N) {
            fila++;
            columna = 0;
        }
        if (fila == N) {
            imprimirOficina();
            return;
        }

        if (esSeguroColocar(fila, columna, COMPUTADORA)) {
            oficina[fila][columna] = COMPUTADORA;
            ubicarEquipos(fila, columna + 1);
            oficina[fila][columna] = VACIO; 
        }

        if (esSeguroColocar(fila, columna, IMPRESORA)) {
            oficina[fila][columna] = IMPRESORA;
            ubicarEquipos(fila, columna + 1);
            oficina[fila][columna] = VACIO; 
        }

        ubicarEquipos(fila, columna + 1);
    }

    static boolean esSeguroColocar(int fila, int columna, char equipo) {
        int[] dFila = {-1, 1, 0, 0}; 
        int[] dColumna = {0, 0, -1, 1}; 

        for (int i = 0; i < 4; i++) {
            int nuevaFila = fila + dFila[i];
            int nuevaColumna = columna + dColumna[i];

            if (nuevaFila >= 0 && nuevaFila < N && nuevaColumna >= 0 && nuevaColumna < N) {
                if (oficina[nuevaFila][nuevaColumna] == equipo) {
                    return false; 
                }
            }
        }
        return true;
    }

    static void imprimirOficina() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(oficina[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
