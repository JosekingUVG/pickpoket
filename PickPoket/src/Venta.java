import java.util.ArrayList;
import java.util.List;

/**
 * Clase Venta que representa una venta de productos.
 * Contiene el código de la venta, la lista de productos, el total y la fecha de la venta.
 */
public class Venta {

    private String codigoVenta;
    private List<Producto> listaProductos; // Cambié a List para mayor flexibilidad
    private double total;
    private String fecha;
    private String idVenta;

    /**
     * Constructor sin parámetros
     */
    public Venta() {
        this.codigoVenta = "";
        this.total = 0;
        this.listaProductos = new ArrayList<>();  // Inicializamos la lista de productos
    }

    public Venta(String idVenta, String fecha) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.listaProductos = new ArrayList<>(); // Inicializamos la lista de productos
    }

    /**
     * Constructor completo
     */
    public Venta(String codigoVenta, List<Producto> listaProductos, double total, String fecha) {
        this.codigoVenta = codigoVenta;
        this.listaProductos = listaProductos;
        this.total = total;
        this.fecha = fecha;
    }

    /**
     * Agrega un producto a la lista de productos de la venta.
     * Suma el costo del producto al total de la venta.
     * @param producto El producto que se va a agregar a la venta.
     */
    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
        total += producto.getPrecio() * producto.getCantidad();
    }

    /**
     * Obtiene la lista de productos de la venta.
     * @return La lista de productos.
     */
    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    /**
     * Obtiene el total de la venta.
     * @return El total de la venta.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Obtiene la fecha en que se realizó la venta.
     * @return La fecha de la venta.
     */
    public String getFecha() {
        return fecha;
    }

    public String getCodigoVenta() {
        return codigoVenta;
    }

    // Puedes agregar más métodos según sea necesario
}