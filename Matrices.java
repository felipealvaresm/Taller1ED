public class Matrices {

    private int fila;
    private int columna;
    private Persona[][] MatrizPersona;
    int indiceF;
    int indiceC;

    public Matrices() {
    }

    public Matrices(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.indiceF = -1;
        this.indiceC = -1;
        this.MatrizPersona = new Persona[fila][columna];

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
        if (indiceF == fila - 1 && indiceC == columna - 1) {
            return true;
        } else {
            return false;
        }
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
            if (this.indiceC < this.columna - 1) {
                this.indiceC++;
                this.MatrizPersona[this.indiceF][this.indiceC] = p;
            } else {
                this.indiceF++;
                this.indiceC = 0;
                this.MatrizPersona[this.indiceF][this.indiceC] = p;
            }
        } else {
            System.out.println("La matriz esta llena, no se puede agregar mas personas");
        }
    }

    public void eliminarPersona(int fila, int columna) {
        if (fila >= 0 && fila <= indiceF && columna >= 0 && columna <= indiceC) {
            Persona personaEliminada = this.MatrizPersona[fila][columna];
            System.out.println(" Persona eliminada: " + personaEliminada);
            this.MatrizPersona[fila][columna] = null;

            // Reorganiza la matriz para llenar el espacio vacío
            for (int i = fila; i <= indiceF; i++) {
                for (int j = (i == fila ? columna : 0); j < columna; j++) {
                    if (i == indiceF && j == indiceC) {
                        this.MatrizPersona[i][j] = null;
                    } else if (j == columna - 1) {
                        this.MatrizPersona[i][j] = this.MatrizPersona[i + 1][0];
                    } else {
                        this.MatrizPersona[i][j] = this.MatrizPersona[i][j + 1];
                    }
                }
            }

            // Actualiza los índices
            if (indiceC == 0) {
                if (indiceF > 0) {
                    indiceF--;
                    indiceC = columna - 1;
                }
            } else {
                indiceC--;
            }

        } else {
            System.out.println("Posición inválida. No se puede eliminar.");
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

}

/*
 * hacer 2 metodos en el cual la matriz principal sume los pesos y me devuelva
 * el promedo de peso
 * y otro metodo que sume las estaturas y me devuelva el promedio de estatura
 * 
 * y crear un menu para matrices y otro para metodos
 */
