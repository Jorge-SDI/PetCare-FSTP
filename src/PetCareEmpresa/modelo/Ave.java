package PetCareEmpresa.modelo;
//herencia de Animal
public class Ave extends Mascota {
    private double longitudAlas; //atributo propio de la clase

    //constructor con valores propios y heredados
    public Ave(String nombre, int edad, double peso, Dueno dueno, double longitudAlas) {
        super(nombre, edad, peso, dueno);
        this.longitudAlas = longitudAlas;
    }

    //implementa metodo heredado de Mascota
    @Override
    public void emitirSonido(){
        System.out.println("Cocoroch");
    }
}
