package transfor;

import java.util.ArrayList;

/* 
    - Analiza un ArrayList con líneas de código.
    - Retorna un Array List con el resultado del análisis.
    - Los mensajes de error se agregan en la línea siguiente 
      a la que contiene el error.
    - Si la cantidad de líneas del resultado es diferente a las
      del archivo original significa que hay errores.
*/
public class AnalizadorLexico {
    
    // Analiza las líneas y devuelve el aaray con el resultado
    public static ArrayList<String> Analizar(ArrayList<String> lineas){
        ArrayList<String> resultado = new ArrayList<>();
        
        for(int i = 0; i < lineas.size(); i++){
            resultado.addAll(AnalizarLinea(lineas.get(i), i));
        }        
        return resultado;
    }
    
    // Analiza una línea y devuelve un array con la linea y sus errores
    private static ArrayList<String> AnalizarLinea(String linea, int pos){
        ArrayList<String> resultado = new ArrayList<>();
        // La línea original siempre se incluye
        resultado.add(Enumerar(pos) + " " + linea);
        // Se eliminan primero los comentarios porque se deben ignorar
        String lineaSinComentarios = EliminarComentarios(linea);
        
        return resultado;
    }
    
    // Devuelve un string con el número de línea
    // El número tiene ceros adelante y siempre es de tamaño 5
    private static String Enumerar(int i){
        String numero = Integer.toString(i + 1);
        
        while(numero.length() < 5){
            numero = "0" + numero;
        }
        
        return numero;
    }
    
    // Elimina los comentarios en una línea, se reemplazan por espcaios vacios
    private static String EliminarComentarios(String linea){
        String nuevaLinea = "";
        int len = linea.length();
        
        if(len == 0){return nuevaLinea;}
        
        int i = 0;
        char letraActual;
        boolean esComentario = false;

        while(i<len ){
            letraActual = linea.charAt(i);
            if(letraActual == '!'){
                esComentario = true;
            }
            if(esComentario){
                nuevaLinea += " ";
            }else{
                nuevaLinea += letraActual;
            }
            i++;
        }
        
        return nuevaLinea;
    }
}
