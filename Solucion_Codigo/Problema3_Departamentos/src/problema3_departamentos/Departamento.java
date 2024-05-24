package problema3_departamentos;
public class Departamento {
    public String nombre;
    public int numEmpl;
    public double proAnu;
    public String cat;
    public String infoDeparString;
    public Departamento(String nombre, int numEmpl, double proAnu) {
        this.nombre = nombre;
        this.numEmpl = numEmpl;
        this.proAnu = proAnu;
    }
    
    public void definirCat() {
        if (numEmpl <= 10 && proAnu == 500000) {
            this.cat = "C";
        } else {
            if (numEmpl <= 20 && proAnu == 1000000) {
                this.cat = "B";
            } else {
                if (numEmpl > 20 && proAnu >     1000000) {
                    this.cat = "A";
                }
                else{
                    this.cat = "NO ENTRA EN NINGUNA CATEGORIA";
                }
            }
        }

    }

    
    public String infoDeparString(){
        this.infoDeparString += "\nNombre del Departamento: " + nombre + "   -    Numero Empleados: " + numEmpl + "   -    Produccion Anual: "
                + proAnu + "   -   Categoria: " + cat+"\n";
        return this.infoDeparString;
    }
}