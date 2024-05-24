
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class  Problema_4_AppFiscalia{
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        int numeroCaso = 1;
        String opcion = "";
        do {
            System.out.println("=================================================================================");
            System.out.println("CASO : " + numeroCaso);
            System.out.println("Ingresa el nombre del caso:");
            String nombreCaso = tc.next();
            System.out.println("Ingresa la fecha de inicio (DD//MM//AAA):");
            String fechaCaso = tc.next();
            System.out.println("Ingresa los dias transcurridos:");
            int diasCaso = tc.nextInt();
            System.out.println("Ingresa cualquier detalle adicional del caso:");
            String detalleCaso = tc.next();
            Caso caso = new Caso(nombreCaso, fechaCaso,diasCaso, detalleCaso);
            System.out.println("QUIERES AGREGAR PERSONAS AL CASO? (1 -> SI | 2 -> NO)");
            int agregarPersonas = tc.nextInt();
            if(agregarPersonas == 1){
                ArrayList<Persona> persona = new ArrayList<>();
                System.out.println("CUANTAS PERSONAS DESEAS AGREGAR?");
                int nPersonas = tc.nextInt();
                for (int i = 0; i < nPersonas; i++) {
                    persona.add(new Persona(generarPersonas(), generarEdad(), generarSentencia(),generarOcupacion(),generarNivImplicacion()));
                    persona.get(i).verificarReduccionPena();
                    caso.agregarPersona(persona.get(i));
                }
            }
            caso.actualizarEstado();
            //MOSTRAR INFORMACION EN CONSOLA
            System.out.println(caso);
            System.out.println("\nPERSONAS IMPLICADAS:");
            for (Persona persona : caso.getPersonasImplicadas()) {
                System.out.println(persona);
            }
            System.out.println("=================================================================================");
            System.out.println("DESEAS REGISTRAR OTRO CASO? ( SI/NO)");
            opcion = tc.next();
            if (opcion.equalsIgnoreCase("SI") )
                numeroCaso++;
            else if (opcion.equalsIgnoreCase("NO"))
                System.out.println("GRACIAS POR VISITAR LA APP DE LA FISCALIA ECUATORIANA, QUE LA JUSTICIA PREVALEZCA");
            else
                System.out.println("OPCION INCORRECTA - PROGRAMA CULMINADO");
        }while(opcion.equalsIgnoreCase("SI"));
    }
    public static String generarPersonas(){
        Random aleatorio = new Random();
        String[] personas = {"Juan Eguiguren","Pedro Yepez","Jean Cuenca","Paula Zuniga","Carlos Alvarado","Emilio Pena"};
        int indiceAleatorio = aleatorio.nextInt(((personas.length-1) - 0) + 1) + 0;
        return personas[indiceAleatorio];
    }
    public static String generarOcupacion(){
        Random aleatorio = new Random();
        String[] ocupacion = {"Ingeniero","Arquitecto","Comerciante","Abogado","Doctor","Profesor"};
        int indiceAleatorio = aleatorio.nextInt(((ocupacion.length-1) - 0) + 1) + 0;
        return ocupacion[indiceAleatorio];
    }
    public static int generarEdad() {
        Random aleatorio = new Random();
        int numero = aleatorio.nextInt((90 - 18) + 1) + 18;
        return numero;
    }
    public static int generarSentencia() {
        Random aleatorio = new Random();
        int numero = aleatorio.nextInt((90 - 1) + 1) + 1;
        return numero;
    }
    
    public static String generarNivImplicacion(){
        Random aleatorio = new Random();
        String[] implicacion = {"Acusado", "Testigo", "Inocente", "Victima", "Implicado"};
        int indiceAleatorio = aleatorio.nextInt(((implicacion.length-1) - 0) + 1) + 0;
        return implicacion[indiceAleatorio];
    }
}

class Caso{
    private String nombreCaso;
    private String fechaInicio;
    private int diasTranscurridos;
    private String estado;
    private String detallesAdicionales;
    private ArrayList<Persona> personasImplicadas;
    
    public Caso(String nombreCaso, String fechaInicio, int diasTransurridos, String detallesAdicionales) {
        this.nombreCaso = nombreCaso;
        this.fechaInicio = fechaInicio;
        this.diasTranscurridos = diasTransurridos;
        this.estado = "Iniciado";
        this.detallesAdicionales = detallesAdicionales;
        this.personasImplicadas = new ArrayList<>();
    }
    
    
    
    public void actualizarEstado() { 
        if (this.diasTranscurridos > 14)
            this.estado = "Urgente";
        else if (diasTranscurridos > 7)
            this.estado = "Alerta";
    }
    public String getNombreCaso() {
        return nombreCaso;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }


    public String getEstado() {
        return estado;
    }


    public String getDetallesAdicionales() {
        return detallesAdicionales;
    }


    public ArrayList<Persona> getPersonasImplicadas() {
        return personasImplicadas;
    }

    public void agregarPersona(Persona persona) {
        personasImplicadas.add(persona);
    }
    @Override
    public String toString() {
        return "NOMBRE DEL CASO: " + nombreCaso + "\nFECHA DE INICIO: " + fechaInicio + "\nESTADO: " + estado + "\nDETALLES: " + detallesAdicionales;
    }
}

class Persona{
    private String nombre;
    private int edad;
    private String ocupacion;
    private String nivelImplicacion;
    private int sentencia; //Meses
    private String estadoPersona;
    
    public Persona(String nombre, int edad, int sentencia, String ocupacion, String nivelImplicacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.ocupacion = ocupacion;
        this.nivelImplicacion = nivelImplicacion;
        this.sentencia = sentencia;
        this.estadoPersona = "Persona con proceso en orden";
    }
    
    
    public void verificarReduccionPena(){ 
        if(this.nivelImplicacion.equalsIgnoreCase("acusado"))
            this.estadoPersona = "Esta persona puede acogerse a reduccion de pena si decide colaborar confesando la verdad"+verificarPagoFianza();
    }
    public String verificarPagoFianza(){
        if(this.sentencia > 12)
            return "\nEsta persona puede acogerse a pagar fianza si es que colabora con informacion util (Fianza no mayor al 50% del danio economico)";
        return "";
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public String getNivelImplicacion() {
        return nivelImplicacion;
    }

    
    @Override
    public String toString() {
        return "NOMBRE: " + nombre + ", EDAD: " + edad + ", OCUPACION: " + ocupacion + ", NIV DE IMPLICACION: " + nivelImplicacion + "\nESTADO: " + estadoPersona;
    }
}
