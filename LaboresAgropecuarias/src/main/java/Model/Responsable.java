/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author karen
 */
public class Responsable {
    
    private int Identificacion ;
    private String Nombre;
    private String Correo;
    private int Telefono;
    private String TipoResponsable;
    private String TipoDerivado;
    
    
    public Responsable(){
    }
    
    public Responsable(int identificacion){
        this.Identificacion=identificacion;
    }
    
    public Responsable(int identificacion, String nombre, String correo, int telefono, String tiporesponsable, String derivado){
        this.Identificacion=identificacion;
        this.Nombre=nombre;
        this.Correo=correo;
        this.Telefono=telefono;
        this.TipoResponsable=tiporesponsable;
        this.TipoDerivado=derivado;
    }

    public int getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(int Identificacion) {
        this.Identificacion = Identificacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getTipoResponsable() {
        return TipoResponsable;
    }

    public void setTipoResponsable(String TipoResponsable) {
        this.TipoResponsable = TipoResponsable;
    }

    public String getTipoDerivado() {
        return TipoDerivado;
    }

    public void setTipoDerivado(String TipoDerivado) {
        this.TipoDerivado = TipoDerivado;
    }
    
    @Override
    public String toString() {
    return Nombre;
    }
}
