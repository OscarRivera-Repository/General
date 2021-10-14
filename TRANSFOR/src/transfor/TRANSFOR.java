package transfor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.lang.Runtime;
import java.util.Scanner;

public class TRANSFOR {

    public static void main(String[] args) throws InterruptedException, IOException {
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
        
        // Se ejecuta el analizador léxico
        ArrayList<String> resultado;
        resultado = AnalizadorLexico.Analizar(lineas);
        
        // Se escribe el archivo con resultado y los errores
        String archivoErrores;
        archivoErrores = nombreArchivo.replace(".transfor", "");
        archivoErrores = archivoErrores + "-errores.txt";
        ManejadorArchivos.EscribirResultado(resultado, archivoErrores);
        
        // Si se detectan errores no se continúa
        if(lineas.size() != resultado.size()){
            System.out.println("Se detectaron errores");
            return;
        }
               
        // Se crea el archivo f90
        String archivof90;
        archivof90 = nombreArchivo.replace(".transfor", ".f90");
        ManejadorArchivos.EscribirResultado(lineas, archivof90);
        
        // Se invoca al compilador Fortran
        Process compilador = new ProcessBuilder("GFORTRAN",archivof90,"-o",archivof90.replace(".f90","")).start();
        while(!compilador.isAlive()){Thread.sleep(1000);}
        compilador.waitFor();
        System.out.println("Programa compilado");
        
        // Se invoca al programa
        String archivoBat = nombreArchivo.replace(".transfor", ".bat");
        ManejadorArchivos.EscribirBat(archivoBat);
        Process ejecutar = new ProcessBuilder("cmd", "/c", "start", archivoBat)
                .directory(new File(System.getProperty("user.dir")))
                .start();
        
        
    }
    
    private static void Ejecutar(String archivof90) throws IOException, InterruptedException{
    
        //Runtime.getRuntime().exec(new String[] {archivof90.replace(".f90","") + ".exe"});
         //Process p = Runtime.getRuntime().exec(new String[] {archivof90.replace(".f90","") + ".exe"});
        
         try {
                Runtime rt = Runtime.getRuntime();
                Process pr = rt.exec(archivof90.replace(".f90","") + ".exe");
 
                BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
                OutputStream stdin = pr.getOutputStream ();
                String line=null;
 
                while((line=input.readLine()) != null) {
                    System.out.println(line);
                }
                
                int exitVal = pr.waitFor();
                System.out.println("Exited with error code "+exitVal);
 
            } catch(Exception e) {
                System.out.println(e.toString());
                e.printStackTrace();
            }
        
        
        //Process ejecutar = new ProcessBuilder(archivof90.replace(".f90","") + ".exe").start();
        //BufferedReader in = new BufferedReader(new InputStreamReader(ejecutar.getInputStream()));
        //String line;
        //while ((line = in.readLine()) != null) {
        //    System.out.println("iterando");
        //    System.out.println(line);
        //}
        //in.close();
        //int exitVal = ejecutar.waitFor();
        //System.out.println("ok!");

        

    }
    
}
