package problema3_departamentos;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejecutor {

    public static void main(String[] args) {
        Scanner put = new Scanner(System.in);
        boolean seguir = true;

        ArrayList<Empresa> listaEmpresas = new ArrayList<>();
        while (seguir) {
            System.out.println("Desea Ingresar otra Empresa?");
            String resp1 = put.next();
            if (resp1.equalsIgnoreCase("NO")) {
                break;
            }
            put.nextLine();
            System.out.println("Ingrese el nombre de la empresa");
            String nombreEmpresa = put.nextLine();
            System.out.println("Ingrese el RUC");
            String ruc = put.nextLine();
            System.out.println("Ingrese la direccion");
            String direccion = put.nextLine();
            Empresa empresa = new Empresa(nombreEmpresa, ruc, direccion);
            boolean otroDepar = true;
            while (otroDepar) {
                System.out.println("Ingrese el nombre, numero de empleados y produccion anual del departamento ");
                String nombreDep = put.next();
                int numEmpleados = put.nextInt();
                double produccionAnual = put.nextDouble();
                empresa.setDatosDepar(nombreDep, numEmpleados, produccionAnual);
                empresa.categoriaDepar();
                System.out.println("Desea agregar otro departamento? SI/NO");
                String resp = put.next();

                if (resp.equalsIgnoreCase("NO")) {
                    otroDepar = false;
                }

            }
            listaEmpresas.add(empresa);
        }
        System.out.println(listaEmpresas);
    }
}
