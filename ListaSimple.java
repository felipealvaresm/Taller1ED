public class ListaSimple {
    private Nodo P, U, Q, T;

    public ListaSimple() {
        this.P = null;
        this.U = null;
        this.Q = null;
        this.T = null;
    }

    public ListaSimple(Persona Persona) {
        Nodo nuevo = new Nodo(Persona);
        this.P = nuevo;
        this.U = nuevo;
        this.Q = null;
        this.T = null;
    }

    public Nodo getP() {
        return P;
    }

    public void setP(Nodo p) {
        P = p;
    }

    public Nodo getU() {
        return U;
    }

    public void setU(Nodo u) {
        U = u;
    }

    public Nodo getQ() {
        return Q;
    }

    public void setQ(Nodo q) {
        Q = q;
    }

    public Nodo getT() {
        return T;
    }

    public void setT(Nodo t) {
        T = t;
    }

    public boolean ListaVacia() {
        if (this.P == null) {
            return true;
        } else {
            return false;
        }
    }

    public void agregarPersonaInicio(Persona p) {
        Nodo nuevo = new Nodo(p);
        if (ListaVacia()) {
            this.P = nuevo;
            this.U = nuevo;
        } else {
            this.U.setSiguiente(nuevo);
            this.U = nuevo;
        }
    }

    public void mostrarLista() {
        if (!ListaVacia()) {
            this.Q = this.P;
            while (this.Q != null) {
                System.out.println(this.Q.getDato());
                this.Q = this.Q.getSiguiente();
            }
        } else {
            System.out.println("La lista esta vacia");
        }
    }

    public int ContarNodos(){
        int contador=0;
        if (!ListaVacia()){
            this.Q=this.P;
            while (this.Q != null){
                contador++;
                this.Q=this.Q.getSiguiente();     
}
}
        return contador;
    }

}
