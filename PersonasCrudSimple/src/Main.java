import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Persona[] personas = new Persona[20];
        Persona obtener = new Persona();
        int opc;
        do{
            System.out.println("-----MENU DE OPCIONES-----");
            System.out.println("1) ALTA");
            System.out.println("2) BUSCAR POR ID");
            System.out.println("3) BAJA LOGICA POR ID");
            System.out.println("4) LISTAR ACTIVOS");
            System.out.println("5) ACTUALIZAR NOMBRE POR ID (SOLO ACTIVOS)");
            System.out.println("0) SALIR");
            System.out.println("SELECCIONA UNA OPCION: ");
            opc = sc.nextInt();
            switch (opc){
                case 1:
                    obtener.alta(sc, personas);
                    break;
                case 2:
                    obtener.buscarId(sc, personas);
                    break;
                case 3:
                    obtener.darDeBaja(sc, personas);
                    break;
                case 4:
                    obtener.listarActivas(personas);
                    break;
                case 5:
                    obtener.actualizarNombre(sc, personas);
                    break;
                default:
                    System.out.println("OPCION INVALIDA!");
            }


        }while(opc != 0);

    }
}