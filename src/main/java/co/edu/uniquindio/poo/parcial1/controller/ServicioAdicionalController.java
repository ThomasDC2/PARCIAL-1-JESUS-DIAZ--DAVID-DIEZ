package co.edu.uniquindio.poo.parcial1.controller;

import co.edu.uniquindio.poo.parcial1.service.ServicioAdicionalService;
import co.edu.uniquindio.poo.parcial1.model.ServicioAdicional;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.util.Objects;

public class ServicioAdicionalController {
    private final ServicioAdicionalService servicioAdicionalService;

    @FXML private TextField codigo;
    @FXML private TextField nombre;
    @FXML private TextField descripcion;
    @FXML private TextField precio;
    @FXML private TextField disponible;
    @FXML private TextArea resultado;

    public ServicioAdicionalController(ServicioAdicionalService servicioAdicionalService) {
        this.servicioAdicionalService = Objects.requireNonNull(servicioAdicionalService);
    }

    @FXML private void registrar() {
        try { servicioAdicionalService.registrar(leerFormulario()); mostrar("Servicio registrado."); }
        catch (RuntimeException error) { mostrar("No se pudo registrar. Revisa el precio y la disponibilidad."); }
    }

    @FXML private void buscar() {
        servicioAdicionalService.buscarPorCodigo(codigo.getText()).ifPresentOrElse(servicio -> {
            nombre.setText(servicio.getNombre()); descripcion.setText(servicio.getDescripcion());
            precio.setText(servicio.getPrecio().toPlainString()); disponible.setText(String.valueOf(servicio.isDisponible()));
            mostrar("Servicio encontrado.");
        }, () -> mostrar("No se encontró el servicio adicional."));
    }

    @FXML private void actualizar() {
        try { servicioAdicionalService.actualizar(leerFormulario()); mostrar("Servicio actualizado."); }
        catch (RuntimeException error) { mostrar("No se pudo actualizar. Revisa los datos ingresados."); }
    }

    @FXML private void eliminar() {
        servicioAdicionalService.eliminar(codigo.getText()); mostrar("Solicitud de eliminación procesada.");
    }

    @FXML private void listar() {
        mostrar(servicioAdicionalService.listarTodos().stream()
                .map(s -> s.getCodigo() + " | " + s.getNombre() + " | " + s.getPrecio())
                .reduce((a, b) -> a + "\n" + b).orElse("No hay servicios registrados."));
    }

    private ServicioAdicional leerFormulario() {
        return new ServicioAdicional(codigo.getText(), nombre.getText(), descripcion.getText(),
                new BigDecimal(precio.getText()), Boolean.parseBoolean(disponible.getText()));
    }

    private void mostrar(String mensaje) { resultado.setText(mensaje); }
}
