package GerardoJovel_20240396;


import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    static TreeMap<String, Estudiante> estudiantes = new TreeMap<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        String respuesta;

        boolean exit = false;
        while (!exit) {
            System.out.println("Elige alguna de las siguiente opciones (Escribe el número):");
            System.out.println("(1) Agrega un estudiante");
            System.out.println("(2) Imprime todos los estudiantes ordenados por ID");
            System.out.println("(3) Actualiza a un estudiante por ID");
            System.out.println("(4) Elimina a un estudiante por ID");
            System.out.println("(5) Busca a un estudiante por ID");
            System.out.println("Escribe cualquier otra cosa para salir");

            respuesta = scan.nextLine();

            if ("1".equals(respuesta)) {

                String estudianteId = obtenerNuevoId();
                if ("".equals(estudianteId)) { continue; }

                String nombre = obtenerNuevoNombre();
                if ("".equals(nombre)) { continue; }

                int edad = obtenerNuevaEdad();
                if (edad < 0) { continue; }

                double promedio = obtenerNuevoPromedio();
                if (promedio < 0) { continue;}

                estudiantes.put(estudianteId, new Estudiante(estudianteId, nombre, edad, promedio));

            } else if ("2".equals(respuesta)) {

                System.out.println("Imprimiendo estudiantes:");
                for (Estudiante estudiante : estudiantes.values()) {
                    System.out.println("-- Estudiante con ID: " + estudiante.getId() + ", Nombre: " + estudiante.getNombre() + ", Edad: " + estudiante.getEdad() + ", y Promedio: " + estudiante.getPromedio());
                }

            } else if ("3".equals(respuesta)) {
                String estudianteId = obtenerExistenteId();
                if ("".equals(estudianteId)) { continue; }
                Estudiante estudiante = estudiantes.get(estudianteId);

                String nombre = obtenerNuevoNombre();
                if ("".equals(nombre)) {
                    System.out.println("- No se actualizará el nombre al no ser un valor válido");
                } else {
                    estudiante.setNombre(nombre);
                }

                int edad = obtenerNuevaEdad();
                if (edad < 0) {
                    System.out.println("- No se actualizará la edad al no ser un valor válido");
                } else {
                    estudiante.setEdad(edad);
                }

                double promedio = obtenerNuevoPromedio();
                if (promedio < 0) {
                    System.out.println("- No se actualizará el promedio al no ser un valor válido");
                } else {
                    estudiante.setPromedio(promedio);
                }


            } else if ("4".equals(respuesta)) {
                String estudianteId = obtenerExistenteId();
                if ("".equals(estudianteId)) { continue;}

                estudiantes.remove(estudianteId);
                System.out.println("El estudiante con ID: " + estudianteId + " ha sido neutralizado");

            } else if ("5".equals(respuesta)) {
                String estudianteId = obtenerExistenteId();
                if ("".equals(estudianteId)) { continue;}

                Estudiante estudiante = estudiantes.get(estudianteId);
                System.out.println("ID: " + estudiante.getId() + ", Nombre: " + estudiante.getNombre() + ", Edad: " + estudiante.getEdad() + ", y Promedio: " + estudiante.getPromedio());

            } else {
                exit = true;
            }

        }
        System.out.println("Adios!!");

    }

    public static String obtenerExistenteId() {
        System.out.println("Ingrese el id del estudiante");
        String estudianteId = scan.nextLine();

        if (!estudiantes.containsKey(estudianteId)) {
            System.out.println("- El id (y por lo tanto el estudiante) no existe");
            return "";
        }
        return estudianteId;
    }

    public static String obtenerNuevoId() {
        System.out.println("Ingrese el id del estudiante");
        String estudianteId = scan.nextLine();

        if (estudiantes.containsKey(estudianteId)) {
            System.out.println("- El id ya existe");
            return "";
        }

        if ("".equals(estudianteId)) {
            System.out.println("- El nuevo id no puede estar vacío");
            return "";
        }

        return estudianteId;
    }

    public static String obtenerNuevoNombre() {
        System.out.println("Ingrese el nuevo nombre del estudiante");

        String nuevoNombre = scan.nextLine();

        if ("".equals(nuevoNombre)) {
            System.out.println("- El nuevo nombre no puede estar vacío");
            return "";
        }
        return nuevoNombre;
    }

    public static int obtenerNuevaEdad() {
        System.out.println("Ingrese la nueva edad del estudiante");
        try {
            int nuevaEdad = Integer.parseInt(scan.nextLine());
            if (nuevaEdad < 0) {
                System.out.println("- La edad no puede ser negativa");
                return -1;
            }
            return nuevaEdad;
        } catch (Exception e) {
            System.out.println("- No ingreso un número entero");
            return  -1;
        }

    }

    public static double obtenerNuevoPromedio() {
        System.out.println("Ingrese el nuevo promedio del estudiante");

       try {
           double nuevoPromedio = Double.parseDouble(scan.nextLine());
           if (nuevoPromedio < 0) {
               System.out.println("- El promedio no puede ser negativo");
               return -1;
           }
           if (nuevoPromedio > 10) {
               System.out.println("- El nuevo promedio no puede ser mayor a diez");
               return -1;
           }

           return nuevoPromedio;
       } catch (Exception e) {
           System.out.println("- No ingreso un número flotante");
           return -1;
       }
    }


}