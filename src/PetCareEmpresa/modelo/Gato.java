package PetCareEmpresa.modelo;

public class Gato extends Mascota{
    private boolean esDomestico;

    public Gato(String nombre, int edad, double peso, boolean esDomestico){
        super(nombre, edad, peso);
        this.esDomestico = esDomestico;
    }

    public boolean getEsDomestico() {
        return esDomestico;
    }

    public void setEsDomestico(boolean esDomestico) {
        this.esDomestico = esDomestico;
    }

    @Override
    public void emitirSonido(){
        System.out.println("Miauuu");
    }
}
