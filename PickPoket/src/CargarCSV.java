import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que permite cargar información de productos y ventas desde archivos CSV.
 */
public class CargarCSV {

    /**
     * Verifica si el archivo existe en la ruta especificada.
     *
     * @param rutaArchivo La ruta del archivo a verificar.
     * @return true si el archivo existe, false en caso contrario.
     */
    private boolean verificarArchivoExiste(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        return archivo.exists();
    }

    /**
     * Carga los productos desde un archivo CSV y los agrega al inventario.
     *
     * @return El inventario cargado con los productos desde el archivo CSV.
     */
    public Inventario cargarProductos() {
        String rutaArchivo = "data/productos.csv";
        Inventario inventario = new Inventario();

        if (verificarArchivoExiste(rutaArchivo)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] campos = line.split(",");
                    String codigo = campos[0];
                    String nombre = campos[1];
                    float precio = Float.parseFloat(campos[2]);
                    int cantidad = Integer.parseInt(campos[3]);
                    String categoria = campos[4];

                    Producto producto = new Producto(codigo, nombre, precio, cantidad, categoria);
                    inventario.AgregarProducto(producto);
                }
                System.out.println("Productos cargados exitosamente desde " + rutaArchivo);
            } catch (IOException e) {
                System.out.println("Error al cargar los productos desde CSV: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo " + rutaArchivo + " no existe.");
        }
        return inventario;
    }

    /**
     * Carga las ventas desde un archivo CSV y las agrega a la lista de ventas.
     * Los productos asociados a cada venta también se cargan desde el mismo archivo.
     *
     * @param inventario El inventario de productos necesarios para asociar a las ventas.
     * @return La lista de ventas cargada desde el archivo CSV.
     */
    public ArrayList<Venta> cargarVentas(Inventario inventario) {
        String rutaArchivo = "ventas.csv";
        ArrayList<Venta> ventas = new ArrayList<>();

        if (verificarArchivoExiste(rutaArchivo)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
                String line;
                Venta venta = null;
                while ((line = reader.readLine()) != null) {
                    String[] campos = line.split(",");
                    if (campos[0].equals("Producto:")) {
                        String codigo = campos[1];
                        String nombre = campos[2];
                        float precio = Float.parseFloat(campos[3]);
                        int cantidad = Integer.parseInt(campos[4]);
                        String categoria = campos[5];

                        Producto producto = new Producto(codigo, nombre, precio, cantidad, categoria);

                        if (venta != null) {
                            venta.AgregarProducto(producto);
                        }
                    } else {
                        String codigoVenta = campos[0];
                        double total = Double.parseDouble(campos[1]);
                        String fecha = campos[2];

                        venta = new Venta(codigoVenta, new ArrayList<>(), total, fecha);
                        ventas.add(venta);
                    }
                }
                System.out.println("Ventas cargadas exitosamente desde " + rutaArchivo);
            } catch (IOException e) {
                System.out.println("Error al cargar las ventas desde CSV: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo " + rutaArchivo + " no existe.");
        }
        return ventas;
    }
}