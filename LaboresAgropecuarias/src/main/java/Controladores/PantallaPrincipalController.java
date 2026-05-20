/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import Model.Labores;
import Model.Cultivo;
import Model.Responsable;
import Model.Parcela;
import Data.ParcelaBDO;
import Data.CultivoDBO;
import Data.LaboresDBO;
import Data.ResponsableDBO;
import Model.CultivoAnual;
import Model.CultivoPerenne;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import com.app.laboresagropecuarias.App;
import javafx.beans.property.SimpleStringProperty;
/**
 * FXML Controller class
 *
 * @author karen
 */
public class PantallaPrincipalController implements Initializable {
    

    CultivoDBO cultidao=new CultivoDBO();
    Cultivo cultivo = new CultivoAnual();
    Cultivo cultivo1 = new CultivoPerenne();
    @FXML
    private TextField txtBuscarCultivo;

    @FXML
    private TableView<Cultivo> tablaCultivos;

    @FXML
    private TableColumn<Cultivo, Integer> colCodigoCultivo;

    @FXML
    private TableColumn<Cultivo, String> colNombreCultivo;

    @FXML
    private TableColumn<Cultivo, String> colVariedadCultivo;

    @FXML
    private TableColumn<Cultivo, LocalDate> colFechaCultivo;

    @FXML
    private TableColumn<Cultivo, String> colTipoCultivo;
    
    @FXML
    private Button Btnbuscarcultivo;
    
    @FXML
    private Button registro1;
    
    @FXML
    private Tab tbcultivo;
    
    ResponsableDBO respondao= new ResponsableDBO();
    Responsable responsable= new Responsable();
    @FXML
    private TextField txtBuscarResponsable;

    @FXML
    private TableView<Responsable> tablaResponsables;

    @FXML
    private TableColumn<Responsable, Integer> colIdResponsable;

    @FXML
    private TableColumn<Responsable, String> colNombreResponsable;

    @FXML
    private TableColumn<Responsable, String> colCorreoResponsable;

    @FXML
    private TableColumn<Responsable, Integer> colTelefonoResponsable;

    @FXML
    private TableColumn<Responsable, String> colTipoResponsable;
    
    @FXML
    private Button registro2;
    
    @FXML
    private Tab tabres;
    
    @FXML
    private Button btnbuscarres;
    
    LaboresDBO  laboresdao=new LaboresDBO();
    Labores labores=new Labores();
    @FXML
    private TextField txtBuscarLabor;

    @FXML
    private TableView<Labores> tablaLabores;

    @FXML
    private TableColumn<Labores, Integer> colCodigoLabor;

    @FXML
    private TableColumn<Labores, Parcela> colParcelaLabor;

    @FXML
    private TableColumn<Labores, Cultivo> colCultivoLabor;

    @FXML
    private TableColumn<Labores, Responsable> colResponsableLabor;

    @FXML
    private TableColumn<Labores, LocalDate> colFechaLabor;

    @FXML
    private TableColumn<Labores, String> colTipoLabor;
   
    @FXML
    private Button registro3;
    
    @FXML
    private TabPane tbpnconsulta;

    @FXML
    private Tab tblab;
    @FXML
    private TextField txtBuscarParcela;

    @FXML
    private TableView<Parcela> tablaParcelas;

    @FXML
    private TableColumn<Parcela, Integer> colCodigoParcela;

    @FXML
    private TableColumn<Parcela, String> colNombreParcela;

    @FXML
    private TableColumn<Parcela, String> colUbicacionParcela;

    @FXML
    private TableColumn<Parcela, String> colAreaParcela;

    @FXML
    private TableColumn<Parcela, String> colTipoSuelo;

    @FXML
    private TableColumn<Parcela, String> colEstadoParcela;
    
    ParcelaBDO parceladao = new ParcelaBDO();
    
    @FXML
    private Button btnbuscarlabores;
    
    @FXML
    private TableColumn<Responsable, String> colTipoDerivado;
    @FXML
    private Button registro11;
    @FXML
    private TableColumn<Cultivo, String> colCategoriaCultivo;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     System.out.println("Pantalla de consultas cargada");
     
        colCodigoCultivo.setCellValueFactory( new PropertyValueFactory<>("codigoCultivo"));

        colNombreCultivo.setCellValueFactory( new PropertyValueFactory<>("nombreCultivo"));

        colVariedadCultivo.setCellValueFactory( new PropertyValueFactory<>("variedad"));

        colFechaCultivo.setCellValueFactory( new PropertyValueFactory<>("fechaSiembra"));

        colTipoCultivo.setCellValueFactory( new PropertyValueFactory<>("tipoCultivo"));
        
        colIdResponsable.setCellValueFactory( new PropertyValueFactory<>("identificacion"));
        
        colNombreResponsable.setCellValueFactory( new PropertyValueFactory<>("nombre"));
        
        colCorreoResponsable.setCellValueFactory( new PropertyValueFactory<>("correo"));
        
        colTelefonoResponsable.setCellValueFactory( new PropertyValueFactory<>("telefono"));
        
        colTipoResponsable.setCellValueFactory( new PropertyValueFactory<>("tipoResponsable"));
        
        colTipoDerivado.setCellValueFactory( new PropertyValueFactory<>("tipoDerivado"));
        
        colCodigoLabor.setCellValueFactory( new PropertyValueFactory<>("codigoLabor"));
        
        colParcelaLabor.setCellValueFactory( new PropertyValueFactory<>("parcelaAso"));
        
        colCultivoLabor.setCellValueFactory( new PropertyValueFactory<>("cultivoAso"));
        
        colResponsableLabor.setCellValueFactory( new PropertyValueFactory<>("responsableAso"));
        
        colFechaLabor.setCellValueFactory( new PropertyValueFactory<>("fechaLabor"));
        
        colTipoLabor.setCellValueFactory( new PropertyValueFactory<>("tipoLabor"));
        
       
        colCodigoParcela.setCellValueFactory(
        new PropertyValueFactory<>("codigoParcela"));

        colNombreParcela.setCellValueFactory(
        new PropertyValueFactory<>("nombreParcela"));

        colUbicacionParcela.setCellValueFactory(
        new PropertyValueFactory<>("ubicacion"));

        colAreaParcela.setCellValueFactory(
        new PropertyValueFactory<>("area"));

        colTipoSuelo.setCellValueFactory(
        new PropertyValueFactory<>("tipoSuelo"));

        colEstadoParcela.setCellValueFactory(
        new PropertyValueFactory<>("estadoParcela"));
        
        colCategoriaCultivo.setCellValueFactory(
        cellData ->
        new SimpleStringProperty(
            cellData.getValue().obtenerCategoria()
        )
        );
        cargarParcelas();
        
        cargarCultivos();
        cargarResponsables();
        cargarLabores();
     }

    @FXML
    private void Registrarvista() {
         try {

            App.setRoot("PantallaRegistrar");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    
    private void cargarParcelas() {

    tablaParcelas.getItems().clear();

    tablaParcelas.getItems().addAll(
            parceladao.ListaParcela(""));
    }
    
    private void cargarCultivos() {

    tablaCultivos.getItems().clear();

    List<Cultivo> lista =
            cultidao.ListaCultivo("");

    tablaCultivos.getItems().addAll(lista);
    }

    private void cargarResponsables() {

    tablaResponsables.getItems().clear();

    List<Responsable> lista =
            respondao.ListaResponsable("");

    tablaResponsables.getItems().addAll(lista);
    }

    private void cargarLabores() {

    tablaLabores.getItems().clear();

    List<Labores> lista =
            laboresdao.ListaLabores("");

    tablaLabores.getItems().addAll(lista);
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

        String texto = txtBuscarCultivo.getText().trim();

        System.out.println("Buscar cultivo: " + texto);

        tablaCultivos.getItems().clear();
        if(!texto.isEmpty()){
             List<Cultivo> listaCultivos = cultidao.ListaCultivo(texto);
        tablaCultivos.getItems().addAll(listaCultivos);
        }
       
    }
    
    @FXML
    private void buscarResponsables() {

        String texto = txtBuscarResponsable.getText().trim();

        System.out.println("Buscar responsable: " + texto);
        
        tablaResponsables.getItems().clear();
        if(!texto.isEmpty()){
            List<Responsable> listaResponsable= respondao.ListaResponsable(texto);
            tablaResponsables.getItems().addAll(listaResponsable);
        }
    }

    @FXML
    private void buscarLabores() {

        String texto = txtBuscarLabor.getText().trim();

        System.out.println("Buscar labor: " + texto);
       
        tablaLabores.getItems().clear();
        if(!texto.isEmpty()){
            List<Labores> listaLabores= laboresdao.ListaLabores(texto);
            tablaLabores.getItems().addAll(listaLabores);
        }

    }
    @FXML
    private void buscarParcelas() {

        String texto = txtBuscarParcela.getText().trim();

        tablaParcelas.getItems().clear();
        if(!texto.isEmpty()){
        tablaParcelas.getItems().addAll(
            parceladao.ListaParcela(texto));
        }
            }

}
