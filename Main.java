import java.util.Scanner;

public class Main {

    private Vectores vector;
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("Bienvenido al sistema de gestión de personas");

        int opcion;
        do {
            System.out.println("1. Agregar personas");
            System.out.println("2. Mostrar personas");
            System.out.println("3. Buscar persona");
            System.out.println("4. Eliminar persona");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    if (vector == null || vector.VectorLleno()) {
                        System.out.print("Ingrese el número de personas a registrar: ");
                        int max = scanner.nextInt();
                        scanner.nextLine();
                        vector = new Vectores(max);
                    }

                    while (!vector.VectorLleno()) {
                        System.out.print("Ingrese el nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese el apellido: ");
                        String apellido = scanner.nextLine();
                        System.out.print("Ingrese la estatura: ");
                        float estatura = scanner.nextFloat();
                        System.out.print("Ingrese el peso: ");
                        float peso = scanner.nextFloat();
                        scanner.nextLine();

                        Persona p = new Persona(nombre, apellido, estatura, peso);
                        vector.agregarPersona(p);

                        if (vector.VectorLleno()) {
                            System.out.println("Se ha alcanzado el límite de personas registradas.");
                        } else {
                            System.out.print("¿Desea agregar otra persona? (sí/no): ");
                            String continuar = scanner.nextLine();
                            if (!continuar.equalsIgnoreCase("sí"))
                                break;
                        }
                    }
                    break;

                case 2:
                    vector.mostrar();
                    break;

                case 3:
                    System.out.print("Ingrese el nombre de la persona a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    int posicion = vector.buscarPersona(nombreBuscar);
                    if (posicion != -1) {
                        System.out.println("Persona encontrada en la posición: " + posicion);
                    } else {
                        System.out.println("Persona no encontrada.");
                    }
                    break;

                case 4:
                    if (vector == null || vector.VectorVacio()) {
                        System.out.println("No hay personas registradas para eliminar.");
                    } else {
                        int indiceActual = vector.getIndice();
                        System.out.print("Ingrese la posición a eliminar (0 a " + (indiceActual - 1) + "): ");

                        if (scanner.hasNextInt()) {
                            int posicionPersona = scanner.nextInt();
                            scanner.nextLine();

                            if (posicionPersona >= 0 && posicionPersona < indiceActual) {
                                vector.eliminarPersona(posicionPersona);
                                System.out.println("Persona eliminada de la posición " + posicionPersona + ".");
                            } else {
                                System.out.println("Error: La posición " + posicionPersona + " no es válida.");
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.mostrarMenu();
    }
}
