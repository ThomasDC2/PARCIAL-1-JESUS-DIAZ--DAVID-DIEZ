package co.edu.uniquindio.poo.parcial1.builder;

import co.edu.uniquindio.poo.parcial1.model.Cliente;
import co.edu.uniquindio.poo.parcial1.model.ModalidadAlquiler;
import co.edu.uniquindio.poo.parcial1.model.Reserva;
import co.edu.uniquindio.poo.parcial1.model.ServicioAdicional;
import co.edu.uniquindio.poo.parcial1.model.Vehiculo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReservaBuilder {
    private String codigo;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private ModalidadAlquiler modalidad;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private LocalDate fechaRealizacion = LocalDate.now();
    private List<ServicioAdicional> serviciosAdicionales = new ArrayList<>();
    private BigDecimal descuentoAplicado = BigDecimal.ZERO;

    public ReservaBuilder codigo(String codigo) { this.codigo = codigo; return this; }
    public ReservaBuilder cliente(Cliente cliente) { this.cliente = cliente; return this; }
    public ReservaBuilder vehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; return this; }
    public ReservaBuilder modalidad(ModalidadAlquiler modalidad) { this.modalidad = modalidad; return this; }
    public ReservaBuilder fechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; return this; }
    public ReservaBuilder fechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; return this; }
    public ReservaBuilder fechaRealizacion(LocalDate fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
        return this;
    }
    public ReservaBuilder serviciosAdicionales(List<ServicioAdicional> servicios) {
        this.serviciosAdicionales = servicios == null ? new ArrayList<>() : new ArrayList<>(servicios);
        return this;
    }
    public ReservaBuilder descuentoAplicado(BigDecimal descuento) {
        this.descuentoAplicado = descuento == null ? BigDecimal.ZERO : descuento;
        return this;
    }

    public Reserva build() {
        Objects.requireNonNull(codigo, "El código de la reserva es obligatorio");
        Objects.requireNonNull(cliente, "El cliente es obligatorio");
        Objects.requireNonNull(vehiculo, "El vehículo es obligatorio");
        Objects.requireNonNull(modalidad, "La modalidad es obligatoria");
        Objects.requireNonNull(fechaInicio, "La fecha de inicio es obligatoria");
        Objects.requireNonNull(fechaFin, "La fecha de fin es obligatoria");
        return new Reserva(codigo, cliente, vehiculo, modalidad, fechaInicio, fechaFin,
                fechaRealizacion, serviciosAdicionales, descuentoAplicado, null);
    }
}
