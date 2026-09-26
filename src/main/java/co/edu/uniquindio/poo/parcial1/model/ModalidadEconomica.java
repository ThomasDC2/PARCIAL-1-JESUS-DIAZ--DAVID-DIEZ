package co.edu.uniquindio.poo.parcial1.model;

import java.math.BigDecimal;
import java.util.List;

public class ModalidadEconomica extends ModalidadAlquiler {
    public ModalidadEconomica(String codigo, String nombre, String descripcion, int duracionMinimaDias,
                              BigDecimal valorDiario, EstadoModalidad estado, List<String> beneficios) {
        super(codigo, nombre, descripcion, duracionMinimaDias, valorDiario, estado,
                TipoModalidad.ECONOMICA, beneficios);
    }

    @Override public ModalidadEconomica clonar() {
        return new ModalidadEconomica(getCodigo(), getNombre(), getDescripcion(), getDuracionMinimaDias(),
                getValorDiario(), getEstado(), getBeneficios());
    }
}
