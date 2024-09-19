import java.util.ArrayList;

/**
 * Clase Venta que representa una venta de productos.
 * Contiene el código de la venta, la lista de productos, el total y la fecha de la venta.
 */
public class Venta {

    private String codigoVenta;
    private ArrayList<Producto> listaProductos;
    private double total;
    private String fecha;

    /**
     * Constructor de la clase Venta.
     * @param codigoVenta El código único de la venta.
     * @param listaProductos La lista de productos incluidos en la venta.
     * @param total El total de la venta.
     * @param fecha La fecha en la que se realizó la venta.
     */
    public Venta(String codigoVenta, ArrayList<Producto> listaProductos, double total, String fecha) {
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
    public void AgregarProducto(Producto producto){
        listaProductos.add(producto);
        total += producto.getPrecio() * producto.getCantidad();
    }

    /**
     * Calcula y devuelve el total de la venta.
     * @return El total de la venta.
     */
    public double CalcularTotal(){
        return total;
    }

    /**
     * Obtiene el código de la venta.
     * @return El código de la venta.
     */
    public String getCodigoVenta() {
        return codigoVenta;
    }

    /**
     * Establece el código de la venta.
     * @param codigoVenta El nuevo código de la venta.
     */
    public void setCodigoVenta(String codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    /**
     * Obtiene la lista de productos de la venta.
     * @return La lista de productos.
     */
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    /**
     * Establece una nueva lista de productos para la venta.
     * @param listaProductos La nueva lista de productos.
     */
    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    /**
     * Obtiene el total de la venta.
     * @return El total de la venta.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Establece un nuevo total para la venta.
     * @param total El nuevo total de la venta.
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Obtiene la fecha en que se realizó la venta.
     * @return La fecha de la venta.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece una nueva fecha para la venta.
     * @param fecha La nueva fecha de la venta.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}