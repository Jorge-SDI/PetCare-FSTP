package PetCareEmpresa.servicio;
import java.time.LocalDate;

public class Comprobante {
    private int folio;
    private LocalDate fechaEmision;
    private double total;
    private DetalleComprobante detalleComprobante;

    public Comprobante(int folio, LocalDate fechaEmision, double total) {
        this.folio = folio;
        this.fechaEmision = fechaEmision;
        this.total = total;
    }

    public DetalleComprobante getDetalleComprobante() {
        return detalleComprobante;
    }

    public void setDetalleComprobante(DetalleComprobante detalleComprobante) {
        this.detalleComprobante = detalleComprobante;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Comprobante de servicio" +
                "Folio: " + folio +
                ", Fecha de emision: " + fechaEmision +
                ", Total: " + total;
    }

    public double calcularTotal() {
        return detalleComprobante.calcularSubtotal();
    }
}
