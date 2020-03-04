package soporte.pac.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import soporte.pac.PacApplication;
import soporte.pac.controller.utilgui.EVentanas;
import soporte.pac.controller.utilgui.IControladorVentana;

@Component
public class MenuController implements Initializable, IControladorVentana {

    private AdminitradorVentanas adminVentanas;

    @FXML
    private Button btnEstado;
    @FXML
    private BorderPane borderPane;
    @FXML
    private ButtonBar buttonBar;
    @FXML
    private HBox hBox;

    @Override
    public void setAdminVentana(AdminitradorVentanas adminVentana) {
        System.out.println("setAdminVentana");
        this.adminVentanas = adminVentana;
        this.adminVentanas.getStage().setMaximized(true);
        borderPane.prefWidthProperty().bind(adminVentana.getStage().widthProperty());
        buttonBar.prefWidthProperty().bind(adminVentana.getScene().widthProperty());
        borderPane.setPrefHeight(adminVentana.getScene().getHeight() - 30);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("initialize");
    }

    @FXML
    private void goConfiguracion(ActionEvent event) {
        adminVentanas.cargarVentana(EVentanas.CONFIGURACION);
        adminVentanas.setVentana(EVentanas.CONFIGURACION.getIdVentana());
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
