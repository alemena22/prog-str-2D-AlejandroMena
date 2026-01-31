import java.util.Scanner;

public class Conversiones {

    public static int contarCf = 0;
    public static int contarFc = 0;
    public static int contarKm = 0;
    public static int contarMkm = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opc = 0;

        do {
            System.out.println("--- MENU DE CONVERSIONES ---");
            System.out.println("1. °C a °F");
            System.out.println("2. °F a °C");
            System.out.println("3. Km a Millas");
            System.out.println("4. Millas a Km");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opcion: ");

            if (scanner.hasNextInt()) {
                opc = scanner.nextInt();
            } else {
                System.out.println("Opcion invalida! Solo se permiten numeros.");
                scanner.next();
                continue;
            }

            if (opc < 1 || opc > 5) {
                System.out.println("Esta opcion esta fuera de rango.");
                continue;
            }

            double valor;

            switch (opc) {
                case 1:
                    valor = pedirNumero(scanner, "Ingrese los grados °C: ");
                    System.out.println("El resultado es: " + celsiusAFahrenheit(valor));
                    contarCf++;
                    break;

                case 2:
                    valor = pedirNumero(scanner, "Ingrese los °F: ");
                    System.out.println("El resultado es: " + fahrenheitACelsius(valor));
                    contarFc++;
                    break;

                case 3:
                    valor = pedirNumero(scanner, "Ingrese los km: ");
                    System.out.println("El resultado: " + kmAMillas(valor));
                    contarKm++;
                    break;

                case 4:
                    valor = pedirNumero(scanner, "Ingrese las millas: ");
                    System.out.println("El resultado: " + millasAKm(valor));
                    contarMkm++;
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;
            }

        } while (opc != 5);

        int total = contarCf + contarFc + contarKm + contarMkm;
        System.out.println("Total de conversiones: " + total);
        System.out.println("Total de conversiones de celsius a fahrenheit: " + contarCf);
        System.out.println("Total de conversiones de fahrenheit a celsius: " + contarFc);
        System.out.println("Total de conversiones de km a millas: " + contarKm);
        System.out.println("Total de conversiones de millas a km: " + contarMkm);
    }

    public static double pedirNumero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextDouble()) {
                return sc.nextDouble();
            } else {
                System.out.println("Solo se permiten valores numericos");
                sc.next();
            }
        }
    }

    public static double celsiusAFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double fahrenheitACelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double kmAMillas(double km) {
        return km * 0.621;
    }

    public static double millasAKm(double mi) {
        return mi * 1.609;
    }
}
