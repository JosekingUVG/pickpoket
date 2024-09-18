import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos;


    public Inventario(){
        productos = new ArrayList<>();
    }

    public void AgregarProducto(Producto producto){
        productos.add(producto);
    }

    public void EliminarProducto(String codigo){
        productos.removeIf(producto -> producto.getCodigo().equals(codigo));
    }

    public Producto BuscarProducto(String codigo){
        for(Producto producto : productos){
            if(producto.getCodigo().equals(codigo)){
                return producto;
            }
        }
        return null;

    }

    public ArrayList<Producto> VerInventario(){
        return productos;

    }
}



