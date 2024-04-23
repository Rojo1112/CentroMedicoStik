package model.modulmain.paciente;

import java.util.Objects;
import estructurasDatos.Listas.ListaDoblementeEnlazada;
import model.Documento;
import model.modulmain.cita.Cita;

public class Paciente {
    private Documento Documento;
    private String id;
    private String nombre;
    private String apellido;
    private String edad;
    private String telefono;
    private String email;
    private ListaDoblementeEnlazada<Cita> citasHistorial; // Historial de citas del paciente

    public Paciente(Documento Documento, String id, String nombre, String apellido, String edad, String telefono, String email) {
        this.Documento = Documento;
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.email = email;
        this.citasHistorial = new ListaDoblementeEnlazada<>();
    }

    // Método para agregar una cita al historial de citas del paciente
    public void agregarCita(Cita cita) {
        citasHistorial.agregarAlFinal(cita);
    }

    public Documento getTipoDocumento() {
        return Documento;
    }

    public void setTipoDocumento(Documento tipoDocumento) {
        this.Documento = tipoDocumento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ListaDoblementeEnlazada<Cita> getHistorialCitas() {
        return citasHistorial;
    }

    public void setCitasHistorial(ListaDoblementeEnlazada<Cita> citasHistorial) {
        this.citasHistorial = citasHistorial;
    }

    //Para poder modificar el Paciente

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(id, paciente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "tipoDocumento=" + Documento +
                ", id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad='" + edad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + email + '\'' +
                ", historialCitas=" + citasHistorial +
                '}';
    }
}
