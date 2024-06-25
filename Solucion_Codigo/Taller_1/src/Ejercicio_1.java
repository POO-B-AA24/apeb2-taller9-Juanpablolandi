import java.util.ArrayList;
public class Ejercicio_1 {
    public static void main(String[] args) {
        
    }
}
class CapituloLibro{
    ArrayList<Seccion> secciones;

    public CapituloLibro(ArrayList<Seccion> secciones) {
        this.secciones = secciones;
    }
    
}
class Seccion{
    ArrayList<ComponenteSeccion> ComponentesSecciones;

    public Seccion(ArrayList<ComponenteSeccion> ComponentesSecciones) {
        this.ComponentesSecciones = ComponentesSecciones;
    }
    
}
class ComponenteSeccion{}
class Figura extends ComponenteSeccion{

    public Figura() {
    }
    
}
class Parrafo extends ComponenteSeccion{
    ArrayList<Sentencia> sentencias;
    
    public Parrafo(ArrayList<Sentencia> sentencias) {
        this.sentencias = sentencias;
    }
    
}
class Sentencia{
    ArrayList<Palabra> palabras;

    public Sentencia(ArrayList<Palabra> palabras) {
        this.palabras = palabras;
    }
    
}
class Palabra{}
