package PetCareEmpresa.app;

import java.util.Scanner;

import PetCareEmpresa.modelo.*;
import PetCareEmpresa.servicio.*;

public class Main {
    public static void main(String[] args) {
        //inicializa todas las instancias de gestion que usará
        //el control de las acciones se administra en la otra clase
        Scanner sc = new Scanner(System.in);
        Clinica clinica = new Clinica("PetCare", "C. Galeana, Col. Agraria #107");
        GestionMascotas mascotas = new GestionMascotas();
        GestionVeterinarios veterinarios = new GestionVeterinarios(mascotas);
        GestionConsultorios consultorios = new GestionConsultorios();
        consultorios.agregarConsultorio(new Consultorio(1));
        consultorios.agregarConsultorio(new Consultorio(2));
        consultorios.agregarConsultorio(new Consultorio(3));
        GestionCitas gestionCitas = new GestionCitas(mascotas, veterinarios, consultorios);
        GestionCobros cobros = new GestionCobros();
        // Creamos e inicializamos menú para ser mostrado
        Menu menu = new Menu(mascotas, veterinarios, consultorios, gestionCitas, cobros, clinica);
        menu.mostrarMenu();
    }
}
