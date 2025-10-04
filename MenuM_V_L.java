import java.util.Scanner;

public class MenuM_V_L {

    private int opcion;
    private Vectores vector;
    private Scanner scanner = new Scanner(System.in);
    private Matrices matriz;
    private ListaSimple lista;

    public void MenuM_M_V() {
        this.scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de gestión de personas");
        System.out.println("Seleccione la estructura de datos que desea utilizar:");

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Vectores");
            System.out.println("2. Matrices");
            System.out.println("3. Menu Listas");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    menuVectores();
                    break;
                case 2:
                    menuMatrices();
                    break;
                case 3:
                    menuListas();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 4);

    }

    public void menuVectores() {
        System.out.println("Bienvenido al metodo vectores");

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
                    if (vector == null) {
                        System.out.println("Ingrese el número de personas a registrar: ");
                        int max = scanner.nextInt();
                        scanner.nextLine();
                        vector = new Vectores(max);
                    }

                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Ingrese la estatura (en cm): ");
                    int estatura = scanner.nextInt();
                    System.out.print("Ingrese el peso (en kg): ");
                    float peso = scanner.nextFloat();
                    scanner.nextLine();

                    Persona persona = new Persona(nombre, apellido, estatura, peso);
                    vector.agregarPersona(persona);

                    break;
                case 2:
                    if (vector == null || vector.VectorVacio()) {
                        System.out.println("No hay personas registradas.");
                    } else {
                        vector.mostrar();
                    }
                    break;

                case 3:

                    if (vector == null || vector.VectorVacio()) {
                        System.out.println("No hay personas registradas para buscar.");
                    } else {

                        System.out.print("Ingrese el nombre de la persona a buscar: ");
                        String nombreBuscar = scanner.nextLine();

                        vector.buscarPersona(nombreBuscar);

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
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }

        } while (opcion != 5);

    }

    public void menuMatrices() {
        System.out.println("Bienvenido al Menu de Matrices");

        int opcion;

        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar Persona");
            System.out.println("2. Mostrar Personas");
            System.out.println("3. Eliminar Persona");
            System.out.println("4. Buscar Persona");
            System.out.println("5. Promedio de estatura y peso");
            System.out.println("6. Salir");
            System.out.print("Ingrese su opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // agregar persona
                    if (matriz == null) {
                        System.out.println("Ingrese el número de filas de la matriz: ");
                        int filas = scanner.nextInt();
                        System.out.println("Ingrese el número de columnas de la matriz: ");
                        int columnas = scanner.nextInt();
                        scanner.nextLine();
                        matriz = new Matrices(filas, columnas);

                        System.out.println("Matriz de " + filas + "x" + columnas + " creada.");

                    }
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Ingrese la estatura (en cm): ");
                    int estatura = scanner.nextInt();
                    System.out.print("Ingrese el peso (en kg): ");
                    float peso = scanner.nextFloat();
                    scanner.nextLine();
                    Persona p = new Persona(nombre, apellido, estatura, peso);
                    matriz.ingresarPersonaSecuencial1(p);

                    break;

                // mostrar personas
                case 2:

                    if (matriz == null || matriz.MatrizVacia()) {
                        System.out.println("No hay personas registradas.");
                    } else {
                        matriz.mostrarPersona();
                    }

                    // eliminar persona
                    break;
                case 3:
                    if (matriz == null || matriz.MatrizVacia()) {
                        System.out.println("No hay personas registradas para eliminar.");
                    } else {
                        System.out.print("Ingrese la fila de la persona a eliminar: ");
                        int fila = scanner.nextInt();
                        System.out.print("Ingrese la columna de la persona a eliminar: ");
                        int columna = scanner.nextInt();
                        scanner.nextLine();

                        matriz.eliminarPersona(fila, columna);

                    }

                    // buscar persona
                    break;
                case 4:
                    if (matriz == null || matriz.MatrizVacia()) {
                        System.out.println("No hay personas registradas para buscar.");
                    } else {
                        System.out.print("Ingrese el nombre de la persona a buscar: ");
                        String nombreBuscar = scanner.nextLine();
                        matriz.buscarPersona(nombreBuscar);
                    }
                    break;

                case 5:
                    if (matriz == null || matriz.MatrizVacia()) {
                        System.out.println("No hay personas registradas.");
                    } else {
                        matriz.promedioEstaturaYPeso();
                    }
                    break;
                    
                case 6:
                    System.out.println("Saliendo del sistema de matrices...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 6);
    }

    public void menuListas() {
        System.out.println("Bienvenido al Menu de Listas");

        int opcion;

        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar Persona");
            System.out.println("2. Mostrar Personas");
            System.out.println("3. Eliminar Persona");
            System.out.println("4. Buscar Persona");
            System.out.println("5. Promedio de estatura y peso");
            System.out.println("6. Salir");
            System.out.print("Ingrese su opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    // agregar persona
                    if (lista == null) {
                        System.out.println("Creando una nueva lista...");
                        lista = new ListaSimple();

                        Scanner scanner = new Scanner(System.in);
                        System.out.print("Ingrese el nombre de la persona: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Ingrese el apellido de la persona: ");
                        String apellido = scanner.nextLine();

                        System.out.print("Ingrese la estatura (en cm): ");
                        int estatura = scanner.nextInt();

                        System.out.print("Ingrese el peso (en kg): ");
                        float peso = scanner.nextFloat();
                        scanner.nextLine();

                        Persona nuevaPersona = new Persona(nombre, apellido, estatura, peso);
                        lista.agregarPersonaInicio(nuevaPersona);

                        System.out.println("Persona agregada exitosamente.");

                        break;

                    }

                    // agregar persona
                    break;
                case 2:
                    // mostrar personas
                    break;
                case 3:
                    // eliminar persona
                    break;
                case 4:
                    // buscar persona
                    break;
                case 5:
                    // promedio estatura y peso
                    break;
                case 6:
                    System.out.println("Saliendo del sistema de listas...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");

            }
        } while (opcion != 6);

    }
}
/* juego torres de Hanoi , termino de recursividad */
