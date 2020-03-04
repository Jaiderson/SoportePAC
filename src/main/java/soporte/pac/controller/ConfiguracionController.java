package soporte.pac.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import soporte.pac.PacApplication;
import soporte.pac.controller.utilgui.EVentanas;
import soporte.pac.controller.utilgui.IControladorVentana;

@Component
public class ConfiguracionController  implements Initializable, IControladorVentana {

    private AdminitradorVentanas adminVentanas;

    @FXML
    private HBox hbMenu;
    @FXML
    private BorderPane pane;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtRutaFondo;
    @FXML
    private TextField txtRutaConfiguracion;
    @FXML
    private TextField txtUsuarioGwb;
    @FXML
    private PasswordField txtClaveGwb;
    @FXML
    private TextField txtUsuarioSlw;
    @FXML
    private PasswordField txtClaveSlw;

    @Override
    public void setAdminVentana(AdminitradorVentanas adminVentana) {
        this.adminVentanas = adminVentana;
        pane.prefWidthProperty().bind(this.adminVentanas.getStage().widthProperty());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }

    @FXML
    private void guardar(ActionEvent event) {

    }
    
    @FXML
    private void regresarMenu(ActionEvent event){
        adminVentanas.cargarVentana(EVentanas.PRINCIPAL);
        this.adminVentanas.setVentana(EVentanas.PRINCIPAL.getIdVentana());
    }

    @FXML
    private void cursorMano(){
        PacApplication.cursorMano();
    }

    @FXML
    private void cursorNormal(){
        PacApplication.cursorNormal();
    }

}
