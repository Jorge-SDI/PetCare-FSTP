package PetCareEmpresa.servicio;

//hereda atributos de Servicios
public class Vacunacion extends Servicios{
    private double costoVacunacion; //atributo propio

    // inicializa atributos propios y heredados
    public Vacunacion(double costoVacunacion, String nombre, String descripcion){
        super(nombre, descripcion);
        setCostoVacunacion(costoVacunacion);
    }

    public double getCostoVacunacion() {
        return costoVacunacion;
    }

    //asignar un costo a la vacuna
    public void setCostoVacunacion(double costoVacunacion) {
        if (costoVacunacion <= 0){
            throw new IllegalArgumentException("El costo debe ser mayor a 0");
        }
        this.costoVacunacion = costoVacunacion;
    }

    //calcular el costo, se contempla solo asistir a vacunacion
    @Override
    public double calcularCosto() {
        return this.costoVacunacion;
    }

    //datos generales del servicio
    @Override
    public String toString() {
        return super.toString() + "costo de vacunacion: " + costoVacunacion;
    }
}
