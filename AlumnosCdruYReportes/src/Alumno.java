import java.util.Scanner;
public class Alumno {
    InputDataValidator input = new InputDataValidator();
    private int id;
    private String nombre;
    private double promedio;
    private boolean activo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {

        this.activo = activo;
    }

    public Alumno(){}
    public Alumno(int id, String nombre, double promedio){
        this.id = id;
        this.nombre = nombre;
        this.promedio = promedio;
        this.activo = true;

    }
    public void alta(Scanner sc, Alumno[] alumnos){
        int id = input.getIntNumber(sc, "Ingresa el ID del alumnos: ");
        if(existeId(alumnos, id)){
            System.out.println("El ID ya esta ocupado!.");
            return;

        }
        String nombre = input.getStringName(sc, "Ingresa el nombre del alumno: ");
        double promedio = input.getDoubleNumber(sc, "Ingresa el promedio del alumno: ");

        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = new Alumno(id, nombre, promedio);
                System.out.println("Hay un nuevo alumno!");
                return;
            }
        }
        System.out.println("No hay mas espacios");

    }

    public void buscarId(Scanner sc, Alumno[] alumnos){
        int id = input.getIntNumber(sc, "Ingresa el ID del alumno que deseas buscar: ");
        for (Alumno alumno : alumnos) {
            if(alumno != null && alumno.getId() == id){
                if(alumno.isActivo() == false) {
                    System.out.println("El alumno esta inactivo!.");
                    return;
                }
                System.out.println("El ID del alumno es: " + alumno.getId());
                System.out.println("El nombre del alumno es: " + alumno.getNombre());
                System.out.println("El promedio del alumno es: " + alumno.getPromedio());
                return;
            }

        }
        System.out.println("El ID no existe.");
    }

    public void actualizarProm(Scanner sc, Alumno[] alumnos){
        int id = input.getIntNumber(sc, "Ingresa el ID del alumno al que se le actualizara el promedio: ");
        for (Alumno alumno : alumnos) {
            if(alumno != null && alumno.getId() == id){
                if(alumno.isActivo() == false){
                    System.out.println("Este alumno esta dado de baja (inactivo).");
                    return;
                }
                double newPromedio = input.getDoubleNumber(sc, "Ingresa el nuevo promedio del alumno: ");
                alumno.setPromedio(newPromedio);
                System.out.println("El promedio ha sido actualizado!");
                return;
            }

        }
        System.out.println("El ID no existe.");
    }

    public void bajaLogica(Scanner sc, Alumno[] alumnos){
        int id = input.getIntNumber(sc, "Ingresa el ID del alumno que deseas dar de baja: ");
        for (Alumno alumno : alumnos) {
            if(alumno != null && alumno.getId() == id){
                if(alumno.isActivo() == false){
                    System.out.println("Este alumno ya estaba dado de baja.");
                    return;

                }else{
                    alumno.setActivo(false);
                    System.out.println("El alumno fue dado de baja.");
                    return;

                }

            }

        }
        System.out.println("El ID no existe.");

    }

    public void listarActivos(Alumno [] alumnos){
        boolean estadoActivo = false;
        for (Alumno alumno : alumnos) {
            if(alumno != null && alumno.isActivo() == true){
                System.out.println(alumno);
                estadoActivo = true;
            }
        }
        if(estadoActivo == false){
            System.out.println("No hay alumnos activos que mostrar");

        }

    }

    public void reporteAlumnos(Scanner sc, Alumno[] alumnos){
        int contarAlumnos = 0;
        double sumaPromedios = 0;
        int contMayoresOcho = 0;
        Alumno mayor = null;
        Alumno menor = null;

        for (Alumno alumno : alumnos) {
            if(alumno != null && alumno.isActivo() == true){
                contarAlumnos++;
                sumaPromedios += alumno.getPromedio();

                if(mayor == null || alumno.getPromedio() > mayor.getPromedio() ){
                    mayor = alumno;

                }
                if(menor == null || alumno.getPromedio() < menor.getPromedio()){
                    menor = alumno;

                }
                if(alumno.getPromedio() >= 8){
                    contMayoresOcho++;
                }
            }

        }

        if(contarAlumnos == 0){
            System.out.println("No se encuentran alumnos activos para generar el reporte.");
            return;

        }
        double promedioGen = sumaPromedios/contarAlumnos;
        System.out.println("--------REPORTE DE ALUMNOS--------");
        System.out.println("Promedio general de alumnos activos: " + promedioGen);
        System.out.println("___________________________________");
        System.out.println("Alumno con el mayor promedio: ");
        System.out.println("ID: " + mayor.getId());
        System.out.println("NOMBRE: " + mayor.getNombre());
        System.out.println("PROMEDIO: " + mayor.getPromedio());
        System.out.println("___________________________________");
        System.out.println("Alumno con el menor promedio: ");
        System.out.println("ID: " + menor.getId());
        System.out.println("NOMBRE: " + menor.getNombre());
        System.out.println("PROMEDIO: " + menor.getPromedio());
        System.out.println("___________________________________");
        System.out.println("Cantidad de alumnos con promedio mayor a 8: " + contMayoresOcho);

    }

    private static boolean existeId(Alumno[] alumnos, int id) {
        for (Alumno alumno : alumnos) {
            if (alumno != null && alumno.getId() == id) {
                return true;

            }
        }
        return false;
    }

    public String toString() {
        return "Alumno [ID: " + id + "; NOMBRE: " + nombre + "; PROMEDIO: " + promedio + "; ESTA ACTIVO: " + activo +"]";
    }

}