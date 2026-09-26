package co.edu.uniquindio.poo.parcial1.controller;

import co.edu.uniquindio.poo.parcial1.service.ClienteService;
import co.edu.uniquindio.poo.parcial1.model.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.Objects;

public class ClienteController {
    private final ClienteService clienteService;

    @FXML private TextField documento;
    @FXML private TextField nombre;
    @FXML private TextField telefono;
    @FXML private TextField correo;
    @FXML private TextField edad;
    @FXML private TextArea resultado;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = Objects.requireNonNull(clienteService);
    }

    @FXML
    private void registrar() {
        try {
            clienteService.registrar(new Cliente(nombre.getText(), documento.getText(), telefono.getText(),
                    correo.getText(), Integer.parseInt(edad.getText()), LocalDate.now()));
            mostrar("Cliente registrado.");
            limpiar();
        } catch (RuntimeException error) {
            mostrar("No se pudo registrar el cliente. Revisa los datos ingresados.");
        }
    }

    @FXML
    private void buscar() {
        clienteService.buscarPorDocumento(documento.getText()).ifPresentOrElse(cliente -> {
            nombre.setText(cliente.getNombreCompleto());
            telefono.setText(cliente.getTelefono());
            correo.setText(cliente.getCorreoElectronico());
            edad.setText(String.valueOf(cliente.getEdad()));
            mostrar("Cliente encontrado.");
        }, () -> mostrar("No se encontró un cliente con ese documento."));
    }

    @FXML
    private void actualizar() {
        try {
            LocalDate fechaRegistro = clienteService.buscarPorDocumento(documento.getText())
                    .map(Cliente::getFechaRegistro).orElse(LocalDate.now());
            Cliente cliente = new Cliente(nombre.getText(), documento.getText(), telefono.getText(),
                    correo.getText(), Integer.parseInt(edad.getText()), fechaRegistro);
            clienteService.actualizar(cliente);
            mostrar("Cliente actualizado.");
        } catch (RuntimeException error) {
            mostrar("No se pudo actualizar el cliente. Verifica el documento y los datos.");
        }
    }

    @FXML
    private void eliminar() {
        clienteService.eliminar(documento.getText());
        mostrar("Solicitud de eliminación procesada.");
    }

    @FXML
    private void listar() {
        mostrar(clienteService.listarTodos().stream()
                .map(cliente -> cliente.getDocumentoIdentidad() + " | " + cliente.getNombreCompleto()
                        + " | " + cliente.getTelefono())
                .reduce((a, b) -> a + "\n" + b).orElse("No hay clientes registrados."));
    }

    private void limpiar() {
        documento.clear();
        nombre.clear();
        telefono.clear();
        correo.clear();
        edad.clear();
    }

    private void mostrar(String mensaje) {
        resultado.setText(mensaje);
    }
}
