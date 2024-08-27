/* 
-- Pseudocódigo --
Función encontrarMaximoCliente(clientes, inicioLista, finLista)
    Si inicioLista= finLista Entonces
        Retornar clientes[inicioLista]
    Fin Si

    // Dividir la lista a la mitad
    mitad = (inicioLista + finLista) / 2

    // Encontrar el cliente con max scoring en la primera mitad
    mitadIzquierda = encontrarMaximoCliente(clientes, inicioLista, mitad)

    // Encontrar el cliente con max scoring en la segunda mitad
    mitadDerecha = encontrarMaximoCliente(clientes, mitad + 1, finLista)

    Si mitadIzquierda.scoring >= mitadDerecha.scoring Entonces
        Retornar mitadIzquierda
    Sino
        Retornar mitadDerecha
    Fin Si
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
}

public class MaximoScoringCliente {

    public static Cliente encontrarMaximoCliente(Cliente[] clientes, int inicio, int fin) {
        // Caso Base
        if (inicio == fin) {
            return clientes[inicio]; 
        }

        // Dividir la lista a la mitad
        int mitad = (inicio + fin) / 2;

        // Encontrar el cliente con max scoring en la primera mitad
        Cliente clienteIzquierda = encontrarMaximoCliente(clientes, inicio, mitad);

        // Encontrar el cliente con max scoring en la segunda mitad
        Cliente clienteDerecha = encontrarMaximoCliente(clientes, mitad + 1, fin);

        if (clienteIzquierda.scoring >= clienteDerecha.scoring) {
            return clienteIzquierda;
        } else {
            return clienteDerecha;
        }
    }

    public static void main(String[] args) {
        Cliente[] clientes = {
            new Cliente(1, "Juan", 80),
            new Cliente(2, "Ana", 95),
            new Cliente(3, "Luis", 90),
            new Cliente(4, "Maria", 85),
            new Cliente(5, "Carlos", 70)
        };

        Cliente clienteConMaximoScoring = encontrarMaximoCliente(clientes, 0, clientes.length - 1);
        System.out.println("Cliente con el máximo scoring: " + clienteConMaximoScoring.nombre + " con un scoring de " + clienteConMaximoScoring.scoring);
    }
}

/* 
-- Análisis de recurrencia por método inductivo --
Caso Base
El caso base ocurre cuando la sublista tiene un solo cliente, y el algoritmo simplemente devuelve ese cliente. Esto es correcto porque, sin comparación necesaria, 
ese cliente es el de mayor puntaje. La complejidad en este caso es constante.

Hipótesis de Inducción
Asumimos que el algoritmo funciona correctamente para cualquier sublista de tamaño n, encontrando siempre al cliente con el puntaje más alto.

Paso de Inducción
Para una sublista de n + 1 clientes, el algoritmo divide la lista en dos, resuelve ambas mitades y luego compara los máximos encontrados, devolviendo el cliente con 
el puntaje más alto entre ellos.

Conclusión
Como el algoritmo funciona para el caso base y se mantiene para n + 1 basado en la hipótesis de inducción, es correcto para cualquier tamaño de lista. Dado que el 
algoritmo divide el problema en partes más pequeñas y combina los resultados, la complejidad general aumenta de manera logarítmica conforme aumenta el tamaño de la 
lista. Por lo tanto, la complejidad algorítimica del problema es de O(n log n)
*/
