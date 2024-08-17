import java.util.ArrayList;
import java.util.List;

public class FacturacionSinMap {

    public static void main(String[] args) {
        // Datos de entrada: Facturas
        List<List<Object>> facturas = new ArrayList<>();
        facturas.add(new ArrayList<>(List.of(1, 101, 500)));
        facturas.add(new ArrayList<>(List.of(2, 102, 300)));
        facturas.add(new ArrayList<>(List.of(3, 101, 200)));
        facturas.add(new ArrayList<>(List.of(4, 103, 600)));
        facturas.add(new ArrayList<>(List.of(5, 102, 150)));

        // Datos de entrada: Clientes
        List<List<Object>> clientes = new ArrayList<>();
        clientes.add(new ArrayList<>(List.of(101, "Cliente A")));
        clientes.add(new ArrayList<>(List.of(102, "Cliente B")));
        clientes.add(new ArrayList<>(List.of(103, "Cliente C")));

        // Lista para almacenar los resultados
        List<List<Object>> resultados = new ArrayList<>();

        // Recorrer la lista de facturas para acumular los importes
        for (List<Object> factura : facturas) {
            int idCliente = (int) factura.get(1);
            int importe = (int) factura.get(2);

            // Buscar si ya existe este cliente en la lista de resultados
            int indiceCliente = buscarClienteEnResultados(resultados, idCliente);
            if (indiceCliente != -1) {
                List<Object> resultadoExistente = resultados.get(indiceCliente);
                resultadoExistente.set(2, (int) resultadoExistente.get(2) + importe);
            } else {
                String nombreCliente = getNombreCliente(clientes, idCliente);
                resultados.add(new ArrayList<>(List.of(idCliente, nombreCliente, importe)));
            }
        }

        // Mostrar los resultados
        for (List<Object> resultado : resultados) {
            System.out.println("ID Cliente: " + resultado.get(0) + ", Nombre: " + resultado.get(1) + ", Suma Importes: " + resultado.get(2));
        }
    }

    // Método auxiliar para buscar si un cliente ya está en los resultados
    public static int buscarClienteEnResultados(List<List<Object>> resultados, int idCliente) {
        for (int i = 0; i < resultados.size(); i++) {
            if ((int) resultados.get(i).get(0) == idCliente) {
                return i; 
            }
        }
        return -1; 
    }

    // Método auxiliar para obtener el nombre del cliente por su ID
    public static String getNombreCliente(List<List<Object>> clientes, int idCliente) {
        for (List<Object> cliente : clientes) {
            if ((int) cliente.get(0) == idCliente) {
                return (String) cliente.get(1);
            }
        }
        return null;
    }
}
