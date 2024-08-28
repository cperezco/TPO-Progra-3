/*
-- Pseudocódigo --
Función encontrarDosMayoresClientes(clientes, inicio, fin)
    Si inicio = fin Entonces
        Retornar (clientes[inicio], null)  
    Fin Si

    // Dividir la lista en dos mitades
    mitad = (inicio + fin) / 2

    // Encontrar los dos clientes con max scoring en la primera mitad
    (mayorIzquierda, segundoMayorIzquierda) = encontrarDosMayoresClientes(clientes, inicio, mitad)

    // Encontrar los dos clientes con max scoring en la segunda mitad
    (mayorDerecha, segundoMayorDerecha) = encontrarDosMayoresClientes(clientes, mitad + 1, fin)

    mayor = máximo(mayorIzquierda, mayorDerecha)
    Si mayor = mayorIzquierda Entonces
        segundoMayor = máximo(segundoMayorIzquierda, mayorDerecha)
    Sino
        segundoMayor = máximo(mayorIzquierda, segundoMayorDerecha)
    Fin Si

    Retornar (mayor, segundoMayor)
Fin Función
*/

class Cliente {
    int id;
    String nombre;
    int scoring;

    public Cliente(int id, String nombre, int scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }

    @Override
    public String toString() {
        return "Cliente{id=" + id + ", nombre='" + nombre + "', scoring=" + scoring + '}';
    }
}

public class DosClientesMayores {

    public static Cliente[] encontrarDosMayoresClientes(Cliente[] clientes, int inicio, int fin) {
        if (inicio == fin) {
            return new Cliente[]{clientes[inicio], null};
        }

        int mitad = (inicio + fin) / 2;

        // Encontrar los dos clientes con max scoring en la primera mitad
        Cliente[] izquierda = encontrarDosMayoresClientes(clientes, inicio, mitad);

        // Encontrar los dos clientes con max scoring en la segunda mitad
        Cliente[] derecha = encontrarDosMayoresClientes(clientes, mitad + 1, fin);

        Cliente mayor, segundoMayor;

        if (izquierda[0].scoring > derecha[0].scoring) {
            mayor = izquierda[0];
            segundoMayor = izquierda[1] != null && izquierda[1].scoring > derecha[0].scoring ? izquierda[1] : derecha[0];
        } else {
            mayor = derecha[0];
            segundoMayor = derecha[1] != null && derecha[1].scoring > izquierda[0].scoring ? derecha[1] : izquierda[0];
        }

        return new Cliente[]{mayor, segundoMayor};
    }

    public static void main(String[] args) {
        Cliente[] clientes = {
            new Cliente(1, "Juan", 80),
            new Cliente(2, "Ana", 95),
            new Cliente(3, "Jose", 100),
            new Cliente(4, "Luis", 90),
            new Cliente(5, "Maria", 85),
            new Cliente(6, "Carlos", 70)
        };

        Cliente[] resultado = encontrarDosMayoresClientes(clientes, 0, clientes.length - 1);
        System.out.println("Los dos clientes con los scoring máximos son:");
        System.out.println(resultado[0]);
        System.out.println(resultado[1]);
    }
}

/*
-- Análisis de recurrencia por método inductivo --
Caso Base: Si la lista contiene solo un cliente, se retorna ese cliente como el mayor y null como el segundo mayor en O(1).

Hipótesis de Inducción: Suponemos que el algoritmo funciona correctamente para sublistas de tamaño n/2 y encuentra los dos mayores en tiempo T(n/2).

Paso de Inducción: Para una lista de tamaño n, dividimos en dos mitades, resolvemos recursivamente ambas mitades (2T(n/2)), y luego combinamos los dos 
mayores de ambas mitades en tiempo constante O(1).

Conclusión de Complejidad: La recurrencia T(n) = 2T(n/2) + O(1) sugiere una complejidad O(n log n).
*/
