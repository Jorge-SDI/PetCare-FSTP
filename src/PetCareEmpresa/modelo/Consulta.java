package PetCareEmpresa.modelo;
import java.time.LocalDate;

public class Consulta {
    //representa una atención medica ya realizada
    private LocalDate fecha;
    private String diagnostico;
    private String observaciones;
    private String tratamiento;

    public Consulta(LocalDate fecha, String diagnostico, String observaciones, String tratamiento) {
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.observaciones = observaciones;
        this.tratamiento = tratamiento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "Fecha: " + fecha +
                ", Diagnostico: " + diagnostico + '\'' +
                ", Observaciones: " + observaciones + '\'' +
                ", Tratamiento: " + tratamiento + '\'' +
                '}';
    }
}
