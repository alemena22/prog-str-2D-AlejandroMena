import java.util.Scanner;
public class Persona {
    InputDataValidator input = new InputDataValidator();
    private int id;
    private String nombre;
    private boolean activa;

    public Persona() {
    }

    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.activa = true;

    }

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

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public void alta(Scanner sc, Persona[] personas) {

        int id = input.getIntNumber(sc, "Ingresa el id del nuevo usuario: ");

        if (existeId(personas, id)) {
            System.out.println("EL id ingresado ya existe");
            return;

        }
        String nombre = input.getStringName(sc, "Ingresa el nombre del usuario: ");
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                personas[i] = new Persona(id, nombre);
                System.out.println("Hay un nuevo usuario!");
                return;
            }
        }
        System.out.println("No hay mas espacios");


    }

    public void buscarId(Scanner sc, Persona[] personas){
        int id = input.getIntNumber(sc, "Ingresa el id que deseas buscar: ");
        for (Persona persona : personas) {
            if(persona != null && persona.getId() == id){
                if(persona.isActiva() == false){
                    System.out.println("El usuario se encuentra inactivo");
                    return;

                }
                System.out.println("EL ID ES: " + persona.getId());
                System.out.println("EL NOMBRE ES: " + persona.getNombre());
                System.out.println("Activo: " + persona.isActiva());
                return;

            }
        }
    }

    public void darDeBaja(Scanner sc, Persona[] personas){
        int id = input.getIntNumber(sc, "Ingresa el id que desees dar de baja: ");
        for (Persona persona : personas) {
            if(persona != null && persona.getId() == id){
                if(persona.isActiva() == false){
                    System.out.println("Usuario ya estaba inactivo");
                    return;

                }else{
                    persona.setActiva(false);
                    System.out.println("El usuario fue dado de baja exitosamente!");
                    return;

                }

            }

        }
        System.out.println("EL id no existe");


    }

    public void listarActivas(Persona[] personas){
        for (Persona persona : personas) {
            if(persona != null && persona.isActiva() == true){
                System.out.println(persona);
            }

        }

    }

    public void actualizarNombre(Scanner sc, Persona[] personas){
        int id = input.getIntNumber(sc, "Ingresa el id al que le desees actualizar el nombre:");
        for (Persona persona : personas) {
            if(persona != null && persona.getId() == id){
                if(persona.isActiva() == false){
                    System.out.println("Este usuario esta inactivo");
                    return;

                }
                String newNombre = input.getStringName(sc, "Ingresa el nuevo nombre para el usuario: ");
                persona.setNombre(newNombre);

                System.out.println("El nombre ha sido actualizado!");
                return;

            }


        }
        System.out.println("El id no existe");


    }

    private static boolean existeId(Persona[] personas, int id) {
        for (Persona persona : personas) {
            if (persona != null && persona.getId() == id) {
                return true;

            }


        }
        return false;

    }

    public String toString() {
        return "USUARIO [ID=" + id + ", NOMBRE=" + nombre + ", ESTA ACTIVO=" + activa + "]";
    }

}