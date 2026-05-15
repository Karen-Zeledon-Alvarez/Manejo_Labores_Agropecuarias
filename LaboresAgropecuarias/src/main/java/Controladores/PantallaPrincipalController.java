/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import Model.Labores;
import Model.Cultivo;
import Model.Responsable;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
/**
 * FXML Controller class
 *
 * @author karen
 */
public class PantallaPrincipalController implements Initializable {
  // CULTIVOS

    @FXML
    private TextField txtBuscarCultivo;

    @FXML
    private TableView<Cultivo> tablaCultivos;

    @FXML
    private TableColumn<?, ?> colCodigoCultivo;

    @FXML
    private TableColumn<?, ?> colNombreCultivo;

    @FXML
    private TableColumn<?, ?> colVariedadCultivo;

    @FXML
    private TableColumn<?, ?> colFechaCultivo;

    @FXML
    private TableColumn<?, ?> colTipoCultivo;
    
    @FXML
    private Button Btnbuscarcultivo;
    
    @FXML
    private Button registro1;
    
    @FXML
    private Tab tbcultivo;
    // RESPONSABLES

    @FXML
    private TextField txtBuscarResponsable;

    @FXML
    private TableView<Responsable> tablaResponsables;

    @FXML
    private TableColumn<?, ?> colIdResponsable;

    @FXML
    private TableColumn<?, ?> colNombreResponsable;

    @FXML
    private TableColumn<?, ?> colCorreoResponsable;

    @FXML
    private TableColumn<?, ?> colTelefonoResponsable;

    @FXML
    private TableColumn<?, ?> colTipoResponsable;
    
    @FXML
    private Button registro2;
    
    @FXML
    private Tab tabres;
    
    @FXML
    private Button btnbuscarres;
    
    // LABORES

    @FXML
    private TextField txtBuscarLabor;

    @FXML
    private TableView<Labores> tablaLabores;

    @FXML
    private TableColumn<?, ?> colCodigoLabor;

    @FXML
    private TableColumn<?, ?> colParcelaLabor;

    @FXML
    private TableColumn<?, ?> colCultivoLabor;

    @FXML
    private TableColumn<?, ?> colResponsableLabor;

    @FXML
    private TableColumn<?, ?> colFechaLabor;

    @FXML
    private TableColumn<?, ?> colTipoLabor;
   
    @FXML
    private Button registro3;
    
    @FXML
    private TabPane tbpnconsulta;

    @FXML
    private Tab tblab;
    
    @FXML
    private Button btnbuscarlabores;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     System.out.println("Pantalla de consultas cargada");
    }

    @FXML
    private void Registrarvista(ActionEvent event) {
        cargarVista("/Fxml/PantallaRegistro.fxml");
    }
    
     private void cargarVista(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Pane vista = loader.load();
            
            } catch (IOException e) {
            System.err.println("Error al cargar la vista: " + fxml);
            e.printStackTrace();
        }
     }
     @FXML
    private void buscarCultivos() {

        String texto = txtBuscarCultivo.getText();

        System.out.println("Buscar cultivo: " + texto);

        // Consulta BD
    }
    
    @FXML
    private void buscarResponsables() {

        String texto = txtBuscarResponsable.getText();

        System.out.println("Buscar responsable: " + texto);

    }

    @FXML
    private void buscarLabores() {

        String texto = txtBuscarLabor.getText();

        System.out.println("Buscar labor: " + texto);

    }


}
