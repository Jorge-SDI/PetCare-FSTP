package PetCareEmpresa.modelo;

//hereda atributos de mascota
public class Perro extends Mascota {
    private String raza; //atributos propios
    private String nivelEnergia; //atributos propios

    //inicializa atributos propios y heredados
    public Perro(String nombre, int edad, double peso, Dueno dueno, String raza, String nivelEnergia){
        super(nombre, edad, peso, dueno);
        this.raza = raza;
        this.nivelEnergia = nivelEnergia;
    }

    //implementa metodo de sonido de Mascota
    @Override
    public void emitirSonido(){
        System.out.println("Woof woof");
    }
}
