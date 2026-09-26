package co.edu.uniquindio.poo.parcial1.model;

import java.math.BigDecimal;
import java.util.List;

public class ModalidadEjecutiva extends ModalidadAlquiler {
    public ModalidadEjecutiva(String codigo, String nombre, String descripcion, int duracionMinimaDias,
                              BigDecimal valorDiario, EstadoModalidad estado, List<String> beneficios) {
        super(codigo, nombre, descripcion, duracionMinimaDias, valorDiario, estado,
                TipoModalidad.EJECUTIVA, beneficios);
    }

    @Override public ModalidadEjecutiva clonar() {
        return new ModalidadEjecutiva(getCodigo(), getNombre(), getDescripcion(), getDuracionMinimaDias(),
                getValorDiario(), getEstado(), getBeneficios());
    }
}
