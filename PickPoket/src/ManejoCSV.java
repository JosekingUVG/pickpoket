import java.io.*;
import java.util.ArrayList;

/**
 * Clase que permite manejar la lectura y escritura de archivos CSV.
 */
public class ManejoCSV {

    /**
     * Verifica si el archivo existe en la ruta especificada.
     *
     * @param rutaArchivo La ruta del archivo a verificar o crear.
     */
    private void verificarOCrearArchivo(String rutaArchivo) {
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
        String rutaArchivo = "productos.csv";
        verificarOCrearArchivo(rutaArchivo);

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
        verificarOCrearArchivo(rutaArchivo);

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

    private boolean verificarArchivoExiste(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        return archivo.exists();
    }
}