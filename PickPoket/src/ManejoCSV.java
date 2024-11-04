import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Clase que permite manejar la lectura y escritura de archivos CSV.
 */
public class ManejoCSV {
    private static final String RUTA_ARCHIVO = "data/productos.csv";
    
    private static final String RUTA_DESCUENTOS = "data/descuentos.csv";

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
        String rutaArchivo = "data/productos.csv";
        verificarOCrearArchivo(rutaArchivo);

        try (FileWriter writer = new FileWriter(rutaArchivo, true)) {
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
        File currentDirFile = new File(".");
        String helper = currentDirFile.getAbsolutePath();
        System.out.println(helper);
        String rutaArchivo = helper.substring(0,helper.length()-2)+"\\pickpoket\\PickPoket\\data\\productos.csv";
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




    public void eliminarProductoPorNombre(String nombreProducto) throws IOException {
        List<Producto> productos = obtenerProductos(); // Cargar todos los productos en un ArrayList
    
        // Recorrer el ArrayList y eliminar el producto con el nombre especificado
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equals(nombreProducto)) {
                productos.remove(i); // Eliminar el producto
                break; // Terminar el ciclo una vez encontrado y eliminado
            }
        }
    
        // Sobrescribir el archivo CSV con la lista actualizada de productos
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/productos.csv"))) {
            for (Producto producto : productos) {
                bw.write(producto.getCodigo() + "," +
                         producto.getNombre() + "," +
                         producto.getPrecio() + "," +
                         producto.getCantidad() + "," +
                         producto.getCategoria());
                bw.newLine();
            }
        }
    
        System.out.println("Producto eliminado exitosamente de productos.csv");
    }

    public List<Producto> obtenerProductos() throws IOException {
        List<Producto> productos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("data/productos.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                Producto producto = new Producto();
                producto.setCodigo(datos[0]);
                producto.setNombre(datos[1]);
                producto.setPrecio(Float.parseFloat(datos[2]));
                producto.setCantidad(Integer.parseInt(datos[3]));
                producto.setCategoria(datos[4]);
                productos.add(producto);
            }
        }
        return productos;
    }

     /**
     * Modifica un producto existente en el archivo CSV.
     *
     * @param nombreProducto El nombre del producto a modificar.
     * @param nuevoCodigo El nuevo código del producto.
     * @param nuevoPrecio El nuevo precio del producto.
     * @param nuevaCantidad La nueva cantidad del producto.
     * @param nuevaCategoria La nueva categoría del producto.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public void modificarProducto(String nombreProducto, String nuevoCodigo, float nuevoPrecio, int nuevaCantidad, String nuevaCategoria) throws IOException {
        File archivoOriginal = new File(RUTA_ARCHIVO);
        File archivoTemporal = new File("temp.csv");

        BufferedReader reader = new BufferedReader(new FileReader(archivoOriginal));
        BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTemporal));

        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split(",");
            
            // Verificamos si el nombre coincide para modificar el producto
            if (datos[1].equals(nombreProducto)) {
                // Escribimos la nueva información del producto
                writer.write(nuevoCodigo + "," + nombreProducto + "," + nuevoPrecio + "," + nuevaCantidad + "," + nuevaCategoria + "\n");
            } else {
                // Escribimos la línea sin cambios
                writer.write(linea + "\n");
            }
        }
        writer.close();
        reader.close();

        // Reemplazar el archivo original con el archivo temporal
        archivoOriginal.delete();
        archivoTemporal.renameTo(archivoOriginal);

        System.out.println("Producto modificado exitosamente en el archivo CSV.");
    }
    
     /**
     * Aplica un descuento a un producto específico por nombre y guarda el detalle en descuentos.csv.
     *
     * @param nombreProducto Nombre del producto a aplicar el descuento.
     * @param descuento      Porcentaje de descuento.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public void aplicarDescuentoPorNombre(String nombreProducto, float descuento) throws IOException {
        List<Producto> productos = obtenerProductos();
        try (BufferedWriter bwDescuentos = new BufferedWriter(new FileWriter(RUTA_DESCUENTOS, true))) {
            for (Producto producto : productos) {
                if (producto.getNombre().equals(nombreProducto)) {
                    float precioOriginal = producto.getPrecio();
                    float precioConDescuento = precioOriginal * (1 - descuento / 100);
                    producto.setPrecio(precioConDescuento);

                    // Guardar detalles en descuentos.csv
                    bwDescuentos.write(producto.getNombre() + "," + descuento + "," + precioConDescuento + "," + precioOriginal);
                    bwDescuentos.newLine();
                    break;
                }
            }
        }

        // Guardar productos actualizados en productos.csv
        guardarProductos(productos);
        System.out.println("Descuento aplicado al producto con nombre " + nombreProducto + " en productos.csv");
    }

    /**
     * Aplica un descuento a todos los productos de una categoría y guarda los detalles en descuentos.csv.
     *
     * @param categoria Categoría de productos a aplicar el descuento.
     * @param descuento Porcentaje de descuento.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public void aplicarDescuentoPorCategoria(String categoria, float descuento) throws IOException {
        List<Producto> productos = obtenerProductos();
        try (BufferedWriter bwDescuentos = new BufferedWriter(new FileWriter(RUTA_DESCUENTOS, true))) {
            for (Producto producto : productos) {
                if (producto.getCategoria().equals(categoria)) {
                    float precioOriginal = producto.getPrecio();
                    float precioConDescuento = precioOriginal * (1 - descuento / 100);
                    producto.setPrecio(precioConDescuento);

                    // Guardar detalles en descuentos.csv
                    bwDescuentos.write(producto.getNombre() + "," + descuento + "," + precioConDescuento + "," + precioOriginal);
                    bwDescuentos.newLine();
                }
            }
        }

        // Guardar productos actualizados en productos.csv
        guardarProductos(productos);
        System.out.println("Descuento aplicado a todos los productos de la categoría " + categoria + " en productos.csv");
    }

    /**
     * Restaura el precio original de un producto en productos.csv y elimina la entrada correspondiente en descuentos.csv.
     *
     * @param nombreProducto Nombre del producto a restaurar.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public void restaurarPrecioOriginal(String nombreProducto) throws IOException {
        List<Producto> productos = obtenerProductos();
        List<String> lineasDescuentos = new ArrayList<>();

        // Leer descuentos.csv y buscar el precio original del producto
        float precioOriginal = -1;
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_DESCUENTOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[0].equals(nombreProducto)) {
                    precioOriginal = Float.parseFloat(datos[3]);
                } else {
                    lineasDescuentos.add(linea);
                }
            }
        }

        if (precioOriginal != -1) {
            // Restaurar el precio en productos.csv
            for (Producto producto : productos) {
                if (producto.getNombre().equals(nombreProducto)) {
                    producto.setPrecio(precioOriginal);
                    break;
                }
            }
            guardarProductos(productos);

            // Escribir el archivo descuentos.csv sin la línea del producto restaurado
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_DESCUENTOS))) {
                for (String linea : lineasDescuentos) {
                    bw.write(linea);
                    bw.newLine();
                }
            }
            System.out.println("Precio original restaurado para el producto " + nombreProducto);
        } else {
            System.out.println("Producto no encontrado en descuentos.csv");
        }
    }

    /**
     * Guarda la lista de productos en el archivo productos.csv.
     *
     * @param productos Lista de productos a guardar.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    private void guardarProductos(List<Producto> productos) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_ARCHIVO))) {
            for (Producto producto : productos) {
                bw.write(producto.getCodigo() + "," +
                         producto.getNombre() + "," +
                         producto.getPrecio() + "," +
                         producto.getCantidad() + "," +
                         producto.getCategoria());
                bw.newLine();
            }
        }
    }

}