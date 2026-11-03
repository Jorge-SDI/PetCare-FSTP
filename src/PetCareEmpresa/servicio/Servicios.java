package PetCareEmpresa.servicio;

//clase Padre de los servicios ofrecidos por la clinica
//utiliza una interfaz para calcular automaticamente su costo
public abstract class Servicios implements CalcularCosto {
    private String nombre;
    private String descripcion; //atributos

    //inicializa sus atributos
    public Servicios(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    //nombre del servicio
    public String getNombre() {
        return nombre;
    }

    // asignar un nombre al sevicio
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //obtener la descripcion de un servicio
    public String getDescripcion() {
        return descripcion;
    }

    //metodo abstracto para utilizar por sus clases hijas
    //para calcular su costo
    public abstract double calcularCosto();

    //datos generales del servicio
    @Override
    public String toString() {
        return "Servicio: " +
                ", nombre: " + nombre + '\'' +
                ", descripcion: " + descripcion;
    }
}
