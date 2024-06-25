public class Ejercicio_3 {
    public static void main(String[] args) {
        Movil remitente = new Movil("123456789", "Juan Landi");
        Movil destinatario = new Movil("987654321", "Pablo Largo");
        TiposMensaje sms = new Sms(remitente, destinatario, "Ñañito, de uuuuuuunaaaa");
        TiposMensaje mms = new Mms(remitente, destinatario, "Pies.jpg");
        sms.enviarMensaje();
        sms.visualizarMensaje();
        mms.enviarMensaje();
        mms.visualizarMensaje();
    }
}
class Movil{
    String numCell;
    String nombre;
    public Movil(String numCell) {
        this.numCell = numCell;
        this.nombre = null;
    }
    public Movil(String numCell, String nombre) {
        this.numCell = numCell;
        this.nombre = nombre;
    }
    public String getNumCell() {
        return numCell;
    }
    public String getNombre() {
        return nombre;
    }
    @Override
    public String toString() {
        if (nombre == null)
            return (numCell);
        else
            return(nombre + " (" + numCell + ")");
    }
}
class TiposMensaje{
    Movil remitente;
    Movil destinatario;

    public TiposMensaje(Movil remitente, Movil destinatario) {
        this.remitente = remitente;
        this.destinatario = destinatario;
    }
    public void enviarMensaje() {}
    public void visualizarMensaje() {}
}
class Sms extends TiposMensaje{
    String mensaje;
    public Sms(Movil remitente, Movil destinatario, String mensaje) {
        super(remitente, destinatario);
        this.mensaje = mensaje;
    }
    @Override
    public void enviarMensaje() {
        System.out.println("Enviando SMS de " + remitente + " a " + destinatario + ": " + mensaje);
    }
    @Override
    public void visualizarMensaje() {
        System.out.println("SMS de " + remitente + " a " + destinatario + ": " + mensaje);
    }
}
class Mms extends TiposMensaje{
    String nombreFichero;
    public Mms(Movil remitente, Movil destinatario, String nombreFichero) {
        super(remitente, destinatario);
        this.nombreFichero = nombreFichero;
    }
    @Override
    public void enviarMensaje() {
        System.out.println("Enviando MMS de " + remitente + " a " + destinatario + " con imagen: " + nombreFichero);
    }
    @Override
    public void visualizarMensaje() {
        System.out.println("MMS de " + remitente + " a " + destinatario + " con imagen: " + nombreFichero);
    }
}