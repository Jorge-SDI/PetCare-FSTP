package PetCareEmpresa.servicio;

public class Cirugia extends Servicios{
    private int horasQuirofano;
    private int complejidadCirugia;

    public  Cirugia(int horasQuirofano, int complejidadCirugia, String nombre, String descripcion){
        super(nombre,descripcion);
        setHorasQuirofano(horasQuirofano);
        setComplejidadCirugia(complejidadCirugia);
    }

    public int getHorasQuirofano() {
        return horasQuirofano;
    }

    public void setHorasQuirofano(int horasQuirofano) {
        if(horasQuirofano < 0){
            throw new IllegalArgumentException("La hora de duracion no puede ser menor a 0");
        }
        this.horasQuirofano = horasQuirofano;
    }

    public int getComplejidadCirugia() {
        return complejidadCirugia;
    }

    public void setComplejidadCirugia(int complejidadCirugia) {
        if(complejidadCirugia < 1 || complejidadCirugia > 5){
            throw new IllegalArgumentException("La complejidad debe estar entre 1 y 5");
        }
        this.complejidadCirugia = complejidadCirugia;
    }

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

    @Override
    public String toString() {
        return super.toString() + "horas de cirugia: " + horasQuirofano +
                ", complejidad de la cirugia: " + complejidadCirugia ;
    }
}
