package PetCareEmpresa.modelo;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import PetCareEmpresa.modelo.Consulta;

public class HistorialClinico {
    //conjunto de todas las consultas de una mascota en especifico
    private LocalDate fechaCreacion;
    private List<Consulta> consultas;

    public HistorialClinico(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        this.consultas = new ArrayList<>();
    }

    public void agregarConsulta(Consulta consulta) {
        this.consultas.add(consulta);
    }

    public void mostrarConsultas() {
        System.out.println("Historial clinico actual");
        for (Consulta x : consultas) {
            System.out.println("-----------------------------------");
            System.out.println(x);
        }
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
}
