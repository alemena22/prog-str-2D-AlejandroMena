import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa tu edad: ");
        int edad = scanner.nextInt();
        System.out.println("¿Eres estudiante? (true/false)");
        boolean esEstudiente = scanner.nextBoolean();
        int tarifa = 0;

        if (edad < 0 || edad > 120){
            System.out.println("Edad invalida!");
            return;

        }
        if (edad < 12){
            tarifa = 50;

        }else if(edad >= 12 && edad <= 17 && esEstudiente){
            tarifa = 60;

        }else if (edad >= 12 && edad <= 17 && !esEstudiente ){
            tarifa = 80;

        }else if(edad >= 18 && esEstudiente ){
            tarifa = 90;

        }else{
            tarifa = 120;
        }
        System.out.println("Tu edad es: " + edad);
        System.out.println("¿Eres estudiante?: " + esEstudiente);
        System.out.println("La tarifa que debes pagar es de: " + tarifa);

    }
}