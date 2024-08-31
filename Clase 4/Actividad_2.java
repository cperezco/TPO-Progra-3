// **** PSEUDOCODIGO ****

// se crean las listas
// se llama a la funcion con las listas como parámetros
// while ( haya espacio libre)
//     for ( viendo cuál es el objeto que más vale considerando todas las veces que entra en el espacio que queda)
//         una vez definido se guarda y resta del espacio que queda libre
//  una vez que no hay más espacio se muestra cuanto valor aporta cada elemento

public class Main {
    public static void main(String[] args) {
        int[] precio = {145,75,23,7,118};
        int[] volumen = {15, 5,3,1,12};
        String[] nombre = {"heladera","silla","teclado","plato","ventilador"};
        int espacio = 26;

        System.out.println(cargarCamion(precio,volumen,nombre, espacio));
        
    }

    public static String cargarCamion (int[] precio, int[] volumen, String[] nombre, int espacio_disp) {
        int valorMax= 0;
        String objetoMax = "";
        int cantidad = 0;
        int ocupa = 0;
        String cargado = "";
        int intentos = 0;
        while (espacio_disp > 0 && intentos < 6) {
            for (int i = 0; i < precio.length; i++) {
                if (volumen[i] <= precio[i]) {
                    cantidad = Math.floorDiv(espacio_disp, volumen[i]);
                    ocupa = cantidad * volumen[i];
                    System.out.println("Cantidad: " + cantidad);
                    if ((precio[i] * cantidad) > valorMax) {
                        valorMax = precio[i] * cantidad;
                        System.out.println("Valor: " + valorMax);
                        objetoMax = nombre[i];
                    }
                }
                intentos++;
            }
            if (espacio_disp > 0) {
                cargado += "$" + valorMax + " en " + objetoMax + " ";
                espacio_disp -= ocupa+1;
                valorMax = 0;
                ocupa = 0;
            }
            if (intentos >= 6) {
                espacio_disp = 0;
            }
        }
        return cargado;
    }

}
