import java.util.ArrayList;

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
     * Elimina un producto del inventario según su código.
     * @param codigo El código del producto que se desea eliminar.
     */
    public void EliminarProducto(String codigo){
        productos.removeIf(producto -> producto.getCodigo().equals(codigo));
    }

    /**
     * Busca un producto en el inventario por su código.
     * @param codigo El código del producto que se desea buscar.
     * @return El producto encontrado o null si no existe.
     */
    public Producto buscarProducto(String codigo){
        for(Producto producto : productos){
            if(producto.getCodigo().equals(codigo)){
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


}



