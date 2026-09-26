package co.edu.uniquindio.poo.parcial1.controller;

import co.edu.uniquindio.poo.parcial1.service.VehiculoService;
import co.edu.uniquindio.poo.parcial1.model.Vehiculo;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class VehiculoController {
    private final VehiculoService vehiculoService;

    @FXML private TextField placa;
    @FXML private TextField marca;
    @FXML private TextField modelo;
    @FXML private TextField anio;
    @FXML private TextField tipo;
    @FXML private TextField tarifaDiaria;
    @FXML private TextArea resultado;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = Objects.requireNonNull(vehiculoService);
    }

    @FXML private void registrar() {
        try {
            vehiculoService.registrar(leerFormulario());
            mostrar("Vehículo registrado.");
        } catch (RuntimeException error) {
            mostrar("No se pudo registrar. Revisa los datos y el formato de la tarifa.");
        }
    }

    @FXML private void buscar() {
        vehiculoService.buscarPorPlaca(placa.getText()).ifPresentOrElse(vehiculo -> {
            marca.setText(vehiculo.getMarca()); modelo.setText(vehiculo.getModelo());
            anio.setText(String.valueOf(vehiculo.getAnio())); tipo.setText(vehiculo.getTipo());
            tarifaDiaria.setText(vehiculo.getTarifaDiaria().toPlainString());
            mostrar("Vehículo encontrado.");
        }, () -> mostrar("No se encontró el vehículo."));
    }

    @FXML private void actualizar() {
        try { vehiculoService.actualizar(leerFormulario()); mostrar("Vehículo actualizado."); }
        catch (RuntimeException error) { mostrar("No se pudo actualizar. Verifica la placa y los datos."); }
    }

    @FXML private void eliminar() {
        vehiculoService.eliminar(placa.getText()); mostrar("Solicitud de eliminación procesada.");
    }

    @FXML private void listar() {
        List<Vehiculo> vehiculos = vehiculoService.listarTodos();
        mostrar(vehiculos.stream().map(v -> v.getPlaca() + " | " + v.getMarca() + " " + v.getModelo())
                .reduce((a, b) -> a + "\n" + b).orElse("No hay vehículos registrados."));
    }

    private Vehiculo leerFormulario() {
        return new Vehiculo(placa.getText(), marca.getText(), modelo.getText(),
                Integer.parseInt(anio.getText()), tipo.getText(), new BigDecimal(tarifaDiaria.getText()));
    }

    private void mostrar(String mensaje) { resultado.setText(mensaje); }
}
