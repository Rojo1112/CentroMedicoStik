package estructurasDatos.Listas;

import estructurasDatos.interfaces.Lista;

// Definición de la clase ListaDoblementeEnlazada que implementa la interfaz Lista<T>
public class ListaDoblementeEnlazada<T> implements Lista<T> {

    // Atributos privados cabeza, cola y tamaño de la lista
    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private int tamano;

    // Constructor de la clase ListaDoblementeEnlazada, inicializa los atributos
    public ListaDoblementeEnlazada() {
        cabeza = null;
        cola = null;
        tamano = 0;
    }

    // Método para agregar un elemento al inicio de la lista
    @Override
    public void agregarAlInicio(T valor) {
        // Crea un nuevo nodo con el valor, apuntando al siguiente nodo como cabeza y al anterior como nulo
        Nodo<T> nuevoNodo = new Nodo<>(valor, cabeza, null);
        // Si la cabeza no es nula, establece su nodo anterior como el nuevo nodo
        if (cabeza != null) {
            cabeza.setAnterior(nuevoNodo);
        }
        // Actualiza la cabeza como el nuevo nodo
        cabeza = nuevoNodo;
        // Si la cola es nula, también se actualiza como el nuevo nodo
        if (cola == null) {
            cola = nuevoNodo;
        }
        // Incrementa el tamaño de la lista
        tamano++;
    }

    // Método para agregar un elemento al final de la lista
    @Override
    public void agregarAlFinal(T valor) {
        // Crea un nuevo nodo con el valor, apuntando al siguiente nodo como nulo y al anterior como la cola actual
        Nodo<T> nuevoNodo = new Nodo<>(valor, null, cola);
        // Si la cola no es nula, establece su siguiente nodo como el nuevo nodo
        if (cola != null) {
            cola.setSiguiente(nuevoNodo);
        }
        // Actualiza la cola como el nuevo nodo
        cola = nuevoNodo;
        // Si la cabeza es nula, también se actualiza como el nuevo nodo
        if (cabeza == null) {
            cabeza = nuevoNodo;
        }
        // Incrementa el tamaño de la lista
        tamano++;
    }

    // Método para eliminar el primer elemento de la lista y devolver su valor
    @Override
    public T eliminarDelInicio() {
        // Verifica si la lista está vacía
        if (estaVacia()) {
            throw new IllegalStateException("La lista está vacía");
        }
        // Obtiene el valor del primer nodo
        T valorEliminado = cabeza.getValor();
        // Actualiza la cabeza como el siguiente nodo
        cabeza = cabeza.getSiguiente();
        // Si la cabeza no es nula, establece su nodo anterior como nulo
        if (cabeza != null) {
            cabeza.setAnterior(null);
        } else { // Si la cabeza es nula, también actualiza la cola como nula
            cola = null;
        }
        // Decrementa el tamaño de la lista
        tamano--;
        // Retorna el valor eliminado
        return valorEliminado;
    }

    // Método para eliminar el último elemento de la lista y devolver su valor
    @Override
    public T eliminarDelFinal() {
        // Verifica si la lista está vacía
        if (estaVacia()) {
            throw new IllegalStateException("La lista está vacía");
        }
        // Obtiene el valor del último nodo
        T valorEliminado = cola.getValor();
        // Actualiza la cola como el nodo anterior al último
        cola = cola.getAnterior();
        // Si la cola no es nula, establece su siguiente nodo como nulo
        if (cola != null) {
            cola.setSiguiente(null);
        } else { // Si la cola es nula, también actualiza la cabeza como nula
            cabeza = null;
        }
        // Decrementa el tamaño de la lista
        tamano--;
        // Retorna el valor eliminado
        return valorEliminado;
    }

    // Método para insertar un elemento en una posición específica de la lista
    @Override
    public void insertarEnMedio(int posicion, T valor) {
        // Verifica si la posición está dentro del rango válido
        if (posicion < 0 || posicion > tamano) {
            throw new IllegalArgumentException("Índice fuera de rango: " + posicion);
        }
        // Si la posición es 0, agrega el elemento al inicio de la lista
        if (posicion == 0) {
            agregarAlInicio(valor);
        } else if (posicion == tamano) { // Si la posición es igual al tamaño, agrega el elemento al final de la lista
            agregarAlFinal(valor);
        } else {
            Nodo<T> nodoActual;
            // Si la posición está más cerca del inicio de la lista, comienza desde la cabeza
            if (posicion < tamano / 2) {
                nodoActual = cabeza;
                for (int i = 0; i < posicion; i++) {
                    nodoActual = nodoActual.getSiguiente();
                }
            } else { // Si la posición está más cerca del final de la lista, comienza desde la cola
                nodoActual = cola;
                for (int i = tamano - 1; i > posicion; i--) {
                    nodoActual = nodoActual.getAnterior();
                }
            }
            // Crea un nuevo nodo con el valor, apuntando al nodo actual y su nodo anterior
            Nodo<T> nuevoNodo = new Nodo<>(valor, nodoActual, nodoActual.getAnterior());
            // Establece los enlaces del nodo anterior y siguiente para insertar el nuevo nodo en medio
            nodoActual.getAnterior().setSiguiente(nuevoNodo);
            nodoActual.setAnterior(nuevoNodo);
            // Incrementa el tamaño de la lista
            tamano++;
        }
    }

    // Método para eliminar un elemento en una posición específica de la lista y devolver su valor
    @Override
    public T eliminarEnMedio(int posicion) {
        // Verifica si la posición está dentro del rango válido
        if (posicion < 0 || posicion >= tamano()) {
            throw new IndexOutOfBoundsException("Posición fuera de rango");
        }
        // Si la posición es 0, elimina el primer elemento de la lista
        if (posicion == 0) {
            return eliminarDelInicio();
        } else if (posicion == tamano() - 1) { // Si la posición es igual al tamaño - 1, elimina el último elemento de la lista
            return eliminarDelFinal();
        } else {
            // Busca el nodo en la posición deseada
            Nodo<T> actual = cabeza;
            for (int i = 0; i < posicion; i++) {
                actual = actual.getSiguiente();
            }
            // Establece los enlaces del nodo anterior y siguiente para omitir el nodo actual
            actual.getAnterior().setSiguiente(actual.getSiguiente());
            actual.getSiguiente().setAnterior(actual.getAnterior());
            // Decrementa el tamaño de la lista
            tamano--;
            // Retorna el valor del nodo eliminado
            return actual.getValor();
        }
    }

    // Método para buscar un elemento en la lista y devolver su posición
    @Override
    public int buscarElemento(T valor) {
        // Inicializa la posición en 0 y el nodo actual como la cabeza de la lista
        int posicion = 0;
        Nodo<T> nodoActual = cabeza;
        // Recorre la lista
        while (nodoActual != null) {
            // Si el valor del nodo actual coincide con el valor buscado, retorna la posición
            if (nodoActual.getValor().equals(valor)) {
                return posicion;
            }
            // Avanza al siguiente nodo y aumenta la posición
            nodoActual = nodoActual.getSiguiente();
            posicion++;
        }
        // Si no se encuentra el valor, retorna -1
        return -1;
    }

    // Método para obtener el tamaño de la lista
    @Override
    public int tamano() {
        return tamano;
    }

    // Método para verificar si la lista está vacía
    @Override
    public boolean estaVacia() {
        return tamano == 0;
    }

    // Método para mostrar todos los elementos de la lista
    @Override
    public void mostrarLista() {
        // Si la lista está vacía, imprime un mensaje y retorna
        if (estaVacia()) {
            System.out.println("La lista está vacía");
            return;
        }
        // Inicializa el nodo actual como la cabeza de la lista
        Nodo<T> nodoActual = cabeza;
        // Recorre la lista e imprime los valores de los nodos
        while (nodoActual != null) {
            System.out.print(nodoActual.getValor() + " ");
            nodoActual = nodoActual.getSiguiente();
        }
        // Imprime un salto de línea al final
        System.out.println();
    }

    // Método para obtener el elemento en una posición específica de la lista
    @Override
    public T obtenerElementoEnPosicion(int posicion) {
        // Verifica si la posición está dentro del rango válido
        if (posicion < 0 || posicion >= tamano) {
            throw new IndexOutOfBoundsException("Posición fuera de rango: " + posicion);
        }
        // Inicializa el nodo actual
        Nodo<T> nodoActual;
        // Si la posición está más cerca del inicio de la lista, comienza desde la cabeza
        if (posicion < tamano / 2) {
            nodoActual = cabeza;
            for (int i = 0; i < posicion; i++) {
                nodoActual = nodoActual.getSiguiente();
            }
        } else { // Si la posición está más cerca del final de la lista, comienza desde la cola
            nodoActual = cola;
            for (int i = tamano - 1; i > posicion; i--) {
                nodoActual = nodoActual.getAnterior();
            }
        }
        // Retorna el valor del nodo en la posición deseada
        return nodoActual.getValor();
    }

    // Método para eliminar todas las ocurrencias de un elemento en la lista
    @Override
    public void eliminar(T valor) {
        // Inicializa el nodo actual como la cabeza de la lista
        Nodo<T> nodoActual = cabeza;
        // Recorre la lista
        while (nodoActual != null) {
            // Si el valor del nodo actual coincide con el valor a eliminar
            if (nodoActual.getValor().equals(valor)) {
                // Si el nodo actual es la cabeza de la lista
                if (nodoActual == cabeza) {
                    cabeza = nodoActual.getSiguiente();
                    // Si la cabeza no es nula, establece su anterior como nulo
                    if (cabeza != null) {
                        cabeza.setAnterior(null);
                    }
                } else if (nodoActual == cola) { // Si el nodo actual es la cola de la lista
                    cola = nodoActual.getAnterior();
                    // Si la cola no es nula, establece su siguiente como nulo
                    if (cola != null) {
                        cola.setSiguiente(null);
                    }
                } else {
                    // Actualiza los enlaces del nodo anterior y siguiente para omitir el nodo actual
                    nodoActual.getAnterior().setSiguiente(nodoActual.getSiguiente());
                    nodoActual.getSiguiente().setAnterior(nodoActual.getAnterior());
                }
                // Disminuye el tamaño de la lista
                tamano--;
            }
            // Avanza al siguiente nodo
            nodoActual = nodoActual.getSiguiente();
        }
    }

    //Metodo toArray() para convertir la lista en un arreglo
    public T[] toArray() {
        T[] arreglo = (T[]) new Object[tamano];
        Nodo<T> actual = cabeza;
        for (int i = 0; i < tamano; i++) {
            arreglo[i] = actual.getValor();
            actual = actual.getSiguiente();
        }
        return arreglo;
    }

    // Clase interna Nodo que representa los nodos de la lista
    private static class Nodo<T> {
        // Atributos valor, siguiente y anterior
        T valor;
        Nodo<T> siguiente;
        Nodo<T> anterior;

        // Constructores de Nodo
        public Nodo(T valor) {
            this(valor, null, null);
        }

        public Nodo(T valor, Nodo<T> siguiente, Nodo<T> anterior) {
            this.valor = valor;
            this.siguiente = siguiente;
            this.anterior = anterior;
        }

        // Métodos getter y setter para los atributos
        public T getValor() {
            return valor;
        }

        public Nodo<T> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<T> siguiente) {
            this.siguiente = siguiente;
        }

        public Nodo<T> getAnterior() {
            return anterior;
        }

        public void setAnterior(Nodo<T> anterior) {
            this.anterior = anterior;
        }
    }
}