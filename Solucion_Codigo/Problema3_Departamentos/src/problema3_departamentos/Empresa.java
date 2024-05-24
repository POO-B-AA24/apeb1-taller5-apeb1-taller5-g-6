package problema3_departamentos;


public class Empresa {
    public String nombre;
    public String ruc;
    public String direccion;
    public String nombreDep ;
    public int numEmpleados ;
    public double produccionAnual;
    public String infoDepar="";

    
    public Empresa(String nombre, String ruc, String direccion) {
        this.nombre = nombre;
        this.ruc = ruc;
        this.direccion = direccion;
    }
    public void setDatosDepar(String nombreDep ,int numEmpleados ,double produccionAnual){
        this.nombreDep = nombreDep ;
        this.numEmpleados = numEmpleados;
        this.produccionAnual = produccionAnual;
    }
    public void categoriaDepar() {
        Departamento departamento = new Departamento(this.nombreDep, this.numEmpleados, this.produccionAnual);
        departamento.definirCat();
        this.infoDepar+= departamento.infoDeparString();
    }

    @Override
    public String toString() {
        return "Nombre Empresa=" + nombre + "  -   RUC=" + ruc + "  -  Direccion=" + direccion + "\n" + this.infoDepar;
    }

}