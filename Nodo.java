
package org.example;

public class Nodo {

    private final String valor;
    private final String tipo;
    private Nodo siguiente;

    public Nodo(String valor, String tipo) {
        this.valor = valor;
        this.tipo = tipo;
        this.siguiente = null;
    }

    public Nodo(String valor, String tipo, Nodo siguiente) {
        this.valor = valor;
        this.tipo = tipo;
        this.siguiente = siguiente;
    }

    public String getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Token{" +
                "valor='" + valor + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
