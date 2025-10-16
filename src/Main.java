import java.io.File;

public class Main {

    /**
     * Programa base para la gestión de ficheros y directorios con java.io.File.
     *
     * TODO:
     * - Implementar menú principal en consola.
     * - Usar únicamente la clase File para las operaciones.
     * - Reutilizar la comprobación de existencia/tipo de la práctica anterior.
     * - Manejar errores y mensajes.
     */
    public static void main(String[] args) {
        // TODO: Inicializar lectura de entrada y, si procede, ruta base desde args.
        // TODO: Bucle del menú hasta seleccionar Salir.
        // TODO: Enrutar cada opción a su método correspondiente.
        // TODO: Mensaje final al salir.
    }

    /**
     * Crear directorio.
     *
     * TODO:
     * - Pedir ruta del directorio.
     * - Validar entrada.
     * - Elegir mkdir o mkdirs.
     * - Mostrar éxito o motivo de fallo.
     */
    public static void crearDirectorio() {
        // TODO: Implementar según los puntos anteriores usando únicamente File.
    }

    /**
     * Eliminar directorio.
     *
     * TODO:
     * - Pedir ruta y verificar exists e isDirectory.
     * - Intentar delete (solo si está vacío).
     * - Informar si no se puede eliminar.
     */
    public static void eliminarDirectorio() {
        // TODO: Implementar según los puntos anteriores usando únicamente File.
    }

    /**
     * Crear fichero.
     *
     * TODO:
     * - Pedir ruta completa del fichero.
     * - Verificar si existe.
     * - Crear con createNewFile controlando posibles excepciones.
     * - Si el directorio padre no existe, decidir si crearlo.
     */
    public static void crearFichero() {
        // TODO: Implementar según los puntos anteriores usando únicamente File.
    }

    /**
     * Eliminar fichero.
     *
     * TODO:
     * - Pedir ruta y verificar exists() e isFile().
     * - Confirmar con el usuario antes de borrar.
     * - Eliminar con delete y mostrar resultado.
     */
    public static void eliminarFichero() {
        // TODO: Implementar según los puntos anteriores usando únicamente File.
    }
}