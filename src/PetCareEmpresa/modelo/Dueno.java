package PetCareEmpresa.modelo;

//hereda atributos de Persona
public class Dueno extends Persona {
    private String direccion; //atributo propio

    //inicializa sus atributos y los heredados
    public Dueno(String nombre, String apellido, String telefono, String correo, String direccion) {
        super(nombre, apellido, telefono, correo);
        this.direccion = direccion;
    }
}
