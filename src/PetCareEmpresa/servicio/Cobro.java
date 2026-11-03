package PetCareEmpresa.servicio;

import PetCareEmpresa.Veterinario;
import PetCareEmpresa.modelo.Cita;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

//registra los cobros realizados por una consulta y/o servicio extra
public class Cobro {
    //asigna un id automaticamente el realizarse un cobro
    private static int contadorCobros = 1;
    private final int idCobro;
    private final BigDecimal monto;
    private final LocalDate fecha; //fecha de pago
    private final MetodoPago metodoPago; //metodo de pago usado
    private final CalcularCosto calcularCostoCobro; //objeto de la interfaz para obtener el costo/importe
    private final Veterinario veterinario; //veterinario que cobra por la consulta o servicio
    private final Cita cita; //cita de la que se desprende el pago

    //inicializa los atributos referenciados y propios
    public Cobro(CalcularCosto calcularCostoCobro, Veterinario veterinario, MetodoPago metodoPago, Cita cita) {
        this.calcularCostoCobro = Objects.requireNonNull(calcularCostoCobro, "El servicio no puede ser nulo");
        this.veterinario = Objects.requireNonNull(veterinario, "El veterinario no puede ser nulo");
        this.metodoPago = Objects.requireNonNull(metodoPago, "El método de pago no puede ser nulo");
        this.cita = Objects.requireNonNull(cita, "La cita no puede ser nula");
        double costo = calcularCostoCobro.calcularCosto();
        if (!Double.isFinite(costo) || costo <= 0) { //valida que no sea 0
            throw new IllegalArgumentException("El costo del servicio debe ser válido y mayor que cero");
        }
        this.monto = BigDecimal.valueOf(costo);
        this.fecha = LocalDate.now();
        this.idCobro = contadorCobros++;
    }

    //obtener el numero de pago
    public int getIdCobro() {
        return idCobro;
    }

    //obtener cantidad pagada
    public BigDecimal getMonto() {
        return monto;
    }

    //obtener veterinario que cobró
    public Veterinario getVeterinario() {
        return veterinario;
    }

    //obtener la fecha en que se realizó
    public LocalDate getFecha() {
        return fecha;
    }

    //obtener de que forma se pagó
    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    //obtener cita de la que se origina el pago
    public Cita getCita() {
        return cita;
    }

    //obtener que objeto genera el cobro
    public CalcularCosto getCalcularCostoCobro() {
        return calcularCostoCobro;
    }
}
