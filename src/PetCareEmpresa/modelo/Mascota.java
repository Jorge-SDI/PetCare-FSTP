package PetCareEmpresa.modelo;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Mascota {
    private final int idMascota;
    private String nombre;
    private int edad;
    private double peso;
    private Dueno dueno;
    private HistorialClinico  historialClinico;

    public Mascota(int idMascota, String nombre, int edad, double peso, Dueno dueno) {
        if(idMascota <= 0){
            throw new IllegalArgumentException("Id mascota invalido");
        }
        this.idMascota = idMascota;
        setNombre(nombre);
        setEdad(edad);
        setPeso(peso);
        this.dueno = Objects.requireNonNull(dueno);
        this.historialClinico = new HistorialClinico(LocalDate.now())
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if(edad < 0){
            throw new IllegalArgumentException("El edad no puede ser cero o negativo.");
        }
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (!Double.isFinite(peso) || peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser un valor positivo y valido.");
        }
        this.peso = peso;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public Dueno getDueno() {
        return dueno;
    }

    public HistorialClinico getHistorialClinico() {
        return historialClinico;
    }

    public abstract void emitirSonido();

    @Override
    public String toString() {
        return "Mascota " +
                "Numero de mascota: " + idMascota +
                "Nombre: " + nombre +
                ", edad: " + edad +
                ", peso: " + peso +
                ", dueno: " + dueno.getNombre();
    }
}
