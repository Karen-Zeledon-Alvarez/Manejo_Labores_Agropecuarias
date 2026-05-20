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
import Model.Cultivo;
import Model.Labores;
import Model.Responsable;
import Model.Parcela;
import Data.ParcelaBDO;
import Data.CultivoDBO;
import Data.LaboresDBO;
import Data.ResponsableDBO;
import com.app.laboresagropecuarias.App;
import java.io.IOException;
import javafx.scene.control.Button;
import java.sql.Date;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import Model.CultivoAnual;
import Model.CultivoPerenne;
/**
 * FXML Controller class
 *
 * @author karen
 */
public class PantallaRegistrarController implements Initializable {
    Cultivo cultivo;
    
    CultivoDBO cultidao=new CultivoDBO();
    LaboresDBO  laboresdao=new LaboresDBO();
    Labores labores=new Labores();
    ResponsableDBO respondao= new ResponsableDBO();
    Responsable responsable= new Responsable();
    ParcelaBDO parceladao = new ParcelaBDO();
    
    @FXML
    private Button bnvolver;
    @FXML
    private TextField txtNombreCultivo;
    @FXML
    private TextField txtVariedad;
    @FXML
    private DatePicker dpFechaSiembra;
    @FXML
    private TextField txtTiempoEstimado;
    @FXML
    private Button btnGuardarCultivo;
    @FXML
    private TextField txtIdentificacion;
    @FXML
    private TextField txtNombreResponsable;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtTelefono;
    
    @FXML
    private TextField txtTipoDerivado;
    @FXML
    private Button btnGuardarResponsable;
    private TextField txtParcela;
   @FXML
    private ComboBox<Cultivo> cbCultivoLabor;
    @FXML
    private ComboBox<Responsable> cbResponsableLabor;
    @FXML
    private DatePicker dpFechaLabor;
    @FXML
    private TextArea txtDescripcion;
    @FXML
    private TextField txtCosto;
    
    @FXML
    private Button btnGuardarLabor;
    @FXML
    private ComboBox<String> cbTipoResponsable;
    @FXML
    private ComboBox<String> cbTipoLabor;
    @FXML
    private ComboBox<String> cbTipoCultivo;
    @FXML
    private TextField txtCodigoParcela;
    @FXML
    private TextField txtNombreParcela;
    @FXML
    private TextField txtUbicacion;
    @FXML
    private TextField txtArea;
    @FXML
    private TextField txtTipoSuelo;
    @FXML
    private ComboBox<String> cbEstadoParcela;
    @FXML
    private Button btnGuardarParcela;
    @FXML
    private ComboBox<Parcela> cbParcelaLabor;
    @FXML
    private ComboBox<String> cmbCategoriaCultivo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        cbTipoResponsable.setItems(
        FXCollections.observableArrayList(
                "Productor",
                "Tecnico agricola"
        )
            );
        cargarParcelaCombo();
        cargarCultivosCombo();
        cargarResponsablesCombo();
        cmbCategoriaCultivo.setItems(
             FXCollections.observableArrayList(
                 "Anual",
                 "Perenne"
                 )
        );
        cbTipoLabor.setItems(
        FXCollections.observableArrayList(
                "Riego",
                "Siembra",
                "Fertilización",
                "Poda",
                "Control de plagas",
                "Cosecha",
                "Otro"
        ));
        cbTipoCultivo.setItems(
        FXCollections.observableArrayList(
                "Cultivo Anual",
                "Cultivo Perenne"
                
        )
            );
        cbEstadoParcela.setItems(
        FXCollections.observableArrayList(
                "Disponible",
                "En Produccion",
                "En Descanso"
        ));

    btnGuardarParcela.setOnAction(e -> registrarParcela());

    btnGuardarCultivo.setOnAction(e -> registrarCultivo());

    btnGuardarResponsable.setOnAction(e -> registrarResponsable());

    btnGuardarLabor.setOnAction(e -> registrarLabor());

    bnvolver.setOnAction(e -> volverPrincipal());
    }
    @FXML
     private void volverPrincipal() {

        try {

            App.setRoot("PantallaPrincipal");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
     private void cargarParcelaCombo() {

    List<Parcela> listaParcela = parceladao.ListaParcela("");

    cbParcelaLabor.setItems(
            FXCollections.observableArrayList(listaParcela));

    }
     private void cargarCultivosCombo() {

    List<Cultivo> listaCultivos = cultidao.ListaCultivo("");

    cbCultivoLabor.setItems(
            FXCollections.observableArrayList(listaCultivos));

    }
     private void cargarResponsablesCombo() {

    List<Responsable> listaResponsables =
            respondao.ListaResponsable("");

    cbResponsableLabor.setItems(
            FXCollections.observableArrayList(listaResponsables));

    }
     private void registrarParcela() {

    try {

        Parcela p = new Parcela();

        p.setCodigoParcela(
                Integer.parseInt(
                        txtCodigoParcela.getText()));

        p.setNombreParcela(
                txtNombreParcela.getText());

        p.setUbicacion(
                txtUbicacion.getText());

        p.setArea(
                txtArea.getText());

        p.setTipoSuelo(
                txtTipoSuelo.getText());

        p.setEstadoParcela(
                cbEstadoParcela.getValue());

        boolean guardado =
                parceladao.AgregarParcela(p);

        if (guardado) {

            mostrarMensaje(
                    "Parcela registrada");

            limpiarParcela();

        } else {

            mostrarMensaje(
                    "Error al guardar parcela");
        }

    } catch (Exception e) {

        e.printStackTrace();

        mostrarMensaje(
                "Error en datos de parcela");
    }
    }
     
     private void limpiarParcela() {

    txtCodigoParcela.clear();
    txtNombreParcela.clear();
    txtUbicacion.clear();
    txtArea.clear();
    txtTipoSuelo.clear();

    cbEstadoParcela.setValue(null);
}
     
    private void registrarCultivo() {

         try {

        Cultivo c;

        String categoria = cmbCategoriaCultivo.getValue();

        if(categoria.equals("Anual")){

        c = new CultivoAnual();

        }else{

         c = new CultivoPerenne();
        }

        c.setNombreCultivo(txtNombreCultivo.getText());

        c.setVariedad(txtVariedad.getText());

        c.setFechaSiembra(dpFechaSiembra.getValue());

        c.setTipoCultivo(cbTipoCultivo.getValue());


        boolean guardado = cultidao.AgregarCultivo(c);

        if (guardado) {

            mostrarMensaje("Cultivo registrado correctamente");

            limpiarCultivo();

        } else {

            mostrarMensaje("Error al registrar cultivo");
        }

    } catch (Exception e) {

        e.printStackTrace();

        mostrarMensaje("Error en los datos del cultivo");
    }
    }
    private void limpiarCultivo() {

    txtNombreCultivo.clear();
    txtVariedad.clear();
    cbTipoCultivo.setValue(null);
    txtTiempoEstimado.clear();
    dpFechaSiembra.setValue(null);
    }
    // =========================
    // REGISTRAR RESPONSABLE
    // =========================

    private void registrarResponsable() {

         try {

        Responsable r = new Responsable();

        r.setIdentificacion(
                Integer.parseInt(txtIdentificacion.getText()));

        r.setNombre(txtNombreResponsable.getText());

        r.setCorreo(txtCorreo.getText());

        r.setTelefono(
                Integer.parseInt(txtTelefono.getText()));

        r.setTipoResponsable(cbTipoResponsable.getValue());

        r.setTipoDerivado(txtTipoDerivado.getText());

        boolean guardado = respondao.AgregarResponsable(r);

        if (guardado) {

            mostrarMensaje("Responsable registrado");

            limpiarResponsable();

        } else {

            mostrarMensaje("Error al registrar responsable");
        }

    } catch (Exception e) {

        e.printStackTrace();

        mostrarMensaje("Error en datos del responsable");
    }
    }
    private void limpiarResponsable() {

    txtIdentificacion.clear();
    txtNombreResponsable.clear();
    txtCorreo.clear();
    txtTelefono.clear();
    cbTipoResponsable.setValue(null);
    txtTipoDerivado.clear();
    }
    // =========================
    // REGISTRAR LABOR
    // =========================

    private void registrarLabor() {

        try {

        Labores l = new Labores();

        Parcela parcelaSeleccionado =
        cbParcelaLabor.getValue();

        l.setParcela(parcelaSeleccionado);


        Cultivo cultivoSeleccionado =
        cbCultivoLabor.getValue();

        l.setCultivoAso(cultivoSeleccionado);

        Responsable responsableSeleccionado =
        cbResponsableLabor.getValue();

        l.setResponsableAso(responsableSeleccionado);

        l.setFechaLabor(
                Date.valueOf(dpFechaLabor.getValue()));

        l.setTipoLabor(cbTipoLabor.getValue());

        l.setDescripcion(txtDescripcion.getText());

        l.setCostoEstimado(
                Integer.parseInt(txtCosto.getText()));

        boolean guardado =
                laboresdao.AgregarLabores(l);

        if (guardado) {

            mostrarMensaje("Labor registrada");

            limpiarLabor();

        } else {

            mostrarMensaje("Error al registrar labor");
        }

    } catch (Exception e) {

        e.printStackTrace();

        mostrarMensaje("Error en datos de la labor");
    }
    }
    private void limpiarLabor() {

    cbParcelaLabor.setValue(null);
    cbCultivoLabor.setValue(null);
    cbResponsableLabor.setValue(null);
    cbTipoLabor.setValue(null);
    txtDescripcion.clear();
    txtCosto.clear();

    dpFechaLabor.setValue(null);
    }
    private void mostrarMensaje(String mensaje) {

    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    alert.setTitle("Sistema");

    alert.setHeaderText(null);

    alert.setContentText(mensaje);

    alert.showAndWait();
    }
}
