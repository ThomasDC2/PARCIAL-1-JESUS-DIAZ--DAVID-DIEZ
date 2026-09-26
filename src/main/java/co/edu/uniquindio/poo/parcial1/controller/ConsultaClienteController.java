package co.edu.uniquindio.poo.parcial1.controller;

import co.edu.uniquindio.poo.parcial1.service.ConsultaClienteService;

import java.util.Objects;

public class ConsultaClienteController {
    private final ConsultaClienteService consultaClienteService;

    public ConsultaClienteController(ConsultaClienteService consultaClienteService) {
        this.consultaClienteService = Objects.requireNonNull(consultaClienteService);
    }
}
