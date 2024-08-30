public class Actividad_1 {
    public static boolean cambioExacto(int montoCambio) {
        int[] denominaciones = {100, 50, 20, 10, 5, 1};

        for (int moneda : denominaciones) {
            if (montoCambio == 0) {
                return false;
            }
            if (montoCambio >= moneda) {
                int cantidadMonedas = montoCambio / moneda;
                montoCambio -= cantidadMonedas * moneda;
            }
        }
        return montoCambio == 0;
    }

    public static void main(String[] args) {
        int montoCambio = 111;

        if (cambioExacto(montoCambio)) {
            System.out.println("Es posible dar el cambio exacto.");
        } else {
            System.out.println("No es posible dar el cambio exacto.");
        }
    }
}

