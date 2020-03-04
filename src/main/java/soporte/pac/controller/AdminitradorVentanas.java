package soporte.pac.controller;

import java.io.IOException;
import java.util.HashMap;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import soporte.pac.PacApplication;
import soporte.pac.controller.utilgui.DialogBuilder;
import soporte.pac.controller.utilgui.EVentanas;
import soporte.pac.controller.utilgui.IControladorVentana;
/**
 *
 * @author Jaider Adriam Serrano Sepulveda
 */

public class AdminitradorVentanas  extends BorderPane {

    private final HashMap<String, Node> ventanas;
    private final Stage stage;
   
    public AdminitradorVentanas(Stage stage) {
        super();
        this.stage = stage;
        ventanas = new HashMap<>();
    }
    /**
     * 
     * @param nombre Nombre de la ventana a adicionar, hace las veces de ID en el mapa ventanas.
     * @param ventana Nodo grafico resultado del FXMLLoader.
     */
    public void addVentana(String nombre, Node ventana) {
        ventanas.put(nombre, ventana);
    }
    /**
     * 
     * @param nombre Nombre de la ventana.
     * @return El nodo grafico correspondiente al nombre recibido o null si no esta en el mapa.
     */
    public Node getVentana(String nombre) {
        return ventanas.get(nombre);
    }
    /**
     * 
     * @param nombre Nombre de la ventana a adicionar, hace las veces de ID en el mapa ventanas.
     * @param recursoFXML Nombre del archivo FXML correspondiente a la ventana.
     * @return 
     */
    public boolean cargarVentana(EVentanas ventana) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(ventana.getFxmlVentana()));
            loader.setControllerFactory(PacApplication.applicationContext::getBean);	
            Parent loadScreen = (Parent) loader.load();
            IControladorVentana iControladorVentana = ((IControladorVentana) loader.getController());
            iControladorVentana.setAdminVentana(this);
            addVentana(ventana.getIdVentana(), loadScreen);
            return true;
        } catch (IOException e) {
            DialogBuilder.create().title("Error cargando ventana").
                    headerText("Ventana: "+ventana.getFxmlVentana()).
                    alert(Alert.AlertType.ERROR).exception(e).build().showAndWait();
            return false;
        }
    }
    /**
     * 
     * @param idVentana Nombre de la ventana a cargar.
     */
    public void setVentana(final String idVentana) {
        
        if (ventanas.get(idVentana) != null) {
            final DoubleProperty opacity = opacityProperty();

            if (!getChildren().isEmpty()) {
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(1000), (ActionEvent action) -> {
                            getChildren().remove(0);
                            getChildren().add(0, ventanas.get(idVentana));
                            Timeline fadeIn = new Timeline(
                                    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                    new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));
                            fadeIn.play();
                }, new KeyValue(opacity, 0.0)));
                fade.play();

            } else {
                setOpacity(0.0);
                getChildren().add(ventanas.get(idVentana));
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(2500), new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
            resizeVentana(idVentana);
        } else {
            //TODO DialogBuilder
            System.out.println("AdminitradorVentanas.setVentana() �Ventana "+idVentana+" No se pudo cargar!");
        }
    }
    /**
     * 
     * @param stage Ventana a modificar altura y anchura.
     * @param tipo Identificador de la ventana a modificar.
     */
    private void resizeVentana(String tipo){
        if (stage != null){
            switch (tipo) {
                case "Menu":
                    if(PacApplication.IS_CACULADO) {
                        stage.setMinHeight(PacApplication.HEIGHT);
                        stage.setMinWidth(PacApplication.WIDTH);
                    }
                    else {
                        PacApplication.HEIGHT = stage.getHeight();
                        PacApplication.WIDTH = stage.getWidth();
                        PacApplication.IS_CACULADO = true;
                    }
                break;

                case "Configuracion":
                    stage.setMinHeight(365);
                    stage.setMaxHeight(370);
                    stage.setMinWidth(585);
                    stage.setMaxWidth(590);
                break;

            }
        }
    }
    /**
     * 
     * @return Mapa con las ventanas resgistradas.
     */
    public HashMap<String, Node> getVentanas(){
        return this.ventanas;
    }
    
    public Stage getStage(){
        return this.stage;
    }
    
}//Fin clase AdministradorVentanas.java
