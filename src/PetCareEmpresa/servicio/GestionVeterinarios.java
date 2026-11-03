package PetCareEmpresa.servicio;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

import PetCareEmpresa.Veterinario;
import PetCareEmpresa.modelo.*;

public class GestionVeterinarios {
    private List<Veterinario> veterinarios;
    private GestionMascotas gestionMascotas;
    private Clinica clinica;

    public GestionVeterinarios(GestionMascotas gestionMascotas) {
        veterinarios = new ArrayList<>();
        this.gestionMascotas = Objects.requireNonNull(gestionMascotas, "No se puede registrar una gestion vacia");
    }

    public Clinica getClinica() {
        return clinica;
    }

    //agregar un veterinario
    public void agregarVeterinario(Veterinario veterinario) {
        Objects.requireNonNull(veterinario, "No se puede registrar a un veterinario vacío");
        if (veterinario.getCorreo() == null || veterinario.getCorreo().isBlank()) {
            throw new IllegalArgumentException("El correo electrónico es obligatorio.");
        }

        //validar correo e ID entre veterinarios
        for(Veterinario veterinarioExistente : veterinarios) {
            if(veterinarioExistente.getIdPersona() == veterinario.getIdPersona()) {
                throw new IllegalArgumentException("El veterinario ya existe en el sistema.");
            }
            if (veterinarioExistente.getCorreo().equalsIgnoreCase(veterinario.getCorreo())) {
                throw new IllegalArgumentException("El correo electrónico ya está registrado.");
            }
        }

        // Validar que el correo no pertenezca a un dueño
        for (Dueno duenoExistente : gestionMascotas.listarDuenos()) {
            if (duenoExistente.getCorreo().equalsIgnoreCase(veterinario.getCorreo())) {
                throw new IllegalArgumentException("El correo electrónico ya pertenece a un dueño.");
            }
        }
        veterinarios.add(veterinario);
    }

    //obtener todos los veterinarios trabajando en la clinica
    public List<Veterinario> listarVeterinarios() {
        return List.copyOf(veterinarios);
    }

    //buscar un veterinario por su identificador
    public Veterinario buscarVeterinario(int idVeterinario) {
        for (Veterinario veterinarioExistente : veterinarios) {
            if(veterinarioExistente.getIdPersona() == idVeterinario) {
                return veterinarioExistente;
            }
        }
        throw new IllegalArgumentException("El veterinario no existe en el sistema.");
    }

    //dar de baja un veterinario del sistema
    public void eliminarVeterinario(int idVeterinario) {
        Veterinario veterinarioObjetivo = null;
        for (Veterinario veterinarioExistente : veterinarios) {
            if(veterinarioExistente.getIdPersona() == idVeterinario) {
                veterinarioObjetivo = veterinarioExistente;
                break;
            }
        }

        if (veterinarioObjetivo == null) {
            throw new IllegalArgumentException("El veterinario no existe en el sistema.");
        }
        veterinarios.remove(veterinarioObjetivo);
    }

    //asignar una clinica de trabajo al veterinario
    public void asignarClinica(int idVeterinario, Clinica clinica) {
        Objects.requireNonNull(clinica, "No puede asignarse una clínica nula");
        Veterinario veterinarioObjetivo = buscarVeterinario(idVeterinario);
        veterinarioObjetivo.setClinica(clinica);
    }
}
