package estructurasDatos;

import java.util.Random;

public class Codigos {
    // Método para generar un código compuesto por una letra y un número aleatorio
    public static String generarCodigo(String motivo, String especialidad) {
        // Letras disponibles para el código
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // Generar un número aleatorio entre 0 y 25 para seleccionar una letra
        Random random = new Random();
        int indiceLetra = random.nextInt(letras.length());
        char letra = letras.charAt(indiceLetra);

        // Generar un número aleatorio de 3 dígitos
        int numero = random.nextInt(900) + 100;

        // Concatenar la letra, el motivo y la especialidad para formar el código
        String codigo = letra + "-" + motivo.toUpperCase() + "-" + especialidad.toUpperCase() + "-" + numero;

        return codigo;
    }
}
