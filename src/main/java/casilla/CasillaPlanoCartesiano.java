package casilla;

/**
 * Clase que representa una Casilla en el plano cartesiano
 */
public class CasillaPlanoCartesiano implements  Casilla{

    private final int coordenadaX;
    private final int coordenadaY;
    private final Direccion direccion;

    public CasillaPlanoCartesiano(int coordenadaX, int coordenadaY, Direccion direccion) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.direccion = direccion;
    }

    private Casilla moverEnY(int pasos){
        return new CasillaPlanoCartesiano(coordenadaX, coordenadaY + pasos, direccion);
    }

    private Casilla moverEnX(int pasos){
        return new CasillaPlanoCartesiano(coordenadaX + pasos, coordenadaY, direccion);
    }

    @Override
    public Casilla avanzar(int pasos){
        if(direccion == Direccion.NORTE){
            return moverEnY(pasos);
        }else if(direccion == Direccion.SUR){
            return moverEnY(-pasos);
        }else if(direccion == Direccion.ESTE){
            return moverEnX(pasos);
        }else{
            return moverEnX(-pasos);
        }
    }

    @Override
    public Casilla girarIzquierda(){
        if(direccion == Direccion.NORTE){
            return  new CasillaPlanoCartesiano(coordenadaX, coordenadaY, Direccion.OESTE);
        }else if(direccion == Direccion.OESTE){
            return new CasillaPlanoCartesiano(coordenadaX, coordenadaY, Direccion.SUR);
        }else if(direccion == Direccion.SUR){
            return new CasillaPlanoCartesiano(coordenadaX, coordenadaY, Direccion.ESTE);
        }else{
            return new CasillaPlanoCartesiano(coordenadaX, coordenadaY, Direccion.NORTE);
        }
    }

    @Override
    public Casilla girarDerecha(){
        if(direccion == Direccion.NORTE){
            return new CasillaPlanoCartesiano(coordenadaX, coordenadaY, Direccion.ESTE);
        }else if(direccion == Direccion.ESTE){
            return new CasillaPlanoCartesiano(coordenadaX, coordenadaY, Direccion.SUR);
        }else if(direccion == Direccion.SUR){
            return  new CasillaPlanoCartesiano(coordenadaX, coordenadaY, Direccion.OESTE);
        }else{
            return new CasillaPlanoCartesiano(coordenadaX, coordenadaY, Direccion.NORTE);
        }
    }

    @Override
    public String toString(){
        return "(" + coordenadaX + "," + coordenadaY + ") " + direccion.getDescripcion();
    }
}
