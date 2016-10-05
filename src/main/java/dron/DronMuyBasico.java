package dron;

/**
 * Ejemplo de Dron basico
 */
public class DronMuyBasico implements Dron<String,String>{

    public void ejecutarInstrucciones(String instruccion){
        System.out.println("Instrucción ejecutada con exito: " + instruccion.toLowerCase());
    }

    public String darReporteEjecucion(){
        return "Soy un dron muy básico y no tengo nada que reportar " + this.getClass();
    }
}
