package domain;

/**
 *
 * @author jhona
 */
public class Orden {
    private int idOrden;
    private static int maxOrden;
    private int idComputador;

    public Orden() {
    }

    public Orden(int idOrden, int idComputador) {
        this.idOrden = idOrden;
        this.idComputador = idComputador;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public static int getMaxOrden() {
        return Orden.maxOrden;
    }

    public static void setMaxOrden(int maxOrden) {
        Orden.maxOrden = maxOrden;
    }

    public int getIdComputador() {
        return idComputador;
    }

    public void setIdComputador(int idComputador) {
        this.idComputador = idComputador;
    }

    @Override
    public String toString() {
        return "Orden{" + "idOrden=" + idOrden + ", idComputador=" + idComputador + '}';
    }
    
}
