/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author karen
 */
public class Labores {
    
    private int CodigoLabor;
    private Parcela ParcelaAso;
    private Cultivo CultivoAso;
    private Responsable ResponsableAso;
    private Date FechaLabor;
    private String TipoLabor;
    private String Descripcion;
    private int CostoEstimado;
    
    public Labores(){}
    
    public Labores(int codigo){this.CodigoLabor=codigo;}
    
    public Labores(int codigo, Parcela parcela, Cultivo cultivo, Responsable responsable, Date fecha, String tipo, String descripcion, int costo){
        this.CodigoLabor=codigo;
        this.ParcelaAso=parcela;
        this.CultivoAso=cultivo;
        this.ResponsableAso=responsable;
        this.FechaLabor=fecha;
        this.TipoLabor=tipo;
        this.Descripcion=descripcion;
        this.CostoEstimado=costo;
    }

    public int getCodigoLabor() {
        return CodigoLabor;
    }

    public void setCodigoLabor(int CodigoLabor) {
        this.CodigoLabor = CodigoLabor;
    }

    public Parcela getParcelaAso() {
        return ParcelaAso;
    }

    public void setParcelaAso(Parcela ParcelaAso) {
        this.ParcelaAso = ParcelaAso;
    }

    public Cultivo getCultivoAso() {
        return CultivoAso;
    }

    public void setCultivoAso(Cultivo CultivoAso) {
        this.CultivoAso = CultivoAso;
    }

    public Responsable getResponsableAso() {
        return ResponsableAso;
    }

    public void setResponsableAso(Responsable ResponsableAso) {
        this.ResponsableAso = ResponsableAso;
    }

    public Date getFechaLabor() {
        return FechaLabor;
    }

    public void setFechaLabor(Date FechaLabor) {
        this.FechaLabor = FechaLabor;
    }

    public String getTipoLabor() {
        return TipoLabor;
    }

    public void setTipoLabor(String TipoLabor) {
        this.TipoLabor = TipoLabor;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getCostoEstimado() {
        return CostoEstimado;
    }

    public void setCostoEstimado(int CostoEstimado) {
        this.CostoEstimado = CostoEstimado;
    }
    
    
}
