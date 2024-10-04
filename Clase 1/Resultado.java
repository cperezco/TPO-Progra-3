public class Resultado {
    private int idCliente;
    private String nombre;
    private double sumaImportes;

    // Constructor. Se ejecuta 1 vez por cada vez que se instancia la clase.
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
