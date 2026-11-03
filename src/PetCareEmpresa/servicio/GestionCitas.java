package PetCareEmpresa.servicio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import PetCareEmpresa.modelo.Cita;
import PetCareEmpresa.modelo.Consulta;
import PetCareEmpresa.modelo.EstadoCita;

//controla las citas creadas (puede cancelar o atenderlas)
public class GestionCitas {
    private final List<Cita> citas; //coleccion de todas las citas existentes
    private final GestionMascotas gestionMascotas; //todas las mascotas con citas
    private final GestionVeterinarios gestionVeterinarios; //veterinarios que ateinden la scitas
    private final GestionConsultorios gestionConsultorios; //consultorios utilizados para las citas

    //inicializa atributos propios y referenciados
    public GestionCitas(GestionMascotas gestionMascotas, GestionVeterinarios gestionVeterinarios,  GestionConsultorios gestionConsultorios){
        citas = new ArrayList<>();
        this.gestionMascotas = Objects.requireNonNull(gestionMascotas);
        this.gestionVeterinarios = Objects.requireNonNull(gestionVeterinarios);
        this.gestionConsultorios = Objects.requireNonNull(gestionConsultorios);
    }

    public void agregarCita(Cita cita){
        Objects.requireNonNull(cita, "No se puede registrar una cita vacia");
        gestionMascotas.buscarMascota(cita.getMascota().getIdMascota());
        gestionVeterinarios.buscarVeterinario(cita.getVeterinario().getIdPersona());
        gestionConsultorios.buscarConsultorio(cita.getConsultorio().getNumeroConsultorio());

        //comprobamos que un veterinario tenga dos citas en el mismo horario
        for (Cita citaExistente : citas) { //verificamos que sea el mismo veterinario, misma fecha y hora
            if (citaExistente.getEstadoCita() == EstadoCita.PROGRAMADA
                    && citaExistente.getVeterinario().getIdPersona() == cita.getVeterinario().getIdPersona()
                    && citaExistente.getFecha().equals(cita.getFecha())
                    && citaExistente.getHora().equals(cita.getHora())) {
            // si se cumplen las 4 impedimos el registro de la cita
                throw new IllegalArgumentException("El veterinario ya tiene una cita programada en ese horario.");
            }

            // Validar disponibilidad del consultorio
            if (citaExistente.getEstadoCita() == EstadoCita.PROGRAMADA
                    && citaExistente.getConsultorio().getNumeroConsultorio() == cita.getConsultorio().getNumeroConsultorio()
                    && citaExistente.getFecha().equals(cita.getFecha())
                    && citaExistente.getHora().equals(cita.getHora())) {
                throw new IllegalArgumentException("El consultorio ya está ocupado en ese horario.");
            }
        }
        //agregamos la cita si ninguna validacion choca
        citas.add(cita);
    }

    //devolvemos todas las citas agendadas
    public List<Cita> listarCitas() {
        return List.copyOf(citas);
    }

    //buscamos una cita por su id
    public Cita buscarCita(int idCita) {
        for (Cita citaExistente : citas) {
            if (citaExistente.getIdCita() == idCita) {
                return citaExistente;
            }
        }
        throw new  IllegalArgumentException("La cita no existe");
    }

    //cancelamos una cita modificando su estado
    public void cancelarCita(int idCita) {
        Cita citaObjetivo = buscarCita(idCita);
        citaObjetivo.setEstadoCita(EstadoCita.CANCELADA);
    }

    //registramos una cita anotando el diagnostico, tratamiento y observaciones de la consulta
    public void registrarCitaAtendida(int idCita, String diagnostico, String observaciones, String tratamiento) {
        Cita citaObjetivo = buscarCita(idCita);

        if (citaObjetivo.getEstadoCita() != EstadoCita.PROGRAMADA) { //si está ya atendida o cancelada
            throw new IllegalArgumentException("Solo se pueden atender citas programadas");
        }
        //horario y dia en que se atendió la cita
        LocalDateTime fechaHoraCita = LocalDateTime.of(citaObjetivo.getFecha(), citaObjetivo.getHora());

        if (fechaHoraCita.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException(
                    "No se puede atender una cita antes de su fecha y hora");
        }
        //asociamos una consulta a la cita
        Consulta nuevaConsulta = new Consulta(LocalDate.now(), diagnostico, observaciones, tratamiento);
        //registramos la consulta asociada
        citaObjetivo.registrarConsulta(nuevaConsulta);
        citaObjetivo.getMascota().getHistorialClinico().agregarConsulta(nuevaConsulta);
    }
}
