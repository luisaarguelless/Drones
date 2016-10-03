package casilla;

/**
 * Enum que representa las direcciones que puede tener una Casilla
 */
public enum Direccion {
    NORTE("Dirección Norte"),
    SUR("Dirección Sur"),
    ESTE("Dirección Este"),
    OESTE("Dirección Oeste");

    private final String descripcion;
    Direccion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }


}
