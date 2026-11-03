import java.util.Scanner;

public class Parqueo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalMotos = 0;
        int totalAutos = 0;
        int totalCamiones = 0;
        double totalRecaudado = 0.0;

        String placaMayorPago = "N/A";
        double mayorCobro = -1.0;

        String continuar;
        do {
            int tipo = 0;
            while (tipo < 1 || tipo > 3) {
                System.out.print("Seleccione tipo de vehículo (1: Moto, 2: Auto, 3: Camión): ");
                if (scanner.hasNextInt()) {
                    tipo = scanner.nextInt();
                } else {
                    scanner.next();
                }
            }

            scanner.nextLine(); // Limpiar buffer
            System.out.print("Ingrese la placa: ");
            String placa = scanner.nextLine();

            int minutos = 0;
            while (minutos <= 0) {
                System.out.print("Ingrese los minutos estacionado (debe ser > 0): ");
                if (scanner.hasNextInt()) {
                    minutos = scanner.nextInt();
                } else {
                    scanner.next();
                }
            }

            Vehiculo v = switch (tipo) {
                case 1 -> {
                    totalMotos++;
                    yield new Moto(placa, minutos);
                }
                case 2 -> {
                    totalAutos++;
                    yield new Auto(placa, minutos);
                }
                case 3 -> {
                    totalCamiones++;
                    yield new Camion(placa, minutos);
                }
                default -> null;
            };

            if (v != null) {
                v.imprimirTicket();
                double cobro = v.calcularCobro();
                totalRecaudado += cobro;

                if (cobro > mayorCobro) {
                    mayorCobro = cobro;
                    placaMayorPago = v.getPlaca();
                }
            }

            System.out.print("¿Desea registrar otro vehículo? (s/n): ");
            continuar = scanner.next().toLowerCase();

        } while (continuar.equals("s"));

        System.out.println("\n================ REPORTE DEL DÍA ================");
        System.out.println("Motos que salieron:    " + totalMotos);
        System.out.println("Autos que salieron:    " + totalAutos);
        System.out.println("Camiones que salieron: " + totalCamiones);
        System.out.println("Total recaudado:       C$" + totalRecaudado);
        System.out.println("Vehículo que pagó más: " + placaMayorPago + " (C$" + (mayorCobro > 0 ? mayorCobro : 0.0) + ")");
        System.out.println("=================================================");

        scanner.close();
    }
}