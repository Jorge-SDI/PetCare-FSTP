package PetCareEmpresa.modelo;

//clase Padre
public abstract class Persona {
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private int idPersona; //se le asigna automaticamente un id
    private static int contadorId = 1;

    //constructor vacio
    public Persona() {
        this.nombre = "";
        this.apellido = "";
        this.telefono = "";
        this.correo = "";
        this.idPersona = 0;
    }

    //inicializa sus atributos e id se asigna automaticamente
    public Persona(String nombre, String apellido, String telefono, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.idPersona = contadorId;
        Persona.contadorId++;
    }

    //asignar un nombre a la persona
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //obtener el nombre de la persona
    public String getNombre() {
        return nombre;
    }

    //obtener el apellido de la persona
    public String getApellido() {
        return apellido;
    }

    //obtener el telefono de la persona
    public String getTelefono() {
        return telefono;
    }

    //obtener el correo de la persona
    public String getCorreo() {
        return correo;
    }

    //obtener el id de la persona
    public int getIdPersona() {
        return idPersona;
    }

    //datos generales de la persona
    @Override
    public String toString() {
        return "Persona: " +
                "Nombre: '" + nombre + '\'' +
                ", apellido: " + apellido + '\'' +
                ", telefono: " + telefono + '\'' +
                ", correo: " + correo +
                ", idPersona: " + idPersona;
    }
}
