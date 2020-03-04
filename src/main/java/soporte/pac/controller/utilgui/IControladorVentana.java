package soporte.pac.controller.utilgui;

import soporte.pac.controller.AdminitradorVentanas;

/**
 * Interfaz que permitira implementar el metodo setAdminVentana el cual permitira
 * navegar por diferentes ventanas en modo MODAL.
 *
 * @author Jaider Adriam Serrano Sepulveda
 */

public interface IControladorVentana {
    
	/**
     * 
     * @param adminVentana Objeto que se encarga de cargar la ventana 
     * utilizando FXML.
     */
    public void setAdminVentana(AdminitradorVentanas adminVentana);
    
}
