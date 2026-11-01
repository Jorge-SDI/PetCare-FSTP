package PetCareEmpresa.modelo;

public abstract class Persona {
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private int idPersona;
    private static int contadorId = 1;

    public Persona() {
        this.nombre = "";
        this.apellido = "";
        this.telefono = "";
        this.correo = "";
        this.idPersona = 0;
    }

    public Persona(String nombre, String apellido, String telefono, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.idPersona = contadorId;
        Persona.contadorId++;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public int getIdPersona() {
        return idPersona;
    }

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
