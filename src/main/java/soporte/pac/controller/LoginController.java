package soporte.pac.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import soporte.pac.PacApplication;
import soporte.pac.controller.utilgui.DialogBuilder;
import soporte.pac.controller.utilgui.EVentanas;
import soporte.pac.controller.utilgui.IControladorVentana;
import soporte.pac.model.Usuario;
import soporte.pac.model.repo.IUsuario;

@Component
public class LoginController implements Initializable, IControladorVentana {

    private AdminitradorVentanas adminVentanas;

    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtClave;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnCancelar;

    @Autowired
    private IUsuario usuarioRep;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @Override
    public void setAdminVentana(AdminitradorVentanas adminVentana) {
        this.adminVentanas = adminVentana;
    }

    @FXML
    private void cursorMano(){
        PacApplication.cursorMano();
    }
    @FXML
    private void cursorNormal(){
        PacApplication.cursorNormal();
    }

    @FXML
    private void goMenuPrincipal(ActionEvent event) {
        if(txtUsuario.getText().isEmpty() || txtClave.getText().isEmpty()) {
           DialogBuilder.create().title("Datos de entrada vacios").
                         contentText("Digite usuario y clave por favor.").
                         alert(Alert.AlertType.ERROR).build().showAndWait();
           return;
        }

        Optional<Usuario> usuario = usuarioRep.findById(txtUsuario.getText());
        if(usuario.isPresent() && usuario.get().getClave().equals(txtClave.getText())) {
            adminVentanas.cargarVentana(EVentanas.PRINCIPAL);
            adminVentanas.setVentana(EVentanas.PRINCIPAL.getIdVentana());
        }
        else {
            DialogBuilder.create().title("Credenciales invalidas").
            contentText("Usuario o clave invalidas.").
            alert(Alert.AlertType.WARNING).build().showAndWait();
            txtClave.setText("");
            txtClave.requestFocus();
        }
    }

    @FXML
    private void salir(ActionEvent event) {
        //System.exit(0);
        adminVentanas.cargarVentana(EVentanas.PRINCIPAL);
        adminVentanas.setVentana(EVentanas.PRINCIPAL.getIdVentana());
    }
}
