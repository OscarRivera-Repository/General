package transfor;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TRANSFOR {

    public static void main(String[] args) {
        // Solo se permite recibir un argumento
        if(args.length != 1){
            Help.MostrarAyuda();
            return;
        }
        
        String nombreArchivo = args[0];
        
        // Se valida el nombre del archivo
        if(!ValidadorArgumentos.EsNombreValido(nombreArchivo)){
            Help.MostrarFormatoDeNombreArchivo();
            return;
        }
        
        // Se procede a leer el archivo
        ArrayList<String> lineas;
        try{
            lineas = ManejadorArchivos.CargarArchivo(nombreArchivo);
        }
        catch(FileNotFoundException ex){
            System.out.println("Error:");
            System.out.println("No se pudo leer el archivo o este no existe");
            return;
        }
        
        ArrayList<String> resultado;
        resultado = AnalizadorLexico.Analizar(lineas);
        
        if(lineas.size() != resultado.size()){
            System.out.println("Se detectaron errores");
        }
        
        // Se escribe el archivo con resultado y los errores
        ManejadorArchivos.EscribirResultado(resultado, nombreArchivo);
        
        // Se invoca al compilador Fortran
    }
    
}
