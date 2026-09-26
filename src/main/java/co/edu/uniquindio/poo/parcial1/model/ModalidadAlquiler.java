package co.edu.uniquindio.poo.parcial1.model;

import java.math.BigDecimal;
import java.util.List;

public class ModalidadAlquiler {
    private String codigo;
    private String nombre;
    private String descripcion;
    private int duracionMinimaDias;
    private BigDecimal valorDiario;
    private EstadoModalidad estado;
    private TipoModalidad tipo;
    private List<String> beneficios;
}
