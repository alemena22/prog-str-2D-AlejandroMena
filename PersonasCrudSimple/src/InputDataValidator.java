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
                System.out.println("El id debe ser mayor que 0");
            }else{
                System.out.println("El id debe se un valor numerico");
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