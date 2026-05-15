/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
/**
 * FXML Controller class
 *
 * @author karen
 */
public class PantallaRegistrarController implements Initializable {

    @FXML
    private ComboBox<String> cbTipoRegistro;
    @FXML
    private VBox panelCultivo;
    @FXML
    private VBox panelResponsable;
    @FXML
    private VBox panelLabor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       cbTipoRegistro.setItems(
                FXCollections.observableArrayList(
                        "Cultivo",
                        "Responsable",
                        "Labor"
                )
        );

        ocultarTodos();
    }    
     @FXML
    private void mostrarFormulario() {

        String opcion = cbTipoRegistro.getValue();

        ocultarTodos();

        if (opcion == null) {
            return;
        }

        switch (opcion) {

            case "Cultivo":
                panelCultivo.setVisible(true);
                panelCultivo.setManaged(true);
                break;

            case "Responsable":
                panelResponsable.setVisible(true);
                panelResponsable.setManaged(true);
                break;

            case "Labor":
                panelLabor.setVisible(true);
                panelLabor.setManaged(true);
                break;
        }

    }

    private void ocultarTodos() {

        panelCultivo.setVisible(false);
        panelCultivo.setManaged(false);

        panelResponsable.setVisible(false);
        panelResponsable.setManaged(false);

        panelLabor.setVisible(false);
        panelLabor.setManaged(false);
    }

    // =========================
    // REGISTRAR CULTIVO
    // =========================

    @FXML
    private void registrarCultivo() {

        System.out.println("Cultivo registrado");

        // Aquí puedes guardar en BD
    }

    // =========================
    // REGISTRAR RESPONSABLE
    // =========================

    @FXML
    private void registrarResponsable() {

        System.out.println("Responsable registrado");

    }

    // =========================
    // REGISTRAR LABOR
    // =========================

    @FXML
    private void registrarLabor() {

        System.out.println("Labor registrada");

    }
}
