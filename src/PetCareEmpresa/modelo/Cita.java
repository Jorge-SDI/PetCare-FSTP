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

    public Cita(LocalDate fecha, LocalTime hora, Mascota mascota, Veterinario veterinario, Consultorio consultorio) {
        this.fecha = Objects.requireNonNull(fecha);
        this.hora = Objects.requireNonNull(hora);
        this.mascota = Objects.requireNonNull(mascota);
        this.veterinario = Objects.requireNonNull(veterinario);
        this.consultorio = Objects.requireNonNull(consultorio);
        //validamos que la fecha de la cita no sea anterior al dia actual
        if (fecha.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de la cita no puede ser anterior a hoy");
        }

        this.estadoCita = EstadoCita.PROGRAMADA;
    }

    public void cancelarCita() {
        if (estadoCita != EstadoCita.PROGRAMADA) {
            throw new IllegalStateException("La cita no se puede cancelar");
        }

        this.estadoCita = EstadoCita.CANCELADA;
        System.out.println("¡Cita cancelada con exito!");
    }

    public void registrarConsulta(Consulta consulta) {
        if(estadoCita != EstadoCita.PROGRAMADA ){
            throw new IllegalStateException("La cita no se encuentra programada");
        }
        //evitamos registrar 2 consultas iguales de una misma cita
        if (this.consulta != null) { //comprueba que el objeto este en un estado que no impida su operacion
            throw new IllegalStateException("La cita ya tiene una consulta previamente registrada");
        }
        this.consulta = Objects.requireNonNull(consulta, "La consulta no puede ser nula");
        this.estadoCita = EstadoCita.ATENDIDA;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public EstadoCita getEstadoCita() {
        return estadoCita;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }
}
