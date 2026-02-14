import java.util.Scanner;

public class InputDataValidator {
    public int getIntNumber(Scanner sc, String msg){
        int id;
        while(true){
            System.out.println(msg);
            if(sc.hasNextInt()){
                id = sc.nextInt();
                sc.nextLine();
                if(id > 0){
                    return id;
                }
                System.out.println("El valor debe ser mayor que 0");
            }else{
                System.out.println("El valor debe ser un valor numerico");
                sc.next();
            }

        }

    }

    public double getDoubleNumber(Scanner sc, String msg){
        double promedio;
        while(true){
            System.out.println(msg);
            if(sc.hasNextDouble()){
                promedio = sc.nextDouble();
                sc.nextLine();
                if(promedio >= 0 && promedio <= 10){
                    return promedio;
                }

                System.out.println("El promedio debe estar entre 0 y 10");
            }else{
                System.out.println("El valor debe ser un valor numerico");
                sc.next();
            }

        }

    }

    public String getStringName(Scanner sc, String msg){
        String nombre;
        while (true){
            System.out.println(msg);
            nombre = sc.nextLine();
            if(nombre.trim().isEmpty()){
                System.out.println("No se acepta texto vacio");

            }else{
                return nombre;
            }

        }

    }
}