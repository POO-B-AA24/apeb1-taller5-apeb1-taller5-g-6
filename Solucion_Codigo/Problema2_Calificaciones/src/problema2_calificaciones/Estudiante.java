package problema2_calificaciones;
public class Estudiante {
    public String nombre;
    public int edad;
    public String nombreMateria;
    public double acd;
    public double ape;
    public double aa;
    public String estadoMaterias="";

    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public void setNotas(String nombreMateria, double acd, double ape, double aa){
        this.nombreMateria=nombreMateria;
        this.acd=acd;
        this.ape=ape;
        this.aa=aa;
    }
    public void estadoMateria(){
        Materia materia = new Materia(this.nombreMateria, this.acd, this.ape, this.aa);
        materia.calcularResultado();
        estadoMaterias+=materia.estadoMaterias();
    }
    

    @Override
    public String toString() {
        return "Nombre=" + nombre + "     -      Edad=" + edad + "\n" + this.estadoMaterias;
    }
    
}
