package co.edu.uniquindio.poo.parcial1.controller;

import co.edu.uniquindio.poo.parcial1.model.Empresa;
import co.edu.uniquindio.poo.parcial1.service.EmpresaService;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Objects;

public class EmpresaController {
    private final EmpresaService empresaService;

    @FXML private TextField nit;
    @FXML private TextField nombre;
    @FXML private TextField direccion;
    @FXML private TextField telefono;
    @FXML private TextField correo;
    @FXML private TextField paginaWeb;
    @FXML private TextArea resultado;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = Objects.requireNonNull(empresaService);
    }

    @FXML private void guardar() {
        try {
            empresaService.guardar(new Empresa(nombre.getText(), nit.getText(), direccion.getText(),
                    telefono.getText(), correo.getText(), paginaWeb.getText()));
            mostrar("Datos de la empresa guardados.");
        } catch (RuntimeException error) {
            mostrar("No se pudieron guardar los datos de la empresa.");
        }
    }

    @FXML private void buscar() {
        empresaService.buscarPorNit(nit.getText()).ifPresentOrElse(empresa -> {
            nombre.setText(empresa.getNombreComercial()); direccion.setText(empresa.getDireccion());
            telefono.setText(empresa.getTelefono()); correo.setText(empresa.getCorreoElectronico());
            paginaWeb.setText(empresa.getPaginaWeb()); mostrar("Empresa encontrada.");
        }, () -> mostrar("No se encontró una empresa con ese NIT."));
    }

    @FXML private void actualizar() {
        try {
            empresaService.actualizar(new Empresa(nombre.getText(), nit.getText(), direccion.getText(),
                    telefono.getText(), correo.getText(), paginaWeb.getText()));
            mostrar("Datos de la empresa actualizados.");
        } catch (RuntimeException error) {
            mostrar("No se pudieron actualizar los datos de la empresa.");
        }
    }

    @FXML private void listar() {
        mostrar(empresaService.listarTodas().stream()
                .map(e -> e.getNit() + " | " + e.getNombreComercial() + " | " + e.getTelefono())
                .reduce((a, b) -> a + "\n" + b).orElse("No hay empresa registrada."));
    }

    private void mostrar(String mensaje) { resultado.setText(mensaje); }
}
