public abstract class Vehiculo {
    private String placa;
    private int minutos;

    public Vehiculo(String placa, int minutos) {
        this.placa = placa;
        this.minutos = minutos;
    }

    public String getPlaca() {
        return placa;
    }

    public int getMinutos() {
        return minutos;
    }

    public int calcularHoras() {
        if (minutos <= 15) {
            return 0; // Primeros 15 minutos gratis
        }
        return (int) Math.ceil(minutos / 60.0); // Hora o fracción
    }

    public abstract double getTarifaPorHora();

    public double calcularCobro() {
        return calcularHoras() * getTarifaPorHora();
    }

    public void imprimirTicket() {
        System.out.println("\n========== TICKET DE PARQUEO ==========");
        System.out.println("Tipo: " + getClass().getSimpleName());
        System.out.println("Placa: " + placa);
        System.out.println("Minutos estacionado: " + minutos);
        System.out.println("Horas cobradas: " + calcularHoras());
        System.out.println("Total a pagar: C$" + calcularCobro());
        System.out.println("=======================================\n");
    }
}