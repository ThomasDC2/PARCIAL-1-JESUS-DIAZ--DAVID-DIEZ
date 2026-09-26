package co.edu.uniquindio.poo.parcial1.controller;

import co.edu.uniquindio.poo.parcial1.service.ClienteService;

import java.util.Objects;

public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = Objects.requireNonNull(clienteService);
    }
}
