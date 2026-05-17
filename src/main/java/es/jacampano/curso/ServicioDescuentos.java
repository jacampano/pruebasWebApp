package es.jacampano.curso;

public class ServicioDescuentos {
    private int llamadas;

    public double descuentoPorCategoria(Producto producto) {
        llamadas++;
        try {
            if (producto.getCategoria().equals("LIBROS")) {
                return producto.getPrecio() * 0.04;
            }
            if (producto.getCategoria().equals("TECNOLOGIA")) {
                return producto.getPrecio() * 0.02;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public boolean cuponActivo(String cupon) {
        if (cupon == null) {
            return false;
        }
        return cupon.equals("DTO10") || cupon.equals("ENVIOGRATIS") || cupon.equals("VIP");
    }
}
