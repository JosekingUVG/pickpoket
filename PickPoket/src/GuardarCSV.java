import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class GuardarCSV {

    private void verificaroCrearArchivo(String rutaArchivo){
        File archivo = new File(rutaArchivo);
        try{
            if(!archivo.exists()){
                archivo.createNewFile();
                System.out.println("El archivo " + rutaArchivo + " no existía. Ha sido creado.");
            }
        } catch (IOException e){
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }

    }

    public void guardarProductos(Inventario inventario) {
        String rutaArchivo = "productos.csv";
        verificaroCrearArchivo(rutaArchivo);

        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            for (Producto producto : inventario.VerInventario()) {
                writer.append(producto.getCodigo()).append(',').append(producto.getNombre()).append(',').append(String.valueOf(producto.getPrecio())).append(',')
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

    public void guardarVentas(ArrayList<Venta> ventas){
        String rutaArchivo = "ventas.csv";
        verificaroCrearArchivo(rutaArchivo);

        try(FileWriter writer = new FileWriter(rutaArchivo)){
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
        } catch (IOException e){   
            System.out.println("Error al guardar las ventas en CSV: " + e.getMessage());
        }
    }

    
}