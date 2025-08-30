
import package.Persona;
import package.Vectores;

public class Main {

    public static void main(String[] args) {
        Persona p1 = new Persona("Juan", "Perez", 175, 70.5f);
        Persona p2 = new Persona("Maria", "Gomez", 160, 60.0f);
        Persona p3 = new Persona("Pedro", "Lopez", 180, 80.0f);

        Vectores vector = new Vectores(3);

        vector.getVectorPersona()[0] = p1;
        vector.getVectorPersona()[1] = p2;
        vector.getVectorPersona()[2] = p3;

        mostrar(vector);

    }

    public static void mostrar(Vectores vector) {
        for (int i = 0; i < vector.getMax(); i++) {
            System.out.println("Nombre: " + vector.getVectorPersona()[i].getNombre() + ", Apellido: " + vector.getVectorPersona()[i].getApellido() +
                    ", Estatura: " + vector.getVectorPersona()[i].getEstatura() + ", Peso: " + vector.getVectorPersona()[i].getPeso());
        }
    }
}
