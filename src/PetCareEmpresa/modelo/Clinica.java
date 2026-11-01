package PetCareEmpresa.modelo;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Clinica {
    private String nombre;
    private String direccion;
    private List<Consultorio> consultorios;


    public Clinica(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.consultorios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void agregarConsultorio(Consultorio consultorio){
        this.consultorios.add(Objects.requireNonNull(consultorio));
        for(Consultorio consultorioExistente : consultorios){
            if(consultorio.getNumeroConsultorio() == consultorioExistente.getNumeroConsultorio()){
                throw new IllegalArgumentException("Ya este un consultorio agregado con el mismo numero");
            }
        }
    }

    public List<Consultorio> getConsultorios() {
        return List.copyOf(consultorios);
    }
}
