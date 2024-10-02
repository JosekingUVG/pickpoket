public class Usuario {

    private String nombre;
    private String contraseña;
    private int tipo;//1.Admin 2.Vendedor

    //Constructor
    public Usuario() {
        this.nombre = "";
        this.contraseña = "";
        this.tipo = 0;
    }
    //Setters y getters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    


}
