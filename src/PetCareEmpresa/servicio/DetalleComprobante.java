package PetCareEmpresa.servicio;
import java.util.Objects;

//guarda cada servicio utilizado en una consulta
public class DetalleComprobante {
    private int cantidad;
    private double costoAplicado;
    private Servicios servicio; //referencia al servicio utilizado

    //inicializa sus atributos propios y referenciados
    public DetalleComprobante(int cantidad, double costoAplicado, Servicios servicio) {
        setServicio(servicio);
        this.cantidad = cantidad;
        this.costoAplicado = costoAplicado;
    }

    //obtener el servicio que fue utilizado
    public Servicios getServicio() {
        return servicio;
    }

    //agregar servicios utilizados
    public void setServicio(Servicios servicio) {
        this.servicio = Objects.requireNonNull(servicio, "Servicio no puede ser nulo.");
    }

    public void setCantidad(int cantidad) {
        if(cantidad < 1){
            throw new IllegalArgumentException("El cantidad debe ser mayor a 0");
        }
        this.cantidad = cantidad;
    }

    //obtener el costo de un solo servicio usado
    public double getCostoAplicado() {
        return costoAplicado;
    }

    //asignar el costo de un solo servicio usado
    public void setCostoAplicado(double costoAplicado) {
        if(costoAplicado <= 0){
            throw new IllegalArgumentException("El costo aplicado debe ser mayor a 0");
        }
        this.costoAplicado = costoAplicado;
    }

    //datos generales de cada servicio individual
    @Override
    public String toString() {
        return "Servicio: " + servicio + ", cantidad: " + cantidad +
                ", costo: " + costoAplicado +
                ", subtotal: " + calcularSubtotal();
    }

    //calcular subtotal por servicio
    public double calcularSubtotal() {
        return cantidad * costoAplicado;
    }
}
