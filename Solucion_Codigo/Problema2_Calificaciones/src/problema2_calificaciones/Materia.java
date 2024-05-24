package problema2_calificaciones;
public class Materia {
    public String nombreMateria;
    public double acd;
    public double ape;
    public double aa;
    public String estadoMateriasString="";
    public double promedio;
    public String resultado;

    public Materia(String nombreMateria, double acd, double ape, double aa) {
        this.nombreMateria = nombreMateria;
        this.acd = acd;
        this.ape = ape;
        this.aa = aa;
    }
    public void calcularResultado(){
        this.promedio= (this.acd*0.35)+(this.ape*0.35)+(this.aa*0.3);
        if(promedio>=7)
            this.resultado="APROBADO";
        else
            this.resultado="REPROBADO - TIENE LA POSIBILIDAD DE RENDIR EXAMEN DE RECUPERACION";
            
    }
    public String estadoMaterias(){
        this.estadoMateriasString+= "////"+this.nombreMateria+"////"+"\nACD: "+this.acd+"\nAPE: "+this.ape+"\nAA: "+this.aa+
                "\nPROMEDIO: "+this.promedio+"\nRESULTADO: "+this.resultado+"\n";
        
        return this.estadoMateriasString;
    }
    
    
}
