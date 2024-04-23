package mainsPruebas;

import model.modulmain.cita.Cita;

public class mainCita {
    public static void main(String[] args) {
        // Crear una nueva cita
        Cita cita = new Cita("ID123", "CONTROL", "MEDICINA_GENERAL", "Dr. García", true);

        // Mostrar los detalles de la cita
        System.out.println("Detalles de la cita:");
        System.out.println(cita);

        // Cambiar el estado de pago de la cita
        cita.setPagado(false);

        // Mostrar los detalles actualizados de la cita
        System.out.println("Detalles actualizados de la cita:");
        System.out.println(cita);
    }
}
