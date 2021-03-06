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
//    private nodo ultimo;
    private int tamanio;

    public Lista() {
        inicio = null;
//        ultimo = null;
        tamanio = 0;
    }

    public boolean esVacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public int getTamanio() {
        return tamanio;
    }

    public void insertar(int numero, int duracion) {
        // Define un nuevo nodo.
        nodo nuevo = new nodo();
        nuevo.setNumero(numero);
        nuevo.setDuracion(duracion);
//        nuevo.setTamaño(tamaño);
        if (esVacia()) {
            inicio = nuevo;
            tamanio++;
//            ultimo = nuevo;
//            ultimo.setSiguiente(inicio);
        } else {
            nodo insertar = inicio;
            for (int i = 1; i < tamanio; i++) {
                insertar = insertar.getSiguiente();
            }
            insertar.setSiguiente(nuevo);
            tamanio++;
//            inicio = nuevo;
//            ultimo.setSiguiente(inicio);
        }
//        tamanio++;
    }

    public nodo getInicio() {
        return inicio;
    }

//    public nodo getUltimo() {
//        return ultimo;
//    }

    public void mostrar() {
        nodo aux = inicio;
        if (inicio != null) {
            for (int i = 0; i <= tamanio; i++) {
                System.out.println("P" + aux.getNumero() + " Tejec" + aux.getDuracion());
                if (aux.getSiguiente() == null) {
                    break;
                }
                aux = aux.getSiguiente();
            }
        } else {
            System.out.println("No hay elementos para mostrar");
        }
    }
}
