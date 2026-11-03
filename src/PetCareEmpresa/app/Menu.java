package PetCareEmpresa.app;

//se separó de main para tener mas controladas las responsabilidades de cada clase
import PetCareEmpresa.Veterinario;
import PetCareEmpresa.modelo.*;
import PetCareEmpresa.servicio.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

//se encarga de interactuar con el usuario pidiendo datos para los registros, contempla todas
//las funciones posibles del menu
public class Menu {
    private Scanner sc;
    private GestionMascotas mascotas;
    private GestionVeterinarios veterinarios;
    private GestionConsultorios consultorios;
    private GestionCitas gestionCitas;
    private GestionCobros cobros;
    private Clinica clinica;


    public Menu(GestionMascotas mascotas, GestionVeterinarios veterinarios, GestionConsultorios consultorios,
                GestionCitas gestionCitas, GestionCobros cobros, Clinica clinica){
        this.sc = new Scanner(System.in);
        this.mascotas = mascotas;
        this.veterinarios = veterinarios;
        this.consultorios = consultorios;
        this.gestionCitas = gestionCitas;
        this.cobros = cobros;
        this.clinica = clinica;
    }

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("========== PETCARE ==========");
            System.out.println("1. Registrar dueño y mascota");
            System.out.println("2. Registrar veterinario y asignarle clinica");
            System.out.println("3. Agendar cita");
            System.out.println("4. Atender o cancelar cita");
            System.out.println("5. Generar comprobante de una cita atendida");
            System.out.println("6. Consultar historial clínico de una mascota");
            System.out.println("7. Listar mascotas y sus sonidos");
            System.out.println("8. Consultar cobros por veterinario");
            System.out.println("9. Dar de baja una mascota");
            System.out.println("0. Salir");
            opcion = leerEntero(sc, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    registrarDueno();
                    break;
                case 2:
                    registroAsignacionVeterinario();
                    break;
                case 3:
                    agendarCita();
                    break;
                case 4:
                    atenderOCancelarCita();
                    break;
                case 5:
                    generarComprobante();
                    break;
                case 6:
                    consultarHistorialClinico();
                    break;
                case 7:
                    listarSonidosAnimales();
                    break;
                case 8:
                    consultarIngresosVeterinario();
                    break;
                case 9:
                    darDeBajaMascota();
                    break;
                case 0:
                    System.out.println("¡Gracias por utilizar PetCare!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private String leerTexto(Scanner sc, String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();
            //verificar que los campos que requieren texto no estén vacíos
            if (texto.isEmpty()) {
                System.out.println("Error: este campo es obligatorio!");
            }
        } while (texto.isEmpty());

        return texto;
    }

    private int leerEntero(Scanner sc, String mensaje) {
        int numero;
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                numero = sc.nextInt();
                sc.nextLine();
                return numero;
            } else {
                System.out.println("Error: debes ingresar un número entero.");
                sc.nextLine();
            }
        }
    }

    private double leerDecimal(Scanner sc, String mensaje) {
        double numero;
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextDouble()) {
                numero = sc.nextDouble();
                sc.nextLine();
                return numero;
            } else {
                System.out.println("Error: debes ingresar un número válido.");
                sc.nextLine();
            }
        }
    }

    private LocalDate leerFecha(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return LocalDate.parse(sc.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("Error: utiliza el formato AAAA-MM-DD.");
            }
        }
    }

    private LocalTime leerHora(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return LocalTime.parse(sc.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("Error: utiliza el formato HH:MM.");
            }
        }
    }

    private void registrarDueno() {
        System.out.println("------ Registro de dueño ------");
        String nombre = leerTexto(sc, "Ingrese el nombre:");
        String apellido = leerTexto(sc, "Ingrese el apellido:");
        String telefono = leerTexto(sc, "Ingrese el teléfono:");
        String correo = leerTexto(sc, "Ingrese el correo electrónico:");
        String direccion = leerTexto(sc, "Ingrese la dirección:");

        Dueno nuevoDueno = new Dueno(nombre, apellido, telefono, correo, direccion);
        mascotas.agregarDueno(nuevoDueno);
        System.out.println("¡Dueño registrado correctamente!");

        registrarMascota(nuevoDueno);
    }

    private void registrarMascota(Dueno dueno) {
        System.out.println("------ Registro de mascota ------");
        System.out.println("1. Perro");
        System.out.println("2. Gato");
        System.out.println("3. Ave");
        int opcion = leerEntero(sc, "Seleccione el tipo de mascota:");

        switch (opcion) {
            case 1:
                String nombrePerro = leerTexto(sc, "Nombre del perro:");
                int edadPerro = leerEntero(sc, "Edad del perro:");
                double pesoPerro = leerDecimal(sc, "Peso del perro:");
                String raza = leerTexto(sc, "Raza del perro:");
                String energia = leerTexto(sc, "Nivel de energía:");

                Perro perro = new Perro(nombrePerro, edadPerro, pesoPerro, dueno, raza, energia);

                mascotas.agregarMascota(perro);
                System.out.println("¡Perro registrado correctamente!");
                break;

            case 2:
                String nombreGato = leerTexto(sc, "Nombre del gato:");
                int edadGato = leerEntero(sc, "Edad del gato:");
                double pesoGato = leerDecimal(sc, "Peso del gato:");
                boolean domestico = leerTexto(sc, "¿Es doméstico? (true/false): ").equalsIgnoreCase("true");

                Gato gato = new Gato(nombreGato, edadGato, pesoGato, dueno, domestico);
                mascotas.agregarMascota(gato);
                System.out.println("¡Gato registrado correctamente!");
                break;

            case 3:
                String nombreAve = leerTexto(sc, "Nombre del ave:");
                int edadAve = leerEntero(sc, "Edad del ave:");
                double pesoAve = leerDecimal(sc, "Peso del ave:");
                double longitudAlas = leerDecimal(sc, "Longitud de las alas:");

                Ave ave = new Ave(nombreAve, edadAve, pesoAve, dueno, longitudAlas);

                mascotas.agregarMascota(ave);
                System.out.println("¡Ave registrada correctamente!");
                break;

            default:
                System.out.println("Tipo de mascota no válido.");
        }
    }

    public void registroAsignacionVeterinario() {
        System.out.println("------ Registro de veterinario ------");

        String nombre = leerTexto(sc, "Ingrese el nombre:");
        String apellido = leerTexto(sc, "Ingrese el apellido:");
        String telefono = leerTexto(sc, "Ingrese el teléfono:");
        String correo = leerTexto(sc, "Ingrese el correo electrónico:");
        String cedula = leerTexto(sc, "Ingrese la cédula profesional:");
        String especialidad = leerTexto(sc, "Ingrese la especialidad:");

        Veterinario nuevoVeterinario = new Veterinario(nombre, apellido, telefono, correo, cedula, especialidad);
        veterinarios.agregarVeterinario(nuevoVeterinario);
        veterinarios.asignarClinica(nuevoVeterinario.getIdPersona(), clinica);

        System.out.println("¡Veterinario registrado y asignado a la clínica correctamente!");
    }

    private void agendarCita() {
        System.out.println("------ Agendar cita ------");

        System.out.println("Mascotas registradas:");
        for (Mascota mascota : mascotas.listarMascotas()) {
            System.out.println("ID: " + mascota.getIdMascota() + " | Nombre: " + mascota.getNombre());
        }

        int idMascota = leerEntero(sc, "Ingrese el ID de la mascota:");
        Mascota mascota = mascotas.buscarMascota(idMascota);

        System.out.println("Veterinarios registrados:");
        for (Veterinario veterinario : veterinarios.listarVeterinarios()) {
            System.out.println("ID: " + veterinario.getIdPersona() + " | Nombre: " + veterinario.getNombre());
        }

        int idVeterinario = leerEntero(sc, "Ingrese el ID del veterinario:");
        Veterinario veterinario = veterinarios.buscarVeterinario(idVeterinario);

        System.out.println("\nConsultorios registrados:");
        for (Consultorio consultorio : consultorios.listarConsultorios()) {
            System.out.println("Número: " + consultorio.getNumeroConsultorio());
        }

        int numeroConsultorio = leerEntero(sc, "Ingrese el número del consultorio:");
        Consultorio consultorio = consultorios.buscarConsultorio(numeroConsultorio);

        LocalDate fecha = leerFecha("Ingrese la fecha (AAAA-MM-DD):");
        LocalTime hora = leerHora("Ingrese la hora (HH:MM):");

        Cita nuevaCita = new Cita(fecha, hora, mascota, veterinario, consultorio);

        gestionCitas.agregarCita(nuevaCita);
        System.out.println("¡Cita registrada correctamente!");
        System.out.println("ID de la cita: " + nuevaCita.getIdCita());
    }

    private void atenderOCancelarCita() {
        System.out.println("------ Atención o cancelación de citas ------");
        //verificamos que haya citas registradas antes de listarlas
        if (gestionCitas.listarCitas().isEmpty()){
            System.out.println("No hay citas registradas en el sistema.");
            return;
        }
        // Mostrar citas registradas al momento
        for (Cita cita : gestionCitas.listarCitas()) {
            System.out.println("ID: " + cita.getIdCita() + " | Mascota: " + cita.getMascota().getNombre()
                    + " | Veterinario: " + cita.getVeterinario().getNombre()
                    + " | Fecha: " + cita.getFecha()
                    + " | Hora: " + cita.getHora()
                    + " | Estado: " + cita.getEstadoCita());
        }
        //buscamos la cita
        int idCita = leerEntero(sc, "Ingrese el ID de la cita:");

        System.out.println("1. Marcar como atendida");
        System.out.println("2. Cancelar cita");
        int opcion = leerEntero(sc, "Seleccione una opción:");

        switch (opcion) {

            case 1:
                String diagnostico = leerTexto(sc, "Ingrese el diagnóstico:");
                String observaciones = leerTexto(sc, "Ingrese las observaciones:");
                String tratamiento = leerTexto(sc, "Ingrese el tratamiento:");

                gestionCitas.registrarCitaAtendida(idCita, diagnostico, observaciones, tratamiento);

                Cita citaAtendida = gestionCitas.buscarCita(idCita);
                registrarServiciosAdicionales(citaAtendida);
                System.out.println("¡Atención registrada correctamente!");
                break;
            case 2:
                gestionCitas.cancelarCita(idCita);
                System.out.println("¡Cita cancelada correctamente!");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private void generarComprobante() {
        System.out.println("========== COMPROBANTE PETCARE ==========");
        if (gestionCitas.listarCitas().isEmpty()) {
            System.out.println("No hay citas registradas.");
            return;
        }
        // Mostramos citas
        for (Cita cita : gestionCitas.listarCitas()) {
            System.out.println("ID: " + cita.getIdCita()
                    + " | Mascota: " + cita.getMascota().getNombre()
                    + " | Estado: " + cita.getEstadoCita());
        }

        //seleccionamos cita de la que se quiere comprobante
        int idCita = leerEntero(sc, "Ingrese el ID de la cita:");
        Cita cita = gestionCitas.buscarCita(idCita);

        // Comprobamos que la cita haya sido atendida
        if (cita.getEstadoCita() != EstadoCita.ATENDIDA) {
            System.out.println("No se puede generar el comprobante: "
                    + "la cita todavía no ha sido atendida.");
            return;
        }

        // Recuperamos información clínica
        Consulta consulta = cita.getConsulta();
        if (consulta == null) {
            System.out.println("La cita no tiene una consulta registrada.");
            return;
        }

        // Datos del dueño
        Dueno dueno = cita.getMascota().getDueno();
        System.out.println("---------- DATOS DE LA CITA ----------");
        System.out.println("Folio: " + cita.getIdCita());
        System.out.println("Fecha: " + cita.getFecha());
        System.out.println("Hora: " + cita.getHora());
        System.out.println("Consultorio: " + cita.getConsultorio().getNumeroConsultorio());
        System.out.println("---------- DATOS DE LA MASCOTA ----------");
        System.out.println("Nombre: " + cita.getMascota().getNombre());
        System.out.println("---------- DATOS DEL VETERINARIO ----------");
        System.out.println("Nombre: " + cita.getVeterinario().getNombre() + " " + cita.getVeterinario().getApellido());
        System.out.println("Cédula: " + cita.getVeterinario().getCedulaProfesional());
        System.out.println("---------- INFORMACIÓN CLÍNICA ----------");
        System.out.println("Diagnóstico: " + consulta.getDiagnostico());
        System.out.println("Observaciones: " + consulta.getObservaciones());
        System.out.println("Tratamiento: " + consulta.getTratamiento());

        // Desglose de pagos
        System.out.println("---------- DESGLOSE DE PAGOS ----------");
        BigDecimal total = BigDecimal.ZERO;
        boolean hayCobros = false;

        System.out.println("Cantidad de cobros registrados: " + cobros.contarCobros());
        for (Cobro cobro : cobros.listarCobros()) {
            if (cobro.getCita().getIdCita() == cita.getIdCita()) {
                hayCobros = true;
                System.out.println("Cobro: " + cobro.getIdCobro());
                System.out.println("Servicio: " + cobro.getCalcularCostoCobro().getClass().getSimpleName());
                System.out.println("Fecha: " + cobro.getFecha());
                System.out.println("Método de pago: " + cobro.getMetodoPago());
                System.out.println("Importe: $" + cobro.getMonto());
                total = total.add(cobro.getMonto());
            }
        }
        if (!hayCobros) {
            System.out.println("No se registraron servicios adicionales.");
        }
        System.out.println("----------------------------------------");
        System.out.println("TOTAL PAGADO: $" + total);
        System.out.println("========================================");
    }

    private void registrarCobroServicio(CalcularCosto servicio, Cita cita) {
        System.out.println("\n========== MÉTODO DE PAGO ==========");
        System.out.println("1. Efectivo");
        System.out.println("2. Tarjeta");
        System.out.println("3. Transferencia");
        int opcion = leerEntero(sc, "Seleccione el método de pago:");

        MetodoPago metodoPago;

        switch (opcion) {
            case 1:
                metodoPago = MetodoPago.EFECTIVO;
                break;
            case 2:
                metodoPago = MetodoPago.TARJETA;
                break;
            case 3:
                metodoPago = MetodoPago.TRANSFERENCIA;
                break;
            default:
                throw new IllegalArgumentException("Método de pago no válido");
        }

        Cobro nuevoCobro = new Cobro(servicio, cita.getVeterinario(), metodoPago, cita);

        cobros.registrarCobro(nuevoCobro);

        System.out.println("Servicio registrado correctamente.");
        System.out.println("Importe: $" + nuevoCobro.getMonto());
    }

    private void registrarServiciosAdicionales(Cita cita) {
        boolean consultaRegistrada = false;
        boolean vacunacionRegistrada = false;
        boolean cirugiaRegistrada = false;

        int opcion;

        do {
            System.out.println("\n========== SERVICIOS REALIZADOS ==========");
            System.out.println("1. Consulta general");
            System.out.println("2. Vacunación");
            System.out.println("3. Cirugía");
            System.out.println("0. Finalizar selección");

            opcion = leerEntero(sc, "Seleccione un servicio:");

            switch (opcion) {
                case 1:
                    if (consultaRegistrada) {
                        System.out.println("La consulta general ya fue registrada.");
                        break;
                    }
                    ConsultaGeneral consultaGeneral = new ConsultaGeneral(
                            "Consulta general",
                            "Evaluación médica general de la mascota"
                    );
                    registrarCobroServicio(consultaGeneral, cita);
                    consultaRegistrada = true;
                    break;
                case 2:
                    if (vacunacionRegistrada) {
                        System.out.println("La vacunación ya fue registrada.");
                        break;
                    }
                    double costoVacunacion = leerDecimal(sc, "Ingrese el costo de la vacunación:");

                    String nombreVacuna = leerTexto(sc, "Ingrese el nombre de la vacunación:");

                    String descripcionVacuna = leerTexto(sc, "Ingrese la descripción:");

                    Vacunacion vacunacion = new Vacunacion(costoVacunacion, nombreVacuna, descripcionVacuna);

                    registrarCobroServicio(vacunacion, cita);
                    vacunacionRegistrada = true;
                    break;
                case 3:
                    if (cirugiaRegistrada) {
                        System.out.println("La cirugía ya fue registrada.");
                        break;
                    }

                    int horas = leerEntero(sc, "Ingrese las horas de quirófano:");
                    int complejidad = leerEntero(sc, "Ingrese la complejidad de la cirugía:");
                    String nombreCirugia = leerTexto(sc, "Ingrese el nombre de la cirugía:");
                    String descripcionCirugia = leerTexto(sc, "Ingrese la descripción:");
                    Cirugia cirugia = new Cirugia(horas, complejidad, nombreCirugia, descripcionCirugia
                    );

                    registrarCobroServicio(cirugia, cita);
                    cirugiaRegistrada = true;
                    break;
                case 0:
                    System.out.println("Finalizando registro de servicios...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }

    private void consultarHistorialClinico() {
        System.out.println("========== HISTORIAL CLÍNICO ==========");
        //verificamos que haya mascotas registradas
        if (mascotas.listarMascotas().isEmpty()) {
            System.out.println("No hay mascotas registradas.");
            return;
        }

        // Mostrar mascotas disponibles
        for (Mascota mascota : mascotas.listarMascotas()) {
            System.out.println("ID: " + mascota.getIdMascota()
                    + " | Nombre: " + mascota.getNombre());
        }
        int idMascota = leerEntero(sc, "Ingrese el ID de la mascota:");
        Mascota mascota = mascotas.buscarMascota(idMascota);

        HistorialClinico historial = mascotas.consultarHistorial(idMascota);

        System.out.println("\nMascota: " + mascota.getNombre());
        System.out.println("Fecha de creación del historial: " + historial.getFechaCreacion());
        System.out.println("Cantidad de consultas: " + historial.getCantidadConsultas());

        if (historial.getCantidadConsultas() == 0) {
            System.out.println("Esta mascota todavía no tiene consultas registradas.");
            return;
        }

        historial.mostrarConsultas();
    }

    private void listarSonidosAnimales() {
        System.out.println("========== SONIDOS DE ANIMALES ==========");
        //verificamos que haya mascotas registradas
        if (mascotas.listarMascotas().isEmpty()) {
            System.out.println("No hay mascotas registradas.");
            return;
        }
        //recuperamos las mascotas y obtenemos sus sonidos
        for (Mascota mascota : mascotas.listarMascotas()) {
            System.out.println("\nMascota: " + mascota.getNombre());
            System.out.print("Sonido: ");
            mascota.emitirSonido();
        }
    }

    private void consultarIngresosVeterinario() {
        System.out.println("========== INGRESOS POR VETERINARIO ==========");
        //verificamos que haya veterinarios registrados
        if (veterinarios.listarVeterinarios().isEmpty()) {
            System.out.println("No hay veterinarios registrados.");
            return;
        }
        // Mostrar veterinarios disponibles
        for (Veterinario veterinario : veterinarios.listarVeterinarios()) {
            System.out.println("ID: " + veterinario.getIdPersona()
                    + " | Nombre: " + veterinario.getNombre()
                    + " " + veterinario.getApellido());
        }
        int idVeterinario = leerEntero(sc, "Ingrese el ID del veterinario:");
        Veterinario veterinario = veterinarios.buscarVeterinario(idVeterinario);

        BigDecimal total = cobros.calcularIngresosPorVeterinario(idVeterinario);

        System.out.println("\n---------- RESULTADO ----------");
        System.out.println("Veterinario: " + veterinario.getNombre() + " " + veterinario.getApellido());
        System.out.println("Total cobrado: $" + total);
        System.out.println("--------------------------------");
    }

    private void darDeBajaMascota() {
        System.out.println("========== BAJA DE MASCOTA ==========");
        //verificamos que haya mascotas para dar de baja
        if (mascotas.listarMascotas().isEmpty()) {
            System.out.println("No hay mascotas registradas.");
            return;
        }
        // Mostrar mascotas registradas
        for (Mascota mascota : mascotas.listarMascotas()) {
            System.out.println("ID: " + mascota.getIdMascota()
                    + " | Nombre: " + mascota.getNombre()
                    + " | Dueño: " + mascota.getDueno().getNombre());
        }

        int idMascota = leerEntero(sc, "Ingrese el ID de la mascota que desea dar de baja:");
        Mascota mascota = mascotas.buscarMascota(idMascota);

        System.out.println("¿Está seguro de dar de baja a " + mascota.getNombre() + "?");
        System.out.println("1. Sí");
        System.out.println("2. No");
        int opcion = leerEntero(sc, "Seleccione una opción:");

        switch (opcion) {
            case 1:
                mascotas.eliminarMascota(idMascota);
                System.out.println("La mascota ha sido dada de baja correctamente.");
                break;
            case 2:
                System.out.println("Operación cancelada.");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}