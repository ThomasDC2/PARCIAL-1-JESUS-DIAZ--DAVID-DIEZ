package co.edu.uniquindio.poo.parcial1.repository;

import co.edu.uniquindio.poo.parcial1.model.Reserva;
import co.edu.uniquindio.poo.parcial1.config.ConfiguracionRentCar;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ReservaRepositoryArchivo extends ArchivoRepository<Reserva> implements ReservaRepository {
    public ReservaRepositoryArchivo() {
        super(ConfiguracionRentCar.getInstancia().getCarpetaDatos().resolve("reservas.dat"),
                Reserva::getCodigo);
    }

    @Override public void guardar(Reserva reserva) { guardarRegistro(reserva); }
    @Override public Optional<Reserva> buscarPorCodigo(String codigo) { return buscarRegistro(codigo); }
    @Override public List<Reserva> listarTodas() { return listarRegistros(); }
    @Override public List<Reserva> buscarPorFechaRealizacion(LocalDate inicio, LocalDate fin) {
        return filtrarRegistros(reserva -> reserva.getFechaRealizacion() != null
                && !reserva.getFechaRealizacion().isBefore(inicio)
                && !reserva.getFechaRealizacion().isAfter(fin));
    }
    @Override public void actualizar(Reserva reserva) { actualizarRegistro(reserva); }
    @Override public void eliminarPorCodigo(String codigo) { eliminarRegistro(codigo); }
}
