package domain;

/**
 *
 * @author jhona
 */
public class Teclado {
    private int idTeclado;
    private int idDispositivo;

    public Teclado() {
    }

    public Teclado(int idTeclado) {
        this.idTeclado = idTeclado;
    }
    
    public Teclado(int idTeclado, int idDispositivo) {
        this.idTeclado = idTeclado;
        this.idDispositivo = idDispositivo;
    }

    public int getIdTeclado() {
        return idTeclado;
    }

    public void setIdTeclado(int idTeclado) {
        this.idTeclado = idTeclado;
    }

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    @Override
    public String toString() {
        return "Teclado{" + "idTeclado=" + idTeclado + ", idDispositivo=" + idDispositivo + '}';
    }

}
