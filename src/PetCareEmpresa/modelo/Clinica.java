package PetCareEmpresa.modelo;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Clinica {
    private String nombre;
    private String direccion;
    private List<Consultorio> consultorios; //almacena todos los consultorios que tiene disponibles

    //se inicializan sus atributos
    public Clinica(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.consultorios = new ArrayList<>();
    }

    //obtener el nombre de la clinica
    public String getNombre() {
        return nombre;
    }

    //asignar un nombre a la clinica
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
