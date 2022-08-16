package domain;

/**
 *
 * @author jhona
 */
public class Raton {
    private int idRaton ;
    private int idDispositivo;

    public Raton() {
    }

    public Raton(int idRaton) {
        this.idRaton = idRaton;
    }

    public Raton(int idRaton, int idDispositivo) {
        this.idRaton = idRaton;
        this.idDispositivo = idDispositivo;
    }

    public int getIdRaton() {
        return idRaton;
    }

    public void setIdRaton(int idRaton) {
        this.idRaton = idRaton;
    }

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    @Override
    public String toString() {
        return "Raton{" + "idRaton=" + idRaton + ", idDispositivo=" + idDispositivo + '}';
    }
    
}
