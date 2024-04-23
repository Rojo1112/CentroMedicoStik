package estructurasDatos.interfaces;

public interface Lista<T> {
    void agregarAlInicio(T valor);

    void agregarAlFinal(T valor);

    T eliminarDelInicio();

    T eliminarDelFinal();

    boolean estaVacia();

    int tamano();

    void insertarEnMedio(int posicion, T valor);

    T eliminarEnMedio(int posicion);

    int buscarElemento(T valor);

    void mostrarLista();

    T obtenerElementoEnPosicion(int posicion);

    void eliminar(T valor);
    // Métodos adicionales según necesidad...
}
