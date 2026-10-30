package PetCareEmpresa.modelo;

public class Ave extends Mascota{
    private double longitudAlas;

    public Ave(String nombre, int edad, double peso, double longitudAlas) {
        super(nombre, edad, peso);
        this.longitudAlas = longitudAlas;
    }

    public double getLongitudAlas() {
        return longitudAlas;
    }

    public void setLongitudAlas(double longitudAlas) {
        this.longitudAlas = longitudAlas;
    }

    @Override
    public void emitirSonido(){
        System.out.println("Cocoroch");
    }
}
