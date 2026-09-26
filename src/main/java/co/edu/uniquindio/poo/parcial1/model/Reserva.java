package co.edu.uniquindio.poo.parcial1.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private String codigo;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private ModalidadAlquiler modalidad;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private LocalDate fechaRealizacion;
    private List<ServicioAdicional> serviciosAdicionales = new ArrayList<>();
    private BigDecimal descuentoAplicado;
    private BigDecimal valorTotal;

    public Reserva() {
    }

    public Reserva(String codigo, Cliente cliente, Vehiculo vehiculo, ModalidadAlquiler modalidad,
                   LocalDate fechaInicio, LocalDate fechaFin, LocalDate fechaRealizacion,
                   List<ServicioAdicional> serviciosAdicionales, BigDecimal descuentoAplicado,
                   BigDecimal valorTotal) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.modalidad = modalidad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaRealizacion = fechaRealizacion;
        setServiciosAdicionales(serviciosAdicionales);
        this.descuentoAplicado = descuentoAplicado;
        this.valorTotal = valorTotal;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Vehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }
    public ModalidadAlquiler getModalidad() { return modalidad; }
    public void setModalidad(ModalidadAlquiler modalidad) { this.modalidad = modalidad; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
    public LocalDate getFechaRealizacion() { return fechaRealizacion; }
    public void setFechaRealizacion(LocalDate fechaRealizacion) { this.fechaRealizacion = fechaRealizacion; }
    public List<ServicioAdicional> getServiciosAdicionales() { return serviciosAdicionales; }
    public void setServiciosAdicionales(List<ServicioAdicional> serviciosAdicionales) {
        this.serviciosAdicionales = serviciosAdicionales == null
                ? new ArrayList<>() : new ArrayList<>(serviciosAdicionales);
    }
    public BigDecimal getDescuentoAplicado() { return descuentoAplicado; }
    public void setDescuentoAplicado(BigDecimal descuentoAplicado) { this.descuentoAplicado = descuentoAplicado; }
    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }

    public void agregarServicioAdicional(ServicioAdicional servicio) {
        if (servicio != null && !serviciosAdicionales.contains(servicio)) {
            serviciosAdicionales.add(servicio);
        }
    }

    public void quitarServicioAdicional(ServicioAdicional servicio) {
        serviciosAdicionales.remove(servicio);
    }
}
