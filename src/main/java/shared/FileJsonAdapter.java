package shared;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import estructurasDatos.Listas.Cola;
import estructurasDatos.Listas.ListaDoblementeEnlazada;
import estructurasDatos.Listas.Pila;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileJsonAdapter<E> {
    private final Object fileWriterLock;

    private FileJsonAdapter() {

        this.fileWriterLock = new Object();
    }

    public static synchronized <E> FileJsonAdapter<E> getInstance() {
        return new FileJsonAdapter<>();
    }

    public ListaDoblementeEnlazada<E> getObjects(String pathFile, Class<E[]> classOfT) {
        ListaDoblementeEnlazada<E> objList = new ListaDoblementeEnlazada<>();
        try {
            Gson gson = new GsonBuilder().create();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));
            E[] objArray = gson.fromJson(bufferedReader, classOfT);
            if (objArray != null) {
                for (E obj : objArray) {
                    objList.agregarAlFinal(obj);
                }
            }
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return objList;
    }

    public Boolean writeObjects(String pathFile, ListaDoblementeEnlazada<E> objects) {
        boolean successful = false;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(pathFile)) {
            synchronized (fileWriterLock) {
                // Limpiar el archivo (eliminar todos los objetos)
                writer.write(""); // Esto eliminará todo el contenido del archivo

                // Escribir los nuevos objetos
                gson.toJson(objects.toArray(), writer);

                successful = true;
            }
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return successful;
    }


    public Pila<E> getObjectsStack(String pathFile, Class<E[]> classOfT) {
        Pila<E> objStack = new Pila<>();
        try {
            Gson gson = new GsonBuilder().create();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));
            E[] objArray = gson.fromJson(bufferedReader, classOfT);
            if (objArray != null) {
                for (E obj : objArray) {
                    objStack.push(obj); // Agregar objetos al StackList
                }
            }
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return objStack;
    }

    public Boolean writeObjectsStack(String pathFile, Pila<E> objects) {
        boolean successful = false;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(pathFile)) {
            synchronized (fileWriterLock) {
                // Limpiar el archivo (eliminar todos los objetos)
                writer.write(""); // Esto eliminará todo el contenido del archivo

                // Escribir los nuevos objetos
                gson.toJson(objects.toArray(), writer);

                successful = true;
            }
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return successful;
    }

    public Cola<E> getObjectsQueue(String pathFile, Class<E[]> classOfT) {
        Cola<E> objQueue = new Cola<>();
        try {
            Gson gson = new GsonBuilder().create();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));
            E[] objArray = gson.fromJson(bufferedReader, classOfT);
            if (objArray != null) {
                for (E obj : objArray) {
                    objQueue.enqueue(obj); // Agregar objetos a la cola
                }
            }
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return objQueue;
    }

    public Boolean writeObjectsQueue(String pathFile, Cola<E> objects) {
        boolean successful = false;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(pathFile)) {
            synchronized (fileWriterLock) {
                // Limpiar el archivo (eliminar todos los objetos)
                writer.write(""); // Esto eliminará todo el contenido del archivo

                // Escribir los nuevos objetos
                gson.toJson(objects.toArray(), writer);

                successful = true;
            }
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return successful;
    }
}