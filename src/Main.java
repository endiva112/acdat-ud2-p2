import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    //URL del proyecto en GitHub -> https://github.com/endiva112/acdat-ud2-p2/tree/main
    private static Scanner sc = new Scanner(System.in);
    private static File rutaActual;
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
        seleccionarDirectorioDeTrabajo();
        if (rutaActual == null) {//Si la ruta actual no está inicializado, damos el error y cerramos el programa
            System.out.println("Ha habido un error, no se ha establecido un fichero de trabajo");
        } else {
            programaPrincipal();
        }

    }

    /**
     * Establece la ruta del directorio actual sobre el que trabajaran el resto de métodos
     */
    public static void seleccionarDirectorioDeTrabajo() {
        System.out.print("Seleccione un directorio de trabajo: ");
        String ruta = sc.nextLine();
        rutaActual = new File(ruta);
    }

    /**
     * Lógica principal del programa
     */
    public static void programaPrincipal() {
        int opcionUsuario;
        do  {//Mostramos opciones
            mostrarOpciones();
            opcionUsuario = sc.nextInt();
            sc.nextLine();//limpiar buffer
            switch (opcionUsuario) {
                case 0://modificar ruta
                    seleccionarDirectorioDeTrabajo();
                    break;
                case 1://crear directorio
                    crearDirectorio(rutaActual);
                    break;
                case 2://eliminar directorio
                    eliminarFichero(rutaActual);
                    break;
                case 3://crear fichero
                    crearFichero(rutaActual);
                    break;
                case 4://eliminar fichero
                    eliminarFichero(rutaActual);
                    break;
                case 5://salir
                    System.out.println("Gracias por usar el programa.");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcionUsuario != 5);
    }

    /**
     * Muestra el bloque de texto en la consola para que el usuario sepa qué está haciendo
     */
    public static void mostrarOpciones(){
        System.out.println("DIRECTORIO sobre el que trabaja: " + rutaActual.getName());
        System.out.println("- - - - - - - - - - - - - - - - - -");
        System.out.println("Lista de acciones que puede tomar: ");
        System.out.println("- - - - - - - - - - - - - - - - - -");
        System.out.println("(0) Modificar el fichero en el que se quiere trabajar");
        System.out.println("(1) Crear directorio");
        System.out.println("(2) Eliminar directorio");
        System.out.println("(3) Crear fichero");
        System.out.println("(4) Eliminar fichero");
        System.out.println("(5) Salir del programa");
        System.out.print("Ingrese su opción aquí: ");
    }


    /**
     * Crear directorio.
     * - Pedir ruta del directorio.
     * - Validar entrada.
     * - Elegir mkdir o mkdirs.
     * - Mostrar éxito o motivo de fallo.
     */
    public static void crearDirectorio(File directorioActual) {
        // TODO: Implementar según los puntos anteriores usando únicamente File.

        boolean creado;
        System.out.println("Elige si crear el directorio actual pulse 1 o toda la ruta pulse 2");
        int opcion = sc.nextInt();


        if (opcion == 1) {
            creado = directorioActual.mkdir();
            if (creado) {
                System.out.println("Directorio guardado correctamente");
            } else {
                System.out.println("Ya hay un directorio con este nombre");
            }
        }else if (opcion == 2) {
            creado = directorioActual.mkdirs();
            if (creado) {
                System.out.println("Directorio y subdirectorio  guardados correctamente");
            } else {
                System.out.println("Ya hay un directorio con este nombre");
            }
        }
    }

    /**
     * Eliminar directorio.
     *
     * TODO:
     * - Pedir ruta y verificar exists e isDirectory.
     * - Intentar delete (solo si está vacío).
     * - Informar si no se puede eliminar.
     */
    public static void eliminarDirectorio(File dir) {
        // TODO: Implementar según los puntos anteriores usando únicamente File.

        boolean flag = true;

        if (dir.isDirectory() && dir.exists()) {
            if (dir.delete()) {//Aquí se comprueba que está vacío
                System.out.println("Directorio eliminado correctamente");
            } else {
                System.out.println("El directorio no está vacio");
            }
        } else {
            System.out.println("El directorio no existe");
        }

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
    public static void crearFichero(File directorioActual) {

        System.out.print("Introduzca el nombre del fichero que desea crear: ");
        String nombreFichero = sc.nextLine();

        File nuevoFichero = new File (directorioActual, nombreFichero);

        if  (nuevoFichero.exists()) {
            System.out.println("El fichero ya existe, no se puede crear");
        } else {//Si no existe, se crea
            try {
                nuevoFichero.createNewFile();
                System.out.println("Fichero creado correctamente: " +  nuevoFichero.getPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /*
        File fichero = new File("ficherito.txt");
        try {
            fichero.createNewFile();
            if (fichero.exists()) {
                System.out.println("Fichero guardado correctamente");
            }else {
                System.out.println("EL fichero ya existe ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }

    /**
     * Eliminar fichero.
     * TODO:
     * - Pedir ruta y verificar exists() e isFile().
     * - Confirmar con el usuario antes de borrar.
     * - Eliminar con delete y mostrar resultado.
     */
    public static void eliminarFichero(File fi) {
        // TODO: Implementar según los puntos anteriores usando únicamente File.

        if (fi.exists() && fi.isFile()) {
            byte opcion = 0;
            boolean flag = true;
            do {

            System.out.println("¿Seguro que desea eliminar el fichero?\n1- Aceptar\n2- Cancelar");
            opcion = sc.nextByte();

                if (opcion == 1) {
                    if (fi.delete()) {
                        System.out.println("El fichero ha sido eliminado");
                    } else {
                        System.out.println("El fichero no se pudo eliminar");
                    }
                }

            } while (opcion != 1 && opcion != 2);

        } else  {
            System.out.println("El fichero no existe");
        }

    }
}
