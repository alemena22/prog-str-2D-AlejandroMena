import java.util.Scanner;
import java.util.Random;


public class Adivinar {
    public static int rangoFuera = 0;
    public static int numerico = 0;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int max = 100;
        int min = 1;
        int secreto = random.nextInt(100) + 1;
        int intentos = 0;
        int limiteIntentos = 7;
        boolean gano = false;

        System.out.println("Adivina el numero que se encuentra entre 1 y 100: ");
        while(intentos < limiteIntentos){
            int numero = validarNumero(sc,"Intento " + (intentos + 1), min, max);
            intentos++;
            if(numero == secreto){
                System.out.println("Adivinaste el numero, has ganado!!");
                gano = true;
                break;
            }else if(numero > secreto){
                System.out.println("El numero que estas buscando es menor a: " + numero);

            }else{
                if(intentos < limiteIntentos){
                    System.out.println("El numero que estas buscando es mayor a: " + numero);
                }
            }

        }
        if(!gano){
            System.out.println("Has perdido, el numero secreto era: " + secreto);
        }
        System.out.println("Has ingresado numeros fuera del rango " + rangoFuera + " veces");
        System.out.println("Ingresaste un dato no numerico " + numerico + " veces");



    }
    public static int validarNumero(Scanner sc, String mensaje, int min, int max){
        int valor;
        while(true){
            System.out.println(mensaje);
            if(sc.hasNextInt()){
                valor = sc.nextInt();
                if(valor>=min && valor<=max ){
                    return valor;

                }
                System.out.println("El valor ingresado esta fuera de rango (1-100)");
                rangoFuera++;

            }else{
                System.out.println("El dato ingresado no es numerico");
                numerico++;
                sc.next();

            }

        }
    }
}
