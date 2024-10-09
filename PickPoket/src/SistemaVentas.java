import java.util.ArrayList;

/**
 * Clase que representa el sistema de ventas de una tienda. 
 * Maneja el inventario y el registro de ventas.
 */
public class SistemaVentas {
    private Inventario inventario;
    private ArrayList<Venta> ventas;
    private GuardarCSV guardarCSV;
    private CargarCSV cargarCSV;

    /**
     * Constructor que inicializa el inventario y crea una lista vacía de ventas.
     * 
     * @param inventario el inventario de productos de la tienda
     */
    public SistemaVentas(Inventario inventario) {
        guardarCSV = new GuardarCSV();
        cargarCSV = new CargarCSV();

         // Cargar el inventario y las ventas desde archivos CSV
         this.inventario = cargarCSV.cargarProductos();
         this.ventas = cargarCSV.cargarVentas(inventario);
        
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
        guardarCSV.guardarProductos(inventario);
        guardarCSV.guardarVentas(ventas);
    }

    /**
     * Genera un reporte con el total de las ventas diarias.
     */
    public void generarReporteDiario() {
        double totalDiario = 0;
        for (Venta venta : ventas) {
            totalDiario += venta.CalcularTotal();
        }
        System.out.println("Total de ventas diarias: " + totalDiario);
    }
}