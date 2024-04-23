package estructurasDatos.Listas;

import estructurasDatos.interfaces.InterfacePila;

import java.util.EmptyStackException;

public class Pila<T> implements InterfacePila<T> {

    private Nodo<T> cabeza;// Declaración del atributo cabeza de tipo Nodo<T>
    private int tamaño;

    // Constructor de la clase Pila
    public Pila() {
        cabeza = null;// Inicialización de cabeza como nulo
        tamaño = 0;// Inicialización del tamaño como 0
    }

    // Método para agregar un elemento a la pila
    @Override
    public void push(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento); // Creación de un nuevo nodo con el elemento
        nuevoNodo.setSiguiente(cabeza);// Establecimiento del siguiente nodo como la cabeza actual
        cabeza = nuevoNodo;// Actualización de la cabeza como el nuevo nodo
        tamaño++;// Incremento del tamaño de la pila
    }

    // Método para remover y retornar el elemento más reciente de la pila
    @Override
    public T pop() {
        if (isEmpty()) {// Verificación si la pila está vacía
            throw new EmptyStackException();// Lanza una excepción EmptyStackException si la pila está vacía
        }
        T valorEliminado = cabeza.getValor();// Obtiene el valor del nodo en la cabeza
        cabeza = cabeza.getSiguiente();// Establece el siguiente nodo como la nueva cabeza
        tamaño--;// Decrementa el tamaño de la pila
        return valorEliminado;// Retorna el valor eliminado
    }

    // Método para retornar el elemento más reciente de la pila sin removerlo
    @Override
    public T peek() {
        if (isEmpty()) {// Verificación si la pila está vacía
            throw new EmptyStackException();// Lanza una excepción EmptyStackException si la pila está vacía
        }
        return cabeza.getValor();// Retorna el valor del nodo en la cabeza
    }

    // Método para verificar si la pila está vacía
    @Override
    public boolean isEmpty() {
        return tamaño == 0;// Retorna verdadero si el tamaño de la pila es 0, falso de lo contrario
    }

    // Método para retornar el tamaño actual de la pila
    @Override
    public int size() {
        return tamaño;// Retorna el tamaño de la pila
    }

    @Override
    public T[] toArray() {
        int size = size(); // Calcular el tamaño de la pila
        T[] array = (T[]) new Object[size]; // Crear un arreglo del tamaño de la pila
        Nodo<T> temp = cabeza; // Nodo temporal para recorrer la pila
        int index = 0;

        // Recorrer la pila y agregar los elementos al arreglo
        while (temp != null) {
            array[index++] = temp.getValor();
            temp = temp.getSiguiente();
        }

        return array;
    }

    // Clase interna Nodo
    private static class Nodo<T> {
        private T valor;
        private Nodo<T> siguiente;

        // Constructor de la clase Nodo
        public Nodo(T valor) {
            this.valor = valor;
            this.siguiente = null;
        }

        public T getValor() {
            return valor;
        }

        public void setValor(T valor) {
            this.valor = valor;
        }

        public Nodo<T> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<T> siguiente) {
            this.siguiente = siguiente;
        }
    }
}
