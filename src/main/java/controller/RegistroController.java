package controller;
import model.citasM.Examen;
import model.modulmain.paciente.Paciente;
import model.RegistroExamen;
import model.repository.RegistroRepository;


public class RegistroController {

    public RegistroRepository registroExamenRepository;
    private  PacientesController  pacientesController = new PacientesController();

    public RegistroController() {
        this.registroExamenRepository = new RegistroRepository();
        this.pacientesController = new PacientesController();
    }

    public boolean validarIdPaciente(String idPaciente) {
        Paciente paciente = pacientesController.buscarPacientePorId(idPaciente);
        // Verificar si el paciente es null antes de intentar acceder a sus propiedades
        if (paciente != null) {
            // Realizar otras operaciones con el paciente si es necesario
            return true;
        } else {
            System.out.println("El paciente con id " + idPaciente + " no existe.");
            return false;
        }
    }

    public void agregarExamen(Examen motivoCitaExamen, String idPaciente) {
        boolean autorizado = false;
        if (!validarIdPaciente(idPaciente)) {
            System.out.println("El paciente con id " + idPaciente + " no existe, el examen no fue registrado");
            return;
        }
        RegistroExamen registroExamen = new RegistroExamen(motivoCitaExamen, idPaciente);
        registroExamenRepository.añadirNuevoRegistroExamen(registroExamen);
        System.out.println("Examen registrado: " + registroExamen.getRadicadoExamen());

        // Aquí podrías realizar más lógica relacionada con la creación o manipulación de registros de examen
    }

    //Metodo para cambiar el boolean autorizado a true



}
