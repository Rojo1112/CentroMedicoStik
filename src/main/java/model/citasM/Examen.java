package model.citasM;

public enum Examen {

    EXAMEN_FISICO_INFANTIL("Examen físico infantil", "PEDIATRIA", "6000", "Dr. García", "Evaluación exhaustiva de la salud y desarrollo del niño, incluyendo mediciones de peso, altura, perímetro cefálico, y examen de sistemas como cardiovascular, respiratorio, digestivo, etc."),
    ELECTROCARDIOGRAMA("Electrocardiograma", "CARDIOLOGIA", "6000", "Dr. Martínez", "Registro de la actividad eléctrica del corazón para detectar problemas en el ritmo cardíaco, hipertrofia ventricular, isquemia, entre otros."),
    ECOCARDIOGRAFIA("Ecocardiografía", "CARDIOLOGIA", "6000", "Dra. Fernández", "Utilización de ultrasonido para producir imágenes en tiempo real del corazón y sus estructuras, útil para evaluar la función cardíaca, anomalías estructurales, etc."),
    DERMATOSCOPIA("Dermatoscopia", "DERMATOLOGIA", "6000", "Dr. Pérez", "Examen no invasivo de la piel que permite evaluar lesiones pigmentadas y no pigmentadas, útil para detectar melanomas, carcinomas, nevos, etc."),
    BIOPSIA_DE_PIEL("Biopsia de piel", "DERMATOLOGIA", "6000", "Dra. Rodríguez", "Extracción de una muestra de piel para su análisis en laboratorio, útil para diagnosticar enfermedades de la piel como cáncer, infecciones, etc."),
    ENTREVISTA_PSIQUIATRICA("Entrevista psiquiátrica", "PSIQUIATRIA", "6000", "Dr. Gómez", "Evaluación de la salud mental del paciente a través de una entrevista clínica, útil para diagnosticar trastornos psiquiátricos como depresión, ansiedad, esquizofrenia, etc."),
    ANALISIS_DE_COMPOSICION_CORPORAL("Análisis de composición corporal", "NUTRICION", "6000", "Dra. Sánchez", "Análisis de la composición corporal del paciente a través de mediciones de peso, altura, índice de masa corporal, porcentaje de grasa, etc., útil para evaluar el estado nutricional y diseñar un plan de alimentación adecuado."),
    LIMPIEZA_DENTAL("Limpieza dental", "ODONTOLOGIA", "6000", "Dr. Hernández", "Remoción de placa bacteriana y sarro de los dientes para prevenir enfermedades bucales como caries, gingivitis, periodontitis, etc."),
    ANALISIS_DE_SANGRE("Análisis de sangre (hemograma completo)", "MEDICINA_GENERAL", "5000", "Dra. Díaz", "Análisis de los componentes de la sangre como glóbulos rojos, glóbulos blancos, plaquetas, hemoglobina, etc., útil para diagnosticar anemias, infecciones, trastornos de coagulación, etc.");

    private final String tipoExamen;
    private final String especialidad;
    private final String costo;
    private final String profesionalAsignado;
    private final String descripcion;

    Examen(String tipoExamen, String especialidad, String costo, String profesionalAsignado, String descripcion) {
        this.tipoExamen = tipoExamen;
        this.especialidad = especialidad;
        this.costo = costo;
        this.profesionalAsignado = profesionalAsignado;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return " Examen" +
                ", tipoExamen='" + tipoExamen + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", costo='" + costo + '\'' +
                ", profesionalAsignado='" + profesionalAsignado + '\'' +
                ", breveDescripcion='" + descripcion;
    }
}
