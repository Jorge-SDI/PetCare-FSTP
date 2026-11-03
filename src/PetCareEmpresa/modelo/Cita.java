package PetCareEmpresa.modelo;
import java.util.Objects;

import PetCareEmpresa.Veterinario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;


public class Cita {
    private LocalDate fecha;
    private LocalTime hora;
    private Mascota mascota;
    private Veterinario veterinario;
    private Consultorio consultorio;
    private EstadoCita estadoCita;
    private Consulta consulta;
    private static int contadorCitas = 1; //asignar ids automaticamente despues de crearse
    private final int idCita;

    public Cita(LocalDate fecha, LocalTime hora, Mascota mascota, Veterinario veterinario, Consultorio consultorio) {
        //asignamos objetos referenciados y verificamos que no sean nulos
        this.fecha = Objects.requireNonNull(fecha);
        this.hora = Objects.requireNonNull(hora);
        this.mascota = Objects.requireNonNull(mascota);
        this.veterinario = Objects.requireNonNull(veterinario);
        this.consultorio = Objects.requireNonNull(consultorio);
        //validamos que la fecha de la cita no sea anterior al dia actual
        if (fecha.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de la cita no puede ser anterior a hoy");
        }
        //al crearse se asigna un estado de programado
        this.estadoCita = EstadoCita.PROGRAMADA;
        this.idCita = contadorCitas;
        contadorCitas++;
    }

    //registramos la consulta relacionada a la cita programada
    //una cita genera una consulta asociada a ella
    public void registrarConsulta(Consulta consulta) {
        if(estadoCita != EstadoCita.PROGRAMADA ){
            throw new IllegalStateException("La cita no se encuentra programada");
        }
        //evitamos registrar 2 consultas iguales de una misma cita
        if (this.consulta != null) { //comprueba que el objeto este en un estado que no impida su operacion
            throw new IllegalStateException("La cita ya tiene una consulta previamente registrada");
        }
        this.consulta = Objects.requireNonNull(consulta, "La consulta no puede ser nula");
        //al registrar la conuslta la cita quedo atendida
        this.estadoCita = EstadoCita.ATENDIDA;
    }

    //obtenemos la mascota que recibió la consulta
    public Mascota getMascota() {
        return mascota;
    }

    //veterinario que atendió la consulta
    public Veterinario getVeterinario() {
        return veterinario;
    }

    //consultorio donde se realizó la cita
    public Consultorio getConsultorio() {
        return consultorio;
    }

    //asignar un estado a la cita
    public void setEstadoCita(EstadoCita estadoCita) {
        this.estadoCita = estadoCita;
    }

    //estado en que se encuentra la cita tras la consulta
    public EstadoCita getEstadoCita() {
        return estadoCita;
    }

    //consulta asociada a la cita
    public Consulta getConsulta() {
        return consulta;
    }

    //fecha programada para la cita
    public LocalDate getFecha() {
        return fecha;
    }

    //hora programada para la cita
    public LocalTime getHora() {
        return hora;
    }

    //identificador asignado a la cita creada
    public int getIdCita() {
        return idCita;
    }
}
