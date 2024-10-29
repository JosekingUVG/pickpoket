import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

/**
 * Clase que permite guardar información de productos y ventas en archivos CSV.
 */
public class GuardarCSV {
    Producto producto;
    //Constructor sin parametros{}
    public GuardarCSV() {
        producto = new Producto();
    }

    /**
     * Verifica si el archivo existe en la ruta especificada. Si no existe, lo crea.
     *
     * @param rutaArchivo La ruta del archivo a verificar o crear.
     */
    private void verificaroCrearArchivo(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
                System.out.println("El archivo " + rutaArchivo + " no existía. Ha sido creado.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    /**
     * Guarda los productos del inventario en un archivo CSV.
     *
     * @param inventario El inventario de productos a guardar.
     */
    public void guardarProductos(Inventario inventario) {
        String rutaArchivo = "data/productos.csv";
        verificaroCrearArchivo(rutaArchivo);

        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            for (Producto producto : inventario.VerInventario()) {
                writer.append(producto.getCodigo())
                        .append(',')
                        .append(producto.getNombre())
                        .append(',')
                        .append(String.valueOf(producto.getPrecio()))
                        .append(',')
                        .append(String.valueOf(producto.getCantidad()))
                        .append(',')
                        .append(producto.getCategoria())
                        .append('\n');
            }
            System.out.println("Productos guardados exitosamente en " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar los productos en CSV: " + e.getMessage());
        }
    }
    

    /**
     * Guarda una lista de ventas en un archivo CSV.
     *
     * @param ventas La lista de ventas a guardar.
     */
    public void guardarVentas(ArrayList<Venta> ventas) {
        String rutaArchivo = "ventas.csv";
        verificaroCrearArchivo(rutaArchivo);

        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            for (Venta venta : ventas) {
                writer.append(venta.getCodigoVenta())
                        .append(',')
                        .append(String.valueOf(venta.getTotal()))
                        .append(',')
                        .append(venta.getFecha())
                        .append('\n');

                for (Producto producto : venta.getListaProductos()) {
                    writer.append("Producto:")
                            .append(',')
                            .append(producto.getCodigo())
                            .append(',')
                            .append(producto.getNombre())
                            .append(',')
                            .append(String.valueOf(producto.getPrecio()))
                            .append(',')
                            .append(String.valueOf(producto.getCantidad()))
                            .append(',')
                            .append(producto.getCategoria())
                            .append('\n');
                }
            }
            System.out.println("Ventas guardadas exitosamente en " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar las ventas en CSV: " + e.getMessage());
        }
    }
}