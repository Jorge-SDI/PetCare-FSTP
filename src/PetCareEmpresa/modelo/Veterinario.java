package PetCareEmpresa;

import PetCareEmpresa.modelo.Persona;
import PetCareEmpresa.modelo.Clinica;

import java.util.Objects;
//hereda atributos de Persona
public class Veterinario extends Persona {
    private String cedulaProfesional; //atributos propios
    private String especialidad; //atributos propios
    private Clinica clinica; //pertenece a una clinica

    //inicializa valores propios y heredados
    public Veterinario(String nombre, String apellido, String telefono, String correo, String cedulaProfesional, String especialidad) {
        super(nombre, apellido, telefono, correo);
        this.cedulaProfesional = cedulaProfesional;
        this.especialidad = especialidad;
    }

    //obtener la cedula del veterinario
    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    //obtener la especialidad medica del veterinario
    public String getEspecialidad() {
        return especialidad;
    }

    //asignar una clinica al veterinario
    public void setClinica(Clinica clinica) {
        this.clinica = Objects.requireNonNull(clinica);
    }
}
