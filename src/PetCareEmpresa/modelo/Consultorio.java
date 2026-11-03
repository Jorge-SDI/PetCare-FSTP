package PetCareEmpresa.modelo;

public class Consultorio {
    private int numeroConsultorio; //identificador para el consultorio

    //inicializamos su identificador
    public Consultorio(int numeroConsultorio) {
        this.numeroConsultorio = numeroConsultorio;
    }

    //obtenemos el numero del consultorio
    public int getNumeroConsultorio() {
        return numeroConsultorio;
    }

    //datos generales del consultorio
    @Override
    public String toString() {
        return "Consultorio:" +
                "Numero de consultorio: " + numeroConsultorio;
    }
}
