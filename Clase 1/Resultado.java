public class Resultado {
    int idCliente;
    String nombre;
    double sumaImportes;

    Resultado(int idCliente, String nombre, double sumaImportes) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.sumaImportes = sumaImportes;
    }

    @Override
    public String toString() {
        return "ID Cliente: " + idCliente + ", Nombre: " + nombre + ", Suma Importes: " + sumaImportes;
    }
}
