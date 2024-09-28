import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RegistroUsuarios {
    // El nombre del archivo CSV
    public static final String ARCHIVO_CSV = "Usuarios.csv";

    // Constructor de la clase
    public RegistroUsuarios() {

        // Verifica si el archivo CSV ya existe, si no lo crea con las cabeceras
        File archivo = new File(ARCHIVO_CSV);
        if (!archivo.exists()) {
            try (FileWriter writer = new FileWriter(ARCHIVO_CSV)) {

                // Escribe las cabeceras en el archivo CSV
                writer.append("Usuario,Contraseña\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para registrar un nuevo usuario en el archivo CSV
    public void registrarUsuario(String usuario, String contrasena) {
        try (FileWriter writer = new FileWriter(ARCHIVO_CSV, true)) {

            // para diferenciar el usaurio y contrasenia usamos coma
            writer.append(usuario).append(",").append(contrasena).append("\n");
            System.out.println("Usuario registrado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar un usuario por nombre en el CSV
    public boolean buscarUsuario(String usuarioBuscado) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_CSV))) {
            String linea;
            while ((linea = reader.readLine()) != null) {

                // Divide la línea por comas
                String[] datos = linea.split(",");
                String usuario = datos[0];
                // Compara el nombre de usuario
                if (usuario.equals(usuarioBuscado)) {
                    System.out.println("Usuario encontrado: " + linea);
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Usuario no encontrado.");
        return false;
    }

    // Método para obtener todos los usuarios
    public List<String> obtenerTodosLosUsuarios() {
        List<String> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_CSV))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                // Añadir usuario a la lista
                usuarios.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}