import java.util.Random;
import java.util.Scanner;
public class Ejercicio_2 {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        Random r = new Random();
        String peliculas[] = {"Intensamente", "Exorcismo", "Titanic","Coco","Cars"};
        String autores[] = {"Juan Pablo", "Diego Guerrero", "Ricardo Espinosa","Anthony Castillo","Pablo Juan"};
        String anios[] = {"2024", "2023", "2022","2020","2012"};
        String idiomas[] = {"Peruano", "Inglés", "Francés","Chino","Español"};
        System.out.println("BIENVENIDO");
        System.out.print("Ingrese el número de películas que desea adquirir: ");
        int numPelis = tc.nextInt();
        tc.nextLine();
        for (int i = 0; i < numPelis; i++) {
            System.out.println("Películas disponibles: ");
            for (int j = 0; j < peliculas.length; j++) {
                System.out.println((j + 1) + ") " + peliculas[j]);
            }
            System.out.print("Ingrese el título de la película que desea: ");
            String titulo = tc.nextLine();
            boolean peliculaEncontrada = false;
            for (int j = 0; j < peliculas.length; j++) {
                if (titulo.equalsIgnoreCase(peliculas[j])) {
                    Soporte soporteAleatorio;
                    if (r.nextBoolean()) {
                        soporteAleatorio = new Dvd(4.5);
                    } else {
                        soporteAleatorio = new Vhs("Estandar");
                    }

                    Pelicula pelicula = new Pelicula(peliculas[j], autores[j], anios[j], idiomas[j], soporteAleatorio);
                    System.out.println(pelicula);
                    peliculaEncontrada = true;
                    break;
                }
            }
            if (!peliculaEncontrada) {
                System.out.println("Película no disponible");
                i--;
            }
        }
        System.out.println("GRACIAS POR VISITARNOS");
    }
}
class Pelicula{
    String titulo;
    String autor;
    String anio;
    String idioma;
    double precio;
    public Soporte soporte;
    public Pelicula(String titulo, String autor, String anio, String idioma, Soporte soporte) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.idioma = idioma;
        this.soporte = soporte;
    }
    public double calcularPrecio(){
        if (this.anio.equalsIgnoreCase("2024"))
            this.precio = 30;
        else if (this.anio.equalsIgnoreCase("2023"))
            this.precio = 25;
        else if (this.anio.equalsIgnoreCase("2022"))
            this.precio = 20;
        else if (this.anio.equalsIgnoreCase("2020"))
            this.precio = 15;
        else
            this.precio = 10;
        if (soporte instanceof Dvd) {
            this.precio *= 1.1;
        }else
            this.precio = this.precio;
        return this.precio;
    }
    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", autor=" + autor + ", anio=" + anio + ", idioma=" + idioma + ", precio=" + calcularPrecio() + ", soporte=" + soporte + '}';
    }
}
class Soporte{}
class Dvd extends Soporte{
    double gb;
    public Dvd(double gb) {
        this.gb = gb;
    }
    @Override
    public String toString() {
        return "Dvd{" + "gb=" + gb + '}';
    }
    
}
class Vhs extends Soporte{
    String tipoCinta;       
    public Vhs(String tipoCinta) {
        this.tipoCinta = tipoCinta;
    }
    @Override
    public String toString() {
        return "Vhs{" + "tipoCinta=" + tipoCinta + '}';
    }  
}