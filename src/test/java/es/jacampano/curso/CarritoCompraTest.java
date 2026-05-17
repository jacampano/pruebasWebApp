package es.jacampano.curso;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarritoCompraTest {
    private CarritoCompra carrito;

    @Before
    public void setUp() {
        carrito = new CarritoCompra();
    }

    @Test
    public void agregaProductoValido() {
        carrito.agregarProducto(new Producto("P1", "Teclado", 20.0, "TECNOLOGIA"), 2);
        Assert.assertEquals(1, carrito.getNumeroLineas());
    }

    @Test
    public void ignoraCantidadCero() {
        carrito.agregarProducto(new Producto("P1", "Teclado", 20.0, "TECNOLOGIA"), 0);
        Assert.assertEquals(0, carrito.getNumeroLineas());
    }

    @Test
    public void ignoraProductoNulo() {
        carrito.agregarProducto(null, 1);
        Assert.assertEquals(0, carrito.getNumeroLineas());
    }

    @Test
    public void calculaSubtotal() {
        carrito.agregarProducto(new Producto("P1", "Teclado", 20.0, "TECNOLOGIA"), 2);
        carrito.agregarProducto(new Producto("P2", "Libro", 10.0, "LIBROS"), 3);
        Assert.assertEquals(70.0, carrito.calcularSubtotal(), 0.001);
    }

    @Test
    public void aplicaDescuentoOro() {
        carrito.agregarProducto(new Producto("P1", "Monitor", 100.0, "TECNOLOGIA"), 1);
        Assert.assertEquals(85.0, carrito.calcularTotal("ORO", null), 0.001);
    }

    @Test
    public void aplicaCuponDto10() {
        carrito.agregarProducto(new Producto("P1", "Monitor", 100.0, "TECNOLOGIA"), 1);
        Assert.assertEquals(90.0, carrito.calcularTotal("NORMAL", "DTO10"), 0.001);
    }

    @Test
    public void totalNoPuedeSerNegativo() {
        carrito.agregarProducto(new Producto("P1", "Cable", 5.0, "TECNOLOGIA"), 1);
        Assert.assertEquals(0.0, carrito.calcularTotal("NORMAL", "DTO10"), 0.001);
    }

    @Test
    public void generaResumenConPrecios() {
        carrito.agregarProducto(new Producto("P1", "Teclado", 20.0, "TECNOLOGIA"), 1);
        String resumen = carrito.generarResumen("Ana", true, false);
        Assert.assertTrue(resumen.contains("Ana"));
        Assert.assertTrue(resumen.contains("Teclado - 20.0"));
    }

    @Test
    public void validaAdministradorCorrecto() {
        Assert.assertTrue(carrito.validarAdministrador("admin", "admin123"));
    }

    @Test
    public void rechazaAdministradorIncorrecto() {
        Assert.assertFalse(carrito.validarAdministrador("admin", "otro"));
    }

    @Test
    public void calculaImpuestoEspania() {
        carrito.agregarProducto(new Producto("P1", "Monitor", 100.0, "TECNOLOGIA"), 1);
        Assert.assertEquals(21.0, carrito.calcularImpuesto("ES"), 0.001);
    }

    @Test
    public void calculaPrecioClienteOro() {
        carrito.agregarProducto(new Producto("P1", "Monitor", 150.0, "TECNOLOGIA"), 1);
        Assert.assertEquals(135.0, carrito.calcularPrecioClienteOro(), 0.001);
    }
}
