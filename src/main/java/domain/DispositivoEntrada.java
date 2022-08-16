package domain;

/**
 *
 * @author jhona
 */
public class DispositivoEntrada {

    private int idDispositivo;
    private String tipoEntrada;
    private String marca;

    public DispositivoEntrada() {
    }

    public DispositivoEntrada(String tipoEntrada, String marca) {
        this.tipoEntrada = tipoEntrada;
        this.marca = marca;
    }

    public DispositivoEntrada(int idDispositivo, String tipoEntrada, String marca) {
        this.idDispositivo = idDispositivo;
        this.tipoEntrada = tipoEntrada;
        this.marca = marca;
    }

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "DispositivoEntrada{" + "idDispositivo=" + idDispositivo + ", tipoEntrada=" + tipoEntrada + ", marca=" + marca + '}';
    }

}
