package co.edu.uniquindio.poo.parcial1.service;

import co.edu.uniquindio.poo.parcial1.repository.ServicioAdicionalRepository;
import co.edu.uniquindio.poo.parcial1.model.ServicioAdicional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ServicioAdicionalService {
    private final ServicioAdicionalRepository servicioAdicionalRepository;

    public ServicioAdicionalService(ServicioAdicionalRepository servicioAdicionalRepository) {
        this.servicioAdicionalRepository = Objects.requireNonNull(servicioAdicionalRepository);
    }

    public void registrar(ServicioAdicional servicio) {
        servicioAdicionalRepository.guardar(Objects.requireNonNull(servicio));
    }

    public Optional<ServicioAdicional> buscarPorCodigo(String codigo) {
        return servicioAdicionalRepository.buscarPorCodigo(codigo);
    }

    public List<ServicioAdicional> listarTodos() {
        return servicioAdicionalRepository.listarTodos();
    }

    public void actualizar(ServicioAdicional servicio) {
        servicioAdicionalRepository.actualizar(Objects.requireNonNull(servicio));
    }

    public void eliminar(String codigo) {
        servicioAdicionalRepository.eliminarPorCodigo(codigo);
    }
}
