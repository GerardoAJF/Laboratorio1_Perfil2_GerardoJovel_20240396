package GerardoJovel_20240396;


import java.util.Scanner;
import java.util.TreeMap;

public class Main {


    public static void main(String[] args) {
        TreeMap<String, Estudiante> estudiantes = new TreeMap<>();
        Scanner scan = new Scanner(System.in);

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

                System.out.println("Ingrese el id del estudiante");
                String nuevoId = scan.nextLine();

                if (estudiantes.containsKey(nuevoId)) {
                    System.out.println("El nuevo id ya existe");
                    continue;
                }

                System.out.println("Ingrese el nombre del estudiante");
                String nuevoNombre = scan.nextLine();
                System.out.println("Ingrese la edad del estudiante");
                int nuevaEdad = Integer.parseInt(scan.nextLine());
                System.out.println("Ingrese el promedio del estudiante");
                double nuevoPromedio = Double.parseDouble(scan.nextLine());

                if (nuevoPromedio < 0) {
                    System.out.println("El promedio no puede ser negativo");
                    continue;
                }

                estudiantes.put(nuevoId, new Estudiante(nuevoId, nuevoNombre, nuevaEdad, nuevoPromedio));

            } else if ("2".equals(respuesta)) {

                for (Estudiante estudiante : estudiantes.values()) {
                    System.out.println("-- El estudiante con ID: " + estudiante.getId() + ", Nombre: " + estudiante.getNombre() + ", Edad: " + estudiante.getEdad() + ", y Promedio: " + estudiante.getPromedio());
                }

            } else if ("3".equals(respuesta)) {

                System.out.println("Ingrese el id del estudiante");
                String estudianteId = scan.nextLine();

                if (!estudiantes.containsKey(estudianteId)) {
                    System.out.println("El id (y por lo tanto el estudiante) no existe");
                    continue;
                }

                Estudiante estudiante = estudiantes.get(estudianteId);

                System.out.println("Ingrese el nuevo nombre del estudiante");
                estudiante.setNombre(scan.nextLine());
                System.out.println("Ingrese la nueva edad del estudiante");
                estudiante.setEdad(Integer.parseInt(scan.nextLine()));
                System.out.println("Ingrese el nuevo promedio del estudiante");

                double nuevoPromedio = Double.parseDouble(scan.nextLine());
                if (nuevoPromedio < 0) {
                    System.out.println("El promedio no puede ser negativo, así que se mantendrá el antiguo");
                    continue;
                }
                estudiante.setPromedio(nuevoPromedio);

            } else if ("4".equals(respuesta)) {

                System.out.println("Ingrese el id del estudiante");
                String estudianteId = scan.nextLine();

                if (!estudiantes.containsKey(estudianteId)) {
                    System.out.println("El id (y por lo tanto el estudiante) no existe");
                    continue;
                }

                estudiantes.remove(estudianteId);
                System.out.println("El estudiante con ID: " + estudianteId + " ha sido neutralizado");

            } else if ("5".equals(respuesta)) {
                System.out.println("Ingrese el id del estudiante");
                String estudianteId = scan.nextLine();

                if (!estudiantes.containsKey(estudianteId)) {
                    System.out.println("El id (y por lo tanto el estudiante) no existe");
                    continue;
                }

                Estudiante estudiante = estudiantes.get(estudianteId);
                System.out.println("ID: " + estudiante.getId() + ", Nombre: " + estudiante.getNombre() + ", Edad: " + estudiante.getEdad() + ", y Promedio: " + estudiante.getPromedio());
                
            } else {
                exit = true;
            }

        }

    }

}