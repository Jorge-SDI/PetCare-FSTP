package PetCareEmpresa.modelo;

public class Perro extends Mascota {
    private String raza;
    private String nivelEnergia;

    public Perro(String nombre, int edad, double peso, String raza, String nivelEnergia){
        super(nombre, edad, peso);
        this.raza = raza;
        this.nivelEnergia = nivelEnergia;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNivelEnergia() {
        return nivelEnergia;
    }

    public void setNivelEnergia(String nivelEnergia) {
        this.nivelEnergia = nivelEnergia;
    }

    @Override
    public void emitirSonido(){
        System.out.println("Woof woof");
    }
}
