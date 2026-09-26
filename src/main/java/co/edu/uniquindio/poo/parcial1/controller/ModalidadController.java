package co.edu.uniquindio.poo.parcial1.controller;

import co.edu.uniquindio.poo.parcial1.service.ModalidadService;

import java.util.Objects;

public class ModalidadController {
    private final ModalidadService modalidadService;

    public ModalidadController(ModalidadService modalidadService) {
        this.modalidadService = Objects.requireNonNull(modalidadService);
    }
}
