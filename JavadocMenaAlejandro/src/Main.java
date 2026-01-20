import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opc;
        do {
            System.out.println("-----Menu-----");
            System.out.println("1. CALCULAR IMC");
            System.out.println("2. CALCULAR AREA DE UN RECTANGULO");
            System.out.println("3. CONVERTIR °C A °F");
            System.out.println("4. CALCULAR AREA DE UN CIRCULO");
            System.out.println("5. SALIR ");
            System.out.print("SELECCIONA UNA OPCION: ");

            opc = scanner.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Dame el peso en KG: ");
                    double pesoKG = scanner.nextDouble();
                    System.out.println("Dame la altura en metros: ");
                    double alturaM = scanner.nextDouble();
                    double imc = calcularImc(pesoKG, alturaM);
                    System.out.println("Tu IMC es de: " + imc);
                    break;
                case 2:
                    System.out.println("Dame la base del rectangulo: ");
                    double baseR = scanner.nextDouble();
                    System.out.println("Dame la altura del rectangulo: ");
                    double alturaR = scanner.nextDouble();
                    double rectArea = calcularRectangulo(baseR, alturaR);
                    System.out.println("El area del rectangulo es de: " + rectArea);
                    break;
                case 3:
                    System.out.println("Dame los grados °C que desees convertir a °F: ");
                    double gradosCen = scanner.nextDouble();
                    double resultGrados = calcularGrados(gradosCen);
                    System.out.println("Los grados °C a °F son: " + resultGrados);
                    break;
                case 4:
                    System.out.println("Dame el radio del circulo: ");
                    double radioCirc = scanner.nextDouble();
                    double areaCirculo = calcularCirculo(radioCirc);
                    System.out.println("El area del circulo es igual a: " + areaCirculo);
                    break;
                default:
                    System.out.println("SALIENDO....");

            }

        }while(opc != 5);

    scanner.close();
    }

    /**
     * Metodo que calcula el IMC de una persona, con la formula peso/altura².
     * @param pesoKG -> peso expresado en kilogramos.
     * @param alturaM -> altura expresada en metros.
     * @return imc de la persona.
     */
    public static double calcularImc(double pesoKG, double alturaM){
        return pesoKG/(alturaM * alturaM);
    }

    /**
     * Metodo que calcula el area de un rectangulo con la formula base * altura.
     * @param baseR -> base del rectangulo.
     * @param alturaR -> altura del rectangulo.
     * @return area del rectangulo.
     */
    public static double calcularRectangulo(double baseR, double alturaR){
        return baseR * alturaR;
    }

    /**
     * Metodo que hace la conversion de grados centigrados a grados fahrenheit con la formula F=(C * 1.8)+32.
     * @param gradosCen -> grados centigrados.
     * @return convesion de grados centigrados a grados fahrenheit.
     */
    public static double calcularGrados(double gradosCen){
        return (gradosCen * 1.8) + 32;

    }

    /**
     * Metodo que calcula el area de un circulo con la formula "area = πr²"
     * @param radioCirc -> radio del circulo.
     * @return area del circulo.
     */
    public static double calcularCirculo(double radioCirc){
        return 3.1416 * (radioCirc * radioCirc);

    }

}
