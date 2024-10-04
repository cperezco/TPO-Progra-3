import java.util.*;

public class RedSocial 
{

    // Utilizamos grafos para generar una interaccion entre los distintos usuarios de la red social.
    private Map<String, List<String>> grafo;

    // Constructor
    public RedSocial() 
    {
        this.grafo = new HashMap<>();
    }

    public void agregarUsuario(String nombre) 
    {
        grafo.putIfAbsent(nombre, new ArrayList<>()); // putIfAbstent evita que se agreguen usuarios repetidos.
                                                      // En este caso, si dos usuarios con un mismo nombre intentan utilizar la red,
                                                      // no podran hacerlo. Se sugiere usar IDs aleatorios para usos en produción.
    }

    public void seguir(String seguidor, String seguido) 
    {
        if (grafo.containsKey(seguidor) && grafo.containsKey(seguido)) 
        {
            List<String> listaSeguidos = grafo.get(seguidor);
            
            // Chequeamos que la lista NO contenga al seguido, y en ese caso, lo agregamos.
            if (!listaSeguidos.contains(seguido)) 
            {
                listaSeguidos.add(seguido);
            }
        }
    }

    public void dejarDeSeguir(String seguidor, String seguido) 
    {
        if (grafo.containsKey(seguidor) && grafo.containsKey(seguido)) 
        {
            grafo.get(seguidor).remove(seguido);
        }
    }

    public List<String> listaSeguidos(String nombre) 
    {
        return grafo.getOrDefault(nombre, new ArrayList<>());
    }

    public List<String> listaDeSeguidores(String nombre) 
    {
        List<String> seguidores = new ArrayList<>();
        for (Map.Entry<String, List<String>> entrada : grafo.entrySet()) 
        {
            if (entrada.getValue().contains(nombre)) 
            {
                seguidores.add(entrada.getKey());
            }
        }
        return seguidores;
    }

    public void mostrarGrafo() {
        for (Map.Entry<String, List<String>> entrada : grafo.entrySet()) 
        {
            System.out.println(entrada.getKey() + " sigue a: " + entrada.getValue());
        }
    }

    public static void main(String[] args) 
    {
        RedSocial redSocial = new RedSocial();

        redSocial.agregarUsuario("Alice");
        redSocial.agregarUsuario("Bob");
        redSocial.agregarUsuario("Charlie");
        redSocial.agregarUsuario("David");

        redSocial.seguir("Alice", "Bob");
        redSocial.seguir("Alice", "Charlie");
        redSocial.seguir("Bob", "David");
        redSocial.seguir("Charlie", "David");

        redSocial.mostrarGrafo();

        System.out.println("Usuarios que Alice sigue: " + redSocial.listaSeguidos("Alice"));
        System.out.println("Usuarios que siguen a David: " + redSocial.listaDeSeguidores("David"));

        redSocial.dejarDeSeguir("Alice", "Charlie");
        System.out.println("Usuarios que Alice sigue después de dejar de seguir a Charlie: " + redSocial.listaSeguidos("Alice"));
    }
}
