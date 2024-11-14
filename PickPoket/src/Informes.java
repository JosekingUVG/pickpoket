import java.util.List;

public class Informes {
    private static final double IVA_RATE = 0.16; // IVA del 16%

    /**
     * Calcula las ganancias totales de los productos en el inventario.
     * @param productos Lista de productos del inventario.
     * @return Las ganancias totales.
     */
    public static double calcularGananciasTotales(List<Producto> productos) {
        double gananciasTotales = 0;
        for (Producto producto : productos) {
            gananciasTotales += producto.getPrecio() * producto.getCantidad();
        }
        return gananciasTotales;
    }

    /**
     * Calcula el IVA total basado en las ganancias totales.
     * @param productos Lista de productos del inventario.
     * @return El IVA total de las ganancias.
     */
    public static double calcularIVATotal(List<Producto> productos) {
        double gananciasTotales = calcularGananciasTotales(productos);
        return gananciasTotales * IVA_RATE;
    }
}
