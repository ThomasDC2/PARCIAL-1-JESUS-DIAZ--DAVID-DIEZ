package co.edu.uniquindio.poo.parcial1.repository;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/** Base común para almacenar registros en archivos locales del proyecto. */
public abstract class ArchivoRepository<T extends Serializable> {
    private final Path archivo;
    private final Function<T, String> obtenerClave;

    protected ArchivoRepository(Path archivo, Function<T, String> obtenerClave) {
        this.archivo = archivo;
        this.obtenerClave = obtenerClave;
    }

    protected synchronized void guardarRegistro(T registro) {
        List<T> registros = leerRegistros();
        String clave = obtenerClave.apply(registro);
        registros.removeIf(actual -> obtenerClave.apply(actual).equals(clave));
        registros.add(registro);
        escribirRegistros(registros);
    }

    protected synchronized Optional<T> buscarRegistro(String clave) {
        return leerRegistros().stream()
                .filter(registro -> obtenerClave.apply(registro).equals(clave))
                .findFirst();
    }

    protected synchronized List<T> listarRegistros() {
        return leerRegistros();
    }

    protected synchronized List<T> filtrarRegistros(Predicate<T> condicion) {
        return leerRegistros().stream().filter(condicion).toList();
    }

    protected synchronized void actualizarRegistro(T registro) {
        List<T> registros = leerRegistros();
        String clave = obtenerClave.apply(registro);
        int posicion = -1;
        for (int i = 0; i < registros.size(); i++) {
            if (obtenerClave.apply(registros.get(i)).equals(clave)) {
                posicion = i;
                break;
            }
        }
        if (posicion < 0) {
            throw new IllegalArgumentException("No existe un registro con identificador " + clave);
        }
        registros.set(posicion, registro);
        escribirRegistros(registros);
    }

    protected synchronized void eliminarRegistro(String clave) {
        List<T> registros = leerRegistros();
        if (registros.removeIf(registro -> obtenerClave.apply(registro).equals(clave))) {
            escribirRegistros(registros);
        }
    }

    @SuppressWarnings("unchecked")
    private List<T> leerRegistros() {
        if (Files.notExists(archivo)) {
            return new ArrayList<>();
        }
        try (ObjectInputStream entrada = new ObjectInputStream(Files.newInputStream(archivo))) {
            return new ArrayList<>((List<T>) entrada.readObject());
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            throw new IllegalStateException("No se pudieron leer los datos de " + archivo, e);
        }
    }

    private void escribirRegistros(List<T> registros) {
        try {
            Path carpeta = archivo.getParent();
            if (carpeta != null) {
                Files.createDirectories(carpeta);
            }
            try (ObjectOutputStream salida = new ObjectOutputStream(Files.newOutputStream(archivo))) {
                salida.writeObject(registros);
            }
        } catch (IOException e) {
            throw new IllegalStateException("No se pudieron guardar los datos en " + archivo, e);
        }
    }
}
