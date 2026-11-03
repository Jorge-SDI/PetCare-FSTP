package PetCareEmpresa.modelo;

//hereda atributos de Persona
public class Recepcionista extends Persona {
    private String turno; //atributo propio

    //inicializa sus valores
    public Recepcionista(String nombre, String apellido, String telefono, String correo, String turno) {
        super(nombre, apellido, telefono, correo);
        this.turno = turno;
    }

    //obtener el turno del recepcionista
    public String getTurno() {
        return turno;
    }

    //asignar turno al recepcionista
    public void setTurno(String turno) {
        this.turno = turno;
    }
}
