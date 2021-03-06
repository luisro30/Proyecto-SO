/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Shadow
 */
public class Lista {

    private nodo inicio;
    private nodo ultimo;
    private int tamanio;

    public Lista() {
        inicio = null;
        ultimo = null;
        tamanio = 0;
    }

    public boolean esVacia() {
        return inicio == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void agregarAlInicio(int numero, int tamaño, int duracion) {
        // Define un nuevo nodo.
        nodo nuevo = new nodo();
        nuevo.setNumero(numero);
        nuevo.setDuracion(duracion);
        nuevo.setTamaño(tamaño);
        if (esVacia()) {
            inicio = nuevo;
            ultimo = nuevo;
            ultimo.setSiguiente(inicio);
        } else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
            ultimo.setSiguiente(inicio);
        }
        tamanio++;
    }
}
