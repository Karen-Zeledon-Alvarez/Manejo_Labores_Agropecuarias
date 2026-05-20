/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author karen
 */
public class Parcela {

    private int codigoParcela;
    private String nombreParcela;
    private String ubicacion;
    private String area;
    private String tipoSuelo;
    private String estadoParcela;

    public Parcela() {
    }

    public Parcela(int codigoParcela, String nombreParcela,
                   String ubicacion, String area,
                   String tipoSuelo, String estadoParcela) {

        this.codigoParcela = codigoParcela;
        this.nombreParcela = nombreParcela;
        this.ubicacion = ubicacion;
        this.area = area;
        this.tipoSuelo = tipoSuelo;
        this.estadoParcela = estadoParcela;
    }

    public int getCodigoParcela() {
        return codigoParcela;
    }

    public void setCodigoParcela(int codigoParcela) {
        this.codigoParcela = codigoParcela;
    }

    public String getNombreParcela() {
        return nombreParcela;
    }

    public void setNombreParcela(String nombreParcela) {
        this.nombreParcela = nombreParcela;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTipoSuelo() {
        return tipoSuelo;
    }

    public void setTipoSuelo(String tipoSuelo) {
        this.tipoSuelo = tipoSuelo;
    }

    public String getEstadoParcela() {
        return estadoParcela;
    }

    public void setEstadoParcela(String estadoParcela) {
        this.estadoParcela = estadoParcela;
    }

    @Override
    public String toString() {
        return nombreParcela;
    }
}

