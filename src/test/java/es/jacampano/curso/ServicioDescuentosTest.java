package es.jacampano.curso;

import org.junit.Assert;
import org.junit.Test;

public class ServicioDescuentosTest {

    @Test
    public void calculaDescuentoLibros() {
        ServicioDescuentos servicio = new ServicioDescuentos();
        Producto producto = new Producto("L1", "Libro Java", 50.0, "LIBROS");
        Assert.assertEquals(2.0, servicio.descuentoPorCategoria(producto), 0.001);
    }

    @Test
    public void reconoceCuponActivo() {
        ServicioDescuentos servicio = new ServicioDescuentos();
        Assert.assertTrue(servicio.cuponActivo("VIP"));
    }
}
