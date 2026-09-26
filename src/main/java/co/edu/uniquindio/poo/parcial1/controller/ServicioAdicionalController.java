package co.edu.uniquindio.poo.parcial1.controller;

import co.edu.uniquindio.poo.parcial1.service.ServicioAdicionalService;

import java.util.Objects;

public class ServicioAdicionalController {
    private final ServicioAdicionalService servicioAdicionalService;

    public ServicioAdicionalController(ServicioAdicionalService servicioAdicionalService) {
        this.servicioAdicionalService = Objects.requireNonNull(servicioAdicionalService);
    }
}
