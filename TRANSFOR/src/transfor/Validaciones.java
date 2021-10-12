package transfor;

public class Validaciones {
    public static String Solo80Caracteres(String linea){
        if(linea.length() > 80){
            return "Error 001: Línea mayor a 80 caracteres";
        }
        return "";
    }
    
    public static String EtiquetasCorrectas(String linea){
        String error = "Error 002: Etiqueta inválida";
        if (linea.length() < 5){return error;}
        String inicio = linea.substring(0, 4);
        try {
            double d = Integer.parseInt(inicio);
        } catch (NumberFormatException nfe) {
            return error;
        }
        return "";
    }
   
    public static String FinLineaValido(String linea){
        return "";
    }
    
    public static String UsoProgramCorrecto(String linea){
        return "";
    }
}
