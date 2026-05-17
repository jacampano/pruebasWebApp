package es.jacampano.curso;

public class LineaCarrito {
    private Producto producto;
    private int cantidad;

    public LineaCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getImporte() {
        return producto.getPrecio() * cantidad;
    }
}
