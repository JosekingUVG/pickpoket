import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Clase Inventario que maneja una lista de productos.
 * Permite agregar, eliminar, buscar productos y ver el inventario completo.
 */
public class Inventario {
    private ArrayList<Producto> productos;

    /**
     * Constructor de la clase Inventario.
     * Inicializa la lista de productos como vacía.
     */
    public Inventario(){
        productos = new ArrayList<>();
    }

    /**
     * Agrega un producto al inventario.
     * @param producto El producto que se va a agregar.
     */
    public void AgregarProducto(Producto producto){
        productos.add(producto);
    }

    

    /**
     * Elimina un producto del inventario según su nombre.
     * @param codigo El código del producto que se desea eliminar.
     */
    public void EliminarProducto(String codigo){
        productos.removeIf(producto -> producto.getNombre().equals(codigo));
    }

    /**
     * Busca un producto en el inventario por su código.
     * @param codigo El código del producto que se desea buscar.
     * @return El producto encontrado o null si no existe.
     */
    public Producto buscarProducto(String codigo){
        for(Producto producto : productos){
            if(producto.getNombre().equals(codigo)){
                return producto;
            }
        }
        return null;
    }

    /**
     * Muestra el inventario completo.
     * @return Una lista de todos los productos en el inventario.
     */
    public ArrayList<Producto> VerInventario(){
        return productos;
    }

    /** 
     * Este metodo sirve para actualizar cada producto
     * @param productoActualizado El producto de tipo Producto que se desea actualizar
     * 
    */
    public void actualizarProducto(Producto productoActualizado) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(productoActualizado.getCodigo())) {
                producto.setNombre(productoActualizado.getNombre());
                producto.setPrecio(productoActualizado.getPrecio());
                producto.setCantidad(productoActualizado.getCantidad());
                producto.setCategoria(productoActualizado.getCategoria());
            }
        }
    }

    public void ordenarInventario(String criterio) {
        Comparator<Producto> comparador;
        switch (criterio) {
            case "codigo":
                comparador = Comparator.comparing(Producto::getCodigo);
                break;
            case "nombre":
                comparador = Comparator.comparing(Producto::getNombre);
                break;
            case "precio":
                comparador = Comparator.comparing(Producto::getPrecio);
                break;
            case "cantidad":
                comparador = Comparator.comparing(Producto::getCantidad);
                break;
            default:
                return;
        }
        Collections.sort(productos, comparador);
    }

    public void setProductos(List<Producto> productos) {
    this.productos = new ArrayList<>(productos);
}


    


}



