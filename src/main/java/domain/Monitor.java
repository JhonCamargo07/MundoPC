package domain;

/**
 *
 * @author jhona
 */
public class Monitor {
    private int idMonitor;
    private String marca;
    private double size;

    public Monitor() {
    }

    public Monitor(int idMonitor) {
        this.idMonitor = idMonitor;
    }

    public Monitor(String marca, double size) {
        this.marca = marca;
        this.size = size;
    }

    public Monitor(int idMonitor, String marca, double size) {
        this.idMonitor = idMonitor;
        this.marca = marca;
        this.size = size;
    }

    public int getIdMonitor() {
        return idMonitor;
    }

    public void setIdMonitor(int idMonitor) {
        this.idMonitor = idMonitor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Monitor{" + "idMonitor=" + idMonitor + ", marca=" + marca + ", size=" + size + '}';
    }
    
}
