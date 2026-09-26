package co.edu.uniquindio.poo.parcial1.repository;

import co.edu.uniquindio.poo.parcial1.model.Reserva;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservaRepository {
    void guardar(Reserva reserva);

    Optional<Reserva> buscarPorCodigo(String codigo);

    List<Reserva> listarTodas();

    List<Reserva> buscarPorFechaRealizacion(LocalDate fechaInicio, LocalDate fechaFin);

    void actualizar(Reserva reserva);

    void eliminarPorCodigo(String codigo);
}
