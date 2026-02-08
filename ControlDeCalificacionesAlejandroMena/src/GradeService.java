public class GradeService {
    public double calcularPromedio(double p1, double p2, double p3){
        return (p1 + p2 + p3)/3;

    }
    public double calcularFinal(double promedio, int asistencia){
        return  (promedio * 0.7) + (asistencia * 0.3);

    }
    public String determinarEstado(double promfinal, int asistencia, boolean entregoProyecto){
        if(asistencia < 80){
            return "REPROBADO POR ASISTENCIA";

        }
        if(entregoProyecto == false){
            return "REPROBADO POR FALTA DE PROYECTO";

        }

        if(promfinal >= 70){
            return "APROBADO";

        }else{
            return "REPROBADO";
        }

    }

}
