package PetCareEmpresa.modelo;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

//coleccion de todas las consultas de una mascota en especifico (o de varias)
public class HistorialClinico {
    private LocalDate fechaCreacion; //fecha desde la primer consulta de la mascota
    private List<Consulta> consultas; //guarda todas las consultas de esa mascota

    //inicializa sus atributos
    public HistorialClinico(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        this.consultas = new ArrayList<>();
    }

    //agrega consulta de la mascota para su historial
    public void agregarConsulta(Consulta consulta) {
        this.consultas.add(Objects.requireNonNull(consulta));
    }

    //muestra las consultas hechas a una mascota
    public void mostrarConsultas() {
        System.out.println("Historial clínico actual");
        for (Consulta consultaAnterior : consultas) {
            System.out.println("-----------------------------------");
            System.out.println(consultaAnterior.toString());
        }
    }

    //listar todas las consultas al momento
    public List<Consulta> getConsultas() {
        return List.copyOf(consultas);
    }

    //cantidad de consultas en el historial clínico que posee una mascota
    public int getCantidadConsultas() {
        return consultas.size();
    }

    //fecha de creacion del historial de la mascota
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
}
