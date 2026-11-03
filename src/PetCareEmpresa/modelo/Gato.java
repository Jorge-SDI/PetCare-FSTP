package PetCareEmpresa.modelo;

//hereda atributos de Mascota
public class Gato extends Mascota {
    private boolean esDomestico; //atributo propio

    //inicializa sus atributos propios y heredados
    public Gato(String nombre, int edad, double peso, Dueno dueno, boolean esDomestico){
        super(nombre, edad, peso, dueno);
        this.esDomestico = esDomestico;
    }

    //metodo abstracto heredado de Mascota
    @Override
    public void emitirSonido(){
        System.out.println("Miauuu");
    }
}
