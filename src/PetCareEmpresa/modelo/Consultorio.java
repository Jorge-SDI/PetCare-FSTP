package PetCareEmpresa.modelo;

public class Consultorio {
    private int numeroConsultorio;

    public Consultorio(int numeroConsultorio) {
        this.numeroConsultorio = numeroConsultorio;
    }

    public int getNumeroConsultorio() {
        return numeroConsultorio;
    }

    @Override
    public String toString() {
        return "Consultorio:" +
                "Numero de consultorio: " + numeroConsultorio;
    }
}
