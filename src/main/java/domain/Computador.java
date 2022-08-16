package domain;
/**
 *
 * @author jhona
 */
public class Computador {
    private int idComputador;
    private String nombre;
    private int idMonitor;
    private int idTeclado;
    private int idRaton;

    public Computador() {
    }

    public Computador(String nombre, int idMonitor, int idTeclado, int idRaton) {
        this.nombre = nombre;
        this.idMonitor = idMonitor;
        this.idTeclado = idTeclado;
        this.idRaton = idRaton;
    }

    public Computador(int idComputador, String nombre, int idMonitor, int idTeclado, int idRaton) {
        this.idComputador = idComputador;
        this.nombre = nombre;
        this.idMonitor = idMonitor;
        this.idTeclado = idTeclado;
        this.idRaton = idRaton;
    }

    public int getIdComputador() {
        return idComputador;
    }

    public void setIdComputador(int idComputador) {
        this.idComputador = idComputador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdMonitor() {
        return idMonitor;
    }

    public void setIdMonitor(int idMonitor) {
        this.idMonitor = idMonitor;
    }

    public int getIdTeclado() {
        return idTeclado;
    }

    public void setIdTeclado(int idTeclado) {
        this.idTeclado = idTeclado;
    }

    public int getIdRaton() {
        return idRaton;
    }

    public void setIdRaton(int idRaton) {
        this.idRaton = idRaton;
    }

    @Override
    public String toString() {
        return "Computador{" + "idComputador=" + idComputador + ", nombre=" + nombre + ", idMonitor=" + idMonitor + ", idTeclado=" + idTeclado + ", idRaton=" + idRaton + '}';
    }
    
}
