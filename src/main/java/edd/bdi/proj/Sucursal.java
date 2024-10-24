package edd.bdi.proj;

/**
 * Clase que representa una sucursal.
 * Contiene una parada y una ciudad asociadas a la sucursal.
 */
public class Sucursal {

    private Parada parada;
    private Ciudad ciudad;

    /**
     * Constructor de la clase Sucursal.
     * Inicializa la sucursal con una parada y una ciudad.
     *
     * @param parada la parada asociada a la sucursal.
     * @param ciudad la ciudad asociada a la sucursal.
     */
    public Sucursal(Parada parada, Ciudad ciudad) {
        this.parada = parada;
        this.ciudad = ciudad;
    }

    /**
     * Obtiene la parada asociada a la sucursal.
     *
     * @return la parada asociada a la sucursal.
     */
    public Parada getParada() {
        return parada;
    }

    /**
     * Establece la parada asociada a la sucursal.
     *
     * @param parada la parada a establecer.
     */
    public void setParada(Parada parada) {
        this.parada = parada;
    }

    /**
     * Obtiene la ciudad asociada a la sucursal.
     *
     * @return la ciudad asociada a la sucursal.
     */
    public Ciudad getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad asociada a la sucursal.
     *
     * @param ciudad la ciudad a establecer.
     */
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
}