package es.jacampano.curso;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class OperacionesAritmeticasTest {

    @Test
    public void suma() {
        Assert.assertEquals(OperacionesAritmeticas.suma(2,2), 4);
    }

    @Test
    public void resta() {
        Assert.assertEquals(OperacionesAritmeticas.resta(5,2), 3);
    }

    @Test
    public void multiplicacion() {
        Assert.assertEquals(OperacionesAritmeticas.multipicacion(3,3), 9);
    }

    //Bloque no conformidades de test unitarios
    /*
    @Test
    public void sumaFail() {
        Assert.assertEquals(OperacionesAritmeticas.suma(2,2), 7);
    }

    @Test
    public void restaFail() {
        Assert.assertEquals(OperacionesAritmeticas.resta(5,2), 7);
    }

    @Test
    public void multiplicacionFail() {
        Assert.assertEquals(OperacionesAritmeticas.multipicacion(3,3), 7);
    }
*/

}
