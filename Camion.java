public class Camion extends Vehiculo {
    public Camion(String placa, int minutos) {
        super(placa, minutos);
    }

    @Override
    public double getTarifaPorHora() {
        return 35.0;
    }

    @Override
    public double calcularCobro() {
        int horas = calcularHoras();
        if (horas > 0) {
            return super.calcularCobro() + 50.0; // Recargo fijo de C$50 si cobra al menos 1 hora
        }
        return 0.0;
    }
}