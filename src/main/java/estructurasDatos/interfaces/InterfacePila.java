package estructurasDatos.interfaces;

public interface InterfacePila<T> {
    void push(T elemento); // Agrega un elemento a la pila

    T pop(); // Remueve y retorna el elemento más reciente de la pila

    T peek(); // Retorna el elemento más reciente de la pila sin removerlo

    boolean isEmpty(); // Verifica si la pila está vacía

    int size(); // Retorna el tamaño actual de la pila

    T[] toArray();
}