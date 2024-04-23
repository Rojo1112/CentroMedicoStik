package estructurasDatos.Listas;

import estructurasDatos.interfaces.InterfaceCola;

import java.util.EmptyStackException;

// Declaración de la clase Cola que implementa la interfaz InterfaceCola
public class Cola<T> implements InterfaceCola<T> {

    private Nodo<T> frente;   // Declaración del atributo frente de tipo Nodo<T>
    private Nodo<T> fin;      // Declaración del atributo fin de tipo Nodo<T>
    private int tamaño;       // Declaración del atributo tamaño de tipo entero

    // Constructor de la clase Cola
    public Cola() {
        frente = null;    // Inicialización de frente como nulo
        fin = null;       // Inicialización de fin como nulo
        tamaño = 0;       // Inicialización del tamaño como 0
    }

    // Método para agregar un elemento al final de la cola
    @Override
    public void enqueue(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);  // Creación de un nuevo nodo con el elemento
        if (isEmpty()) {                           // Verificación si la cola está vacía
            frente = nuevoNodo;                    // Si está vacía, el nuevo nodo es tanto el frente como el fin
        } else {
            fin.setSiguiente(nuevoNodo);           // Si no está vacía, el nuevo nodo se enlaza al final de la cola
        }
        fin = nuevoNodo;                           // El nuevo nodo se convierte en el nuevo fin de la cola
        tamaño++;                                  // Incremento del tamaño de la cola
    }

    // Método para remover y retornar el elemento al frente de la cola
    @Override
    public T dequeue() {
        if (isEmpty()) {                          // Verificación si la cola está vacía
            throw new EmptyStackException();      // Lanza una excepción EmptyStackException si la cola está vacía
        }
        T valorEliminado = frente.getValor();     // Obtiene el valor del nodo en el frente de la cola
        frente = frente.getSiguiente();            // Avanza el frente al siguiente nodo
        if (frente == null) {                      // Si el frente llega a ser nulo, la cola está vacía
            fin = null;                           // Por lo tanto, también el fin se vuelve nulo
        }
        tamaño--;                                 // Decremento del tamaño de la cola
        return valorEliminado;                    // Retorna el valor eliminado
    }

    // Método para retornar el elemento al frente de la cola sin removerlo
    @Override
    public T peek() {
        if (isEmpty()) {                          // Verificación si la cola está vacía
            throw new EmptyStackException();      // Lanza una excepción EmptyStackException si la cola está vacía
        }
        return frente.getValor();                 // Retorna el valor del nodo en el frente de la cola
    }

    // Método para verificar si la cola está vacía
    @Override
    public boolean isEmpty() {
        return tamaño == 0;                       // Retorna verdadero si el tamaño de la cola es 0, falso de lo contrario
    }

    // Método para retornar el tamaño actual de la cola
    @Override
    public int size() {
        return tamaño;                            // Retorna el tamaño de la cola
    }

    //toArray
    public Object[] toArray() {
        Object[] array = new Object[size()];  // Corregido: tamaño() -> size()
        Nodo<T> temp = frente;
        for (int i = 0; i < array.length; i++) {
            array[i] = temp.getValor();  // Corregido: getElemento() -> getValor()
            temp = temp.getSiguiente();
        }
        return array;
    }

    // Clase interna Nodo
    private static class Nodo<T> {
        private T valor;                          // Declaración del atributo valor de tipo T
        private Nodo<T> siguiente;                // Declaración del atributo siguiente de tipo Nodo<T>

        // Constructor de la clase Nodo
        public Nodo(T valor) {
            this.valor = valor;                   // Asignación del valor del nodo
            this.siguiente = null;                // Inicialización del siguiente nodo como nulo
        }

        // Métodos getter y setter para el atributo valor
        public T getValor() {
            return valor;                         // Retorna el valor del nodo
        }

        public void setValor(T valor) {
            this.valor = valor;                   // Asigna un nuevo valor al nodo
        }

        // Métodos getter y setter para el atributo siguiente
        public Nodo<T> getSiguiente() {
            return siguiente;                     // Retorna el siguiente nodo
        }

        public void setSiguiente(Nodo<T> siguiente) {
            this.siguiente = siguiente;           // Asigna el siguiente nodo
        }
    }
}
