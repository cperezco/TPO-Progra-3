/*funcion cambio(monto_a_cambiar)
	orden de mayor a menor
	lista denominaciones = lista con las monedas


	por cada moneda en la lista
		si el monto es 0 
			se devuelve false
		si el monto de mayor o igual a la moneda
			se divide el monto por la moneda
			se actualiza el monto a cambiar
	se devuelve que el valor a devolver es 0 */

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
        int montoCambio = 1110542;

        if (cambioExacto(montoCambio)) {
            System.out.println("Es posible dar el cambio exacto.");
        } else {
            System.out.println("No es posible dar el cambio exacto.");
        }
    }
}


