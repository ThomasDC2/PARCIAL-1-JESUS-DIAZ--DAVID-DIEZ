package co.edu.uniquindio.poo.parcial1.controller;

import co.edu.uniquindio.poo.parcial1.service.VehiculoService;

import java.util.Objects;

public class VehiculoController {
    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = Objects.requireNonNull(vehiculoService);
    }
}
