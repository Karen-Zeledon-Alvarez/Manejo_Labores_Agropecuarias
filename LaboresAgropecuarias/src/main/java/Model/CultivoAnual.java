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
public class CultivoAnual extends Cultivo{
    public CultivoAnual() {
        super();
    }

    public CultivoAnual(int codigoCultivo,
                          String nombreCultivo,
                          String variedad,
                          LocalDate fechaCultivo,
                          String tipoCultivo) {

        super(codigoCultivo, nombreCultivo, variedad, fechaCultivo, tipoCultivo);
    }

    @Override
    public String obtenerCategoria() {
        return "Anual";
    }
}
