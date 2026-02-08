import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        InputDataValidator input = new InputDataValidator();
        GradeService grade = new GradeService();

        String name = input.leerTextoNoVacio(sc, "Nombre del alumno: ");
        double p1 = input.leerDoubleEnRango(sc, "Ingresa la calificacion del parcial 1 (0-100): ", 0,100);
        double p2 = input.leerDoubleEnRango(sc, "Ingresa la calificacion del parcial 2 (0-100): ", 0,100);
        double p3 = input.leerDoubleEnRango(sc, "Ingresa la calificacion del parcial 3 (0-100): ", 0,100);
        int asistencia = input.leerIntEnRango(sc, "Ingresa la asistencia (0-100): ", 0, 100);
        boolean entregaProyecto = input.leerBoolean(sc, "Entrego proyecto?");

        double promedio = grade.calcularPromedio(p1,p2,p3);
        double promfinal = grade.calcularFinal(promedio,asistencia);
        String estado = grade.determinarEstado(promfinal, asistencia, entregaProyecto);

        reporte(name, p1, p2, p3, promedio, asistencia, entregaProyecto, promfinal, estado);

    }

    public static void reporte(String name, double p1, double p2, double p3, double promedio, int asistencia, boolean entregoProyecto, double promfinal, String estado){
        System.out.println("El nombre del alumno es: " + name);
        System.out.println("La calificacion del parcial 1 es: " + p1);
        System.out.println("La calificacion del parcial 2 es: " + p2);
        System.out.println("La calificacion del parcial 3 es: " + p3);
        System.out.println("El promedio de las 3 calificaciones es: " + promedio);
        System.out.println("La asistencia del alumno es: " + asistencia);
        System.out.println("Entrego proyecto: " + entregoProyecto);
        System.out.println("El promedio final es de: " + promfinal);
        System.out.println("El alumno esta: " + estado);

    }
}
