import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Informes {
    private static final double IVA_RATE = 0.12; // IVA del 12%

    /**
     * Lee los productos desde un archivo CSV.
     * @param rutaArchivo Ruta del archivo CSV.
     * @return Lista de productos leída del archivo.
     */
    public static List<Producto> leerProductosDesdeCSV(String rutaArchivo) {
        List<Producto> productos = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            br.readLine(); // Salta la cabecera
            
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String codigo = datos[0];
                String nombre = datos[1];
                float precio = Float.parseFloat(datos[2]);
                int cantidad = Integer.parseInt(datos[3]);
                String categoria = datos[4];
                
                Producto producto = new Producto(codigo, nombre, precio, cantidad, categoria);
                productos.add(producto);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        
        return productos;
    }

    /**
     * Calcula las ganancias totales de los productos.
     * @param productos Lista de productos.
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
     * @param productos Lista de productos.
     * @return El IVA total de las ganancias.
     */
    public static double calcularIVATotal(List<Producto> productos) {
        double gananciasTotales = calcularGananciasTotales(productos);
        return gananciasTotales * IVA_RATE;
    }
}
