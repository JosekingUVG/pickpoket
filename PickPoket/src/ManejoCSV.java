import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Clase que permite manejar la lectura y escritura de archivos CSV.
 */
public class ManejoCSV {
    private static final String RUTA_ARCHIVO = "data/productos.csv";

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
    
    
    

    public void aplicarDescuentoTemporal(String nombreProducto, double precioDescuento, LocalDate fechaFin) {
        try (FileWriter writer = new FileWriter("data/descuentos_temporales.csv", true)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            writer.write(nombreProducto + "," + precioDescuento + "," + fechaFin.format(formatter) + "\n");
            JOptionPane.showMessageDialog(null, "Descuento aplicado temporalmente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al aplicar el descuento: " + e.getMessage());
        }
    }
    
    public void verificarDescuentosExpirados() {
    	String linea;
        List<String> lineasActualizadas = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate hoy = LocalDate.now();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("data/descuentos_temporales.csv"))) {
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombreProducto = datos[0];
                double precioDescuento = Double.parseDouble(datos[1]);
                LocalDate fechaFin = LocalDate.parse(datos[2], formatter);

                if (fechaFin.isBefore(hoy)) {
                    // Restablece el precio original en tu archivo principal
                    restaurarPrecioOriginal(nombreProducto);
                } else {
                    lineasActualizadas.add(linea);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar descuentos: " + e.getMessage());
        }
        
        // Sobreescribe el archivo con los descuentos no expirados
        try (FileWriter writer = new FileWriter("data/descuentos_temporales.csv", false)) {
            for (String line : lineasActualizadas) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar descuentos temporales: " + e.getMessage());
        }
        

    }
        
        public void restaurarPrecioOriginal(String nombreProducto) {
            // Implementa la lógica para leer el archivo principal de productos e 
            // identificar el precio original del producto y restablecerlo.
            // Luego guarda los cambios en el archivo de inventario.
        }

}