package co.edu.uniquindio.poo.parcial1.service;

import co.edu.uniquindio.poo.parcial1.model.ModalidadAlquiler;
import co.edu.uniquindio.poo.parcial1.model.EstadoModalidad;
import co.edu.uniquindio.poo.parcial1.model.Reserva;
import co.edu.uniquindio.poo.parcial1.model.ServicioAdicional;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class CalculadoraAlquiler {
    public BigDecimal calcularValorTotal(Reserva reserva) {
        Objects.requireNonNull(reserva, "La reserva es obligatoria");

        ModalidadAlquiler modalidad = Objects.requireNonNull(
                reserva.getModalidad(), "La reserva debe tener una modalidad");
        Objects.requireNonNull(reserva.getFechaInicio(), "La fecha de inicio es obligatoria");
        Objects.requireNonNull(reserva.getFechaFin(), "La fecha de fin es obligatoria");
        Objects.requireNonNull(modalidad.getValorDiario(), "La modalidad debe tener un valor diario");

        if (modalidad.getEstado() != EstadoModalidad.DISPONIBLE) {
            throw new IllegalArgumentException("La modalidad no está disponible");
        }

        if (reserva.getFechaFin().isBefore(reserva.getFechaInicio())) {
            throw new IllegalArgumentException("La fecha de fin no puede ser anterior a la fecha de inicio");
        }

        long dias = Math.max(1, ChronoUnit.DAYS.between(reserva.getFechaInicio(), reserva.getFechaFin()));
        if (dias < modalidad.getDuracionMinimaDias()) {
            throw new IllegalArgumentException("La duración es menor a la mínima de la modalidad");
        }

        BigDecimal total = modalidad.getValorDiario().multiply(BigDecimal.valueOf(dias));
        for (ServicioAdicional servicio : reserva.getServiciosAdicionales()) {
            if (servicio == null || !servicio.isDisponible()) {
                throw new IllegalArgumentException("La reserva contiene un servicio no disponible");
            }
            total = total.add(Objects.requireNonNull(servicio.getPrecio(),
                    "El servicio adicional debe tener un precio"));
        }

        if (reserva.getDescuentoAplicado() != null) {
            if (reserva.getDescuentoAplicado().compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException("El descuento no puede ser negativo");
            }
            total = total.subtract(reserva.getDescuentoAplicado());
        }

        return total.max(BigDecimal.ZERO);
    }
}
