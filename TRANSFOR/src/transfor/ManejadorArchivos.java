package transfor;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManejadorArchivos {
    /* 
        Carga el archivo en un array de líneas para que sea mas facil 
        de procesar y enviar como argumento entre funciones
    */
    public static ArrayList<String> CargarArchivo(String nombre) throws FileNotFoundException{
        ArrayList<String> lineas = new ArrayList<>();
        
        Scanner lector = new Scanner(new File(nombre));
        lector.useDelimiter("\r\n");
        while(lector.hasNext()){
            lineas.add(lector.next());
        }
        return lineas;
    }
    
    public static void EscribirResultado(ArrayList<String> resultado, 
                                         String nombreArchivo)
    {
        String nuevoNombre;
        nuevoNombre = nombreArchivo.replace(".transfor", "");
        nuevoNombre = nuevoNombre + "-errores.txt";
        
        // Se crea el archivo
        try {
            File archivo = new File(nuevoNombre);
            if(archivo.exists()){ 
                archivo.delete(); 
            }
            archivo.createNewFile();
        } 
        catch (IOException e) {
            System.out.println("Excepción al crear archivo:");
        }
        
        // Se escribe en el archivo
        try{
            FileWriter escritor;
            escritor = new FileWriter(nuevoNombre);
            
            for(int i = 0; i < resultado.size(); i++){
                escritor.write(resultado.get(i) + "\r\n");
            }
            
            escritor.close();
        } 
        catch (IOException e) {
            System.out.println("Excepción al escribir archivo:");
        }
    }
}
