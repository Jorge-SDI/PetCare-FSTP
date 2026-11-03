package PetCareEmpresa.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import PetCareEmpresa.modelo.*;

public class GestionMascotas {
    private List<Mascota> mascotas;
    private List<Dueno> duenos; //colecciones de duenos y mascotas

    //inicializa las colecciones
    public GestionMascotas() {
        this.mascotas = new ArrayList<>();
        this.duenos = new ArrayList<>();
    }

    public void agregarDueno(Dueno dueno) {
        //verificamos que el objeto dueño no sea null
        Objects.requireNonNull(dueno, "No se puede registrar un dueño vacío");
        if (dueno.getCorreo() == null || dueno.getCorreo().isBlank()) { //si dejamos el espacio en blanco
            throw new IllegalArgumentException("El correo electrónico es obligatorio.");
        }
        //se compara el id para ver si no existe ya
        for (Dueno duenoExistente : duenos) {
            if (duenoExistente.getIdPersona() == dueno.getIdPersona()) {
                throw new IllegalArgumentException("El dueño ya existe en el sistema.");
            }

            if (duenoExistente.getCorreo() != null && duenoExistente.getCorreo().equalsIgnoreCase(dueno.getCorreo())){
                throw new IllegalArgumentException("El correo electrónico ya está registrado.");
            }
        }
        //se agrega al catalogo si pasa ambas verificaciones
        this.duenos.add(dueno);
    }

    //agergar una mascota nueva
    public void agregarMascota(Mascota mascota) {
        Objects.requireNonNull(mascota, "No se puede registrar una mascota vacía");
        Dueno dueno = Objects.requireNonNull(mascota.getDueno(), "La mascota debe tener un dueño");
        boolean duenoRegistrado = false;
        for (Dueno duenoExistente : duenos) {
            if (duenoExistente.getIdPersona() == dueno.getIdPersona()) {
                duenoRegistrado = true;
                break;
            }
        }
        if (!duenoRegistrado) {
            throw new IllegalArgumentException("El dueño no está registrado en el sistema.");
        }
        for (Mascota mascotaExistente : mascotas) {
            if (mascotaExistente.getIdMascota() == mascota.getIdMascota()) {
                throw new IllegalArgumentException("La mascota ya existe en el sistema.");
            }
        }

        this.mascotas.add(mascota);
    }

    //obtener todas las mascotas registradas
    public List<Mascota> listarMascotas() {
        return List.copyOf(mascotas);
    }

    //obtener todos los duenos registrados
    public List<Dueno> listarDuenos() {
        return List.copyOf(duenos);
    }

    //buscar una mascota por su id
    public Mascota buscarMascota(int idMascota) {
        for (Mascota mascotaExistente : mascotas) {
            if (mascotaExistente.getIdMascota() == idMascota) {
                return mascotaExistente;
            }
        }

        throw new IllegalArgumentException("La mascota no existe en el sistema.");
    }

    //buscar un dueno
    public Dueno buscarDueno(int idDueno) {
        for (Dueno duenoExistente : duenos) {
            if(duenoExistente.getIdPersona() == idDueno) {
                return duenoExistente;
            }
        }
        throw new IllegalArgumentException("El dueno no existe en el sistema.");
    }

    //eliminar una mascota por su id
    public void eliminarMascota(int idMascota) {
        Mascota mascotaObjetivo = null;
        for (Mascota mascotaExistente : mascotas) {
            if (mascotaExistente.getIdMascota() == idMascota) {
                mascotaObjetivo = mascotaExistente; //guarda en un nuevo objeto si lo encuentra
                break;
            }
        }
        if (mascotaObjetivo == null) { //si no existe
            throw new IllegalArgumentException("La mascota no existe en el sistema.");
        }
        mascotas.remove(mascotaObjetivo); //elimina el objeto con la mascota guardada
    }


    public List<Mascota> buscarMascotasPorDueno(int idDueno) {
        buscarDueno(idDueno);
        List<Mascota> mascotasAsociadas = new ArrayList<>();

        for (Mascota mascotaExistente : mascotas) {
            if (mascotaExistente.getDueno().getIdPersona() == idDueno) {
                mascotasAsociadas.add(mascotaExistente);
            }
        }
        return List.copyOf(mascotasAsociadas);
    }

    //contar mascotas registradas en el sistema
    public int contarMascotas(){
        return mascotas.size();
    }

    //contar cuantas mascotas tiene un msimo dueno
    public int contarMascotasPorDueno(int idDueno){
        buscarDueno(idDueno);
        int cantidadAsociadaMascotas = 0;

        for (Mascota mascotaExistente : mascotas) {
            if (mascotaExistente.getDueno().getIdPersona() == idDueno) {
                cantidadAsociadaMascotas++;
            }
        }
        return cantidadAsociadaMascotas;
    }

    //revisar el historial clinico de una mascota
    public HistorialClinico consultarHistorial(int idMascota){
       Mascota objetivo = buscarMascota(idMascota);
       return objetivo.getHistorialClinico();
    }
}
