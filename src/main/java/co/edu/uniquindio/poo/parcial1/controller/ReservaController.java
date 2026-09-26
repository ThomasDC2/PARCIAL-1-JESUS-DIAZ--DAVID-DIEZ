package co.edu.uniquindio.poo.parcial1.controller;

import co.edu.uniquindio.poo.parcial1.service.ReservaService;
import co.edu.uniquindio.poo.parcial1.model.Reserva;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ReservaController {
    private final ReservaService reservaService;

    @FXML private TextField codigo;
    @FXML private TextField documentoCliente;
    @FXML private TextField placaVehiculo;
    @FXML private TextField codigoModalidad;
    @FXML private TextField codigosServicios;
    @FXML private TextField descuento;
    @FXML private DatePicker fechaInicio;
    @FXML private DatePicker fechaFin;
    @FXML private TextArea resultado;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = Objects.requireNonNull(reservaService);
    }

    @FXML private void registrar() {
        try {
            reservaService.crearYRegistrar(codigo.getText(), documentoCliente.getText(), placaVehiculo.getText(),
                    codigoModalidad.getText(), fechaInicio.getValue(), fechaFin.getValue(),
                    separarCodigos(), descuento.getText().isBlank() ? BigDecimal.ZERO : new BigDecimal(descuento.getText()));
            mostrar("Reserva registrada y valor calculado.");
        } catch (RuntimeException error) {
            mostrar("No se pudo registrar. Verifica códigos, fechas y valores.");
        }
    }

    @FXML private void buscar() {
        reservaService.buscarPorCodigo(codigo.getText()).ifPresentOrElse(reserva -> {
            documentoCliente.setText(reserva.getCliente().getDocumentoIdentidad());
            placaVehiculo.setText(reserva.getVehiculo().getPlaca());
            codigoModalidad.setText(reserva.getModalidad().getCodigo());
            fechaInicio.setValue(reserva.getFechaInicio()); fechaFin.setValue(reserva.getFechaFin());
            codigosServicios.setText(reserva.getServiciosAdicionales().stream()
                    .map(s -> s.getCodigo()).reduce((a, b) -> a + "," + b).orElse(""));
            descuento.setText(reserva.getDescuentoAplicado() == null ? "0" : reserva.getDescuentoAplicado().toPlainString());
            mostrar("Valor total: " + reserva.getValorTotal());
        }, () -> mostrar("No se encontró la reserva."));
    }

    @FXML private void eliminar() {
        reservaService.eliminar(codigo.getText()); mostrar("Solicitud de cancelación procesada.");
    }

    @FXML private void listar() {
        mostrar(reservaService.listarTodas().stream()
                .map(r -> r.getCodigo() + " | " + r.getCliente().getNombreCompleto()
                        + " | " + r.getValorTotal())
                .reduce((a, b) -> a + "\n" + b).orElse("No hay reservas registradas."));
    }

    private List<String> separarCodigos() {
        if (codigosServicios.getText().isBlank()) return List.of();
        return Arrays.stream(codigosServicios.getText().split(","))
                .map(String::trim).filter(c -> !c.isEmpty()).toList();
    }

    private void mostrar(String mensaje) { resultado.setText(mensaje); }
}
