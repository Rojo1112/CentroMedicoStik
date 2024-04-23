package model.repository;

import estructurasDatos.Listas.ListaDoblementeEnlazada;
import model.RegistroExamen;
import shared.FileJsonAdapter;

public class RegistroRepository {

    private final FileJsonAdapter<RegistroExamen> jsonAdapterRegistroExamen;
    private String pathFile;
    private ListaDoblementeEnlazada<RegistroExamen> registroExamenes;

    private final AutorizacionRepository autorizacionRepository;

    public RegistroRepository() {
        this.autorizacionRepository = new AutorizacionRepository();
        this.pathFile = "src/main/java/dataBase/RegistroExamen.Json";
        this.jsonAdapterRegistroExamen = FileJsonAdapter.getInstance();
        this.registroExamenes = jsonAdapterRegistroExamen.getObjects(pathFile, RegistroExamen[].class);
    }

    public ListaDoblementeEnlazada<RegistroExamen> obtenerTodos() {
        return registroExamenes;
    }

    public void añadirNuevoRegistroExamen(RegistroExamen nuevoRegistroExamen) {
        registroExamenes.agregarAlFinal(nuevoRegistroExamen);
        jsonAdapterRegistroExamen.writeObjects(pathFile, registroExamenes);
    }

    public ListaDoblementeEnlazada<RegistroExamen> buscarPorIdPaciente(String idPaciente) {
        // Implementación del método de búsqueda por ID del paciente
    }

    public RegistroExamen buscarPorRadicadoExamen(String radicadoExamen) {
        // Implementación del método de búsqueda por radicado de examen
    }

    public void eliminarExamen(RegistroExamen registroExamen) {
        int indice = registroExamenes.buscarElemento(registroExamen);
        if (indice != -1) {
            registroExamenes.eliminarEnMedio(indice);
            jsonAdapterRegistroExamen.writeObjects(pathFile, registroExamenes);
        } else {
            System.out.println("El registro de examen no se encontró en la lista.");
        }
    }

    public void actualizarAutorizacionExamen(RegistroExamen registroExamen) {
        int indice = registroExamenes.buscarElemento(registroExamen);
        if (indice != -1) {
            registroExamenes.eliminarEnMedio(indice);
            registroExamenes.agregarAlFinal(registroExamen); // Agrega el registro actualizado al final de la lista
            jsonAdapterRegistroExamen.writeObjects(pathFile, registroExamenes);
        } else {
            System.out.println("El registro de examen no se encontró en la lista.");
        }
    }
}
