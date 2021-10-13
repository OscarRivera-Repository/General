package transfor;

public class Validaciones {
    /*
        Algunas validaciones ignoran los espacios vacios,
        esta función los elimina para que no interfieran    
    */
    public static String QuitarEspacios(String linea){
        String nuevaLinea = "";
        for(int i = 0; i < linea.length(); i++){
            if(linea.charAt(i) != ' ' ){ 
                nuevaLinea += linea.charAt(i); 
            }
        }
        return nuevaLinea;
    }
    
    public static String Solo80Caracteres(String linea){
        if(linea.length() > 80){
            return "Error 001: Línea mayor a 80 caracteres";
        }
        return "";
    }
    
    /*
        Se vaidan etiquetas
        Se asume que uso de & se validó primero
    */
    public static String EtiquetasCorrectas(String linea){
        String error = "Error 002: Etiqueta inválida";
        // La etiqueta es de tamaño 5 seguida de un espacio
        if (linea.length() < 6){return error;}
        String inicio = linea.substring(0, 5);
        // La equeta debe ser un numero y ocupar 5 caracteres
        try {
            double d = Integer.parseInt(inicio);
        } catch (NumberFormatException nfe) {
            // Si los primeros 5 caracteres no son número es un  error
            return error;
        }
        // Depués del número debe haber espacio o es un error
        char posicion6 = linea.charAt(5);
        
        if(posicion6 != ' '){return error;}

        return "";
    }
   
    /*
        Valida que columas 73-80 estén vacías
        Se asume que largo de línea se validó primero
        Se asume que uso de & se validó primero        
    */
    public static String FinLineaValido(String linea){
        String error = "Error 003: Fin de linea debe ir vacío";
        // Si hay menos de 73 caracteres se omite validación
        if (linea.length() < 72){return "";}
        // Se validan el resto de posiciones
        for(int i = 72; i < linea.length(); i++){
            if(linea.charAt(i) != ' '){return error;}
        }
        return "";
    }
    
    public static String UsoProgramCorrecto(String linea){
        return "";
    }
}
