import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Ejercicio_5 {
     public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        Teatro teatro = new Teatro();
         System.out.println("Bienvenido al teatro EL DORADO");
         System.out.println("Que deseas hacer?");
         System.out.println("1) Vender entrada");
         System.out.println("2) Consultar Entrada");
         System.out.println("3) Salir");
        while (true) {
            int opcion = tc.nextInt();
            if (opcion == 1) {
                System.out.println("Ingrese la zona deseada:");
                String zona = tc.next();
                System.out.println("Ingrese el nombre del comprador:");
                String nombre = tc.next();
                System.out.println("Ingrese el tipo de entrada (normal, abonado, reducida):");
                String tipo = tc.next();
                teatro.venderEntrada(zona, nombre, tipo);
            } else if (opcion == 2) {
                System.out.println("Ingrese el identificador de la entrada:");
                int id = tc.nextInt();
                teatro.consultar(id);
            } else if (opcion == 3) {
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }
}
class Teatro{
    List<Zona> zonas;
    List<Entrada> entradas;
    public Teatro() {
        zonas = new ArrayList<>();
        entradas = new ArrayList<>();
        zonas();
    }
    public void zonas() {
        zonas.add(new Zona("Principal", 200, 25.0, 17.5));
        zonas.add(new Zona("PalcoB", 40, 70.0, 40.0));
        zonas.add(new Zona("Central", 400, 20.0, 14.0));
        zonas.add(new Zona("Lateral", 100, 15.5, 10.0));
    }
    public Entrada venderEntrada(String nombreZona, String nombreComprador, String tipoEntrada) {
        Zona zona = buscarZona(nombreZona);
        if (zona == null) {
            System.out.println("No existe ninguna zona con ese nombre.");
            return null;
        }
        if (!zona.zonasLibres()) {
            System.out.println("La zona elegida está completa.");
            return null;
        }
        double precio = calcularPrecio(zona, tipoEntrada);
        Entrada entrada = new Entrada(nombreZona, nombreComprador, precio);
        entradas.add(entrada);
        zona.ocuparLocalidad();
        System.out.println("Identificador de la entrada: " + entrada.getId());
        System.out.println("Precio de la entrada: " + precio);
        return entrada;
    }
    public Entrada consultar(int id) {
        for (Entrada entrada : entradas) {
            if (entrada.getId() == id) {
                System.out.println(entrada);
                return entrada;
            }
        }
        System.out.println("No existe ninguna entrada con ese identificador.");
        return null;
    }

    public Zona buscarZona(String nombre) {
        for (Zona zona : zonas) {
            if (zona.getNombre().equalsIgnoreCase(nombre)) {
                return zona;
            }
        }
        return null;
    }

    public double calcularPrecio(Zona zona, String tipoEntrada) {
        switch (tipoEntrada.toLowerCase()) {
            case "normal":
                return zona.getPrecioNormal();
            case "abonado":
                return zona.getPrecioAbonado();
            case "reducida":
                return zona.getPrecioNormal() * 0.85;
            default:
                return 0;
        }
    }
}
class Zona extends Teatro{
    String nombre;
    int numLocalidades;
    int ocupado;
    double precioNormal;
    double precioAbonado;

    public Zona(String nombre, int numLocalidades, double precioNormal, double precioAbonado) {
        this.nombre = nombre;
        this.numLocalidades = numLocalidades;
        this.precioNormal = precioNormal;
        this.precioAbonado = precioAbonado;
        this.ocupado = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumLocalidades() {
        return numLocalidades;
    }

    public double getPrecioNormal() {
        return precioNormal;
    }

    public double getPrecioAbonado() {
        return precioAbonado;
    }

    public boolean zonasLibres() {
        return ocupado < numLocalidades;
    }

    public void ocuparLocalidad() {
        if (zonasLibres()) {
            ocupado++;
        }
    }
}
class Entrada extends Teatro{
    int contador = 0;
    int id;
    String zona;
    String cliente;
    double precio;

    public Entrada(String zona, String nombreComprador, double precio) {
        this.id = contador++;
        this.zona = zona;
        this.cliente = nombreComprador;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getZona() {
        return zona;
    }

    public String getCliente() {
        return cliente;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Entrada [ID=" + id + ", Zona=" + zona + ", Comprador=" + cliente + ", Precio=" + precio + "]";
    }
}