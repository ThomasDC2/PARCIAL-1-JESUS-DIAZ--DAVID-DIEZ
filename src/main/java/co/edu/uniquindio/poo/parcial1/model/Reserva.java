package co.edu.uniquindio.poo.parcial1.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Reserva {
    private String codigo;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private ModalidadAlquiler modalidad;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private LocalDate fechaRealizacion;
    private List<ServicioAdicional> serviciosAdicionales;
    private BigDecimal descuentoAplicado;
    private BigDecimal valorTotal;
}
