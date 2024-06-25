import java.util.Scanner;

public class Ejercicio_6 {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        System.out.println("Bienvenido al banco de Jay 3.1416 Y SUS AMIGOS");
        Ahorro cuentaAhorro = new Ahorro("123456", "Juan Perez", 1000);
        Cheque cuentaCheque = new Cheque("234567", "Maria Lopez", 2000);
        Platino cuentaPlatino = new Platino("345678", "Carlos Garcia", 3000);
        realizarOperacion(tc, cuentaAhorro);
        realizarOperacion(tc, cuentaCheque);
        realizarOperacion(tc, cuentaPlatino);
    }

    public static void realizarOperacion(Scanner tc, Ahorro cuenta) {
        System.out.println("1) Deposito");
        System.out.println("2) Retirar");
        System.out.println("3) Balance");
        System.out.println("Seleccione una operación: ");
        int opcion = tc.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Inserte la cantidad a depositar: ");
                double deposito = tc.nextDouble();
                cuenta.depositarDinero(deposito);
                System.out.println("Se ha depositado el monto de: " + deposito);
                System.out.println("Su cuenta tiene un balance de: " + cuenta.obtenerBalance() + " con intereses: " + cuenta.calcularInteres());
                break;
            case 2:
                System.out.print("Inserte la cantidad a retirar: ");
                double retiro = tc.nextDouble();
                cuenta.retirarDinero(retiro);
                System.out.println("Se ha retirado el monto de: " + retiro);
                System.out.println("Su cuenta tiene un balance de: " + cuenta.obtenerBalance() + " con intereses: " + cuenta.calcularInteres());
                break;
            case 3:
                System.out.println("Balance de su cuenta " + cuenta.numCuenta + " tiene: " + cuenta.obtenerBalance() + " con intereses: " + cuenta.calcularInteres());
                break;
            default:
                System.out.println("Opción no disponible");
                break;
        }
    }

    public static void realizarOperacion(Scanner tc, Cheque cuenta) {
        System.out.println("1) Deposito");
        System.out.println("2) Retirar");
        System.out.println("3) Balance");
        System.out.println("Seleccione una operación: ");
        int opcion = tc.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Inserte la cantidad a depositar: ");
                double deposito = tc.nextDouble();
                cuenta.depositarDinero(deposito);
                System.out.println("Se ha depositado el monto de: " + deposito);
                System.out.println("Su cuenta tiene un balance de: " + cuenta.obtenerBalance());
                break;
            case 2:
                System.out.print("Inserte la cantidad a retirar: ");
                double retiro = tc.nextDouble();
                cuenta.retirarDinero(retiro);
                System.out.println("Se ha retirado el monto de: " + retiro);
                System.out.println("Su cuenta tiene un balance de: " + cuenta.obtenerBalance());
                break;
            case 3:
                System.out.println("Balance de su cuenta " + cuenta.numCuenta + " tiene: " + cuenta.obtenerBalance());
                break;
            default:
                System.out.println("Opción no disponible");
                break;
        }
    }

    public static void realizarOperacion(Scanner tc, Platino cuenta) {
        System.out.println("1) Deposito");
        System.out.println("2) Retirar");
        System.out.println("3) Balance");
        System.out.println("Seleccione una operación: ");
        int opcion = tc.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Inserte la cantidad a depositar: ");
                double deposito = tc.nextDouble();
                cuenta.depositarDinero(deposito);
                System.out.println("Se ha depositado el monto de: " + deposito);
                System.out.println("Su cuenta tiene un balance de: " + cuenta.obtenerBalance() + " con intereses: " + cuenta.calcularInteres());
                break;
            case 2:
                System.out.print("Inserte la cantidad a retirar: ");
                double retiro = tc.nextDouble();
                cuenta.retirarDinero(retiro);
                System.out.println("Se ha retirado el monto de: " + retiro);
                System.out.println("Su cuenta tiene un balance de: " + cuenta.obtenerBalance() + " con intereses: " + cuenta.calcularInteres());
                break;
            case 3:
                System.out.println("Balance de su cuenta " + cuenta.numCuenta + " tiene: " + cuenta.obtenerBalance() + " con intereses: " + cuenta.calcularInteres());
                break;
            default:
                System.out.println("Opción no disponible");
                break;
        }
    }
}

class Cuenta {
    public String numCuenta;
    public String nombreCliente;
    public double balance;

    public Cuenta(String numCuenta, String nombreCliente, double balance) {
        this.numCuenta = numCuenta;
        this.nombreCliente = nombreCliente;
        this.balance = balance;
    }

    public void depositarDinero(double deposito) {
        this.balance += deposito;
    }

    public void retirarDinero(double retiro) {
        this.balance -= retiro;
    }

    public double obtenerBalance() {
        return this.balance;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numCuenta=" + numCuenta + ", nombreCliente=" + nombreCliente + ", balance=" + balance + '}';
    }
}

class Ahorro extends Cuenta {
    public double interes;
    public double balanceInteres;

    public Ahorro(String numCuenta, String nombreCliente, double balance) {
        super(numCuenta, nombreCliente, balance);
    }

    public double calcularInteres() {
        this.interes = this.balance * 0.05;
        return this.balanceInteres = this.balance + this.interes;
    }

    @Override
    public String toString() {
        return super.toString() + " Tipo de cuenta: Ahorro{" + "interes=" + interes + ", balanceInteres=" + balanceInteres + '}';
    }
}

class Cheque extends Cuenta {
    public Cheque(String numCuenta, String nombreCliente, double balance) {
        super(numCuenta, nombreCliente, balance);
    }

    @Override
    public String toString() {
        return super.toString() + " Tipo de cuenta: Cheque";
    }
}

class Platino extends Cuenta {
    public double interes;
    public double balanceInteres;

    public Platino(String numCuenta, String nombreCliente, double balance) {
        super(numCuenta, nombreCliente, balance);
    }

    public double calcularInteres() {
        this.interes = this.balance * 0.10;
        return this.balanceInteres = this.balance + this.interes;
    }

    @Override
    public String toString() {
        return super.toString() + " Tipo de cuenta: Platino{" + "interes=" + interes + ", balanceInteres=" + balanceInteres + '}';
    }
}