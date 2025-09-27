public class Matrices {

    private int fila;
    private int columna;
    private Persona[][] MatrizPersona;
    int indiceF;
    int indiceC;
    int indiceActual;

    public Matrices() {
    }

    public Matrices(int filas, int columnas) {
        this.fila = filas;
        this.columna = columnas;
        this.indiceF = 0;
        this.indiceC = 0;
        this.MatrizPersona = new Persona[filas][columnas];

    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getIndiceF() {
        return indiceF;
    }

    public void setIndiceF(int indiceF) {
        this.indiceF = indiceF;
    }

    public int getIndiceC() {
        return indiceC;
    }

    public void setIndiceC(int indiceC) {
        this.indiceC = indiceC;
    }

    public Persona[][] getMatrizPersona() {
        return MatrizPersona;
    }

    public void setMatrizPersona(Persona[][] MatrizPersona) {
        this.MatrizPersona = MatrizPersona;
    }

    public boolean MatrizVacia() {
        if (indiceF == -1 && indiceC == -1) {
            return true;
        } else {
            return false;

        }
    }

    public boolean MatrizLlena() {
        return (this.indiceF == fila);
    }

    public void mostrarMatriz() {
        for (int i = 0; i <= indiceF; i++) {
            for (int j = 0; j <= indiceC; j++) {
                System.out.println(MatrizPersona[i][j]);
            }
        }
    }

    public void ingresarPersonaSecuencial1(Persona p) {
        if (!MatrizLlena()) {
            if (indiceF < fila && indiceC < columna) {
                MatrizPersona[indiceF][indiceC] = p;
                System.out.println("Insertado en [" + indiceF + "][" + indiceC + "]");

                indiceC++;
                if (indiceC == columna) {
                    indiceC = 0;
                    indiceF++;
                }
            } else {
                System.out.println("Error: no se puede insertar, índice fuera de rango.");
            }
        } else {
            System.out.println("La matriz está llena, no se puede agregar más personas.");
        }
    }

    public void mostrarPersona() {
        int totalPersonas = 0;

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                if (MatrizPersona[i][j] != null) {
                    System.out
                            .println("Persona en la fila [" + i + "] y la columna [" + j + "]: " + MatrizPersona[i][j]);
                    totalPersonas++;
                }
            }
        }

        System.out.println("Total de personas registradas: " + totalPersonas);
    }

    public void eliminarPersona(int fila, int columna) {
    int posEliminar = fila * this.columna + columna;
    int totalPersonas = indiceF * this.columna + indiceC;

    if (posEliminar >= totalPersonas || MatrizPersona[fila][columna] == null) {
        System.out.println("Error: La posición [" + fila + "][" + columna + "] no es válida o está vacía.");
        return;
    }

    System.out.println("Persona eliminada: " + MatrizPersona[fila][columna]);
    MatrizPersona[fila][columna] = null;

    // Desplaza personas hacia atrás
    for (int k = posEliminar + 1; k < totalPersonas; k++) {
        int origenF = k / columna;
        int origenC = k % columna;
        int destinoF = (k - 1) / columna;
        int destinoC = (k - 1) % columna;

        MatrizPersona[destinoF][destinoC] = MatrizPersona[origenF][origenC];
        MatrizPersona[origenF][origenC] = null;
    }

    // Actualiza índices
    if (indiceC == 0) {
        indiceF--;
        indiceC = columna - 1;
    } else {
        indiceC--;
    }
    }

    public int buscarPersona(String nombre) {
        for (int i = 0; i <= this.indiceF; i++) {
            for (int j = 0; j <= this.indiceC; j++) {
                if (this.MatrizPersona[i][j] != null &&
                        this.MatrizPersona[i][j].getNombre().equalsIgnoreCase(nombre)) {
                    System.out.println(this.MatrizPersona[i][j]);
                    System.out.println("Persona encontrada en la posición: Fila " + i + ", Columna " + j);
                    return i;
                }
            }
        }
        return -1;
    }

    public float promedioPeso() {
        float sumaPeso = 0;
        int contador = 0;

        for (int i = 0; i <= this.indiceF; i++) {
            for (int j = 0; j <= this.indiceC; j++) {
                if (this.MatrizPersona[i][j] != null) {
                    sumaPeso += this.MatrizPersona[i][j].getPeso();
                    contador++;
                }
            }
        }

        return (contador > 0) ? sumaPeso / contador : 0;
    }

    public double promedioEstatura() {

        double sumaEstatura = 0;
        int contador = 0;

        for (int i = 0; i <= this.indiceF; i++) {
            for (int j = 0; j <= this.indiceC; j++) {
                if (this.MatrizPersona[i][j] != null) {
                    sumaEstatura += this.MatrizPersona[i][j].getEstatura();
                    contador++;

                }
            }

        }

        return (contador > 0) ? sumaEstatura / contador : 0;
    }

    public void promedioEstaturaYPeso() {
        double promedioEstatura = promedioEstatura();
        double promedioPeso = promedioPeso();

        System.out.println("Promedio de Estatura: " + promedioEstatura + " cm");
        System.out.println("Promedio de Peso: " + promedioPeso + " kg");
    }
}

/*
 * hacer 2 metodos en el cual la matriz principal sume los pesos y me devuelva
 * el promedo de peso
 * y otro metodo que sume las estaturas y me devuelva el promedio de estatura
 * 
 * y crear un menu para matrices y otro para metodos
 */
