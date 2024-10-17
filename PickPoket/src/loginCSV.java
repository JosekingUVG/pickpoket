import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class loginCSV {
    private Usuario usuario;
    
    private static final String FILE_PATH = "data/usuarios.csv";



    // Constructor
    public loginCSV() {
        this.usuario = new Usuario();
    }

    // Función para guardar un nuevo usuario
    public void guardarUsuario(Usuario usuario) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true)); // true para agregar al archivo
        writer.write(usuario.getNombre() + "," + usuario.getContraseña() + "," + usuario.getTipo() + "\n");
        writer.close();
    }


// Nueva función: Obtener todos los usuarios registrados y guardarlos en un ArrayList
public List<Usuario> obtenerUsuarios() throws IOException {
    List<Usuario> listaUsuarios = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
    String line;
    
    while ((line = reader.readLine()) != null) {
        String[] datos = line.split(",");
        if (datos.length == 3) {
            Usuario usuario = new Usuario();
            usuario.setNombre(datos[0]);
            usuario.setContraseña(datos[1]);
            usuario.setTipo(Integer.parseInt(datos[2])); // Tipo (1: Admin, 2: Vendedor)
            listaUsuarios.add(usuario);
        }
    }
    reader.close();
    return listaUsuarios;
}



    // Función modificada para buscar un usuario (Login)
    public Usuario loginUsuario(String nombre, String contraseña) throws IOException {
        List<Usuario> usuarios = obtenerUsuarios(); // Cargar todos los usuarios en un ArrayList
        
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre) && usuario.getContraseña().equals(contraseña)) {
                return usuario; // Retornamos el usuario si el login es exitoso
            }
        }
        return null; // Usuario no encontrado o contraseña incorrecta
    }

    //Función para Eliminar un usuario del csv usando el ArrayList obtenerUsuario
    public void eliminarUsuario(Usuario user) throws IOException{
    	 List<Usuario> usuarios = obtenerUsuarios(); // Cargar todos los usuarios en un ArrayList

    	// Usar un ciclo for con un índice para eliminar el usuario
         for (int i = 0; i < usuarios.size(); i++) {
             if (usuarios.get(i).getNombre().equals(user.getNombre())) {
                 usuarios.remove(i); // Eliminar el usuario
                 break; // Terminar el ciclo ya que el usuario ha sido encontrado
             }
         }

         // Sobrescribir el archivo CSV con la lista actualizada
         try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
             for (Usuario usuario : usuarios) {
                 bw.write(usuario.getNombre() + "," + usuario.getContraseña() + "," + usuario.getTipo());
                 bw.newLine();
             }
         }
     }


    




    // Función para modificar un usuario existente
    public void modificarUsuario(String nombre, String nuevaContraseña, int nuevoTipo) throws IOException {
        File inputFile = new File(FILE_PATH);
        File tempFile = new File("temp.csv");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] datos = line.split(",");
            if (datos[0].equals(nombre)) {
                // Actualizamos los datos del usuario
                writer.write(nombre + "," + nuevaContraseña + "," + nuevoTipo + "\n");
            } else {
                // Escribimos los datos sin modificar
                writer.write(line + "\n");
            }
        }
        writer.close();
        reader.close();

        // Borramos el archivo original y renombramos el temporal
        inputFile.delete();
        tempFile.renameTo(inputFile);
    }
}
