package PetCareEmpresa.modelo;
import java.time.LocalDate;

public class Consulta {
    //representa la atencion de una cita
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

    //diagnostico registrado en la consulta
    public String getDiagnostico() {
        return diagnostico;
    }

    //observaciones del diagnostico de la consulta
    public String getObservaciones() {
        return observaciones;
    }

    //tratamiento registrado de la consulta
    public String getTratamiento() {
        return tratamiento;
    }

    //datos generales de la consulta
    @Override
    public String toString() {
        return "Consulta: " +
                "Fecha: " + fecha +
                ", Diagnostico: " + diagnostico + '\'' +
                ", Observaciones: " + observaciones + '\'' +
                ", Tratamiento: " + tratamiento;
    }
}
