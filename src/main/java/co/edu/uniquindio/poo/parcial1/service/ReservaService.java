package co.edu.uniquindio.poo.parcial1.service;

import co.edu.uniquindio.poo.parcial1.repository.ReservaRepository;
import co.edu.uniquindio.poo.parcial1.model.Reserva;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final CalculadoraAlquiler calculadoraAlquiler;

    public ReservaService(ReservaRepository reservaRepository, CalculadoraAlquiler calculadoraAlquiler) {
        this.reservaRepository = Objects.requireNonNull(reservaRepository);
        this.calculadoraAlquiler = Objects.requireNonNull(calculadoraAlquiler);
    }

    public void registrar(Reserva reserva) {
        Reserva reservaValidada = Objects.requireNonNull(reserva);
        reservaValidada.setValorTotal(calculadoraAlquiler.calcularValorTotal(reservaValidada));
        reservaRepository.guardar(reservaValidada);
    }

    public Optional<Reserva> buscarPorCodigo(String codigo) {
        return reservaRepository.buscarPorCodigo(codigo);
    }

    public List<Reserva> listarTodas() {
        return reservaRepository.listarTodas();
    }

    public List<Reserva> buscarPorFechaRealizacion(LocalDate fechaInicio, LocalDate fechaFin) {
        return reservaRepository.buscarPorFechaRealizacion(fechaInicio, fechaFin);
    }

    public void actualizar(Reserva reserva) {
        Reserva reservaValidada = Objects.requireNonNull(reserva);
        reservaValidada.setValorTotal(calculadoraAlquiler.calcularValorTotal(reservaValidada));
        reservaRepository.actualizar(reservaValidada);
    }

    public void eliminar(String codigo) {
        reservaRepository.eliminarPorCodigo(codigo);
    }
}
