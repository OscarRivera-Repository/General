package transfor;

public class ValidadorArgumentos {
    public static Boolean EsNombreValido(String nombre){
        // Se convierte todo a minúscula por facilidad
        nombre = nombre.toLowerCase();
        
        // El archivo es de extensión .transfor
        if(!nombre.endsWith(".transfor")){ return false; }
        
        // Se elimina la extensión para validar el nombre
        nombre = nombre.replace(".transfor", "");
        
        /* 
           Se valida que el nombre no sea nulo, 
           ni mayor a 30 letras y que empice con letra 
        */
        if(nombre == null){ return false; }
        if(nombre.length() == 0){ return false; }
        if(nombre.length() > 30){ return false; }
        if(Character.isLetter(nombre.charAt(0)) == false){ return false; }
        
        // Se valida que no tenga caracteres especiales 
        // Solo se aceptan letras, números y guión bajo
        // fuente: https://www.tutorialspoint.com/check-if-the-string-contains-only-unicode-letters-in-java
        for(int i = 0; i < nombre.length(); i++){
            if(!Character.isLetter(nombre.charAt(i)) &&
               !Character.isDigit(nombre.charAt(i)) &&
               nombre.charAt(i) != '_' ){ 
                return false; 
            }
        }
        
        // Si ninguna validación falló, se retorna true
        return true;
    }
}
