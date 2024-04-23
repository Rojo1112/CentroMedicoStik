package model;

import estructurasDatos.Codigos;
import model.citasM.Examen;

public class RegistroExamen {
    private String radicadoExamen;
    private Examen motivoCitaExamen;
    private boolean autorizado;
    private Codigos generadorCodigo = new Codigos(); // Inicializar la instancia de Codigos
    private String idPaciente;
    private String nota;

    public RegistroExamen(Examen motivoCitaExamen, String idPaciente) {
        this.radicadoExamen = generadorCodigo.generarIdentificador();
        this.autorizado = false; // Inicializar como no autorizado
        this.idPaciente = idPaciente;
        this.motivoCitaExamen = motivoCitaExamen;
        this.nota = "POR AUTORIZAR";
    }

    public String getRadicadoExamen() {
        return radicadoExamen;
    }

    public void setRadicadoExamen(String radicadoExamen) {
        this.radicadoExamen = radicadoExamen;
    }

    public Examen getMotivoCitaExamen() {
        return motivoCitaExamen;
    }

    public void setMotivoCitaExamen(Examen motivoCitaExamen) {
        this.motivoCitaExamen = motivoCitaExamen;
    }

    public boolean isAutorizado() {
        return autorizado;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "RegistroExamen{" +
                "radicadoExamen='" + radicadoExamen + '\'' +
                ", motivoCitaExamen=" + motivoCitaExamen +
                ", autorizado=" + autorizado +
                ", idPaciente='" + idPaciente + '\'' +
                ", nota='" + nota + '\'' +
                '}';
    }
}
