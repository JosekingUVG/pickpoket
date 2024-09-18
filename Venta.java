import java.util.ArrayList;

public class Venta {

    private String codigoVenta;
    private ArrayList<Producto> listaProductos;
    private double total;
    private String fecha;

    public Venta(String codigoVenta, ArrayList<Producto> listaProductos, double total, String fecha) {
        this.codigoVenta = codigoVenta;
        this.listaProductos = listaProductos;
        this.total = total;
        this.fecha = fecha;
    }

    public void AgregarProducto(Producto producto){
        listaProductos.add(producto);
        total += producto.getPrecio() * producto.getCantidad();
    }

    public double CalcularTotal(){
        return total;

    }

    public String getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(String codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    

    
    
}
