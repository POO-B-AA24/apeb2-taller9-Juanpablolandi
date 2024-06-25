import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Ejercicio_4 {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        List<Trabajador> empleados = new ArrayList<>();
        FijoMensual fijo = new FijoMensual("Juan", "Largo", "ZH", "1111", 2500.0);
        Comisionista comisionista = new Comisionista("Pablo", "Largo", "LA SALLE", "2222", 5.0);
        PorHoras porHoras = new PorHoras("Ricardo", "Landi", "Amable Maria", "3333", 10.0, 15.0);
        Jefe jefe = new Jefe("Hola", "Landi", "UTPL", "4444", 5000.0);

        empleados.add(fijo);
        empleados.add(comisionista);
        empleados.add(porHoras);
        empleados.add(jefe);

        comisionista.registrarVenta(1000.0);
        comisionista.registrarVenta(1500.0);
        porHoras.registrarHorasTrabajadas(45);
        for (Trabajador empleado : empleados) {
            System.out.println("Empleado: " + empleado.getNombre() + ", DNI: " + empleado.getDni());
        }
        for (Trabajador empleado : empleados) {
            System.out.println("Sueldo de " + empleado.getNombre() + ": " + empleado.calcularSueldo());
        }

        System.out.println("¿Desea dar de alta a algun empleado? SI/NO");
        String opcion = tc.next();
        while (opcion.equalsIgnoreCase("Si")) {
            System.out.println("Ingrese el dni del empleado que desea dar de alta");
            String eliminarDni = tc.next();
            boolean encontrado = false;
            for (int i = 0; i < empleados.size(); i++) {
                if (empleados.get(i).getDni().equals(eliminarDni)) {
                    empleados.remove(i);
                    System.out.println("Empleado con DNI " + eliminarDni + " ha sido dado de alta.");
                    for (Trabajador empleado : empleados) {
                        System.out.println("Empleado: " + empleado.getNombre() + ", DNI: " + empleado.getDni());
                    }
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("No se encontró un empleado con el DNI " + eliminarDni + ".");
            }
            System.out.println("¿Desea seguir buscando? SI/NO");
            opcion = tc.next();
        }
        System.out.println("Gracias por preferirnos");
    }
}
class Trabajador{
    String nombre;
    String apellidos;
    String direccion;
    String dni;

    public Trabajador(String nombre, String apellidos, String direccion, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDni() {
        return dni;
    }

    public double calcularSueldo(){
        return 0;
    }
}
class Jefe extends Trabajador{
    double sueldoFijo;
    public Jefe(String nombre, String apellidos, String direccion, String dni, double sueldoFijo) {
        super(nombre, apellidos, direccion, dni);
        this.sueldoFijo = sueldoFijo;
    }
    @Override
    public double calcularSueldo() {
        return sueldoFijo;
    }
}
class FijoMensual extends Trabajador{
    double sueldoMensual;

    public FijoMensual(String nombre, String apellidos, String direccion, String dni, double sueldoMensual) {
        super(nombre, apellidos, direccion, dni);
        this.sueldoMensual = sueldoMensual;
    }

    @Override
    public double calcularSueldo() {
        return sueldoMensual;
    }
}
class Comisionista extends Trabajador {
    double porcentajeComision;
    double ventasRealizadas;

    public Comisionista(String nombre, String apellidos, String direccion, String dni, double porcentajeComision) {
        super(nombre, apellidos, direccion, dni);
        this.porcentajeComision = porcentajeComision;
        this.ventasRealizadas = 0.0;
    }

    public void registrarVenta(double montoVenta) {
        ventasRealizadas += montoVenta;
    }

    @Override
    public double calcularSueldo() {
        return ventasRealizadas * (porcentajeComision / 100);
    }
}

class PorHoras extends Trabajador{
    double precioHoraNormal;
    double precioHoraExtra;
    int horasTrabajadas;
     public PorHoras(String nombre, String apellidos, String direccion, String dni,double precioHoraNormal, double precioHoraExtra) {
        super(nombre, apellidos, direccion, dni);
        this.precioHoraNormal = precioHoraNormal;
        this.precioHoraExtra = precioHoraExtra;
        this.horasTrabajadas = 0;
    }
    public void registrarHorasTrabajadas(int horas) {
        horasTrabajadas += horas;
    }

    @Override
    public double calcularSueldo() {
        if (horasTrabajadas <= 40) {
            return horasTrabajadas * precioHoraNormal;
        } else {
            int horasNormales = 40;
            int horasExtras = horasTrabajadas - 40;
            return horasNormales * precioHoraNormal + horasExtras * precioHoraExtra;
        }
    }
}