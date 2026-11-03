public class Moto extends Vehiculo {
    public Moto(String placa, int minutos) {
        super(placa, minutos);
    }

    @Override
    public double getTarifaPorHora() {
        return 10.0;
    }
}