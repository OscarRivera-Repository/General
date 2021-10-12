package transfor;

/*
Contiene mensajes de ayuda para usar el programa
*/
public class Help {
    // Muestra la ayuda general
    public static void MostrarAyuda(){
        System.out.println("Uso: java –jar TRANSFOR.jar [nombre-de-archivo]");
        System.out.println("");
        System.out.println("nombre-de-archivo");
        System.out.println("    Nombre del archivo a compilar");
    }
    
    // Muestra el formato correcto para el nombre de archivo
    public static void MostrarFormatoDeNombreArchivo(){
        System.out.println("El nombre no debe sobrepasar los 30 caracteres");
        System.out.println("Debe empezar con una letra");
        System.out.println("Puede tener letras números y guiones bajos");
        System.out.println("N puede tener otros caracteres especiales");
        System.out.println("No puede empezar o terminar con guín bajo");
    }
  
}
