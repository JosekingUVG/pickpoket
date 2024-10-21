import java.util.ArrayList;

/**
 * Clase que representa el sistema de ventas de una tienda. 
 * Maneja el inventario y el registro de ventas.
 */
public class SistemaVentas {
    private Inventario inventario;
    private ArrayList<Venta> ventas;
    private ManejoCSV manejoCSV;

    /**
     * Constructor que inicializa el inventario y crea una lista vacía de ventas.
     * 
     * @param inventario el inventario de productos de la tienda
     */
    public SistemaVentas(Inventario inventario) {
        manejoCSV = new ManejoCSV();

         // Cargar el inventario y las ventas desde archivos CSV
         this.inventario = manejoCSV.cargarProductos();
         this.ventas = manejoCSV.cargarVentas(inventario);
        
    }

    /**
     * Obtiene el inventario de productos de la tienda.
     * 
     * @return el inventario actual
     */
    public Inventario getInventario() {
        return inventario;
    }

    /**
     * Establece un nuevo inventario para la tienda.
     * 
     * @param inventario el inventario a establecer
     */
    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    /**
     * Obtiene la lista de ventas realizadas.
     * 
     * @return una lista con las ventas registradas
     */
    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    /**
     * Establece una lista de ventas.
     * 
     * @param ventas la lista de ventas a establecer
     */
    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }

    /**
     * Registra una venta en el sistema y actualiza el inventario.
     * 
     * @param venta la venta a registrar
     */
    public void registrarVentas(Venta venta) {
        ventas.add(venta);
        for (Producto productoVendido : venta.getListaProductos()) {
            Producto productoInventario = inventario.buscarProducto(productoVendido.getCodigo());
            if (productoInventario != null) {
                int nuevaCantidad = productoInventario.getCantidad() - productoVendido.getCantidad();
                productoInventario.setCantidad(nuevaCantidad);
            }
        }
        manejoCSV.guardarProductos(inventario);
        manejoCSV.guardarVentas(ventas);
    }

    /**
     * Genera un reporte con el total de las ventas diarias.
     */
    public void generarReporteDiario() {
        double totalDiario = 0;
        System.out.println("Reporte Diario de ventas: ");
        for (Venta venta : ventas) {
            System.out.println("Código de Venta: " + venta.getCodigoVenta() + " | Fecha: " + venta.getFecha());
            for(Producto producto : venta.getListaProductos()){
                double precioTotalProducto = producto.getPrecio() * producto.getCantidad();
                System.out.println("Producto: " + producto.getNombre() +
                " | Cantidad: " + producto.getCantidad() +
                " | Precio Unitario: " + producto.getPrecio() +
                " | Precio Total: " + precioTotalProducto);
            }
            totalDiario += venta.CalcularTotal();
            System.out.println("-----------------------------------");
        }
        System.out.println("Total de ventas diarias: " + totalDiario);
    }

}