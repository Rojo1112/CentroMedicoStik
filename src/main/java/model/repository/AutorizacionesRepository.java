package model.repository;

import estructurasDatos.Listas.ListaDoblementeEnlazada;
import estructurasDatos.Listas.Pila;
import model.RegistroExamen;
import shared.FileJsonAdapter;

public class AutorizacionesRepository {

    private final FileJsonAdapter<RegistroExamen> jsonAdapterAutorizacion;
    private final String pathFile;
    private Pila<RegistroExamen> examenesPorAutorizar;

    /**
     * Constructor de la clase AutorizacionesRepository
     */
    public AutorizacionesRepository() {
        this.pathFile = "src/main/java/dataBase/Autorizacion.Json";
        this.jsonAdapterAutorizacion = FileJsonAdapter.getInstance();
        this.examenesPorAutorizar = jsonAdapterAutorizacion.getObjectsStack(pathFile, RegistroExamen[].class);
    }

    public Pila<RegistroExamen> obtenerTodos() {
        return examenesPorAutorizar;
    }

    public void agregarNuevoRegistroExamenAPila(RegistroExamen nuevoRegistroExamen) {
        examenesPorAutorizar.push(nuevoRegistroExamen);
        jsonAdapterAutorizacion.writeObjectsStack(pathFile, examenesPorAutorizar);
    }

    public void eliminarRegistroExamenPila() {
        if (!examenesPorAutorizar.isEmpty()) {
            examenesPorAutorizar.pop();
            jsonAdapterAutorizacion.writeObjectsStack(pathFile, examenesPorAutorizar);
        } else {
            System.out.println("La pila de exámenes por autorizar está vacía.");
        }
    }

    public void actualizarAutorizacionExamen() {
        if (!examenesPorAutorizar.isEmpty()) {
            RegistroExamen examen = examenesPorAutorizar.peek();
            examen.setAutorizado(true);
            examen.setNota("AUTORIZADO");
            jsonAdapterAutorizacion.writeObjectsStack(pathFile, examenesPorAutorizar);
        } else {
            System.out.println("La pila de exámenes por autorizar está vacía.");
        }
    }

    public RegistroExamen buscarPorAutorizado(boolean autorizado) {
        RegistroExamen registroAutorizado = null;
        ListaDoblementeEnlazada<RegistroExamen> tempList = new ListaDoblementeEnlazada<>();

        while (!examenesPorAutorizar.isEmpty()) {
            tempList.agregarAlInicio(examenesPorAutorizar.pop());
        }

        for (int i = 0; i < tempList.tamano(); i++) {
            RegistroExamen registro = tempList.obtenerElementoEnPosicion(i);
            if (registro != null && registro.isAutorizado() == autorizado) {
                registroAutorizado = registro;
                break;
            }
        }

        while (!tempList.estaVacia()) {
            examenesPorAutorizar.push(tempList.eliminarDelInicio());
        }

        return registroAutorizado;
    }
}