package PetCareEmpresa.servicio;
import java.util.Objects;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//importacion del modulo de citas
import PetCareEmpresa.modelo.*;

public class Comprobante {
    private int folio;
    private LocalDate fechaEmision;
    private List<DetalleComprobante> detalles;
    private Cita cita;

    public Comprobante(int folio, LocalDate fechaEmision, Cita cita){
        setFolio(folio);
        setFechaEmision(fechaEmision);
        this.detalles = new ArrayList<>();
        this.cita = Objects.requireNonNull(cita, "La cita no puede ser nula");
    }

    public void agregarDetalle(DetalleComprobante detalleComprobante) {
        this.detalles.add(Objects.requireNonNull(detalleComprobante));
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = Objects.requireNonNull(folio, "El numero de folio no puede ser nulo");
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = Objects.requireNonNull(fechaEmision, "La fecha no puede tener registros vacios");
    }

    public Cita getCita() {
        return cita;
    }

    public double calcularTotal(){
        double total = 0;
        for(DetalleComprobante detalleComprobante : detalles){
            total += detalleComprobante.calcularSubtotal();
        }
        return total;
    }

    public void imprimirComprobante(){
        if (detalles.isEmpty()) {
            System.out.println("El comprobante no contiene ningun servicio.");
            return;
        }
        System.out.println("Generando comprobante...");
        System.out.println("Clinica Veterinaria PetCare");
        System.out.print("Folio: " + getFolio() + "     " + "Fecha: " + getFechaEmision());
        System.out.println("Servicios utilizados: ");
        for(DetalleComprobante detalleComprobante : detalles){
            System.out.println(detalleComprobante.toString());
        }
        System.out.println("Total: " + calcularTotal());
        System.out.println("¡Gracias por preferencia!");
    }

    @Override
    public String toString() {
        return "Comprobante de servicio" +
                "Folio: " + folio +
                ", Fecha de emision: " + fechaEmision;
    }

}
