package edd.bdi.proj;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danielairibarren
 */
public class Sucursal {
    
    private int numeroSucursal;
    private Parada parada;
    private Ciudad ciudad;

    public Sucursal(int numeroSucursal, Parada parada, Ciudad ciudad) {
        this.numeroSucursal = numeroSucursal;
        this.parada = parada;
        this.ciudad = ciudad;
        
    }

    /**
     * @return the numeroSucursal
     */
    public int getNumeroSucursal() {
        return numeroSucursal;
    }

    /**
     * @param numeroSucursal the numeroSucursal to set
     */
    public void setNumeroSucursal(int numeroSucursal) {
        this.numeroSucursal = numeroSucursal;
    }

    /**
     * @return the parada
     */
    public Parada getParada() {
        return parada;
    }

    /**
     * @param parada the parada to set
     */
    public void setParada(Parada parada) {
        this.parada = parada;
    }

    /**
     * @return the ciudad
     */
    public Ciudad getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
    

    

    
    
    
}
