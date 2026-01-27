import java.util.Scanner;
public class ActividadSwitchCalculadora{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----MENU-----");
        System.out.println("1. SUMA");
        System.out.println("2. RESTA");
        System.out.println("3. MULTIPLICAR");
        System.out.println("4. DIVIDIR");
        System.out.println("Selecciona una opcion: ");
        int opc = scanner.nextInt();
        double variable1, variable2;

        switch (opc){
            case 1:
                System.out.println("Ingresa el primer numero: ");
                variable1 = scanner.nextDouble();
                System.out.println("Ingresa el segundo numero: ");
                variable2 = scanner.nextDouble();
                System.out.println("La operacion seleccionada es: SUMA");
                System.out.println("El primer numero ingresado es: " + variable1 + " y el segundo numero ingresado es: " + variable2);
                System.out.println("EL resultado de la suma es: " + calcularSuma(variable1, variable2));
                break;
            case 2:
                System.out.println("Ingresa el primer numero: ");
                variable1 = scanner.nextDouble();
                System.out.println("Ingresa el segundo numero: ");
                variable2 = scanner.nextDouble();
                System.out.println("La operacion seleccionada es: RESTA");
                System.out.println("El primer numero ingresado es: " + variable1 + " y el segundo numero ingresado es: " + variable2);
                System.out.println("EL resultado de la resta es: " + calcularResta(variable1, variable2));
                break;
            case 3:
                System.out.println("Ingresa el primer numero: ");
                variable1 = scanner.nextDouble();
                System.out.println("Ingresa el segundo numero: ");
                variable2 = scanner.nextDouble();
                System.out.println("La operacion seleccionada es: MULTIPLICACION");
                System.out.println("El primer numero ingresado es: " + variable1 + " y el segundo numero ingresado es: " + variable2);
                System.out.println("EL resultado de la multiplicacion es: " + calcularMultiplicacion(variable1, variable2));
                break;
            case 4:
                System.out.println("Ingresa el primer numero: ");
                variable1 = scanner.nextDouble();
                System.out.println("Ingresa el segundo numero: ");
                variable2 = scanner.nextDouble();
                if(variable2 == 0){
                    System.out.println("No se puede dividir entre 0");

                }else {
                    System.out.println("La operacion seleccionada es: DIVISION");
                    System.out.println("El primer numero ingresado es: " + variable1 + " y el segundo numero ingresado es: " + variable2);
                    System.out.println("EL resultado de la division es: " + calcularDivision(variable1, variable2));
                }
                break;
            default:
                System.out.println("Opcion invalida!");
                return;

         }

     }
     public static double calcularSuma(double variable1, double variable2){
         return variable1 + variable2;

     }
     public static double calcularResta(double variable1, double variable2){
        return variable1 - variable2;

     }
     public static double calcularMultiplicacion(double variable1, double variable2){
        return variable1 * variable2;

     }
     public static double calcularDivision(double variable1, double variable2){
        return variable1/variable2;

     }


}