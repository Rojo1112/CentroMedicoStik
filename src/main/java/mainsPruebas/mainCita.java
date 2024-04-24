package mainsPruebas;

import controller.CitasController;
import estructurasDatos.Codigos;
import model.citasM.Control;
import model.modulmain.cita.Cita;

public class mainCita {
    public static void main(String[] args) {

        Codigos generadorCodigo = new Codigos();

        CitasController citasController = new CitasController();

        citasController.agendarCitaControlValoracion(new Cita("3","VALORACION","MEDICINA_GENERAL", "123456", true));
        citasController.agendarCitaControlValoracion(new Cita("2","VALORACION","DERMATOLOGIA", "123456", true));;

        //probar cita examen
    }
}
