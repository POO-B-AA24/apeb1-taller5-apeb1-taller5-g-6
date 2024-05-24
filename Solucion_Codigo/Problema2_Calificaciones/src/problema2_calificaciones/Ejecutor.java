package problema2_calificaciones;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejecutor {

    public static void main(String[] args) {
        Scanner put = new Scanner(System.in);
        boolean seguir = true;
        boolean otraMateria = true;
        ArrayList<Estudiante> listaEstudiante = new ArrayList<>();

        while (seguir) {
            System.out.println("Desea agregar un alumno? SI/NO");
            String resp1 = put.next();
            if (resp1.equalsIgnoreCase("NO")) {
                break;
            }
            System.out.println("Ingrese el nombre del alumno");
            String nombreAl = put.next();
            System.out.println("Ingrese la edad del alumno");
            int edad = put.nextInt();

            Estudiante estudiante = new Estudiante(nombreAl, edad);
            otraMateria=true;
            while (otraMateria) {
                put.nextLine();
                System.out.println("Ingrese la materia a vincular");
                String nombreMateria = put.nextLine();
                System.out.println("Ingrese las notas de ACD(35%)  -  APE(35%)  -  AA(30%)");
                double acd = put.nextDouble(), ape = put.nextDouble(), aa = put.nextDouble();
                estudiante.setNotas(nombreMateria, acd, ape, aa);
                estudiante.estadoMateria();
                System.out.println("Desea agregar otra materia? SI/NO");
                String resp2 = put.next();
                if (resp2.equalsIgnoreCase("NO")) {
                    otraMateria = false;
                }

            }
            listaEstudiante.add(estudiante);
        }
        System.out.println(listaEstudiante);

    }

}
