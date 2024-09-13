public class Actividad_1_FuerzaBruta {
    static class objeto {
        int peso;
        int valor;

        public objeto(int peso, int valor) {
            this.peso = peso;
            this.valor = valor;
        }
    }
    public static void main(String[] args) {
        objeto[] objeto = {
                new objeto(3, 3),  // Jugador 1
                new objeto(4, 6),  // Jugador 2
                new objeto(2, 3)   // Jugador 3
        };

        int capacidad = 6;
        Resultado mejorResultado = mejorCombinacion(objeto, capacidad);

        System.out.println("Valor máximo: " + mejorResultado.valorMaximo);
        System.out.println("Peso total: " + mejorResultado.pesoTotal);
    }
    static class Resultado {
        int valorMaximo;
        int pesoTotal;

        public Resultado(int valorMaximo, int pesoTotal) {
            this.valorMaximo = valorMaximo;
            this.pesoTotal = pesoTotal;
        }
    }
    static Resultado mejorCombinacion(objeto[] jugadores, int capacidad) {
        int n = jugadores.length;
        int mejorValor = 0;
        int mejorPeso = 0;

        for (int i = 0; i < (1 << n); i++) {  // "1 << n" es 2^n
            int pesoTotal = 0;
            int valorTotal = 0;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {  // Si el bit j está activado en i
                    pesoTotal += jugadores[j].peso;
                    valorTotal += jugadores[j].valor;
                }
            }

            if (pesoTotal <= capacidad && valorTotal > mejorValor) {
                mejorValor = valorTotal;
                mejorPeso = pesoTotal;
            }
        }

        return new Resultado(mejorValor, mejorPeso);
    }
}
