package co.edu.uniquindio.poo.parcial1.controller;

import co.edu.uniquindio.poo.parcial1.service.ReporteIngresosService;

import java.util.Objects;

public class ReporteIngresosController {
    private final ReporteIngresosService reporteIngresosService;

    public ReporteIngresosController(ReporteIngresosService reporteIngresosService) {
        this.reporteIngresosService = Objects.requireNonNull(reporteIngresosService);
    }
}
