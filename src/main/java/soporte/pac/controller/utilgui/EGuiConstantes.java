package soporte.pac.controller.utilgui;

public enum EGuiConstantes {
    //Numero de casos de prueba que ejecutara cada hilo.
    CANTIDAD_HILOS("CANTIDAD_HILOS"),
    //Numero de la corrida.
    NUM_CORRIDA("NUM_CORRIDA"),
    //Caracter especial el cual sirve como separador de la concatenacion de las llave primaria.
    SEPARADOR("SEPARADOR"),
    //Ruta de la carpeta de evidencias
    RUTA_EVIDENCIAS("RUTA_EVIDENCIAS"),    
    //Nombre del cliente.
    CLIENTE("CLIENTE"),
    //Nombre del proyecto en el cual se esta trabajando.
    PROYECTO("PROYECTO"),
    //Nombre del modulo a probar.
    MODULO("MODULO"),
    //Logo del cliente el cual se utilizara para los reportes que generar� el Robot.
    LOGO_CLIENTE("LOGO"),
    //Nombre del tester responsable de las pruebas.
    TESTER("TESTER"),
    //Cargo del colaborardor.
    CARGO("CARGO"), 
    //Nombre de archivo de configuracion de conexcion con la BD postgres del sistema.    
    RUTA_CONFIGBD("RUTA_BDS"),
    //Ubicacion de los iconos e imagenes del proyecto.
    CANCEL_48x48("/images/CANCEL_48x_48.png"),
    OK_32x32("/images/OK_32x32.png"),
    LOGO_DIALOG("/images/logo.png"),
    LOGO("/images/logoEPS.png");
    
    private final String value;
    
    private EGuiConstantes(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getMapValue(){
        if (value.equals("RUTA_BDS")){
            //return (DlgPrincipalController.varGlobales.get(value) == null) ? "dbConfiguration.inf" : DlgPrincipalController.varGlobales.get(value) + "dbConfiguration.inf";
        	return "hello XFXFX";
        }
        //return DlgPrincipalController.varGlobales.get(value);
        return "hello DlgPrincipalController KKKK";  }
}
