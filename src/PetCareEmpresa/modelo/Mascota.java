package PetCareEmpresa.modelo;

import java.time.LocalDate;
import java.util.Objects;

//clase Padre para los animales
public abstract class Mascota {
    private final int idMascota;
    private static int contadorIdMascota = 1;
    private String nombre;
    private int edad;
    private double peso;
    private Dueno dueno; //deben tener un dueno al que pertenece
    private HistorialClinico historialClinico; //cada mascota debe poseer un historial clinico

    //se inicializan sus atributos
    public Mascota(String nombre, int edad, double peso, Dueno dueno) {
        setNombre(nombre);
        setEdad(edad);
        setPeso(peso);
        this.idMascota = contadorIdMascota; //el id se asigna automaticamente segun sean registrados
        contadorIdMascota++;
        this.dueno = Objects.requireNonNull(dueno); //se asigna un dueno
        this.historialClinico = new HistorialClinico(LocalDate.now()); //se crea un historial para esa mascota
    }

    //nombre de la mascota
    public String getNombre() {
        return nombre;
    }

    //asignar un nombre a la mascota
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    //obtener la edad de la mascota
    public int getEdad() {
        return edad;
    }

    //asignar una edad a la mascota
    public void setEdad(int edad) {
        if(edad < 0){
            throw new IllegalArgumentException("El edad no puede ser cero o negativo.");
        }
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    //asignar un peso a la mascota
    public void setPeso(double peso) {
        if (!Double.isFinite(peso) || peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser un valor positivo y valido.");
        }
        this.peso = peso;
    }

    //recuperar el identificador de la mascota
    public int getIdMascota() {
        return idMascota;
    }

    //consultar a que dueno le pertenece
    public Dueno getDueno() {
        return dueno;
    }

    //obtener el historial clinico completo de la mascota
    public HistorialClinico getHistorialClinico() {
        return historialClinico;
    }

    //metodo para clases hijas
    //obliga a realizar un sonido caracteristico
    public abstract void emitirSonido();

    //datos generales de la mascota
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
