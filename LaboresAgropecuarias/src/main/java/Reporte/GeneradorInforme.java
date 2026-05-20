/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reporte;

import Data.LaboresDBO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import Model.Labores;

public class GeneradorInforme {
  private final LaboresDBO laborDAO;

    public GeneradorInforme() {
        this.laborDAO = new LaboresDBO();
    }

    public void generarInforme() {
        generarInforme("txt");
    }

    public void generarInformeCSV() {
        generarInforme("csv");
    }

    private void generarInforme(String formato) {
        try {
            List<Labores> labores = laborDAO.ListaLabores("");

            if (labores.isEmpty()) {
                System.out.println("No hay labores registradas para generar el informe.");
                return;
            }

            String nombreArchivo = "informe_labores_agricolas." + formato;
            File archivo = new File(nombreArchivo);

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {

                String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                if (formato.equals("txt")) {
                    bw.write("====================================================================\n");
                    bw.write("               INFORME DE LABORES AGRÍCOLAS\n");
                    bw.write("====================================================================\n");
                    bw.write("Fecha de generación: " + fecha + "\n");
                    bw.write("Total de labores: " + labores.size() + "\n\n");

                    for (Labores l : labores) {
                        bw.write("Código: " + l.getCodigoLabor() + "\n");
                        bw.write("Fecha: " + l.getFechaLabor() + "\n");
                        bw.write("Parcela: " + (l.getParcelaAso() != null ? l.getParcelaAso().getNombreParcela() : "N/A") + "\n");
                        bw.write("Cultivo: " + (l.getCultivoAso()!= null ? l.getCultivoAso().getNombreCultivo() : "N/A") + "\n");
                        bw.write("Responsable: " + (l.getResponsableAso() != null ? l.getResponsableAso().getNombre() : "N/A") + "\n");
                        bw.write("Tipo de Labor: " + l.getTipoLabor() + "\n");
                        bw.write("Costo Estimado: " + l.getCostoEstimado() + "\n");
                        bw.write("Descripción: " + l.getDescripcion() + "\n");
                        bw.write("--------------------------------------------------------------------\n");
                    }

                } else if (formato.equals("csv")) {
                    bw.write("codigo,fecha,parcela,cultivo,responsable,tipo_labor,costo_estimado,descripcion\n");

                    for (Labores l : labores) {
                        bw.write(l.getCodigoLabor() + ",");
                        bw.write(l.getFechaLabor() + ",");
                        bw.write((l.getParcelaAso() != null ? l.getParcelaAso().getNombreParcela() : "N/A") + ",");
                        bw.write((l.getCultivoAso() != null ? l.getCultivoAso().getNombreCultivo() : "N/A") + ",");
                        bw.write((l.getResponsableAso() != null ? l.getResponsableAso().getNombre() : "N/A") + ",");
                        bw.write(l.getTipoLabor() + ",");
                        bw.write(l.getCostoEstimado() + ",");
                        bw.write("\"" + l.getDescripcion().replace("\"", "'") + "\"\n");
                    }
                }
            }

            System.out.println("Informe generado exitosamente: " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
