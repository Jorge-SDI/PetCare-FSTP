package PetCareEmpresa.servicio;
//hereda de Servicios
public class ConsultaGeneral extends Servicios {
    private static final double TARIFA_BASE = 350.00; //atributo base, precio de una consulta general (solo revision)

    //iniciliza atributos heredados
    public ConsultaGeneral(String nombre, String descripcion) {
        super(nombre, descripcion);
    }

    //obtiene la tarifa cobrada por consulta
    public static double getTarifaBase() {
        return TARIFA_BASE;
    }

    //interfaz para calcular su costo
    @Override
    public double calcularCosto() {
        return this.TARIFA_BASE;
    }

    //datos generales de la consulta
    @Override
    public String toString() {
        return super.toString() + "tarifaBase=" + TARIFA_BASE;
    }
}
