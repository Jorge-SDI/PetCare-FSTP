package PetCareEmpresa.servicio;

public abstract class Servicios implements CalcularCosto {
    private String nombre;
    private String descripcion;

    public Servicios(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public abstract double calcularCosto();

    @Override
    public String toString() {
        return "Servicio: " +
                ", nombre: " + nombre + '\'' +
                ", descripcion: " + descripcion;
    }
}
