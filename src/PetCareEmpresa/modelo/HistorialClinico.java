package PetCareEmpresa.modelo;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class HistorialClinico {
    //conjunto de todas las consultas de una mascota en especifico
    private LocalDate fechaCreacion;
    private List<Consulta> consultas;

    public HistorialClinico(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        this.consultas = new ArrayList<>();
    }

    public void agregarConsulta(Consulta consulta) {
        this.consultas.add(Objects.requireNonNull(consulta));
    }

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

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
}
