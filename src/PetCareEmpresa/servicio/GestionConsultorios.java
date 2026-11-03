package PetCareEmpresa.servicio;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

import PetCareEmpresa.modelo.Consultorio;

//gestiona los consultorios existentes en la clinica
public class GestionConsultorios {
    private List<Consultorio> consultorios; //coleccion con todos los consultorios

    //inicializa la coleccion
    public GestionConsultorios(){
        consultorios = new ArrayList<>();
    }

    //agerga un consultorio nuevo
    public void agregarConsultorio(Consultorio consultorio){
        Objects.requireNonNull(consultorio, "No puede asignarse un consultorio nulo");

        for (Consultorio consultorioExistente : consultorios) {
            if(consultorioExistente.getNumeroConsultorio() == consultorio.getNumeroConsultorio()){ //revisa que no exista
                throw new IllegalArgumentException("El consultorio ya existe!");
            }
        }
        consultorios.add(consultorio); //agrega el consultorio
    }
    //muestra todos los consultorios existentes
    public List<Consultorio> listarConsultorios() {
        return List.copyOf(consultorios);
    }

    //buscar un consultorio mediante su identificador
    public Consultorio buscarConsultorio(int idConsultorio){
        for (Consultorio consultorioExistente : consultorios) {
            if(consultorioExistente.getNumeroConsultorio() == idConsultorio){
                return consultorioExistente;
            }
        }
        throw new IllegalArgumentException("El consultorio no existe!"); //si no es encontrado
    }

    //eliminar un consultorio mediante su id
    public void eliminarConsultorio(int idConsultorio){
        Consultorio consultorioObjetivo = null;
        for (Consultorio consultorioExistente : consultorios) {
            if(consultorioExistente.getNumeroConsultorio() == idConsultorio){
                consultorioObjetivo = consultorioExistente; //si es encontrado lo guarda en una variable objeto
                break;
            }
        }
        if(consultorioObjetivo == null){ //si no es encontrado
            throw new IllegalArgumentException("El consultorio no existe!");
        }
        consultorios.remove(consultorioObjetivo); //elimina el consultorio de la variable objeto
    }
}
