package PetCareEmpresa.servicio;

//hereda atributos de Servicios
public class Cirugia extends Servicios{
    private int horasQuirofano; //atributos propios
    private int complejidadCirugia; // el costo se calcula en base a ellos

    //inicializa atributos propios y heredados
    public Cirugia(int horasQuirofano, int complejidadCirugia, String nombre, String descripcion){
        super(nombre,descripcion);
        setHorasQuirofano(horasQuirofano);
        setComplejidadCirugia(complejidadCirugia);
    }

    public int getHorasQuirofano() {
        return horasQuirofano;
    }

    //asignar horas de duracion de la cirugia
    public void setHorasQuirofano(int horasQuirofano) {
        if(horasQuirofano < 0){
            throw new IllegalArgumentException("La hora de duracion no puede ser menor a 0");
        }
        this.horasQuirofano = horasQuirofano;
    }

    //asigna una complejidad entre el 1 al 5 a la cirugia
    public void setComplejidadCirugia(int complejidadCirugia) {
        if(complejidadCirugia < 1 || complejidadCirugia > 5){
            throw new IllegalArgumentException("La complejidad debe estar entre 1 y 5");
        }
        this.complejidadCirugia = complejidadCirugia;
    }

    //metodo implementado de la interfaz para calcular el costo del sevicio (cirugia)
    @Override
    public double calcularCosto() {
        if (complejidadCirugia == 1) {
            if (horasQuirofano <= 2) {
                return 2300.00;
            } else if (horasQuirofano <= 4) {
                return 2800.00;
            } else {
                return 3500.00;
            }
        } else if (complejidadCirugia == 2) {
            if (horasQuirofano <= 3) {
                return 3700.00;
            } else if (horasQuirofano <= 5) {
                return 4300.00;
            } else {
                return 5000.00;
            }
        } else if (complejidadCirugia == 3) {
            if (horasQuirofano <= 6) {
                return 5500.00;
            } else {
                return 6500.00;
            }
        } else if (complejidadCirugia > 3 && complejidadCirugia <= 5) {
            if (horasQuirofano <= 3) {
                return 7500.00;
            } else if (horasQuirofano <= 7) {
                return 8500.00;
            } else {
                return 9500.00;
            }
        }
        return 0;
    }

    //datos generales de la cirugia
    @Override
    public String toString() {
        return super.toString() + "horas de cirugia: " + horasQuirofano +
                ", complejidad de la cirugia: " + complejidadCirugia;
    }
}
