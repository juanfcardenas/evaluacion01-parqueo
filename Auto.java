public class Auto extends Vehiculo {
    public Auto(String placa, int minutos) {
        super(placa, minutos);
    }

    @Override
    public double getTarifaPorHora() {
        return 20.0;
    }
}