package PetCareEmpresa.servicio;

public class ConsultaGeneral extends Servicios {
    private static final double TARIFA_BASE = 350.00;

    public ConsultaGeneral(String nombre, String descripcion) {
        super(nombre, descripcion);
    }

    public static double getTarifaBase() {
        return TARIFA_BASE;
    }

    @Override
    public double calcularCosto() {
        return this.TARIFA_BASE;
    }

    @Override
    public String toString() {
        return super.toString() + "tarifaBase=" + TARIFA_BASE;
    }
}
