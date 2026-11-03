# PetCare – Documentación de clases

Este documento resume las clases, interfaces y enumeraciones identificadas en los diagramas del proyecto **PetCare**. Los atributos y métodos se presentan de forma resumida; no se enumeran individualmente todos los getters y setters.

> **Nota importante:** `Comprobante` y `DetalleComprobante` están implementadas, pero actualmente `Menu.generarComprobante()` imprime el comprobante directamente con información de la cita y el cobro, sin utilizar esas dos clases.

## Tabla de clases

| Clase candidata | Tipo (concreta, abstracta o interfaz) | Atributos principales | Responsabilidades (métodos) | Justificación |
|---|---|---|---|---|
| `Persona` | Abstracta | `nombre`, `apellido`, `telefono`, `correo`, `idPersona`, `contadorId` | Constructores, getters/setters, `toString()` | Reúne los datos comunes de las personas y evita repetirlos en sus subclases. |
| `Dueno` | Concreta | `direccion` y atributos heredados de `Persona` | Constructor, `getDireccion()`, `setDireccion()` | Representa al propietario responsable de una o varias mascotas. |
| `Veterinario` | Concreta | `cedulaProfesional`, `especialidad`, `clinica` y atributos heredados | Constructor, getters de cédula y especialidad, `setClinica()` | Representa al profesional que atiende las citas y puede asociarse con una clínica. |
| `Recepcionista` | Concreta | `turno` y atributos heredados de `Persona` | Constructor, `getTurno()`, `setTurno()` | Representa al personal de recepción y registra su turno. |
| `Mascota` | Abstracta | `idMascota`, `contadorIdMascota`, `nombre`, `edad`, `peso`, `dueno`, `historialClinico` | Constructor, getters/setters, `emitirSonido()` abstracto, `toString()` | Define la estructura común de las mascotas y exige implementar su sonido en las subclases. |
| `Perro` | Concreta | `raza`, `nivelEnergia` y atributos heredados de `Mascota` | Constructor, `emitirSonido()`, getters/setters propios | Especializa a `Mascota` con características propias de los perros. |
| `Gato` | Concreta | `esDomestico` y atributos heredados de `Mascota` | Constructor, `emitirSonido()`, getter/setter de `esDomestico` | Especializa a `Mascota` y registra si el gato es doméstico. |
| `Ave` | Concreta | `longitudAlas` y atributos heredados de `Mascota` | Constructor, `emitirSonido()`, getter/setter de `longitudAlas` | Especializa a `Mascota` con una característica propia de las aves. |
| `Clinica` | Concreta | `nombre`, `direccion`, `consultorios` | Constructor, getters/setters de nombre y dirección | Representa la clínica y sus datos generales; declara una lista de consultorios. |
| `Consultorio` | Concreta | `numeroConsultorio` | Constructor, `getNumeroConsultorio()`, `setNumero()` | Representa un espacio físico que puede asignarse a una cita. |
| `EstadoCita` | Enumeración | `PROGRAMADA`, `ATENDIDA`, `CANCELADA` | Sin métodos propios indicados | Restringe el estado de una cita a valores definidos. |
| `Cita` | Concreta | `fecha`, `hora`, `mascota`, `veterinario`, `consultorio`, `estadoCita`, `consulta`, `idCita`, `contadorCitas` | Constructor, `registrarConsulta()`, getters, `setEstadoCita()`, `setFecha()`, `setHora()` | Representa la programación y seguimiento de una atención veterinaria. |
| `HistorialClinico` | Concreta | `fechaCreacion`, `consultas` | Constructor, `agregarConsulta()`, `mostrarConsultas()`, getters, `getCantidadConsultas()` | Conserva y permite consultar las consultas médicas de una mascota. |
| `Consulta` | Concreta | `fecha`, `diagnostico`, `observaciones`, `tratamiento` | Constructor, getters y setters | Almacena la información médica generada durante la atención. |
| `CalcularCosto` | Interfaz | No se indican atributos | `calcularCosto()` | Define un contrato para los objetos cuyo costo puede calcularse. |
| `Servicios` | Abstracta | `nombre`, `descripcion` | Constructor, getters/setters, `calcularCosto()` abstracto | Proporciona una base común para los servicios veterinarios. |
| `ConsultaGeneral` | Concreta | `TARIFA_BASE` (estático y constante) | Constructor, `getTarifaBase()`, `calcularCosto()` | Representa la consulta general y calcula su costo a partir de una tarifa base. |
| `Vacunacion` | Concreta | `costoVacunacion` | Constructor, getter/setter de costo, `calcularCosto()` | Modela el servicio de vacunación y calcula su costo. |
| `Cirugia` | Concreta | `horasQuirofano`, `complejidadCirugia` | Constructor, getters/setters correspondientes, `calcularCosto()` | Modela una cirugía considerando horas de quirófano y complejidad. |
| `Cobro` | Concreta | `idCobro`, `monto`, `fecha`, `metodoPago`, `calcularCostoCobro`, `veterinario`, `cita` | Constructor y getters | Registra el importe, fecha, método de pago y referencias al servicio, veterinario y cita. |
| `MetodoPago` | Enumeración | `EFECTIVO`, `TARJETA`, `TRANSFERENCIA` | Sin métodos propios indicados | Define las formas de pago permitidas. |
| `Comprobante` | Concreta | `folio`, `fechaEmision`, `detalles`, `cita` | Constructor, `agregarDetalle()`, getters/setters, `calcularTotal()` | Está diseñada para representar un comprobante y calcular su total; actualmente no se usa en el flujo de impresión del menú. |
| `DetalleComprobante` | Concreta | `cantidad`, `costoAplicado`, `servicio` | Constructor, getters/setters, `calcularSubtotal()` | Representa cada servicio de un comprobante y calcula su subtotal; actualmente no se usa en el flujo de impresión del menú. |
| `GestionMascotas` | Concreta | `mascotas`, `duenos` | Agregar, listar, buscar y eliminar mascotas; agregar/listar/buscar dueños; buscar mascotas por dueño; contar; consultar historial | Encapsula la administración de mascotas y dueños, separándola de la interfaz de consola. |
| `GestionVeterinarios` | Concreta | `veterinarios`, `gestionMascotas`, `clinica` | Agregar, listar, buscar y eliminar veterinarios; `asignarClinica()`; `getClinica()` | Centraliza la administración de veterinarios y su asignación a una clínica. |
| `GestionConsultorios` | Concreta | `consultorios` | Agregar, listar, buscar y eliminar consultorios | Administra los consultorios disponibles para las citas. |
| `GestionCitas` | Concreta | `citas`, `gestionMascotas`, `gestionVeterinarios`, `gestionConsultorios` | Agregar, listar y buscar citas; cancelar; registrar cita atendida con diagnóstico, observaciones y tratamiento | Coordina la administración de citas y consulta las gestoras necesarias. |
| `GestionCobros` | Concreta | `cobros` | Registrar, listar y buscar cobros; calcular ingresos totales y por veterinario; contar cobros | Centraliza el registro y las consultas de cobros e ingresos. |
| `Menu` | Concreta | `sc`, `mascotas`, `veterinarios`, `consultorios`, `gestionCitas`, `cobros`, `clinica` | `mostrarMenu()`, generar comprobante, registrar cobros y servicios adicionales, consultar historial, listar sonidos, consultar ingresos por veterinario, dar de baja mascotas | Gestiona la interacción por consola y conecta las opciones del usuario con las clases del sistema. |
| `Main` | Concreta | Sin atributos de instancia indicados | `main()` estático | Es el punto de entrada; inicializa los objetos necesarios e inicia el menú. |

## Consideraciones del diseño

- **Herencia:** `Dueno`, `Veterinario` y `Recepcionista` heredan de `Persona`; `Perro`, `Gato` y `Ave` heredan de `Mascota`; `ConsultaGeneral`, `Vacunacion` y `Cirugia` heredan de `Servicios`.
- **Abstracción:** `Persona`, `Mascota` y `Servicios` reúnen características comunes y definen comportamientos que sus subclases completan.
- **Polimorfismo:** las subclases de `Mascota` implementan `emitirSonido()` y los servicios concretos implementan `calcularCosto()`.
- **Interfaz:** `CalcularCosto` establece el método que implementan las clases que calculan un costo.
- **Enumeraciones:** `EstadoCita` y `MetodoPago` limitan los valores posibles de esos atributos.
- **Composición:** cada `Mascota` crea su propio `HistorialClinico`; el historial conserva consultas. `Comprobante` contiene detalles mediante una lista de `DetalleComprobante`.
- **Almacenamiento:** las clases gestoras mantienen colecciones en memoria; este documento no describe persistencia en una base de datos.

## Organización de paquetes

| Paquete | Clases |
|---|---|
| `PetCareEmpresa.modelo` | `Persona`, `Dueno`, `Veterinario`, `Recepcionista`, `Mascota`, `Perro`, `Gato`, `Ave`, `Clinica`, `Consultorio`, `EstadoCita`, `Cita`, `HistorialClinico`, `Consulta` |
| `PetCareEmpresa.servicio` | `CalcularCosto`, `Servicios`, `ConsultaGeneral`, `Vacunacion`, `Cirugia`, `Cobro`, `MetodoPago`, `Comprobante`, `DetalleComprobante`, `GestionMascotas`, `GestionVeterinarios`, `GestionConsultorios`, `GestionCitas`, `GestionCobros` |
| `PetCareEmpresa.app` | `Menu`, `Main` |

## Objetos de ejemplo

Los siguientes objetos son ejemplos ilustrativos para mostrar cómo podrían representarse instancias de las clases del sistema. ¡Los valores no corresponden a registros reales!

| Objeto | Clase | Valores de ejemplo |
| :--- | :--- | :--- |
| **dueno01** | Dueno | nombre = "Ana", apellido = "López", telefono = "5551234567", correo = "ana@example.com", direccion = "Av. Central 120" |
| **mascota01** | Perro | nombre = "Max", edad = 4, peso = 18.5, raza = "Labrador", nivelEnergia = "Alto", dueno = dueno01 |
| **cita01** | Cita | fecha = 2026-11-10, hora = 10:30, mascota = mascota01, veterinario = veterinario01, consultorio = consultorio01, estadoCita = PROGRAMADA |

En el tercer ejemplo, `veterinario01` y `consultorio01` representan referencias a objetos de las clases **Veterinario** y **Consultorio**, respectivamente. Se muestran como referencias para ilustrar las relaciones de la cita, no como objetos adicionales dentro de los tres ejemplos solicitados.

---

## Clases candidatas descartadas

* **Direccion:** no se modeló como clase independiente porque en el diseño actual solo se almacena como un dato de texto de `Dueno` y `Clinica`; no tiene identidad, comportamiento ni relaciones propias.
* **Turno:** no se modeló como clase independiente porque actualmente solo representa el dato descriptivo del turno de un `Recepcionista`, sin atributos o responsabilidades adicionales que justifiquen separarlo.

---

## Justificación de las relaciones

### Asociaciones

* **Dueno – Mascota:** se modeló como asociación porque el dueño está relacionado con sus mascotas, pero ambos objetos tienen identidad y pueden administrarse por separado. No es composición porque la mascota no forma parte del ciclo de vida del dueño.
* **Cita – Mascota, Veterinario y Consultorio:** son asociaciones porque la cita utiliza referencias a esos objetos para indicar quién recibe la atención, quién la brinda y dónde ocurre. No se eligió composición porque la cita no crea ni controla el ciclo de vida de la mascota, el veterinario o el consultorio.
* **Cita – Consulta:** se representa como asociación porque una cita puede tener una consulta registrada, pero la consulta es información médica que también se conserva en el historial clínico de la mascota. Por ello, no se considera que su existencia dependa exclusivamente de la cita.
* **Veterinario – Clinica:** se modeló como asociación porque el veterinario puede tener una clínica asignada, pero ambos se representan como objetos independientes.
* **Clinica – Consultorio:** en el diagrama actual se representa como asociación simple, aunque `Clinica` declara una lista de consultorios. No se marcó como agregación porque el código y el diagrama no establecen explícitamente una relación de pertenencia con ciclo de vida independiente bajo la semántica de agregación.
* **Cobro – Cita y Veterinario:** son asociaciones porque el cobro registra referencias a la cita atendida y al veterinario relacionado, sin ser propietario de esos objetos.
* **Cobro – CalcularCosto:** es una asociación porque `Cobro` recibe una referencia a una implementación de la interfaz para obtener el costo, sin crear ni controlar su ciclo de vida.
* **Comprobante – Cita:** se modeló como asociación porque el comprobante hace referencia a la cita a la que corresponde, pero no es dueño de la cita.
* **DetalleComprobante – Servicios:** es asociación porque cada detalle referencia el servicio cuyo costo se aplica; el servicio puede existir independientemente del detalle.

### Agregaciones

En el diagrama actual no se identifican relaciones marcadas explícitamente como agregación (rombo blanco). Aunque `Clinica` declara una colección de `Consultorio`, esa declaración por sí sola no demuestra que la relación deba representarse como agregación. Se conserva como asociación simple hasta que el diseño o la implementación establezcan claramente una relación todo-parte con objetos que mantengan su ciclo de vida independiente.

### Composiciones

* **Mascota – HistorialClinico:** se eligió composición porque el historial clínico se crea dentro del constructor de `Mascota` y forma parte de su estructura. No se modeló como asociación simple porque, según la implementación descrita, cada mascota mantiene su propio historial.
* **HistorialClinico – Consulta:** se eligió composición porque el historial contiene la colección de consultas que conserva para esa mascota. En el modelo, esas consultas forman parte del historial clínico y se gestionan desde él.
* **Comprobante – DetalleComprobante:** se modeló como composición porque el comprobante contiene una lista de sus detalles y estos representan las partidas que lo integran. Esta relación corresponde al diseño de las clases, aunque actualmente esas clases no se utilizan en el flujo de impresión del menú.

> **Criterio utilizado:** la asociación representa una relación entre objetos independientes; la agregación representa una relación todo-parte débil en la que las partes pueden existir por separado; y la composición representa una relación todo-parte fuerte en la que el ciclo de vida de las partes depende del objeto compuesto. La clasificación anterior sigue las relaciones que aparecen en los diagramas y la información de implementación disponible.