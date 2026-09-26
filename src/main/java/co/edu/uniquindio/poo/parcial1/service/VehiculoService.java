package co.edu.uniquindio.poo.parcial1.service;

import co.edu.uniquindio.poo.parcial1.repository.VehiculoRepository;
import co.edu.uniquindio.poo.parcial1.model.Vehiculo;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class VehiculoService {
    private final VehiculoRepository vehiculoRepository;

    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = Objects.requireNonNull(vehiculoRepository);
    }

    public void registrar(Vehiculo vehiculo) {
        vehiculoRepository.guardar(Objects.requireNonNull(vehiculo));
    }

    public Optional<Vehiculo> buscarPorPlaca(String placa) {
        return vehiculoRepository.buscarPorPlaca(placa);
    }

    public List<Vehiculo> listarTodos() {
        return vehiculoRepository.listarTodos();
    }

    public void actualizar(Vehiculo vehiculo) {
        vehiculoRepository.actualizar(Objects.requireNonNull(vehiculo));
    }

    public void eliminar(String placa) {
        vehiculoRepository.eliminarPorPlaca(placa);
    }
}
