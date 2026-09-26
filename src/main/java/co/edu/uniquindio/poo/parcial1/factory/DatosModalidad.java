package co.edu.uniquindio.poo.parcial1.factory;

import co.edu.uniquindio.poo.parcial1.model.EstadoModalidad;

import java.math.BigDecimal;
import java.util.List;

public record DatosModalidad(String codigo, String nombre, String descripcion, int duracionMinimaDias,
                             BigDecimal valorDiario, EstadoModalidad estado, List<String> beneficios,
                             String tipoCobertura, int conductoresAdicionales,
                             List<String> caracteristicasEspeciales) {
}
