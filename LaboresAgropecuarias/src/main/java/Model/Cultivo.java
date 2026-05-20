/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import java.time.LocalDate;


/**
 *
 * @author karen
 */
public abstract class Cultivo {
    
    private int CodigoCultivo;
    private String NombreCultivo;
    private String Variedad;
    private LocalDate FechaSiembra;
    private String TipoCultivo;
    protected String categoriaCultivo;
    
    
    public Cultivo(){
    }
    
    public Cultivo(int codigo){
        this.CodigoCultivo=codigo;
    }
    
    public Cultivo(int codigo, String nombre, String variedad, LocalDate fecha, String tipo){
        this.CodigoCultivo=codigo;
        this.NombreCultivo=nombre;
        this.Variedad=variedad;
        this.FechaSiembra=fecha;
        this.TipoCultivo=tipo;
        
               
    }

    public int getCodigoCultivo() {
        return CodigoCultivo;
    }

    public void setCodigoCultivo(int CodigoCultivo) {
        this.CodigoCultivo = CodigoCultivo;
    }

    public String getNombreCultivo() {
        return NombreCultivo;
    }

    public void setNombreCultivo(String NombreCultivo) {
        this.NombreCultivo = NombreCultivo;
    }

    public String getVariedad() {
        return Variedad;
    }

    public void setVariedad(String Variedad) {
        this.Variedad = Variedad;
    }

    public LocalDate getFechaSiembra() {
        return FechaSiembra;
    }

    public void setFechaSiembra(LocalDate FechaSiembra) {
        this.FechaSiembra = FechaSiembra;
    }

    public String getTipoCultivo() {
        return TipoCultivo;
    }

    public void setTipoCultivo(String TipoCultivo) {
        this.TipoCultivo = TipoCultivo;
    }
    
    public String getCategoriaCultivo() {
    return categoriaCultivo;
    }
    
    public void setCategoriaCultivo(String categoriaCultivo) {
    this.categoriaCultivo = categoriaCultivo;
    }
    
    public abstract String obtenerCategoria();
    
    @Override
    public String toString() {
    return NombreCultivo;
    }
}
