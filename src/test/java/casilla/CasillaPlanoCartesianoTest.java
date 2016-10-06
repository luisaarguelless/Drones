package casilla;

import org.junit.Test;

import static org.junit.Assert.*;


public class CasillaPlanoCartesianoTest {

    private Integer X_INICIAL = 0;
    private Integer Y_INICIAL = 0;
    private Integer VELOCIDAD_AVANCE = 1;

    
    @Test
    public void avanzarDireccionNorte() throws Exception {

        Casilla casillaInicial = new CasillaPlanoCartesiano(X_INICIAL,Y_INICIAL,Direccion.NORTE);
        Casilla casilaaEsperada = new CasillaPlanoCartesiano(0,1,Direccion.NORTE);
        assertEquals(casilaaEsperada.toString(), casillaInicial.avanzar(VELOCIDAD_AVANCE).toString());
    }

    @Test
    public void avanzarDireccionSur(){

    }

    @Test
    public void girarIzquierda() throws Exception {

    }

    @Test
    public void girarDerecha() throws Exception {

    }



}