/**
 * Clase Producto que representa un producto en el inventario.
 * Contiene información como el código, nombre, precio, cantidad y categoría del producto.
 */
public class Producto {
    private String codigo;
    private String nombre;
    private float precio;
    private int cantidad;
    private String categoria;

    /**
     * Constructor de la clase Producto.
     * @param codigo El código único del producto.
     * @param nombre El nombre del producto.
     * @param precio El precio del producto.
     * @param cantidad La cantidad disponible del producto.
     * @param categoria La categoría a la que pertenece el producto.
     */
    public Producto(String codigo, String nombre, float precio, int cantidad, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    /**
     * Obtiene el código del producto.
     * @return El código del producto.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código del producto.
     * @param codigo El nuevo código del producto.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene el nombre del producto.
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     * @param nombre El nuevo nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del producto.
     * @return El precio del producto.
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     * @param precio El nuevo precio del producto.
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la cantidad disponible del producto.
     * @return La cantidad disponible del producto.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad disponible del producto.
     * @param cantidad La nueva cantidad del producto.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene la categoría del producto.
     * @return La categoría del producto.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría del producto.
     * @param categoria La nueva categoría del producto.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}