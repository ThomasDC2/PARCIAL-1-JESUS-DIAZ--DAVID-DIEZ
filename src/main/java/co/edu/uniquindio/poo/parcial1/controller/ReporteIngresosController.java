package co.edu.uniquindio.poo.parcial1.controller;

import co.edu.uniquindio.poo.parcial1.service.ReporteIngresosService;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class ReporteIngresosController {
    private final ReporteIngresosService reporteIngresosService;

    @FXML private DatePicker fechaInicio;
    @FXML private DatePicker fechaFin;
    @FXML private TextArea resultado;

    public ReporteIngresosController(ReporteIngresosService reporteIngresosService) {
        this.reporteIngresosService = Objects.requireNonNull(reporteIngresosService);
    }

    @FXML private void consultarIngresos() {
        try {
            LocalDate inicio = fechaInicio.getValue();
            LocalDate fin = fechaFin.getValue();
            BigDecimal ingresos = reporteIngresosService.calcularIngresos(inicio, fin);
            resultado.setText("Ingresos entre " + inicio + " y " + fin + ": " + ingresos);
        } catch (RuntimeException error) {
            resultado.setText("Selecciona un rango de fechas válido.");
        }
    }
}
