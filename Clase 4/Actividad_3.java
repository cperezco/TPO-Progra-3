import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Item {
    double valor;
    double peso;

    public Item(double valor, double peso) {
        this.valor = valor;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Item{valor=" + valor + ", peso=" + peso + "}";
    }
}

public class Actividad_3 {

    public static double cargarCamion(List<Item> items, double capacidad) {
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                double r1 = o1.valor / o1.peso;
                double r2 = o2.valor / o2.peso;
                return Double.compare(r2, r1); 
            }
        });

        double valorTotal = 0.0;
        List<String> itemsCargados = new ArrayList<>(); 

        for (Item item : items) {
            if (capacidad == 0) break; 
            if (item.peso <= capacidad) {
                capacidad -= item.peso;
                valorTotal += item.valor;
                itemsCargados.add("Cargado completo: " + item);
            } else {
                double fraccion = capacidad / item.peso;
                valorTotal += item.valor * fraccion;
                itemsCargados.add("Cargado fracción (" + fraccion * 100 + "%) de: " + item);
                capacidad = 0;
            }
        }

        //Mostrar como se cargo el camión
        System.out.println("Items cargados en el camión:");
        for (String item : itemsCargados) {
            System.out.println(item);
        }
        System.out.println();

        return valorTotal;
    }

    public static void main(String[] args) {
        
        List<Item> items = Arrays.asList(
            new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30)
        );
        double capacidad = 50; 

        double valorMaximo = cargarCamion(items, capacidad);
        System.out.println("El valor máximo que se puede obtener es: " + valorMaximo);
    }
}
