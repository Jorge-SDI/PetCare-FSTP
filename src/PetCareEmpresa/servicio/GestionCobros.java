package PetCareEmpresa.servicio;

import PetCareEmpresa.Veterinario;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GestionCobros {
    private final List<Cobro> cobros; //coleccion de todos los cobros hechos por servicios

    //inicializa la coleccion
    public GestionCobros() {
        this.cobros = new ArrayList<>();
    }

    // Registrar un nuevo cobro
    public void registrarCobro(Cobro cobro) {
        Objects.requireNonNull(cobro, "No puede haber cobros nulos");

        for (Cobro cobroExistente : cobros) {
            if (cobroExistente.getIdCobro() == cobro.getIdCobro()) {
                throw new IllegalArgumentException("El cobro ya se encuentra registrado");
            }
        }
        cobros.add(cobro);

        System.out.println("Cobros almacenados: " + cobros.size());
    }

    // Listar todos los cobros
    public List<Cobro> listarCobros() {
        return List.copyOf(cobros);
    }

    // Buscar un cobro por su identificador
    public Cobro buscarCobro(int idCobro) {
        for (Cobro cobroExistente : cobros) {
            if (cobroExistente.getIdCobro() == idCobro) {
                return cobroExistente;
            }
        }
        throw new IllegalArgumentException("El cobro no existe");
    }

    // Calcular los ingresos totales
    public BigDecimal calcularIngresosTotales() {
        BigDecimal ingresosTotales = BigDecimal.ZERO;
        for (Cobro cobroExistente : cobros) {
            ingresosTotales = ingresosTotales.add(cobroExistente.getMonto());
        }
        return ingresosTotales;
    }

    // Contar los cobros registrados
    public int contarCobros() {
        return cobros.size();
    }

    //calcula cuanto cobra un veterinario en cada consulta que hace
    public BigDecimal calcularIngresosPorVeterinario(int idVeterinario) {
        BigDecimal ingresos = BigDecimal.ZERO;
        for (Cobro cobroExistente : cobros) {
            if (cobroExistente.getVeterinario().getIdPersona() == idVeterinario) {
                ingresos = ingresos.add(cobroExistente.getMonto());
            }
        }
        return ingresos;
    }

}