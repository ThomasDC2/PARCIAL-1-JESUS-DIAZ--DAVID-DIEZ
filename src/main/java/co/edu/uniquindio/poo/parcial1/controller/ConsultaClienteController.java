package co.edu.uniquindio.poo.parcial1.controller;

import co.edu.uniquindio.poo.parcial1.service.ConsultaClienteService;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Objects;

public class ConsultaClienteController {
    private final ConsultaClienteService consultaClienteService;

    @FXML private TextField telefono;
    @FXML private TextArea resultado;

    public ConsultaClienteController(ConsultaClienteService consultaClienteService) {
        this.consultaClienteService = Objects.requireNonNull(consultaClienteService);
    }

    @FXML private void buscarCliente() {
        consultaClienteService.buscarPorTelefono(telefono.getText()).ifPresentOrElse(cliente ->
                resultado.setText("Cliente: " + cliente.getNombreCompleto()
                        + "\nDocumento: " + cliente.getDocumentoIdentidad()
                        + "\nTeléfono: " + cliente.getTelefono()),
                () -> resultado.setText("No se encontró un cliente con ese teléfono."));
    }

    @FXML private void verificarNumeroPerfecto() {
        boolean perfecto = consultaClienteService.telefonoEsNumeroPerfecto(telefono.getText());
        resultado.setText(perfecto ? "El teléfono corresponde a un número perfecto."
                : "El teléfono no corresponde a un número perfecto.");
    }
}
