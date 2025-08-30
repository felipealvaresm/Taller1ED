/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// (Removed package declaration to match the expected package)

public class Persona {

    protected String nombre;
    protected String Apellido;
    protected int estatura;
    protected float peso;

    // Constructor
    public Persona(String nom, String Ape, int est, float pe) {

        this.nombre = nom;
        this.Apellido = Ape;
        this.estatura = est;
        this.peso = pe;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

}
