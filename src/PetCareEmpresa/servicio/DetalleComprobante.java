package PetCareEmpresa.servicio;
import java.util.Objects;

public class DetalleComprobante {
    private int cantidad;
    private double costoAplicado;
    private Servicios servicio;

    public DetalleComprobante(int cantidad, double costoAplicado, Servicios servicio) {
        setServicio(servicio);
        this.cantidad = cantidad;
        this.costoAplicado = costoAplicado;
    }

    public Servicios getServicio() {
        return servicio;
    }

    public void setServicio(Servicios servicio) {
        this.servicio = Objects.requireNonNull(servicio, "Servicio no puede ser nulo.");
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if(cantidad < 1){
            throw new IllegalArgumentException("El cantidad debe ser mayor a 0");
        }
        this.cantidad = cantidad;
    }

    public double getCostoAplicado() {
        return costoAplicado;
    }

    public void setCostoAplicado(double costoAplicado) {
        if(costoAplicado <= 0){
            throw new IllegalArgumentException("El costo aplicado debe ser mayor a 0");
        }
        this.costoAplicado = costoAplicado;
    }

    @Override
    public String toString() {
        return "Servicio: " + servicio + ", cantidad: " + cantidad +
                ", costo: " + costoAplicado +
                ", subtotal: " + calcularSubtotal();
    }

    public double calcularSubtotal() {
        return cantidad * costoAplicado;
    }
}
