package gestortarea;
import java.util.*;



public class Tareaa {
    public static void main(String[] args) {
        Gestion gestion = new Gestion();
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        String archivo = "tareas.txt"; // Definir el nombre del archivo

        do {
            System.out.println("Menú:");
            System.out.println("1. Agregar Tarea");
            System.out.println("2. Mostrar Tareas");
            System.out.println("3. Eliminar Tareas Completadas");
            System.out.println("4. Cambiar Estado de Tarea");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            try{
                opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    gestion.agregarTarea(sc);
                    break;
                case 2:
                    gestion.mostrarTareas();
                    break;
                case 3:
                    gestion.eliminarTarea();
                    break;
                case 4:
                   gestion.cambiarEstadoTarea(sc);
                    break;
                case 5:
                    gestion.guardarArchivo(archivo);
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Entrada no válida. Intente nuevamente.");
                sc.nextLine(); // Limpiar el buffer
            }
            
        } while (opcion != 5);

        sc.close(); 
    }
}
