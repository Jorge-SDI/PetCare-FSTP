package PetCareEmpresa.modelo;

import java.time.LocalDate;
import java.time.LocalTime;


public class Cita {
    private LocalDate fecha;
    private LocalTime hora;
    private Mascota mascota;
    private Veterinario veterinario;
    private Consultorio consultorio;
    private EstadoCita estadoCita;

    public Cita(LocalDate fecha, LocalTime hora, Mascota mascota, Veterinario veterinario, Consultorio consultorio, EstadoCita estadoCita) {
        this.fecha = fecha;
        this.hora = hora;
        this.mascota = mascota;
        this.veterinario = veterinario;
        this.consultorio = consultorio;
        this.estadoCita = EstadoCita.PROGRAMADA;
    }

    public void atenderCita(){
        if(estadoCita != EstadoCita.PROGRAMADA){
            System.out.println("La cita no se puede atender...");
            return;
        }
        this.estadoCita = EstadoCita.ATENDIDA;
        System.out.println("Cita atendida correctamente!");
    }

    public void cancelarCita() {
        if(estadoCita != EstadoCita.PROGRAMADA){
            System.out.println("La cita no se puede cancelar...");
            return;
        }
        this.estadoCita = EstadoCita.CANCELADA;
        System.out.println("Cita cancelada con exito!");
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }
}
