package co.edu.uniquindio.poo.parcial1.service;

import co.edu.uniquindio.poo.parcial1.repository.ReservaRepository;
import co.edu.uniquindio.poo.parcial1.model.Reserva;
import co.edu.uniquindio.poo.parcial1.model.ServicioAdicional;
import co.edu.uniquindio.poo.parcial1.builder.ReservaBuilder;
import co.edu.uniquindio.poo.parcial1.repository.ClienteRepository;
import co.edu.uniquindio.poo.parcial1.repository.ModalidadRepository;
import co.edu.uniquindio.poo.parcial1.repository.ServicioAdicionalRepository;
import co.edu.uniquindio.poo.parcial1.repository.VehiculoRepository;
import co.edu.uniquindio.poo.parcial1.model.Cliente;
import co.edu.uniquindio.poo.parcial1.model.ModalidadAlquiler;
import co.edu.uniquindio.poo.parcial1.model.Vehiculo;
import java.math.BigDecimal;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final CalculadoraAlquiler calculadoraAlquiler;
    private final ClienteRepository clienteRepository;
    private final VehiculoRepository vehiculoRepository;
    private final ModalidadRepository modalidadRepository;
    private final ServicioAdicionalRepository servicioAdicionalRepository;

    public ReservaService(ReservaRepository reservaRepository, CalculadoraAlquiler calculadoraAlquiler,
                         ClienteRepository clienteRepository, VehiculoRepository vehiculoRepository,
                         ModalidadRepository modalidadRepository,
                         ServicioAdicionalRepository servicioAdicionalRepository) {
        this.reservaRepository = Objects.requireNonNull(reservaRepository);
        this.calculadoraAlquiler = Objects.requireNonNull(calculadoraAlquiler);
        this.clienteRepository = Objects.requireNonNull(clienteRepository);
        this.vehiculoRepository = Objects.requireNonNull(vehiculoRepository);
        this.modalidadRepository = Objects.requireNonNull(modalidadRepository);
        this.servicioAdicionalRepository = Objects.requireNonNull(servicioAdicionalRepository);
    }

    public void crearYRegistrar(String codigo, String documentoCliente, String placaVehiculo,
                                String codigoModalidad, LocalDate fechaInicio, LocalDate fechaFin,
                                List<String> codigosServicios, BigDecimal descuento) {
        Cliente cliente = clienteRepository.buscarPorDocumentoIdentidad(documentoCliente)
                .orElseThrow(() -> new IllegalArgumentException("No existe el cliente indicado"));
        Vehiculo vehiculo = vehiculoRepository.buscarPorPlaca(placaVehiculo)
                .orElseThrow(() -> new IllegalArgumentException("No existe el vehículo indicado"));
        ModalidadAlquiler modalidad = modalidadRepository.buscarPorCodigo(codigoModalidad)
                .orElseThrow(() -> new IllegalArgumentException("No existe la modalidad indicada"));
        List<ServicioAdicional> servicios = codigosServicios.stream()
                .map(codigoServicio -> servicioAdicionalRepository.buscarPorCodigo(codigoServicio)
                        .orElseThrow(() -> new IllegalArgumentException(
                                "No existe el servicio adicional " + codigoServicio)))
                .toList();

        Reserva reserva = new ReservaBuilder().codigo(codigo).cliente(cliente).vehiculo(vehiculo)
                .modalidad(modalidad).fechaInicio(fechaInicio).fechaFin(fechaFin)
                .fechaRealizacion(LocalDate.now()).serviciosAdicionales(servicios)
                .descuentoAplicado(descuento).build();
        registrar(reserva);
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
