

class Persona {
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre='" + nombre + '\'' + '}';
    }
}

public class Vectores {

    private Persona[] VectorPersona;
    private int max;
    private int indice;

    public Vectores(int Max) {

        this.max = Max;
        this.VectorPersona = new Persona[Max];
        this.indice = indice;

    }

    public Persona[] getVectorPersona() {
        return VectorPersona;
    }

    public void setVectorPersona(Persona[] VectorPersona) {
        this.VectorPersona = VectorPersona;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public boolean VectorVacio() {

        if (this.indice == -1) {
            return true;
        } else {
            return false;
        }

    }

    public boolean VectorLleno() {

        if (this.max == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void agregarPersona(Persona p) {
        if (!VectorLleno()) {
            this.indice++;
            this.VectorPersona[this.indice] = p;

        } else {
            System.out.println("El vector esta lleno");
        }
    }

    public void eliminarPersona(int pos) {
        if (!VectorVacio() && pos >= 0 && pos <= this.indice) {
            for (int i = pos; i < this.indice; i++) {
                this.VectorPersona[i] = this.VectorPersona[i + 1];
            }
            this.indice--;
        } else {
            System.out.println("No se puede eliminar, el vector esta vacio o la posicion es invalida");
        }
    }
    public int buscarPersona(String nombre){
        for(int i=0; i<=this.indice; i++){
            if(this.VectorPersona[i].getNombre().equalsIgnoreCase(nombre)){
                return i;
            }
        }
        return -1;
    }
    public void mostrar(){
        if(!VectorVacio()){
            for(int i=0; i<=this.indice; i++){
                System.out.println(this.VectorPersona[i]);
            }
        }else{
            System.out.println("El vector esta vacio");
        }
    }
}
