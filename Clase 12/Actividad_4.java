import java.util.*;

class Usuario {
    int id;
    String nombre;

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

class RedSocial {
    private Map<Usuario, List<Usuario>> adjList;

    public RedSocial() {
        adjList = new HashMap<>();
    }

    public void agregarUsuario(Usuario usuario) {
        adjList.putIfAbsent(usuario, new ArrayList<>());
    }

    public void agregarAmistad(Usuario u1, Usuario u2) {
        adjList.get(u1).add(u2);
        adjList.get(u2).add(u1); // Amistad bidireccional
    }

    // DFS Recursivo
    public void DFS(Usuario usuarioInicial) {
        Set<Usuario> visitados = new HashSet<>();
        DFSRecursivo(usuarioInicial, visitados);
    }

    private void DFSRecursivo(Usuario usuario, Set<Usuario> visitados) {
        visitados.add(usuario);
        System.out.println("Usuario alcanzado: " + usuario);

        for (Usuario amigo : adjList.get(usuario)) {
            if (!visitados.contains(amigo)) {
                DFSRecursivo(amigo, visitados);
            }
        }
    }

    // BFS
    public void BFS(Usuario usuarioInicial) {
        Queue<Usuario> cola = new LinkedList<>();
        Set<Usuario> visitados = new HashSet<>();

        cola.add(usuarioInicial);
        visitados.add(usuarioInicial);

        while (!cola.isEmpty()) {
            Usuario actual = cola.poll();
            System.out.println("Usuario alcanzado: " + actual);

            for (Usuario amigo : adjList.get(actual)) {
                if (!visitados.contains(amigo)) {
                    cola.add(amigo);
                    visitados.add(amigo);
                }
            }
        }
    }
}

// Ejemplo de uso
public class MainRedSocial {
    public static void main(String[] args) {
        RedSocial redSocial = new RedSocial();

        Usuario u1 = new Usuario(1, "Alice");
        Usuario u2 = new Usuario(2, "Bob");
        Usuario u3 = new Usuario(3, "Carlos");
        Usuario u4 = new Usuario(4, "Diana");

        redSocial.agregarUsuario(u1);
        redSocial.agregarUsuario(u2);
        redSocial.agregarUsuario(u3);
        redSocial.agregarUsuario(u4);

        redSocial.agregarAmistad(u1, u2);
        redSocial.agregarAmistad(u2, u3);
        redSocial.agregarAmistad(u3, u4);
        redSocial.agregarAmistad(u4, u1);

        System.out.println("DFS desde Alice:");
        redSocial.DFS(u1);

        System.out.println("\nBFS desde Alice:");
        redSocial.BFS(u1);
    }
}
