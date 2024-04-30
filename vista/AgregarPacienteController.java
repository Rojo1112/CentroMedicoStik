package vista;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.modulmain.paciente.Paciente;
import model.repository.PacientesRepository;

public class AgregarPacienteController implements Initializable {

    @FXML
    private TextField idField;
    @FXML
    private TextField nombreField;
    @FXML
    private Button continuar;

    private PacientesRepository pacientesRepository;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pacientesRepository = new PacientesRepository();
    }    

    @FXML
    private void agregarPaciente(ActionEvent event) {
        String id = idField.getText();
        String nombre = nombreField.getText();
        
        if (!id.isEmpty() && !nombre.isEmpty()) {
            Paciente nuevoPaciente = new Paciente(id, nombre);
            pacientesRepository.añadirNuevoPaciente(nuevoPaciente);
            
            // Limpiar campos después de agregar el paciente
            idField.clear();
            nombreField.clear();
            
            mostrarMensaje("Paciente agregado correctamente.", Alert.AlertType.INFORMATION);
        } else {
            mostrarMensaje("Por favor, complete todos los campos.", Alert.AlertType.WARNING);
        }
    }

    @FXML
    private void continuarabuscar(ActionEvent event) {
        // Lógica para continuar con la búsqueda de pacientes
    }

    private void mostrarMensaje(String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
