import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShippingCalculator ship = new ShippingCalculator();

        double pesoKg = leerDoubleEnRango(sc, "Ingrese el peso en KG: ", 0.1, 50.0);
        int distanciaKm = leerIntEnRango(sc, "Ingresa la distancia en KM: ", 1, 2000);
        int tipoServicio = leerIntEnRango(sc, "Ingresa el tipo de servicio 1) estandar y 2) express: ", 1, 2);
        boolean esZonaRemota = leerBoolean(sc, "Es zona remota?");

        double subtotal = ship.calcularSubtotal(pesoKg, distanciaKm, tipoServicio, esZonaRemota);
        double iva = ship.calcularIVA(subtotal);
        double total = ship.calcularTotal(subtotal, iva);


        ticket(tipoServicio, pesoKg, distanciaKm, esZonaRemota, subtotal, iva, total);

    }



    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max){
        double value;
        while(true){
            System.out.println(msg);
            if(sc.hasNextDouble()){
                value = sc.nextDouble();
                if(value >= min && value <= max){
                    return value;

                }
                System.out.println("El valor esta fuera del rango de " + min + " a "+ max);
            }else{
                System.out.println("No es un dato numerico");
                sc.next();
            }

        }

    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max){
        int value;
        while(true){
            System.out.println(msg);
            if(sc.hasNextInt()){
                value = sc.nextInt();
                if(value >= min && value <= max){
                    return value;

                }
                System.out.println("El valor esta fuera del rango de " + min + " a "+ max);
            }else{
                System.out.println("No es un dato numerico");
                sc.next();
            }

        }

    }

    public static boolean leerBoolean(Scanner sc, String msg){
        while (true){
            System.out.println(msg);
            if(sc.hasNextBoolean()){
                return sc.nextBoolean();

            }else{
                System.out.println("EL valor ingresado no es booleano (true/false)");
                sc.next();
            }
        }
    }

    public static void ticket(int tipoServicio, double pesoKg, int distanciaKm, boolean esZonaRemota, double subtotal, double iva, double total){
        System.out.println("-------TICKET-------");
        System.out.println("1) ESTANDAR y 2) EXPRESS");
        System.out.println("El tipo de servicio es: " + tipoServicio);
        System.out.println("El peso en KG es de: " + pesoKg);
        System.out.println("Los kilometros son: " + distanciaKm);
        System.out.println("Zona remota: " + esZonaRemota);
        System.out.println("EL total sin IVA es de: " + subtotal);
        System.out.println("El total del IVA es de: " + iva);
        System.out.println("El total final es de: " + total);

    }


}
