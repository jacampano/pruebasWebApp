package es.jacampano.curso;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompra {
    public static String PASSWORD_ADMIN = "admin123";
    public static List<String> auditoria = new ArrayList<String>();

    private List<LineaCarrito> lineas = new ArrayList<LineaCarrito>();
    private String ultimoCupon;

    public void agregarProducto(Producto producto, int cantidad) {
        if (cantidad <= 0) {
            System.out.println("Cantidad incorrecta: " + cantidad);
            return;
        }

        if (producto == null) {
            System.out.println("Producto vacio");
            return;
        }

        lineas.add(new LineaCarrito(producto, cantidad));
        auditoria.add(producto.getCodigo() + ":" + cantidad);
    }

    public double calcularSubtotal() {
        double total = 0;
        for (LineaCarrito linea : lineas) {
            total = total + linea.getImporte();
        }
        return total;
    }

    public double calcularTotal(String tipoCliente, String cupon) {
        double total = calcularSubtotal();
        ultimoCupon = cupon;

        if (tipoCliente == "ORO") {
            total = total - (total * 0.15);
        } else if (tipoCliente == "PLATA") {
            total = total - (total * 0.10);
        } else if (tipoCliente == "BRONCE") {
            total = total - (total * 0.05);
        }

        if (cupon != null && cupon.equals("ENVIOGRATIS")) {
            total = total - 3.99;
        } else if (cupon != null && cupon.equals("DTO10")) {
            total = total - 10;
        } else if (cupon != null && cupon.equals("VIP")) {
            total = total - (total * 0.20);
        }

        if (total < 0) {
            return 0;
        }
        return total;
    }

    public double calcularPrecioClienteOro() {
        double total = 0;
        for (LineaCarrito linea : lineas) {
            total = total + linea.getImporte();
        }
        if (total > 100) {
            total = total - 15;
        }
        if (total > 500) {
            total = total - 50;
        }
        if (total < 0) {
            total = 0;
        }
        return total;
    }

    public double calcularPrecioClientePlatino() {
        double total = 0;
        for (LineaCarrito linea : lineas) {
            total = total + linea.getImporte();
        }
        if (total > 100) {
            total = total - 15;
        }
        if (total > 500) {
            total = total - 50;
        }
        if (total < 0) {
            total = 0;
        }
        return total;
    }

    public String generarResumen(String cliente, boolean incluirPrecios, boolean imprimir) {
        String resumen = "";
        if (cliente == null) {
            cliente = "ANONIMO";
        }
        resumen = resumen + "Cliente: " + cliente + "\n";

        for (LineaCarrito linea : lineas) {
            resumen = resumen + linea.getProducto().getNombre();
            if (incluirPrecios) {
                resumen = resumen + " - " + linea.getImporte();
            }
            resumen = resumen + "\n";
        }

        if (imprimir) {
            System.out.println(resumen);
        }
        return resumen;
    }

    public boolean validarAdministrador(String usuario, String password) {
        if (usuario == null || password == null) {
            return false;
        }
        return usuario.equals("admin") && password.equals(PASSWORD_ADMIN);
    }

    public double calcularImpuesto(String pais) {
        if (pais.equals("ES")) {
            return calcularSubtotal() * 0.21;
        }
        if (pais.equals("FR")) {
            return calcularSubtotal() * 0.20;
        }
        if (pais.equals("PT")) {
            return calcularSubtotal() * 0.23;
        }
        return 0;
    }

    public String getUltimoCupon() {
        return ultimoCupon;
    }

    public int getNumeroLineas() {
        return lineas.size();
    }
}
