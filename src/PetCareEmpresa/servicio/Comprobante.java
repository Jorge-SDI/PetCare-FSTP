package PetCareEmpresa.servicio;
import java.util.Objects;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//importacion del modulo de citas
import PetCareEmpresa.modelo.*;

//muestra el comprobante con todos los servicios de una consulta
public class Comprobante {
    private int folio; //numero de comprobante
    private LocalDate fechaEmision; //fecha de expedición
    private List<DetalleComprobante> detalles; //coleccion de detalles (desglosa que cosas se pagaron)
    private Cita cita; //referencia a una cita en especifico

    //inicializa atributos propios y referenciados
    public Comprobante(int folio, LocalDate fechaEmision, Cita cita){
        setFolio(folio);
        setFechaEmision(fechaEmision);
        this.detalles = new ArrayList<>();
        this.cita = Objects.requireNonNull(cita, "La cita no puede ser nula");
    }

    public void agregarDetalle(DetalleComprobante detalleComprobante) {
        this.detalles.add(Objects.requireNonNull(detalleComprobante));
    }

    //obtener el numero de comprobante
    public int getFolio() {
        return folio;
    }

    //asignar un numero de comprobante
    public void setFolio(int folio) {
        this.folio = Objects.requireNonNull(folio, "El numero de folio no puede ser nulo");
    }

    //obtener la fecha de expedicion
    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    //asignar una fecha de emision del comprobante
    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = Objects.requireNonNull(fechaEmision, "La fecha no puede tener registros vacios");
    }

    public Cita getCita() {
        return cita;
    }

    //caclular el total de servicios para el comprobante
    public double calcularTotal(){
        double total = 0;
        for(DetalleComprobante detalleComprobante : detalles){
            total += detalleComprobante.calcularSubtotal();
        }
        return total;
    }

    //datos generales del comprobante
    @Override
    public String toString() {
        return "Comprobante de servicio" +
                "Folio: " + folio +
                ", Fecha de emision: " + fechaEmision;
    }

}
