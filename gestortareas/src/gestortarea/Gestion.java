package gestortarea;
import java.util.*;
import java.io.*;

class Gestion {
    private List<Tarea> tareas;

    public Gestion() {
        this.tareas = new ArrayList<>();
    }

    public void guardarArchivo(String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Tarea t : tareas) {
                writer.write(t.getDescripcion() + "," + t.getEstado());
                writer.newLine();
            }
            System.out.println("Tareas guardadas en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public void agregarTarea(Scanner sc) {
        System.out.println("Ingrese la descripción de la tarea:");
        String descripcion = sc.nextLine();

        System.out.println("Ingrese el estado de la tarea:\n1. Pendiente\n2. Completada");
        String estadoInput = sc.nextLine();
        String estado;

        if (estadoInput.equals("1")) {
            estado = "Pendiente";
        } else if (estadoInput.equals("2")) {
            estado = "Completada";
        } else {
            System.out.println("Estado no válido, se asignará como Pendiente.");
             estado = "Pendiente";        }

        Tarea tarea1 = new Tarea(descripcion, estado);
        tareas.add(tarea1);

        System.out.println("Tarea agregada: " + tarea1);
    }

    public void cambiarEstadoTarea(Scanner sc) {
        mostrarTareas();

        if (tareas.isEmpty()) {
            System.out.println("No hay tareas para cambiar el estado.");
            return;
        }

        System.out.println("Ingrese el número de la tarea a cambiar el estado:");
        String input=sc.nextLine();
        int num;

        try {
            num = Integer.parseInt(input);
            if (num < 1 || num > tareas.size()) {
                System.out.println("Número de tarea no válido.");
                return;
            }
        } 
        
        catch (NumberFormatException e) {
            System.out.println("Entrada no válida.");
            return;
        }

        Tarea tarea = tareas.get(num - 1);
        System.out.println("Ingrese el nuevo estado de la tarea:\n1. Pendiente\n2. Completada");
        int nuevoEstado = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea
        if(nuevoEstado == 1) {
            tarea.setEstado("Pendiente");
        } else if(nuevoEstado == 2) {
            tarea.setEstado("Completada");
        } else {
            System.out.println("Estado no válido, se asignará como Pendiente.");
            tarea.setEstado("Pendiente");
            return;
        }
        System.out.println("Estado de la tarea actualizado: " + tarea);
    }

    public void mostrarTareas() {
        int i = 1;
        for (Tarea t : tareas) {
            System.out.println(i + ". " + t);
            i++;
        }
        System.out.println("Total de tareas: " + tareas.size());
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
        }
        
    }

    public void eliminarTarea() {
        mostrarTareas();
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas para eliminar.");
            return;
        }
        int antes = tareas.size();
        tareas.removeIf(t -> t.getEstado().equalsIgnoreCase("Completada"));
        int eliminadas = antes - tareas.size();
        System.out.println("Se eliminaron " + eliminadas + " tareas completadas.");
    }
}

