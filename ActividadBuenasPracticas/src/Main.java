import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numero = pedirNumero(scanner);
        int resultado = totalSuma(numero);

        System.out.println("La suma total es de: " + resultado);

    }

    public static int pedirNumero(Scanner scanner) {
        System.out.println("Ingresa un numero positivo hasta el que desees sumar: ");
        return scanner.nextInt();
    }

    public static int totalSuma(int numero) {
        int suma = 0;

        for (int i = 1; i <= numero; i++) {
            suma += i;
        }
        return suma;
    }
}