import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacturacionConMap {

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

        // Crear un Map para almacenar la suma de importes por cliente
        Map<Integer, Integer> sumaImportesPorCliente = new HashMap<>();

        // Sumar los importes de las facturas por cliente
        for (List<Object> factura : facturas) {
            int idCliente = (int) factura.get(1);
            int importe = (int) factura.get(2);

            // Comprobar si el cliente ya está en el Map
            if (sumaImportesPorCliente.containsKey(idCliente)) {
                int sumaActual = sumaImportesPorCliente.get(idCliente);
                sumaImportesPorCliente.put(idCliente, sumaActual + importe);
            } else {
                sumaImportesPorCliente.put(idCliente, importe);
            }
        }

        // Lista para almacenar los resultados
        List<List<Object>> resultados = new ArrayList<>();

        // Crear la lista de resultados combinando clientes con suma de importes
        for (List<Object> cliente : clientes) {
            int idCliente = (int) cliente.get(0);
            String nombreCliente = (String) cliente.get(1);
            int sumaImportes = sumaImportesPorCliente.get(idCliente);
            resultados.add(new ArrayList<>(List.of(idCliente, nombreCliente, sumaImportes)));
        }

        // Mostrar los resultados
        for (List<Object> resultado : resultados) {
            System.out.println("ID Cliente: " + resultado.get(0) + ", Nombre: " + resultado.get(1) + ", Suma Importes: " + resultado.get(2));
        }
    }
}
