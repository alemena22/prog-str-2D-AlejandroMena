import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Alumno[] alumnos = new Alumno[25];
        Alumno obtener = new Alumno();
        int opc;
        do{
            System.out.println("-----MENU-----");
            System.out.println("1) ALTA ALUMNO");
            System.out.println("2) BUSCAR POR ID");
            System.out.println("3) ACTUALIZAR PROMEDIO POR ID");
            System.out.println("4) BAJA LOGICA POR ID");
            System.out.println("5) LISTAR ACTIVOS");
            System.out.println("6) REPORTES");
            System.out.println("0) SALIR");
            System.out.println("SELECCIONA UNA OPCION: ");
            opc = sc.nextInt();

            switch(opc){
                case 1:
                    obtener.alta(sc, alumnos);
                    break;
                case 2:
                    obtener.buscarId(sc, alumnos);
                    break;
                case 3:
                    obtener.actualizarProm(sc, alumnos);
                    break;
                case 4:
                    obtener.bajaLogica(sc, alumnos);
                    break;
                case 5:
                    obtener.listarActivos(alumnos);
                    break;
                case 6:
                    obtener.reporteAlumnos(sc, alumnos);
                    break;
                case 0:
                    System.out.println("Saliendo....");
                    break;
                default:
                    System.out.println("OPCION INVALIDA");

            }

        }while(opc != 0);
    }
}