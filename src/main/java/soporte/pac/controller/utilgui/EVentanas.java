package soporte.pac.controller.utilgui;

/**
*
* @author Jaider Adriam Serrano Sep�lveda.
*/
public enum EVentanas {
   LOGIN("Login", "/fxml/Login.fxml"),
   PRINCIPAL("Menu", "/fxml/Menu.fxml"),
   CONFIGURACION("Configuracion", "/fxml/Configuracion.fxml");
   
   private final String idVentana;
   private final String fxmlVentana;

   /**
    * @param idVentana Nombre (�nico) con el cual se identifica una ventana.
    * @param fxmlVentana Nombre del archivo FXML el cual contiene la estructura de la ventana.
    */
   private EVentanas(final String idVentana, final String fxmlVentana) {
       this.idVentana = idVentana;
       this.fxmlVentana = fxmlVentana;
   }

   public String getIdVentana() {
       return idVentana;
   }   

   public String getFxmlVentana() {
       return fxmlVentana;
   } 
}