package co.edu.uniquindio.poo.parcial1.config;

import java.nio.file.Path;

/** Configuración compartida de la aplicación. */
public final class ConfiguracionRentCar {
    private static final ConfiguracionRentCar INSTANCIA = new ConfiguracionRentCar();
    private final Path carpetaDatos = Path.of("data");

    private ConfiguracionRentCar() {
    }

    public static ConfiguracionRentCar getInstancia() {
        return INSTANCIA;
    }

    public Path getCarpetaDatos() {
        return carpetaDatos;
    }
}
