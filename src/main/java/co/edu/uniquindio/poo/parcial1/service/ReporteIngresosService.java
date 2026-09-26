package co.edu.uniquindio.poo.parcial1.service;

import co.edu.uniquindio.poo.parcial1.repository.ReservaRepository;
import co.edu.uniquindio.poo.parcial1.model.Reserva;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class ReporteIngresosService {
    private final ReservaRepository reservaRepository;

    public ReporteIngresosService(ReservaRepository reservaRepository) {
        this.reservaRepository = Objects.requireNonNull(reservaRepository);
    }

    public BigDecimal calcularIngresos(LocalDate fechaInicio, LocalDate fechaFin) {
        Objects.requireNonNull(fechaInicio, "La fecha inicial es obligatoria");
        Objects.requireNonNull(fechaFin, "La fecha final es obligatoria");
        if (fechaFin.isBefore(fechaInicio)) {
            throw new IllegalArgumentException("La fecha final no puede ser anterior a la fecha inicial");
        }

        List<Reserva> reservas = reservaRepository.buscarPorFechaRealizacion(fechaInicio, fechaFin);
        return reservas.stream()
                .map(Reserva::getValorTotal)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
