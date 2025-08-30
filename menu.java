
import java.util.Scanner;


public class menu {
    int max=0;

    Scanner scanner = new Scanner(System.in);

    public int numeroPersonas(){
        System.out.println("Ingrese el numero de personas a registrar: ");
        max = scanner.nextInt();
        return max;
    }
    

    private Vectores vector = new Vectores(numeroPersonas());


    public void mostrarMenu() {
        System.out.println("Bienvenido al sistema de gestion de personas");
        System.out.println("1. Agregar persona");
        System.out.println("2. Mostrar personas");
        System.out.println("3. Eliminar persona");
        System.out.println("4. Buscar persona");
        System.out.println("5. Salir");

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Seleccione una opcion: ");
        int opcion = scanner.nextInt();

        while (opcion != 4) {
            switch (opcion) {
                case 1:
                    if (!vector.VectorLleno()) {
                        System.out.print("Ingrese el nombre: ");
                        String nombre = scanner.next();
                        System.out.print("Ingrese el apellido: ");
                        String apellido = scanner.next();
                        System.out.print("Ingrese el peso: ");
                        float peso = scanner.nextFloat();
                        System.out.print("Ingrese la altura: ");
                        int altura = scanner.nextInt();

                        Persona p = new Persona (nombre, apellido , altura , peso  );
                        vector.agregarPersona(p);

                    } else {
                        System.out.println("El vector esta lleno");
                    }
                    break;
                case 2:
                    vector.mostrar();
                    break;
                case 3:
                    if (!vector.VectorVacio()) {
                        System.out.print("Ingrese la posicion a eliminar (0 a " + vector.getIndice() + "): ");
                        int posicion = scanner.nextInt();
                        vector.eliminarPersona(posicion);
                    } else {
                        System.out.println("El vector esta vacio");
                    }
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
        }

        System.out.println("Saliendo del sistema...");
        scanner.close();
    }
}
