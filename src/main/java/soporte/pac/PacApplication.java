package soporte.pac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import soporte.pac.controller.AdminitradorVentanas;
import soporte.pac.controller.utilgui.EGuiConstantes;
import soporte.pac.controller.utilgui.EVentanas;

@SpringBootApplication
public class PacApplication extends Application {
    public static ConfigurableApplicationContext applicationContext;
    private static Stage stage;
    public static double HEIGHT = 0.0;
    public static double WIDTH = 0.0;
    public static boolean IS_CACULADO = false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        applicationContext = SpringApplication.run(PacApplication.class);
        AdminitradorVentanas adminVentanas = new AdminitradorVentanas(primaryStage);
        adminVentanas.cargarVentana(EVentanas.LOGIN);
        adminVentanas.setVentana(EVentanas.LOGIN.getIdVentana());

        Group root = new Group();
        root.getChildren().addAll(adminVentanas);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle(" Soporte EPS SURA");
        String rutaLogo =  getClass().getResource(EGuiConstantes.LOGO.getValue()).getFile();
        primaryStage.getIcons().add(new Image("file:"+rutaLogo));
        primaryStage.setResizable(false);
        stage = primaryStage; 
        primaryStage.show();
    }

    public static void cursorMano() {
        stage.getScene().setCursor(Cursor.HAND);
    }

    public static void cursorNormal() {
        stage.getScene().setCursor(Cursor.DEFAULT);
    }

}
