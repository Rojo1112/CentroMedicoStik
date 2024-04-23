package estructurasDatos.interfaces;

public interface InterfaceCola<T> {
    void enqueue(T elemento); // Agrega un elemento al final de la cola

    T dequeue(); // Remueve y retorna el elemento al frente de la cola

    T peek(); // Retorna el elemento al frente de la cola sin removerlo

    boolean isEmpty(); // Verifica si la cola está vacía

    int size(); // Retorna el tamaño actual de la cola
}