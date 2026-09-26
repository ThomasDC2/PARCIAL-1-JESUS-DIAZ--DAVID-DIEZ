package co.edu.uniquindio.poo.parcial1.controller;

import co.edu.uniquindio.poo.parcial1.service.ModalidadService;
import co.edu.uniquindio.poo.parcial1.model.EstadoModalidad;
import co.edu.uniquindio.poo.parcial1.model.ModalidadAlquiler;
import co.edu.uniquindio.poo.parcial1.model.ModalidadPremium;
import co.edu.uniquindio.poo.parcial1.model.TipoModalidad;
import co.edu.uniquindio.poo.parcial1.factory.DatosModalidad;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ModalidadController {
    private final ModalidadService modalidadService;

    @FXML private TextField codigo;
    @FXML private TextField nombre;
    @FXML private TextField descripcion;
    @FXML private TextField duracionMinima;
    @FXML private TextField valorDiario;
    @FXML private TextField estado;
    @FXML private TextField tipo;
    @FXML private TextField beneficios;
    @FXML private TextField cobertura;
    @FXML private TextField conductores;
    @FXML private TextField caracteristicas;
    @FXML private TextArea resultado;

    public ModalidadController(ModalidadService modalidadService) {
        this.modalidadService = Objects.requireNonNull(modalidadService);
    }

    @FXML private void registrar() {
        try {
            modalidadService.crearYRegistrar(tipoSeleccionado(), leerDatosFormulario());
            mostrar("Modalidad registrada.");
        } catch (RuntimeException error) {
            mostrar("No se pudo registrar. Revisa tipo, estado, duración y valor diario.");
        }
    }

    @FXML private void buscar() {
        modalidadService.buscarPorCodigo(codigo.getText()).ifPresentOrElse(m -> {
            nombre.setText(m.getNombre()); descripcion.setText(m.getDescripcion());
            duracionMinima.setText(String.valueOf(m.getDuracionMinimaDias()));
            valorDiario.setText(m.getValorDiario().toPlainString()); estado.setText(m.getEstado().name());
            tipo.setText(m.getTipo().name()); beneficios.setText(String.join(",", m.getBeneficios()));
            if (m instanceof ModalidadPremium premium) {
                cobertura.setText(premium.getTipoCobertura());
                conductores.setText(String.valueOf(premium.getConductoresAdicionalesPermitidos()));
                caracteristicas.setText(String.join(",", premium.getCaracteristicasEspeciales()));
            }
            mostrar("Modalidad encontrada.");
        }, () -> mostrar("No se encontró la modalidad."));
    }

    @FXML private void actualizar() {
        try { modalidadService.actualizar(crearModalidadFormulario()); mostrar("Modalidad actualizada."); }
        catch (RuntimeException error) { mostrar("No se pudo actualizar. Verifica los datos ingresados."); }
    }

    @FXML private void eliminar() {
        modalidadService.eliminar(codigo.getText()); mostrar("Solicitud de eliminación procesada.");
    }

    @FXML private void listar() {
        mostrar(modalidadService.listarTodas().stream()
                .map(m -> m.getCodigo() + " | " + m.getNombre() + " | " + m.getTipo())
                .reduce((a, b) -> a + "\n" + b).orElse("No hay modalidades registradas."));
    }

    private TipoModalidad tipoSeleccionado() {
        return TipoModalidad.valueOf(tipo.getText().trim().toUpperCase());
    }

    private DatosModalidad leerDatosFormulario() {
        EstadoModalidad estadoSeleccionado = EstadoModalidad.valueOf(estado.getText().trim().toUpperCase());
        List<String> listaBeneficios = separar(beneficios.getText());
        BigDecimal tarifa = new BigDecimal(valorDiario.getText());
        int dias = Integer.parseInt(duracionMinima.getText());
        int cantidadConductores = conductores.getText().isBlank() ? 0 : Integer.parseInt(conductores.getText());
        return new DatosModalidad(codigo.getText(), nombre.getText(), descripcion.getText(), dias,
                tarifa, estadoSeleccionado, listaBeneficios, cobertura.getText(),
                cantidadConductores, separar(caracteristicas.getText()));
    }

    private ModalidadAlquiler crearModalidadFormulario() {
        return co.edu.uniquindio.poo.parcial1.factory.CreadorModalidades.para(tipoSeleccionado())
                .crearModalidad(leerDatosFormulario());
    }

    private List<String> separar(String texto) {
        if (texto == null || texto.isBlank()) return List.of();
        return Arrays.stream(texto.split(",")).map(String::trim).filter(s -> !s.isEmpty()).toList();
    }

    private void mostrar(String mensaje) { resultado.setText(mensaje); }
}
