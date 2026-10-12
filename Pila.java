
package org.example;

public class Pila {

    private Nodo top;
    private int cantidad;

    public Pila() {
        top = null;
        cantidad = -1;
    }

    public boolean estaVacia() {
        return top == null;
    }

    public void push(String valor, String tipo) {

        Nodo nuevoNodo = new Nodo(valor, tipo, top);

        top = nuevoNodo;
        cantidad++;
    }

    public Nodo pop() {

        if (estaVacia()) {
            return null;
        }

        Nodo nodoEliminado = top;

        top = top.getSiguiente();

        nodoEliminado.setSiguiente(null);

        cantidad--;

        return nodoEliminado;
    }

    public Nodo peek() {

        if (estaVacia()) {
            return null;
        }

        return top;
    }

    public int getCantidad() {
        return cantidad;
    }
}
