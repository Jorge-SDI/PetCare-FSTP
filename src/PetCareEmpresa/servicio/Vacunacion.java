package PetCareEmpresa.servicio;

public class Vacunacion extends Servicios{
    private double costoVacunacion;

    public Vacunacion(double costoVacunacion, String nombre, String descripcion){
        super(nombre, descripcion);
        setCostoVacunacion(costoVacunacion);
    }

    public double getCostoVacunacion() {
        return costoVacunacion;
    }

    public void setCostoVacunacion(double costoVacunacion) {
        if (costoVacunacion <= 0){
            throw new IllegalArgumentException("El costo debe ser mayor a 0");
        }
        this.costoVacunacion = costoVacunacion;
    }

    @Override
    public double calcularCosto() {
        return this.costoVacunacion + ConsultaGeneral.getTarifaBase();
    }

    @Override
    public String toString() {
        return super.toString() + "costo de vacunacion: " + costoVacunacion;
    }
}
