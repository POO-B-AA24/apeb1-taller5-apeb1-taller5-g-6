
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Problema_5_SistemaGestionConflicto {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        String opcion = "";
        do {
            System.out.println("==============================================================================================================");
            System.out.println("Desea ingresar un evento?(SI/NO)");
            opcion = tcl.next();
            System.out.println("==============================================================================================================");
            if (opcion.equalsIgnoreCase("SI")) {
                System.out.println("CUANTOS CONFLICTOS DESEA INGRESAR?");
                int nConflictos = tcl.nextInt();
                for (int i = 0; i < nConflictos; i++) {
                    ArrayList<String> paisesInvolucrados = new ArrayList<>();
                    paisesInvolucrados.add(generarPaises());//el numero de paises involucrados determina el tamanio del arreglo

                    System.out.println("INGRESE EL NOMBRE DEL CONFLICTO");
                    String nombreConflicto = "Conflicto " + (i + 1) + " " + tcl.next();
                    System.out.println(nombreConflicto);

                    Conflicto conflicto = new Conflicto(nombreConflicto, paisesInvolucrados, generarFechas());

                    System.out.println("==============================================================================================================");
                    System.out.println("CUANTOS EVENTOS DESEA INGRESAR?");
                    int nEventos = tcl.nextInt();
                    for (int j = 0; j < nEventos; j++) {
                        String nombreEvento = "Evento: " + (j + 1);
                        Evento evento1 = new Evento(nombreEvento, generarFechas(), generarPaises(), generarNombreEvento(), "Descripción de la batalla", generarTrueFalse(), 10);
                        conflicto.agregarEvento(evento1);
                        System.out.println("========================================================================================================");
                        System.out.println("Nombre del conflicto: " + conflicto.getNombre());
                        System.out.println("Estado actual del conflicto: " + conflicto.getEstadoActual());
                        for (Evento evento : conflicto.consultarEventos()) {
                            System.out.println("Evento: " + evento.getNombre() + ", Tipo: " + evento.getTipo() + ", Fecha: " + evento.getFecha());

                        }
                        System.out.println("***********************************TO STRING***********************************");

                        System.out.println(evento1);
                    }
                }

            }
        } while (opcion.equalsIgnoreCase("si"));
    }

    public static String generarPaises() {
        Random aleatorio = new Random();
        String[] paises = {"China", "Japon", "Rusia", "Ecuador", "Canada", "Argentina", "Alemania", "Espania", "EEUU", "Reino Unido", "Francia", "Peru"};
        int indiceAleatorio = aleatorio.nextInt(((paises.length - 1) - 0) + 1) + 0;
        return paises[indiceAleatorio];
    }

    public static String generarFechas() {
        Random aleatorio = new Random();
        String[] fechaOcurrio = {"20/5/2023", "12/12/2022", "4/7/2023", "9/3/2024", "01/9/2020"};
        int indiceAleatorio = aleatorio.nextInt(((fechaOcurrio.length - 1) - 0) + 1) + 0;
        return fechaOcurrio[indiceAleatorio];
    }

    public static String generarNombreEvento() {
        Random aleatorio = new Random();
        String[] nombreEvento = {"Batalla", "Tratado de paz", "Reunion Diplomatica"};
        int indiceAleatorio = aleatorio.nextInt(((nombreEvento.length - 1) - 0) + 1) + 0;
        return nombreEvento[indiceAleatorio];
    }

    public static boolean generarTrueFalse() {
        Random aleatorio = new Random();
        boolean[] bombas = {true, false};
        int indiceAleatorio = aleatorio.nextInt(((bombas.length - 1) - 0) + 1) + 0;
        return bombas[indiceAleatorio];
    }

    public static int generarBajasPorcentuales() {
        Random aleatorio = new Random();
        int[] bajas = {5, 10, 20, 30, 0, 15};
        int indiceAleatorio = aleatorio.nextInt(((bajas.length - 1) - 0) + 1) + 0;
        return bajas[indiceAleatorio];
    }
}

class Conflicto {

    private String nombre;
    private ArrayList<String> paisesInvolucrados;
    private String fechaInicio;
    private String estadoActual;
    private ArrayList<Evento> eventos;

    public Conflicto(String nombre, ArrayList<String> paisesInvolucrados, String fechaInicio) {
        this.nombre = nombre;
        this.paisesInvolucrados = paisesInvolucrados;
        this.fechaInicio = fechaInicio;
        this.estadoActual = "Activo";
        this.eventos = new ArrayList<>();
    }

    

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
        actualizarEstado();
    }

    private void actualizarEstado() {
        int totalPaises = paisesInvolucrados.size();
        ArrayList<String> paisesConBatallas = new ArrayList<>();//declaro el arreglo de los paises que estan en batalla
        for (Evento evento : eventos) {
            if (evento.getTipo().equals("Batalla") && !paisesConBatallas.contains(evento.getUbicacion())) {//verifico si los paises que se presentan estan en batalla
                paisesConBatallas.add(evento.getUbicacion());
            }
        }

        double porcentajePaisesConBatallas = (double) paisesConBatallas.size() / totalPaises;//hago que el valor que me envie pase de String a double

        if (porcentajePaisesConBatallas > 0.5) {
            estadoActual = "Guerra Mundial";
        } else if (porcentajePaisesConBatallas >= 0.3) {
            estadoActual = "Convocar a la ONU a reunión urgente";
        }

        // Lista de países de primer mundo 
        String[] paisesPrimerMundo = {"EEUU", "Rusia", "Reino Unido", "Francia"};

        boolean batallasNucleares = false;
        for (Evento evento : eventos) {
            for (String pais : paisesPrimerMundo) {
                if (evento.getUbicacion().equals(pais) && evento.siUsaArmasNucleares()) {//Si se usa armas nucleares variabble booleana
                    batallasNucleares = true;
                    break;
                }
            }
        }

        if (batallasNucleares) {
            estadoActual = "Guerra Mundial";
        }

        for (Evento evento : eventos) {
            if (evento.getBajasPorcentuales() >= 50) {
                estadoActual = "Convocar a la ONU a reunión urgente";
                break;
            }
        }
    }

    public ArrayList<Evento> consultarEventos() {
        return eventos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstadoActual() {
        return estadoActual;
    }
    public ArrayList<String> getPaisesInvolucrados() {
        return paisesInvolucrados;
    }

    @Override
    public String toString() {
        return "Conflicto{" + "nombre=" + nombre + ", paisesInvolucrados=" + paisesInvolucrados + ", fechaInicio=" + fechaInicio + ", estadoActual=" + estadoActual + ", eventos=" + eventos + '}';
    }

}

class Evento {

    private String nombre;
    private String fecha;
    private String ubicacion;
    private String tipo;
    private String descripcion;
    private boolean usaArmasNucleares;
    private int bajasPorcentuales;

    public Evento(String nombre, String fecha, String ubicacion, String tipo, String descripcion, boolean usaArmasNucleares, int bajasPorcentuales) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.usaArmasNucleares = usaArmasNucleares;
        this.bajasPorcentuales = bajasPorcentuales;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean siUsaArmasNucleares() {
        return usaArmasNucleares;
    }

    public int getBajasPorcentuales() {
        return bajasPorcentuales;
    }

    @Override
    public String toString() {
        return "Evento{" + "nombre=" + nombre + ", fecha=" + fecha + ", ubicacion=" + ubicacion + ", tipo=" + tipo + ", descripcion=" + descripcion + ", usaArmasNucleares=" + usaArmasNucleares + ", bajasPorcentuales=" + bajasPorcentuales + '}';
    }
}
