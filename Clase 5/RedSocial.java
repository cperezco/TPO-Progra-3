import java.util.*;

public class RedSocial {

    // Map para representar el grafo de seguidores
    private Map<String, List<String>> grafo;

    public RedSocial() {
        this.grafo = new HashMap<>();
    }

    // Agregar usuarios
    public void agregarUsuario(String nombre) {
        grafo.putIfAbsent(nombre, new ArrayList<>());
    }

    // Usuario siga a otro
    public void seguir(String seguidor, String seguido) {
        if (grafo.containsKey(seguidor) && grafo.containsKey(seguido)) {
            List<String> listaSeguidos = grafo.get(seguidor);
            if (!listaSeguidos.contains(seguido)) {
                listaSeguidos.add(seguido);
            }
        }
    }

    // Usuario deje de seguir a otro
    public void dejarDeSeguir(String seguidor, String seguido) {
        if (grafo.containsKey(seguidor) && grafo.containsKey(seguido)) {
            grafo.get(seguidor).remove(seguido);
        }
    }

    // Lista de seguidos
    public List<String> listaSeguidos(String nombre) {
        return grafo.getOrDefault(nombre, new ArrayList<>());
    }

    // Lista de seguidores
    public List<String> listaSeguidoresDe(String nombre) {
        List<String> seguidores = new ArrayList<>();
        for (Map.Entry<String, List<String>> entrada : grafo.entrySet()) {
            if (entrada.getValue().contains(nombre)) {
                seguidores.add(entrada.getKey());
            }
        }
        return seguidores;
    }

    // Mostrar del grafo
    public void mostrarGrafo() {
        for (Map.Entry<String, List<String>> entrada : grafo.entrySet()) {
            System.out.println(entrada.getKey() + " sigue a: " + entrada.getValue());
        }
    }

    public static void main(String[] args) {
        RedSocial redSocial = new RedSocial();

        // Agregar usuarios
        redSocial.agregarUsuario("Alice");
        redSocial.agregarUsuario("Bob");
        redSocial.agregarUsuario("Charlie");
        redSocial.agregarUsuario("David");

        // Seguir usuarios
        redSocial.seguir("Alice", "Bob");
        redSocial.seguir("Alice", "Charlie");
        redSocial.seguir("Bob", "David");
        redSocial.seguir("Charlie", "David");

        // Mostrar el grafo
        redSocial.mostrarGrafo();

        // Listar seguidores y seguidos
        System.out.println("Usuarios que Alice sigue: " + redSocial.listaSeguidos("Alice"));
        System.out.println("Usuarios que siguen a David: " + redSocial.listaSeguidoresDe("David"));

        // Dejar de seguir
        redSocial.dejarDeSeguir("Alice", "Charlie");
        System.out.println("Usuarios que Alice sigue después de dejar de seguir a Charlie: " + redSocial.listaSeguidos("Alice"));
    }
}
